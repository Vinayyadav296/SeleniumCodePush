package helper3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base3 {
	public static WebDriver driver;
	public static Properties prop;

	static {
		FileInputStream file;
		try {

			// this path in the file input Stream parameter is my laptop specific path if
			// the
			// project is exported someone else system then
			// this path will not work so we have to make this path generic
//						 file = new
//						 FileInputStream("C:\\Users\\dell\\eclipse-workspace\\com.SwagLabs\\src\\test\\java\\resources\\environment.properties");
			// user.dir Represent current directory and we have to add the resources path
			// with it
			file = new FileInputStream(
					System.getProperty("user.dir") + "/src/test/java/resources3/environment.properties");
			prop = new Properties();
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Before
	public void setup() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			// WebDriverManager.chromedriver().setup(); // from the version 4 of the
			// selenium we do not need to write this code it is not required
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		driver.get(prop.getProperty("url")); // URL Launch
		driver.manage().deleteAllCookies(); 
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}

	@After
	public void tearDown(Scenario s) throws IOException {
		if (s.isFailed()) {
			// takeScreenShot();
			TakesScreenshot ts = ((TakesScreenshot) driver);
			File src = ts.getScreenshotAs(OutputType.FILE);
//	      	 FileUtils.copyFile(src, new File("Screenshots/test.png"));
			FileUtils.copyFile(src, new File("Screenshots/" + s.getName() + ".png"));
		}
		driver.quit();
	}

	// Creating a generic method for selecting the dropdown by visible Text it can
	// be reused anywhere
//		public void selectByVisibleText(WebElement ele, String value) {
	public void selectByVisibleText(By ele, String value) {
//		Select s = new Select(ele);
		Select s = new Select(driver.findElement(ele));
		s.selectByVisibleText(value);
	}

//		public void selectByIndex(WebElement ele, int value) {
	public void selectByIndex(By ele, int value) {
//			Select s = new Select(ele);
		Select s = new Select(driver.findElement(ele));
		s.selectByIndex(value);
	}

//		public void selectByValue(WebElement ele, String value) {
	public void selectByValue(By ele, String value) {
//			Select s = new Select(ele);
		Select s = new Select(driver.findElement(ele));
		s.selectByValue(value);
	}

	// Mouser Hover Generic Method

//		public void hoverMouse(WebElement ele) {
	public void hoverMouse(By ele) {
		Actions action = new Actions(driver);
//			action.moveToElement(ele).build().perform();
		action.moveToElement(driver.findElement(ele)).build().perform(); // converting this locator into by type

	}

	// Explicit Wait Generic Method on visibility of element

//		public void explicitWaitVisibilityOfElement(WebElement ele) {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // this driver is the same
//																							// WebDriver reference which is
//																							// defined at the global level
//			wait.until(ExpectedConditions.visibilityOf(ele));
//		}
//		
//		public void explicitWaitElementToBeClickable(WebElement ele) {
	public void explicitWaitElementToBeClickable(By ele) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15)); // this driver is the same
																				// WebDriver reference which is
																				// defined at the global level
//			wait.until(ExpectedConditions.elementToBeClickable(ele));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}

	// Here the method is defined in return manner
	public WebElement explicitWaitVisibilityOfElement(By by) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	// JavaScript Executor generic Method
//		public void jsExecutorClick(WebElement ele) {
	public void jsExecutorClick(By ele) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
//	        js.executeScript("arguments[0].click();",ele);
		js.executeScript("arguments[0].click();", driver.findElement(ele));

	}

	// AlertPopUp generic Method

	public void handleAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		alert.dismiss();
	}

	// Generic method to take screenshot screenshot is an interface in selenium
	public void takeScreenShot() throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
//      	 FileUtils.copyFile(src, new File("Screenshots/test.png"));
		FileUtils.copyFile(src, new File("Screenshots/" + System.currentTimeMillis() + "png"));
	}

}
