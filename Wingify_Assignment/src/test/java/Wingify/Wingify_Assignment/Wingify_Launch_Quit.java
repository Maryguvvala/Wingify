package Wingify.Wingify_Assignment;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;


@Listeners(Wingify_Listeners.class)


public class Wingify_Launch_Quit extends Wingify_Listeners
{
	@BeforeMethod
	@Parameters("browser")
    public void pre_condition(String name_of_browser)
    {
		if(name_of_browser.equals("chrome"))
		{
			driver = new ChromeDriver();
		}
		if(name_of_browser.equals("firefox"))
		{
			driver = new FirefoxDriver();
		}
		if(name_of_browser.equals("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.get("https://sakshingp.github.io/assignment/login.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
    }
	
	@AfterMethod
	public void closure_activity() throws InterruptedException
	{
		Thread.sleep(1000);
		driver.quit();
	}
	

}
