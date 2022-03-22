package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.swissre.SeleniumCucumberUITest.WebDriverChrome;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login extends WebDriverChrome {

	

	// Locators of login page
	By LoginBtn = By.xpath("//a[@href='#login']");
	By UserNameInput = By.xpath("//input[@type='email']");
	By signInButton = By.xpath("//button[@class='btn btn-lg btn-primary pull-xs-right']");
	By passwordInput = By.xpath("//input[@placeholder='Password']");
	By homePage = By.className("home-page");

	
	
	public void navigatetoLogin (String URL) {
		driver.get(URL);
		driver.manage().window().maximize();
	}
	public void clickSignIn() {
		driver.findElement(LoginBtn).click();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		

	}
	
	

	public void loginValidUser(String username, String password) {
		driver.findElement(LoginBtn).click();
		driver.findElement(UserNameInput).sendKeys(username);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(passwordInput).sendKeys(password);

	}

	public void clickLogin() {

		driver.findElement(signInButton).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

	}

	public void validateRedirectionHomePage() {

		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		driver.findElement(homePage).isDisplayed();

	}
}
