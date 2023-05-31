package com.travel.ujetix.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class updateTourPackage {
	
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

	
	// constructor
	public updateTourPackage( WebDriver driver) {
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
	
	// method to update tour package
	public void updateTourPackage1(String packageName,String packageType, String location, String price, String feature, String details,String img)
	{
	   packagenametf.sendKeys(packageName);
	   packagetypetf.sendKeys(packageType);
	   locationtextfield.sendKeys(location);
	   pricetf.sendKeys(price);
	   featurestextf.sendKeys(feature);
	   packagedetailstextf.sendKeys(details);
	   packageimage.sendKeys(img);
	   
		
	}
	

}
