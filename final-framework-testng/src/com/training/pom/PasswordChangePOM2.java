//To verify whether application allows user to change the password in Change Your Password page
package com.training.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PasswordChangePOM2 {
	private WebDriver driver;

	public PasswordChangePOM2(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i")
	private WebElement loginMenu;

	@FindBy(partialLinkText = "LOGIN / REGISTER")
	private WebElement oSelect;

	@FindBy(linkText = "Forgotten Password")
	private WebElement forPwd;

	@FindBy(name = "email")
	private WebElement emailID;

	@FindBy(xpath = "//*[@id=\"System_nyHsmShk\"]/form/div/div[2]/input")
	private WebElement submit;

	//@FindBy(xpath = "//*[@id=\"System_nyHsmShk\"]/div[1]")
	@FindBy(xpath ="//div[@class='alert alert-success']")
	private WebElement actual;

	// click on login menu
	public void clickLoginMenu() {
		this.loginMenu.click();
	}

	// click on forgot password
	public void clickForgotPwd() {
		this.forPwd.click();
	}

	// enter email id
	public void enterEmail(String email) {
		this.emailID.clear();
		this.emailID.sendKeys(email);
	}

	// click on submit
	public void submit() {
		this.submit.click();
	}
	// password is changed successfully
	/*
	public void success() {
		boolean expected = true;
		Assert.assertEquals(actual.isDisplayed(), expected);
		System.out.println("success in changing pwd" + actual.getText());
	}
*/
	public String success() {
		return this.actual.getText();
}
}
