package com.qa.util;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import cucumber.api.Scenario;

public class WaitMethods {

	WebDriver driver;

	public static String ELEMENT_TO_BE_CLICKABLE = "elementTobeClickable";
	public static String ELEMENT_TO_BE_VISIBLE = "visibilityOf";
	public static String STALENESS_OF_ELEMENT = "stalenessof";

	/**
	 * @param millisec
	 * This is a static method is to call Thread.sleep whenever required
	 */
	public static void staticWait(long millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public static WebElement waitFor(WebDriver driver, WebElement elem, String waitType, Scenario scenario) {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(ReadProperties.getFluentWaitTime(), TimeUnit.SECONDS)
				.pollingEvery(10, TimeUnit.MILLISECONDS).ignoring(NoSuchElementException.class);

		try {
			switch (waitType) {
			case "elementToBeClickable":
				wait.until(ExpectedConditions.elementToBeClickable(elem));

			case "visibilityOf":
				wait.until(ExpectedConditions.visibilityOf(elem));

			case "elementToBeSelected":
				wait.until(ExpectedConditions.elementToBeSelected(elem));

			case "stalenessOf":
				wait.until(ExpectedConditions.stalenessOf(elem));
			}
		} catch (Exception E) {
			scenario.write("There is an Exception in Fluent Wait checking... " + E.getMessage());
		}

		return elem;
	}

	// public static WebElement waitFor(WebDriver driver, WebElement elem,
	// String waitType, Scenario scenario) {
	//
	// Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	// .withTimeout(ReadProperties.getFluentWaitTime(),
	// TimeUnit.SECONDS).pollingEvery(10, TimeUnit.MILLISECONDS)
	// .ignoring(NoSuchElementException.class);
	//
	// try {
	// switch (waitType) {
	//
	// case "elementTobeClickable":
	// wait.until(ExpectedConditions.elementToBeClickable(elem));
	// break;
	// case "visibilityOf":
	// wait.until(ExpectedConditions.visibilityOf(elem));
	// break;
	// case "elementToBeSelected":
	// wait.until(ExpectedConditions.elementToBeSelected(elem));
	// break;
	// case "stalenessof":
	// wait.until(ExpectedConditions.stalenessOf(elem));
	// break;
	// default:
	// wait.until(ExpectedConditions.visibilityOf(elem));
	// }
	//
	// } catch (Exception E) {
	//
	// scenario.write("There is some Exception in Fluent Wait checking-- " +
	// E.getMessage());
	// }
	//
	// return elem;
	// }

}
