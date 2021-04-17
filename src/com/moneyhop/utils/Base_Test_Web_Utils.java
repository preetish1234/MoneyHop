package com.moneyhop.utils;

import java.net.InetAddress;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import com.moneyhop.page.BasePage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.Protocol;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Base_Test_Web_Utils {


	public static RemoteWebDriver driver;
	public static ExtentHtmlReporter reporter;
	public static ExtentReports report;
	public static ExtentTest mainTest;
	public static ExtentTest test;
	public static Status status;
	public static Properties prop;
	public static FileReader reader;
	public String testName;
	public String testCaseName;
	public String suiteName;
	public static Logger logger;
	public static InetAddress systemAddress;
	public static File file;
	public static String report_filePath;
	public static DesiredCapabilities capabilities;
	public static String mainWindow;
	DesiredCapabilities cap;
	public  ThreadLocal<ExtentTest> parent = new ThreadLocal<ExtentTest>();
	public  ThreadLocal<ExtentTest> child = new ThreadLocal<ExtentTest>();
	
	@SuppressWarnings("deprecation")
	public  static void launchWeb(String os_Type, String bType) throws Exception {

		// To Launch the browser and navigate to url
		if ((MoneyHopConstants.PROJECT).equalsIgnoreCase("WEB")) {
			if (os_Type.equalsIgnoreCase("Mac")) {
				switch (bType.toLowerCase()) {
				case "Firefox":
					// WebDriverManager.firefoxdriver().setup();
					// FirefoxProfile ffprofile = new FirefoxProfile();
					// ffprofile.setPreference("dom.webnotifications.enabled", false);
					driver = new FirefoxDriver();
					break;
				case "chrome":
					/*
					 * ChromeOptions options = new ChromeOptions();
					 * 
					 * options.addArguments("--disable-notifications"); driver= new
					 * ChromeDriver(options);
					 */
					WebDriverManager.chromedriver().setup();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("--disable-notifications");
					// DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					// capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					// capabilities.setCapability("pageLoadStrategy", "normal");
					driver = new ChromeDriver(options);
					driver.manage().window().maximize();
					driver.manage().deleteAllCookies();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);

					capabilities.setCapability("requireWindowFocus", true);
					driver = new InternetExplorerDriver();
					driver.manage().window().maximize();
					break;
				case "safari":

					// System.setProperty("webdriver.ie.driver", VootConstantsWeb.IE_DRIVER_EXE);
					// FirefoxProfile ffprofile = new FirefoxProfile();
					// ffprofile.setPreference("dom.webnotifications.enabled", false);
					Runtime.getRuntime().exec("killall safaridriver");
					capabilities = DesiredCapabilities.safari();
					// capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
					// true);
					capabilities.setCapability("requireWindowFocus", true);
					driver = new SafariDriver(capabilities);
					driver.manage().window().maximize();
					break;
				default:
					Assert.assertTrue(false,
							"Given OS : '" + os_Type + "'or Given Browser :'" + bType + "' is invalid");
					break;
				}
			} else if (os_Type.equalsIgnoreCase("windows")) {
				switch (bType.toLowerCase()) {
				
				
					
				case "firefox":

					
					
					  WebDriverManager.firefoxdriver().setup(); 
					  // FirefoxProfile ffprofile = new FirefoxProfile();
					  // ffprofile.setPreference("dom.webnotifications.enabled",false); 
					  driver = new FirefoxDriver();
					 
					 
					
					
					/*
					 * cap = DesiredCapabilities.firefox();
					 * cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
					 */
					 

									
					break;
				
				case "chrome":
					
					
					
					/*
					 * cap = DesiredCapabilities.chrome();
					 * 
					 * cap.setCapability(CapabilityType.BROWSER_NAME,BrowserType.CHROME);
					 * cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
					 * 
					 * ChromeOptions options1 = new ChromeOptions();
					 * options1.addArguments("disable-infobars");
					 * options1.addArguments("--start-maximized");
					 * options1.addArguments("--disable-notifications"); options1.merge(cap);
					 */
					 
					   	
					  
					  //System.setProperty("webdriver.chrome.driver", VootConstants.CHROME_DRIVER_EXE);
					
					
					  WebDriverManager.chromedriver().setup(); 
					  ChromeOptions options = new ChromeOptions(); 
					  // options.addArguments("--start-maximized");
					  //options.addArguments("--headless");
					  options.addArguments("--disable-notifications"); // DesiredCapabilities
					  capabilities = DesiredCapabilities.chrome(); //
					  capabilities.setCapability(ChromeOptions.CAPABILITY, options); //
					  capabilities.setCapability("pageLoadStrategy", "normal"); 
					  driver = new ChromeDriver(options);
					 
					 
					 
			
					break;
				
				case "ie":
					WebDriverManager.iedriver().setup();
					// FirefoxProfile ffprofile = new FirefoxProfile();
					// ffprofile.setPreference("dom.webnotifications.enabled", false);
					capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);

					capabilities.setCapability("requireWindowFocus", true);
					driver = new InternetExplorerDriver(capabilities);
					driver.manage().window().maximize();
					break;
				case "safari":
					System.setProperty("webdriver.ie.driver", MoneyHopConstants.IE_DRIVER_EXE);
					// FirefoxProfile ffprofile = new FirefoxProfile();
					// ffprofile.setPreference("dom.webnotifications.enabled", false);
					DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
					capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
							true);

					capabilities.setCapability("requireWindowFocus", true);
					driver = new InternetExplorerDriver(capabilities);

					driver.manage().window().maximize();
					break;
				default:
					Assert.assertTrue(false,
							"Given OS : '" + os_Type + "'or Given Browser :'" + bType + "' is invalid");
					break;
				}
			}
			
			
			
			/*
			 * URL url = new URL("http://192.168.42.102:4444/wd/hub"); driver = new
			 * RemoteWebDriver(url,cap);
			 */
			 
			 
			
			driver.manage().window().maximize();
			
			UtilitiesWeb.waitUntilPageLoaded();

			driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);

			try {
				driver.get(MoneyHopConstants.URL);
				UtilitiesWeb.waitUntilPageLoaded();
			} catch (TimeoutException e) {
				try {
					
					driver.navigate().to(MoneyHopConstants.URL);
					UtilitiesWeb.waitUntilPageLoaded();
				} catch (TimeoutException ex) {

					try {
						driver.navigate().to(MoneyHopConstants.URL);
						UtilitiesWeb.waitUntilPageLoaded();
					} catch (TimeoutException exe) {
						BasePage.reportFail("Page is not loaded for long time ");
					}
				}
			}
			UtilitiesWeb.waitUntilPageLoaded();
//		test.log(status.INFO, "Opened Voot successfully in -browser " + bType);
		}

		// To load and read the property files

	}

	public static FileReader loadPropertyFile(String propfilename) throws Exception {
		if (MoneyHopConstants.OS.equalsIgnoreCase("mac")) {
		
			prop = new Properties();
			String propUrl = System.getProperty("user.dir") + "/src/com/AifMetrics/Properties/" + propfilename;
			System.out.println();
			file = new File(propUrl);
			reader = new FileReader(file);

		} else {
			
			try {
				prop = new Properties();
				String propUrl = System.getProperty("user.dir") + "\\src\\com\\AifMetrics\\Properties\\" + propfilename;
				file = new File(propUrl);
				reader = new FileReader(file);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reader;
	}

	// To generate the report at class level
	public void initializeReportClassLevel(String executionType) throws UnknownHostException {

		if (MoneyHopConstants.OS.equalsIgnoreCase("mac")) {
			UtilitiesWeb.createFolder(MoneyHopConstants.REPORT_PATH_MAC + "//Class//");
			report_filePath = MoneyHopConstants.REPORT_PATH_MAC + "//Class//" + MoneyHopConstants.PROJECT + "_"
					+ MoneyHopConstants.USERTYPE + "_" + MoneyHopConstants.environment + "_" + MoneyHopConstants.browser + "_"
					 + getTimeStamp() + ".html";
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();
		} else {
			UtilitiesWeb.createFolder(MoneyHopConstants.REPORT_PATH + "//Class//");
			report_filePath = MoneyHopConstants.REPORT_PATH + "//Class//" + MoneyHopConstants.PROJECT + "_"
					+ MoneyHopConstants.USERTYPE + "_" + MoneyHopConstants.environment + "_" + MoneyHopConstants.browser + "_"
					+ getTimeStamp() + ".html";
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();
		}
	}

	// To generate the report at suite level
	public void initializeReportSuiteLevel(String name) throws UnknownHostException {
		if (MoneyHopConstants.OS.equalsIgnoreCase("mac")) {
			UtilitiesWeb.createFolder(MoneyHopConstants.REPORT_PATH_MAC + "//Suite//");
			report_filePath = MoneyHopConstants.REPORT_PATH_MAC + "//Suite//" + MoneyHopConstants.PROJECT + "_"
					+ MoneyHopConstants.USERTYPE + "_" + MoneyHopConstants.environment + "_" + MoneyHopConstants.browser + "_"
					+ name + "_" + ".html";
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();

		} else {
			UtilitiesWeb.createFolder(MoneyHopConstants.REPORT_PATH + "//Suite//");
			report_filePath = MoneyHopConstants.REPORT_PATH + "//Suite//" + MoneyHopConstants.PROJECT + "_"
					+ MoneyHopConstants.USERTYPE + "_" + MoneyHopConstants.environment + "_" + MoneyHopConstants.browser + "_"
					+ name + "_" + ".html";
			reporter = new ExtentHtmlReporter(report_filePath);
			reportConfigurations();
		}

	}

	// Configure report with Klov
	public void reportConfigurations() throws UnknownHostException {
		reporter.setAppendExisting(true);
		reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setDocumentTitle("AifMetrics_Web " + suiteName + MoneyHopConstants.browser);
		reporter.config().setProtocol(Protocol.HTTPS);
		reporter.config().setEncoding("UTF-8");
		reporter.config().setTheme(Theme.DARK);
		reporter.config().setReportName("Suite_" + MoneyHopConstants.browser + getTimeStamp());
		report = new ExtentReports();
		// Amresh Code starts
		if (MoneyHopConstants.KLOV_FLAG) {
			KlovReporter klovReporter = new KlovReporter();
			klovReporter.initMongoDbConnection("192.168.12.73", 27017);
			klovReporter.setProjectName(MoneyHopConstants.EMAIL_SUBJECT);
			klovReporter.setReportName(suiteName);
			klovReporter.setKlovUrl("http://192.168.12.73/");
			report.attachReporter(klovReporter, reporter);
		} else {
			report.attachReporter(reporter);
		}
		// Amresh Code ends

		report.setReportUsesManualConfiguration(true);

		systemAddress = Inet4Address.getLocalHost();

		report.setSystemInfo("IP Address", systemAddress.getHostAddress());
		report.setSystemInfo("Host Name", systemAddress.getHostName());
		report.setSystemInfo("UserName", System.getProperty("user.name"));
		report.setSystemInfo("Operating System", System.getProperty("os.name"));
	}

	// To Kill the crome browser
	public void killProcess() throws IOException {
		if (driver != null) {
			if (MoneyHopConstants.OS.equalsIgnoreCase("windows")) {
				// driver.quit();
				try {
					driver.quit();
				} catch (Exception e) {
				}
			}
			if (MoneyHopConstants.OS.equals("Mac")) {
				try {
					driver.quit();
				} catch (Exception e) {
				}
			}
		}
	}

	// To get current time
	public static String getTimeStamp() {
		Date d = new Date();
		return d.toString().replace(":", "_").replace(" ", "_");
	}

	public static void main(String[] args) {
		String name = "ie";
		String report_filePath = MoneyHopConstants.REPORT_PATH_MAC + "\\Suite\\" + "Suite_" + MoneyHopConstants.browser + "_"
				+ name + "_" + ".html";
		System.out.println(report_filePath);
	}
}

