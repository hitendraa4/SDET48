package com.travel.ujetix.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericutilities.WebDriverUtility;
import ujetix.genericutilities.javascriptutility;

public class ManageBooking {
	
	@FindBy(xpath = "//a[.='Confirm']")
	private List<WebElement> confirm;
	
	@FindBy(xpath = "//a[.='Cancel']")
	private List<WebElement> cancel;
	
	public ManageBooking(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	
	
	// method for confirm the booking
	public void confirmBooking(javascriptutility js,WebDriverUtility  wdu, WebDriver driver)
	{
		js.scrllDown();
		int last = confirm.size()-1;
		confirm.get(last).click();
		wdu.switchToAlertPopupAndAccept(driver);
		
	}
	
	// method for cancel the booking
	public void cancelBooking(javascriptutility js, WebDriverUtility wdu, WebDriver driver)
	{
		js.scrllDown();
		int last = cancel.size()-1;
		cancel.get(last).click();
		wdu.switchToAlertPopupAndAccept(driver);
		
	}

}
