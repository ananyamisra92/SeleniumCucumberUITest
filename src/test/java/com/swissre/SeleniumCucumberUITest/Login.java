package com.swissre.SeleniumCucumberUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login extends WebDriverChrome{
	
	@Given("I have navigated to website {string}")
	public void i_have_navigated_to_website(String URL) {
		driver.get(URL);
		driver.manage().window().maximize();

	}
	
	//Locators
	By LoginBtn = By.xpath("//a[@href='#login']");
	By UserNameInput = By.xpath("//input[@type='email']");
	By signInButton = By.xpath("//button[@class='btn btn-lg btn-primary pull-xs-right']");
	By passwordInput = By.xpath("//input[@placeholder='Password']");
	By homePage = By.className("home-page");

	@SuppressWarnings("deprecation")
	@When("I click on Sign In")
	public void i_click_on_sign_in() {
		driver.findElement(LoginBtn).click();
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	  
	}

	@SuppressWarnings("deprecation")
	@When("I add UserName {string} and Password {string}")
	public void i_add_user_name_and_password(String username, String password) {
		driver.findElement(UserNameInput).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(passwordInput).sendKeys(password);
		
		
	}

	@SuppressWarnings("deprecation")
	@When("I click on Sign In button")
	public void i_click_on_sign_in_button() {
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(signInButton).click();
		
		
	   
	}

	@Then("I am successfully logged in")
	public void i_am_successfully_logged_in() {
		driver.findElement(homePage).isDisplayed();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		
	   
	}

}
