package admin;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.travel.ujetix.pom.AdminHomePage;
import com.travel.ujetix.pom.AdminLoginPage;
import com.travel.ujetix.pom.HomePage;
import com.travel.ujetix.pom.IssueTicketsPage;
import com.travel.ujetix.pom.ManageIssue;
import com.travel.ujetix.pom.UpdateCompliantPage;
import com.travel.ujetix.pom.UserHomePage;
import com.travel.ujetix.pom.UserLoginPage;
import com.travel.ujetix.pom.Write_usPage;

import ujetix.genericutilities.BaseClass;
import ujetix.genericutilities.FileUtility;
import ujetix.genericutilities.WebDriverUtility;
import ujetix.genericutilities.javascriptutility;

public class IssueRemarks extends BaseClass {
      @Test(groups = "regressionTest")
	public void issueRemarks() throws Exception {
		WebDriver driver=new  ChromeDriver();
		WebDriverUtility wu=new WebDriverUtility();
		wu.maximizeWindow(driver);
		wu.waitTillPageLoad(driver);
		
		FileUtility fu=new FileUtility();
		
		String URL = fu.getPropertyData("url");
		String userName = fu.getPropertyData("username");
		String password=fu.getPropertyData("upassword");
		
		String adminun = fu.getPropertyData("adminusername");
		String admp = fu.getPropertyData("password");
		
		driver.get(URL);
		// login as user
		HomePage h=new HomePage(driver);
		h.getUsersignin().click();
		UserLoginPage ul=new UserLoginPage(driver);
		ul.getEmailtextfield().sendKeys(userName);
		ul.getPasswordtextfield().sendKeys(password);
		ul.getSigninbutton().click();
		UserHomePage up=new UserHomePage(driver);
		up.getWriteusmajortab().click();
		
		
		Write_usPage w=new Write_usPage(driver);
		w.createIssue(2,"cancellation i want i book package from other website");
		up.logoutUser();
		//login as admin
		h.getAdminloginlink().click();
	    AdminLoginPage a=new AdminLoginPage(driver);
	    a.getAdminusernametextfield().sendKeys(adminun);
	    a.getAdminpasswordtextfield().sendKeys(admp);
	    a.getSigninbutton().click();
		AdminHomePage a1=new AdminHomePage(driver);
		
		// click on manage issue tab
		a1.getManageissuetab().click();
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
		javascriptutility js=new javascriptutility(driver);
		js.scrollUp();
		AdminHomePage ah=new AdminHomePage(driver);
		ah.adminLogout();
		a.getBacktohomelink().click();
		
		driver.findElement(By.linkText("Back to home")).click();
		// login as user
		
		h.getUsersignin().click();
		
		ul.getEmailtextfield().sendKeys(userName);
		ul.getPasswordtextfield().sendKeys(password);
		ul.getSigninbutton().click();
		
		// click on issue ticket 
		UserHomePage uh=new UserHomePage(driver);
		uh.getIssueticketslink().click();
		IssueTicketsPage it=new IssueTicketsPage(driver);
		int last=it.getAdminremark().size()-1;
		String text = it.getAdminremark().get(last).getText();
		
		if(text.contains("OK Alright i will try to check once"))
		{
			System.out.println("Text is displayed under remarks section");
		}
		else {
			System.out.println("text is not displayed");
		}
		// logout as user
		driver.findElement(By.xpath("//a[@href='logout.php']")).click();
		// close the application
		driver.quit();
	}

}



