package stepDefinitions;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.PlacedOrder;
import pageObjects.ProductListingPage;
import pageObjects.SearchPage;
import utilities.ConfigFileReader;


public class Steps{

	protected WebDriver driver;
	public static String browsername;

	
	@Given("^user is on Home Page$")	
	public void user_is_on_Home_Page() throws Throwable {
		ConfigFileReader.ConfigFile();
		if(browsername.equalsIgnoreCase("Chrome"))
		{
		System.setProperty("webdriver.chrome.driver", ConfigFileReader.getchromepath());
		
		driver = new ChromeDriver();
		}
		if(browsername.equalsIgnoreCase("Edge"))
		{
		System.setProperty("webdriver.edge.driver", ConfigFileReader.getedgepath());
		driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(ConfigFileReader.applicationurl());
		HomePage home = new HomePage(driver);
		home.user_is_on_Home_Page();
		
	}
	


	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String arg1) throws Throwable  {
		SearchPage search = new SearchPage(driver);
		search.he_search_for(arg1);
	
	}	
	
	
	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		ProductListingPage list = new ProductListingPage(driver);
		list.choose_to_buy_the_first_item();
	}

	@When("^moves to checkout from mini mart$")
	public void moves_to_checkout_from_mini_mart() throws Throwable {
		CartPage cart = new CartPage(driver);
		cart.moves_to_checkout_from_mini_mart();
	}

	@When("^enter personal details on chekout page$")
	public void enter_personal_details_on_chekout_page() throws Throwable {
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.enter_personal_details_on_chekout_page();

	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
		PlacedOrder order =  new PlacedOrder(driver);
		order.place_the_order();

	}
	
	@AfterStep
	public void addScreenshot(Scenario scenario) throws IOException {

		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/jpeg", "image");
		
		//Object scrshot = new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);
		//ImageIO.write(((Screenshot) scrshot).getImage(), "JPG", new File("./Screenshots/"));
		
		//Shutterbug.shootPage(driver,ScrollStrategy.BOTH_DIRECTIONS,500,true).withName("Expected").save("D:\\CPSAT\\eclipse-photon-workspace\\CucumberFramework2\\Reports\\screen\\");
				
	}

	
}
