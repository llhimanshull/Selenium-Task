package com.demo.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.demo.base.Initializer;
import com.demo.pages.LoginPage;
import com.demo.utils.ConfigReader;
import com.demo.utils.WebDriverUtli;

public class LoginTest extends Initializer {

	LoginPage loginPage;
	WebDriverUtli webDriverUtil;
	
	
	@BeforeMethod
	public void setup() {
		super.setup();
		driver.get(ConfigReader.getProperty("base.url"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		loginPage = new LoginPage(driver);
		webDriverUtil = new WebDriverUtli(driver);

	}
	
	@Test
	public void ValidLoginTest() {
		test = extent.createTest("Valid Login Test");
		test.info("Starting Valid login test");
		
		loginPage.setUsername(ConfigReader.getProperty("username"));
		loginPage.setPassword(ConfigReader.getProperty("password"));
		loginPage.submit();
		
		test.info("Login form submitted with valid credentials");
		
		boolean isRedirected =  webDriverUtil.waitForNewUrl(ConfigReader.getProperty("home.url"));
		
		test.info("Waiting for URL redirection" + ConfigReader.getProperty("home.url"));
		
		Assert.assertTrue(isRedirected);
		test.pass("Valid login test Passed");
	}
	
	@Test
	public void InvalidLoginTest() {
		test = extent.createTest("Invalid Login Test");
		test.info("Starting invalid Login Test");
		
		loginPage.setUsername("invalid");
		loginPage.setPassword("invalid");
		loginPage.submit();
		
		test.info("Login form submitted with invalid credentials.");
		
		webDriverUtil.waitForAlert();
		
		test.info("Alert displayed for invalid login.");
		test.pass("Invalid Login Test Passed : Expected Alert shown");
	}
	
	@AfterMethod
	public void logout() {
		super.logout();
	}
	
	@AfterSuite
	public static void flushExtentReport() {
		if(extent != null) {
			extent.flush();
		}
	}

}
