package com.moneyhop.test;

import org.testng.annotations.Test;


import com.aventstack.extentreports.Status;
import com.moneyhop.requestCallBack.DeatilsForm;
import com.moneyhop.sanityscripts.MoneyHopBaseTest;
import com.moneyhop.utils.MoneyHopConstants;


public class RequestCallBackTest extends MoneyHopBaseTest {

		
	
	@Test()
	@org.testng.annotations.Parameters("browser")
	public void browserSetupEngine(String XmlbrowserName) throws Exception {

		test.log(Status.INFO, XmlbrowserName + "-Browser Up and Running Application Start!!!!!!");
		test.log(Status.INFO, XmlbrowserName + "-Navigated to the url-" + MoneyHopConstants.URL);

		MoneyHopBaseTest.lunchBrowsersetUp(XmlbrowserName);

	}
	
	
	@Test()
	public void fillDetailsFrom() {

		try {
			DeatilsForm obj = new DeatilsForm();
			obj.fillDetails();
         
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
