package admin;

import java.io.IOException;
import java.util.List;

import org.apache.commons.math3.random.HaltonSequenceGenerator;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.travel.ujetix.pom.AdminHomePage;
import com.travel.ujetix.pom.AdminLoginPage;
import com.travel.ujetix.pom.HomePage;
import com.travel.ujetix.pom.ManageBooking;
import com.travel.ujetix.pom.UserHomePage;
import com.travel.ujetix.pom.UserLoginPage;

import ujetix.genericutilities.BaseClass;
import ujetix.genericutilities.FileUtility;
import ujetix.genericutilities.WebDriverUtility;
import ujetix.genericutilities.javascriptutility;
@Listeners(ujetix.genericutilities.ListnerImplementation.class)
public class ConfirmTheBooking extends BaseClass  {
     @Test(retryAnalyzer = ujetix.genericutilities.RetryAnalyser.class)
	public  void confirmTheBooking() throws IOException {
    	
		
		WebDriverUtility u=new WebDriverUtility();
		u.maximizeWindow(driver);
		u.waitTillPageLoad(driver);
		FileUtility fu=new FileUtility();
		String URL = fu.getPropertyData("url");
		String userName =fu.getPropertyData("adminusername");
		String password=fu.getPropertyData("password");
		Assert.fail();
		// enter the url
		driver.get(URL);
		// login as admin
		HomePage h=new HomePage(driver);
		h.getAdminloginlink().click();
		AdminLoginPage a=new AdminLoginPage(driver);
		a.getAdminusernametextfield().sendKeys(userName);
		a.getAdminpasswordtextfield().sendKeys(password);
		a.getSigninbutton().click();
		// click on manage booking tab
		AdminHomePage ah=new AdminHomePage(driver);
		ah.getManagebookingtab().click();
		ManageBooking mb=new ManageBooking(driver);
		javascriptutility js =new javascriptutility(driver);
		mb.confirmBooking(js, u, driver);
		
		
		// logout as admin
		ah.adminLogout();
		
		a.getBacktohomelink().click();
				
		// login as user
				
				String  userName1 = fu.getPropertyData("username");
				String password1=fu.getPropertyData("upassword");
				// login as user
				UserLoginPage ul=new UserLoginPage(driver);
				h.getUsersignin().click();
				ul.getEmailtextfield().sendKeys(userName1);
				ul.getPasswordtextfield().sendKeys(password1);
						ul.getSigninbutton().click();
				// click my tour history major tab 		
				UserHomePage uh=new UserHomePage(driver);
				uh.getTourhistorylink().click();
				
				driver.quit();
				
				
		
	}

}
