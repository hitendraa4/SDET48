package admin;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.travel.ujetix.pom.AdminHomePage;
import com.travel.ujetix.pom.AdminLoginPage;
import com.travel.ujetix.pom.CreateTourPackagePage;
import com.travel.ujetix.pom.HomePage;
import com.travel.ujetix.pom.ManageIssue;
import com.travel.ujetix.pom.UpdateCompliantPage;
import com.travel.ujetix.pom.UserHomePage;
import com.travel.ujetix.pom.UserLoginPage;
import com.travel.ujetix.pom.UserTourPackage;
import com.travel.ujetix.pom.Write_usPage;

import ujetix.genericutilities.BaseClass;
import ujetix.genericutilities.ExcelUtility;
import ujetix.genericutilities.FileUtility;
import ujetix.genericutilities.JavaUtility;
import ujetix.genericutilities.WebDriverUtility;
import ujetix.genericutilities.javascriptutility;

public class TourPackage1 extends BaseClass {
	
	
     @Test(groups = "regressionTest")
	public void tourPackage() throws IOException {
		
		WebDriver driver=new  ChromeDriver();
		WebDriverUtility u=new WebDriverUtility();
		u.maximizeWindow(driver);
		u.waitTillPageLoad(driver);
		FileUtility fu=new FileUtility();
		String URL = fu.getPropertyData("url");
		String userName =fu.getPropertyData("adminusername");
		String password=fu.getPropertyData("password");
		
		// enter the url
		driver.get(URL);
		// login as admin
		HomePage h=new HomePage(driver);
		h.getAdminloginlink().click();
		AdminLoginPage a=new AdminLoginPage(driver);
		a.getAdminusernametextfield().sendKeys(userName);
		a.getAdminpasswordtextfield().sendKeys(password);
		a.getSigninbutton().click();
		
		AdminHomePage ah=new AdminHomePage(driver);
		ah.clickCreatePackage(driver, u);
		JavaUtility ju=new JavaUtility();
		
		
		 int no = ju.getRandomNumber();
		 ExcelUtility eu=new ExcelUtility();
			String packageName =eu.getExcelData("Sheet1", 1, 0)+""+no;
			String packageType = eu.getExcelData("Sheet1", 1, 1);
			String location = eu.getExcelData("Sheet1", 1, 2);
			String price="120$";
			String features="Free Pickup and Drop Facility";
			String details="Food will be free on First day";
			String image="C:\\Users\\Hitendra singhal\\OneDrive\\Pictures\\Screenshots\\Screenshot (56).png";
			CreateTourPackagePage cp=new CreateTourPackagePage(driver);
			cp.getPackagenametf().sendKeys(packageName);
			cp.getPackagetypetf().sendKeys(packageType);
		    cp.getLocationtextfield().sendKeys(location);
		    cp.getPricetf().sendKeys(price);
		    cp.getFeaturestextf().sendKeys(features);
		    cp.getPackagedetailstextf().sendKeys(details);
		    cp.getPackageimage().sendKeys(image);
		    cp.getCreatepackagebutton().click();
		    javascriptutility  js=(javascriptutility) driver;
		    js.scrllDown();
		    cp.getCreatepackagebutton().click();
		    
		
		
		// logout as admin
		    ah.adminLogout();
		AdminLoginPage al=new AdminLoginPage(driver);
		al.getBacktohomelink();
		

	

		
		
		String userName1 = fu.getPropertyData("username");
		String password1=fu.getPropertyData("upassword");
		// login as user
       HomePage h1=new HomePage(driver);
       UserLoginPage ul=new UserLoginPage(driver);
       
       h1.getUsersignin().click();
		
		ul.getEmailtextfield().sendKeys(userName);
		ul.getPasswordtextfield().sendKeys(password);
		ul.getSigninbutton().click();
		
					// verify recently created tour package
				driver.findElement(By.linkText("Tour Packages")).click();
				UserTourPackage utp=new UserTourPackage(driver);
				utp.getTourpackages();
				
			   JavascriptExecutor j=(JavascriptExecutor) driver;
			   
			    j.executeScript("window.scrollTo(0,4000)");
			   
			    for(int i=0;i<utp.getTourpackages().size();i++)
			    {
			    	String text = utp.getTourpackages().get(i).getText();
			    	if(text.contains("Arequipa20"))
			    	{
			    		System.out.println("Arequipa20:Package is present");
			    	}
			    }
			    UserHomePage up=new UserHomePage(driver);
			    //create issue
			    Write_usPage w=new Write_usPage(driver);
				w.createIssue(2,"cancellation i want i book package from other website");
				up.logoutUser();
				
				
				// login as Admin
				
				h.getAdminloginlink().click();
				
				a.getAdminusernametextfield().sendKeys(userName);
				a.getAdminpasswordtextfield().sendKeys(password);
				a.getSigninbutton().click();
				
				// click on manage issue tab
				
				ah.getManageissuetab();
				ManageIssue m=new ManageIssue(driver);
				m.getAction(driver);
			
				
				Set<String> wh = driver.getWindowHandles();
				UpdateCompliantPage uc=new UpdateCompliantPage(driver);
				for(String i:wh)
				{
					driver.switchTo().window(i);
					String title = driver.getTitle();
					// validate 
					if(title.equals("Update Compliant"))
					{
						uc.getRemarksarea().sendKeys("OK Alright i will try to check once ");
						uc.getUpdate().click();
						driver.close();
					}
				}
				
				
				// logout as admin
				ah.adminLogout();
				
				driver.quit();
		

	}

}
