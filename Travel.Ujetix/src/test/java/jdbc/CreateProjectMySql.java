package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.cj.jdbc.Driver;

public class CreateProjectMySql {
	public static void main(String[] args) throws Exception {
		Driver driver1=new Driver();
		DriverManager.registerDriver(driver1);
		Connection con= DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects","root@%","root");
		try {
			Statement stat = con.createStatement();
			String query="Insert into project values('Ty_PROJ_0308','Hitendra','11/05/2023','Hitler','On Going',4)";
			 int result = stat.executeUpdate(query);
             if(result==1)
             {
            	 System.out.println("data is added");
             }
             else {
            	 System.out.println("data is not added");
             }
		
	}
		 finally {
			 con.close();
		}
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://rmgtestingserver:8084/");
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		
		
		
		driver.findElement(By.xpath("//button[.='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		List<WebElement> pn = driver.findElements(By.xpath("//tbody/child::tr/child::td[2]"));
		for(WebElement i:pn)
		{
			String prn=i.getText();
			if(prn.contains("Hitler"))
			{
				System.out.println("project is present");
				break;
				
			}
			
		}
}
}
