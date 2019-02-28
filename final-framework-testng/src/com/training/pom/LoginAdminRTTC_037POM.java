/*Test case 2: To verify whether application denies admin getting logged in 
upon entering invalid credentials in required field  */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginAdminRTTC_037POM {
	private WebDriver driver;

	public LoginAdminRTTC_037POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "username")
	private WebElement uname;

	@FindBy(name = "password")
	private WebElement pWord;

	@FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div[2]/form/div[3]/button")
	private WebElement submit;

	//@FindBy(xpath = "//*[@id=\"content\"]/div/div/div/div/div[2]/div")
	@FindBy(xpath = "//div[@class='alert alert-danger']")
	private WebElement errMsz;

	
	// step 1 enter credentials in Username textbox
	public void enterUsername(String name) {
		this.uname.clear();
		this.uname.sendKeys(name);
	}

	// step 2 enter credentials in Password textbox
	public void enterPassword(String password) {
		this.pWord.clear();
		this.pWord.sendKeys(password);
	}

	// step 3 click on Login button
	public void submit() {
		this.submit.click();
	}

	
	// Wrong password message should be displayed
	
	public String success() {
		return this.errMsz.getText();
	}
	/*
	public void success() {
		boolean expected = true;
		
		Assert.assertEquals(errMsz.isDisplayed(), expected);
		System.out.println("Wrong Password entered: " + errMsz.getText());
	}
*/
}
