package com.moneyhop.utils;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.remote.RemoteWebDriver;

/*************************************************************************************
 * Class : GlobalVariables Author : Preetish Purpose : This class is used for
 * storing all the global constants
 **************************************************************************************/

public class MoneyHopConstants {

	/*************************************************************************************
	 * 1.0 If using Windows Machine, Comment Mac os, if using Mac Machine, comment
	 * Windows os.
	 **************************************************************************************/

	public static String OS = "Windows";
//		public static String OS = "Mac";

	/**************************************************************************************
	 * 2.0 Comment out the browsers that you are not running on.
	 **************************************************************************************/

	public static String browser = "Chrome";
//	public static String browser = "firefox";
//	public static String browser="Safari";

	/*************************************************************************************
	 * 4.0 Below is the Environment and the URLs that you are planning to run the
	 * Suite or Class.
	 **************************************************************************************/
	public static String URL = "http://www.moneyhop.co/send/";public static boolean apiURLs_uatFlag = false; public static String environment = "DevTest";
//   public static String URL = "https://dev.aifmetrics.com/";public static boolean apiURLs_uatFlag = false; public static String environment = "Dev";
//	public static String URL = "https://prodgold.aifmetrics.com/";public static boolean apiURLs_uatFlag = false; public static String environment = "Prod";
	/*************************************************************************************
	 * 4.1 Select the type of user that you want to run the whole suite.
	 **************************************************************************************/
	public static boolean runflag = false;
	public static final String USERTYPE = "AMC";

	/*************************************************************************************
	 * 4.2 If you are running as a Class or Suite Comment the lines as necessary
	 * below.
	 **************************************************************************************/

//		If Running a single Class Uncomment Below Line.
//	    public static String executionMode = "class";
//		If Running in a Suite Uncomment Below Line
	public static String executionMode = Base_Test_Web_Utils.getTimeStamp();

	
	/*************************************************************************************
	 * 4.3 Change the below files as required for a Suite Run.
	 **************************************************************************************/
	public static String APP_VERSION = "1.3.8";
	public static String APP_VERSION_UAT = "1.3.6";
	public static final String HUB_URL = "http://127.0.0.1:4723/wd/hub";
	public static final String APPIUM_IPADDRESS = "127.0.0.1";
	public static final int PORT_NUMBER = 4724;
	public static final String XLS_PATH = System.getProperty("user.dir") + "//data//WebSuiteStatus.xlsx";
	public static final String REPORT_PATH_MAC = "/Users/ifocus/Desktop/Voot-V3-Web-Automation-Reports/report";
	public static final String SCREENSHOT_PATH_MAC = "/Users/ifocus/Desktop/Voot-V3-Web-Automation-Reports/screenshots";
	public static final String REPORT_PATH = "C:\\Aif-Metrics-Automation-Reports\\";
	public static final String SCREENSHOT_PATH = "C:\\Aif-Metrics-Automation-Reports-Screeenshots\\";
	public static final String REPORT_EMAIL_SUBJECT = "Automation reports from Web";
	public static RemoteWebDriver driver;
	public static String charleslogsName = "";
	public static String charlesName = "";
	public static String ipAdress = "";
	public static InetAddress localhost;
	public static String filePath = "";
	public static String filePathxml = "";
	public static String filePathlogs = "";
	public static String charleslogsNameDFP = "";
	public static String charlesNameDFP = "";
	public static String filePathxmlDFP = "";
	public static String filePathlogsDFP = "";
	public static final String AUTOMATION_NAME = "XCUITest";
	public static final String XCODE_ORG_ID = "7GZEJ5HA3G";
	public static String ipAddress;
	public static boolean Result = false;
	public static boolean vastCall = false;
	public static Map<String, String> SBUChannel = new HashMap<String, String>();
	public static String MP_EXCEL_EVENTS_PATH = ".//data//Mixpanel Report_Web.xlsx";
	public static ArrayList<String> MPProperties = new ArrayList<String>();
	public static String EventName = "";
	public static final String EMAIL_SUBJECT = "Voot_Web - Automation";
	public static final String sheet = "VOOT_USERS";
	public static String charlesResponse = "";
	public static final boolean KLOV_BAT_FLAG = false;
	public static final String EXCEL_PATHWEBV2 = ".//data//TestDataWeb.xlsx";
	public static final String CHROME_DRIVER_EXE = ".//drivers/chromedriver.exe";
	public static final String MOZILLA_DRIVER_EXE = ".//drivers/geckodriver.exe";
	public static final String IE_DRIVER_EXE = ".//drivers/IEDriverServer.exe";
	public static final String CHROME_DRIVER_DMG = ".//drivers/chromedriver";
	public static final String MOZILLA_DRIVER_DMG = ".//drivers/geckodriver.exe";
	public static final String IE_DRIVER_DMG = ".//drivers/IEDriverServer.exe";

	/*************************************************************************************
	 * 4.4 If you want to Update Voot Web Regression suite , you can make it True.
	 **************************************************************************************/

//		public static final boolean KLOV_FLAG = true; 
//		public static final boolean REGRESSION_SHEET_UPDATE_FLAG = true; public static String spreadsheetId = "1qzDeBQpc9y3YRUOVnQxHhE6yIgd0A5t_uqmI-6Za-N4";
	public static final boolean KLOV_FLAG = false;
	public static final boolean REGRESSION_SHEET_UPDATE_FLAG = false;
	public static String spreadsheetId = "1qzDeBQpc9y3YRUOVnQxHhE6yIgd0A5t_uqmI-6Za-N4";

	/*************************************************************************************
	 * 4.5 If you want to Update Voot Pwa Regression suite , you can make it True.
	 **************************************************************************************/

//		public static final boolean KLOV_FLAG = true; public static final boolean REGRESSION_SHEET_UPDATE_FLAG = true; public static String spreadsheetId = "1ba54sBZ-cg3PPwoGqDPmBnWf8nmu863jSb5C-sjRDog"; 	
//		public static final boolean KLOV_FLAG = false; public static final boolean REGRESSION_SHEET_UPDATE_FLAG = false; public static String spreadsheetId = "1ba54sBZ-cg3PPwoGqDPmBnWf8nmu863jSb5C-sjRDog"; 	

	/*************************************************************************************
	 * 5.0 Below Flags are Required for the PWA Project
	 **************************************************************************************/
	/*
	 * Note: You need to Download the latest version of ChromeDriver.exe and add to
	 * C:\Users\AppData\Roaming\npm\node_modules\appium\node_modules\appium-
	 * chromedriver\chromedriver\win
	 */
	/*************************************************************************************
	 * 6.0 If you are using a PWA device you need to comment web and vice versa.
	 **************************************************************************************/
//	public static String PROJECT= "PWA";
	public static String PROJECT = "WEB";

//		public static final String PLATFORM_NAME = "Android";
	public static final String PLATFORM_NAME = "iOS";
	/*************************************************************************************
	 * 7.0 Select the proper Node.exe path according to the system that you are
	 * working on
	 **************************************************************************************/
//		Windows
	public static final String NODEJS_PATH = "C:\\Program Files\\nodejs\\node.exe";
//		MAC
//		public static final String NODEJS_PATH = "/usr/local/bin/node";
	/*************************************************************************************
	 * 8.0 Select the proper Appium.JS paths based on the system that you are
	 * working on.
	 **************************************************************************************/
//		Mac
//		public static final String APPIUM_JS_PATH = "/Applications/Appium.app/Contents/Resources/app/node_modules/appium/build/lib/main.js";

	// Machine-Amresh Office/ Machine-4
//		public static final String APPIUM_JS_PATH = "C:\\Users\\IFOCUS\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	// Machine-3 - HUB
//		public static final String APPIUM_JS_PATH = "C:\\Users\\iFocus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	// Machine-Amresh Home
//		public static final String APPIUM_JS_PATH = "C:\\Users\\Amresh\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
	// Machine-4 - HARISH
	// public static final String APPIUM_JS_PATH =
	// "C:\\Users\\IFOCUS.DESKTOP-JHF0INJ\\node_modules\\appium\\build\\lib\\main.js";
	// Machine-1 - HUB
//		public static final String APPIUM_JS_PATH = "C:\\Users\\iFocus.IFOCUSODC-PC14\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
//		Machine-5 - Meenarani
//		public static final String APPIUM_JS_PATH = "C:\\Users\\ifocus\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

	// Preetish Laptop
	public static final String APPIUM_JS_PATH = "C:\\Users\\Preetish Kumar\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";

	/*************************************************************************************
	 * 9.0 Select the proper UDID based on the Device that you are working on.
	 **************************************************************************************/
//		OS 6
//		public static final String UDID = "CQFE99NN75ZPU8VC"; public static final String DEVICE_NAME = "Amresh-Lenovo"; public static final String DEVICE_VERSION = "6.0";
//		public static final String UDID = "E6HM7SBI6LAUVCEU"; public static final String DEVICE_NAME = "Lenovo-K3Note"; public static final String DEVICE_VERSION = "6.0";
//		public static final String UDID = "F9AZCY21V645"; public static final String DEVICE_NAME = "Amresh-Asus"; public static final String DEVICE_VERSION = "6.0.1";
//	 	public static final String UDID = "03496e5f438064ba"; public static final String DEVICE_NAME = "LG-Nexus"; public static final String DEVICE_VERSION = "6.0.1";
//		public static final String UDID = "4200a46cb468a267"; public static final String DEVICE_NAME = "Samsung-On5"; public static final String DEVICE_VERSION = "6.0.1";
	public static final String UDID = "420033e296b87447";
	public static final String DEVICE_NAME = "Galaxy On Max";
	public static final String DEVICE_VERSION = "8.1.0";
//		public static final String UDID = "ZY2235DZSQ";	public static final String DEVICE_NAME = "MotoGTurbo";	public static final String DEVICE_VERSION = "6.0.1";

//		OS 7
//		public static final String UDID = "ZW2225B6LM"; public static final String DEVICE_NAME = "Amresh-CPlus"; public static final String DEVICE_VERSION = "7.0";
//		public static final String UDID = "ZW2225DTSJ"; public static final String DEVICE_NAME = "Unusable-Moto-E4"; public static final String DEVICE_VERSION = "7.1.1";
//	 	public static final String UDID = "ZY322CF54R"; public static final String DEVICE_NAME = "Moto-G5S"; public static final String DEVICE_VERSION = "7.1.1";
//		public static final String UDID = "ZY32279CMM"; public static final String DEVICE_NAME = "Moto-G5SPlus"; public static final String DEVICE_VERSION = "7.1.1";
//		public static final String UDID = "MCCDU17207000772"; public static final String DEVICE_NAME = "Amresh-Honor"; public static final String DEVICE_VERSION = "7.0.0";

//		OS 8
//		public static final String UDID = "ZY223ZL8J8";	public static final String DEVICE_NAME = "Amresh-G5Plus";	public static final String DEVICE_VERSION = "8.0.0";
//		public static final String UDID = "421042efc4159421"; public static final String DEVICE_NAME = "Samsung-Galaxy-J5"; public static final String DEVICE_VERSION = "8.0.0";

//	 	OS 9
//		public static final String UDID = "DRGID18101405207"; public static final String DEVICE_NAME = "NOKIA"; public static final String DEVICE_VERSION = "9.0.0";

//		OS 10
//		public static final String UDID = "32012439840d5631"; public static final String DEVICE_NAME = "Samsung-M20"; public static final String DEVICE_VERSION = "10.0.0";

//		iOS 12,1
//		public static final String UDID = "a77a281e05af5793d1b292eaaef151095f1b87c7"; public static final String DEVICE_NAME = "iPhone 6"; public static final String DEVICE_VERSION = "12.1";

	/*************************************************************************************
	 * Thanks. Regards
	 **************************************************************************************/

}
