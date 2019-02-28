/* To verify whether application allows admin to Edit Meta tag Title in categories page
 */
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

public class EditCategoryRTTC_039POM {
	private WebDriver driver;

	public EditCategoryRTTC_039POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// scroll down function
	public void scrollDown() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	// Click on Edit icon of the category to modify
	@FindBy(xpath = "//td[contains(text(),'ORNAMENTS')]//following-sibling::td[2]//a")
	private WebElement edit_cat;

	public void editCat() {
		this.edit_cat.click();

	}

	// Clear the values present in Meta tag Title textbox and enter new value
	@FindBy(id = "input-meta-title1")
	private WebElement edit_Metatitle;

	public void editMeta_Title(String title) {
		this.edit_Metatitle.clear();
		this.edit_Metatitle.sendKeys(title);
	}

	// Enter Valid credentials in Meta tag Description textbox of General tab
	@FindBy(id = "input-meta-description1")
	private WebElement edit_metaDesc;

	public void editmeta_Desc(String desc) {
		this.edit_metaDesc.clear();
		this.edit_metaDesc.sendKeys(desc);
	}
	
	@FindBy(xpath="//div[@class='alert alert-success']")
	private WebElement success_msz;
	
	public String success() {
		return this.success_msz.getText();
}
	
}
