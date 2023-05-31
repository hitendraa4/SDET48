package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	
	@FindBy(xpath = "//input[@name='username']")
	private WebElement adminusernametextfield;
	
	@FindBy(xpath = "//input[@name='password']")
	private WebElement adminpasswordtextfield;
	
	@FindBy(xpath = "//input[@name='login']")
	private WebElement signinbutton;
	
	@FindBy(xpath="//a[.='Back to home']")
	private WebElement backtohomelink;

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getAdminusernametextfield() {
		return adminusernametextfield;
	}

	public WebElement getAdminpasswordtextfield() {
		return adminpasswordtextfield;
	}

	public WebElement getSigninbutton() {
		return signinbutton;
	}

	public WebElement getBacktohomelink() {
		return backtohomelink;
	}

	
	
	
	
	
	

}
