package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Write_usPage {
	@FindBy(xpath = "//select[@id='country']")
	private WebElement issuedropdown;
	
	@FindBy(xpath = "//input[@name='description']")
	private WebElement descriptiontext;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement submit;

	public Write_usPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getIssuedropdown() {
		return issuedropdown;
	}

	public WebElement getDescriptiontext() {
		return descriptiontext;
	}

	public WebElement getSubmit() {
		return submit;
	}
	
	// method to craete issue
	public void createIssue(int index,String text)
	{
		issuedropdown.click();
		Select s=new Select(issuedropdown);
		s.selectByIndex(index);
		descriptiontext.sendKeys(text);
		submit.click();
		
	}

	
	
	
	
	

}
