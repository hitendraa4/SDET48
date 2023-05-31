package ujetix.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	
	/**
	 * this method maimize the window
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * this method is used to minimize the window
	 * @param driver
	 */
	public void minmizeWindow(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**
	 * this method is used to wait until page get load
	 * @param driver
	 */
	public void waitTillPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IPathConstant.implicitWaitDuration));
		
	}
	/**
	 * this method wait till Element to be visible
	 * @param driver
	 * @param elem
	 */
	public void waitTillElementToBeVisible(WebDriver driver, WebElement elem)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.visibilityOf(elem));
	}
	/**
	 * this method wait till element to click in UI
	 * @param driver
	 * @param elem
	 */
	public void waitTillElementToBeClickable(WebDriver driver,WebElement elem)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.elementToBeClickable(elem));
		
		
	}
	/**
	 * this method wait until the alert is Peresent
	 * @param driver
	 */
	public void waitForAlertPopup(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.alertIsPresent());
	}
	/**
	 * this method wait untile title to be visible in webpage
	 * @param driver
	 * @param title
	 */
	public void waitForATitle(WebDriver driver, String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * this method wait untilw url to be visible in webpage
	 * @param driver
	 * @param url
	 */
	public void waitForAUrl(WebDriver driver, String url)
	
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.explicitWaitDuration));
		wait.until(ExpectedConditions.urlContains(url));
}
	/**
	 * this method ignore NoSuchElementException if it gets
	 * @param driver
	 */
	public void ignoreNoSuchEleExc(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(IPathConstant.explicitWaitDuration));
		wait.ignoring(NoSuchElementException.class);
	}
	/**
	 * this method select element in dropdown by using index
	 * @param element
	 * @param index
	 */
	public void selectElementInDropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * this method is used to select element n drpdown by using value
	 * @param element
	 * @param index
	 */
	public void selectElementInDropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * this method is used to get All options from Dropdown
	 * @param element
	 */
	public void getAllOptionFromDropDown(WebElement element)
	{
		Select s=new Select(element);
		List<WebElement> aoptions = s.getOptions();
		for(WebElement i:aoptions)
		{
			String text = i.getText();
			System.out.println(text);
		}
	}
	/**
	 * this method is used to mouse over on element
	 * @param driver
	 * @param element
	 */
	public void mouseOverOnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
		
	}
	/**
	 * this method is used to right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();;
		
	}
	/**
	 * this method is used to double click on particular element
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver,WebElement element)
	{
		Actions a=new Actions(driver);
		a.doubleClick(element).perform();;
		
	}
	/**
	 * this method is used to switch on frame by index
	 * @param driver
	 * @param index
	 */
	public void switchFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * this method is used to switch on frame by id
	 * @param driver
	 * @param id
	 */
	public void switchFrame(WebDriver driver, String id)
	{
		driver.switchTo().frame(id);
	}
	/**
	 *  this method is used to switch on frame by element
	 * @param driver
	 * @param element
	 */
	public void switchFrame(WebDriver driver, WebElement element)
	{
		driver.switchTo().frame(element);
	}
	/**
	 * this method is used to switch default frame
	 * @param driver
	 */
	public void switchToDefaultFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopupAndAccept(WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		
		
		alt.accept();
	}
	/**
	 * this method is used to dismiss the alert popup
	 * @param driver
	 * @param text
	 */
	public void switchToAlertPopupAndDismiss(String text,WebDriver driver)
	{
		Alert alt = driver.switchTo().alert();
		
		if(alt.getText().trim().equalsIgnoreCase(text.trim()))
		{
			System.out.println("Alert is Present");
		}
		else {
			System.out.println("Alert is not present");
		}
		alt.dismiss();
	}
	/**
	 * this method is used to handle FileUpload Popup
	 * @param element
	 * @param path
	 */
public void FileUpload(WebElement element,String path)
{
	element.sendKeys(path);
}
/**
 * this method is used to provide user polling time
 * @param duration
 * @param element
 * @param pollingTime
 */
	public void customWait(int duration,WebElement element,long pollingTime )
	{
		int count=0;
		while(count<duration)
		{
			try {
				element.click();
				break;
			}
			catch(Exception e)
			{
				try {
					Thread.sleep(pollingTime);
				}
				catch(InterruptedException i)
				{
					i.printStackTrace();
				}
				count++;
			}
		}
	}
	/**
	 * this method is used to get ScreenShot
	 * @param driver
	 * @param ssName
	 * @return
	 * @throws IOException
	 */
   public String getScreenShot(WebDriver driver, String ssName) throws IOException
   {
	   TakesScreenshot t=(TakesScreenshot) driver;
	   File src = t.getScreenshotAs(OutputType.FILE);
	   LocalDateTime ldT = LocalDateTime.now();
	   File dest=new File("./screenshots/"+ssName+""+ldT+".png");
	   FileUtils.copyFile(src, dest);
	   return ssName;
   }
   public void switchWindow(WebDriver driver,String title)
   {
	   Set<String> set = driver.getWindowHandles();
	   for(String i:set)
	   {
		   driver.switchTo().window(i);
		   String text=driver.getTitle();
		   if(text.contains(title))
		   {
			   break;
		   }
	   }
   }
   /**
    * this method is used to switch child window
    * @param driver
    * @param url
    */
   public void switchingWindow(WebDriver driver,String url)
   {
	   Set<String> whs = driver.getWindowHandles();
	   Iterator<String> it=whs.iterator();
	   while(it.hasNext())
	   {
		   String wid=it.next();
		   driver.switchTo().window(wid);
		   String text=driver.getCurrentUrl();
		   if(text.contains(url))
		   {
			   break;
		   }
	   }
   }
}
	

