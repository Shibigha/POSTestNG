package com.qa.utility;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.utility.WaitUtility;

public class PageUtility 
{
	public static void  performSendKey(WebDriver driver,WebElement ele,String val)
	{
		WaitUtility.visibilityOfEleLocated(driver, ele);
		ele.clear();
		ele.sendKeys(val);
	}
	
	public static void performClick(WebDriver driver,WebElement ele)
	{
		WaitUtility.waitForEleToBeClickable(driver, ele);
		ele.click();
	}
	
	public static boolean isElementDisplayed(WebElement ele)
	{
		boolean eledisplayed=ele.isDisplayed();
		return eledisplayed;
	}
	
	public static WebElement firstElementofList(WebElement list) 
	{
		List<WebElement> elements = list.findElements(By.xpath("./child::*"));
		WebElement firstElement = elements.get(0);
		
		return firstElement;
	}
	
	public static WebElement secondElementofList(WebElement list) 
	{
		List<WebElement> elements = list.findElements(By.xpath("./child::*"));
		WebElement secondElement = elements.get(1);
		
		return secondElement;
	}
	
	public static void AcceptAlert(WebDriver driver) 
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
	}
	
	public static void dropdown(WebElement ele,String text)
	{
		Select select=new Select(ele);
		select.selectByVisibleText(text);
	}
	
	public static void scrollDown(WebDriver driver)
	{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("window.scrollTo(0,document.body.scrollHeight);");
	}
}

	

