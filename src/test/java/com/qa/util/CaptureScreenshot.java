package com.qa.util;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * @author Jain This method will take screenshot and return image in byte
 *         format to embed in Cucumber Report
 */
public class CaptureScreenshot {

	public static byte[] captureImage(WebDriver driver) {
		TakesScreenshot srcShot = (TakesScreenshot) driver;
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] srcFile = srcShot.getScreenshotAs(OutputType.BYTES);
		
		return srcFile;

	}

}
