package com.qa.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.Base;

// code in  TableUtility class is not unique, we need to convert it into a common code to use in utilities package
public class ScreenshotsUtil extends Base {
	public static String screenshot(WebDriver driver, String methodName) {
		String destination = null;
		try {
			Date date = new Date();
			// This method returns the time in mills
			long timeMilli = date.getTime();
			// Take the screenshot
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			// Copy the file to a location and use try catch block to handle exception

			destination = System.getProperty("user.dir") + "\\Screenshots\\" + methodName + "_" + timeMilli + ".png";

			FileUtils.copyFile(screenshot, new File(destination));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return destination;
	}

}
