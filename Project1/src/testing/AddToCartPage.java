package testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img")
	WebElement itemImage;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/div[2]/a[2]")
	WebElement btnMore;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/p[1]/input")
	WebElement txtQuantity;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[2]/div/fieldset[1]/div/div/select")
	WebElement selectSize;
	@FindBy(xpath="/html/body/div/div[2]/div/div[3]/div/div/div/div[4]/form/div/div[3]/div[1]/p/button")
	WebElement btnAddToCart;
	@FindBy(css="div#layer_cart a > span")
	WebElement btnCheckout;
	@FindBy(xpath="/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a/span[1]")
	WebElement cartText;
	
	AddToCart_POM selenium;
	public AddToCartPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		selenium = new AddToCart_POM();
	}
	public boolean validateAddToCart(WebDriver driver) throws Exception {
		
		selenium.performMouseHover(itemImage, driver);
		selenium.Click(btnMore);
		selenium.clear(txtQuantity);
		selenium.setText("3", txtQuantity);
		selenium.SelectByVisibleText(selectSize, "M");
		selenium.Click(btnAddToCart);
		selenium.clickUsingJavaScriptExecutor(btnCheckout, driver);
		selenium.refresh(driver);
		//selenium.validateText(driver, cartText, "3");
		
		return selenium.validateText(driver, cartText, "3");
	}
	

}
