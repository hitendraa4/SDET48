package user;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.travel.ujetix.pom.HomePage;
import com.travel.ujetix.pom.SignUpPage;
import com.travel.ujetix.pom.UpdateProFilePage;
import com.travel.ujetix.pom.UserHomePage;
import com.travel.ujetix.pom.UserLoginPage;

import ujetix.genericutilities.FileUtility;
import ujetix.genericutilities.WebDriverUtility;

public class SignupandSigninAndUpdateProfile {

	public static void main(String[] args) throws IOException {
		
		
		WebDriver driver=new ChromeDriver();
		
		WebDriverUtility u=new WebDriverUtility();
		u.maximizeWindow(driver);
		u.waitTillPageLoad(driver);
		
		FileUtility fu=new FileUtility();
		String URL = fu.getPropertyData("url");
		// navigate to application
		driver.get(URL);
		
		String email="hit@gmail.com";
		String passw="123456";
		
		// click on signup button
		HomePage h=new HomePage(driver);
		h.getUsersignup().click();
		SignUpPage sp=new SignUpPage(driver);
		sp.userSignup("Hitendra", "9079835868", email, passw);
		//click on sign in button
		h.getUsersignin().click();
		// login as user
		 UserLoginPage ul=new UserLoginPage(driver);
	       ul.userLogin(email, passw);
	       
	       UserHomePage uh=new UserHomePage(driver);
	       uh.getMyprofilelink().click();
	       UpdateProFilePage up=new UpdateProFilePage(driver);
	       up.updateProfileName("Rahul");
	       // logout as user
	       
	       uh.logoutUser();
	       driver.quit();
	       
		
		
		

	}

}
