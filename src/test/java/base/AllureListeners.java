package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.io.ByteArrayInputStream;

import io.qameta.allure.Allure;

public class AllureListeners implements ITestListener{
	
	public WebDriver driver;
	
	private void takeScreenShot(String name)
	{
		driver= BaseClass.obj;
		byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		Allure.addAttachment(name, new ByteArrayInputStream(screenshot));
	}
	
	public void onTestSuccess(ITestResult result)
	{
		takeScreenShot("On Success : "+ result.getMethod().getMethodName());
	}
	
	public void onTestFailure(ITestResult result)
	{
		takeScreenShot("On Failure : "+ result.getMethod().getMethodName());
	}
	
	

}
