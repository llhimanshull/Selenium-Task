package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EditCustomerPage {

	WebDriver driver;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By customerIdField = By.name("cusid");
	private By submit = By.name("AccSubmit");
	private By submitField = By.name("sub");
	
	public void setCustomerID(String customerID) {
		driver.findElement(customerIdField).sendKeys(customerID);
	}
	
	public void submit() {
		driver.findElement(submit).click();
	}
	
	public void formSubmit() {
		driver.findElement(submitField).click();
	}

}
