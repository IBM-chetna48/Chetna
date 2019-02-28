//*Test case 2: To verify whether application denies admin getting logged in 
package com.training.sanity.tests;

import java.awt.AWTException;
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
import com.training.pom.LoginAdminRTTC_037POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class LoginAdminRTTC037_Test2 {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminRTTC_037POM rttc037;
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
		rttc037 = new LoginAdminRTTC_037POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		//step 1 enter credentials in Username textbox
		rttc037.enterUsername("admin");
		
		//step 2 enter credentials in Password textbox
		rttc037.enterPassword("admin23");
		
		//step 3 click on Login button
		rttc037.submit();
		//check for success message
		String msz="No match ";
		System.out.println(rttc037.success());
		Assert.assertTrue(rttc037.success().contains(msz));
		
		//rttc037.success();
		
		screenShot.captureScreenShot("LoginAdminFail");
	}
}
