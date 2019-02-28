/*
 * To Verify whether application displays appropriate search products based on the user preference
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ProductsortByListRTTC008_Tests3 {

	private WebDriver driver;
	private String baseUrl;
//	private LoginPOM loginPOM;
	private ProductSortByListPOM3_RTTC008 loginPOM3;
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
	//	loginPOM = new LoginPOM(driver); 
		loginPOM3 = new ProductSortByListPOM3_RTTC008(driver); 
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
	public void validLoginTest() {
	//	loginPOM2.sendUserName("admin");
//		loginPOM2.sendPassword("admin@123");
		loginPOM3.clickLoginMenu();
		loginPOM3.clickethnic();
		loginPOM3.click_sortBy();
		screenShot.captureScreenShot("third");
	}
}
