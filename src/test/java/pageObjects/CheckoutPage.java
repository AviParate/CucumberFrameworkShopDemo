package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stepDefinitions.Steps;

public class CheckoutPage extends Steps{
	
	@FindBy(id="billing_first_name")WebElement firstname;
	@FindBy(id="billing_last_name")WebElement lastname;
	@FindBy(id="billing_address_1")WebElement address1;
	@FindBy(id="billing_address_2")WebElement address2;
	@FindBy(id="billing_city")WebElement city;
	@FindBy(id="select2-billing_state-container")WebElement state1;
	@FindBy(xpath="//body/span[1]/span[1]/span[1]/input[1]")WebElement state2;
	@FindBy(xpath="//body/span[1]/span[1]/span[1]/input[1]")WebElement enter;
	@FindBy(id="billing_postcode")WebElement postcode;
	@FindBy(id="billing_phone")WebElement phone;
	@FindBy(xpath="//*[@id=\"billing_email\"]")WebElement email;
	@FindBy(xpath="//*[@id=\"terms\"]")WebElement terms;
	@FindBy(xpath="//*[@id=\"place_order\"]")WebElement placeorder;
	

	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void enter_personal_details_on_chekout_page() throws Throwable {
		firstname.sendKeys("Laks");
		lastname.sendKeys("Sharma");
		address1.sendKeys("Street_1");
		address2.sendKeys("Apartment_1");
		city.sendKeys("Hyderabad");
		state1.click();
		Thread.sleep(1000);
		state2.sendKeys("Andhra Pradesh");
		enter.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		postcode.sendKeys("777859");
		phone.sendKeys("8989787878");
		email.sendKeys("test2@toolsqa.com");
		Thread.sleep(2000);
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
		terms.click();
		placeorder.click();
		Thread.sleep(2000);
	}
	
	
}
