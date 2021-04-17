package com.moneyhop.requestCallBack;

import org.openqa.selenium.WebElement;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.moneyhop.page.RequestCallBackPage;
import com.moneyhop.sanityscripts.BaseTestWeb;
import com.moneyhop.utils.ActionClass;
import com.moneyhop.utils.JavaScriptExecutor;
import com.moneyhop.utils.UtilitiesWeb;

public class DeatilsForm extends BaseTestWeb {

	public void fillDetails() throws Exception {

		RequestCallBackPage details = new RequestCallBackPage(driver);

		try {
			UtilitiesWeb.waitUntilPageLoaded();
			ActionClass.moveAndClickOnElement(driver, details.RequestCallback);
			test.log(Status.INFO, "Click on FundTab");
		} catch (Exception e) {
			test.log(Status.DEBUG, "Not able to Click on FundTab" + "<br/>", MediaEntityBuilder
					.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName)).build());
		}

		if (UtilitiesWeb.waitUntilElementIsVisible(details.name, 30)) {

			ActionClass.clickSendkeyFuction(driver, details.name, "Preetish Kumar Mahato");
			test.log(Status.INFO, "Click on Name user can type the name");
		} else {
			test.log(Status.DEBUG, "Not able to click & type on Name Field" + "<br/>", MediaEntityBuilder
					.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName)).build());
		}

		if (UtilitiesWeb.waitUntilElementIsVisible(details.email, 20)) {

			ActionClass.clickSendkeyFuction(driver, details.email, "preetish.m004@gmail.com");
			test.log(Status.INFO, "Click on Email & type the email id");
		} else {
			test.log(Status.DEBUG, "Not able to Click & type on Email field" + "<br/>", MediaEntityBuilder
					.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName)).build());
		}

		if (UtilitiesWeb.waitUntilElementIsVisible(details.phone, 20)) {

			ActionClass.clickSendkeyFuction(driver, details.phone, "8152888585");
			test.log(Status.INFO, "Click on Phone nbr & user can able to type the ph nbr");
		} else {
			test.log(Status.DEBUG, "Not able to Click & type on ph nbr field" + "<br/>", MediaEntityBuilder
					.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName)).build());
		}

		if (UtilitiesWeb.waitUntilElementIsVisible(details.city, 20)) {

			ActionClass.clickSendkeyFuction(driver, details.city, "Ghatsila");
			test.log(Status.INFO, "Click on city & user can able to type the city");
		} else {
			test.log(Status.DEBUG, "Not able to Click & type on city" + "<br/>", MediaEntityBuilder
					.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName)).build());
		}

		if (UtilitiesWeb.waitUntilElementIsVisible(details.amount, 20)) {

			ActionClass.clickSendkeyFuction(driver, details.amount, "300");
			test.log(Status.INFO, "Click on amount & user can able to type the amount");
		} else {
			test.log(Status.DEBUG, "Not able to Click & type on amount field" + "<br/>", MediaEntityBuilder
					.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName)).build());
		}

		if (UtilitiesWeb.waitUntilElementIsVisible(details.currecy, 20)) {
			ActionClass.moveAndClickOnElement(driver, details.currecy);

			for (WebElement ele : details.ListOfCurrecy) {
				String innerHTML = ele.getAttribute("data-value");
				System.out.println(innerHTML);

				if (innerHTML.equals("AUD")) {
					ActionClass.moveAndClickOnElement(driver, ele);
					break;
				}

			}
			
			
			
			
			try {
				ActionClass.clickSendkeyFuction(driver, details.Reasonforthecallback, "Not able to trasfer Money to Client");
				test.log(Status.INFO, "Click on reason for call back & user can able to type the Reason");
			} catch (Exception e) {
				test.log(Status.DEBUG, "Not able click and type on reason for call back" + "<br/>", MediaEntityBuilder
						.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName))
						.build());
			}
			
			
			
			

			if (UtilitiesWeb.waitUntilElementIsVisible(details.submit, 10)) {
				ActionClass.moveAndClickOnElement(driver, details.submit);
			} else {
				test.log(Status.DEBUG, "Not able click on submit button" + "<br/>", MediaEntityBuilder
						.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName))
						.build());
			}
			
			
			UtilitiesWeb.waitUntilPageLoaded();
			if(UtilitiesWeb.waitUntilElementIsVisible(details.successMsg, 30)) {
				JavaScriptExecutor.highlightElementAndDisbleTheElement(driver, details.successMsg);
			}else {
				test.log(Status.DEBUG, "Success msg has not Populated" + "<br/>", MediaEntityBuilder
						.createScreenCaptureFromPath(UtilitiesWeb.captureScreenshotWithName(driver, testCaseName))
						.build());
			}
			

		}

	}

}
