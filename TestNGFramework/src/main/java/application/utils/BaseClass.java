package application.utils;

import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class BaseClass extends Initialization {

	/**
	 * Method to wait for an element till it is visible
	 *
	 * @param locator, timeout
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public void waitUntilElementIsVisible(WebElement element, long timeoutInSecs)
			throws IOException, InterruptedException {

		WebDriverWait webDriverWait;
		webDriverWait = new WebDriverWait(driverSelection(driverInstance), timeoutInSecs);

		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			LoggerLoad.error(element + " WebElement is not visible");
			ReportUtil.fail(element + " WebElement is not visible");
		}
	}

	/**
	 * Method to click Element
	 *
	 * @param locator
	 * @throws InterruptedException
	 */
	public void clickElement(WebElement webElement, String objname, int... waittime)
			throws IOException, InterruptedException {

		if (waittime.length > 0) {
			waitUntilElementIsVisible(webElement, waittime[0]);
			LoggerLoad.info("WebElement is Visible");
			ReportUtil.pass("WebElement is Visible");
		} else {
			waitUntilElementIsVisible(webElement, 50);
			LoggerLoad.info("WebElement is Visible");
			ReportUtil.pass("WebElement is Visible");
		}
		if (isObjectExists(webElement)) {
			webElement.click();
			LoggerLoad.info("Clicked " + objname);
			ReportUtil.pass("Clicked " + objname);
		} else {
			LoggerLoad.error(objname + " Unable to Click the element");
			ReportUtil.fail(objname + " Unable to Click the element");
		}
	}

	/**
	 * Method to verify element exist
	 *
	 * @param locator, waittime
	 */

	public boolean isObjectExists(WebElement element, int... waittime) throws IOException {
		try {
			if (waittime.length > 0) {
				waitUntilElementIsVisible(element, waittime[0]);
			} else {
				waitUntilElementIsVisible(element, 20);
			}
			return true;
		} catch (Exception e) {
			LoggerLoad.error(element + " Object Desn't Exists");
			ReportUtil.fail(element + " Object Desn't Exist");
			return false;
		}
	}

	/**
	 * Method to verify Text
	 *
	 * @param locator, text
	 * @throws IOException
	 */
	public void verifyTextWithElement(WebElement element, String expectedText) throws IOException {
		String actualText;
		driverSelection(driverInstance).manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		SoftAssert sa = new SoftAssert();
		actualText = element.getText();
		if (StringUtils.isEmpty(actualText)) {
			actualText = element.getAttribute("value");
		}
		try {
			boolean assertreturn = actualText.equals(expectedText);
			sa.assertTrue(assertreturn);
			sa.assertAll();
			LoggerLoad.info("Following text is displayed : " + actualText + " with expected : " + expectedText);
			ReportUtil.pass("Following text is displayed : " + actualText + " with expected : " + expectedText);
		} catch (AssertionError e) {
			LoggerLoad.error("Following text is not displayed : " + actualText + " in " + element);
			ReportUtil.fail("Following text is not dispalyed : " + actualText + " in " + element);
		}
	}

	/************************************************************************
	 * Description : Check element is present or not Parameters : Return Value :
	 * Last Update Details :
	 * 
	 * @throws IOException
	 ************************************************************************/
	public boolean isElementPresent(WebElement element) {

		try {
			waitUntilElementIsVisible(element, 20);
			ReportUtil.pass("Element is present: " + element.isDisplayed());
			LoggerLoad.info("Element is present: " + element.isDisplayed());
			return element.isDisplayed() || element.isEnabled();
		} catch (Exception e) {
			LoggerLoad.error(element + " element is not present.");
		}
		LoggerLoad.error(element + " Element is not present");
		return false;
	}

	/************************************************************************
	 * Description : Verify text Parameters : Return Value : Last Update Details :
	 * 
	 * @throws IOException
	 * 
	 * @throws IOException
	 ************************************************************************/
	public void verifyTextWithElement(String actual, String expected) throws IOException {

		try {
			SoftAssert sa = new SoftAssert();
			boolean assertreturn = actual.equals(expected);
			sa.assertTrue(assertreturn);
			sa.assertAll();
			LoggerLoad.info("Actual value " + actual + " and Expected value " + expected + " both are equals");
			ReportUtil.pass("Actual value  " + actual + " and Expected value " + expected + " both are equals");
		} catch (AssertionError ae) {
			LoggerLoad.error("Actual value " + actual + " and Expected value " + expected + " both are not equals");
			ReportUtil.fail("Actual value  " + actual + " and Expected value " + expected + " both are not equals");
		}
	}

	/**
	 * Method to enter Text
	 *
	 * @param locator, text
	 */
	public void sendKeys(WebElement element, String objname, String text) throws IOException {

		try {
			if (isObjectExists(element)) {
				element.clear();
				element.sendKeys(text);
				LoggerLoad.info("'" + text + "' is entered in  " + objname + " field");
				ReportUtil.pass("'" + text + "' is entered in " + objname + " field");
			} else {
				LoggerLoad.error("Element not present on the screen. Cannot set the Text: " + text);
				ReportUtil.fail("Element not present on the screen. Cannot set the Text: " + text);
			}
		} catch (Exception e) {
			LoggerLoad.error(element + " Element not present on the screen. Cannot set the Text");
			ReportUtil.fail(element + " Element not present on the screen. Cannot set the Text");
		}
	}

	/**
	 * 
	 * Method to select value from DropDown
	 * 
	 * @param locator,text
	 */

	public void selectvalueWithText(WebElement element, String text) throws IOException {

		Select select = new Select(element);
		try {
			select.selectByVisibleText(text);
			LoggerLoad.info("value selected from DropDown : " + text);
			ReportUtil.pass("value selected from DropDown : " + text);
		} catch (Exception e) {
			LoggerLoad.error(text + " value is not selected from DropDown");
			ReportUtil.fail(text + " value is not selected from DropDown");
		}
	}

	public void selectvalueWithValue(WebElement element, String text) throws IOException {

		Select select = new Select(element);
		try {
			select.selectByValue(text);
			LoggerLoad.info("value selected from DropDown : " + text);
			ReportUtil.pass("value selected from DropDown : " + text);
		} catch (Exception e) {
			LoggerLoad.info("value is not selected from DropDown : " + text);
			ReportUtil.pass("value is not selected from DropDown : " + text);
		}
	}

	/**
	 * 
	 * method to click checkbox
	 * 
	 * @param element,objname,waittime
	 * @throws InterruptedException
	 * 
	 */

	public void clickCheckbox(WebElement element, String objname, int... waittime)
			throws IOException, InterruptedException {

		JavascriptExecutor js;
		js = (JavascriptExecutor) driverSelection(driverInstance);

		if (waittime.length > 0) {
			waitUntilElementIsVisible(element, waittime[0]);
		} else {
			waitUntilElementIsVisible(element, 20);
		}
		if (isObjectExists(element)) {
			js.executeScript("arguments[0].click()", element);
			LoggerLoad.info("CheckBox Clicked " + objname);
			ReportUtil.pass("CheckBox Clicked " + objname);
		} else {
			LoggerLoad.error("Unable to Click the CheckBox " + objname);
			ReportUtil.fail("Unable to Click the CheckBox " + objname);
		}

	}

	public void clickJSButton(WebElement element, String objname, int... waittime)
			throws IOException, InterruptedException {

		JavascriptExecutor js;
		js = (JavascriptExecutor) driverSelection(driverInstance);

		if (waittime.length > 0) {
			waitUntilElementIsVisible(element, waittime[0]);
		} else {
			waitUntilElementIsVisible(element, 20);
		}
		if (isObjectExists(element)) {
			js.executeScript("arguments[0].click()", element);
			LoggerLoad.info("Clicked " + objname);
			ReportUtil.pass("Clicked " + objname);
		} else {
			LoggerLoad.error("Unable to Click " + objname);
			ReportUtil.fail("Unable to Click " + objname);
		}

	}

	/**
	 * Method to create unique email address and add to Testdata
	 * 
	 * @throws IOException
	 * 
	 */
	public String createUniqueEmailAddress() throws IOException {
		try {
			DateFormat dateFormat = new SimpleDateFormat("MMddyyyyhhmmss");
			Date date = new Date();
			String date1 = dateFormat.format(date);
			String email = "Test" + date1 + "@gmail.com";
			ReportUtil.pass("Unique Email Address is: " + email);
			LoggerLoad.info("Unique Email Address is: " + email);
			return email;
		} catch (Exception e) {
			ReportUtil.fail("Not generated Unique Email Address " + e.getMessage());
			LoggerLoad.error("Not generated Unique Email Address " + e.getMessage());
			return null;
		}
	}

	public void selectOption(WebElement element) throws IOException {
		try {
			Select s = new Select(element);
			s.getFirstSelectedOption();
			LoggerLoad.info("First option selected: " + element);
			ReportUtil.pass("First option selected: " + element);
		} catch (Exception e) {
			ReportUtil.fail("First option not selected " + e.getMessage());
			LoggerLoad.error("First option not selected " + e.getMessage());
		}
	}

	/*
	 * Method to pass into next tab
	 */
	public void robotTab(WebElement element, int... waittime) throws AWTException, IOException {

		try {
			Thread.sleep(2000);
			waitUntilElementIsVisible(element, 20);
			DriverFactory.getrobot().keyPress(KeyEvent.VK_TAB);
			DriverFactory.getrobot().keyRelease(KeyEvent.VK_TAB);
			LoggerLoad.info("passed into next Tab after" + waittime + "Sec");
			ReportUtil.pass("passed into next Tab");
		} catch (Exception e) {
			LoggerLoad.error("Failed to pass into next Tab " + e.getMessage());
			ReportUtil.fail("Failed to Pass into next Tab " + e.getMessage());
		}
	}

	public void clearText(WebElement element) throws IOException {
		try {
			element.clear();
			LoggerLoad.info("Cleared the value");
			ReportUtil.pass("Cleared the value");
		} catch (Exception e) {
			LoggerLoad.error("Unable to clear the value " + e.getMessage());
			ReportUtil.fail("Unable to clear the value " + e.getMessage());
		}
	}

	public void verifyTextConcat(WebElement element, WebElement element1, String expectedText) throws IOException {
		String actualText;
		driverSelection(driverInstance).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		SoftAssert sa = new SoftAssert();
		try {
			actualText = element.getText() + " " + element1.getText();
			LoggerLoad.info("expected text : " + expectedText + " actulalText : " + actualText);
			boolean assertreturn = actualText.equalsIgnoreCase(expectedText);
			sa.assertTrue(assertreturn);
			sa.assertAll();
			LoggerLoad.info("Following text is displayed : " + actualText);
			ReportUtil.pass("Following text is displayed : " + actualText);
		} catch (AssertionError e) {
			LoggerLoad.error("Following text is not displayed : " + expectedText);
			ReportUtil.fail("Following text is not dispalyed : " + expectedText);
		}
	}

	public void verifyAttribute(WebElement element) throws IOException {

		try {
			driverSelection(driverInstance).manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			String actualValue = element.getAttribute("value");
			ReportUtil.info(element + " Attribute value : " + actualValue);
			LoggerLoad.info(element + " Attribute value : " + actualValue);
		} catch (Exception e) {
			ReportUtil.fail(element + " Unable to find attribute value " + e.getMessage());
			LoggerLoad.error(element + " Unable to find attribute value " + e.getMessage());
		}
	}

	public void windowHanldes() throws IOException, InterruptedException {

		String parentWindow;
		Set<String> allWind;
		try {
			parentWindow = driverSelection(driverInstance).getWindowHandle();
			allWind = driverSelection(driverInstance).getWindowHandles();
			LoggerLoad.info("Parent Window " + parentWindow);
			LoggerLoad.info("Child Windows " + allWind);

			for (String x : allWind) {
				if (!parentWindow.equals(x)) {
					driverSelection(driverInstance).switchTo().window(x);
					LoggerLoad.info("**********" + x);
					LoggerLoad.info("User switches to child window " + x);
					ReportUtil.pass("User switches to child window");
				}
			}
		} catch (Exception e) {
			LoggerLoad.error("User unable to switch child window " + e.getMessage());
			ReportUtil.fail("User unable to switch child window " + e.getMessage());
		}
	}

	/**
	 * Method to Switch the iframe
	 *
	 * @param iframe number
	 */

	public void switchingToiFrame(int frame) throws IOException {

		try {
			driverSelection(driverInstance).switchTo().frame(frame);
			LoggerLoad.info("iframe Switched");
			ReportUtil.pass("iframe Switched");
		} catch (Exception e) {
			LoggerLoad.error("Failed to Switch iframe");
			ReportUtil.fail("Failed to Switch iframe");
		}
	}

	/**
	 * Method to pass the control on main page after switching iframe
	 */

	public void defaultContentFrame() throws IOException {

		try {
			driverSelection(driverInstance).switchTo().defaultContent();
			LoggerLoad.info("pass the control to main page");
			ReportUtil.pass("pass the control to main page");
		} catch (Exception e) {
			LoggerLoad.error("Not able to pass the control to main page");
			ReportUtil.fail("Not able to pass the control to main page");
		}
	}

	/**
	 * Method to Scroll the Bar 0,800
	 */

	public void scroll(int num) throws IOException {

		JavascriptExecutor js;
		try {
			js = (JavascriptExecutor) driverSelection(driverInstance);
			js.executeScript("window.scrollBy(0," + num + ")", "");
			LoggerLoad.info("Scroll Down");
			ReportUtil.pass("Scroll Down");

		} catch (Exception e) {
			LoggerLoad.error("Not able to Scroll Down " + e.getMessage());
			ReportUtil.fail("Not able to Scroll Down " + e.getMessage());
		}
	}

	public void scrolltoelement(WebElement element) throws IOException {

		try {
			((JavascriptExecutor) driverSelection(driverInstance)).executeScript("arguments[0].scrollIntoView(true);",
					element);
			ReportUtil.pass("Moved to element: " + element);
			LoggerLoad.info("Moved to element: " + element);
		} catch (Exception e) {
			ReportUtil.fail("Unable to move: " + e.getMessage());
			LoggerLoad.error("Unable to move: " + e.getMessage());
		}
	}

	/************************************************************************
	 * Description : Check element is present or not Parameters : Return Value :
	 * Last Update Details :
	 * 
	 * @throws IOException
	 ************************************************************************/
	public boolean isElementPresent(WebElement element, String objName) throws IOException {

		try {
			waitUntilElementIsVisible(element, 20);
			LoggerLoad.info("Element is present " + objName);
			ReportUtil.pass("Element is present: " + element.isDisplayed());
			return element.isDisplayed() || element.isEnabled();
		} catch (Exception e) {
			LoggerLoad.info("Element is not present " + e.getMessage());
			ReportUtil.pass("Element is not present: " + e.getMessage());
			return false;
		}
	}

	/**
	 * Method to Mousehover on Element
	 * 
	 * @param - Locator
	 * @throws IOException
	 * @throws IOException
	 * 
	 */
	public void mouseHover(WebElement element, String objName) throws IOException {

		Actions actions;
		try {
			actions = new Actions(driverSelection(driverInstance));
			actions.moveToElement(element).perform();
			LoggerLoad.info("MouseHover To Element: " + objName);
			ReportUtil.pass("MouseHover To Element: " + objName);
		} catch (Exception e) {
			LoggerLoad.error("unable to perform MouseHover To Element: " + e.getMessage());
			ReportUtil.fail("unable to perform MouseHover To Element: " + e.getMessage());
		}
	}

	/*
	 * Method to Press Enter
	 */
	public void robotEnter(WebElement element, int... waittime) throws AWTException, IOException {

		try {
			Thread.sleep(5000);
			waitUntilElementIsVisible(element, 20);
			DriverFactory.getrobot().keyPress(KeyEvent.VK_ENTER);
			DriverFactory.getrobot().keyRelease(KeyEvent.VK_ENTER);
			LoggerLoad.info("Pressed Enter after " + waittime);
			ReportUtil.pass("Pressed Enter");
		} catch (Exception e) {
			LoggerLoad.error("Failed to Press Enter " + e.getMessage());
			ReportUtil.fail("Failed to Press Enter " + e.getMessage());
		}

	}

	/************************************************************************
	 * Description : Check element is present or not Parameters : Return Value :
	 * Last Update Details :
	 * 
	 * @throws IOException
	 ************************************************************************/
	public boolean isElementPresent(List<WebElement> element, String objName, int i) throws IOException {

		try {
			waitUntilElementIsVisible(element.get(i), 20);
			LoggerLoad.info("Element is present " + objName);
			ReportUtil.pass(objName + " is present: " + element.get(i).isDisplayed());
			return element.get(i).isDisplayed() || element.get(i).isEnabled();
		} catch (Exception e) {
			LoggerLoad.error("Element is not present " + e.getMessage());
			ReportUtil.fail("Element is not present " + e.getMessage());
			return false;
		}
	}

	/************************************************************************
	 * Description : Move to element Last Update Details :
	 * 
	 * @throws IOException
	 * 
	 * @throws IOException
	 ************************************************************************/
	public void moveToElementTillObject(WebElement element, String objName) throws IOException {

		Actions ac;
		try {
			waitUntilElementIsVisible(element, 20);
			ac = new Actions(driverSelection(driverInstance));
			ac.moveToElement(element).perform();
			LoggerLoad.info("Scroll down till element " + objName);
			ReportUtil.pass("Scroll down till element " + objName);
		} catch (Exception e) {
			LoggerLoad.error("Unable to scroll down till element " + e.getMessage());
			ReportUtil.fail("Unable to Scroll down till element " + e.getMessage());
		}
	}

	public WebElement expandRootElement(WebElement element) throws IOException {
		try {
			WebElement returnObj = null;
			Object shadowRoot = ((JavascriptExecutor) driverSelection(driverInstance))
					.executeScript("return arguments[0].shadowRoot", element);

			Map<String, Object> shadowRootMap = (Map<String, Object>) shadowRoot;
			String shadowRootKey = (String) shadowRootMap.keySet().toArray()[0];
			String id = (String) shadowRootMap.get(shadowRootKey);
			RemoteWebElement remoteWebElement = new RemoteWebElement();
			remoteWebElement.setParent((RemoteWebDriver) DriverFactory.getDriver());
			remoteWebElement.setId(id);
			returnObj = remoteWebElement;
			ReportUtil.pass("Expanded Root Element");
			LoggerLoad.info("Expanded Root Element");
			return returnObj;
		} catch (Exception e) {
			ReportUtil.fail("Unable to Expand the Root Element " + e.getMessage());
			LoggerLoad.error("Unable to Expand the Root Element " + e.getMessage());
			return null;
		}
	}

	public void scrollBottomPage() throws IOException {

		try {
			((JavascriptExecutor) driverSelection(driverInstance))
					.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			ReportUtil.pass("Scrolled to Bottom of the Page");
			LoggerLoad.info("Scrolled to Bottom of the Page");
		} catch (Exception e) {
			ReportUtil.fail("Unable to Scroll Bottom of the Page " + e.getMessage());
			LoggerLoad.error("Unable to Scroll Bottom of the Page " + e.getMessage());
		}
	}

	public void scrollUpPage() throws IOException {

		try {
			((JavascriptExecutor) driverSelection(driverInstance))
					.executeScript("window.scrollTo(document.body.scrollHeight,0)");

			ReportUtil.pass("Scrolled to Top of the Page");
			LoggerLoad.info("Scrolled to Top of the Page");
		} catch (Exception e) {
			ReportUtil.fail("Unable to Scroll Top of the Page " + e.getMessage());
			LoggerLoad.error("Unable to Scroll Top of the Page " + e.getMessage());
		}
	}
}
