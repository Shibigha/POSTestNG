package com.qa.test;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.base.Base;
import com.qa.models.Product;
import com.qa.pages.HomePage;
import com.qa.pages.LoginPage;
import com.qa.pages.ProductPage;
import com.qa.utility.PageUtility;

import junit.framework.Assert;

public class ProductTC extends Base
{
	ProductPage productpageobject;
	HomePage homepage;
	LoginPage login;
	
	@BeforeClass
	public void performlogin()
	{
		login =new LoginPage(driver);
		homepage = new HomePage(driver);
		productpageobject=new ProductPage(driver);
		login.login("admin","password");
	}
	
	@Test(priority=1)
	public void clickProductMenuTest()
	{
		homepage.menuClicked();
		productpageobject.clickProductMenu();
		boolean productMenuDisplayed=productpageobject.isAddProductButtonDisplayed();
		Assert.assertTrue(productMenuDisplayed);
		 
	}

	@Test(priority=2)
	public void supplierSelectedTest()
	{
		productpageobject.supplierSelected();
	}
	
	@Test(priority=3)
	public void typeSelectedTest()
	{
		productpageobject.typeSelected();
	}
	
	@Test(priority=4)
	public void scrollPage()
	{
		productpageobject.scrollPage();
	}
	
	@Test(priority=5)
	public void downloadExcelTest() throws IOException
	{
		productpageobject.downloadexcelclick();
	}
	
	@Test(priority=6)
	public void readExcelText() throws IOException
	{
		boolean response = productpageobject.IsExcelDownloaded("C:\\Users\\SHYNU B P\\Downloads\\products.csv", 0, 1);
		Assert.assertTrue(response);
	}
	
	@Test(priority=7)
	public void searchTest() 
	{
		productpageobject.search("SampleTest");
	
	}
	
	@Test(priority=8)
	public void ProductPopupDisplayTest()
	{
		productpageobject.clickAddProductButton();
		boolean productPopupDisplay=productpageobject.addProductPopupDisplay();
		Assert.assertTrue(productPopupDisplay);
	}
	
	@Test(priority=9)
	public void addProductFieldsTest()
	{
		Product pdtObj=new Product();
		pdtObj.Type = "Standard";
		pdtObj.Code="1234";
		pdtObj.Name="Apple";
		pdtObj.Category="Juices";
		pdtObj.Supplier="Supplier1";
		pdtObj.PurchasePrice="10";
		pdtObj.Tax="5";
		pdtObj.TaxMethod="exclusive";
		pdtObj.Price="200";
		pdtObj.ProductUnit="1";
		pdtObj.AlertQuantity="5";
		pdtObj.ProductOptions="Munnar Apples,Swedan Oranges";
		productpageobject.addProductFields(pdtObj);
	}
	
	@Test(priority=10)
	public void stockSubmitClickTest()
	{
		productpageobject.stockSubmitClick();
		
	}	
	
	/*@Test(priority=11)
	public void printTest()
	{
		boolean printDisplay=productpageobject.printmenu();
		Assert.assertTrue(printDisplay);
	}
	
	@Test(priority=12)
	public void uploadcsvTest()
	{
		productpageobject.uploadCsvFile();
	}*/
}
