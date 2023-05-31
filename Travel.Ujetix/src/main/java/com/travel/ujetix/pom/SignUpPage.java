package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {
	@FindBy(xpath = "//input[@name='fname']")
	private WebElement fullname;
	
	@FindBy(xpath="//input[@name='mobilenumber']")
	private WebElement mobilenotf;
	
	@FindBy(xpath="(//input[@id='email'])[1]")
	private WebElement email;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordtf;
	
	@FindBy(xpath = "//input[@id='submit']")
	private WebElement createAccountbtn;
	
	

	public SignUpPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getFullname() {
		return fullname;
	}

	public WebElement getMobileno() {
		return mobilenotf;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getPassword() {
		return passwordtf;
	}

	public WebElement getCreateAccountbtn() {
		return createAccountbtn;
	}
	
	// method for user signup
	public void userSignup(String fname,String mobileno,String Email, String password)
	{
		fullname.sendKeys(fname);
		mobilenotf.sendKeys(mobileno);
		email.sendKeys(Email);
		passwordtf.sendKeys(password);
		createAccountbtn.click();
		
	}
	
	

}
