/*
 * @autor : Supun Mahawaththa
*/

package com.testautomation.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.testautomation.qa.utill.WebEventListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public TestBase() {
		// -------- ConfigFile Read ----------
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "/resources/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// -------- Driver Initialization ----------
	public static void Initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// Use Chromedriver Manager
			driver = WebDriverManager.chromedriver().create();
		} else if (browserName.equalsIgnoreCase("edge")) {
			// Use Edge Webdriver Manager
			driver = WebDriverManager.edgedriver().create();
		} else {
			System.out.println("Please Provide a Valid Browser Name");
		}
		// EventListnerHandler initialize
		e_driver = new EventFiringWebDriver(driver);
		// Create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	// -------- Commands Declaration --------

	// click
	public static void click(WebElement objectName) {
		try {

			objectName.click();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// type
	public static void type(WebElement objectName, String text) {
		try {
			objectName.sendKeys(text);
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// select
	public static void select(WebElement objectName, String ddValue) {
		try {
			Select dropdown = new Select(objectName);
			dropdown.selectByVisibleText(ddValue);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// getText
	public static String getText(WebElement objectName) {
		try {
			String text;
			text = objectName.getText();
			System.out.println(text);
			return text;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;

	}

	// jsGetText
	public static String jsGetText(WebElement objectName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			String text = (String) js.executeScript("return arguments[0].innerText;", objectName);
			System.out.println(text);
			return text;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	// verifyText
	public static void verifyText(WebElement objectName, String text) {

		try {
			String actualResult = objectName.getText().trim();
			Assert.assertEquals(actualResult, text, " '" + actualResult + " and " + text + ", both values are not matched!");
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// pause
	public static void pause(int waittime) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(waittime, TimeUnit.MILLISECONDS);
	}

	// explicitWait
	public static void explicitWait(int waittime, WebElement objectName) throws InterruptedException {

		// explicit wait - to wait for the compose button to be click-able
		WebDriverWait wait = new WebDriverWait(driver, waittime);
		wait.until(ExpectedConditions.visibilityOf(objectName));
	}

	// writeToReport
	public static void writeToLog(String text) {
		System.out.println(text);
	}

	// -------- Read Data Sheet-Start --------
	public static Object[][] readExcel(String filePath, String sheetName) throws IOException {
		FileInputStream file = new FileInputStream(filePath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet(sheetName);
		int rowCount = sheet.getLastRowNum();
		int column = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][column];

		for (int i = 1; i <= rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < column; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter formatter = new DataFormatter();
				String val = formatter.formatCellValue(cell);
				data[i - 1][j] = val;
			}

		}

		return data;
	}
}
