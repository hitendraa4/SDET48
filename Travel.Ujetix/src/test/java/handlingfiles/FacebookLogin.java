package handlingfiles;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FacebookLogin {

	public static void main(String[] args) throws IOException {
		WebDriver driver;
		FileInputStream fis=new FileInputStream("./src/test/resources/commondata.properties");
		Properties p=new Properties();
		p.load(fis);
		
            String URL = p.getProperty("url");
            String Browser = p.getProperty("browser");
            
            if(Browser.equalsIgnoreCase("Chrome"))
            {
            	driver=new ChromeDriver();
            }
            else if(Browser.equalsIgnoreCase("firefox"))
            {
            	driver=new FirefoxDriver();
            }
            else {
            	driver=new ChromeDriver();
            	
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(URL);
            
            List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
            FileInputStream fis1=new FileInputStream("./src/test/resources/testdata.xlsx");
            Workbook wb = WorkbookFactory.create(fis1);
           Sheet sheet = wb.getSheet("Sheet1");
            
            for(int i=0;i<allLinks.size();i++)
            {
            	sheet.createRow(i).createCell(0).setCellValue(allLinks.get(i).getAttribute("href"));
            }
            
            FileOutputStream fos=new FileOutputStream("./src/test/resources/testdata.xlsx");
            wb.write(fos);
            wb.close();
             
            
            
            
           
            
            
	}

}
