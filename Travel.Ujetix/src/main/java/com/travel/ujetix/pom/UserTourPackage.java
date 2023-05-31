package com.travel.ujetix.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTourPackage {
	@FindBy(xpath = "//h4")
	private List<WebElement> tourpackages;

	public UserTourPackage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}


	public List<WebElement> getTourpackages() {
		return tourpackages;
	}
	
	
	
	
	

}
