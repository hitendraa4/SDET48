package ujetix.genericutilities;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.travel.ujetix.pom.AdminHomePage;
import com.travel.ujetix.pom.AdminLoginPage;
import com.travel.ujetix.pom.HomePage;

public class BaseClass {
	
	public ExcelUtility e=new ExcelUtility();
	public FileUtility f=new FileUtility();
	public WebDriverUtility wd=new WebDriverUtility();
	
	
	public static  WebDriver driver;
	
	@BeforeSuite
	public void dbconnectivity()
	{
		System.out.println("Database connection");
	}
	@Parameters("browser")
	@BeforeClass
	public void openBrowse(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		  driver=new ChromeDriver();
		}
		else if(browser.equals("edge"))
		{
			driver=new EdgeDriver();
		}

		driver.manage().window().maximize();
			
			
			
	}
	
	@BeforeMethod
	public void loginApp() throws IOException
	{
		String URL = f.getPropertyData("url");
		String admin = f.getPropertyData("adminusername");
		String password = f.getPropertyData("password");
		
		driver.get(URL);
		HomePage h=new HomePage(driver);
		h.getAdminloginlink().click();
		AdminLoginPage a=new AdminLoginPage(driver);
		a.getAdminusernametextfield().sendKeys(admin);
		a.getAdminpasswordtextfield().sendKeys(password);
		a.getSigninbutton().click();
	}
	
	@AfterMethod
	public void logout()
	{
		AdminHomePage a=new AdminHomePage(driver);
		a.adminLogout();
		
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
	 
	@AfterSuite
	public void databaseClose()
	{
		System.out.println("close database");
	}
	
	

}
