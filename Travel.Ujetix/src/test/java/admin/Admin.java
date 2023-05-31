package admin;

import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import ujetix.genericutilities.WebDriverUtility;
import ujetix.genericutilities.javascriptutility;

public class Admin extends BaseClass {
	
	
	
	// hello how 
	@Test(groups = "smokeTest")
	public  void createTourPackageAndVerifyIssue() throws Throwable {
		
		
		WebDriverUtility u=new WebDriverUtility();
		u.waitTillPageLoad(driver);
		FileUtility fu=new FileUtility();
		String userName =fu.getPropertyData("adminusername");
		String password=fu.getPropertyData("password");
		String username = fu.getPropertyData("username");
		
		
		// login as admin  hrllo
		HomePage h=new HomePage(driver);
		AdminHomePage ah=new AdminHomePage(driver);
		ah.clickCreatePackage(driver, u);
		 ExcelUtility eu=new ExcelUtility();
			
			CreateTourPackagePage cp=new CreateTourPackagePage(driver);
			HashMap<String, String> fd = eu.getMultipleData("CreateTourPackage");
			cp.createTourPackage(fd, driver);
			cp.getCreatepackagebutton().click();
		// logout as admin
		    ah.adminLogout();
		AdminLoginPage al=new AdminLoginPage(driver);
		al.getBacktohomelink().click();
		
		String userName1 = fu.getPropertyData("username");
		String password1=fu.getPropertyData("upassword");
		// login as user
       UserLoginPage ul=new UserLoginPage(driver);
       
       h.getUsersignin().click();
		
		ul.getEmailtextfield().sendKeys(userName1);
		ul.getPasswordtextfield().sendKeys(password1);
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
			    		break;
			    	}
			    }
			    javascriptutility js=new javascriptutility(driver);
			    js.scrollUp();
			    UserHomePage up=new UserHomePage(driver);
			    up.getWriteusmajortab().click();
			    //create issue
			    Write_usPage w=new Write_usPage(driver);
				w.createIssue(2,"cancellation i want i book package from other website");
				up.logoutUser();
				
				
				// login as Admin
				
				h.getAdminloginlink().click();
				
				al.getAdminusernametextfield().sendKeys(userName);
				al.getAdminpasswordtextfield().sendKeys(password);
				al.getSigninbutton().click();
				
				// click on manage issue tab
				
				ah.getManageissuetab().click();
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
						break;
					}
				}
				
				js.scrollUp();
				// logout as admin
				ah.adminLogout();
				
				// login as user 
				h.getUsersignin().click();
				
				
				h.getUsersignin().click();
				
				ul.getEmailtextfield().sendKeys(username);
				ul.getPasswordtextfield().sendKeys("123456");
				ul.getSigninbutton().click();

}
}
