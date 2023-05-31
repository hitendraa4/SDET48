package com.travel.ujetix.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IssueTicketsPage {

	@FindBy(xpath = "//tr/td[5]")
	private List<WebElement> adminremark;

	public IssueTicketsPage(WebDriver driver) {
		PageFactory.initElements(driver,this );
	}

	

	public List<WebElement> getAdminremark() {
		return adminremark;
	}

	
	
	
}
