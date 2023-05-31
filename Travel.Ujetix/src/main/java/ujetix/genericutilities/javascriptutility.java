package ujetix.genericutilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class javascriptutility {
	
	public JavascriptExecutor js;
	
	/**
	 * Constructor to initialize the JavascriptExecutor object
	 * @param driver The WebDriver object
	 */
	public javascriptutility(WebDriver driver) {
		js = (JavascriptExecutor) driver;
	}
	
	/**
	 * Scrolls up the web page
	 */
	public void scrollUp() {
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}
	
	/**
	 * Scrolls to a specific element on the web page
	 * @param element The WebElement to scroll to
	 */
	public void scrollTillElement(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
	/**
	 * Scrolls down the web page
	 */
	public void scrllDown() {
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	/**
	 * Launches the application by navigating to the specified URL
	 * @param url The URL of the application
	 */
	public void launchApplication(String url) {
		js.executeScript("window.location=arguments[0]", url);
	}
	
	/**
	 * Enters the specified data into a WebElement using JavaScript Executor
	 * @param element The WebElement to enter data into
	 * @param data The data to be entered
	 */
	public void sendKeys(WebElement element, String data) {
		js.executeScript("arguments[0].value=arguments[1]", element, data);
	}
	
	/**
	 * Clicks on a WebElement using JavaScript Executor
	 * @param element The WebElement to click on
	 */
	public void click(WebElement element) {
		js.executeScript("arguments[0].click()", element);
	}
	
	/**
	 * Clicks on an element by its ID using JavaScript Executor
	 * @param elementID The ID of the element to click on
	 */
	public void clickElementById(String elementID) {
		js.executeScript("document.getElementById('elementID').clck()");
	}
	
	/**
	 * Retrieves the text value of a WebElement using JavaScript Executor
	 * @param element The WebElement to get the text from
	 * @return The text value of the WebElement
	 */
	public String getTheText(WebElement element) {
	String textFieldValue = (String) js.executeScript("return arguments[0].value", element);
		return textFieldValue;
	}
	
	/**
	 * Retrieves the URL of the current web page using JavaScript Executor
	 * @return The URL of the current web page
	 */
	public String getUrlOfCurrentPage() {
		String url = (String) js.executeScript("return window.location.href");
		return url;
	}
	
	/**
	 * Retrieves the title of the current web page using JavaScript Executor
	 * @return The title of the current web page
	 */
	public String getTitleOfCurrentPage() {
		String title = (String) js.executeScript("return document.title");
		return title;
	}
}
