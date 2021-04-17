package com.moneyhop.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import com.moneyhop.page.BasePage;
import com.moneyhop.sanityscripts.BaseTestWeb;

/*************************************************************************************
 * Class : Utilities Purpose : This class is used for reusable functions across
 * the framework Remarks : none Author : Preetish 24th May 2020 - Last Modified
 * 
 **************************************************************************************/

public class UtilitiesWeb {

	public static DesiredCapabilities cap;
	public static String service_url;
	FileInputStream fin = null;
	public static FileReader reader;
	public static Properties PROP = null;
	public static File FILE;

	/**** Element isDisplayed or not ****/
	public static boolean isDisplayed(RemoteWebDriver driver, WebElement element, int sec) {
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		try {

			if (element.isDisplayed())
				return true;

		} catch (Exception e) {
			return false;

		}
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
		return true;
	}

	// explicit Wait method to wait for the element to be
	public static boolean explicitWaitVisible(RemoteWebDriver driver, WebElement element, int time) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		try {
			WebDriverWait wait = new WebDriverWait(driver, time);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (StaleElementReferenceException e) {
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		}
		return true;
	}

	/**** Explicit Wait UntilElementIsVisible ***/
	public static boolean waitUntilElementIsVisible(WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(BasePage.driver, timeOut);
			wait.until(ExpectedConditions.visibilityOf(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
		}
		return isElementEnabled;
	}

	// to create folder in specified path
	public static void createFolder(String foldPath) {
		File f = new File(foldPath);
		if (!f.exists()) {
			f.mkdirs();
		}
	}

	
	
	
	// Scroll to the Top of the Page. scrollTop renamed to scrollToTop
	public static void scrollToTop(RemoteWebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollTo(0,0)", "");
	}

	public static void scrollToParticularElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) Base_Test_Web_Utils.driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}

	/**** captureScreenshotWithName ***/
	public static String captureScreenshotWithName(RemoteWebDriver driver, String screenshotname) throws IOException {
		createFolder(MoneyHopConstants.SCREENSHOT_PATH);
		TakesScreenshot ts = (TakesScreenshot) driver;
		SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMMyyyy");
		Calendar cal = Calendar.getInstance();
		String sysdate1 = dateFormat.format(cal.getTime());
		SimpleDateFormat dateFormat1 = new SimpleDateFormat("HHmmss");
		String sysdate2 = dateFormat1.format(cal.getTime());
		screenshotname = screenshotname + sysdate1 + "/" + "/" + sysdate2 + UtilitiesWeb.getTimeStamp_sec() + ".png";
		File image = ts.getScreenshotAs(OutputType.FILE);
		String destpath = "";

		destpath = MoneyHopConstants.SCREENSHOT_PATH + screenshotname;

		File destPath = new File(destpath);
		FileUtils.moveFile(image, destPath);
		return destpath;
	}

	// wait_until_the_page_is_loaded should be renamed waitUntilPageLoaded
	public static void waitUntilPageLoaded() {
		Object status = "";

		while (!status.toString().equalsIgnoreCase("complete")) {

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (int i = 0; i < 3; i++) {
				JavascriptExecutor js = (JavascriptExecutor) Base_Test_Web_Utils.driver;
				status = js.executeScript("return document.readyState");
			}
		}
	}

	// To wait until the element is enabled. wait_until_elememt_is_enable renamed to
	// waitUntilElememtIsEnabled
	public static boolean waitUntilElememtIsEnabled(WebElement element, int timeOut) {
		boolean isElementEnabled;
		try {
			WebDriverWait wait = new WebDriverWait(BaseTestWeb.driver, timeOut);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			wait.pollingEvery(Duration.ofMillis(200));
			isElementEnabled = true;
		} catch (Exception e) {
			isElementEnabled = false;
			System.out.println("element " + element.toString() + "' is not enabled even after waiting for :" + timeOut
					+ " seconds.");
		}
		return isElementEnabled;
	}

	// Used to click on the WebElement using locator
	@SuppressWarnings("unused")
	public static void clickButton(WebElement element, int timeout) throws Exception {
		BaseTestWeb.logger.info("Clicking on the element " + element.toString());
		try {
			if (element == null) {
				System.out.println("No element is found with locator:" + element.toString());
			} else {
				if (waitUntilElementIsVisible(element, timeout)) {
					if (waitUntilElememtIsEnabled(element, timeout)) {
						element.click();
						BaseTestWeb.logger.info("Clicked on the element " + element.toString());
					} else {
						System.out.println("Element : " + element.toString() + " is not enabled even after waiting for"
								+ timeout + "secconds.");
					}
				} else {
					System.out.println("Element : " + element.toString() + " is not visible even after waiting for "
							+ timeout + "secconds.");
					System.out.println("Element : " + element.toString() + " is not visible even after waiting for "
							+ timeout + "secconds.");
				}
			}
		} catch (ElementClickInterceptedException ecie) {
			((JavascriptExecutor) Base_Test_Web_Utils.driver).executeScript("arguments[0].click();", element);
		}
	}

	public static FileReader loginCredentials(String propfilename) throws IOException {

		try {
			PROP = new Properties();
			String propUrl = System.getProperty("user.dir") + "\\src\\com\\AifMetrics\\Properties\\" + propfilename;
			FILE = new File(propUrl);
			reader = new FileReader(FILE);
			PROP.load(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return reader;
	}

	//get the SUITENAME
	public static String getSuiteName(ITestContext context) {
		return context.getCurrentXmlTest().getSuite().getName();
	}

	// To get the current time and date getTimeStamp_sec
	public static String getTimeStamp_sec() {
		String timeStamp = "";
		Date d = new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(d);
		timeStamp = timeStamp + c.get(Calendar.MONTH) + c.get(Calendar.DAY_OF_MONTH) + c.get(Calendar.HOUR)
				+ c.get(Calendar.MINUTE) + c.get(Calendar.SECOND);
		return timeStamp;
	}

	// To get current time
	public static String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

}
