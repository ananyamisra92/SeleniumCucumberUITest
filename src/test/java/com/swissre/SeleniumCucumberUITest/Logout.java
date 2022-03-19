package com.swissre.SeleniumCucumberUITest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Logout extends WebDriverChrome {
	
	
	//Locators
		By profilePic = By.xpath("//img[@class='user-pic']");
		By editProfileBtn = By.xpath("//a[@class='btn btn-sm btn-outline-secondary action-btn']");
		By signInButton = By.xpath("//button[@class='btn btn-lg btn-primary pull-xs-right']");
		By logoutBtn = By.xpath("//button[@class='btn btn-outline-danger']");
		By LoginBtn = By.xpath("//a[@href='#login']");

	
	@Given("User profile button is available")
	public void user_profile_button_is_available() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	   driver.findElement(By.xpath("//img[@class='user-pic']")).isEnabled();
	}

	@SuppressWarnings("deprecation")
	@When("I click on user Profile")
	public void i_click_on_user_profile() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(profilePic).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(editProfileBtn)).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		 
	       //specify the WebElement till which the page has to be scrolled
	       WebElement element = driver.findElement(logoutBtn);
	 
	       js.executeScript("arguments[0].scrollIntoView();", element);
	}

	@SuppressWarnings("deprecation")
	@When("I click on logout")
	public void i_click_on_logout() {
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(logoutBtn).click();
	    
	}

	@Then("I am successfully logged out")
	public void i_am_successfully_logged_out() {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(LoginBtn).isDisplayed();
		driver.close();
	}

}
