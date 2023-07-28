package pages3;

import static org.junit.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import helper3.Base3;

public class CheckoutPage3 extends Base3 {
 
	// Different way of defining web elements
	
	public By FirstName=By.cssSelector("input#first-name");
	public By LastName=By.cssSelector("input#last-name");
	public By PostalCode=By.cssSelector("input#postal-code");
	public By ContinueButton=By.cssSelector("input.btn_primary.cart_button");
	public By FinishButton=By.xpath("//a[@class='btn_action cart_button']");
	public By OrderConfirmation=By.cssSelector("h2.complete-header");
	public By ErrorMessage=By.cssSelector("[data-test='error']");
	public void user_enters_information(String fname, String lname, String pcode) {
		
//		WebElement fName = driver.findElement(By.cssSelector("input#first-name"));
//		fName.sendKeys(fname);
		
		explicitWaitVisibilityOfElement(FirstName).sendKeys(fname);
		
//		WebElement lName = driver.findElement(By.cssSelector("input#last-name"));
//		lName.sendKeys(lname);
		
		explicitWaitVisibilityOfElement(LastName).sendKeys(lname);

//		WebElement pCode = driver.findElement(By.cssSelector("input#postal-code"));
//		pCode.sendKeys(pcode);
		
		explicitWaitVisibilityOfElement(PostalCode).sendKeys(pcode);

//		WebElement continueButton = driver.findElement(By.cssSelector("input.btn_primary.cart_button"));
//		continueButton.click();
		
		
 		explicitWaitVisibilityOfElement(ContinueButton).click();
		


	}

	public void user_place_order_with_cash_on_delivery() throws IOException {
//		WebElement finishButton=driver.findElement(By.xpath("//a[@class='btn_action cart_button']"));
//		           finishButton.click();
		   takeScreenShot();
		  explicitWaitVisibilityOfElement(FinishButton).click();
		  
           
		           
	}

	public void validate_order_confirmation() {
//		WebElement orderConfirmationHeading=driver.findElement(By.cssSelector("h2.complete-header"));
//		         String orderConfirmationText =  orderConfirmationHeading.getText();
//		         assertEquals("THANK YOU FOR YOUR ORDER",orderConfirmationText);
		         
		         String confirmationMessage=explicitWaitVisibilityOfElement(OrderConfirmation).getText();
		         assertEquals("THANK YOU FOR YOUR ORDER",confirmationMessage);
		         
	}
	
	public void validate_error_message() {
//	      WebElement errorMessage=driver.findElement(By.cssSelector("[data-test='error']"));
//	                 boolean errorMessageDisplay=errorMessage.isDisplayed();
//	                 Assert.assertTrue(errorMessageDisplay);
		
	              boolean errormsgDisplay = explicitWaitVisibilityOfElement(OrderConfirmation).isDisplayed();
	              Assert.assertTrue(errormsgDisplay);
	                 
	}

}
