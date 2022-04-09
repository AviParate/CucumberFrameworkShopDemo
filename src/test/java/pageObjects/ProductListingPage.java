package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import stepDefinitions.Steps;

public class ProductListingPage extends Steps {


	@FindBy(css = "div.noo-product-inner")List<WebElement> productlist;
	@FindBy(id = "color")WebElement color;
	@FindBy(id = "size")WebElement size;
	@FindBy(xpath = "//button[contains(text(),'Add to cart')]")WebElement addtocart;
	@FindBy(xpath = "//a[contains(text(),'View cart')]")WebElement viewcart;
	
	public ProductListingPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	

		public void choose_to_buy_the_first_item() throws Throwable {
		productlist.get(15).click();
		Select col =  new Select(color);
		col.selectByIndex(1);
		Select sz =  new Select(size);
		sz.selectByIndex(2);
		addtocart.click();
		viewcart.click();
	}
}
