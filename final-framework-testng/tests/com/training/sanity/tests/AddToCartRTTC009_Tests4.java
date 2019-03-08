/*
 * To verify whether application allows the user to add product details into cart
 */

package com.training.sanity.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM; //old
import com.training.pom.PasswordChangePOM2;
import com.training.pom.ProductSortByListPOM3_RTTC008;
import com.training.pom.ShoppingCartPOM4_RTTC009;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddToCartRTTC009_Tests4 {

	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	// private LoginPOM3 loginPOM3;
	private ShoppingCartPOM4_RTTC009 loginPOM4;
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
		loginPOM4 = new ShoppingCartPOM4_RTTC009(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(baseUrl);
	}
/*
	@AfterMethod
	
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();

	}
*/
	@Test
	public void validLoginTest() throws InterruptedException {
		// loginPOM2.sendUserName("admin");
		// loginPOM2.sendPassword("admin@123");
		loginPOM4.clickLoginMenu();
		loginPOM4.clickethnic();
		loginPOM4.clickItem();
		loginPOM4.windowHandle();
		loginPOM4.success();
		screenShot.captureScreenShot("Fourth");

	}
}
