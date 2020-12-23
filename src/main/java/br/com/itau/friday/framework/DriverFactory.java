package br.com.itau.friday.framework;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.Scenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;


public class DriverFactory {

	static WebDriver driver;
	static AndroidDriver<MobileElement> androidDriver;
	static IOSDriver<MobileElement> iOSDriver;
	private static Properties properties = PropertiesHelper.getProperties();
	private static String browser = properties.getProperty("browser");
	private static String appPackage = properties.getProperty("appPackage");
	private static String appActivity = properties.getProperty("appActivity");
	private static String deviceName = properties.getProperty("deviceName");
	private static String AndroidAppPath = properties.getProperty("AndroidAppPath");
	private static String iOSAppPath = properties.getProperty("iOSAppPath");
	Logger logger = Logger.getLogger(getClass().getName());

	public static WebDriver getDriver() throws Exception {
		driver = startDriver(DriverFactory.Browsers.valueOf(browser.toUpperCase()));
		return driver;
	}

	public enum Browsers {
		FIREFOX, CHROME, EDGE, IE;
	}
	
	public static WebDriver startDriver(Browsers browser) throws Exception {
		switch (browser) {

		case FIREFOX:
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			return driver;

		case CHROME:
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			return driver;

		case EDGE:
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			return driver;

		case IE:
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			return driver;

		default:
			return null;
		}
	}

	public static void winiumDriver() {

		String Winium = new String("src/main/resources/drivers/Winium.Desktop.Driver.exe");
		String line;
		int instances = 0;
		try {
			Process processo = Runtime.getRuntime().exec("wmic.exe");
			try (BufferedReader br = new BufferedReader(new InputStreamReader(processo.getInputStream()))) {
				OutputStreamWriter osw = new OutputStreamWriter(processo.getOutputStream());
				osw.write("process where name='Winium.Desktop.Driver.exe'");
				osw.flush();
				osw.close();
				while ((line = br.readLine()) != null) {
					// System.out.println(line);
					if (line.contains("Winium")) {
						instances++;
					}
				}
				// System.out.println("Existem " + instances + " processos winium.exe rodando");
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		if (instances < 1) {
			try {
				Runtime.getRuntime().exec(Winium);
				// System.out.println(p.exec(Winium).isAlive());
			} catch (Exception e) {
				System.out.println("Erro executar winium driver");
			}
		}
	}

	@SuppressWarnings("rawtypes")
	public static AndroidDriver androidDriver(Scenario s) throws MalformedURLException {
		File app = new File(AndroidAppPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("appPackage", appPackage);
		capabilities.setCapability("appActivity", appActivity);
		capabilities.setCapability("app", app.getAbsolutePath());
		capabilities.setCapability(MobileCapabilityType.NO_RESET, false);
		capabilities.setCapability("automationName", "UiAutomator2");
		androidDriver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
		return androidDriver;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static IOSDriver iOSDriver(Scenario s) throws MalformedURLException {
		File app = new File(iOSAppPath);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "8.2");
		capabilities.setCapability("appiumVersion", "1.3.7");
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 5s");
		capabilities.setCapability("app", app.getAbsolutePath());
		iOSDriver = new IOSDriver(new URL("http://localhost:4723/wd/hub"), capabilities);
		return iOSDriver;
	}

}
