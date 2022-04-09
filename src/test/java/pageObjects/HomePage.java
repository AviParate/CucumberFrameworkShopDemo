package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Steps;

public class HomePage extends Steps {
	
	 
	@FindBy(xpath="//a[contains(text(),'Dismiss')]")WebElement dismisslink;

		
	public HomePage(WebDriver driver)
	{
		this.driver =  driver;		
		PageFactory.initElements(driver, this);
	}

	public void user_is_on_Home_Page() throws Throwable
	{
		
		dismisslink.click();
	
	}
	

	
}
