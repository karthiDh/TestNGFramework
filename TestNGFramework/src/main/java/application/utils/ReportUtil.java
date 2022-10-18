package application.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ReportUtil extends Initialization {

	public ReportUtil() {
		throw new IllegalStateException("Report Utility class");
	}

	static ExtentReports report;
	static ExtentTest test;
	protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static String reportFile = "";

	public static String date = Utilities.getDate(UtilConstants.DD_M_YY_HH_MM_SS);
	public static String concatinatedDate = date.replace(" ", "_");
	public static String modifiedDate = concatinatedDate.replace(":", "_");

	/**
	 * Method to create Extent report file for API automation framework
	 * 
	 * @author M1008242
	 * @throws IOException
	 */
	public static String createReportFile() throws IOException {

		if (Utilities.getConfigData("jenkinsTrigger").equalsIgnoreCase("true")) {
			reportFile = UtilConstants.SYSTEM_USER + "\\Results\\ChromeExtentResults_.html";
		} else {
			reportFile = UtilConstants.SYSTEM_USER + "\\Results\\ChromeExtentResults_" + modifiedDate + ".html";
		}
		report = new ExtentReports(reportFile);
		report.loadConfig(new File(UtilConstants.SYSTEM_USER + "\\Properties\\extent-config.xml"));

		return reportFile;
	}

	/**
	 * Method to start the report logging for the specified test case
	 * 
	 * @param testCaseName
	 * @author M1008242
	 */
	public static void startReport(String testCaseName) {
		test = report.startTest(testCaseName);
		extentTest.set(test);
	}

	/**
	 * Method to log PASS step along with message in html report
	 * 
	 * @param message
	 * @author M1008242
	 * @throws IOException
	 */
	public static void pass(String message) throws IOException {
		if (Utilities.getConfigData("passScreenshot").equalsIgnoreCase("true")) {
			extentTest.get().log(LogStatus.PASS, message, extentTest.get().addScreenCapture(takeScreenShot("PassImg")));
		} else {
			extentTest.get().log(LogStatus.PASS, message);
		}
	}

	/**
	 * Method to log FAIL step along with message in html report
	 * 
	 * @param message
	 * @author M1008242
	 * @throws IOException
	 */
	public static void fail(String message) throws IOException {
		if (Utilities.getConfigData("failScreenshot").equalsIgnoreCase("true") && !message.contains("Error occurred")) {
			extentTest.get().log(LogStatus.FAIL, message);
			extentTest.get().log(LogStatus.FAIL, message, extentTest.get().addScreenCapture(takeScreenShot("FailImg")));
			throw new RuntimeException(message);
		} else {
			extentTest.get().log(LogStatus.FAIL, message);
			throw new RuntimeException(message);
		}
	}

	/**
	 * Method to log INFO step along with message in html report
	 * 
	 * @param message
	 * @author M1008242
	 * @throws IOException
	 */
	public static void info(String message) throws IOException {
		extentTest.get().log(LogStatus.INFO, message);
	}

	/**
	 * Method to log SKIP step along with message in html report
	 * 
	 * @param message
	 * @author M1008242
	 */
	public static void skip(String message) {
		extentTest.get().log(LogStatus.SKIP, message);
	}

	public static void finish(String message) {
		extentTest.get().log(LogStatus.PASS, message);
	}
	
	/**
	 * Method to end the reporting logging and flushing the report
	 * 
	 * @author M1008242
	 */
	public static void endTest() {
		
		report.endTest(test);
		report.endTest(extentTest.get());
		report.flush();
	}

	public static String takeScreenShot(String screenShotName) throws IOException {

		String df = Utilities.getDate("yyyyMMddhhss");
		TakesScreenshot ts;
		ts = (TakesScreenshot) BaseClass.driverSelection(driverInstance);
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = UtilConstants.SYSTEM_USER + "/Results/Screenshots/" + screenShotName + df + ".png";
		File destination = new File(path);
		FileUtils.copyFile(source, destination);

		return path;
	}

	public static void captureScreenShot(String screenShot) throws IOException {
		String screenshotPath = takeScreenShot(screenShot);
		extentTest.get().addScreenCapture(screenshotPath);
	}

	public static void RenameExtentReport(String browsers) {

		File file1 = new File(reportFile);

		if (browsers.equalsIgnoreCase("Chrome")) {
			File file2 = new File(
					UtilConstants.SYSTEM_USER + "\\Results\\Application_ChromeExtentResults_" + modifiedDate + ".html");

			if (file1.exists()) {
				file1.renameTo(file2);
			}

		} else if (browsers.equalsIgnoreCase("Edge")) {
			File file2 = new File(
					UtilConstants.SYSTEM_USER + "\\Results\\Application_EdgeExtentResults_" + modifiedDate + ".html");
			if (file1.exists()) {
				file1.renameTo(file2);
			}
		} else {
			File file2 = new File(
					UtilConstants.SYSTEM_USER + "\\Results\\Application_MacSafariExtentResults_" + modifiedDate + ".html");
			if (file1.exists()) {
				file1.renameTo(file2);
			}
		}
	}
}
