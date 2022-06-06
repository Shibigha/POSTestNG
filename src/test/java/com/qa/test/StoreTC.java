package com.qa.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.models.Product;
import com.qa.models.Store;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.pages.StorePage;

public class StoreTC extends Base
{
	StorePage storepageobject;
	ProductPage productpageobject;
	HomePage homepage;
	LoginPage login;
	
	
	@BeforeClass
	public void performlogin()
	{
		login =new LoginPage(driver);
		homepage = new HomePage(driver);
		productpageobject=new ProductPage(driver);
		storepageobject=new StorePage(driver);
		login.login("admin","password");
	}
	
	@Test(priority=1)
	public void storeClickTest()
	{
		homepage.menuClicked();
		storepageobject.storeClick();
	}
	@Test(priority=2)
	
	public void storeNameSearchTest()
	{
		storepageobject.storeNameSearch("Lee's CafeTwo");
	}
	
	@Test(priority=3)
	public void addStoreClickTest()
	{
		storepageobject.performAddStoreClick();
	}
	
    @Test(priority=4)
	
	public void addStoreFieldsTest()
	{
    	Store strObj =new Store();
    	strObj.StoreName="Le_CAFE";
    	strObj.Email="lecafe@gmail.com";
    	strObj.StorePhone="23456";
    	strObj.Country="America";
    	strObj.City="asdfg";
    	strObj.Adresse="213,adfgh,fghjj";
    	strObj.CustomeFooterreceipt="welcome";
        storepageobject.addStoreFields(strObj);
	}
    
    @Test(priority=5)
	
   	public void addStoreSubmitTest()
   	{
    	storepageobject.StoreSubmitButtonClick();
   	}
    
    @Test(priority=6)
	
   	public void performStoreListFilter()
   	{
    	storepageobject.SelectTableFilter();
   	}
   	
}

