package Testing;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class TestClass {
	WebDriver driver;
	 ExtentReports extent;
	 ExtentTest test;
	 ExtentHtmlReporter htmlReporter;
	 
	 
	  @Test (priority = 0)
	  public void Login() throws Exception {

		  test = extent.createTest("TC1: Login verification", "verify login for valid and invalid credentials");
		  ExcelUtils.setExcelFile(Constants.excelLocation + Constants.excelFilename,Constants.sheetname);
		  Login_POM login = new Login_POM(driver);
		  
		  int totalrows = ExcelUtils.getNumberRows();
		  for(int i=1; i <= totalrows; i++) {
					  login.setEmailClear();
				  login.setEmailtxt(ExcelUtils.getCellData(i, 0));
				  login.setPasswordClear();
				  login.setPassword(ExcelUtils.getCellData(i, 1));
				  login.setSubmit();
				 
				  LoginResults loginResult = new LoginResults(driver);
				  
				  String usernames = loginResult.getUsernametxt();
				  ExcelUtils.setCellData(usernames, i, 4);
				  
				  String Actualusernames = loginResult.getloginHeader();
				  String Expectedusername = ExcelUtils.getCellData(i, 2);
				  
				  if(Actualusernames.equalsIgnoreCase(Expectedusername)) {
					  
					  ExcelUtils.setCellData(Actualusernames, i, 3);
					  ExcelUtils.setCellData("Pass", i, 5); 
				  }else {
					  ExcelUtils.setCellData(Actualusernames, i, 3);
					  ExcelUtils.setCellData("fail", i, 5); 
				  }
		  } Assert.assertTrue(true);
	  }
	
  @Test (priority = 1)
  public void AddToCart() throws Exception {
	  
	  test = extent.createTest("TC1: Add to cart verification", "verify that the wuantity of items in cart are correct");
	  
	  ExcelUtils.setExcelFile(Constants.excelLocation + Constants.excelFilename,Constants.sheetname2);
	  AddToCart_POM addCart = new AddToCart_POM(driver);
	  addCart.setWomensLink();
	  
	  int totalrows = ExcelUtils.getNumberRows();
	  
	  for(int i=1; i <= totalrows; i++) {
	 
	  addCart.performMouseHover();
	  addCart.setMorebtn();
	  addCart.setQuantityfield();
	  addCart.setQuantity(ExcelUtils.getCellData(i, 0));
	  addCart.setSize(ExcelUtils.getCellData(i, 1));
	  addCart.setAddtoCartSubmit();
	  driver.manage().timeouts().implicitlyWait(100000, TimeUnit.SECONDS);
	  addCart.clickUsingJavaScriptExecutor();
	  addCart.refresh(driver);
	  
	  AddToCartResults_POM cartResults = new AddToCartResults_POM(driver);
	  
	  String ActualQuantityResults = cartResults.getCartQuantity();
	  String ExpectedQuantityResults = ExcelUtils.getCellData(i, 2);
	  
	  if(ActualQuantityResults.equalsIgnoreCase(ExpectedQuantityResults)) {
		  ExcelUtils.setCellData(ActualQuantityResults, i, 3);
		  ExcelUtils.setCellData("Pass", i, 4);
	  }else {
		  ExcelUtils.setCellData(ActualQuantityResults, i, 3);
		  ExcelUtils.setCellData("Fail", i, 4);
	  }
	  addCart.setDressLink();
	  
	  
	  }
	  addCart.setAddCarbtn();
	  
	  
	  Assert.assertTrue(true);
  }
  
	
	  @Test (priority = 2)
	  public void PaymentPage() throws Exception { 
		  
		  test = extent.createTest("TC3: Payment verification", "verify that the total amount for all items in cart is correct to the total amount due to pay");
		  
		  ExcelUtils.setExcelFile(Constants.excelLocation + Constants.excelFilename,Constants.sheetname3);
		  Payment_POM payment = new Payment_POM(driver);
		  
		  payment.setAddcartProceedbtn();
		  payment.setAddressProceedbtn();
		  payment.setTermsrad();
		  payment.setShippingProceedbtn();
		  payment.setBanktbn();
		  payment.setConfirmOrderbtn();
		  
		  String ActualAmountTotalResults = payment.getPaymentAmount();
		  String ExpectedAmountTotalResults = ExcelUtils.getCellData(1, 0);
		  
		  if(ActualAmountTotalResults.equalsIgnoreCase(ExpectedAmountTotalResults)) {
			  ExcelUtils.setCellData(ActualAmountTotalResults, 1, 1);
			  ExcelUtils.setCellData("Pass", 1, 2); 
		  }else { ExcelUtils.setCellData(ActualAmountTotalResults, 1, 1);
		  ExcelUtils.setCellData("fail", 1, 2);}
		  
		  Assert.assertTrue(true);
	  }
	 
  

	  @AfterTest 
	  public void Logout() { 
		  Payment_POM payment = new Payment_POM(driver); 
		  payment.setSignOutbtn();
		  
		  driver.quit(); 
		  }
	 
	  @Parameters({ "OS", "browser" })
  @BeforeTest
  public void OpenBrowser(String OS, String browser) {
	 // htmlReporter.config().setDocumentTitle("ReportTest.html");
	// initialize the HtmlReporter
      htmlReporter = new ExtentHtmlReporter("TestNGReport.html");
      
      //initialize ExtentReports and attach the HtmlReporter
      extent = new ExtentReports();
      extent.attachReporter(htmlReporter);
       
      //To add system or environment info by using the setSystemInfo method.
      extent.setSystemInfo("OS", OS);
      extent.setSystemInfo("Browser", browser);
      
      //configuration items to change the look and feel
      //add content, manage tests etc
      htmlReporter.config().setDocumentTitle("Automation E-commerce shopping site");
      htmlReporter.config().setReportName("Test Reports Ffor MECURY TOURS APPLICATION");
      htmlReporter.config().setTheme(Theme.STANDARD);
      htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
	  
      
	  
	  
		
		  System.setProperty(Constants.browser, Constants.browserLocation); 
		  driver =new ChromeDriver(); 
		  driver.get(Constants.link);
		  driver.manage().window().maximize();
		 
  }

	
	  
	 
	  
	  
	  @AfterMethod
	    public void getResult(ITestResult result) {
	        if(result.getStatus() == ITestResult.FAILURE) {
	            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" FAILED ", ExtentColor.RED));
	            test.fail(result.getThrowable());
	        }
	        else if(result.getStatus() == ITestResult.SUCCESS) {
	            test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" PASSED ", ExtentColor.GREEN));
	        }
	        else {
	            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" SKIPPED ", ExtentColor.ORANGE));
	            test.skip(result.getThrowable());
	        }
	    }
	  
	  
	 

}
