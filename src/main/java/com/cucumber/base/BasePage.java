package com.cucumber.base;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class BasePage {
	
	protected WebDriver driver;
	
	protected Map<String, By> objectrepo = new HashMap<String, By>();
	
	public BasePage(WebDriver driver) {
		this.driver=driver;
	}

	public void addObject(String Element,By by) {
		 objectrepo.put(Element, by);
	}
	
	public WebElement getElement(String elementName) {
		By by=objectrepo.get(elementName);
		WebElement element=driver.findElement(by);
		return element;		
	}
	
	public void enterintotextbox(String elementName,String inputData) {
		WebElement element=getElement(elementName);
		element.sendKeys(inputData);
	}
	
	public void clickbutton(String elementName) {
		WebElement element=getElement(elementName);
		element.click();
	}
	
	
	
	/*public void waitforwebelement(WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver,15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}*/
	
	public WebElement waitforwebelement(String elementName) {
	    By by = objectrepo.get(elementName); // get locator from repository
	    if (by == null) {
	        throw new RuntimeException(
	            "Element '" + elementName + "' not found in object repository!"
	        );
	    }
	    WebDriverWait wait = new WebDriverWait(driver,15);
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}
	
	public void verifytext(String elementName,String expectedtext) {
		WebElement element=getElement(elementName);
		String actualname=element.getText();
		Assert.assertEquals(actualname, expectedtext);
	}
	
	public void switchToFrame(WebElement frameElement) {
		WebDriverWait wait=new WebDriverWait(driver,15);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameElement));
    }
}