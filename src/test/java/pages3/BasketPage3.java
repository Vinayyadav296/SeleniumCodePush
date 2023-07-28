package pages3;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper3.Base3;

public class BasketPage3 extends Base3 {
	
	public By AddToCartBtn=By.xpath("(//button[@class='btn_primary btn_inventory'])[1]");
	public By BasketCount=By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
	public By CartBtn=By.cssSelector("[data-icon='shopping-cart']");
	public By CheckOutBtn=By.xpath("//a[@class='btn_action checkout_button']");
	
	public void user_add_product_into_the_basket_from_plp_page() {
//		WebElement addToCartBtn=driver.findElement(By.xpath("(//button[@class='btn_primary btn_inventory'])[1]"));
//		           addToCartBtn.click();
		           explicitWaitVisibilityOfElement(AddToCartBtn).click();           
		
	}
    
	public void validateBasketCount() {
//		WebElement basketCount=driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']"));
//		 String  basketCountText = basketCount.getText();
//		         assertEquals("1",basketCountText);
		      String basketCountText =explicitWaitVisibilityOfElement(BasketCount).getText();
		      assertEquals("1",basketCountText);
	}
	
	public void user_navigate_to_cart_page() {
//		WebElement cartBtn=driver.findElement(By.cssSelector("[data-icon='shopping-cart']"));
//		           cartBtn.click();
//		WebElement checkoutBtn = driver.findElement(By.xpath("//a[@class='btn_action checkout_button']"));
//		           checkoutBtn.click();
		explicitWaitVisibilityOfElement(CartBtn).click();
		explicitWaitVisibilityOfElement(CheckOutBtn).click();
		
	}
}
