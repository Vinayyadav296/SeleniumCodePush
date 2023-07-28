package stepDefinitions3;

import io.cucumber.java.en.Then;
import pages3.BasketPage3;
public class BaksetPageSteps3 {
	BasketPage3 bp=new BasketPage3();
	@Then("user add product into the basket from plp page")
	public void user_add_product_into_the_basket_from_plp_page() {
		bp.user_add_product_into_the_basket_from_plp_page();
	    bp.validateBasketCount();
	}

	@Then("user navigate to cart page")
	public void user_navigate_to_cart_page() {
	    bp.user_navigate_to_cart_page();
	}
}
