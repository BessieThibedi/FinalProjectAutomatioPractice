package Testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Payment_POM {
	
	WebDriver driver;
	By AddcartProceedCheckout = By.xpath("//*[@id=\"center_column\"]/p[2]/a[1]");
	By AddressProceedCheckout = By.name("processAddress");
	By termsRad = By.name("cgv");
	By shippingProceedCheckout = By.name("processCarrier");
	By btnBank = By.xpath("//*[@id=\"HOOK_PAYMENT\"]/div[2]/div");
	By btnConfirmOrder = By.xpath("//*[@id=\"cart_navigation\"]/button");
	By txtPaymentAmount = By.xpath("//*[@id=\"center_column\"]/div/span/strong");
	By signOutbtn = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
	
	public Payment_POM(WebDriver driver) {
		this.driver = driver;
	}
	
	public void setSignOutbtn() {
		driver.findElement(signOutbtn).click();
	}
	public void setAddcartProceedbtn() {
		driver.findElement(AddcartProceedCheckout).click();
	}public void setAddressProceedbtn() {
		driver.findElement(AddressProceedCheckout).click();
	}public void setTermsrad() {
		driver.findElement(termsRad).click();
	}public void setShippingProceedbtn() {
		driver.findElement(shippingProceedCheckout).click();
	}public void setBanktbn() {
		driver.findElement(btnBank).click();
	}public void setConfirmOrderbtn() {
		driver.findElement(btnConfirmOrder).click();
	}public String getPaymentAmount() {
		return driver.findElement(txtPaymentAmount).getText();
	}

}
