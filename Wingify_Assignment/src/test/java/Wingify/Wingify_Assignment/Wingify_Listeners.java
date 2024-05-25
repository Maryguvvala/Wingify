package Wingify.Wingify_Assignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class Wingify_Listeners  implements ITestListener
{
	static WebDriver driver;
	
	@Override
	public void onTestSuccess(ITestResult result) 
	{
		Reporter.log("Testcase passed");
		ITestListener.super.onTestSuccess(result);
		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\KING\\eclipse-workspace\\Wingify_Assignment\\Wingify_screenshot\\Wingify_Pass\\pass."+Math.random()+".png");
	    try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestFailure(ITestResult result) 
	{
		Reporter.log("Testcase failed");
		ITestListener.super.onTestFailure(result);
		TakesScreenshot tss = (TakesScreenshot) driver;
		File source = tss.getScreenshotAs(OutputType.FILE);
		File destination = new File("C:\\Users\\KING\\eclipse-workspace\\Wingify_Assignment\\Wingify_screenshot\\Wingify_Fail\\fail."+Math.random()+".png");
	    try {
			FileUtils.copyFile(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
