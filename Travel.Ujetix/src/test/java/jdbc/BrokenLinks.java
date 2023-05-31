package jdbc;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrokenLinks {
      public static void main(String[] args) {
		
	
	WebDriver driver=new FirefoxDriver();
	driver.get("https://www.amazon.in/");
	driver.manage().window().maximize();
	 List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
	 ArrayList<String>  brokenLinks=new ArrayList<String>();
	 
	
	for(int i=0;i<allLinks.size();i++)
	{
		int statusCode=0;
		String links = allLinks.get(i).getAttribute("href");
		try {
			URL url=new URL(links);
			URLConnection con = url.openConnection();
			HttpURLConnection httpurlconnection=(HttpURLConnection)con;
			statusCode=httpurlconnection.getResponseCode();
			if(statusCode>=400)
			{
				brokenLinks.add(links+""+statusCode);
			}
		}
		catch(Exception e)
		{
			brokenLinks.add(links+" "+statusCode);
		}
	}
	
	for(String i:brokenLinks)
	{
		System.out.println(i);
	}
	
	
	
	
      }	
}
