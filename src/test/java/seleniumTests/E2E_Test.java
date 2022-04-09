package seleniumTests;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E_Test {
	static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\CPSAT\\eclipse-photon-workspace\\cpsat1415dec\\src\\test\\resources\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://shop.demoqa.com");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[contains(@class,'woocommerce-store-notice__dismiss-link')]")).click();
		
		driver.findElement(By.xpath("//header/div[2]/div[1]/a[1]/i[1]")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[3]/div[2]/form[1]/input[1]")).sendKeys("dress");
		driver.findElement(By.xpath("/html[1]/body[1]/div[2]/header[1]/div[3]/div[2]/form[1]/input[1]")).sendKeys(Keys.ENTER);
		
		List<WebElement> items = driver.findElements(By.cssSelector("div.noo-product-inner"));
		items.get(1).click();
		Select color =  new Select(driver.findElement(By.id("pa_color")));
		color.selectByIndex(1);
		Select size =  new Select(driver.findElement(By.id("pa_size")));
		size.selectByIndex(2);
		driver.findElement(By.xpath("//button[contains(text(),'Add to cart')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'View cart')]")).click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Proceed to checkout')]")).click();
		
		driver.findElement(By.id("billing_first_name")).sendKeys("Laks");
		driver.findElement(By.id("billing_last_name")).sendKeys("Sharma");
		driver.findElement(By.id("billing_address_1")).sendKeys("Street_1");
		driver.findElement(By.id("billing_address_2")).sendKeys("Apartment_1");
		driver.findElement(By.id("billing_city")).sendKeys("Hyderabad");
		//Select state =  new Select(driver.findElement(By.id("select2-billing_state-container")));
		//state.selectByVisibleText("Andhra Pradesh");
		//state.get(1).click();
		
		
		
		
		driver.findElement(By.id("select2-billing_state-container")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys("Andhra Pradesh");
		driver.findElement(By.xpath("//body/span[1]/span[1]/span[1]/input[1]")).sendKeys(Keys.ENTER);
		
		/*List<WebElement> statelist = driver.findElements(By.id("select2-billing_state-container)]"));
		for(WebElement state: statelist)
		{
		if(state.getText().equals("Goa")) {
			state.click();
			Thread.sleep(2000);	
			break;
		}
		}*/
		
		Thread.sleep(1000);
		driver.findElement(By.id("billing_postcode")).sendKeys("777859");
		driver.findElement(By.id("billing_phone")).sendKeys("8989787878");
		driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("test2@toolsqa.com");
		Thread.sleep(2000);
		
		JavascriptExecutor js =  (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
		driver.findElement(By.xpath("//*[@id=\"terms\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
		Thread.sleep(2000);
		
		JavascriptExecutor js2 =  (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,400)");
		String s1 = driver.findElement(By.xpath("//p[contains(text(),'Thank you. Your order has been received.')]")).getText();
		if(s1.equals("Thank you. Your order has been received."))
				{ 
					System.out.println("Order placed successfully");
				}
		 
	}
}
