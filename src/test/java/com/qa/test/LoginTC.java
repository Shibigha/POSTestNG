package com.qa.test;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;

import junit.framework.Assert;

public class LoginTC extends Base
{
	LoginPage loginpage;
	HomePage homepage;
	
	@BeforeMethod
	public void beforeMethod()
	{
		loginpage=new LoginPage(driver);
		homepage=new HomePage(driver);
	}
	
	@Test(priority=1)
	public void userIdFieldIsDisplayed()
	{
		boolean userIdFieldDisplayed=loginpage.isUserIdFieldDisplayed();
		Assert.assertTrue(userIdFieldDisplayed);
	}
	
	@Test(priority=2)
	public void passwordFieldIsDisplayed()
	{
		boolean passwordDisplayed=loginpage.isPasswordFieldDisplayed();
		Assert.assertTrue(passwordDisplayed);
	}
	
	@Test(priority=3)
	public void passwordMasked()
	{
		boolean ispasswordmasked=loginpage.isMasked();
		Assert.assertTrue(ispasswordmasked);
	}
	
	@Test(priority=4)
	public void loginTestWithWrongPassword()
	{
		loginpage.login("admin","admin");	
		boolean userIdFieldDisplayed=loginpage.isUserIdFieldDisplayed();
		Assert.assertTrue(userIdFieldDisplayed);
	}
	
	@Test(priority=5)
	public void loginTest()
	{
		loginpage.login("admin","password");	
		boolean homepagedisplayed=homepage.ishomePageDisplayed();
		Assert.assertTrue(homepagedisplayed);
	}
	
	
}
