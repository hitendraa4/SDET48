package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericutilities.WebDriverUtility;

public class AdminHomePage {
	
	
	
	@FindBy(xpath = "//span[.=' Tour Packages']")
	private WebElement tourpackagestab;
	
	@FindBy(xpath="//a[.='Create']")
	private WebElement createtab;
	
	@FindBy(xpath = "//a[.='Manage']")
	private WebElement managetab;
	
	@FindBy(xpath = "//span[.='Manage Users']")
	private WebElement manageusertab;
	
	@FindBy(xpath = "//span[.='Manage Booking']")
	private WebElement managebookingtab;
	
	
	@FindBy(xpath = "//span[.='Manage Issues']")
	private WebElement manageissuetab;
	
	@FindBy(xpath="//span[.='Manage Enquiries']")
	private WebElement manageenquirytab;
	
	@FindBy(xpath="//span[.='//span[.='Manage Pages']']")
	private WebElement managepagestab;
	
	@FindBy(xpath="//p[.='Welcome']")
	private WebElement administratordd;
	
	@FindBy(xpath = "//a[@href='logout.php']")
	private WebElement logoutlink;
	
	@FindBy(xpath = "//a[@href='change-password.php']")
	private  WebElement updatePassword;
	
	

	public AdminHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getTourpackagestab() {
		return tourpackagestab;
	}

	public WebElement getCreatetab() {
		return createtab;
	}

	public WebElement getManagetab() {
		return managetab;
	}

	public WebElement getManageusertab() {
		return manageusertab;
	}

	public WebElement getManagebookingtab() {
		return managebookingtab;
	}

	public WebElement getManageissuetab() {
		return manageissuetab;
	}

	public WebElement getManageenquirytab() {
		return manageenquirytab;
	}

	public WebElement getManagepagestab() {
		return managepagestab;
	}
	

	public WebElement getAdministratordd() {
		return administratordd;
	}

	public WebElement getLogoutlink() {
		return logoutlink;
	}

	public WebElement getUpdatePassword() {
		return updatePassword;
	}
	
	// Buisness Library
	// mouse hover to tourpackages tab and click on create
	public void clickCreatePackage(WebDriver driver,WebDriverUtility wdu)
	{
		wdu.mouseOverOnElement(driver, tourpackagestab);
		wdu.mouseOverOnElement(driver, createtab);
		createtab.click();
	}
	
	// mouse hover to tourpackages tab and click on manage
	public void clickManagePackage(WebDriver driver,WebDriverUtility wdu)
	{
		wdu.mouseOverOnElement(driver, tourpackagestab);
		wdu.mouseOverOnElement(driver, managetab);
		managetab.click();
	}
	
	
	
	// click on administrator click on logout link
	/**
	 * @author Hitendra singhal
	 */
	public void adminLogout()
	{
		administratordd.click();
		logoutlink.click();
	}
	
	//click on administrator and click on update password
	/**
	 * @author Hitendra singhal
	 */
	public void updatePassword()
	{
		administratordd.click();
		updatePassword.click();
	}
		

	
	

}
