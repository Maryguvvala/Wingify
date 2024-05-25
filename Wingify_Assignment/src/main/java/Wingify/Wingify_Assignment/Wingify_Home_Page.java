package Wingify.Wingify_Assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Wingify_Home_Page 
{
	WebDriver driver;
	
//locating the components

	@FindBy (id="logged-user-name")
	WebElement customer_name_text; //user name element 

	@FindBy (xpath ="//td[@class='text-right bolder nowrap']//span")
	List<WebElement> before_sort; //stored all the values in list
	
	@FindBy (xpath ="//td[@class='text-right bolder nowrap']//span")
	List<WebElement> after_sort;  //stored all the values in list
	
	@FindBy (id="amount")
	WebElement amount_text; //amount text element from transaction table
	
	
//created separate methods for each components to perform action
	
	public void sorting_values()
	{
		List<Double> before_sort_price = new ArrayList<>();
		for(WebElement e: before_sort)
		{
			//converting string to double to replace
			before_sort_price.add(Double.valueOf(e.getText().replace(" ", "").replace("USD", "").replace(",", "")));
		}
		
		System.out.println("Original values - " +before_sort_price);
		amount_text.click();
		
		List<Double> after_sort_price = new ArrayList<>();
		for (WebElement e: after_sort)
		{
			//converting string to double to replace
			after_sort_price.add(Double.valueOf(e.getText().replace(" ", "").replace("USD", "").replace(",", "")));
		}
		
		Collections.sort(before_sort_price);//original values sorted
		
		System.out.println("Original values after sorting - " + before_sort_price);
		System.out.println("Sorted values after clicking on amount option - " + after_sort_price);
		
		Assert.assertEquals(before_sort_price,after_sort_price);// Assertion done to compare original values after sorted 
	}
	
	
//initializing the components
	
	public Wingify_Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
