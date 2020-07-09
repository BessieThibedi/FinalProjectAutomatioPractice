package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddToCartResults_POM {
	
	WebDriver driver;
	
	By txtCarQuantity = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[1]");
	By txtCarTotalPrice = By.id("total_price");
	
public AddToCartResults_POM(WebDriver driver) {
	this.driver=driver;
}	

public String getCartQuantity() {
	return driver.findElement(txtCarQuantity).getText();
}
public String getCartTotalPrice() {
	return driver.findElement(txtCarTotalPrice).getText();
}




}
