package cucumberOptions3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopUp {
     public static void main(String[] args) {
    		WebDriver driver=new ChromeDriver();
    	//	driver.get("https://the-internet.herokuapp.com/basic_auth"); // this is normal url launch 
    	// In the below code we are handling the authentication pop up in which we have to pass username and password
    	// inside the url like https://username:password@url	
    	    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    	    
    	       
	}

}
