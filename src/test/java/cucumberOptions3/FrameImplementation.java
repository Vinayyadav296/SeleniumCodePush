package cucumberOptions3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameImplementation {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?org/openqa/selenium/package-summary.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		// Now switching to the frame
		driver.switchTo().frame("packageListFrame");
		WebElement firstLink=driver.findElement(By.xpath("//ul[@title='Packages']/li[1]/a"));  // this will give error of no such element because 
		                                                   // element is in the frame so we have to switch to frame
                   firstLink.click();
                // switching to main frame   
               driver.switchTo().defaultContent();    
             //  driver.switchTo().frame("packageFrame");// if we use it directly we will get an error because firstly we have to switch 
                                                       // to main frame
              // we can switch to frames using index also
               driver.switchTo().frame(0);
       //  WebElement helpLink=driver.findElement(By.xpath("(//ul[@title='Navigation'])[1]/li[8]/a"));
       //             helpLink.click(); 
	}

}
