package com.travel.ujetix.pom;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericutilities.javascriptutility;

public class ManageEnquiryPage {

	@FindBy(xpath="//a[.='Pending']")
	private List<WebElement> pendings;

	public ManageEnquiryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public List<WebElement> getPendings() {
		return pendings;
	}

	// method to click on read button of recently created enquiry
	public void clickOnread(WebDriver driver)
	{
		int last = pendings.size()-1;
		javascriptutility js=new javascriptutility(driver);
		js.scrllDown();
		pendings.get(last).click();
		Alert al = driver.switchTo().alert();
		al.accept();
	}
	
	
	
}
