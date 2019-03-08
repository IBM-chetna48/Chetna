/*Product List page  */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductListRTTC_067POM {
	private WebDriver driver;

	public ProductListRTTC_067POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	

	@FindBy(linkText = "Products")
	private WebElement products;

	@FindBy(name = "filter_name")
	private WebElement Product_Name;

	@FindBy(name = "filter_price")
	private WebElement Price;
	/*
	 * @FindBy(name = "filter_status") private WebElement Status;
	 */
	@FindBy(name = "filter_model")
	private WebElement Model;

	@FindBy(name = "filter_quantity")
	private WebElement Quantity;

	@FindBy(name = "filter_image")
	private WebElement Image;

	@FindBy(id = "button-filter")
	private WebElement Filter;

	@FindBy(xpath = "//table//tbody//tr")
	private WebElement result;

	// Click on Product link
	public void clickProduct() {
		this.products.click();
	}

	// Enter Product name
	public void enterProductsName(String ProductName) {
		this.Product_Name.clear();
		this.Product_Name.sendKeys(ProductName);
	}

	// Enter Price
	public void enterPrice(String price) {
		this.Price.clear();
		this.Price.sendKeys(price);
	}

	// Select status
	public void enterStatus(String status) {
		Select drpStatus = new Select(driver.findElement(By.name("filter_status")));
		drpStatus.selectByVisibleText(status);

	}

	// Enter credentials in model
	public void enterModel(String model) {
		this.Model.clear();
		this.Model.sendKeys(model);
	}

	// enter quantity
	public void enterQuantity(String quantity) {
		this.Quantity.clear();
		this.Quantity.sendKeys(quantity);
	}

	// Select if image is enabled or disabled
	public void enterImage(String image) {
		Select drpImage = new Select(Image);
		drpImage.selectByVisibleText(image);
	}

	// click filter
	public void clickFilter() {
		this.Filter.click();
	}

	// Fetch the resulting row
	public String getResult() {
		return this.result.getText();
	}

}
