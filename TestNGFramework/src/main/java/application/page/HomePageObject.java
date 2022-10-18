package application.page;

import java.awt.AWTException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import application.utils.BaseClass;
import application.utils.DriverFactory;
import application.utils.LoggerLoad;

public class HomePageObject extends BaseClass {

	public String driverInstance;

	public HomePageObject(String driverInstance) {
		this.driverInstance = driverInstance;
		PageFactory.initElements(driverSelection(driverInstance), this);
	}

	@FindBy(xpath = "//a[@id='login_user']")
	public WebElement loginInput;

	@FindBy(xpath = "(//a[@href='/product/essence/facial-treatment-essence'])[1]")
	public WebElement productFacialtreatementEsscence;

	@FindBy(xpath = "//*[@id='login_user_page']")
	public WebElement loginInputIOS;

	@FindBy(css = "a#shop-bestsellers.event_menu_click")
	public WebElement bestsellers;

	@FindBy(xpath = "//div[@class='shop-all-navbar']/a[contains(text(),'Shop All')]")
	public WebElement shopAll;

	@FindBy(xpath = "//div[@class='cta-section']//a[@id='addtocart-url-458']")
	public WebElement addToBag;

	@FindBy(id = "form-action-addToCart")
	public WebElement addToBagIos;

	@FindBy(xpath = "((//a[@href='/cart.php?action=add&sku=00730870159439'])[1]")
	public WebElement product;

	@FindBy(xpath = "(//a[@href='/product/essence/facial-treatment-essence'])[1]")
	public WebElement facialTreatementEsscence;

	@FindBy(xpath = "(//a[@href='/product/essence/limited-edition-andy-warhol-pitera-essence'])[1]")
	public WebElement piteraEssenceAndyWarhol;

	@FindBy(xpath = "//img[@src='https://cdn11.bigcommerce.com/s-dgn50skflj/images/stencil/500x500/products/485/1554/FTE__36905.1615995093.png']")
	public WebElement peteraEssenceProductIos;

	@FindBy(xpath = "//img[@title='SKINPOWER Eye Cream For Glowing Skin | Thumb']")
	public WebElement productSkinPowderEye;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[2]")
	public WebElement productFirstExperienceKitIos;

	@FindBy(xpath = "//img[@src='https://cdn11.bigcommerce.com/s-dgn50skflj/images/stencil/500x659/products/536/1520/skinpower-eyecream-15g__00794.1609851149.png?c=1']")
	public WebElement productSkinPowderEyeMac;

	@FindBy(xpath = "(//a[@href='/gift-sets/first-experience-kit'])[3]")
	public WebElement productFirstExperienceKit;

	@FindBy(xpath = "//img[@src='https://cdn11.bigcommerce.com/s-dgn50skflj/images/stencil/500x500/products/458/1558/FEK__62029.1616082084.png']")
	public WebElement PRODUCT_FIRST_Experience_KIT_IOS;

	@FindBy(xpath = "//img[@src='https://cdn11.bigcommerce.com/s-dgn50skflj/images/stencil/500x500/products/458/1558/FEK__62029.1616082084.png']")
	public WebElement firstExperienceKitProductIos;

	@FindBy(xpath = "//*[@nodeName='IMG' and ./parent::*[@nodeName='SPAN']]")
	public WebElement floatingBubbleComponentIos;

	@FindBy(xpath = "//img[@class='floating-img lazyloaded']")
	public WebElement floatingBubbleComponent;

	@FindBy(xpath = "//img[@src='https://res.cloudinary.com/mtree/image/upload/q_auto:low,f_auto,dpr_auto,w_auto/SKII-US_DTC-STAGE-CDN/content/assets/images/floatingBubbleImages/pdtBubble.png']")
	public WebElement floatingBubbleComponentMac;

	@FindBy(xpath = "//*[contains(text(),'Our bestsellers')]")
	public WebElement ourBestseller;

	@FindBy(xpath = "//form//div//input[@id='form-action-addToCart']")
	public WebElement addToBagIos1;

	@FindBy(xpath = "//div[@class='cta-section addtobag-button']/a")
	public WebElement skin_addToBagIos;

	@FindBy(xpath = "(//a[@href='/our-bestsellers'][1])[1]")
	public WebElement bestsellerIos;

	@FindBy(xpath = "//*[@class='award-title startLogo logoclass award-text-color']")
	public WebElement awardModuleTitle;

	@FindBy(xpath = "//div[@class='award-feature glamour-home']")
	public WebElement awardGlamour;

	@FindBy(xpath = "//p[text()='2020 Anti-Aging Awards']")
	public WebElement awardBaazar;

	@FindBy(xpath = "//img[@title='/content/assets/images/pdp/brand_logo/glamour.svg']")
	public WebElement glamourLogo;

	@FindBy(xpath = "//img[@title='/content/assets/images/pdp/brand_logo/bazaar.svg']")
	public WebElement bazaarLogo;

	@FindBy(xpath = "//a[text()='Store Policy']")
	public WebElement storePolicyIos;

	@FindBy(xpath = "//a[@href='/skii-policy']")
	public WebElement storePolicyElement;

	@FindBy(xpath = "//h1[text()='SK-II Policies Agreement']")
	public WebElement policyAgreementTxtIos;

	@FindBy(css = "div.faq-header .header-4")
	public WebElement policyAgreementTxt;

	@FindBy(css = "div.skii-policies .header-5")
	public WebElement policyIntroTxt;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[4]")
	public WebElement specialEditionPiteraEssenceIos;

	@FindBy(xpath = "//a[text()='Special Edition PITERA™ Essence']")
	public WebElement specialEditionPiteraEssence;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[3]")
	public WebElement newPiteraPowerKitIos;

	@FindBy(xpath = "//a[text()='New PITERA™ Power Kit']")
	public WebElement newPiteraPowerKit;

	@FindBy(xpath = "//a[text()='PITERA™ Aura Kit']")
	public WebElement piteraAuroKitTxt;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[6]")
	public WebElement skinpowderCreamIos;

	@FindBy(xpath = "(//a[text()='SKINPOWER Cream'])[3]")
	public WebElement skinpowderCream;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[7]")
	public WebElement facialTreatmentMaskIos;

	@FindBy(xpath = "(//a[text()='Facial Treatment Mask'])[3]")
	public WebElement facialTreatmentMask;

	@FindBy(xpath = "(//a[contains(text(),'Learn more')])[2]")
	public WebElement giftLearnMore;

	@FindBy(xpath = "(//a[contains(text(),'Shop now')])[1]")
	public WebElement giftShopNow;

	@FindBy(xpath = "//a[text()='SKINPOWER Airy Milky Lotion']")
	public WebElement skinpowerAiryMilkyLotion;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[9]")
	public WebElement genopticsAuraEssenceSerumIos;

	@FindBy(xpath = "(//a[text()='GenOptics Aura Essence Serum'])[2]")
	public WebElement genopticsAuraEssenceSerum;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[10]")
	public WebElement skinpowerEssenceIos;

	@FindBy(xpath = "(//a[text()='SKINPOWER Essence'])[2]")
	public WebElement skinpowerEssence;

	@FindBy(xpath = "(//a[@class='event_buy_now_choose_product tiles-title'])[5]")
	public WebElement piteraAuraKitIos;

	@FindBy(xpath = "(//a[@href='/gift-sets/pitera-aura-kit'])[2]")
	public WebElement piteraAuraKit;

	@FindBy(xpath = "//span[@class='all-products-title']")
	public WebElement allproduct;

	@FindBy(xpath = "(//img[@alt='SK-II  Facial Treatment Essence for glowing, crystal-clear skin | Hero'])[1]")
	public WebElement facialTreatmentEssenceProductChrome;

	@FindBy(xpath = "(//img[@class='bestseller-card-img-container plp-image ls-is-cached lazyloaded'])[9]")
	public WebElement genopticsAuraEssence;

	@FindBy(xpath = "//a[@id='addtocart-url-533']")
	public WebElement skinPowderAiryMilkyLotion1;

	@FindBy(xpath = "//img[@src='https://cdn11.bigcommerce.com/s-dgn50skflj/images/stencil/320x320/products/539/1472/HYGIENE_PPK__03397.1590737544.1280.1280__35512.1609146774.png']")
	public WebElement skinPowderAiryMilkyLotionMac;

	@FindBy(xpath = "//a[@id='addtocart-url-533']")
	public WebElement skinPowderAiryMilkyLotion;

	@FindBy(xpath = "(//a[@href='/gift-sets/first-experience-kit'])[2]")
	public WebElement productFirstExperienceKitIOS1;

	@FindBy(xpath = "//div[@class='logo-inner']")
	public WebElement skLogoIOS;

	@FindBy(xpath = "//button[@class='delete_btn edit_paymentDetails_Buttons']")
	public WebElement deleteButton;

	@FindBy(xpath = "//span[text()='You must enter a valid credit card number.']")
	public WebElement invalidCardDetails;

	@FindBy(xpath = "//span[text()='You must enter a valid expiration date.']")
	public WebElement invalidYYMMText;

	@FindBy(xpath = "//span[text()='You must enter a valid cvv.']")
	public WebElement invalidCVVText;

	@FindBy(xpath = "//span[text()='You must enter a name.']")
	public WebElement emptyNameMessage;

	@FindBy(xpath = "//input[@class='button button--primary']")
	public WebElement updatePayment;

	@FindBy(xpath = "//span[@class='checkmark'][1]")
	public WebElement checkmark;

	@FindBy(xpath = "//input[@id='firstName_input']")
	public WebElement newFirstName;

	@FindBy(xpath = "//input[@id='last_name_input']")
	public WebElement newLastName;

	@FindBy(xpath = "//input[@id='postal_code_input']")
	public WebElement newBillingPostalCode;

	@FindBy(xpath = "//select[@id='country_select']")
	public WebElement newBillingCountry;

	@FindBy(xpath = "//*[@id='FormField_11_select']")
	public WebElement newBillingCountryIOS;

	@FindBy(xpath = "//input[@id='city_input']")
	public WebElement newBillingCity;

	@FindBy(xpath = "//select[@id='state_input']")
	public WebElement newBillingState;

	@FindBy(xpath = "//*[@id='FormField_12_select']")
	public WebElement newBillingStateIOS;

	@FindBy(xpath = "//input[@id='address1_input']")
	public WebElement newBillingAddressLine1;

	@FindBy(xpath = "//input[@id='address2_input']")
	public WebElement newBillingAddressLine2;

	@FindBy(xpath = "//input[@id='phone_input']")
	public WebElement newBillingPhoneNumber;

	@FindBy(xpath = "//input[@id='FormField_4_input']")
	public WebElement editFirstName;

	@FindBy(xpath = "//input[@id='FormField_5_input']")
	public WebElement editLastName;

	@FindBy(xpath = "//input[@id='FormField_13_input']")
	public WebElement editBillingCode;

	@FindBy(xpath = "//select[@id='FormField_11_select']")
	public WebElement editBillingCountry;

	@FindBy(xpath = "//input[@id='FormField_10_input']")
	public WebElement editBillingCity;

	@FindBy(xpath = "//select[@id='FormField_12_select']")
	public WebElement editBillingState;

	@FindBy(xpath = "//input[@id='FormField_8_input']")
	public WebElement billingAddress1;

	@FindBy(xpath = "//input[@id='FormField_9_input']")
	public WebElement editBillingAddress2;

	@FindBy(xpath = "//input[@id='FormField_7_input']")
	public WebElement editBillingPhoneNumber;

	@FindBy(xpath = "//div[@class='paymentMethod']")
	public WebElement saveCard;

	@FindBy(xpath = "//label[text()='Default Payment Method']")
	public WebElement defaultPaymentMethods;

	@FindBy(xpath = "(//span[@class='checkmark'])[1]")
	public WebElement setPrimaryCheckMar;

	@FindBy(xpath = "//span[text()='You must enter a valid credit card number.']")
	public WebElement invalidCreditCardNumber;

	@FindBy(xpath = "//span[text()='You must enter a valid expiration date.']")
	public WebElement invalidExpireDate;

	@FindBy(xpath = "//a[text()='Payment']")
	public WebElement paymentLink;

	@FindBy(xpath = "//a[contains(text(),'Add new payment method')]")
	public WebElement addNewPaymentMethod;

	@FindBy(xpath = "//label[@class='container']")
	public WebElement setAsPrimaryText;

	@FindBy(xpath = "//input[@id='credit_card_number_input']")
	public WebElement creditCardNumber;

	@FindBy(xpath = "//input[@id='expiration_input']")
	public WebElement expiryDate;

	@FindBy(xpath = "//input[@id='cvv_input']")
	public WebElement cvvInput;

	@FindBy(xpath = "//input[@id='name_on_card_input']")
	public WebElement nameOnCard;

	@FindBy(xpath = "//label[text()='Default Payment Method']")
	public WebElement defaultPaymentMethod;

	@FindBy(xpath = "//input[@value='ADD PAYMENT']")
	public WebElement addPaymentText;

	@FindBy(xpath = "//h2[text()='Payment method']")
	public WebElement paymentMethod;

	@FindBy(xpath = "//a[@class='edit_btn edit_paymentDetails_Buttons']")
	public WebElement editButton;

	@FindBy(xpath = "(//a[@href='/product/essence/facial-treatment-essence'])[1]")
	public WebElement productPiteraEssence;

	@FindBy(xpath = "//nav[@class='nav-toggle']")
	public WebElement menuBtn;

	public void clickOnLoginBtn() throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(1000);
			clickJSButton(loginInputIOS, "LOGIN_INPUT");
		} else {
			clickOnLogin();
		}
	}

	public void clickOnLogin() throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(1000);
			clickOnMenunBtn();
			clickJSButton(loginInputIOS, "LOGIN_INPUT");
		} else if (driverInstance.equalsIgnoreCase("Mac")) {
			Thread.sleep(5000);
			clickJSButton(loginInput, "LOGIN");
		} else {
			clickElement(loginInput, "LOGIN");
		}
	}

	public void clickOnMenunBtn() throws IOException, InterruptedException {
		if (driverInstance.equalsIgnoreCase("IOSDriver") || driverInstance.equalsIgnoreCase("AndroidDriver")) {
			clickElement(menuBtn, "MENU BTN");
		}
	}

	public void switchingNativeApp1() throws InterruptedException, IOException {
		deleteMethod(2);
	}

	public void deletePaymentIOS() throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			deleteMethod(1);
		}
	}

	public void deleteMethod(int n) throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(1000);
			DriverFactory.getmDriver().context("NATIVE_APP");

			Thread.sleep(3000);
			waitUntilElementIsVisible(DriverFactory.getmDriver().findElement(By.id("OK")), 40);
			for (int i = 0; i <= n; i++) {
				Thread.sleep(2000);
				DriverFactory.getmDriver().findElement(By.id("OK")).click();
			}
			Thread.sleep(5000);
			DriverFactory.getmDriver().context("WEBVIEW_1");
		}
	}

	public void switchingWebview1() throws InterruptedException {

		if (driverInstance.equalsIgnoreCase("Chrome") || driverInstance.equalsIgnoreCase("Edge")) {
			Thread.sleep(2000);
			DriverFactory.getDriver().switchTo().alert().accept();
		}
	}

	public void editPaymentIOS(String fname, String lname, String country1, String postcode1, String state1,
			String address11, String address22, String phoneno1)
			throws IOException, InterruptedException, AWTException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			clickElement(editButton, "EDIT BUTTON", 20);
			editFirstName.clear();
			sendKeys(editFirstName, "FIRST NAME", fname);
			editLastName.clear();
			sendKeys(editLastName, "LAST NAME", lname);

			scroll(200);
			Thread.sleep(1000);
			clickElement(newBillingCountryIOS, "COUNTRY", 10);
			selectCountryIOS(country1);
			scroll(200);

			editBillingCode.clear();
			sendKeys(editBillingCode, "POSTCODE", postcode1);
			robotTab(editBillingCode, 20);

			clickElement(newBillingStateIOS, "STATE", 10);
			selectingStateIOS(state1);
			scroll(200);

			billingAddress1.clear();
			sendKeys(billingAddress1, "ADDRESS LINE 1", address11);
			editBillingAddress2.clear();
			sendKeys(editBillingAddress2, "ADDRESS LINE 2", address22);
			editBillingPhoneNumber.clear();
			sendKeys(editBillingPhoneNumber, "PHONE NUMBER", phoneno1);
			clickElement(updatePayment, "UPDATE PAYMENT", 20);
			verifyTextWithElement(paymentMethod, "Payment method");
		}
	}

	public void editPaymentChrome(String fname, String lname, String country1, String postcode1, String city1,
			String state1, String address11, String address22, String phoneno1)
			throws IOException, InterruptedException, AWTException {
		if (driverInstance.equalsIgnoreCase("Chrome") || driverInstance.equalsIgnoreCase("Edge")) {
			clickElement(editButton, "EDIT BUTTON", 20);
			editFirstName.clear();
			sendKeys(editFirstName, "FIRST NAME", fname);
			editLastName.clear();
			sendKeys(editLastName, "LAST NAME", lname);
			waitUntilElementIsVisible(editBillingCountry, 20);
			selectvalueWithText(editBillingCountry, country1);
			editBillingCode.clear();
			sendKeys(editBillingCode, "POSTCODE", postcode1);
			robotTab(editBillingCode, 20);
			editBillingCity.clear();
			sendKeys(editBillingCity, "SUBURB CITY", city1);
			selectvalueWithText(editBillingState, state1);
			billingAddress1.clear();
			sendKeys(billingAddress1, "ADDRESS LINE 1", address11);
			editBillingAddress2.clear();
			sendKeys(editBillingAddress2, "ADDRESS LINE 2", address22);
			editBillingPhoneNumber.clear();
			sendKeys(editBillingPhoneNumber, "PHONE NUMBER", phoneno1);
			clickElement(updatePayment, "UPDATE PAYMENT", 20);
			verifyTextWithElement(paymentMethod, "Payment method");
		}
	}

	public void addNewPaymentIOS(String creditcardno, String expirydate, String cvv, String nameoncard,
			String firstname, String lastname, String country, String postcode, String city, String state,
			String address1, String address2, String phoneno) throws IOException, InterruptedException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {

			waitUntilElementIsVisible(addNewPaymentMethod, 20);
			clickElement(addNewPaymentMethod, "ADD NEW PAYMENT METHOD", 20);
			sendKeys(creditCardNumber, "CREDIT CARD NUMBER", creditcardno);
			sendKeys(expiryDate, "EXPIRY DATE", expirydate);
			sendKeys(cvvInput, "CVV", cvv);
			sendKeys(nameOnCard, "NAME ON CARD", nameoncard);

			clickOnDefaultPayment();
			scroll(500);
			waitUntilElementIsVisible(newFirstName, 10);
			sendKeys(newFirstName, "FIRST NAME", firstname);
			sendKeys(newLastName, "LAST NAME", lastname);

			clickElement(newBillingCountry, "COUNTRY", 10);
			selectCountryIOS(country);
			scroll(200);
			sendKeys(newBillingPostalCode, "POSTCODE", postcode);
			sendKeys(newBillingCity, "SUBURB CITY", city);
			waitUntilElementIsVisible(newBillingState, 20);

			clickElement(newBillingState, "STATE", 10);
			selectingStateIOS(state);
			scroll(200);
			sendKeys(newBillingAddressLine1, "ADDRESS LINE 1", address1);
			sendKeys(newBillingAddressLine2, "ADDRESS LINE 2", address2);
			sendKeys(newBillingPhoneNumber, "PHONE NUMBER", phoneno);
			clickElement(addPaymentText, "ADD PAYMENT", 20);
			Thread.sleep(2000);
			verifyTextWithElement(paymentMethod, "Payment method");
		}
	}

	public void addNewPaymentChrome(String creditcardno, String expirydate, String cvv, String nameoncard,
			String firstname, String lastname, String country, String postcode, String city, String state,
			String address1, String address2, String phoneno) throws IOException, InterruptedException {
		if (driverInstance.equalsIgnoreCase("Chrome") || driverInstance.equalsIgnoreCase("Edge")) {
			waitUntilElementIsVisible(addNewPaymentMethod, 20);
			clickElement(addNewPaymentMethod, "ADD NEW PAYMENT METHOD", 20);
			sendKeys(creditCardNumber, "CREDIT CARD NUMBER", creditcardno);
			sendKeys(expiryDate, "EXPIRY DATE", expirydate);
			sendKeys(cvvInput, "CVV", cvv);
			sendKeys(nameOnCard, "NAME ON CARD", nameoncard);

			clickOnDefaultPayment();
			waitUntilElementIsVisible(newFirstName, 10);
			sendKeys(newFirstName, "FIRST NAME", firstname);
			sendKeys(newLastName, "LAST NAME", lastname);
			waitUntilElementIsVisible(newBillingCountry, 20);
			selectvalueWithText(newBillingCountry, country);
			sendKeys(newBillingPostalCode, "POSTCODE", postcode);
			sendKeys(newBillingCity, "SUBURB CITY", city);
			waitUntilElementIsVisible(newBillingState, 20);
			selectvalueWithText(newBillingState, state);
			sendKeys(newBillingAddressLine1, "ADDRESS LINE 1", address1);
			sendKeys(newBillingAddressLine2, "ADDRESS LINE 2", address2);
			sendKeys(newBillingPhoneNumber, "PHONE NUMBER", phoneno);
			clickElement(addPaymentText, "ADD PAYMENT", 20);
			verifyTextWithElement(paymentMethod, "Payment method");
		}
	}

	public void clickOnBestsellers() throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(1000);
			clickJSButton(bestsellerIos, "BESTSELLERS");
		} else {
			Thread.sleep(20000);
			clickElement(bestsellers, "BESTSELLERS");
		}
	}

	public void clickOnShopAll() throws InterruptedException, IOException {

		Thread.sleep(20000);
		clickElement(shopAll, "SHOP ALL");
	}

	public void clickOnProduct() throws IOException, InterruptedException {
		if (driverInstance.equalsIgnoreCase("Mac")) {
			Thread.sleep(5000);
			clickJSButton(facialTreatmentEssenceProductChrome, "FACIAL_TREATMENT_ESSENCE_PRODUCT", 10);
			Thread.sleep(5000);
			clickJSButton(addToBagIos, "ADD TO BAG", 10);
		} else {
			Thread.sleep(5000);
			waitUntilElementIsVisible(addToBag, 20);
			clickElement(addToBag, "ADD TO BAG");
		}
	}

	public void clickOnNonVariantProduct() throws IOException, InterruptedException {
		Thread.sleep(5000);
		waitUntilElementIsVisible(addToBag, 20);
		clickJSButton(addToBag, "ADD TO BAG");
	}

	public void clickOnSkinPowder() throws IOException, InterruptedException {

		waitUntilElementIsVisible(skinPowderAiryMilkyLotion, 60);
		clickJSButton(skinPowderAiryMilkyLotion, "Clicked on skinPowderAiryMilkyLotion");
		Thread.sleep(5000);
		clickJSButton(skin_addToBagIos, "ADD TO BAG", 10);
	}

	public void clickProduct() throws IOException, InterruptedException {

		Thread.sleep(10000);
		clickJSButton(facialTreatementEsscence, "PRODUCT_PITERA_ESSENCE");

	}

	public void clickAWProduct() throws IOException, InterruptedException {

		Thread.sleep(10000);
		clickJSButton(piteraEssenceAndyWarhol, "PRODUCT_PITERA_ESSENCE_ANDY_WARHOL");
	}

	public void clickProduct1() throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("Mac")) {
			Thread.sleep(10000);
			scroll(500);
			Thread.sleep(10000);
			waitUntilElementIsVisible(productSkinPowderEyeMac, 40);
			clickJSButton(productSkinPowderEyeMac, "Skin Power Eye Cream", 40);
		} else {
			scroll(500);
			clickElement(productSkinPowderEye, "PRODUCT_SKINPOWDEREYE");
		}
	}

	public void clickProductFEK() throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver") || driverInstance.equalsIgnoreCase("Mac")) {
			Thread.sleep(2000);
			clickJSButton(firstExperienceKitProductIos, "PRODUCT_First_Experience_KIT");
		} else {
			Thread.sleep(1000);
			clickElement(productFirstExperienceKit, "PRODUCT_First_Experience_KIT");
		}
	}

	public void clickFloatingBubbleComponent() throws IOException, InterruptedException {
		clickElement(floatingBubbleComponent, "FLOATING_BUBBLE_COMPONENT");
	}

	public void clickStorePolicy() throws IOException, InterruptedException {
			Thread.sleep(10000);
			scrollBottomPage();
			Thread.sleep(10000);
			scrollUpPage();
			Thread.sleep(10000);
			clickJSButton(storePolicyElement, "STORE_POLICY");
	
	}

	public void verifyOurBestseller() throws IOException, InterruptedException {
		Thread.sleep(5000);
		waitUntilElementIsVisible(ourBestseller, 30);
		verifyTextWithElement(ourBestseller, "Ourbestsllers");
	}

	public void verifyAwardModuleTitle() throws InterruptedException, IOException {
		Thread.sleep(10000);
		scrollBottomPage();
		Thread.sleep(10000);
		scrollUpPage();
		Thread.sleep(10000);
		verifyTextWithElement(awardModuleTitle, "Award-winning Skincare");
		if (glamourLogo.isDisplayed()) {
			LoggerLoad.info("Image displayed.");
		} else {
			LoggerLoad.error("Image not displayed.");
		}

		verifyTextWithElement(awardGlamour, "2020 Glamour Beauty Awards");
		if (bazaarLogo.isDisplayed()) {
			LoggerLoad.info("Image displayed.");
		} else {
			LoggerLoad.error("Image not displayed.");
		}
		verifyTextWithElement(awardBaazar, "2020 Anti-Aging Awards");
	}

	public void bestsellerComponents() throws IOException, InterruptedException {
		Thread.sleep(5000);
		waitUntilElementIsVisible(facialTreatementEsscence, 30);
		verifyTextWithElement(facialTreatementEsscence, "Facial Treatment Essence");
		scrollBottomPage();
		Thread.sleep(10000);
		scrollUpPage();
		Thread.sleep(10000);
		verifyTextWithElement(productFirstExperienceKit, "First Experience Kit");
		verifyTextWithElement(newPiteraPowerKit, "New PITERA™ Power Kit");
		verifyTextWithElement(piteraAuraKitIos, "PITERA™ Essence Andy Warhol Limited Edition");
		verifyTextWithElement(skinpowderCream, "SKINPOWER Cream");
		verifyTextWithElement(facialTreatmentMask, "Facial Treatment Mask");
		verifyTextWithElement(skinpowerAiryMilkyLotion, "SKINPOWER Airy Milky Lotion");
		verifyTextWithElement(genopticsAuraEssenceSerum, "GenOptics Aura Essence Serum");
		verifyTextWithElement(skinpowerEssence, "SKINPOWER Essence");
	}

	public void storePolicy() throws IOException, InterruptedException {
			Thread.sleep(5000);
			verifyTextWithElement(policyAgreementTxt, "SK-II Policies Agreement");
			verifyTextWithElement(policyIntroTxt, "Introduction and Acceptance of Terms");
	}

	public void clickAiryMilkyLotionProduct() throws IOException, InterruptedException {
		clickElement(skinpowerAiryMilkyLotion, "PRODUCT_PITERA_ESSENCE");
	}

	public void clickLearnMore() throws IOException, InterruptedException {
		Thread.sleep(5000);
		clickElement(giftLearnMore, "Learn More");
	}

	public void verifyShopNow() throws IOException, InterruptedException {
		Thread.sleep(5000);
		verifyTextWithElement(giftShopNow, "Shop Now");
	}

	public void clickOnDefaultPayment() throws IOException, InterruptedException {
		waitUntilElementIsVisible(defaultPaymentMethods, 20);
		clickElement(defaultPaymentMethods, "DEFAULT_PAYMENT_CHECKBOX CARD", 30);
	}

	public void locationEnable() throws InterruptedException, IOException {
		deleteMethod(0);
	}

	public void locationDisable() throws InterruptedException, IOException {
		dontAllow(0);
	}

	public void dontAllow(int n) throws InterruptedException, IOException {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			Thread.sleep(1000);
			DriverFactory.getmDriver().context("NATIVE_APP");
			Thread.sleep(3000);
			waitUntilElementIsVisible(DriverFactory.getmDriver()
					.findElement(By.xpath("//*[@class='UIAView' and @width>0 and ./*[@text='Don’t Allow']]")), 40);
			for (int i = 0; i <= n; i++) {
				Thread.sleep(2000);
				DriverFactory.getmDriver()
						.findElement(By.xpath("//*[@class='UIAView' and @width>0 and ./*[@text='Don’t Allow']]"))
						.click();
			}
			Thread.sleep(5000);
			DriverFactory.getmDriver().context("WEBVIEW_1");
		}

	}

	public void selectCountryIOS(String country) {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			DriverFactory.getmDriver().context("NATIVE_APP");
			DriverFactory.getmDriver().findElement(By.className("XCUIElementTypePickerWheel")).setValue(country);
			DriverFactory.getmDriver()
					.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeButton' and @label='Done']")).click();
			DriverFactory.getmDriver().context("WEBVIEW_1");
		}
	}

	public void selectingStateIOS(String state) {
		if (driverInstance.equalsIgnoreCase("IOSDriver")) {
			DriverFactory.getmDriver().context("NATIVE_APP");
			DriverFactory.getmDriver().findElement(By.className("XCUIElementTypePickerWheel")).setValue(state);
			DriverFactory.getmDriver()
					.findElement(By.xpath("//*[@XCElementType='XCUIElementTypeButton' and @label='Done']")).click();
			DriverFactory.getmDriver().context("WEBVIEW_1");
		}
	}

	public void closingPopup() throws InterruptedException, IOException {

		if (driverInstance.equalsIgnoreCase("Mac")) {
			Thread.sleep(10000);
			switchingToiFrame(2);
			List<WebElement> element = DriverFactory.getRemoteWebDriver()
					.findElements(By.cssSelector("svg#closeIconSvg"));

			if (element.size() > 0) {
				DriverFactory.getRemoteWebDriver().findElement(By.cssSelector("svg#closeIconSvg")).click();
			}
			defaultContentFrame();
		} else {
			Thread.sleep(10000);
			switchingToiFrame(2);
			List<WebElement> elements = DriverFactory.getDriver().findElements(By.cssSelector("svg#closeIconSvg"));

			if (elements.size() > 0) {
				DriverFactory.getDriver().findElement(By.cssSelector("svg#closeIconSvg")).click();
			}
			defaultContentFrame();
		}
	}

}
