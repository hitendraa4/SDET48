package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateEnquiryPage {
	
	@FindBy(id = "fname")
	private WebElement fname;
	
	@FindBy(id = "email")
	private WebElement emaletextf;
	
	@FindBy(id = "mobileno")
	private WebElement mobiletextf;
	
	@FindBy(id = "subject")
	private WebElement subjecttf;
	
	@FindBy(id ="description")
	private WebElement desctf;
	
	@FindBy(xpath = "//button[@class='btn-primary btn']")
	private WebElement submitbtn;

	public CreateEnquiryPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getFname() {
		return fname;
	}

	public WebElement getEmaletextf() {
		return emaletextf;
	}

	public WebElement getMobiletextf() {
		return mobiletextf;
	}

	public WebElement getSubjecttf() {
		return subjecttf;
	}

	public WebElement getDesctf() {
		return desctf;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}
	
	
	
	
	
	

}
