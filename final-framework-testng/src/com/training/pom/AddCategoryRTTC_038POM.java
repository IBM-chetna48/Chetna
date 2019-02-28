/*To verify whether application allows admin to add category in categories page  */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddCategoryRTTC_038POM {
	private WebDriver driver;

	public AddCategoryRTTC_038POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(xpath = "//i[@class='fa fa-tags fw']")
	private WebElement catalog;

	@FindBy(linkText = "Categories")
	private WebElement categor;

	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/a[1]/i")
	private WebElement add;

	@FindBy(name = "category_description[1][name]")
	private WebElement cat_name;
	
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	private WebElement cat_desc;

	@FindBy(id = "input-meta-title1")
	private WebElement cat_metatitle;
	
	
	@FindBy(id = "input-meta-description1")
	private WebElement cat_metaDesc;
	
	@FindBy(id = "input-meta-keyword1")
	private WebElement cat_metakey;
	
	@FindBy(xpath = "//*[@id=\"content\"]/div[1]/div/div/button")
	private WebElement saveCat;
	
	@FindBy(linkText = "Data")
	private WebElement Data_tab;
	
	@FindBy(linkText = "Design")
	private WebElement designTab;
	
	//@FindBy(xpath="//*[@id=\"content\"]/div[2]/div[1]")
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success_msz;
	
	
	//step 1 Click on Catelog icon
	public void enterCatalog() {
		this.catalog.click();
	}
	
	//step 2 Click on Categories link
	public void clickCategory() {
		this.categor.click();
	}
	
	//step 3 Click on Add new icon
	public void addCategory() {
		this.add.click();
	}

	// step 4 Enter Valid credentials in Category Name textbox of General tab
	public void enterCat_Name(String catname) {
		this.cat_name.clear();
		this.cat_name.sendKeys(catname);
	}
	
	//step 5 Enter Valid credentials in Description textbox of General tab
	public void enterCat_Desc(String desc) {
		this.cat_desc.clear();
		this.cat_desc.sendKeys(desc);
	}
	
	//step 6 Enter Valid credentials in Meta tag Title textbox of General tab
	public void enterMeta_Title(String title) {
		this.cat_metatitle.clear();
		this.cat_metatitle.sendKeys(title);
	}
	
	//step 7 Enter Valid credentials in Meta tag Description textbox of General tab
	public void entercat_metaDesc(String metadesc) {
		this.cat_metaDesc.clear();
		this.cat_metaDesc.sendKeys(metadesc);
	}
	
	//step 8 enter Valid credentials in Meta key 
	public void entercat_metakey(String metakey) {
		this.cat_metakey.clear();
		this.cat_metakey.sendKeys(metakey);
	}
	
	//scroll up
	public void scroll() throws AWTException {
		Robot robot = new Robot(); 
		robot.keyPress(KeyEvent.VK_PAGE_UP); 
		robot.keyRelease(KeyEvent.VK_PAGE_UP);
	}
	
	//step 9 Keep Data and Design tab fields with default values
	
	public void Data_tab() throws InterruptedException{
		this.Data_tab.click();
		Thread.sleep(1000);
	}
	
	public void Design_tab() {
		this.designTab.click();
	}
	
	//step 10 Click on Save icon
	public void Save() {
		this.saveCat.click();
	}
	
	// Wrong password message should be displayed
	/*
	public void success() {
		boolean expected = true;
		
		Assert.assertEquals(success_msz.isDisplayed(), expected);
		System.out.println("success msz on console: " + success_msz.getText());
	}
*/
	//check to see if category addition is successful
	public String success() {
		return this.success_msz.getText();
}
}
