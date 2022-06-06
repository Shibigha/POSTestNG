package com.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.Base;
import com.qa.models.Product;
import com.qa.utility.*;

public class ProductPage extends Base
{
	@FindBy(xpath="//span[text()='Product']//parent::a[1]")
	WebElement productMenu;
	
	@FindBy(xpath = "//select[@name='Table_length']")
    WebElement entriesDropdown;
	
	@FindBy(xpath = "//select[@name='filtersupp']")
    WebElement supplierDropdown;
	
	@FindBy(xpath="//ul[@class='nav navbar-nav']")
	WebElement menuList;
	
	@FindBy(xpath="//button[text()='Add Product']")
	WebElement addProductButton;
	
	@FindBy(xpath = "//div[@id='Addproduct']")
	WebElement addProductPopup;
	
	@FindBy(xpath="//input[@type='search']")
	WebElement search;
	
	@FindBy(xpath="//div[@class='container']")
	WebElement page;
	
	@FindBy(name="type")
	WebElement addProductType;
	
	@FindBy(xpath = "//input[@name='code']")
	WebElement addProductCode;
	
	@FindBy(xpath = "//input[@id='ProductName']")
	WebElement addProductName;
	
	@FindBy(xpath = "//select[@id='Category']")
	WebElement addProductCategory;
	
	@FindBy(xpath = "//select[@name='supplier']")
	WebElement addProductSupplier;
	
	@FindBy(xpath = "//input[@id='PurchasePrice']")
	WebElement addProductPurchasePrice;
	
	@FindBy(xpath = "//input[@id='Tax']")
	WebElement addProductTax;
	
	@FindBy(xpath = "//select[@id='taxType']")
	WebElement addProductTaxType;
	
	@FindBy(xpath = "//input[@id='Price']")
	WebElement addProductPrice;
	
	@FindBy(xpath = "//input[@id='Unit']")
	WebElement addProductUnit;
	
	@FindBy(xpath = "//input[@id='AlertQt']")
	WebElement addProductAlertQt;
	
	@FindBy(xpath = "//textarea[@id='ProductOptions']")
	WebElement addProductOptions;
	
	@FindBy(xpath = "//label[text()='Input Image']")
	WebElement addProductImage;
	
	@FindBy(xpath = "//button[@class='btn btn-add'][1]")
	WebElement submitButton;
	
	@FindBy(xpath = "//button[@onclick='updatestock()']")
	WebElement stockSubmitButton;
	
	@FindBy(xpath = "//a[text()='Upload CSV file']")
	WebElement csvFileUpload;
	
	@FindBy(xpath = "//select[@name='filtersupp']")
	WebElement filterSupplier;
	
	@FindBy(xpath = "//select[@name='filtertype']")
	WebElement filterType;
	
	@FindBy(xpath = "//a[text()='PrintMenu']")
	WebElement printMenu;
	
	@FindBy(xpath = "//h1[text()='Menu']")
	WebElement MenuPopup;
	
	@FindBy(xpath ="//button[text()='print']//preceding-sibling::button)[2]")
	WebElement closePopup;
		
	@FindBy(xpath ="//a[text()='Download CSV']")
	WebElement downloadCSV;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void productMenuClicked()
	{
		PageUtility.performClick(driver,productMenu);
	}
	
	public boolean isaddProductVisible()
	{
		boolean addProductVisible =PageUtility.isElementDisplayed(addProductButton);
		return addProductVisible;
	}
	
	public boolean  isEntriesDropdownVisible()
	{
		boolean entriesDropdownVisible = PageUtility.isElementDisplayed(entriesDropdown);
		return entriesDropdownVisible;
	}

	public boolean  isSupplierDropdownVisible()
	{
		boolean supplierDropdownVisible = PageUtility.isElementDisplayed(supplierDropdown);
		return supplierDropdownVisible;
	}
	public void clickProductMenu()
	{
		WaitUtility.visibilityOfEleLocated(driver, menuList);
		WebElement productMenu=PageUtility.secondElementofList(menuList);
		productMenu.click();
    }
	
	public boolean isAddProductButtonDisplayed() 
	{
		WaitUtility.visibilityOfEleLocated(driver, addProductButton);
		boolean AddProductButtonDisplayed=addProductButton.isDisplayed();
		return AddProductButtonDisplayed;
	}
	
	public void clickAddProductButton()
	{
		WaitUtility.visibilityOfEleLocated(driver, addProductButton);
		PageUtility.performClick(driver, addProductButton);
	}
	
	public boolean addProductPopupDisplay() 
	{
		WaitUtility.visibilityOfEleLocated(driver, addProductPopup);
		boolean productPopupDisplayed=addProductPopup.isDisplayed();
		return productPopupDisplayed;
		
	}
	
	public void search(String name)
	{
	    WaitUtility.visibilityOfEleLocated(driver, search);
	    PageUtility.performSendKey(driver, search, name);
	}
	
	public void addProductFields(Product pdt)
	{
		PageUtility.dropdown(addProductType, pdt.Type);
		PageUtility.performSendKey(driver, addProductCode, pdt.Code);
		PageUtility.performSendKey(driver, addProductName, pdt.Name);
		PageUtility.dropdown(addProductCategory, pdt.Category);
		PageUtility.dropdown(addProductSupplier, pdt.Supplier);
		PageUtility.performSendKey(driver, addProductPurchasePrice, pdt.PurchasePrice);
		PageUtility.performSendKey(driver, addProductTax, pdt.Tax);
		PageUtility.dropdown(addProductTaxType, pdt.TaxMethod);
		PageUtility.performSendKey(driver, addProductPrice, pdt.Price);
		PageUtility.performSendKey(driver, addProductUnit, pdt.ProductUnit);
		PageUtility.performSendKey(driver, addProductAlertQt, pdt.AlertQuantity);
		PageUtility.performSendKey(driver, addProductOptions, pdt.ProductOptions);
		PageUtility.performClick(driver, submitButton);
	}
	
	public void stockSubmitClick()
	{
		PageUtility.performClick(driver,stockSubmitButton);
	}
	
	public void uploadCsvFile()
	{
		
		WaitUtility.visibilityOfEleLocated(driver,csvFileUpload);
		PageUtility.performClick(driver,csvFileUpload);
		WebElement browse = driver.findElement(By.xpath("//label[contains(text(),'Upload CSV file')]//following-sibling::input[@id='ImageInput']"));
		WaitUtility.visibilityOfEleLocated(driver,browse);
		browse.sendKeys("C:\\Users\\SHYNU B P\\Downloads\\products.csv"); 	  
	}
	
	public void supplierSelected() 
	{
		WaitUtility.visibilityOfEleLocated(driver,filterSupplier);
		PageUtility.dropdown(filterSupplier, "Supplier1");
	}
	
	public void typeSelected() 
	{
		WaitUtility.visibilityOfEleLocated(driver,filterType);
		PageUtility.dropdown(filterType, "Service");
	}
	
	public void scrollPage()
	{
		PageUtility.scrollDown(driver);
	}
	public boolean printmenu()
	{
		WaitUtility.visibilityOfEleLocated(driver, printMenu);
		PageUtility.performClick(driver, printMenu);
		WaitUtility.visibilityOfEleLocated(driver, MenuPopup);
		boolean isPopupDisplay=PageUtility.isElementDisplayed(MenuPopup);
		return isPopupDisplay;
	}
	
	public void downloadexcelclick() throws IOException
	{
		PageUtility.performClick(driver, downloadCSV);
	}
	
	public boolean IsExcelDownloaded(String path, int row, int column) throws IOException {
		String response = CsvHelper.readStringData(row, column, path);
	
		if(response != null) {
			return true;
		}
		return false;
	}
}
