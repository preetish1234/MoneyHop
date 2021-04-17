package com.moneyhop.page;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.moneyhop.page.BasePage;

public class RequestCallBackPage extends BasePage {
	
	public RequestCallBackPage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(how = How.XPATH, using = "//*[text()='Request a Callback']")
	public WebElement RequestCallback;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'name')]")
	public WebElement name;

	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'email')]")
	public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'phone')]")
	public WebElement phone;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'city')]")
	public WebElement city;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@name, 'amount')]")
	public WebElement amount;
	
	@FindBy(how = How.XPATH, using = "//*[contains(@id, 'select-currency')]")
	public WebElement currecy;
	
	@FindBy(how = How.XPATH, using = "//ul[contains(@role, 'listbox')]/li")
	public List<WebElement> ListOfCurrecy;

	@FindBy(how = How.XPATH, using = "//span[text()='Submit']")
	public WebElement submit;
	
	@FindBy(how = How.XPATH, using = "//div[text()='Your request has been received']")
	public WebElement successMsg;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Reason for the callback']")
	public WebElement Reasonforthecallback;
	
	
	
}