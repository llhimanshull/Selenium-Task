package com.demo.tests;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demo.base.Initializer;
import com.demo.pages.LoginPage;
import com.demo.pages.NewCustomerPage;
import com.demo.utils.ConfigReader;
import com.demo.utils.ExcelReader;
import com.demo.utils.WebDriverUtli;

public class NewCustomerTest extends Initializer{

	LoginPage loginPage;
	NewCustomerPage newCustomerPage;
	WebDriverUtli webDriverUtil;
	
	
	@BeforeMethod
	public void setup() {
		super.setup();
		loginPage = new LoginPage(driver);
		newCustomerPage = new NewCustomerPage(driver);
		webDriverUtil = new WebDriverUtli(driver);	
	}
	
	
	@DataProvider(name = "customerData")
	public Object[][] getCustomerData() throws IOException{
		return ExcelReader.getExcelData("src/main/resources/NewCustomerData.xlsx","Sheet1");
	}
	
	
	@Test (dataProvider = "customerData")
	public void AddCustomer(String name, String gender, String dob, String address, String city, 
	                        String state, String pincode, String mobileNo, String email, String password) {
	    
		loginPage.setUsername(ConfigReader.getProperty("username"));
		loginPage.setPassword(ConfigReader.getProperty("password"));
		loginPage.submit();
		webDriverUtil.waitForNewUrl(ConfigReader.getProperty("home.url"));
		driver.get(ConfigReader.getProperty("addCustomer.url"));
		test = extent.createTest("add customer");
	    test.info("Adding New Customer Test Started");

	    
	    
	    test.info("Navigated to Add Customer Page");

	    newCustomerPage.setName(name);
	    newCustomerPage.setGender(gender);
	    newCustomerPage.setDob(dob);
	    newCustomerPage.setAddress(address);
	    newCustomerPage.setCity(city);
	    newCustomerPage.setState(state);
	    newCustomerPage.setPincode(pincode);
	    newCustomerPage.setMobileNo(mobileNo);
	    newCustomerPage.setEmail(email);
	    newCustomerPage.setPassword(password);
	    
	    newCustomerPage.submit();
	    test.info("Form submitted for adding new customer");

	    webDriverUtil.waitForAlert();
	    test.info("Alert handling completed");

	    webDriverUtil.waitForElementVisibleByid("customer");

	    webDriverUtil.waitForElementVisibleByXpath("//table[@id='customer']//tr[td[text()='Customer ID']]/td[2]");
	    WebElement customerIdElement = driver.findElement(By.xpath("//table[@id='customer']//tr[td[text()='Customer ID']]/td[2]"));

	    String customerId = customerIdElement.getText();
	    test.info("Registered Customer ID: " + customerId);
	    
	    

	    if (customerId.isEmpty()) {
	        test.fail("Customer ID not found!");
	    } else {
	        test.pass("Successfully got Customer ID: " + customerId);
	    }
	    
	    newCustomerPage.homeButton();
	}

	
	@Test
	public void EmailAlreadyPresent() {
		
		test = extent.createTest("Email Already Present");
		
		
		loginPage.setUsername(ConfigReader.getProperty("username"));
		loginPage.setPassword(ConfigReader.getProperty("password"));
		loginPage.submit();
		
		test.info("Login done");
		
		webDriverUtil.waitForNewUrl(ConfigReader.getProperty("home.url"));
		test.info("Redirected to Home");
		
		driver.get(ConfigReader.getProperty("addCustomer.url"));
		test.info("Add Customer Page");
		
		newCustomerPage.setName("what");
		newCustomerPage.setGender("m");
		newCustomerPage.setDob("07/08/2002");
		newCustomerPage.setAddress("adfadfdf sdf" );
		newCustomerPage.setCity("chab");
		newCustomerPage.setState("pune");
		newCustomerPage.setPincode("505050");
		newCustomerPage.setMobileNo("1010101010");
		newCustomerPage.setEmail("what222222@gamil.com");
		newCustomerPage.setPassword("admin123");
		
		
		newCustomerPage.submit();
		test.info("Form Submitted");
		
		
		webDriverUtil.waitForAlert();
		test.pass("Alert shown");
	}
//	
	@AfterMethod
	public void logout() {
		extent.flush();
		super.logout();
	}

}
