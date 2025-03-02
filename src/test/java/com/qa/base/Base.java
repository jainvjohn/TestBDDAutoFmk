package com.qa.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.qa.util.ReadProperties;

/**
 * @author Jain This class will start,launch & close the Browser
 *
 */
public class Base {

	public static WebDriver driver;

	/**
	 * @return This method will start and launch the browser
	 */
	public WebDriver initializeWebDriver() {

		System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");
		// Start the Browser
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(ReadProperties.getImplicitWaitTime(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ReadProperties.getAppURL());
		return driver;

	}

	/**
	 * This method will close the Browser
	 * 
	 */
	public void closeBrowser() {
		driver.quit();
	}
	
}
