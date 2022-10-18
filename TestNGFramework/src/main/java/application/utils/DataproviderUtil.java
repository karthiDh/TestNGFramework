package application.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class DataproviderUtil extends BaseClass {

	private DataproviderUtil() {
		throw new IllegalStateException("DataProvider Utility class");
	}

	static String filePath;
	static Sheet sheet;
	static int TestCaseRowNum = 0;

	public static Object[][] testDataSupplier(String TestCaseName) throws IOException {

		filePath = ".\\Data\\DemoData.xlsx";
		File testDataFile = new File(filePath);
		Workbook wb = WorkbookFactory.create(testDataFile);
		sheet = wb.getSheet("Testdata");
		Object[][] obj = null;
		for (int i = 1; i <= getRowCount(); i++) {
			if ((sheet.getRow(i).getCell(0).toString()).equals(TestCaseName)) {
				TestCaseRowNum = i;
				HashMap<String, String> testData = dataSupplier(TestCaseRowNum);
				obj = new Object[1][1];
				obj[0][0] = testData;
				break;
			}
		}
		return obj;
	}

	public static HashMap<String, String> dataSupplier(int rowNum) throws IOException {

		HashMap<String, String> hm = new HashMap<String, String>();
		DataFormatter df = new DataFormatter();
		for (int i = 0; i < sheet.getRow(0).getLastCellNum(); i++) {
			hm.put(df.formatCellValue(sheet.getRow(0).getCell(i)).toString(),
					df.formatCellValue(sheet.getRow(rowNum).getCell(i)).toString());
		}
		return hm;
	}

	public static int getRowCount() {
		return sheet.getLastRowNum();
	}

	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	@DataProvider
	public static Object[][] validateEmailAddressNotPrePopulated() throws IOException {
		return testDataSupplier("validateEmailAddressNotPrePopulated");
	}

	@DataProvider
	public static Object[][] placeOrder_withValid_visaCard() throws IOException {
		return testDataSupplier("placeOrder_withValid_visaCard");
	}

	@DataProvider
	public static Object[][] placeOrder_withValid_masterCard() throws IOException {
		return testDataSupplier("placeOrder_withValid_masterCard");
	}

	@DataProvider
	public static Object[][] placeOrder_withValid_discoverCard() throws IOException {
		return testDataSupplier("placeOrder_withValid_discoverCard");
	}

	@DataProvider
	public static Object[][] placeOrder_withValid_amexCard() throws IOException {
		return testDataSupplier("placeOrder_withValid_amexCard");
	}

	@DataProvider
	public static Object[][] placeOrder_withValid_jcbCard() throws IOException {
		return testDataSupplier("placeOrder_withValid_jcbCard");
	}

	@DataProvider
	public static Object[][] placeOrder_withValid_dinnerClubCard() throws IOException {
		return testDataSupplier("placeOrder_withValid_dinnerClubCard");
	}

	@DataProvider
	public static Object[][] invalid_credit_number_and_expiry() throws IOException {
		return testDataSupplier("invalid_credit_number_and_expiry");
	}

	@DataProvider
	public static Object[][] empty_credit_cardNumber_expiry_CVV() throws IOException {
		return testDataSupplier("empty_credit_cardNumber_expiry_CVV");
	}

	@DataProvider
	public static Object[][] deliveryMethod_standardDelivery() throws IOException {
		return testDataSupplier("deliveryMethod_standardDelivery");
	}

	@DataProvider
	public static Object[][] deliveryMethod_rushDelivery() throws IOException {
		return testDataSupplier("deliveryMethod_rushDelivery");
	}

	@DataProvider
	public static Object[][] deliveryMethod_expeditedDelivery() throws IOException {
		return testDataSupplier("deliveryMethod_expeditedDelivery");
	}

	@DataProvider
	public static Object[][] verifyDetails_displayedIn_orderConfirmationScreen() throws IOException {
		return testDataSupplier("verifyDetails_displayedIn_orderConfirmationScreen");
	}

	@DataProvider
	public static Object[][] defaultDeliveryMethod_forStateHawaii() throws IOException {
		return testDataSupplier("defaultDeliveryMethod_forStateHawaii");
	}

	@DataProvider
	public static Object[][] defaultDeliveryMethod_forStateAlaska() throws IOException {
		return testDataSupplier("defaultDeliveryMethod_forStateAlaska");
	}

}