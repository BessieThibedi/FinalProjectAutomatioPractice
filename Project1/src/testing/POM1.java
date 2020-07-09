package testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class POM1 {
	

	

WebDriver driver;
    

    By emailtxt = By.name("email_create");
    By submitbtn = By.name("SubmitCreate");
    By titleRad = By.id("id_gender2");
    By firstnameTxt = By.id("customer_firstname");
    By lastnameTxt = By.id("customer_lastname");
    By passwordTxt = By.id("passwd");
    By daysDropdwn = By.id("days");
    By monthsDropdown = By.id("months");
    By yearDropdown = By.id("years");
    By newsletterRad = By.id("newsletter");
    By specialsRad = By.id("optin");
    By adress1txt = By.id("address1");
    By adress2txt = By.id("address2");
    By cityTxt = By.id("city");
    By StateDrop = By.id("id_state");
    By postalcodeTxt = By.id("postcode");
    By countryDropdown = By.id("id_country");
    By additionalTxt = By.id("other");
    By Homephonetxt = By.id("phone");
    By MobilePhone = By.id("phone_mobile");
    By submitRegitrationBtn = By.id("submitAccount");
    By AccountName = By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span");
    By signOutbtn=By.xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[2]/a");
    By Pagetitle = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/h1");
    By Weelcomtxt = By.xpath("/html/body/div/div[2]/div/div[3]/div/p");
    By TotalAmount = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/span/strong");
    
    public POM1(WebDriver driver) {
        this.driver=driver;
    }
    
    public void setEmailtxt(String email) {
        driver.findElement(emailtxt).sendKeys(email);
    }
    public void setSubmitBtn() {
        driver.findElement(submitbtn).click();
    }
    public void setTitlerad() {
        driver.findElement(titleRad).click();
    }
    public void setFirstnametxt(String fname) {
        driver.findElement(firstnameTxt).sendKeys(fname);
    }
    public void setLastname(String lname) {
        driver.findElement(lastnameTxt).sendKeys(lname);
    }
    public void setPasswordtxt(String password) {
        driver.findElement(passwordTxt).sendKeys(password);
    }
    public void setDaysDropdwn(String days) {
        new Select (driver.findElement(daysDropdwn)).selectByValue(days);
    }
    public void setmonthDrop(String month) {
        new Select (driver.findElement(monthsDropdown)).selectByValue(month);
    }
    public void setYearDrop(String year) {
        new Select(driver.findElement(yearDropdown)).selectByValue(year);
    }
    public void setnewsletterRad() {
        driver.findElement(newsletterRad).click();
    }
    public void setspecialsRad() {
        driver.findElement(specialsRad).click();
    }
    public void setAddress1(String address1) {
        driver.findElement(adress1txt).sendKeys(address1);
    }
    public void setAddress2(String address2) {
        driver.findElement(adress2txt).sendKeys(address2);
    }
    public void setCity(String city) {
        driver.findElement(cityTxt).sendKeys(city);
    }
    public void setStateDrop(String state) {
        new Select (driver.findElement(StateDrop)).selectByValue(state);
    }
    public void setPostalCode(String postalCode) {
        driver.findElement(postalcodeTxt).sendKeys(postalCode);
    }
    public void setCountryDrop(String country) {
        new Select(driver.findElement(countryDropdown)).selectByValue(country);
    }
    public void setAdditionaltxt(String additionals) {
        driver.findElement(additionalTxt).sendKeys(additionals);
    }
    public void setHomePhone(String home) {
        driver.findElement(Homephonetxt).sendKeys(home);
    }
    public void setMobilePhone(String mobile) {
        driver.findElement(MobilePhone).sendKeys(mobile);
    }

      public void setRegisterbtn() {
      driver.findElement(submitRegitrationBtn).click(); }
     
    public String getAccountName() {
        return driver.findElement(AccountName).getText();
    }
    public Boolean getAccountExist() {
        return driver.findElement(AccountName).isDisplayed();
    }
    
    
    public void setLogoutbtn() {
        driver.findElement(signOutbtn).click();
    }
    public String getPageTitle() {
        return driver.findElement(Pagetitle).getText();
    }
    public boolean getWelcometxt() {
    	return driver.findElement(Weelcomtxt).isDisplayed();
    }
    public String getWelcoming() {
    	return driver.findElement(Weelcomtxt).getText();
    }
    public String getTotalAmount() {
    	return driver.findElement(TotalAmount).getText();
    }
	
}
