package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	@FindBy(linkText = "Admin Login")
	private WebElement adminloginlink;
	
	@FindBy(xpath = "//a[.='Sign Up']")
	private WebElement usersignup;
	
	@FindBy(xpath="//a[.='/ Sign In']")
	private WebElement usersignin;
	
	@FindBy(xpath="//a[.=' Enquiry ']")
	private WebElement enquirytab;
	
	@FindBy(xpath="//a[.='Tour Packages']")
	private WebElement tourpackagestab;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
		
	}

	public WebElement getAdminloginlink() {
		return adminloginlink;
	}

	public WebElement getUsersignup() {
		return usersignup;
	}

	public WebElement getUsersignin() {
		return usersignin;
	}

	public WebElement getEnquirytab() {
		return enquirytab;
	}

	public WebElement getTourpackagestab() {
		return tourpackagestab;
	}
	
	
	
	

}
