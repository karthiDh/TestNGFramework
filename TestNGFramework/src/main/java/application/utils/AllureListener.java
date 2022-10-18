package application.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {

	public static String driverName;
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}

	@Attachment(value = "Page screenshot", type = "image/png")
	public byte[] saveScreenshotPNG(WebDriver driver) {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}

	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLoggerLoadLoad(String message) {
		return message;
	}

	@Attachment(value = "{0}", type = "text/html")
	public static String attachHtml(String html) {
		return html;
	}
	
	
	@Override
	public void onStart(ITestContext iTestContext) {
		LoggerLoad.info("I am in onStart method " + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", Initialization.driverSelection(iTestContext.getName()));
		driverName=iTestContext.getName();
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		LoggerLoad.info(iTestContext.getName());
	}

	@Override
	public void onTestStart(ITestResult iTestResult) {
		LoggerLoad.info(getTestMethodName(iTestResult) + " test is starting.");
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		LoggerLoad.info(getTestMethodName(iTestResult) + " test is succeed.");

	}
	
	@Override
	public void onTestFailure(ITestResult iTestResult) {
		LoggerLoad.info(getTestMethodName(iTestResult) + " test is failed.");
		//String TestMethodName = getTestMethodName(iTestResult);
		WebDriver driver = Initialization.driverSelection(driverName);

		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case:" + getTestMethodName(iTestResult));
			saveScreenshotPNG(driver);
		}
		saveTextLoggerLoadLoad(getTestMethodName(iTestResult) + " failed and screenshot taken!");
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		LoggerLoad.info(getTestMethodName(iTestResult) + " test is skipped.");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		LoggerLoad.info("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
	}
}
