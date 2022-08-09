package com.objectsRepo;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LocatorsRepo {

	ChromeDriver localDriver;

	public LocatorsRepo(ChromeDriver remoteDriver) {
		localDriver = remoteDriver;
		PageFactory.initElements(remoteDriver, this);
	}

//	----------------------------------------------- Login Page ------------------------------------------------

	@FindBy(xpath = "//*[@id='login_credentials']")
	public WebElement userNameText;

	@FindBy(xpath = "//*[@class='login_password']")
	public WebElement passwordText;

	@FindBy(xpath = "//*[@id='user-name']")
	public WebElement userNameInputField;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement passwordInputField;
	
	@FindBy(xpath = "//*[@id='login-button']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//*[@class='title']")
	public WebElement homePageHeader;
	
	@FindBy(xpath = "//div[@class='inventory_item']")
	public List<WebElement> containerList;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	public WebElement oneAddToCartButton;
	
	@FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
	public List<WebElement> oneAddToCartButtonlist;
	
	
	
}
