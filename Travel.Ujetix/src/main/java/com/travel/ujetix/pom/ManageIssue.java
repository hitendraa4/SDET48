package com.travel.ujetix.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ujetix.genericutilities.javascriptutility;

public class ManageIssue {
	
	
	@FindBy(xpath = "//a[.='View ']")
	private List<WebElement> actions;

	
	
	public ManageIssue(WebDriver driver) {
		PageFactory.initElements(driver, this);
		
	}



	public List<WebElement> getActions() {
		return actions;
	}
	
	
     public void getAction(WebDriver driver)
     {
    	 javascriptutility js=new javascriptutility(driver);
    	 js.scrllDown();
    	 int last = actions.size()-1;
    	 
    	 actions.get(last).click();
    	 }
	

	
	
	
}
