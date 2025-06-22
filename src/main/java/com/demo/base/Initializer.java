package com.demo.base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import static com.demo.base.Initializer.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.demo.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Initializer {
	
	protected WebDriver driver;
	protected static ExtentReports extent ;
	protected static ExtentTest test;
	
	@BeforeSuite
	public static void initializeExtentReports() {
		extent = new ExtentReports();
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-reports/extentReport.html");
		extent.attachReporter(sparkReporter);
	}
	
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();		
		driver.manage().window().maximize();
		driver.get(ConfigReader.getProperty("base.url"));

	}
	
	
	public void logout() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	@AfterMethod
	public void ExtentFinsh() {
		 test.info("Test completed. Cleaning up and closing the browser.");
		 extent.flush();
		 
	}
}
