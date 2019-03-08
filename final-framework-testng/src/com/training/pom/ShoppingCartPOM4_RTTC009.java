/*
 * Add product details into cart
 */

package com.training.pom;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ShoppingCartPOM4_RTTC009 {
	private WebDriver driver; 
	
	public ShoppingCartPOM4_RTTC009(WebDriver driver) {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//*[@id=\"menu_all_categories_Menu_VIfWm2LT_Ytne9\"]/a/span")
	private WebElement shopNow; 
	
	@FindBy(linkText="Ethnic")
	private WebElement ethnic; 
	
	
	
	@FindBy(xpath="//*[@id=\"ProductsSystem_QQI8r357\"]/div[1]/div[1]/div/div[3]/div/div/div[1]/h4/a")
	//private WebElement sortBy;
	private WebElement item;
	
	
	
	public void clickLoginMenu() {
		this.shopNow.click(); 
	}
	
	//step 1. Click on ETHNIC link
	public void clickethnic() {
		this.ethnic.click(); 
	}
	
	//step 2. Click on Integer Vitae Iaculis Massa product
		public void clickItem() {
		this.item.click(); 
	}
		
		//step 3,4,5 
		public void windowHandle() throws InterruptedException {
			// handle for element on next screen
			String main_windowHandle = driver.getWindowHandle();
			System.out.println("main_windowHandle "+main_windowHandle);

			Set<String> windowHandles = driver.getWindowHandles();

			for(String handle:windowHandles)
			{
			if(handle.equals(main_windowHandle))
			{
			//don't do anything
			}
			
			else
			{
			driver.switchTo().window(handle);
			System.out.println("Title of 2nd window is "+driver.switchTo().window(handle).getTitle());
			Thread.sleep(10000);
			
			//step 3: Click on Add to Cart button which is on next screen
			driver.findElement(By.id("button-cart")).click();

			System.out.println("Title of 2nd window after click "+driver.switchTo().window(handle).getTitle());
			
			//Handle the notification message of successful product addition to cart
			String alertText = "";
			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='noty_cont noty_layout_topRight']")));
			WebElement toast1 = driver.findElement(By.xpath("//ul[@class='noty_cont noty_layout_topRight']"));  
			alertText = toast1.getText();
			System.out.println(alertText);
			Thread.sleep(2000);
			//step 4: Mouse Over to Cart Icon
			WebElement ele = driver.findElement(By.xpath("//*[@id=\"cart\"]/ul/li/h3/a/i"));
			//Create object 'action' of an Actions class
			
			Actions action = new Actions(driver);
			//Mouseover on an element
			action.moveToElement(ele).build().perform();
			
			//step 5 : click on View Cart button
			WebElement view = driver.findElement(By.linkText("View Cart"));
			view.click();
			}
			System.out.println(handle);

			//driver.switchTo().window(main_windowHandle);

			}
				}
	
	 
		public void success() {
			boolean expected = true;
			WebElement actual;
			actual = driver.findElement(By.xpath("//*[@id=\"cart_form\"]/div/table/tbody/tr/td[2]/a"));
			Assert.assertEquals(actual.isDisplayed(), expected);
			System.out.println("Product displayed on screen:" + actual.getText());
		}
		

	
		
		
}
