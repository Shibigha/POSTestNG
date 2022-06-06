package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;
import com.qa.models.Store;
import com.qa.utility.PageUtility;
import com.qa.utility.ScreenshotsUtil;
import com.qa.utility.WaitUtility;

public class StorePage extends Base
{
	@FindBy(xpath ="//span[text()='Stores']")
	WebElement Store;
	
	@FindBy(xpath ="//input[@type='search']")
	WebElement StoreSearch;
	
	@FindBy(xpath ="//input[@id='StoreName']")
	WebElement AddStoreName;
	
	@FindBy(xpath ="//input[@id='email']")
	WebElement Addemail;
	
	@FindBy(xpath ="//input[@id='StorePhone']")
	WebElement AddStorePhone;
	
	@FindBy(xpath ="//input[@id='Country']")
	WebElement AddCountry;
	
	@FindBy(xpath ="//input[@id='City']")
	WebElement AddCity;
	
	@FindBy(xpath ="//input[@id='Adresse']")
	WebElement AddAdresse;
	
	@FindBy(xpath ="//input[@id='CustomeFooter']")
	WebElement AddCustomeFooter;
	
	@FindBy(xpath ="//button[text()='Submit']")
	WebElement AddStoreSubmit;
	
	@FindBy(xpath ="//button[@class='btn btn-add btn-lg']")
	WebElement AddStoreButton;
	
	@FindBy(xpath="//select[@name='Table_length']")
	WebElement tableFilterDropdown;
	
	public StorePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void storeClick()
	{
		WaitUtility.waitForEleToBeClickable(driver, Store);
		PageUtility.performClick(driver, Store);
		
	}
	
	public void  storeNameSearch(String name)
	{
		WaitUtility.visibilityOfEleLocated(driver, StoreSearch);
		PageUtility.performSendKey(driver, StoreSearch, name);
	}
	
	public void performAddStoreClick() {

		WaitUtility.visibilityOfEleLocated(driver, AddStoreButton);
		PageUtility.performClick(driver, AddStoreButton);
	}
	
	public void addStoreFields(Store stre)
	{
		WaitUtility.visibilityOfEleLocated(driver, AddStoreName);

		PageUtility.performSendKey(driver, AddStoreName, stre.StoreName);
		PageUtility.performSendKey(driver, Addemail, stre.Email);
		PageUtility.performSendKey(driver, AddStorePhone, stre.StorePhone);
		PageUtility.performSendKey(driver, AddCountry, stre.Country);
		PageUtility.performSendKey(driver, AddCity, stre.City);
		PageUtility.performSendKey(driver, AddAdresse, stre.Adresse);
		PageUtility.performSendKey(driver,AddCustomeFooter, stre.CustomeFooterreceipt);
		
		addStoreFieldsScreenshot();
    }
	
	public void addStoreFieldsScreenshot()
	{
		ScreenshotsUtil.screenshot(driver,"addStoreFields");
	}
	
	public void StoreSubmitButtonClick()
	{
		PageUtility.performClick(driver, AddStoreSubmit);
	}
	
	public void SelectTableFilter()
	{
		WaitUtility.visibilityOfEleLocated(driver,tableFilterDropdown);
		PageUtility.dropdown(tableFilterDropdown, "25");
	}
}
