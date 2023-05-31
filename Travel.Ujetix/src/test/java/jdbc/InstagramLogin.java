package jdbc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InstagramLogin {
	
	

	
	    public static void main(String[] args) {
	       

	        // Create a new instance of the ChromeDriver
	        WebDriver driver = new ChromeDriver();

	        // Navigate to the Instagram login page
	        driver.get("https://www.instagram.com/accounts/login/");

	        // Find the username and password input fields
	        WebElement usernameField = driver.findElement(By.name("username"));
	        WebElement passwordField = driver.findElement(By.name("password"));

	        // Enter the username and password
	        usernameField.sendKeys("your_username");
	        passwordField.sendKeys("your_password");

	        // Find and click the login button
	        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
	        loginButton.click();

	        // Wait for the home page to load
	        // You can use explicit waits or sleep here for simplicity
	        // For example: Thread.sleep(5000);

	        // Verify if the login was successful
	        if (driver.getCurrentUrl().equals("https://www.instagram.com/")) {
	            System.out.println("Login successful");
	        } else {
	            System.out.println("Login failed");
	        }

	        // Close the browser
	        driver.quit();
	    }
	}


