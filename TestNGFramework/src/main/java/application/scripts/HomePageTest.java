package application.scripts;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import application.utils.AllureListener;
import application.utils.BaseClass;
import application.utils.LoggerLoad;
import application.utils.ReportUtil;
import application.utils.UtilConstants;


@Listeners({AllureListener.class})
public class HomePageTest extends BaseClass {

	/*
	 * TC - Floating Bubble component
	 */

	@Test
	public void verify_Floating_Bubble_Component() throws IOException {
		try {
			String testName = new Throwable().getStackTrace()[0].getMethodName();
			LoggerLoad.info(UtilConstants.TEST_EXECUTION_START);
			LoggerLoad.info(UtilConstants.STYLE + testName + UtilConstants.STYLE);
			ReportUtil.startReport(testName);
			homepage.clickFloatingBubbleComponent();
			homepage.verifyOurBestseller();
			ReportUtil.finish(UtilConstants.TEST_EXECUTION_END);
			LoggerLoad.info(UtilConstants.TEST_EXECUTION_END);
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.fail(UtilConstants.ERROR_OCCURED + e.getMessage());
		}
	}

	/*
	 * TC - Store Policy Page
	 */

	@Test
	public void verify_Store_Policy_Homepage() throws IOException {
		try {
			String testName = new Throwable().getStackTrace()[0].getMethodName();
			LoggerLoad.info(UtilConstants.TEST_EXECUTION_START);
			LoggerLoad.info(UtilConstants.STYLE + testName + UtilConstants.STYLE);
			ReportUtil.startReport(testName);
			homepage.clickStorePolicy();
			homepage.storePolicy();
			ReportUtil.finish(UtilConstants.TEST_EXECUTION_END);
			LoggerLoad.info(UtilConstants.TEST_EXECUTION_END);
		} catch (Exception e) {
			e.printStackTrace();
			ReportUtil.fail(UtilConstants.ERROR_OCCURED + e.getMessage());
		}
	}
}
