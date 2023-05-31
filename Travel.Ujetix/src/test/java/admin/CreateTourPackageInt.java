package admin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.travel.ujetix.pom.AdminHomePage;
import com.travel.ujetix.pom.AdminLoginPage;
import com.travel.ujetix.pom.CreateTourPackagePage;
import com.travel.ujetix.pom.HomePage;

import ujetix.genericutilities.BaseClass;
import ujetix.genericutilities.ExcelUtility;
import ujetix.genericutilities.FileUtility;
import ujetix.genericutilities.JavaUtility;
import ujetix.genericutilities.WebDriverUtility;

public class CreateTourPackageInt  extends BaseClass{
	
	@Test
	public void createTourPackage ()throws Throwable {

		
		FileUtility f=new FileUtility();
		
		
		String URL = f.getPropertyData("url");
		String admin = f.getPropertyData("adminusername");
		String password = f.getPropertyData("password");
		WebDriver driver=new ChromeDriver();
		WebDriverUtility u=new WebDriverUtility();
		u.maximizeWindow(driver);
		u.waitTillPageLoad(driver);
		
		
		
		// click on tour package dropdown and click on create tab
		AdminHomePage ah=new AdminHomePage(driver);
		ah.clickCreatePackage(driver, u);
		
		// Fetching Test data from Excel File
		ExcelUtility eu=new ExcelUtility();
		eu.getExcelData("Sheet1", 1, 0);
		
		JavaUtility j=new JavaUtility();
		int no = j.getRandomNumber();
		String packageName = eu.getExcelData("Sheet1", 1, 0)+""+no;
		String packageType = eu.getExcelData("Sheet1", 1, 1);
		String location = eu.getExcelData("Sheet1", 1, 2);
		String features="Free Pickup and Drop Facility";
	    String details="Food will be free on First day";
	    String price="12000$";
	    String imgp="C:\\Users\\Hitendra singhal\\OneDrive\\Pictures\\Screenshots\\Screenshot (56).png";

		CreateTourPackagePage c=new CreateTourPackagePage(driver);
		//c.createTourPackage(driver,packageName, packageType, location, price, features, details, imgp);
		ExcelUtility e=new ExcelUtility();
		HashMap<String, String> h1 = e.getMultipleData("CreateTourPackage");// passing sheetname
		c.createTourPackage(h1, driver);
		c.getCreatepackagebutton().click();
		
		
      
		
		
		// logout as admin
		ah.adminLogout();
		
		// login as user
//		driver.findElement(By.xpath("//a[.='/ Sign In']")).click();
//		driver.findElement(By.xpath("//input[@placeholder='Enter your Email']")).sendKeys("usera@gmail.com");
//		driver.findElement(By.xpath("//input[@id=\"password\"]")).sendKeys("123456");
//		driver.findElement(By.xpath("//input[@name='signin']")).click();

		// click on tour packages major tab
		HomePage h=new HomePage(driver);
		h.getTourpackagestab().click();

		//verify that package will be created or not
		List<WebElement> packagenames = driver.findElements(By.xpath("//h4"));
         JavascriptExecutor je=(JavascriptExecutor) driver;
     int x=0;
     while(x<100)
     {
		try {

			for(int i=0;i<packagenames.size();i++)
			{
				String text = packagenames.get(i).getText();
				if(text.contains(packageName))
				{
					System.out.println(packageName+":Package is present");
					break;
				}
				
				System.out.println(10/0);
			}
		}
		catch(Exception e1)
		{
			je.executeScript("window.scrollTo(0,500)");
			x++;

		}
		driver.quit();
	}
	}





	





}


