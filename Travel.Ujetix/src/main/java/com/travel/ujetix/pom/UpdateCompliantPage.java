package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateCompliantPage {
	
	@FindBy(xpath = "//textarea")
	private WebElement remarksarea;
	
	@FindBy(xpath="//input")
	private WebElement update;

	public UpdateCompliantPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getRemarksarea() {
		return remarksarea;
	}

	public WebElement getUpdate() {
		return update;
	}
	
	
	
	

}
