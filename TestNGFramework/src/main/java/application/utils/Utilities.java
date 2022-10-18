package application.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;

public class Utilities extends Initialization {

	private Utilities() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Method to get config data from properties file for the specified key
	 * 
	 * @param key
	 * @return String value of the property
	 * @throws IOException
	 * @author M1008242
	 */
	public static String getConfigData(String key) throws IOException {

		Properties prop = readPropertiesFile(".\\Properties\\Config.properties");
		if (prop != null) {
			return prop.getProperty(key).trim();
		} else {
			return "Property value is null";
		}

	}

	/**
	 * Method to read properties file for the specified file
	 * 
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	public static Properties readPropertiesFile(String fileName) throws IOException {

		Properties prop = null;
		try (FileInputStream fis = new FileInputStream(fileName)) {
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException fnfe) {
			LoggerLoad.error(fnfe.getMessage());
		} catch (IOException ioe) {
			LoggerLoad.error(ioe.getMessage());
		}
		return prop;

	}

	/**
	 * Method to get current system date and time for the specified format
	 * 
	 * @param format of date to be returned
	 * @return String form of date for the specified date format
	 * @author M1008242
	 */
	public static String getDate(String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date();
		return formatter.format(date);
	}

	/**
	 * Method to trigger email with attached report
	 * 
	 * @param reportPath - path of the report to be sent
	 * @throws IOException
	 * @author M1039188
	 */

	/**
	 * Method to get the application URL for the specified environemnt type
	 * 
	 * @param environment
	 * @return URL details after reading from prooperties file
	 * @throws IOException
	 * @author M1008242
	 */
	public static String getUrlFromPropery(String environment) throws IOException {

		switch (environment) {

		case "UAT":
			return Utilities.getConfigData("uat");

		case "CERT":
			return Utilities.getConfigData("cert");

		case "PROD":
			return Utilities.getConfigData("prod");

		default:
			return Utilities.getConfigData("qa");
		}
	}

	/**
	 * Method to delete the existing folder for setup
	 * 
	 * @param folderPath
	 * @author M1008242
	 * @throws IOException
	 */
	public static void deleteScreenshotFolder(String folderPath) throws IOException {

		LoggerLoad.info("Checking existance of " + folderPath + " folder for the session run");
		File file = new File(folderPath);
		if (file.exists()) {
			FileUtils.deleteDirectory(new File(folderPath));
			LoggerLoad.info("Folder " + folderPath + " exists and is deleted");
		} else {
			LoggerLoad.info("Folder " + folderPath + " does not exists");
		}
	}

	/**
	 * Method to enter the text in the specified input field
	 * 
	 * @param webElement
	 * @param textToEnter
	 * @author M1008242
	 */
	public static void enterText(WebElement webElement, String textToEnter) {

		LoggerLoad.info("Entering " + textToEnter + " in specified field");
		webElement.sendKeys(textToEnter);
		LoggerLoad.info("Entered " + textToEnter + " in the specified field");
	}

}
