package jdbc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class CreateProject {
	
	
public static void main(String[] args) throws AWTException, SQLException {
	WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://rmgtestingserver:8084/");
	driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
	driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
	
	
	
	driver.findElement(By.xpath("//button[.='Sign in']")).click();
	driver.findElement(By.xpath("//a[text()='Projects']")).click();
	driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
	driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys("Automation");
	driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("Hitendra");
	WebElement dropdown = driver.findElement(By.xpath("//label[text()='Project Status ']/following-sibling::select"));
	Select s=new Select(dropdown);
	s.selectByVisibleText("On Gogin");
	driver.findElement(By.xpath("//input[@value='Add Project']")).click();
	
	
	String pname="Automation";
	
	Driver driver1=new Driver();
	DriverManager.registerDriver(driver1);
	Connection con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
	try {
		Statement stat = con.createStatement();
	String query="Select * from project";
	 ResultSet result = stat.executeQuery(query);
     while(result.next())
     {
    	 String s1=result.getString(4);
    	 if(s1.contains(pname))
    	 {
    		 System.out.println("project created successfully");
    	 }
    	 
     }
	
	
}
 finally {
	 con.close();
}

driver.close();

	
	
	
	
}
}
