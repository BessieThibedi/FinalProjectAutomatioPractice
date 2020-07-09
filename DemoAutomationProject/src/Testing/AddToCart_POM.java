package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class AddToCart_POM {
	
	WebDriver driver;
	Actions action;
	
	By womensLink = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a");
	By dressLink = By.xpath("//*[@id=\"block_top_menu\"]/ul/li[2]/a");
	By itemImage = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[1]/div/a[1]/img");
	By Morebtn = By.xpath("//*[@id=\"center_column\"]/ul/li[2]/div/div[2]/div[2]/a[2]");
	By Quantitytxt = By.name("qty");
	By Sizetxt = By.name("group_1");
	By AddtoCartSubmitbtn = By.name("Submit");
	By proceedCheckoutbtn = By.cssSelector("div#layer_cart a > span");
	By addToCartbtn = By.xpath("//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a");
	
	
	
	
	public AddToCart_POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setWomensLink() {
		driver.findElement(womensLink).click();
	}
	public void setAddCarbtn() {
		driver.findElement(addToCartbtn).click();
	}
	public void setDressLink() {
		driver.findElement(dressLink).click();
	}
	public void performMouseHover() {
		action = new Actions(driver);
		WebElement btn = driver.findElement(itemImage);
        action.moveToElement(btn).perform();
	}
	public void setMorebtn() {
		driver.findElement(Morebtn).click();
	}
	public void setQuantityfield() {
		driver.findElement(Quantitytxt).clear();
	}
	public void setQuantity(String quantity) {
		driver.findElement(Quantitytxt).sendKeys(quantity);
	}
	public void setSize(String size) {
		new Select (driver.findElement(Sizetxt)).selectByValue(size);
	}public void setAddtoCartSubmit() {
		driver.findElement(AddtoCartSubmitbtn).click();
	}
	
	public void clickUsingJavaScriptExecutor() {
		//create javascript executor
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		WebElement pc = driver.findElement(proceedCheckoutbtn);
		executor.executeScript("arguments[0].click();", pc);
	}
	public void refresh(WebDriver driver) {
		driver.navigate().refresh();
	}
	

}
