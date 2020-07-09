package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginResults {
	
	WebDriver driver;
	
	By txtUsernameRes = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]");
	By loginHeader = By.xpath("//*[@id=\"center_column\"]/h1");
	
	public LoginResults(WebDriver driver) {
		this.driver=driver;
	}
	
	public String getUsernametxt() {
		return driver.findElement(txtUsernameRes).getText();
	}
	public String getloginHeader() {
		return driver.findElement(loginHeader).getText();
	}

}
