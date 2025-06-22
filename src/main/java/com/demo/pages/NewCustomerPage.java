package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewCustomerPage {
	
	WebDriver driver;
	
	public NewCustomerPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By nameField = By.name("name");
	private By dobField = By.id("dob");
	private By addressField = By.name("addr");
	private By cityField = By.name("city");
	private By stateField = By.name("state");
	private By pincodeField = By.name("pinno");
	private By phoneNoField = By.name("telephoneno");
	private By emailField = By.name("emailid");
	private By passwordField = By.name("password");
	private By submitField = By.name("sub");
	private By homeField = By.linkText("Home");
	
	
	public void setName(String name) {
		driver.findElement(nameField).sendKeys(name);
	}
	
	public void setGender(String gender) {
		driver.findElement(By.xpath("//input[@value = '" + gender + "']"));
	}
	
	public void setDob(String dob) {
		driver.findElement(dobField).sendKeys(dob);
	}
	
	public void setAddress(String address) {
		driver.findElement(addressField).sendKeys(address);
	}
	
	public void setCity(String city) {
		driver.findElement(cityField).sendKeys(city);
	}
	
	public void setState(String state) {
		driver.findElement(stateField).sendKeys(state);
	}
	
	public void setPincode(String pincode) {
		driver.findElement(pincodeField).sendKeys(pincode);
	}
	
	public void setMobileNo(String No) {
		driver.findElement(phoneNoField).sendKeys(No);
	}
	
	public void setEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void submit() {
		driver.findElement(submitField).click();
	}	
	
	public void homeButton() {
		driver.findElement(homeField).click();
	}
	
}
