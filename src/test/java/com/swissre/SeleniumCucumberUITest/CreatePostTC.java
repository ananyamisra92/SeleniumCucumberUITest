package com.swissre.SeleniumCucumberUITest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreatePostTC extends WebDriverChrome{
	
	//Locators
		By articleTextArea = By.xpath("//*[@id='main']//fieldset[3]/textarea");
		By articleSummaryInput = By.xpath("//*[@id='main']//fieldset[2]/input");
		By articleTitleInput = By.xpath("//input[@placeholder='Article Title']");
		By createPostBtn = By.xpath("//*[@id='main']/div/nav/div/ul/li[2]/a");
		By homePage = By.className("home-page");
		By articleTagInput = By.xpath("//input[@placeholder='Enter tags']");
		By profilePic = By.xpath("//img[@class='user-pic']");
		By articleTitleName = By.xpath("//div[@class='article-preview'][1]/a/h1");
		By publishArticleBtn = By.xpath("//button[@class='btn btn-lg pull-xs-right btn-primary']");
	
	@Given("I have successfully logged in")
	public void i_have_successfully_logged_in() {
		driver.findElement(homePage).isDisplayed();
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
	}

	@Given("New Post button is clickable")
	public void new_post_button_is_clickable() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(createPostBtn)).isEnabled();
        			}

	@When("I click on New Post")
	public void i_click_on_new_post() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(createPostBtn)).click();
	   
	}

	@When("I enter ArticleTitle {string} , ArticleSummary {string}, Content {string} and tag {string}")
	public void i_enter_article_title_article_summary_content_and_tag(String articleTitle, String summary, String content, String tag) {
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(articleTitleInput).sendKeys(articleTitle);
		driver.findElement(articleSummaryInput).sendKeys(summary);
		driver.findElement(articleTextArea).sendKeys(content);
		driver.findElement(articleTagInput).sendKeys(tag);

	}

	@When("I click on Publish Article")
	public void i_click_on_publish_article() {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(publishArticleBtn)).click();
	}

	@Then("I am able to view my ArticleTitle {string}")
	public void i_am_able_to_view_my_article_title(String articleTitle) {
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(profilePic)).click();
		new WebDriverWait(driver, Duration.ofSeconds(10))
        .until(ExpectedConditions.elementToBeClickable(articleTitleName)).isDisplayed();
		Assert.assertEquals(driver.findElement(articleTitleName).getText(), articleTitle);
		
	}


}
