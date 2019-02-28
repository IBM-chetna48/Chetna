//To verify whether application allows user to change the password in Change Your Password page
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
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class PasswordChangeRTTC_006 {
	
	private WebDriver driver;
	private String baseUrl;
//	private LoginPOM loginPOM;
	private PasswordChangePOM2 loginPOM2;
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
		loginPOM2 = new PasswordChangePOM2(driver); 
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
		// click on login menu
		loginPOM2.clickLoginMenu(); 
		
		// click on forgot password
		loginPOM2.clickForgotPwd();
		
		// enter emailID
		loginPOM2.enterEmail("chetna4889@gmail.com");
		
		//login
		loginPOM2.submit();
		loginPOM2.success();
		String msz="An email ";
		System.out.println(loginPOM2.success());
		Assert.assertTrue(loginPOM2.success().contains(msz));
		
		screenShot.captureScreenShot("First");
	}
}
