/*
 * To verify whether application allows the user to remove added product details from cart
 */

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM; //old
import com.training.pom.PasswordChangePOM2;
import com.training.pom.ProductSortByListPOM3_RTTC008;
import com.training.pom.AddToCartPOM4_RTTC009;
import com.training.pom.RemoveProduct_RTTC010;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class RemoveProductRTTC010_Tests5 {

	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	// private LoginPOM3 loginPOM3;
	private RemoveProduct_RTTC010 loginPOM5;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		// loginPOM = new LoginPOM(driver);
		loginPOM5 = new RemoveProduct_RTTC010(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test
	public void validLoginTest() throws InterruptedException {
		// loginPOM2.sendUserName("admin");
		// loginPOM2.sendPassword("admin@123");
		loginPOM5.clickLoginMenu();
		loginPOM5.clickethnic();

		loginPOM5.clickItem();
		loginPOM5.windowHandle();
		//loginPOM5.success();
		String msz="Your shopping ";
		System.out.println(loginPOM5.success());
		Assert.assertTrue(loginPOM5.success().contains(msz));
		screenShot.captureScreenShot("Fifth");

		// loginPOM3.click_sotBy();
	}
}
