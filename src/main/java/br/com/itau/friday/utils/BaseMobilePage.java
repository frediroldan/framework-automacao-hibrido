package br.com.itau.friday.utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import br.com.itau.friday.framework.PropertiesHelper;
import cucumber.api.Scenario;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.connection.ConnectionState;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;


public class BaseMobilePage {

	static protected AppiumDriver<WebElement> driver;
	protected Wait<AppiumDriver<WebElement>> wait;
	protected Logger logger = Logger.getLogger(getClass().getName());
	protected static Scenario scenario;
	private static Properties properties = PropertiesHelper.getProperties();
	private static boolean lastPrint = Boolean.parseBoolean(properties.getProperty("lastPrint"));
	private static boolean fullPrint = Boolean.parseBoolean(properties.getProperty("fullPrint"));
	private static boolean wordPrint = Boolean.parseBoolean(properties.getProperty("wordPrint"));
	Utils utils = new Utils();
	
	public BaseMobilePage(AppiumDriver<WebElement> appiumDriver) {
		BaseMobilePage.driver = (AppiumDriver<WebElement>) appiumDriver;
		PageFactory.initElements(new AppiumFieldDecorator(BaseMobilePage.driver), this);
		if (driver != null) {
			wait = new FluentWait<AppiumDriver<WebElement>>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofMillis(1000))
					.ignoring(NoSuchElementException.class, org.openqa.selenium.WebDriverException.class);
		}
	}

	public void setScenario(Scenario s) {
		BaseMobilePage.scenario = s;
	}

	/****************** Espera *********************/

	public void espera(int milisegundos) {
		try {
			Thread.sleep(milisegundos);
			logger.info("Espera de " + milisegundos + " milisegundos");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void espera(MobileElement element) {
		boolean visible = false;
		int i = 0;
		while (visible == false && i <= 25) {
			try {
				visible = element.isDisplayed();
			} catch (Exception e) {
				espera(1000);
			}
			i++;
		}
	}

	public void esperaExplicitaElementVisible(MobileElement element, long segundos) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, segundos);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			System.out.println("Elemento nao localizado");
		}
	}

	public void esperaImplicita(long milliseconds) {
		driver.manage().timeouts().implicitlyWait(milliseconds, TimeUnit.MILLISECONDS);
	}

	/************** Back and hide keyboard *********************/
	/**
	 * method to hide keyboard
	 */
	@SuppressWarnings("rawtypes")
	public void hideKeyboard() {
		logger.info("Hide keyboard");
		((AppiumDriver) driver).hideKeyboard();
	}

	/**
	 * method to go back by Android Native back click
	 */
	@SuppressWarnings("rawtypes")
	public void back() {
		logger.info("Go back on Android Native back click");
		print("Back");
		((AndroidDriver) driver).pressKey(new KeyEvent().withKey(AndroidKey.BACK));
	}

	/********************* Click *********************/

	public void click(MobileElement element) {
		int i = 0;
		boolean click_ok = false;
		while (click_ok == false && i < 2) {
			try {
				logger.info("Click on element: " + element.toString());
				wait.until(ExpectedConditions.visibilityOf(element));
				print("Click");
				element.click();
				click_ok = true;
			} catch (Exception e) {
				logger.error("Error Click: " + e);
				espera(1000);
				click_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			element.click();
		}
	}

	public void doubleClick(MobileElement element) {
		int i = 0;
		boolean click_ok = false;
		while (click_ok == false && i < 2) {
			try {
				logger.info("Click Duplo on element: " + element.toString());
				wait.until(ExpectedConditions.visibilityOf(element));
				print("Double Click");
				element.click();
				element.click();
				click_ok = true;
			} catch (Exception e) {
				logger.error("Error Click Duplo: " + e);
				espera(1000);
				click_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			element.click();
			element.click();
		}
	}

	/********************* Toque (Tap) *********************/

	@SuppressWarnings("rawtypes")
	public void tap(int x, int y) {
		int i = 0;
		boolean write_ok = false;
		while (write_ok == false && i < 2) {
			try {
				logger.info("Tap on x: " + x + " on y: " + y);
				print("Tap");
				new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(x, y)).perform();
				write_ok = true;
			} catch (Exception e) {
				logger.error("Error Tap: " + e);
				espera(1000);
				write_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			new TouchAction((PerformsTouchActions) driver).tap(PointOption.point(x, y)).perform();
		}
	}

	@SuppressWarnings("rawtypes")
	public void tap(MobileElement element) {
		Point pointElement = element.getCenter();
		int i = 0;
		boolean write_ok = false;
		while (write_ok == false && i < 2) {
			try {
				logger.info("Tap on element: " + element + " x e y: " + pointElement.x + " " + pointElement.y);
				wait.until(ExpectedConditions.visibilityOf(element));
				print("Tap");
				new TouchAction((AppiumDriver) driver).tap(PointOption.point(pointElement.x, pointElement.y)).perform();
				write_ok = true;
			} catch (Exception e) {
				logger.error("Error Tap: " + e);
				espera(1000);
				write_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			new TouchAction((AppiumDriver) driver).tap(PointOption.point(pointElement.x, pointElement.y)).perform();
		}
	}

	@SuppressWarnings("rawtypes")
	public void doubleTap(MobileElement element) {
		Point pointElement = element.getCenter();
		int i = 0;
		boolean write_ok = false;
		while (write_ok == false && i < 2) {
			try {
				logger.info("Double Tap on element: " + element + " x e y: " + pointElement.x + " " + pointElement.y);
				wait.until(ExpectedConditions.visibilityOf(element));
				print("Double Tap");
				new TouchAction((AppiumDriver) driver).tap(PointOption.point(pointElement.x, pointElement.y))
						.tap(PointOption.point(pointElement.x, pointElement.y)).perform();
				write_ok = true;
			} catch (Exception e) {
				logger.error("Error Double Tap: " + e);
				espera(1000);
				write_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			new TouchAction((AppiumDriver) driver).tap(PointOption.point(pointElement.x, pointElement.y))
					.tap(PointOption.point(pointElement.x, pointElement.y)).perform();
		}

	}

	public void tapJS(double xPosition, double yPosition) {
		logger.info("Tap with JS on x: " + xPosition + " y: " + yPosition);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> tapObject = new HashMap<String, Double>();
		tapObject.put("startX", xPosition);
		tapObject.put("startY", yPosition);
		js.executeScript("mobile: tap", tapObject);
	}

	/********************* Escrever *********************/

	public void escrever(MobileElement element, String texto) {
		int i = 0;
		boolean write_ok = false;
		while (write_ok == false && i < 2) {
			try {
				logger.info("Escrever on element: " + element.toString() + " Texto: " + texto);
				wait.until(ExpectedConditions.visibilityOf(element));
				element.clear();
				espera(50);
				print("SendKeys");
				element.sendKeys(texto);
				write_ok = true;
			} catch (Exception e) {
				logger.error("Error Escrever: " + e);
				espera(1000);
				write_ok = false;
			}
			i++;
		}
		if (i >= 2) {
			element.sendKeys(texto);
		}

	}

	public String obterTexto(MobileElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Obter texto: " + element.getText());
		} catch (Exception e) {
			logger.error("Error Obter texto: " + e);
		}
		return element.getText();
	}

	public boolean existeElementoPorTexto(String texto) {
		espera(1000);
		List<WebElement> elementos = driver.findElements(By.xpath("//*[@text='" + texto + "']"));
		return elementos.size() > 0;
	}

	public String[] obterLista(By by) {
		// esperaExplicita(by, 10);

		List<WebElement> elements = driver.findElements(by);
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			// System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}

	public String[] obterLista(List<WebElement> elements) {
		// esperaExplicita(by, 10);

		// List<WebElement> elements = (List<WebElement>) element;
		String[] retorno = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			System.out.println("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}

	/********************* CheckBox *********************/

	public boolean isCheckboxMarcado(MobileElement element) {
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("CheckBox selecionada: " + element.isSelected());
		} catch (Exception e) {
			logger.error(e);
		}
		return element.isSelected();
	}

	public boolean isCheckMarcado(MobileElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
		return element.getAttribute("checked").equals("true");
	}

	/********************* Alert *********************/
	/**
	 * method to verify if alert is present
	 *
	 * @return returns true if alert is present else false
	 */
	public boolean isAlertPresent() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			driver.switchTo().alert();
			logger.info("Alerta presente");
			return true;
		} catch (NoAlertPresentException e) {
			throw e;
		}
	}

	/**
	 * method to verify text alert
	 *
	 * @return returns String of text alert
	 */
	public String obterTextoAlert() {
		String textoAlerta;
		try {
			WebDriverWait wait = new WebDriverWait(driver, 15);
			wait.until(ExpectedConditions.alertIsPresent());
			textoAlerta = driver.switchTo().alert().getText();
			logger.info("Obter Texto Alerta: " + textoAlerta);
			return textoAlerta;
		} catch (NoAlertPresentException e) {
			logger.error("Obter Texto Alerta: " + e);
			throw e;
		}
	}

	/**
	 * method to Accept Alert if alert is present
	 */
	public void acceptAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		print("AcceptAlert");
		driver.switchTo().alert().accept();
	}

	/**
	 * method to Dismiss Alert if alert is present
	 */
	public void dismissAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
		print("DismissAlert");
		driver.switchTo().alert().dismiss();
	}

	/********************* Long Press *********************/
	public void longPress(MobileElement element) {
		logger.info("Long Press: " + element.toString());
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		print("LongPress");
		new Actions(driver).clickAndHold(element).perform();

		// TouchActions action = new TouchActions(driver);
		// action.longPress(element);
		// action.perform();

	}

	/********************* Drag and Drop *********************/

	@SuppressWarnings("rawtypes")
	public void arrastarElemento(MobileElement origem, MobileElement destiny) {
		logger.info("Drag and Drop From: " + origem + " To: " + destiny);
		wait.until(ExpectedConditions.visibilityOf(origem));
		wait.until(ExpectedConditions.visibilityOf(destiny));
		Point pointElement = destiny.getCenter();
		print("DragAndDrop");
		new TouchAction((PerformsTouchActions) driver)
				.longPress(LongPressOptions.longPressOptions().withElement(ElementOption.element(origem)))
				.moveTo(PointOption.point(pointElement.x, pointElement.y)).release().perform();
	}

	/********************* Scroll *********************/

	public void scrollDown() {
		logger.info("Scroll Down");
		scroll(0.9, 0.1);
	}

	public void scrollUp() {
		logger.info("Scroll Up");
		scroll(0.1, 0.9);
	}

	@SuppressWarnings("rawtypes")
	public void scroll(double inicio, double fim) {
		Dimension size = driver.manage().window().getSize();
		int x = size.width / 2;
		int yInicial = (int) (size.height * inicio);
		int yFinal = (int) (size.height * fim);
		logger.info("Scroll x: " + x + " y start: " + yInicial + " y end: " + yFinal);
		print("Scroll");
		new TouchAction(driver).press(PointOption.point(x, yInicial)).waitAction().moveTo(PointOption.point(x, yFinal))
				.release().perform();

	}

	/********************* Swipe *********************/
	public void swipeLeft() {
		logger.info("Swipe Left");
		swipe(0.1, 0.9);
	}

	public void swipeRight() {
		logger.info("Swipe Right");
		swipe(0.9, 0.1);
	}

	@SuppressWarnings("rawtypes")
	public void swipe(double inicio, double fim) {
		Dimension size = driver.manage().window().getSize();
		int y = size.height / 2;
		int xInicial = (int) (size.width * inicio);
		int xFinal = (int) (size.width * fim);
		print("Swipe");
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(xInicial, y)).waitAction()
				.moveTo(PointOption.point(xFinal, y)).release().perform();
	}

	/**
	 * method to swipe on the screen on provided coordinates com Js
	 *
	 * @param startX
	 *            - start X coordinate to be tapped
	 * @param endX
	 *            - end X coordinate to be tapped
	 * @param startY
	 *            - start y coordinate to be tapped
	 * @param endY
	 *            - end Y coordinate to be tapped
	 * @param duration
	 *            duration to be tapped
	 */
	public void swipeJs(double startX, double startY, double endX, double endY, double duration) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		// swipeObject.put("touchCount", 1.0);
		swipeObject.put("startX", startX);
		swipeObject.put("startY", startY);
		swipeObject.put("endX", endX);
		swipeObject.put("endY", endY);
		swipeObject.put("duration", duration);
		js.executeScript("mobile: swipe", swipeObject);
	}

	/********************* Swipe Element *********************/

	public void swipeRightElement(MobileElement element) {
		logger.info("Swipe Right on element: " + element);
		swipeElement(element, 0.1, 0.9);
	}

	public void swipeLeftElement(MobileElement element) {
		logger.info("Swipe Left on element: " + element);
		swipeElement(element, 0.9, 0.1);
	}

	@SuppressWarnings("rawtypes")
	public void swipeElement(MobileElement element, double inicio, double fim) {
		wait.until(ExpectedConditions.visibilityOf(element));
		int y = element.getLocation().y + (element.getSize().height / 2);
		int xInicial = (int) (element.getSize().width * inicio);
		int xFinal = (int) (element.getSize().width * fim);
		print("Swipe");
		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(xInicial, y)).waitAction()
				.moveTo(PointOption.point(xFinal, y)).release().perform();
	}

	/********************* Menu Notifications *********************/

	@SuppressWarnings("rawtypes")
	public void openNotifications() {
		logger.info("Open Notification");
		((AndroidDriver) driver).openNotifications();
	}

	@SuppressWarnings("rawtypes")
	public void launchApp() {
		logger.info("Lauch App");
		((AppiumDriver) driver).launchApp();
	}

	/********************* Network settings *********************/

	/**
	 * method to get network settings
	 */
	@SuppressWarnings("rawtypes")
	public void getNetworkConnection() {
		System.out.println(((AndroidDriver) driver).getConnection());
	}

	/**
	 * method to set network settings
	 *
	 * @param airplaneMode
	 *            pass true to activate airplane mode else false
	 * @param wifi
	 *            pass true to activate wifi mode else false
	 * @param data
	 *            pass true to activate data mode else false
	 */
	@SuppressWarnings("rawtypes")
	public void setNetworkConnection(boolean airplaneMode, boolean wifi, boolean data) {
		long mode = 1L;
		if (wifi) {
			mode = 2L;
		} else if (data) {
			mode = 4L;
		}
		ConnectionState connectionState = new ConnectionState(mode);
		((AndroidDriver) driver).setConnection(connectionState);
		System.out.println("Your current connection settings are :" + ((AndroidDriver) driver).getConnection());
	}

	/**
	 * method to get all the context handles at particular screen
	 */
	@SuppressWarnings("rawtypes")
	public void getContext() {
		((AppiumDriver) driver).getContextHandles();
	}

	/**
	 * method to set the context to required view.
	 *
	 * @param context
	 *            view to be set
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void setContext(String context) {
		Set<String> contextNames = ((AppiumDriver) driver).getContextHandles();
		if (contextNames.contains(context)) {
			((AppiumDriver) driver).context(context);
			logger.info("Context changed successfully");
		} else {
			logger.info(context + "not found on this page");
		}
		logger.info("Current context" + ((AppiumDriver) driver).getContext());
	}

	/************************* Print Screen **************************/
	private void print(String texto) {
		if (fullPrint == true) {
			printscr(texto);
		}
	}

	public void printscreen(String texto) {
		if (lastPrint == true || wordPrint == true) {
			printscr(texto);
		}
	}

	private void printscr(String texto) {
		String path = System.getProperty("user.dir") + File.separator + "output" + File.separator + "Evidence"
				+ File.separator + utils.dataHoje("yyyy-MM-dd")
				+ File.separator + scenario.getName();
		File dir = new File(path);
		try {
			dir.mkdir();
			Thread.currentThread();
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String evidenceStep = path + File.separator
				+ java.time.LocalTime.now().toString().replace(":", "").replace(".", "") + "-"
				+ scenario.getStatus().toString().toUpperCase() + "-" + texto + ".png";
		File screenFile = new File(evidenceStep);
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, screenFile);
		} catch (IOException e) {
		}
		logger.info("Print Screen: " + evidenceStep);
	}
	
	public String printReportHtml() {
		String scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
		logger.info("Print Screen to HTML Report");
		return scrFile;
	}

}