/*
 * To Verify whether application displays appropriate search products based on the user preference
 */
package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ProductSortByListPOM3_RTTC008 {
	private WebDriver driver;

	public ProductSortByListPOM3_RTTC008(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"menu_all_categories_Menu_VIfWm2LT_Ytne9\"]/a/span")
	private WebElement shopNow;

	@FindBy(linkText = "Ethnic")
	private WebElement ethnic;

	@FindBy(xpath = "//*[@id=\"ProductsSystem_QQI8r357\"]/nav/div/div[3]/select")
	// private WebElement sortBy;
	private WebElement select;

	// step 1: Click on ETHNIC link
	public void clickLoginMenu() {
		this.shopNow.click();
	}

	// step 2: Click on Sort By list box
	public void clickethnic() {
		this.ethnic.click();
	}

	// step 3:Select Name(A-Z) in Sort By List box
	public void click_sortBy() {

		Select dropdown = new Select(select);
		dropdown.selectByIndex(1);
		// step 4: Select Rating(Highest) in Sort By List box
		dropdown.selectByVisibleText("Rating (Highest)");

		boolean expected = true;

		WebElement actual = dropdown.getFirstSelectedOption();
		Assert.assertEquals(actual.isDisplayed(), expected);
		System.out.println(actual.getText());
	}

}
