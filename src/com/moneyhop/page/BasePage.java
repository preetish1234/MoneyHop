package com.moneyhop.page;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;
import com.moneyhop.utils.FileFilterDateIntervalUtils;


public class BasePage {

	public static RemoteWebDriver driver;

	public BasePage(RemoteWebDriver driver) {

		
		PageFactory.initElements(driver, this);
		BasePage.driver = driver;
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

	}

	public static void reportPass(String passMsg) {
		com.moneyhop.sanityscripts.BaseTestWeb.test.log(Status.PASS, passMsg);
		takeScreenshot();
	}

	public static void reportFail(String failureMsg) throws Exception {

		// test.log(LogStatus.FAIL, failureMsg);
		takeScreenshot();
		Assert.fail(failureMsg);

	}

	public static void takeScreenshot() {

		String CURRENTPATH = "";
		switch (com.moneyhop.utils.MoneyHopConstants.OS) {
		case "Mac": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH_MAC;

			break;
		}
		case "Windows": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH;
			break;
		}
		}

		// decide the file name
		Date d = new Date();

		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = CURRENTPATH + screenshotFile;
		// take screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// add screenshot to report
		// test.log(LogStatus.INFO,"Snapshot below:
		// "+test.addScreenCapture(addScreenshot()));

	}


	public static String addScreenshot() {
		File scrFile = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(scrFile);
			byte[] bytes = new byte[(int) scrFile.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}

	public static void takeScreenshotvPlayback() {

		String CURRENTPATH = "";
		switch (com.moneyhop.utils.MoneyHopConstants.OS) {
		case "Mac": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH_MAC;

			break;
		}
		case "Windows": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH;
			break;
		}
		}
		// decide the file name
		Date d = new Date();

		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = CURRENTPATH + screenshotFile;
		// take screenshot
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * //add screenshot to report
		 * test.log(LogStatus.INFO,"Snapshot below: ("+screenshotFile+")"+
		 * test.addScreenCapture(path));
		 */
	}

	public static void logScreenshot() {
		String CURRENTPATH = "";
		switch (com.moneyhop.utils.MoneyHopConstants.OS) {
		case "Mac": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH_MAC;

			break;
		}
		case "Windows": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH;
			break;
		}
		}

		String screenshotFolder = CURRENTPATH;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sdf);
		FileFilterDateIntervalUtils filter = new FileFilterDateIntervalUtils("2017-04-04", "2050-01-20");
		File folder = new File(screenshotFolder);
		File files[] = folder.listFiles(filter);
		// date

		String fileName = files[files.length - 1].getName();

		String filename = screenshotFolder + fileName;
		System.out.println("File name-" + filename);
		// add screenshot to report
//		test.log(LogStatus.INFO,"Snapshot below: (fileName)"+
//				 test.addScreenCapture(filename));
	}

	

	public static void fullScreenshot() throws InterruptedException, AWTException, IOException {
		String CURRENTPATH = "";
		switch (com.moneyhop.utils.MoneyHopConstants.OS) {
		case "Mac": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH_MAC;

			break;
		}
		case "Windows": {
			CURRENTPATH = com.moneyhop.utils.MoneyHopConstants.SCREENSHOT_PATH;
			break;
		}
		}

		Date d = new Date();
		String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
		String path = CURRENTPATH + screenshotFile;
		Robot robot = new Robot();
		Rectangle rect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage src = robot.createScreenCapture(rect);
		File scrFile = new File(path);
		ImageIO.write(src, "png", scrFile);
		// add screenshot to report
		// test.log(LogStatus.INFO,"Snapshot below:
		// "+test.addScreenCapture(addScreenshotFull(scrFile)));

	}

	public static String addScreenshotFull(File file) throws AWTException, IOException {

		String encodedBase64 = null;
		FileInputStream fileInputStreamReader = null;
		try {
			fileInputStreamReader = new FileInputStream(file);
			byte[] bytes = new byte[(int) file.length()];
			fileInputStreamReader.read(bytes);
			encodedBase64 = new String(Base64.encodeBase64(bytes));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "data:image/png;base64," + encodedBase64;
	}
}