package Wingify.Wingify_Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Data_Fetching;

public class Wingify_Login_Page extends Data_Fetching
{
	WebDriver driver;
	
//locating the components
	@FindBy (id="username")
	WebElement username_tf; //user name text field
	
	@FindBy (id="password")
	WebElement password_tf; //password text field
	
	@FindBy (id="log-in")
	WebElement login_button; //login button
	
	@FindBy (xpath="//div[.='Password must be present']")
	WebElement error_msg_text; //password must be present error msg
	
//created separate methods for each components to perform action
	public void valid_un()
	{
		username_tf.isDisplayed();
		username_tf.isEnabled();
		username_tf.sendKeys(valid_username);
	}
	
	public void valid_pwd()
	{
		password_tf.isDisplayed();
		password_tf.isEnabled();
		password_tf.sendKeys(valid_pwd);
	}
	
	public void click_login()
	{
		login_button.isDisplayed();
		login_button.isEnabled();
		login_button.click();
	}
	
	
//initializing the components
	
	public Wingify_Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
}
