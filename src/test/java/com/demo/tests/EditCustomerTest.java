package com.demo.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.demo.base.Initializer;
import com.demo.pages.EditCustomerPage;
import com.demo.pages.LoginPage;
import com.demo.pages.NewCustomerPage;
import com.demo.utils.ConfigReader;
import com.demo.utils.WebDriverUtli;

public class EditCustomerTest extends Initializer{

	LoginPage loginPage;
	EditCustomerPage editCustomerPage;
	NewCustomerPage newCustomerPage;
	WebDriverUtli webDriverUtil;
	
	private boolean isLoggedIn = false;
	
	@BeforeMethod
	public void setup() {
		super.setup();
		loginPage = new LoginPage(driver);
		editCustomerPage = new EditCustomerPage(driver);
		newCustomerPage = new NewCustomerPage(driver);
		webDriverUtil = new WebDriverUtli(driver);
		
		if(!isLoggedIn) {
			loginPage.setUsername(ConfigReader.getProperty("username"));
			loginPage.setPassword(ConfigReader.getProperty("password"));
			loginPage.submit();
			isLoggedIn = true;
			webDriverUtil.waitForNewUrl(ConfigReader.getProperty("home.url"));
		} 
		
	}
	
	@Test
	public void EditCustomer() {
	
		test = extent.createTest("Edit Customer");
		driver.get(ConfigReader.getProperty("editCustomer.url"));
		
		
		test.info("Redirected to Edit Customer Page");
		
		editCustomerPage.setCustomerID("46757");
		editCustomerPage.submit();
		test.info("Customer Id entered and submitted");
		
		webDriverUtil.waitForElementVisibleByName("addcust");
	
		newCustomerPage.setAddress("Himanshu");
		test.info("new address Entered");
		
		editCustomerPage.formSubmit();
		test.pass("Submitted and Modified");
	}
	
	
	@Test
	public void InvalidCustomerId() {
		test = extent.createTest("Invalid Customer ID");
		
		driver.get(ConfigReader.getProperty("editCustomer.url"));
		test.info("Redirected to Edit Customer Page");
		
		
		webDriverUtil.waitForElementVisibleByName("fbal");
		
		editCustomerPage.setCustomerID("46727");
		editCustomerPage.submit();
		test.info("Customer Id entered and submitted");
		webDriverUtil.waitForAlert();
		test.pass("Invalid Customer ID Test Passed");		
		
	}
	
	
	@AfterMethod
	public void logout() {
		super.logout();
	}

}
