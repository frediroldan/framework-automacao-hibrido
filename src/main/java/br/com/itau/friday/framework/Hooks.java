package br.com.itau.friday.framework;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import javax.mail.MessagingException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.log4j.Logger;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import br.com.itau.friday.utils.BaseMobilePage;
import br.com.itau.friday.utils.BasePage;
import br.com.itau.friday.utils.Utils;
import cucumber.api.PickleStepTestStep;
import cucumber.api.Result;
import cucumber.api.Scenario;
import cucumber.api.TestCase;
import cucumber.api.event.EventHandler;
import cucumber.api.event.EventPublisher;
import cucumber.api.event.TestRunFinished;
import cucumber.api.event.TestRunStarted;
import cucumber.api.formatter.Formatter;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import io.cucumber.datatable.DataTable;
import io.restassured.response.Response;

/**
 * Classe Hooks, responsavel por agrupar metodos simples com anotacoes especiais
 * dentro de suas classes de contexto podendo utilizar tags para controle
 * 
 * **************************Web**************************************************
 * | @web | @web-same-session | @closeBrowser | @refreshBrowser **********
 * | @chrome | @chrome-same-session | @closeBrowser | @refreshBrowser *****
 * | @firefox | @firefox-same-session | @closeBrowser | @refreshBrowser *****
 * | @edge | @edge-same-session | @closeBrowser | @refreshBrowser *****
 * **************************Desktop**********************************************
 * | @winium | @closeProcess
 * **************************Mobile***********************************************
 * | @mobile | @closeMobile | @resetMobileApp
 * *******************************************************************************
 * 
 * @author Douglas Gelli
 * @version 3.0
 */

@SuppressWarnings("deprecation")
public class Hooks implements Formatter {

	public static WebDriver driver;
	BasePage basepage = new BasePage(driver);

	public static AppiumDriver<WebElement> appiumDriver;
	public static AndroidDriver<WebElement> androidDriver;
	public static IOSDriver<WebElement> iOSDriver;
	BaseMobilePage basemobilepage = new BaseMobilePage(appiumDriver);

	private static Properties properties = PropertiesHelper.getProperties();
	private static String os = properties.getProperty("os");
	private static String projectName = properties.getProperty("projectName");
	private static String environment = properties.getProperty("environment");
	private static String author = properties.getProperty("author");
	private static String sprint = properties.getProperty("sprint");
	private static String cycle = properties.getProperty("cycle");
	private static String templateExcel = properties.getProperty("templateExcel");
	private static boolean wordPrint = Boolean.parseBoolean(properties.getProperty("wordPrint"));
	private static boolean excelReport = Boolean.parseBoolean(properties.getProperty("excelReport"));
	private static boolean htmlReport = Boolean.parseBoolean(properties.getProperty("htmlReport"));
	private static boolean sendMail = Boolean.parseBoolean(properties.getProperty("sendMail"));
	private static String browser = properties.getProperty("browser");

	private Excel excel = new Excel();
	private Logger logger = Logger.getLogger(getClass().getName());
	private Utils utils = new Utils();

	private static String print64;
	private String printErrorPath, tipo, navegator = null;
	private File htmlReportFile;
	private List<String> wordTableString;
	private long ms; //
	private String timeTest; //
	private Throwable errorCause;
	private long milisegundos, segundos, minutos, horas;
	private static AppiumDriverLocalService service;
	private static AppiumServiceBuilder builder;
	private static DesiredCapabilities cap;

	private static ExtentHtmlReporter htmlReporter;
	private static ExtentReports extent;
	private ExtentTest test, node; //
	private static ExtentTest nodeStatic; //
	private static boolean oneTime = false;
	private int currentStepDefIndex = 0;

	/**************** Method to use After ALL execution *****************/
	private EventHandler<TestRunStarted> setup = event -> {
	};
	// @After All Tests
	private EventHandler<TestRunFinished> teardown = event -> {
		if (sendMail == true) {
			sendMail();
		}
		if (driver != null)
			try {
				driver.quit();
			} catch (Exception e) {
			}
		if (appiumDriver != null)
			try {
				appiumDriver.quit();
			} catch (Exception e) {
			}
	};

	@Override
	public void setEventPublisher(EventPublisher publisher) {
		publisher.registerHandlerFor(TestRunStarted.class, setup);
		publisher.registerHandlerFor(TestRunFinished.class, teardown);
	}

	/******************* End Method to use After ALL ********************/

	/************* Method to use Before ALL and Before test *************/
	@Before(order = 1)
	public void beforeAll(Scenario s) {
		basepage.setScenario(s);
		logger.info("");
		logger.info("************* " + s.getName().toString().toUpperCase() + " ************");
		ms = System.currentTimeMillis();

		String tagName = s.getSourceTagNames().toString().toUpperCase();
		if (tagName.contains("WEB")) {
			tipo = "Web";
			navegator = browser.toUpperCase();
		} else if (tagName.contains("CHROME")) {
			tipo = "Web";
			navegator = "CHROME";
		} else if (tagName.contains("FIREFOX")) {
			tipo = "Web";
			navegator = "FIREFOX";
		} else if (tagName.contains("EDGE")) {
			tipo = "Web";
			navegator = "EDGE";
		} else if (tagName.contains("GRID")) {
			tipo = "Web-Grid";
			navegator = browser.toUpperCase();
		} else if (tagName.contains("WINIUM")) {
			tipo = "DeskTop";
		} else if (tagName.contains("MOBILE")) {
			tipo = "Mobile";
		} else {
			tipo = "API";
		}

		if (htmlReport == true) {
			String path = System.getProperty("user.dir") + File.separator + "output" + File.separator + "HtmlReport"
					+ File.separator + utils.dataHoje("yyyy-MM-dd");
			File dir = new File(path);
			dir.mkdir();
			File report = new File(path + File.separator + "Report.html");
			// For use just one time
			if (oneTime == false) {
				htmlReporter = new ExtentHtmlReporter(report);
				extent = new ExtentReports();
				extent.attachReporter(htmlReporter);
				// extent.setSystemInfo("OS", System.getProperty("os.name"));
				// extent.setSystemInfo("API", "RestAssured");
				// extent.setSystemInfo("Browser", browser.toUpperCase());
				// extent.setSystemInfo("Mobile", os.toUpperCase());
				// extent.setSystemInfo("DesckTop", "Winium");
				htmlReporter.config().setReportName("DGelli Report");
				htmlReporter.config().setTheme(Theme.DARK);
				htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
			}
			oneTime = true;
			test = extent.createTest(s.getName().toString());
			test.assignCategory("All");
			test.assignCategory(tipo);
			if (navegator != null)
				test.assignCategory(navegator);
			test.assignAuthor(author);
			node = test.createNode(s.getName().toString());
			nodeStatic = node;
		}
	}

	/*********** To add Response node in the HTML report ****************/
	public void node(Response response) {
		if (htmlReport == true) {
			if (node == null) {
				nodeStatic.createNode("Response").info(MarkupHelper.createCodeBlock(response.body().asString()));
			} else
				node.createNode("Response").info(MarkupHelper.createCodeBlock(response.body().asString()));
		}
	}

	/*********** To add node in the HTML report ****************/
	public void node(String nodeName, String infoTexto) {
		if (htmlReport == true) {
			node.createNode(nodeName).info(infoTexto);
		}
	}

	/*********** To add node in the HTML report with image ****************/
	public void node(String nodeName, String infoTexto, String printPath) {
		if (htmlReport == true) {
			try {
				if (this.node == null) {
					nodeStatic.createNode(nodeName).info(infoTexto,
							MediaEntityBuilder.createScreenCaptureFromBase64String(printPath).build());	
				}else {
					node.createNode(nodeName).info(infoTexto,
							MediaEntityBuilder.createScreenCaptureFromBase64String(printPath).build());					
				}
			} catch (IOException e) {
				logger.error(e);
			}
			extent.flush();
		}
	}

	public void print(String print) {
		print64 = print;
	}
	
	
	/*********** Method to use After all Steps of Cucumber ****************/
	@AfterStep(order = 0)
	public void stepResult(Scenario s) throws NoSuchFieldException, SecurityException, IllegalArgumentException,
			IllegalAccessException, IOException {
		if (htmlReport == true) {
			// Take screen shot when step fail
			if (s.isFailed() && (s.getSourceTagNames().toString().toUpperCase().contains("WEB")
					|| s.getSourceTagNames().toString().toUpperCase().contains("WINIUM")
					|| s.getSourceTagNames().toString().toUpperCase().contains("CHROME")
					|| s.getSourceTagNames().toString().toUpperCase().contains("FIREFOX")
					|| s.getSourceTagNames().toString().toUpperCase().contains("EDGE"))) {
				if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
					printErrorPath = print64;
				} else {
					printErrorPath = basepage.printReportHtml();
				}
			} else if (s.isFailed() && s.getSourceTagNames().toString().toUpperCase().contains("MOBILE")) {
				printErrorPath = basemobilepage.printReportHtml();
			} else {
				printErrorPath = "";
			}
			// Get details about step
			Field f = s.getClass().getDeclaredField("testCase");
			f.setAccessible(true);
			TestCase r = (TestCase) f.get(s);
			List<PickleStepTestStep> stepDefs = r.getTestSteps().stream().filter(x -> x instanceof PickleStepTestStep)
					.map(x -> (PickleStepTestStep) x).collect(Collectors.toList());
			PickleStepTestStep currentStepDef = stepDefs.get(currentStepDefIndex);

			logger.info("Step: ==> " + currentStepDef.getStepText() + " <==");
			logger.info("Step: ==> " + s.getStatus().toString().toUpperCase() + " <==");

			// Create node in a HTML report on FAILED
			if (s.getStatus().toString().contains("FAILED")) {
				getErrorCause(s);
				if (tipo.contains("API")) {
					node.createNode(currentStepDef.getStepText().toString()).fail(errorCause);
				} else {
					node.createNode(currentStepDef.getStepText().toString()).fail(errorCause,
							MediaEntityBuilder.createScreenCaptureFromBase64String(printErrorPath).build());
				}
				// To include the next steps after fail
				if (stepDefs.size() != currentStepDefIndex) {
					for (int i = currentStepDefIndex + 1; i < stepDefs.size(); i++) {
						node.createNode(stepDefs.get(i).getStepText().toString()).skip("Step not runned");
					}
				}

				// Create node in a HTML report on PASSED
			} else if (s.getStatus().toString().contains("PASSED")) {
				// Check if is the last step to take last screen shot
				if (stepDefs.size() == currentStepDefIndex + 1) {
					// Verify API, mobile or web
					if (s.getSourceTagNames().toString().toUpperCase().contains("MOBILE")) {
						printErrorPath = basemobilepage.printReportHtml();
						node.createNode(currentStepDef.getStepText().toString()).pass("Sucess",
								MediaEntityBuilder.createScreenCaptureFromBase64String(printErrorPath).build());
					} else if (s.getSourceTagNames().toString().toUpperCase().contains("WEB")
							|| s.getSourceTagNames().toString().toUpperCase().contains("WINIUM")
							|| s.getSourceTagNames().toString().toUpperCase().contains("CHROME")
							|| s.getSourceTagNames().toString().toUpperCase().contains("FIREFOX")
							|| s.getSourceTagNames().toString().toUpperCase().contains("EDGE")) {
						if (s.getSourceTagNames().toString().toUpperCase().contains("GRID")) {
							node.createNode(currentStepDef.getStepText().toString()).pass("Sucess");
						} else {
							printErrorPath = basepage.printReportHtml();
							node.createNode(currentStepDef.getStepText().toString()).pass("Sucess",
									MediaEntityBuilder.createScreenCaptureFromBase64String(printErrorPath).build());
						}
					} else {
						node.createNode(currentStepDef.getStepText().toString()).pass("Sucess");
					}
					// If is not the last step, just create a node
				} else {
					node.createNode(currentStepDef.getStepText().toString()).pass("Sucess");
				}
				// Create node if the step is differ of pass or fail
			} else {
				node.createNode(currentStepDef.getStepText().toString()).skip(errorCause);
			}
			currentStepDefIndex++;
			extent.flush();
		}
	}

	/************************* Web ***************************/
	// To use browser defined in properties file
	@Before("@web")
	public void openBrowser(Scenario s) throws Exception {
		driver = DriverFactory.getDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	// To use browser defined in properties file
	@Before("@web-same-session")
	public void openBrowserSameSession(Scenario s) throws Exception {
		if (driver == null) {
			driver = DriverFactory.getDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.navigate().refresh();
	}

	// To use Chrome as specific browser
	@Before("@chrome")
	public void openChromeBrowser(Scenario s) throws Exception {
		driver = DriverFactory.startDriver(DriverFactory.Browsers.CHROME);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Before("@chrome-same-session")
	public void openChromeBrowserSameSession(Scenario s) throws Exception {
		if (driver == null) {
			driver = DriverFactory.startDriver(DriverFactory.Browsers.CHROME);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.navigate().refresh();
	}

	// To use Fire Fox as specific browser
	@Before("@firefox")
	public void openFireFoxBrowser(Scenario s) throws Exception {
		driver = DriverFactory.startDriver(DriverFactory.Browsers.FIREFOX);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Before("@firefox-same-session")
	public void openFireFoxBrowserSameSession(Scenario s) throws Exception {
		if (driver == null) {
			driver = DriverFactory.startDriver(DriverFactory.Browsers.FIREFOX);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.navigate().refresh();
	}

	// To use EDGE as specific browser
	@Before("@edge")
	public void openEDGEBrowser(Scenario s) throws Exception {
		driver = DriverFactory.startDriver(DriverFactory.Browsers.EDGE);
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Before("@edge-same-session")
	public void openEDGEBrowserSameSession(Scenario s) throws Exception {
		if (driver == null) {
			driver = DriverFactory.startDriver(DriverFactory.Browsers.EDGE);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}
		driver.navigate().refresh();
	}

	// After any browsers
	@After("@closeBrowser")
	public void closeBrowser(Scenario s) throws Exception {
		basepage.setScenario(s);
		basepage.printscreen("EndPrint");
		try {
			if (driver != null) {
				driver.quit();
				driver = null;
			}
			// basepage.killProcess("chromedriver.exe");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@After("@refreshBrowser")
	public void refreshBrowser(Scenario s) throws Exception {
		basepage.setScenario(s);
		basepage.printscreen("EndPrint");
		try {
			driver.navigate().refresh();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	/******************* DeskTop Winium ********************/
	public DesktopOptions deskOptions = new DesktopOptions();

	@Before("@winium")
	public void openWiniumDeskop(Scenario s) throws Exception {
		DriverFactory.winiumDriver();
		deskOptions.setApplicationPath(properties.getProperty("fileFolder"));
		driver = new WiniumDriver(new URL("http://localhost:9999"), deskOptions);
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
	}

	@After("@closeProcess")
	public void closeProcess(Scenario s) throws Exception {
		basepage.setScenario(s);
		basepage.printscreen("EndPrint");
		try {
			utils.killProcess(properties.getProperty("processName"));
			utils.killProcess("Winium.Desktop.Driver.exe");
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		driver = null;
		logger.info("Fim do processo: " + properties.getProperty("processName"));
		logger.info("Fim do processo: Winium.Desktop.Driver.exe");
	}

	/******************* Mobile ********************/
	@SuppressWarnings("unchecked")
	@Before("@mobile")
	public void openMobile(Scenario s) throws Exception {
		basemobilepage.setScenario(s);
		int port = 4723;
		launchAndroidEmulator();
		if (!checkIfServerIsRunnning(port)) {
			startServer();
		} else {
			logger.info("Appium Server already running on Port - " + port);
		}

		if (appiumDriver == null) {
			if (os.contains("android")) {
				androidDriver = DriverFactory.androidDriver(s);
				androidDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				appiumDriver = androidDriver;
			} else if (os.contains("iOS")) {
				iOSDriver = DriverFactory.iOSDriver(s);
				iOSDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				appiumDriver = iOSDriver;
			} else {
				logger.info("");
				logger.error("Invalido Android ou IOS. Sem driver para iniciar");
				appiumDriver = null;
			}
		}
	}

	@After("@closeMobile")
	public void closeMobile(Scenario s) throws Exception {
		basemobilepage.setScenario(s);
		basemobilepage.printscreen("EndPrint");
		appiumDriver.closeApp();
		stopServer();
		if (s.getSourceTagNames().contains("KillEmulator")) {
			if (utils.verificaProcessoWin("qemu-system-x86_64.exe")) {
				utils.killProcess("qemu-system-x86_64.exe");
			}
		}
	}

	@After("@resetMobileApp")
	public void resetMobileApp(Scenario s) throws Exception {
		basemobilepage.setScenario(s);
		basemobilepage.printscreen("EndPrint");
		appiumDriver.resetApp();
	}

	/******************* To Generate Word ********************/
	@Dado("^que utilizo o word para evidencias com as informacoes de execucao$")
	public void queUtilizoWordParaEvidenciasComSeguintesInformacoes_id_nomeCT_objetivo_resultadoEsperado_resultadoObtido_Executor_SP_Cdt(
			DataTable wordTable) throws Throwable {
		this.wordTableString = wordTable.asList(String.class);
	}

	@After(order = 9)
	public void wordGeneration(Scenario s) throws Exception {
		if (wordPrint == true) {
			logger.info("Gerar Evidencias em Word...");
			String nomeCenario = s.getName();
			String fileName = s.getName().toString() + "-" + s.getStatus().toString().toUpperCase() + "-"
					+ utils.dataHoje("yyyyMMdd-HHmmss");

			String path = System.getProperty("user.dir") + File.separator + "output" + File.separator + "Evidence"
					+ File.separator + utils.dataHoje("yyyy-MM-dd") + File.separator + s.getName();

			File folder = new File(path);
			path = folder.getAbsolutePath().toString();

			if (folder.exists()) {
				WordEvidence evidence = new WordEvidence();
				WordprocessingMLPackage template = evidence.getTemplate(properties.getProperty("templateWord"));
				evidence.replacePlaceholder(template, environment, "<ambiente>");
				String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
				evidence.replacePlaceholder(template, timeStamp, "<data>");
				evidence.replacePlaceholder(template, nomeCenario, "<id_nomeCT>");
				evidence.replacePlaceholder(template, this.wordTableString.get(0), "<objetivo>");
				evidence.replacePlaceholder(template, this.wordTableString.get(1), "<resultado_esperado>");
				evidence.replacePlaceholder(template, s.getStatus().toString().toUpperCase(), "<resultado_obtido>");
				evidence.replacePlaceholder(template, author, "<executor>");
				evidence.replacePlaceholder(template, sprint, "<sp>");
				evidence.replacePlaceholder(template, cycle, "<cdt>");
				evidence.createWordEvidence(template, path, fileName);
			} else {
				logger.info("No images to generate the word");
			}
		}
	}

	/******************* To Get Time of execution ********************/
	@After(order = 10)
	public void TimeTeste(Scenario s) {
		ms = System.currentTimeMillis() - ms;
		milisegundos = ms % 1000;
		segundos = (ms / 1000) % 60;
		minutos = (ms / 60000) % 60;
		horas = ms / 3600000;
		timeTest = String.format("%02d:%02d:%02d,%03d", horas, minutos, segundos, milisegundos);
		logger.info(timeTest);
	}

	/******************* To Generate Excel Report ********************/
	@After(order = 8)
	public void excelReport(Scenario s) throws IOException {
		if (excelReport == true) {
			getErrorCause(s);

			String path = System.getProperty("user.dir") + File.separator + "output" + File.separator + "ExcelReport"
					+ File.separator + utils.dataHoje("yyyy-MM-dd");
			File dir = new File(path);
			dir.mkdir();
			File template = new File(templateExcel);
			File newName = new File(path + File.separator + "report.xlsm");

			if (!newName.exists()) {
				FileUtils.copyFileToDirectory(template, dir);
				String fileName = path + File.separator + template.getName();
				File copia = new File(fileName);
				copia.renameTo(newName);
			}

			excel.abrePlanilha(newName, "CT");
			int linha = excel.getNumeroDeLinhas();
			excel.setTextoCelula(linha, 0, projectName);
			excel.setTextoCelula(linha, 1, s.getName());
			excel.setTextoCelula(linha, 2, s.getStatus().toString().toUpperCase());
			excel.setTextoCelula(linha, 3, utils.dataHoje("dd/MM/yyyy  HH:mm:ss"));
			excel.setTextoCelula(linha, 4, tipo);
			excel.setTextoCelula(linha, 5, timeTest);
			if (errorCause != null)
				excel.setTextoCelula(linha, 6, errorCause.toString());
			excel.salvaPlanilha(newName);
		}
	}

	/******************* To log result about test ********************/
	@After(order = 7)
	public void resultado(Scenario s) {
		logger.info("Status: ===========> " + s.getStatus().toString().toUpperCase() + " <===========");
	}

	/******************* To Send Mail ********************/
	private void sendMail() {

		htmlReportFile = new File("output" + File.separator + "HtmlReport" + File.separator
				+ utils.dataHoje("yyyy-MM-dd") + File.separator + "Report.html");

		logger.info("Sending mail..........");
		try {
			SendGmail.generateAndSendEmail("Automation finshed", "Report: " + htmlReportFile.getAbsolutePath(),
					"douglasgelli@gmail.com", null, htmlReportFile);
		} catch (UnsupportedEncodingException | MessagingException e) {
			logger.error(e);
		}

	}

	/******************* Start and Stop Appium ********************/
	public void startServer() {
		// Set Capabilities
		cap = new DesiredCapabilities();
		cap.setCapability("noReset", "false");

		// Build the Appium service
		builder = new AppiumServiceBuilder();
		builder.withIPAddress("127.0.0.1");
		builder.usingPort(4723);
		builder.withCapabilities(cap);
		builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
		builder.withArgument(GeneralServerFlag.LOG_LEVEL, "info");

		// Start the server with the builder
		service = AppiumDriverLocalService.buildService(builder);
		service.start();
	}

	public void stopServer() {
		try {
			service.stop();
		} catch (Exception e) {
			logger.error("Stop service appium: " + e);
		}
	}

	public boolean checkIfServerIsRunnning(int port) {

		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// If control comes here, then it means that the port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;
	}

	public void launchAndroidEmulator() {
		File emulator = new File("StartEmulator.bat");
		String pathEmulator = emulator.getAbsoluteFile().toString();
		if (!utils.verificaProcessoWin("qemu-system-x86_64.exe")) {
			try {
				Runtime.getRuntime().exec(pathEmulator);
				Thread.sleep(20000);
			} catch (Exception e) {
			}
		}
	}

	/******************* Get Error Cause ********************/
	private void getErrorCause(Scenario s) {
		if (s.isFailed()) {
			Field field = FieldUtils.getField(s.getClass(), "stepResults", true);
			field.setAccessible(true);
			try {
				@SuppressWarnings("unchecked")
				ArrayList<Result> results = (ArrayList<Result>) field.get(s);
				for (Result result : results) {
					if (result.getError() != null) {
						logger.error(s.getId(), result.getError());
						errorCause = result.getError();
					}
				}
			} catch (Exception e) {
				logger.error("Error while logging error", e);
			}
		}
	}

}
