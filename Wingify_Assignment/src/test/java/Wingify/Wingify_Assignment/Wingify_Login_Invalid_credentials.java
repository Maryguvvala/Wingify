package Wingify.Wingify_Assignment;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import utility.Data_Fetching;

public class Wingify_Login_Invalid_credentials extends Wingify_Launch_Quit
{

	@Test
	public void invalid_login_details() throws EncryptedDocumentException, IOException
	{
		Data_Fetching data = new Data_Fetching();
		data.fetch_data();
		
		Wingify_Login_Page login = new Wingify_Login_Page(driver);
		login.valid_un();
		login.click_login();
		
		//Assertion is done on the error text message that is visible if we do not pass the required values
		Assert.assertTrue(login.error_msg_text.isDisplayed()==true , "Login is successful");
		
		Reporter.log("Login is not successful");
	}

}
