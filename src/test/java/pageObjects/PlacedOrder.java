package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Steps;

public class PlacedOrder extends Steps {
	
	public PlacedOrder(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void place_the_order() throws Throwable {
		JavascriptExecutor js2 =  (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,400)");
		String s1 = driver.findElement(By.xpath("//p[contains(text(),'Thank you. Your order has been received.')]")).getText();
		if(s1.equals("Thank you. Your order has been received."))
				{ 
					System.out.println("Order placed successfully");
				}
	}

}
