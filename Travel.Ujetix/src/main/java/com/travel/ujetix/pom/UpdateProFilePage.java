package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateProFilePage {
	
	@FindBy(id = "name")
	private WebElement nametf;
	
	@FindBy(id = "mobileno")
	private WebElement mbtf;
	
	@FindBy(xpath ="(//input[@id='email'])[1]")
	private WebElement email;
	
	@FindBy(xpath="//button[.='Updtae']")
	private WebElement update;
	
	

	public UpdateProFilePage(WebDriver driver) 
	{ 
		PageFactory.initElements(driver, this);
	}

	public WebElement getNametf() {
		return nametf;
	}

	public WebElement getMbtf() {
		return mbtf;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getUpdate() {
		return update;
	}
	// update profile
	public void updateProfileName(String name )
	{
		nametf.clear();
		nametf.sendKeys(name);
		
		update.click();
	}
	
	// update email
	public void updateMobile(String mno)
	{
		mbtf.clear();
		mbtf.sendKeys(mno);
		update.click();
	}
	
	

}
