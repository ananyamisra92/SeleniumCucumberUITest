package com.swissre.SeleniumCucumberUITest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.Login;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.swissre.SeleniumCucumberUITest.WebDriverChrome;

public class LoginTC  {


	Login loginTest = new Login();
	
	@Given("I have navigated to website {string}")
	public void i_have_navigated_to_website(String URL) {
		loginTest.navigatetoLogin(URL);
	}
	
	

	@SuppressWarnings("deprecation")
	@When("I click on Sign In")
	public void i_click_on_sign_in() {
		
		loginTest.clickSignIn();
		  
	}

	@SuppressWarnings("deprecation")
	@And("I add UserName {string} and Password {string}")
	public void i_add_user_name_and_password(String username, String password) {
		
		
		loginTest.loginValidUser(username, password);
		
		
		
	}

	@SuppressWarnings("deprecation")
	@And("I click on Sign In button")
	public void i_click_on_sign_in_button() {
		
		loginTest.clickLogin();
		
		
		
	   
	}

	@Then("I am successfully logged in")
	public void i_am_successfully_logged_in() {
	loginTest.validateRedirectionHomePage();
		
		
	   
	}

}
