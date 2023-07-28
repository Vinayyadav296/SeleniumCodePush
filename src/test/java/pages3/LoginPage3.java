package pages3;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper3.Base3;


public class LoginPage3 extends Base3{
	
	public By UserName=By.xpath("//input[@id='user-name']");
	public By Password=By.xpath("//input[@id='password']");
	public By loginButton=By.xpath("//input[@id='login-button']");	
     
//	public void user_enter_valid_details() {
//	     WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
//	                userName.sendKeys("standard_user");
//	     WebElement password=driver.findElement(By.xpath("//input[@id='password']"));
//	                password.sendKeys("secret_sauce");
//	}
	
	public void user_enters_valid_username_and_password(String email, String passw) {
//		WebElement userName=driver.findElement(By.xpath("//input[@id='user-name']"));
//		           userName.sendKeys(email);
//	    WebElement password=driver.findElement(By.xpath("//input[@id='password']"));      
//	               password.sendKeys(passw);
		
		explicitWaitVisibilityOfElement(UserName).sendKeys(email);
		explicitWaitVisibilityOfElement(Password).sendKeys(passw);
		
	}

    public void user_click_on_login_button() {
//	   WebElement loginButton=driver.findElement(By.xpath("//input[@id='login-button']"));
//	              loginButton.click();
    	explicitWaitVisibilityOfElement(loginButton).click();
	}

	public void validate_user_login() {
		WebElement invalidDetailsElement=driver.findElement(By.cssSelector("[data-test='error']"));
	       boolean invalidDetailMessage =  invalidDetailsElement.isDisplayed();
	            Assert.assertTrue(invalidDetailMessage);
	} 
}
