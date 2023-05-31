package com.travel.ujetix.pom;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class CreateTourPackagePage {
	
	@FindBy(xpath = "//input[@name='packagename']")
	private WebElement packagenametf;
	
	@FindBy(xpath = "//input[@name='packagetype']")
	private WebElement packagetypetf;
	
	@FindBy(xpath = "//input[@name='packagelocation']")
	private WebElement locationtextfield;
	
	@FindBy(id = "packageprice" )
	private WebElement pricetf;
	
	@FindBy(xpath = "//input[@name='packagefeatures']")
	private WebElement featurestextf;
	
	@FindBy(id = "packagedetails")
	private WebElement packagedetailstextf;
	
	@FindBy(id = "packageimage")
	private WebElement packageimage;
	
	@FindBy(xpath = "//button[@name='submit']")
	private WebElement createpackagebutton;

	
	
	public CreateTourPackagePage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}

	public WebElement getPackagenametf() {
		return packagenametf;
	}

	public WebElement getPackagetypetf() {
		return packagetypetf;
	}

	public WebElement getLocationtextfield() {
		return locationtextfield;
	}

	public WebElement getPricetf() {
		return pricetf;
	}

	public WebElement getFeaturestextf() {
		return featurestextf;
	}

	public WebElement getPackagedetailstextf() {
		return packagedetailstextf;
	}

	public WebElement getPackageimage() {
		return packageimage;
	}

	public WebElement getCreatepackagebutton() {
		return createpackagebutton;
	}
	// method for to create tour package
//	public void createTourPackage(WebDriver driver,String packageName,String packageType, String location, String price, String feature, String details,String img)
//	{
//	   packagenametf.sendKeys(packageName);
//	   packagetypetf.sendKeys(packageType);
//	   locationtextfield.sendKeys(location);
//	   pricetf.sendKeys(price);
//	   featurestextf.sendKeys(feature);
//	   packagedetailstextf.sendKeys(details);
//	   packageimage.sendKeys(img);
//	   javascriptutility js=new javascriptutility(driver);
//	   js.scrllDown();
//	   createpackagebutton.click();
//		
//	}
	
	// create tour package
	//ExcelUtility e=new ExcelUtility();
	
	
	public void createTourPackage(HashMap<String, String> h,WebDriver driver) throws Throwable
	{
		//HashMap<String, String> h1 = e.getMultipleData("CreateTourPackage");
		for(Entry<String, String> set:h.entrySet())
		{
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
		}	
	}
	
}
	
	
	
	



