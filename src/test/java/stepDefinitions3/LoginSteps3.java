package stepDefinitions3;

import helper3.Base3;
//import helper3.Base3;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages3.LoginPage3;

//public class LoginSteps3 extends Base3 {

public class LoginSteps3  {
	LoginPage3 lp=new LoginPage3();
//	
//	@Given("user launch site url")
//	public void user_launch_site_url() {
//	   setup();
//	}

//	@And("user enter valid details")
//	public void user_enter_valid_details() {
//	    lp.user_enter_valid_details();
//	}
	
	@Given("user enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String uname, String pass) {
	      lp.user_enters_valid_username_and_password(uname, pass);
	}

	@Then("user click on login button")
	public void user_click_on_login_button() {
	     lp.user_click_on_login_button();
	}

	@Then("validate user login")
	public void validate_user_login() {
	    //  lp.validate_user_login();
	}

}
