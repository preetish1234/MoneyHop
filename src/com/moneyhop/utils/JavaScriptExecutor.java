package com.moneyhop.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.moneyhop.sanityscripts.BaseTestWeb;

public class JavaScriptExecutor {

	public static void highlightElementAndDisbleTheElement(RemoteWebDriver driver, WebElement element)
			throws InterruptedException {

		UtilitiesWeb.waitUntilElementIsVisible(element, 30);
		ActionClass.moveToElement(driver, element);
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].setAttribute('style', 'background: blue; border: 2px solid red;');", element);

		UtilitiesWeb.explicitWaitVisible(driver, element, 30);
		Thread.sleep(150);

		((JavascriptExecutor) driver).executeScript(
				"arguments[0].removeAttribute('style', 'background: blue; border: 2px solid red;');", element);

		BaseTestWeb.logger.info("Element to Action " + element.toString());

	}

}
