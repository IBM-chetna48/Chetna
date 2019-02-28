//To Verify whether application allows the user to return ordered product
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
import com.training.pom.PasswordChangePOM2;
import com.training.pom.ProductSortByListPOM3_RTTC008;
import com.training.pom.AddToCartPOM4_RTTC009;
import com.training.pom.MismatchPasswordPOM_RTTC007;
import com.training.pom.ReturnOrderRTTC_036POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class ReturnOrderRTTC036_Test {
	
	private WebDriver driver;
	private String baseUrl;
	
	private AddToCartPOM4_RTTC009 loginPOM4;
	private MismatchPasswordPOM_RTTC007 loginPOM_rttc007;
	private ReturnOrderRTTC_036POM rttc036;
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
		
		loginPOM4 = new AddToCartPOM4_RTTC009(driver); 
		loginPOM_rttc007 = new MismatchPasswordPOM_RTTC007(driver);
		rttc036 = new ReturnOrderRTTC_036POM(driver);
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		
		//steps for login 
		loginPOM_rttc007.clickLoginMenu(); 
		
		// enter email id and adding item to cart
		loginPOM_rttc007.enterEmail("chetna4889@gmail.com");
		
		//enter password
		loginPOM_rttc007.enterPassword("chetna");
		
		//click login
		loginPOM_rttc007.submit();
		
		//click login icon
		loginPOM4.clickLoginMenu();
		
		//click ethnic from shop now
		loginPOM4.clickethnic();
		
		//click the item to be purchased
		loginPOM4.clickItem();
		
		//add the item to cart
		loginPOM4.windowHandle();
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
	//	loginPOM2.sendUserName("admin");
//		loginPOM2.sendPassword("admin@123");
		
		//steps for ordering a product
		//click on checkout option on cart window
		rttc036.clickcheckout();
		
		//click on continue
		rttc036.clickcontinue();
		
		//select 'I want to use new address' in delivery details
		rttc036.enterShipping() ;
		
		//enter first name in delivery details
		rttc036.enterfirstname("chetna");
		
		//enter last name
		rttc036.enterLast("singh");
		
		//enter address
		rttc036.enteraddress("pitampura") ;		
		
		//enter city
		rttc036.enterCity("delhi") ;
		
		//enter pin code
		rttc036.enterPostncode("110034") ;
		
		//click continue
		rttc036.clickcontinue2();
		Thread.sleep(2000);
		
		//click continue  on free shipping step
		rttc036.clickcontinue3() ;
		Thread.sleep(3000);
		
		//click the agree to terms checkbox
		rttc036.clickterms() ;
		
		//click on continue on shipping step
		rttc036.clickcontinue4();
		
		//click confirm for ordering 
		rttc036.clickconfirm() ;
		
		//click continue to navigate back to main page
		rttc036.clickcontinue5(); 
		// end of ordering product steps
		
		//Steps for returning product
		
		//step 1 Click on User Icon
		rttc036.clickLogin(); 
		
		//step 2 Click on MY ORDERS link
		rttc036.clickMyOrders();
		
		//step 3 Click on view icon
		rttc036.clickView(); 
		//rttc036.scroll();
		
		//step 4 Click on Return icon
		rttc036.clickreturn();
		
		//step 5 Click on valid Reason for Return radio button
		rttc036.clickradio();
		
		//step 6 Click radio button of Product is opened category
		rttc036.clickopen();
		
		//step 7 Enter reason for return in Faulty or other details textbox
		rttc036.enterComment("product is faulty");
		
		//step 8  Click on Submit button
		rttc036.clickSubmit();
		
		//check if successful message is generated
		String msz="Thank you ";
		System.out.println(rttc036.success());
		Assert.assertTrue(rttc036.success().contains(msz));
		screenShot.captureScreenShot("RTTC036_Return_Order");
		
		
		
	}
}
