package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;



public class MainTestClass {
	
	WebDriver driver;
	
	 @BeforeTest
	  public void OpenBrowser() {
		 
		 System.setProperty(Constants.browser, Constants.browserLocation);
		  driver = new ChromeDriver();
		  driver.get(Constants.link);
		  driver.manage().window().maximize();
		 
	 }
	

}
