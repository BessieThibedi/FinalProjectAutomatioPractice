package testing;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainTest {
	WebDriver driver;
	AddToCartPage page;
	 
	
	
  @BeforeTest
  public void OpenBrowser() {
	  
	  System.setProperty(Constants.browser, Constants.browserLocation);
	  driver = new ChromeDriver();
	  driver.get(Constants.link);
	  driver.manage().window().maximize();
	  
	  POM001 login = new POM001(driver);
	  login.setEmailtxt("this1@this1.com");
	  login.setPassword("this1this");
	  login.setSubmit();
	  
	  login.setWomensLink();
	 
  }
  

  
  @Test
  public void ValidateAddtoCart() throws Exception {
	  
	  
	  page=new AddToCartPage(driver);
	  
	 Assert.assertTrue(page.validateAddToCart(driver));
	  
	  
	  //driver.close();
	  
  }
  
	/*
	 * @Test public void ValidateAmountToPay() { POM001 login = new POM001(driver);
	 * 
	 * // String ActualResults =
	 * 
	 * 
	 * }
	 */
  
}
