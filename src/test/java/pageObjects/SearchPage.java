package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Steps;

public class SearchPage extends Steps{
	
	@FindBy(xpath="//header/div[2]/div[1]/a[1]/i[1]")WebElement searchicon;
	@FindBy(xpath="/html[1]/body[1]/div[2]/header[1]/div[3]/div[2]/form[1]/input[1]")WebElement searchcriteria;
	@FindBy(xpath="/html[1]/body[1]/div[2]/header[1]/div[3]/div[2]/form[1]/input[1]")WebElement enter;
	

    public SearchPage(WebDriver driver)
	{
	    this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		public void he_search_for(String sch) throws InterruptedException {
		searchicon.click();
		Thread.sleep(1000);
		searchcriteria.sendKeys("dress");
		enter.sendKeys(Keys.ENTER);	
		}

}
