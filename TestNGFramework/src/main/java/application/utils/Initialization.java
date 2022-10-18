package application.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;

import application.page.HomePageObject;

public class Initialization {

	static String resultFile;
	public DriverFactory driver;
	public DriverFactory mdriver;
	public HomePageObject homepage;
	public Properties cloudProperties = new Properties();
	public static String driverInstance;

	@BeforeSuite
	public static void startTest() throws IOException {

		Utilities.deleteScreenshotFolder(System.getProperty("user.dir") + "/Results/Screenshots/");
		Utilities.deleteScreenshotFolder(System.getProperty("user.dir") + "/allure-results/");
		resultFile = ReportUtil.createReportFile();
	}

	@BeforeMethod
	// @Parameters({ "driverInstance", "udid" })
	public void startExecution(@Optional("Chrome") String driverInstance, String UDID)
			// public void startExecution(String driverInstance, String UDID)
			throws FileNotFoundException, IOException, InterruptedException {
		Initialization.driverInstance = driverInstance;

		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			mdriver = DriverFactory.getInstance();
			mdriver.setDriver(driverInstance, UDID);
			pageObjects(driverInstance);
			launchURLInSafriBrowser();

		} else if (driverInstance.equalsIgnoreCase("Mac")) {
			driver = DriverFactory.getInstance();
			driver.setDriver(driverInstance, UDID);
			pageObjects(driverInstance);
			String url = Utilities.getUrlFromPropery(SystemProperties.getEnvironment());
			DriverFactory.getRemoteWebDriver().manage().deleteAllCookies();
			DriverFactory.getRemoteWebDriver().manage().window().maximize();
			DriverFactory.getRemoteWebDriver().get(url);

		} else {
			driver = DriverFactory.getInstance();
			driver.setDriver(driverInstance, UDID);
			pageObjects(driverInstance);
			String url = Utilities.getUrlFromPropery(SystemProperties.getEnvironment());
			DriverFactory.getDriver().manage().deleteAllCookies();
			DriverFactory.getDriver().manage().window().maximize();
			DriverFactory.getDriver().get(url);
		}
	}

	/**
	 * Driver Selection
	 * 
	 * @param driver name
	 * @return
	 * 
	 */
	public static WebDriver driverSelection(String driverInstance) {

		if (driverInstance.equalsIgnoreCase("IOSDriver") || driverInstance.equalsIgnoreCase("AndroidDriver")) {
			return DriverFactory.getmDriver();
		} else if (driverInstance.equalsIgnoreCase("Mac")) {
			return DriverFactory.getRemoteWebDriver();
		} else {
			return DriverFactory.getDriver();
		}
	}

	public void pageObjects(String driverInstance) {
		homepage = new HomePageObject(driverInstance);
	}

	public void launchURLInSafriBrowser() throws IOException {
		DriverFactory.getmDriver().get(getURL());
	}

	public String getURL() throws IOException {
		String url = Utilities.getUrlFromPropery(SystemProperties.getEnvironment());
		return url;
	}

	/******************************************************************
	 * Description : This Method is validate the properties and get the properties.
	 * Update Details :
	 ******************************************************************/
	public String getProperty(String property, Properties props) {
		if (System.getProperty(property) != null) {
			return System.getProperty(property);
		} else if (System.getenv().containsKey(property)) {
			return System.getenv(property);
		} else if (props != null) {
			return props.getProperty(property);
		}
		return null;
	}

	@AfterMethod
	public void closeBrowser() throws IOException {
		ReportUtil.endTest();
		driverSelection(driverInstance).quit();
	}

	@AfterSuite
	public static void endTest() throws IOException {

		ReportUtil.RenameExtentReport(driverInstance);
	}
}
