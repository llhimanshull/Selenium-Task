package com.demo.utils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;


public class WebDriverUtli {

	WebDriver driver;
	ExtentReports extentReports;
	ExtentTest test;
	
	public WebDriverUtli(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean waitForNewUrl(String url) {
		try {
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
			wait.until(ExpectedConditions.urlContains(url));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void waitForAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.alertIsPresent());
			
			Alert alert = driver.switchTo().alert();
			System.out.println("alert found" + alert.getText());
			alert.accept();
		} catch (Exception e) {
			System.out.println("no alert found");
		}
	}
	
	public boolean waitForElementVisibleByXpath(String elem) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elem)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean waitForElementVisibleByid(String elem) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(elem)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean waitForElementVisibleByName(String elem) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(elem)));
			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
