package com.cucumber.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.cucumber.base.BasePage;
import com.cucumber.base.BaseTest;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps extends BaseTest{
	BasePage page; 
	WebDriver driver;	
		
	@Given("user launch the application")
    public void user_launch_the_application() {      
		driver=launchapplication();	
    }
	@Given("user is on {string}")
	public void user_is_on(String pagename) {
		String packagename="com.cucumber.pages";
		   String fullpath=packagename+"."+pagename;
		   try {
			   page=(BasePage)Class.forName(fullpath).getDeclaredConstructor(WebDriver.class).newInstance(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	   
	@When("user enter into textbox {string} {string}")
	public void user_enter_into_textbox(String elementName, String inputData) {
		page.enterintotextbox(elementName, inputData);		  
	}
	
	@Then("user click on login Button {string}")
	public void user_click_on_login_button(String elementName) {
		page.clickbutton(elementName);
	}
	
	@Then("user click on Button {string}")
	public void user_click_on_button(String element) {
		page.waitforwebelement(element);
		page.clickbutton(element);
	}
	

@When("user enter name into textbox {string} {string}")
public void user_enter_name_into_textbox(String elementName, String inputData) {
	page.enterintotextbox(elementName, inputData);
}

@Then("user click on radiobutton {string}")
public void user_click_on_radiobutton(String element) {
	page.clickbutton(element);
}

@Then("user verify the text {string} {string}")
public void user_verify_the_text(String elementName, String expectedtext) {
	page.waitforwebelement(elementName);
	page.verifytext(elementName, expectedtext);
}

@After
public void teardown(Scenario scenario) {
	if (driver != null) {
        try {
            // Take screenshot and attach to scenario
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close browser completely
            driver.quit();
            driver = null;
        }
    }

}
}
