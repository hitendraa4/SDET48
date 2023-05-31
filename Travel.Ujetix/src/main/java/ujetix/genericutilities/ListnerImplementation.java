package ujetix.genericutilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImplementation  implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String name=result.getMethod().getMethodName();
		System.out.println("Listening");
		TakesScreenshot t=(TakesScreenshot) BaseClass.driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		 LocalDateTime localdatetime = LocalDateTime.now();
		 String cdate = localdatetime.toString().replace(" ", "_").replace(":", "_");
		 
		 File dst=new File("screenshots/"+" "+name+" "+cdate+".png");
		 
		 try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		  
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		;
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}
	
	

}
