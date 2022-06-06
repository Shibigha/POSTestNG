package com.qa.test;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import junit.framework.Assert;

public class HomePageTC extends Base
{
	HomePage homepage;
	LoginPage login;
	
	@BeforeClass
	public void performlogin()
	{
		login =new LoginPage(driver);
		
		homepage = new HomePage(driver);
		login.login("admin","password");
	}
	
	@Test(priority=1)
	public void homepagetest()
	{
		homepage.menuClicked();
		boolean menuDisplayed=homepage.isMenuDisplayed();
		Assert.assertTrue(menuDisplayed);
	}
	
	@Test(priority=2)
	public void posMenuTest() {
		homepage.posMenuClicked();
		boolean homeDisplayed=homepage.ishomePageDisplayed();
		Assert.assertTrue(homeDisplayed);
	}
	
	@Test(priority=3)
	public void storeClickedTest() {
		homepage.storeClicked();
		boolean isStorePopupDisplayed = homepage.isstoreClickPopupDisplayed();
		Assert.assertTrue(isStorePopupDisplayed);
	}
	
	@Test(priority=4)
	public void submitPopupTest() 
	{
		homepage.cashInHandSubmit("10","12");
	
	}
	
	@Test(priority=5)
	public void cancelPopupTest() 
	{		
		homepage.cashInHandCancel();
		
		boolean homeDisplayed = homepage.ishomePageDisplayed();
		Assert.assertTrue(homeDisplayed);
	}
	
	@Test(priority=6)
	public void submitPopupTest1() 
	{
		homepage.storeItem1Clicked();
		homepage.cashInHandSubmit1("10");
	
	}
	
	@Test(priority=7)
	public void cancelPopupTest1() 
	{		
		homepage.cashInHandCancelItem1();
		
		boolean homeDisplayed = homepage.ishomePageDisplayed();
		Assert.assertTrue(homeDisplayed);
	}
}
	

