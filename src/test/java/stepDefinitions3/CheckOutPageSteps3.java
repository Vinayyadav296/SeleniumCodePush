package stepDefinitions3;

import java.io.IOException;

import io.cucumber.java.en.Then;
import pages3.CheckoutPage3;
public class CheckOutPageSteps3  {
	CheckoutPage3 cp=new CheckoutPage3();
	@Then("user enters information {string} {string} {string}")
	public void user_enters_information(String firstName, String lastName, String postalCode) {
	        cp.user_enters_information(firstName, lastName, postalCode);
	}

	@Then("user place order with cash on delivery")
	public void user_place_order_with_cash_on_delivery() throws IOException {
	  cp.user_place_order_with_cash_on_delivery();
	}

	@Then("validate order confirmation")
	public void validate_order_confirmation() {
	   cp.validate_order_confirmation();
	}
	@Then("validate error message")
	public void validate_error_message() {
      cp.validate_error_message();
	}

}
