package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.cucumber.base.BasePage;

public class LoginPage extends BasePage{
	
	public LoginPage(WebDriver driver) {
		super(driver);
		//this.driver=driver;
		//addObject("Loginpage",By.id("email_field"));
		addObject("username",By.id("email_field"));
		addObject("password",By.id("password_field"));
		addObject("login",By.xpath("//button[text()='Login to Account']"));
	}
	
	

}
