package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Admin This class contains common methods to read Properties from
 *         Properties file Shift +Alt+J
 *
 */

public class ReadProperties {
	// Open the File
	public static Properties loadProperties() {
		File objFile = new File("C://Users//Admin//workspace//BDDFrameworkNov2024Batch//AppConfig//config.properties");

		// Read the File
		FileInputStream objFis = null;
		try {
			objFis = new FileInputStream(objFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		Properties objProp = new Properties();
		try {
			objProp.load(objFis);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return objProp;
	}

	/**
	 * @return
	 */
	public static String getAppURL() {
		return loadProperties().getProperty("appURL");
	}

	/**
	 * @return
	 */
	public static long getImplicitWaitTime() {
		return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));
	}
	
	public static long getFluentWaitTime(){
		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));
	}

	public static String getAppUsername() {
		return loadProperties().getProperty("userName");
	}

	public static String getAppPassword() {
		return loadProperties().getProperty("password");
	}

	// public static Properties loadProperties() {
	// // Open the File
	// File objfile = new File("/AppConfig/config.properties");
	// // Read the File
	//
	// FileInputStream objfis = null;
	// try {
	// objfis = new FileInputStream(objfile);
	// } catch (FileNotFoundException e1) {
	//
	// e1.printStackTrace();
	// }
	//
	// Properties objprop = new Properties();
	// try {
	// objprop.load(objfis);
	// } catch (IOException e) {
	//
	// e.printStackTrace();
	// }
	// return objprop;
	//
	// }
	//
	// public static String getappURL() throws IOException {
	//
	// return loadProperties().getProperty("appURL");
	//
	// }
	//
	// public static String getAppUserName() {
	// return loadProperties().getProperty("userName");
	// }
	//
	// public static String getAppPassword() {
	// return loadProperties().getProperty("password");
	// }
	//
	//
	// }
	// public static long implicitWaitTime() {

	// return Long.parseLong(loadProperties().getProperty("implicitWaitTime"));
	// 
	
//	public static long getFluentWaitTime() {
//
//		return Long.parseLong(loadProperties().getProperty("fluentWaitTime"));
//	}
	//}

}
