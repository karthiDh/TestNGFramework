package application.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory extends Initialization {

	private static DriverFactory instance = null;
	static ThreadLocal<RemoteWebDriver> webDriver = new ThreadLocal<RemoteWebDriver>();
	public RemoteWebDriver Bdriver;
	public static ThreadLocal<AppiumDriver<MobileElement>> mobDriver = new ThreadLocal<>();
	public static ThreadLocal<RemoteWebDriver> RemoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	public static ThreadLocal<Robot> robot = new ThreadLocal<Robot>();
	public static ThreadLocal<LoggerLoad> log = new ThreadLocal<LoggerLoad>();

	private DriverFactory() {
	}

	public static DriverFactory getInstance() {
		if (instance == null) {
			instance = new DriverFactory();
		}
		return instance;
	}

	public final void setDriver(String browser, String UDID) throws FileNotFoundException, IOException {

		switch (browser) {

		case "Firefox":
			WebDriverManager.firefoxdriver().setup();
			webDriver.set(new FirefoxDriver());
			break;

		case "InternetExplorer":
			WebDriverManager.iedriver().setup();
			webDriver.set(new InternetExplorerDriver());
			break;

		case "Edge":
			WebDriverManager.edgedriver().setup();
			webDriver.set(new EdgeDriver());
			break;

		case "BrowserStack":
			final String AUTOMATE_USERNAME1 = "raghusathyanaray1";
			final String AUTOMATE_ACCESS_KEY1 = "8yptyWtwxKBcFWFxbpyu";
			String URL1 = "https://" + AUTOMATE_USERNAME1 + ":" + AUTOMATE_ACCESS_KEY1
					+ "@hub-cloud.browserstack.com/wd/hub";

			DesiredCapabilities Bcaps = new DesiredCapabilities();
			Bcaps.setCapability("browserName", "Android");
			Bcaps.setCapability("device", "Samsung Galaxy S20");
			Bcaps.setCapability("realMobile", "true");
			Bcaps.setCapability("os_version", "10.0");
			Bdriver = new RemoteWebDriver(new URL(URL1), Bcaps);
			Bdriver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			break;

		case "IOSDriver":

			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("reportDirectory", "reports");
			capabilities.setCapability("reportFormat", "xml");
			String accessKey = getProperty("accessKey", cloudProperties);
			if (accessKey != null && !accessKey.isEmpty()) {
				capabilities.setCapability("accessKey", accessKey);
			} else {
				capabilities.setCapability("user", getProperty("username", cloudProperties));
				capabilities.setCapability("password", getProperty("password", cloudProperties));
			}

			capabilities.setCapability("project", getProperty("project", cloudProperties));
			capabilities.setCapability(MobileCapabilityType.FULL_RESET, true);
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
			capabilities.setCapability(UtilConstants.MOBILECAPABILITYTYPE_BROWSER_NAME, "Safari");
			capabilities.setCapability(MobileCapabilityType.UDID, UDID);
			capabilities.setCapability("testName", "IOSDemoTest");
			LoggerLoad.info("********** iOS driver *************");
			mobDriver.set(new IOSDriver<MobileElement>(new URL(getProperty("url", cloudProperties) + "/wd/hub"),
					capabilities));
			break;

		case "AndroidDriver":

			DesiredCapabilities capabilities1 = new DesiredCapabilities();
			capabilities1.setCapability("reportDirectory", "reports");
			capabilities1.setCapability("reportFormat", "xml");
			String accessKey2 = getProperty("accessKey", cloudProperties);
			if (accessKey2 != null && !accessKey2.isEmpty()) {
				capabilities1.setCapability("accessKey", accessKey2);
			} else {
				capabilities1.setCapability("user", getProperty("username", cloudProperties));
				capabilities1.setCapability("password", getProperty("password", cloudProperties));
			}

			capabilities1.setCapability("project", getProperty("project", cloudProperties));
			capabilities1.setCapability(MobileCapabilityType.FULL_RESET, true);
			capabilities1.setCapability(UtilConstants.MOBILECAPABILITYTYPE_PLATFORM_NAME, "Android");
			capabilities1.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
			capabilities1.setCapability(UtilConstants.MOBILECAPABILITYTYPE_BROWSER_NAME, "Chrome");
			capabilities1.setCapability(MobileCapabilityType.UDID, UDID);
			capabilities1.setCapability("testName", "AndroidDemoTest");
			LoggerLoad.info("********** Android driver *************");
			mobDriver.set(new AndroidDriver<>(new URL(getProperty("url", cloudProperties) + "/wd/hub"), capabilities1));
			break;

		case "Mac":
			final String AUTOMATE_USERNAME = "karthikvaradhan_ED8g2l";
			final String AUTOMATE_ACCESS_KEY = "dBqn73B3xLzCAaXrKNz6";
			String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
					+ "@hub-cloud.browserstack.com/wd/hub";

			DesiredCapabilities BMaccaps = new DesiredCapabilities();
			BMaccaps.setCapability("os", "OS X");
			BMaccaps.setCapability("os_version", "Catalina");
			BMaccaps.setCapability("browser", "safari");
			BMaccaps.setCapability("browser_version", "13.1");
			BMaccaps.setCapability("browserstack.local", "false");
			BMaccaps.setCapability("name", "MacSafari_Execution ");
			BMaccaps.setCapability("project", "SKII");
			BMaccaps.setCapability("build", "SKIIMacSafari_Execution");

			LoggerLoad.info("********** Mac Safari driver *************");
			RemoteWebDriver.set(new RemoteWebDriver(new URL(URL), BMaccaps));
			break;

		default:

			WebDriverManager.chromedriver().setup();
			webDriver.set(new ChromeDriver());
			break;
		}
	}

	public static RemoteWebDriver getRemoteWebDriver() {
		return RemoteWebDriver.get();
	}

	public static RemoteWebDriver getDriver() {
		return webDriver.get();
	}

	public static AppiumDriver<MobileElement> getmDriver() {
		return mobDriver.get();
	}

	public static Robot getrobot() {
		try {
			robot.set(new Robot());
		} catch (AWTException e) {
			e.printStackTrace();
		}
		return robot.get();
	}

	public static LoggerLoad getLog() {
		return log.get();
	}

}
