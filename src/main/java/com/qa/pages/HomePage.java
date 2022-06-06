package com.qa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.Base;
import com.qa.utility.PageUtility;
import com.qa.utility.WaitUtility;

public class HomePage extends Base
{
	@FindBy(className="row")
	WebElement homelabel;
	
	@FindBy(xpath="//button[@class='navbar-toggle collapsed']")
	WebElement menubutton;
	
	@FindBy (xpath="//ul[@class='nav navbar-nav']")
	WebElement menulist;
	
	@FindBy(xpath="//span[text()='POS']//parent::a//parent::li")
	WebElement posMenu;
	
	@FindBy(xpath="//li[@class='listing clearfix']//parent::a//parent::ul")
	WebElement storeList;
	
	@FindBy(xpath="//form[@id='cachIH']")
	WebElement cachInHandPopup;
	
	@FindBy(name="cash")
	WebElement cashInHand;
	
	@FindBy(xpath = "//input[@placeholder='Zain Staff Cash in Hand']")
	WebElement ZainStaffcashInHand;
	
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement submitButton;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement cancelButton;
	
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean ishomePageDisplayed()
	{
		boolean isDisplayed = homelabel.isDisplayed();
		return  isDisplayed;
	}
	
	public void menuClicked()
	{
		PageUtility.performClick(driver,menubutton);
	}
	
	public boolean isMenuDisplayed()
	{
		boolean isMenuDisplay=menulist.isDisplayed();
		return isMenuDisplay;
	}
	
	public void posMenuClicked()
	{
		PageUtility.performClick(driver,posMenu);
	}
	
	public void storeClicked()
	{
		WaitUtility.waitForEleToBeClickable(driver, storeList);
		
		WebElement storeItem = PageUtility.firstElementofList(storeList);
		
		storeItem.click();
	}
	
	public boolean isstoreClickPopupDisplayed() 
	{
		WaitUtility.waitForEleToBeClickable(driver, cachInHandPopup);

		boolean isDisplayed = cachInHandPopup.isDisplayed();
		return isDisplayed;
	}
	
	public void cashInHandSubmit(String cash,String staffCash)
	{
		WaitUtility.waitForEleToBeClickable(driver, cashInHand);
		WaitUtility.waitForEleToBeClickable(driver, ZainStaffcashInHand);
		PageUtility.performSendKey(driver, cashInHand, cash);
		PageUtility.performSendKey(driver, ZainStaffcashInHand, staffCash);
		WaitUtility.waitForEleToBeClickable(driver, submitButton);
		PageUtility.performClick(driver, submitButton);
				
		PageUtility.AcceptAlert(driver);
	}
	
	public void cashInHandCancel()
	{
		WaitUtility.waitForEleToBeClickable(driver, cancelButton);
		PageUtility.performClick(driver, cancelButton);
	}
	
	public void storeItem1Clicked()
	{
		WaitUtility.waitForEleToBeClickable(driver, storeList);
		
		WebElement storeItem = PageUtility.secondElementofList(storeList);
		
		storeItem.click();
	}
	
	public void cashInHandSubmit1(String money)
	{
		WaitUtility.waitForEleToBeClickable(driver, cashInHand);
		PageUtility.performSendKey(driver, cashInHand, money);
		WaitUtility.waitForEleToBeClickable(driver, submitButton);
		PageUtility.performClick(driver, submitButton);
		PageUtility.AcceptAlert(driver);
	}
	
	public void cashInHandCancelItem1()
	{
		WaitUtility.waitForEleToBeClickable(driver, cancelButton);
		PageUtility.performClick(driver, cancelButton);
	}
	
}
