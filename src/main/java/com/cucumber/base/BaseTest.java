package com.cucumber.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
static WebDriver driver;

public WebDriver launchapplication() {	
	if(driver==null) {
		WebDriverManager.chromedriver().setup();	
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("--incognito");
		driver=new ChromeDriver(options);
		driver.get("https://selenium-prd.firebaseapp.com/");
		}
	return driver;
}

}

