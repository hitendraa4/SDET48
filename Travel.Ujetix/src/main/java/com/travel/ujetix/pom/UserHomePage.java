package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserHomePage {
	
	@FindBy( partialLinkText = "My Profile" )
	private WebElement myprofilelink;
	
	@FindBy(xpath = "//a[@href='change-password.php']")
	private WebElement chnpasslink;
	
	@FindBy(xpath = "//a[@href='tour-history.php']")
	private WebElement tourhistorylink;
	
	@FindBy(xpath = "//a[@href='issuetickets.php']")
	private WebElement issueticketslink;
	
	@FindBy(xpath ="//a[.=' / Write Us ']")
	private WebElement writeusmajortab;
	
	@FindBy(xpath = "//a[.='Tour Packages']")
	private WebElement tourpackagesmajtab;
	
	@FindBy(xpath = "//a[.='Home']")
	private WebElement homemajortab;
	
	@FindBy(xpath="//a[.='/ Logout']")
	private WebElement logoutlink;
	
	
	
	
	
	public UserHomePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	

	public WebElement getMyprofilelink() {
		return myprofilelink;
	}

	public WebElement getChnpasslink() {
		return chnpasslink;
	}

	public WebElement getTourhistorylink() {
		return tourhistorylink;
	}

	public WebElement getIssueticketslink() {
		return issueticketslink;
	}

	public WebElement getWriteusmajortab() {
		return writeusmajortab;
	}

	public WebElement getTourpackagesmajtab() {
		return tourpackagesmajtab;
	}

	public WebElement getHomemajortab() {
		return homemajortab;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}
	
	// logout as user
	
		public void logoutUser()
		{
			logoutlink.click();
		}
 
}
