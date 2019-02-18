/*Test Case 2: To verify whether application displays error message upon mis matching password 
& confirm password of Change Your Password page */
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
import com.training.pom.LoginPOM2;
import com.training.pom.LoginPOM_RTTC007;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginTests_RTTC007 {

	private WebDriver driver;
	private String baseUrl;
	// private LoginPOM loginPOM;
	private LoginPOM_RTTC007 RTTC007;
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
		RTTC007 = new LoginPOM_RTTC007(driver);
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
		// loginPOM2.sendUserName("admin");
		// loginPOM2.sendPassword("admin@123");
		RTTC007.clickLoginMenu();
		RTTC007.enterEmail("chetna4889@gmail.com");
		RTTC007.enterPassword("chetna");
		RTTC007.submit();
		RTTC007.changeP();
		RTTC007.enterActualP("chetna");
		RTTC007.enterConfirmP("HELLO");
		RTTC007.final_submit();
		RTTC007.success();
		screenShot.captureScreenShot("second");
	}
}
