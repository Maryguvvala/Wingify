package Wingify.Wingify_Assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.Data_Fetching;

public class Wingify_Login_valid_credentials extends Wingify_Launch_Quit
{
	@Test
	public void valid_login_details() throws EncryptedDocumentException, IOException
	{
		Data_Fetching data = new Data_Fetching();
		data.fetch_data();
		
		Wingify_Login_Page login = new Wingify_Login_Page(driver);
		login.valid_un();
		login.valid_pwd();
		login.click_login();
		
		Wingify_Home_Page home_page = new Wingify_Home_Page(driver);
		
		//assertion is done on the username element which is visible only after successful login in the home page
		Assert.assertTrue(home_page.customer_name_text.isDisplayed()==true, "Login is not successful");
		
		Reporter.log("Login is successful");
		
	}

}
