/*Order Page*/
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class OrdersPOM {
	private WebDriver driver;
	private String idData;

	public OrdersPOM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// elements for ordering product
	public void newTab() throws AWTException {
		// To open a new tab

		((JavascriptExecutor) driver).executeScript("window.open()");
		// ((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(2));
		// driver.get("http://google.com");
	}

	public void newTab2() throws AWTException {
		// To open a new tab

		((JavascriptExecutor) driver).executeScript("window.open()");
		// ((JavascriptExecutor)driver).executeScript("window.open()");
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(3));
		// driver.get("http://google.com");
	}

	// click sales
	@FindBy(xpath = "//a[@class='parent']//i[@class='fa fa-shopping-cart fw']")
	private WebElement Sales;

	public void clickSales() {
		this.Sales.click();

	}

	// click order
	@FindBy(linkText = "Orders")
	private WebElement Orders;

	public void clickOrders() {
		this.Orders.click();

	}

	// click checkbox
	@FindBy(xpath = "//table//tbody//tr//td[2]")
	private WebElement returnid;

	public void returnID() {
		idData = this.returnid.getText();
		System.out.println(idData);
	}

	public void checkBox() {
		String Before = "//input[@value='";
		String after = "']";
		String path = Before + idData + after;
		driver.findElement(By.xpath(path)).click();

	}

	// click view order
	@FindBy(xpath = "//table//tbody//tr//td[8]//a//i[@class='fa fa-eye']")
	private WebElement viewOrder;

	public void viewOrderClick() {
		this.viewOrder.click();

	}

	// select order status
	@FindBy(id = "input-order-status")
	private WebElement orderStatus;

	public void selectSatus(String ordStat) {
		Select drpImage = new Select(orderStatus);
		drpImage.selectByVisibleText(ordStat);
	}

	// Add history
	@FindBy(id = "button-history")
	private WebElement addHistory;

	public void addHistClick() {
		this.addHistory.click();

	}

	// success message
	@FindBy(id = "//div[@class='alert alert-success']")
	private WebElement success;

	// view history
	@FindBy(linkText = "View your order history")
	private WebElement orderHistory;

	public void ordHistClick() {
		this.orderHistory.click();

	}

	// Ordered row from history
	@FindBy(xpath = "//table[3]//tr[2]")
	private WebElement Status;

	public String ordStatus() {

		return this.Status.getText();
	}
}
