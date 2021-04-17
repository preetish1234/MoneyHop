package com.moneyhop.sanityscripts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.moneyhop.utils.MoneyHopConstants;
import com.moneyhop.utils.Base_Test_Web_Utils;
import com.moneyhop.utils.UtilitiesWeb;


public class BaseTestWeb extends Base_Test_Web_Utils {
	// @Parameters({ "browserName" })
	// As of now we are not passing browser name from testNG , if required we will
	// uncomment the above line and also in testng.xml and pass "String browser" as
	// parameter to setup() below.
	public static String className = "";

	@BeforeSuite(alwaysRun = true)
	public void beforeSuite(ITestContext ctx) throws UnknownHostException {
		
		
		// @Preetish 
		if (MoneyHopConstants.KLOV_BAT_FLAG) {
			try {
				Runtime.getRuntime().exec("klov_run.bat");
			} catch (IOException e) {
				System.out.println("Couldnot start KLOV Server");
			}
		}

		// @Preetish Code Starts
		suiteName = ctx.getCurrentXmlTest().getSuite().getName() + " ";
		if ("class".equalsIgnoreCase(MoneyHopConstants.executionMode)) {

			initializeReportClassLevel(MoneyHopConstants.executionMode);
		} else {
			initializeReportSuiteLevel(MoneyHopConstants.executionMode);
			
		}

		
		//Log configuration is there
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String fileName = "ExecutionLog_" + timeStamp + ".log";
		String filePath = "";
		if (MoneyHopConstants.OS.equalsIgnoreCase("mac")) {
			filePath = "Set path" + fileName;

		} else {
			filePath = "C:\\Aif-Metrics-Automation-Logs\\" + fileName;
		}
		File f = new File(filePath);
		System.setProperty("log.file", filePath);
		System.setProperty("log.parent.path", f.getParent());
		System.setProperty("log.file.name", FilenameUtils.getBaseName(f.getName()));
		logger = LogManager.getRootLogger();
		logger.trace("Initializing the log file in before suit.");
		logger.trace("Executing the suite file : " + suiteName);
		// @Preetish code Starts
		try {
			if (MoneyHopConstants.REGRESSION_SHEET_UPDATE_FLAG) {
				//SheetUtils.startSheetService();
			} else {
				System.out.println("Regression Checklist Update is False");
			}
		} catch (Exception e) {
			System.out.println("Unable to Create Sheet Service");
		}
	}

	@BeforeTest(alwaysRun = true)
	public void beforeTest(ITestContext ctx) {
		logger.trace("Executing the test file : " + ctx.getCurrentXmlTest().getName());
		
	}

	
	@BeforeClass(alwaysRun = true)
	public void beforeClass(ITestContext ctx) {
		
		testName = ctx.getCurrentXmlTest().getSuite().getName() + " : " + ctx.getCurrentXmlTest().getName();
		logger.trace("Executing the class : " + this.getClass().getSimpleName());
		mainTest = report.createTest(testName + " : " + this.getClass().getSimpleName());
		mainTest.assignCategory(ctx.getCurrentXmlTest().getName());
		parent.set(mainTest);
		className = this.getClass().getName();

	}

	
	@BeforeMethod(alwaysRun = true)
	public void setup(Method testName, ITestResult result) throws InterruptedException {
	
		testCaseName = testName.getName();
		logger.trace("Executing the test case : " + testCaseName);
		test = mainTest.createNode(testCaseName);
		child.set(test);

	}

	@AfterMethod(alwaysRun = true)
	public void getResult(Method testName, ITestResult result) throws IOException {
		
		testCaseName = testName.getName();
		if (result.getStatus() == ITestResult.SUCCESS) {
			logger.trace("Test Case Pass : " + testCaseName);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			try {
				test.log(Status.FAIL, "Test Case Failed is " + testCaseName, MediaEntityBuilder
						.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName))
						.build());
			} catch (Exception e) {
				test.log(Status.INFO, "Unable to Take Screenshot");
			}
			test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
		} else if (driver == null) {
			test.log(Status.FAIL, "Test Case Failed is " + result.getTestName());
		} else {
			test.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
			logger.trace(
					"Completed the test case : " + testCaseName + " Having an exception of " + result.getThrowable());
		}

	

		if (report != null) {
			report.flush();
			logger.trace("Completed the class : " + testCaseName);
		}
	//	killProcess();
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() throws IOException {
		if (report != null) {
			report.flush();
			logger.trace("Completed the class : " + testCaseName);
			//killProcess();
		}
	}

	@AfterTest(alwaysRun = true)
	public void quitbrowser(ITestContext ctx) throws Exception {
		if (report != null) {
			report.flush();
		}
		logger.trace("Completed the test  : " + ctx.getCurrentXmlTest().getName());
		//killProcess();
	}

	@AfterSuite(alwaysRun = true)
	public void teardown(ITestContext ctx) throws Exception {
		
		suiteName = ctx.getCurrentXmlTest().getSuite().getName() + " ";
		Thread.sleep(1000);

		if (report != null) {
			report.flush();
			//killProcess();
		}

		if (MoneyHopConstants.Result) {
			try {
				//SendMailWeb.main(null);
				System.out.println(
						"Email was sent sucessfully, because Result flag in Voot Constants was" + MoneyHopConstants.Result);
			} catch (Exception e) {
				System.out.println("Email was not sent, because there was some Exceptions");
			}
		} else {
			System.out.println("Email was not sent, because Result flag in Voot Constants was" + MoneyHopConstants.Result);
		}
		logger.trace("Execution has been completed for the : " + suiteName);
	}

}
