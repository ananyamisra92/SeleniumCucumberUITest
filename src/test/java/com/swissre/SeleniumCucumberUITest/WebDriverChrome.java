package com.swissre.SeleniumCucumberUITest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverChrome {
	public static  ChromeOptions options;
	public static  WebDriver driver;
	
	static {
		WebDriverManager.chromedriver().setup();
		options = new ChromeOptions();
		 driver = new ChromeDriver(options);
	}


}
