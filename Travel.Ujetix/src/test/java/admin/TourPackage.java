package admin;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.travel.ujetix.pom.AdminHomePage;
import com.travel.ujetix.pom.AdminLoginPage;
import com.travel.ujetix.pom.CreateEnquiryPage;
import com.travel.ujetix.pom.CreateTourPackagePage;
import com.travel.ujetix.pom.HomePage;
import com.travel.ujetix.pom.ManageEnquiryPage;

import ujetix.genericutilities.BaseClass;
import ujetix.genericutilities.ExcelUtility;
import ujetix.genericutilities.FileUtility;
import ujetix.genericutilities.JavaUtility;
import ujetix.genericutilities.WebDriverUtility;

public class TourPackage extends BaseClass {
       @Test(groups = "regressionTest")
	public  void createTourP() throws Throwable {
       
		WebDriver driver=new  ChromeDriver();
		// maximize the browser
		WebDriverUtility wu=new WebDriverUtility();
		wu.maximizeWindow(driver);
		wu.waitTillPageLoad(driver);
		
		// fetching common data
		
		FileUtility fu=new FileUtility();
		String URL = fu.getPropertyData("url");
		String userName =fu.getPropertyData("adminusername");
		String password=fu.getPropertyData("password");
		
		
		
		// Fetching Test data from Excel File
		ExcelUtility eu=new ExcelUtility();
		
		JavaUtility ju=new JavaUtility();
		ju.getRandomNumber();
			
			 int no = ju.getRandomNumber();
		String packageName =eu.getExcelData("Sheet1", 1, 0)+""+no;
		String packageType = eu.getExcelData("Sheet1", 1, 1);
		String location = eu.getExcelData("Sheet1", 1, 2);
		
		
		// enter the url
		HomePage h=new HomePage(driver);
		h.getAdminloginlink().click();
		AdminLoginPage a=new AdminLoginPage(driver);
		a.getAdminusernametextfield().sendKeys(userName);
		a.getAdminpasswordtextfield().sendKeys(password);
		a.getSigninbutton().click();
		
		// create tour package
		AdminHomePage ah=new AdminHomePage(driver);
		ah.clickCreatePackage(driver, wu);
		
		
		// Entering package details
		CreateTourPackagePage ctp=new CreateTourPackagePage(driver);
		//ctp.createTourPackage(driver,packageName, packageType, location,price, feat, details, packageType);
		
		ExcelUtility e=new ExcelUtility();
		HashMap<String, String> h1 = e.getMultipleData("CreateTourPackage");
		ctp.createTourPackage(h1, driver);
		
		// logout as admin
		ah.adminLogout();
		a.getBacktohomelink().click();
		
		
		
		JavascriptExecutor j=(JavascriptExecutor) driver;
		
	    List<WebElement> packagenames = driver.findElements(By.xpath("//h4"));
	    j.executeScript("window.scrollTo(0,4000)");
	   
	    for(int i=0;i<packagenames.size();i++)
	    {
	    	String text = packagenames.get(i).getText();
	    	if(text.contains("Arequipa20"))
	    	{
	    		System.out.println("Arequipa20:Package is present");
	    	}
	    }
		// entering details
	    h.getEnquirytab().click();
	    
	    
	    String firstname = e.getExcelData("createEnquiry", 2,1);
	    String email = e.getExcelData("createEnquiry", 2, 2);
	    String mbno=e.getExcelData("createEnquiry", 2, 3);
	    String status=e.getExcelData("createEnquiry", 2, 4);
	    String description=e.getExcelData("createEnquiry", 2, 5);
	    
	    CreateEnquiryPage ce=new CreateEnquiryPage(driver);
	    ce.getFname().sendKeys(firstname);
	    ce.getEmaletextf().sendKeys(email);
	    ce.getMobiletextf().sendKeys(mbno);
	    ce.getSubjecttf().sendKeys(status);
	    ce.getDesctf().sendKeys(description);
	    ce.getSubmitbtn().click();
	    
	    
	    
		
		// login as admin
	    h.getAdminloginlink().click();
		
		a.getAdminusernametextfield().sendKeys(userName);
		a.getAdminpasswordtextfield().sendKeys(password);
		// click on manage enquiry and handling Enquiry
		
		ah.getManageenquirytab().click();
		
		ManageEnquiryPage me=new ManageEnquiryPage(driver);
		me.clickOnread(driver);
		
		
		
		// logout as admin	
		ah.adminLogout();
		a.getBacktohomelink().click();
		
		
		
		// ScreenShot 
		wu.getScreenShot(driver,"admin");
		
		
		// close application
		driver.quit();
		
		
		
		
		
	}

}
