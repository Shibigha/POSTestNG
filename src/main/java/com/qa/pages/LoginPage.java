package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;
import com.qa.utility.PageUtility;
import com.qa.utility.WaitUtility;

public class LoginPage extends Base
{
	@FindBy(name="username")//input[@type='username']
	WebElement userId;
	
	@FindBy(name="password")//input[@type='password']
	WebElement passwrd;
	
	@FindBy(xpath="//input[@class=\"login loginmodal-submit\"]")
	WebElement login;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean isUserIdFieldDisplayed()
	{
		WaitUtility.visibilityOfEleLocated(driver, userId);

		boolean isDisplayed=PageUtility.isElementDisplayed(userId);
		return isDisplayed;
	}
	
	public boolean isPasswordFieldDisplayed()
	{
		WaitUtility.visibilityOfEleLocated(driver, passwrd);

		boolean isDisplayed=PageUtility.isElementDisplayed(passwrd);
		return isDisplayed;
	}
	
	public boolean isMasked()
	{
		boolean masked=false;
		if(passwrd.getAttribute("type").equals("password"))
		{
			masked=true;
		}
		return masked;
	}
	
	public void login(String username,String password)
	{
		
		PageUtility.performSendKey(driver,userId, username);
		PageUtility.performSendKey(driver,passwrd, password);
		PageUtility.performClick(driver,login);
		//userId.sendKeys(username);
		//passwrd.sendKeys(password);
		//login.click();
	}
}
