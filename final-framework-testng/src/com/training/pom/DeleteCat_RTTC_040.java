/* To verify whether application allows the user to remove added product 
 * details from cart
 */
package com.training.pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteCat_RTTC_040 {
	private WebDriver driver;

	public DeleteCat_RTTC_040(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// path for Checkbox of category to be deleted
	@FindBy(xpath = "//td[contains(text(),'ORNAMENTS')]//preceding-sibling::td//*")
	private WebElement check_cat;

	// path for delete icon
	@FindBy(xpath = "//button[@type='button']")
	private WebElement delete_cat;

	// path of message which appears when category is successfully deleted
	@FindBy(xpath = "//div[@class='alert alert-success']")
	private WebElement success_msz;

	// Click on Checkbox of the category to be deleted
	public void checkCat() {
		this.check_cat.click();

	}

	// click the delete icon
	public void deleteCat() {
		this.delete_cat.click();

	}

	// click on ok button of pop up window
	public void alert() {
		Alert alert = driver.switchTo().alert();
		String msz = driver.switchTo().alert().getText();
		System.out.println(msz);
		alert.accept();

	}

	// Get the success text message of deleting category
	public String getMszBox() {
		return this.success_msz.getText();
	}

}
