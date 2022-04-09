package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Steps;

public class CartPage extends Steps{
	
	@FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")WebElement proceedtocheckout;
	
	public CartPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
		public void moves_to_checkout_from_mini_mart() throws Throwable {
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
		proceedtocheckout.click();
		}

}
