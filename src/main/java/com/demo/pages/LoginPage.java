package com.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By usernameField = By.name("uid");
	private By passwordField = By.name("password");
	private By submitField = By.name("btnLogin");
	
	
	public void setUsername(String username) {
		driver.findElement(usernameField).sendKeys(username);
	}
	
	public void setPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void submit() {
		driver.findElement(submitField).click();
	}
}
