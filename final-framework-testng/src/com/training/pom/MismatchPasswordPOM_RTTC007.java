/*Test case 2: To verify whether application displays error message upon mis matching password 
& confirm password of Change Your Password page */
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MismatchPasswordPOM_RTTC007 {
	private WebDriver driver;

	public MismatchPasswordPOM_RTTC007(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i")
	private WebElement loginMenu;

	@FindBy(partialLinkText = "LOGIN / REGISTER")
	private WebElement oSelect;

	@FindBy(name = "email")
	private WebElement emailID;

	@FindBy(name = "password")
	private WebElement passWord;

	@FindBy(xpath = "//*[@id=\"System_nyHsmShk\"]/div/div[2]/div/form/div/div[2]/input")
	private WebElement submit;

	@FindBy(linkText = "Change your password")
	private WebElement change;

	@FindBy(name = "password")
	private WebElement actual_password;

	@FindBy(name = "confirm")
	private WebElement confirm_password;

	@FindBy(xpath = "//*[@id=\"System_gqgg2zel\"]/form/div/div[2]/input")
	private WebElement final_Submit;

	@FindBy(xpath = "//div[@class='text-danger']")
	////*[@id=\"System_gqgg2zel\"]/form/fieldset/div[2]/div/div
	private WebElement errMsz;

	// click on login menu

	public void clickLoginMenu() {
		this.loginMenu.click();
	}

	// enter email id
	public void enterEmail(String email) {
		this.emailID.clear();
		this.emailID.sendKeys(email);
	}

	// enter password
	public void enterPassword(String password) {
		this.passWord.clear();
		this.passWord.sendKeys(password);
	}

	// submit the form
	public void submit() {
		this.submit.click();
	}

	// step 1 :Click on Change your password link
	public void changeP() {
		this.change.click();
	}

	// step 2 :Enter new password in Password textbox
	public void enterActualP(String PWD) {
		this.actual_password.clear();
		this.actual_password.sendKeys(PWD);

	}
	
	// step 3: Enter new password in Confirm Password textbox
	public void enterConfirmP(String confirm) {
		this.confirm_password.clear();
		this.confirm_password.sendKeys(confirm);
	}

	// step 4 :Click on Continue button
	public void final_submit() {
		this.final_Submit.click();
	}

	// Wrong password message should be displayed
	/*
	public void success() {
		boolean expected = true;
		Assert.assertEquals(errMsz.isDisplayed(), expected);
		System.out.println("Wrong Password entered: " + errMsz.getText());
	}
*/
	
	public String success() {
		return this.errMsz.getText();
}
}
