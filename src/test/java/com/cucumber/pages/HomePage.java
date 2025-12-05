package com.cucumber.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.cucumber.base.BasePage;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		addObject("Home",By.xpath("//a[text()='Home']"));
		addObject("name",By.id("name"));
		addObject("lastname",By.name("lastname"));
		addObject("Female",By.xpath("//input[@value='female']"));
		addObject("Heading",By.xpath("//h1[contains(text(),'Student')]"));
		
	}
	
	

}
