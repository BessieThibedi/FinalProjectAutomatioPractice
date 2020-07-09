package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_POM {

	

	
	WebDriver driver;
	By emailtxt = By.name("email");
	By passwordtxt = By.name("passwd");
	By submitBtn = By.name("SubmitLogin");
	
	
	public Login_POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setEmailtxt(String emails) {
		driver.findElement(emailtxt).sendKeys(emails);
	}
	public void setEmailClear() {
		driver.findElement(emailtxt).clear();
	}
	public void setPasswordClear() {
		driver.findElement(passwordtxt).clear();
	}
	public void setPassword(String pass) {
		driver.findElement(passwordtxt).sendKeys(pass);
	}
	public void setSubmit() {
		driver.findElement(submitBtn).click();
	}
	

	
}
