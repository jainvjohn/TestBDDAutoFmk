package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.util.ElementActions;

import cucumber.api.Scenario;

public class MyTimesheetPage {

	WebDriver driver;

	// Page Object Repositories
	@FindBy(xpath = "//span[text()='Time']")
	WebElement timePageLink;

	@FindBy(xpath = "//span[text()='Timesheets ']")
	WebElement TimeSheetsMenu;

	@FindBy(xpath = "//a[text()='My Timesheets']")
	WebElement mytimeSheetPageLink;

	@FindBy(xpath = "//table[@class='orangehrm-timesheet-table']/tbody/tr[2]/td[3]")
	WebElement monTotal;

	@FindBy(xpath = "//table[@class='orangehrm-timesheet-table']/tbody/tr[2]/td[4]")
	WebElement tueTotal;

	@FindBy(xpath = "//table[@class='orangehrm-timesheet-table']/tbody/tr[2]/td[5]")
	WebElement wedTotal;

	@FindBy(xpath = "//table[@class='orangehrm-timesheet-table']/tbody/tr[2]/td[6]")
	WebElement thuTotal;

	@FindBy(xpath = "//table[@class='orangehrm-timesheet-table']/tbody/tr[2]/td[7]")
	WebElement fridayTotal;

	@FindBy(xpath = "//table[@class='orangehrm-timesheet-table']/tbody/tr[2]/td[10]")
	WebElement allDayTotal;

	// Page class constructor

	public MyTimesheetPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// Page Operation methods

	public void navigateToTimePage(Scenario scenario) {
		ElementActions.clickElement(driver, timePageLink, scenario);
	}

	public void navigateToMyTimeSheetsPage(Scenario scenario) {
		ElementActions.clickElement(driver, TimeSheetsMenu, scenario);
		ElementActions.clickElement(driver, mytimeSheetPageLink, scenario);

	}

	/**
	 * @param scenario
	 * @return This will return the sum of all logged hours in Emp TimeSheet
	 *         page in OrangeHRM It picks the value of each day logged hrs
	 */

	public int getSumofBookedDaysTime(Scenario scenario) {

		return Integer.parseInt(ElementActions.getText(driver, monTotal, scenario).split(":")[0])
				+ Integer.parseInt(ElementActions.getText(driver, tueTotal, scenario).split(":")[0])
				+ Integer.parseInt(ElementActions.getText(driver, wedTotal, scenario).split(":")[0])
				+ Integer.parseInt(ElementActions.getText(driver, thuTotal, scenario).split(":")[0])
				+ Integer.parseInt(ElementActions.getText(driver, fridayTotal, scenario).split(":")[0]);

	}

	/**
	 * @param scenario
	 * @return
	 * Split() converts to array of Strings to avoid : in the hrs captured
	 * Prints the 0th value in the array
	 */
	public int getsumofallBookedDays(Scenario scenario) {

		return Integer.parseInt(ElementActions.getText(driver, allDayTotal, scenario).split(":")[0]);
	}
}
