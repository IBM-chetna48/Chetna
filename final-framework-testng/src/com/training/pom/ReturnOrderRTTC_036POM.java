/*To Verify whether application allows the user to return ordered product */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ReturnOrderRTTC_036POM {
	private WebDriver driver;

	public ReturnOrderRTTC_036POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	// elements for ordering product

	@FindBy(linkText = "Checkout")
	private WebElement checkout;

	@FindBy(id = "button-payment-address")
	private WebElement cont_button;

	@FindBy(id = "input-shipping-firstname")
	private WebElement firstname;

	@FindBy(id = "input-shipping-lastname")
	private WebElement Lastname;

	@FindBy(id = "input-shipping-address-1")
	private WebElement Address1;

	@FindBy(id = "input-shipping-city")
	private WebElement city;

	@FindBy(id = "input-shipping-postcode")
	private WebElement postCode;

	@FindBy(id = "button-shipping-address")
	private WebElement cont_button2;

	@FindBy(id = "button-shipping-method")
	private WebElement cont_button3;

	@FindBy(id = "button-payment-method")
	private WebElement cont_button4;

	@FindBy(name = "agree")
	private WebElement terms;

	@FindBy(id = "button-confirm")
	private WebElement confirm;

	@FindBy(linkText = "Continue")
	private WebElement cont_button5;

	// Elements for return product

	@FindBy(linkText = "MY ORDERS")
	private WebElement orders;

	@FindBy(xpath = "//*[@id=\"System_gqgg2zel\"]/div[1]/table/tbody/tr/td[7]/a/i")
	private WebElement view;

	@FindBy(xpath = "//*[@id=\"System_gqgg2zel\"]/div/div[1]/table/tbody/tr/td[6]/a[2]/i")
	private WebElement returnorder;

	@FindBy(name = "return_reason_id")
	private List<WebElement> reason;

	@FindBy(name = "opened")
	private List<WebElement> open;

	@FindBy(name = "comment")
	private WebElement Comment;

	@FindBy(xpath = "//*[@id=\"return_request_form\"]/div/div/input")
	private WebElement Sub_button;

	@FindBy(xpath = "//div[@class='tb_text_wrap tb_sep']")
	private WebElement actual;

	/*************************************************
	 * */

	// steps for ordering a product

	// click on checkout option on cart window
	public void clickcheckout() {
		this.checkout.click();
	}

	// click on continue button
	public void clickcontinue() {
		this.cont_button.click();

	}

	// select 'I want to use new address' in delivery details
	public void enterShipping() throws InterruptedException {

		// this.shipping.click();
		WebElement shipping;
		shipping = driver.findElement(By.xpath("*//*[@id=\"collapse-shipping-address\"]/div/div[3]/label"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", shipping);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}

	// enter first name in delivery details
	public void enterfirstname(String fname) {
		this.firstname.clear();
		this.firstname.sendKeys(fname);
	}

	// enter last name in delivery details
	public void enterLast(String lname) {
		this.Lastname.clear();
		this.Lastname.sendKeys(lname);

	}

	// enter address in delivery details
	public void enteraddress(String addr) {
		this.Address1.clear();
		this.Address1.sendKeys(addr);

	}

	// enter address in delivery details
	public void enterCity(String cty) {
		this.city.clear();
		this.city.sendKeys(cty);

	}

	// enter postal code
	public void enterPostncode(String pin) {
		this.postCode.clear();
		this.postCode.sendKeys(pin);
	}

	// click continue
	public void clickcontinue2() {
		this.cont_button2.click();
	}

	// click continue on free shipping step
	public void clickcontinue3() {
		this.cont_button3.click();
	}

	// click the agree to terms checkbox
	public void clickterms() {
		this.terms.click();
	}

	// click on continue on shipping step
	public void clickcontinue4() {
		this.cont_button4.click();
	}

	// click on confirm button
	public void clickconfirm() {
		this.confirm.click();
	}

	// click on continue to get back to main page
	public void clickcontinue5() {
		this.cont_button5.click();
	}

	// steps for returning a product

	// step 1 click on login icon

	public void clickLogin() {
		WebElement ele = driver.findElement(By.xpath("//*[@id=\"Menu_Wmt3OMY3\"]/nav/ul/li[2]/a/span/span/i"));
		// Create object 'action' of an Actions class

		Actions action = new Actions(driver);
		// Mouseover on an element
		action.moveToElement(ele).build().perform();
		// this.user.click();
	}

	// step 2 select my orders from login menu
	public void clickMyOrders() {
		this.orders.click();
	}

	// step 3 click on view icon on the product
	public void clickView() {
		this.view.click();
	}

	// scroll down to locate return icon
	public void scroll() throws AWTException {
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_PAGE_DOWN);
		robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	}

	// step 4 click on return
	public void clickreturn() {
		this.returnorder.click();
	}

	// step 5 click on dead on arrival as reason
	public void clickradio() {
		((WebElement) this.reason.get(0)).click();
	}

	// step 6 Click radio button of Product is opened category
	public void clickopen() {
		((WebElement) this.open.get(0)).click();
	}

	// step 7 Enter reason for return
	public void enterComment(String text) {
		this.Comment.clear();
		this.Comment.sendKeys(text);
	}

	// step 8 click submit
	public void clickSubmit() {
		this.Sub_button.click();
	}

	// Get the success message
	public String success() {
		return this.actual.getText();
		// boolean expected = true;
		// WebElement actual;
		// actual =
		// driver.findElement(By.xpath("//*[@id=\"System_gqgg2zel\"]/div[1]/p[1]"));
		// Assert.assertEquals(actual.isDisplayed(), expected);
		// System.out.println("success msz: " + actual.getText());
	}

}
