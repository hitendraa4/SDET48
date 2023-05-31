package javascriptpractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import ujetix.genericutilities.javascriptutility;

public class JavaScriptPractice {

	public static void main(String[] args) throws InterruptedException {
     WebDriver driver=new ChromeDriver();
     
     
     
     // get url of current page
    javascriptutility JS=new javascriptutility(driver);
    JS.launchApplication("https://docs.phptravels.com/");
    String url=JS.getUrlOfCurrentPage();
     System.out.println(url);
     
     // get the title of current page
     String title = JS.getTitleOfCurrentPage();
     System.out.println(title);
     // ScrollDown
     Thread.sleep(2000);
     JS.scrllDown();
     Thread.sleep(2000);
     
     JS.scrollUp();
     
     // scrollTillElement // scrollBar1 (click on api response erroer link)
     WebElement element=driver.findElement(By.xpath("//div[@data-testid='page.desktopTableOfContents']//div[.='API Response Error']"));
     JS.scrollTillElement(element);
     // click 
     Thread.sleep(2000);
     JS.click(element);
     
     WebElement smily = driver.findElement(By.xpath("/html/body/div[1]/div/div/div[2]/div/div[2]/div[2]/div/main/div[2]/div[2]/div/div/div/div[2]/div/div[2]/div/div[2]/div[3]/div/svg"));
     // scroll and click on particular Element
     JS.scrollTillElement(smily);
     JS.click(smily);
     
	}

}
