package com.moneyhop.utils;

import java.util.ArrayList;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class ActionClass {

	public static WebElement clickSendkeyFuction(RemoteWebDriver driver, WebElement element, String valueToType)
			throws InterruptedException {

		Actions actions = new Actions(driver);

		JavaScriptExecutor.highlightElementAndDisbleTheElement(driver, element);
		actions.moveToElement(element).click().sendKeys(valueToType).build().perform();
		UtilitiesWeb.waitUntilPageLoaded();

		return element;
	}

	public static WebElement moveAndClickOnElement(RemoteWebDriver driver, WebElement element) throws Exception{

	
			Actions actions = new Actions(driver);
			UtilitiesWeb.waitUntilElememtIsEnabled(element, 20);
			actions.moveToElement(element).build().perform();
			JavaScriptExecutor.highlightElementAndDisbleTheElement(driver, element);
			actions.click(element).build().perform();
	

		return element;
	}

	public static WebElement moveToElement(RemoteWebDriver driver, WebElement element) throws InterruptedException {
		
		Actions actions = new Actions(driver);
		UtilitiesWeb.waitUntilElememtIsEnabled(element, 10);
		actions.moveToElement(element).build().perform();
		return element;
	}

	
	public static void openNewTab(RemoteWebDriver driver) throws InterruptedException {
		
		((JavascriptExecutor)driver).executeScript("window.open('about:blank','_blank');");

		
	}
	
	
	public static void switchtab(RemoteWebDriver driver, int a) throws InterruptedException {

		Thread.sleep(3000);
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		System.out.println(tabs.size());
		driver.switchTo().window(tabs.get(a));
	}
	
	
	public static void slideRight(WebElement element, RemoteWebDriver driver, int nbr) throws InterruptedException {

		try {

			org.openqa.selenium.Dimension dim = element.getSize();
			int x = dim.getWidth();
			Actions SliderAction = new Actions(driver);
			Thread.sleep(2000);
			SliderAction.dragAndDropBy(element, x - nbr, 0).click().release().perform();

		} catch (Exception e) {

		}
	}

}
