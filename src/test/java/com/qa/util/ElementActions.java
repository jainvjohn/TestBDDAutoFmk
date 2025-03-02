package com.qa.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.Scenario;



/**
 * @author Admin
 *This class has all elements in Selenium to click and perform actions
 */
public class ElementActions {

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * This method will clear default values in textfields
	 */
	public static void clearFieldvalue(WebDriver driver, WebElement elem, Scenario scenario) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Emmenet ");
		}
		try {
			elem.clear();
		} catch (Exception E) {
			scenario.write(" Error on clicking the element after wating !");
		}

	}
	
	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param texttoType
	 *            This method will take element as parameter wait for Explicit Wait
	 *            time for Element to be clickable (Fluent Time=50s) and perform
	 *            click operation
	 */
	public static void clickElement(WebDriver driver, WebElement elem, Scenario scenario) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Element ");
		}
		try {
			elem.click();
		} catch (Exception E) {
			scenario.write(" Error on clicking the element after waiting !");
		}

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param texttoType
	 */
	public static void sendKeys(WebDriver driver, WebElement elem, Scenario scenario, String texttoType) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Element ");
		}

		try {
			elem.sendKeys(texttoType);
		} catch (Exception E) {
			scenario.write(" Error on typing the text in element after waiting !");
		}

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @return This method will wait for Fluent Wait Time and when element is
	 *         visible, it will get the text and return the element
	 */
	public static String getText(WebDriver driver, WebElement elem, Scenario scenario) {

		String texttoReturn = null;
		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_VISIBLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for clicking on Element ");
		}
		try {
			texttoReturn = elem.getText();
		} catch (Exception E) {
			scenario.write(" Error on fetching the text in element after waiting !");
		}
		return texttoReturn;

	}

	/**
	 * @param driver
	 * @param elem
	 * @param scenario
	 * @param option
	 *            This method will wait for element and select a value from
	 *            Dropdown
	 */
	public static void selectOptionFromDropDown(WebDriver driver, WebElement elem, Scenario scenario, String option) {

		try {
			WaitMethods.waitFor(driver, elem, WaitMethods.ELEMENT_TO_BE_CLICKABLE, scenario);
		} catch (Exception E) {
			scenario.write(" Error while waiting for Element to be clickable   ");
		}

		Select objselect = new Select(elem);

		try {
			objselect.selectByValue(option);
		} catch (Exception E) {
			scenario.write(" Error while selecting the option from Dropdown! ");

		}
	}
}
