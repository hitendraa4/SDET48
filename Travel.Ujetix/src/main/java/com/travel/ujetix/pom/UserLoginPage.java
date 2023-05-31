package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {
	
	@FindBy(xpath = "//input[@placeholder='Enter your Email']")
	private WebElement emailtextfield;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement passwordtextfield;
	
	@FindBy(xpath = "//input[@name='signin']")
	private WebElement signinbutton;

	public UserLoginPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public WebElement getEmailtextfield() {
		return emailtextfield;
	}

	public WebElement getPasswordtextfield() {
		return passwordtextfield;
	}

	public WebElement getSigninbutton() {
		return signinbutton;
	}
	
	// method for login as user 
	public void userLogin(String email, String password)
	{
		emailtextfield.sendKeys(email);
		passwordtextfield.sendKeys(password);
		signinbutton.click();
	}

}
