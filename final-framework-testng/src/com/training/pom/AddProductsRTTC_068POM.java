/*To verify whether application allows admin to add category in categories page  */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AddProductsRTTC_068POM {
	private WebDriver driver;

	public AddProductsRTTC_068POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(linkText = "Products")
	private WebElement products;

	@FindBy(xpath = "//div[@class='pull-right']//a[@class='btn btn-primary']")
	private WebElement Add;

	@FindBy(id = "input-name1")
	private WebElement Prd_Name;
	
	@FindBy(id = "input-meta-title1")
	private WebElement Prd_MetaTitle;

	@FindBy(linkText = "Data")
	private WebElement data_Tab;

	@FindBy(id = "input-model")
	private WebElement prd_Model;

	@FindBy(id = "input-price")
	private WebElement prd_Price;

	@FindBy(id = "input-quantity")
	private WebElement prd_Quantity;

	@FindBy(linkText = "Links")
	private WebElement link_Tab;

	@FindBy(id = "input-category")
	private WebElement prd_Cat;

	@FindBy(linkText = "Attribute")
	private WebElement attribute_Tab;

	public void clickAttr() {
		this.attribute_Tab.click();
	}

	@FindBy(linkText = "Option")
	private WebElement option_Tab;

	public void clickOption() {
		this.option_Tab.click();
	}

	@FindBy(linkText = "Recurring")
	private WebElement recurring_Tab;

	public void clickRecurring() {
		this.recurring_Tab.click();
	}

	@FindBy(linkText = "Discount")
	private WebElement discount_Tab;

	public void clickDisc() {
		this.discount_Tab.click();
	}

	@FindBy(linkText = "Special")
	private WebElement special_Tab;

	public void clickSpecial() {
		this.special_Tab.click();
	}

	@FindBy(linkText = "Image")
	private WebElement image_Tab;

	public void clickImage() {
		this.image_Tab.click();
	}

	@FindBy(linkText = "Reward Points")
	private WebElement rp_Tab;

	public void clickReward() {
		this.rp_Tab.click();
	}

	@FindBy(linkText = "Design")
	private WebElement design_Tab;

	public void clickDesign() {
		this.design_Tab.click();
	}

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	public void clicksubmit() {
		this.submit.click();
	}

	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement success_msz;

	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement err_Msz;

	// Click on Product link
	public void clickProduct() {
		this.products.click();
	}

	// click add
	public void clickAdd() {
		this.Add.click();
	}

	// Enter product name
	public void enterProductsName(String productName) {
		this.Prd_Name.clear();
		this.Prd_Name.sendKeys(productName);
	}

	// enter meta tag title
	public void enterMetaTagTitle(String metaTitle) {
		this.Prd_MetaTitle.clear();
		this.Prd_MetaTitle.sendKeys(metaTitle);
	}

	// scroll up
	// click data tab
	public void clickData() {
		this.data_Tab.click();
	}

	// enter model
	public void enterModel(String model) {
		this.prd_Model.clear();
		this.prd_Model.sendKeys(model);
	}

	// scroll down

	// enter price
	public void enterPrice(String price) {
		this.prd_Price.clear();
		this.prd_Price.sendKeys(price);
	}

	// enter quantity
	public void enterQuantity(String quantity) {
		this.prd_Quantity.clear();
		this.prd_Quantity.sendKeys(quantity);
	}
	// scroll up

	// click link tab
	public void clickLinks() {
		this.link_Tab.click();
	}

	// enter product category
	public void enterCategories(String cat) {
		this.prd_Cat.clear();
		this.prd_Cat.sendKeys(cat);

	}

	// get success message
	public String getMszBox() {
		return this.success_msz.getText();
	}

	// get error message
	public String getErrMsz() {
		return this.err_Msz.getText();
	}

}
