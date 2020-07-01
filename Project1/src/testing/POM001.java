package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class POM001 {
	
	WebDriver driver;
	By emailtxt = By.name("email");
	By passwordtxt = By.name("passwd");
	By submitBtn = By.name("SubmitLogin");
	By womensLink = By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[6]/ul/li[1]/a");
	
	public POM001(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setEmailtxt(String emails) {
		driver.findElement(emailtxt).sendKeys(emails);
	}
	public void setPassword(String pass) {
		driver.findElement(passwordtxt).sendKeys(pass);
	}
	public void setSubmit() {
		driver.findElement(submitBtn).click();
	}
	public void setWomensLink() {
		driver.findElement(womensLink).click();
	}
	
	
}
