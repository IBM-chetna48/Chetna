/*To verify whether application allows user to place an order with Pre Logging in 
& admin change the status of order to complete
*/
package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.training.pom.ShoppingCartPOM4_RTTC009;
import com.training.pom.OrdersPOM;
import com.training.pom.EditCategoryRTTC_039POM;
import com.training.pom.LoginAdminRTTC_037POM;
import com.training.pom.MismatchPasswordPOM_RTTC007;
import com.training.pom.ReturnOrderRTTC_036POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminOrderStatusChangeRTTC070_Test {
	
	private WebDriver driver;
	private String baseUrl;
	private String urlLink;
	private ShoppingCartPOM4_RTTC009 loginPOM4;
	private LoginAdminRTTC_037POM rttc037;
	private MismatchPasswordPOM_RTTC007 loginPOM_rttc007;
	private OrdersPOM rttc070;
	private ReturnOrderRTTC_036POM rttc036;
	private static Properties properties;
	private ScreenShot screenShot;
	private EditCategoryRTTC_039POM rttc039;

	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		
		loginPOM4 = new ShoppingCartPOM4_RTTC009(driver); 
		loginPOM_rttc007 = new MismatchPasswordPOM_RTTC007(driver);
		rttc037 = new LoginAdminRTTC_037POM(driver);
		rttc036 = new ReturnOrderRTTC_036POM(driver);
		rttc039 = new EditCategoryRTTC_039POM(driver);
		rttc070 = new OrdersPOM(driver);
		baseUrl = properties.getProperty("baseURL");
		urlLink = properties.getProperty("adminURL");
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
		//click login icon
		
		loginPOM4.clickLoginMenu();
				
		//click ethnic from shop now
		loginPOM4.clickethnic();
				
		//click the item to be purchased
		loginPOM4.clickItem();
				
		//add the item to cart
		loginPOM4.windowHandle();
				
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
		
		//Steps for CHANGING THE STATUS of order
		//open new tab
		 
		rttc070.newTab();
		driver.get("http://retail.upskills.in/admin");
		
		
		rttc037.enterUsername("admin");
		
		//enter valid password
		rttc037.enterPassword("admin@123");
		
		//click login
		rttc037.submit();
		
		// Click on Sales Icon
		rttc070.clickSales();
		
		// click on Orders link
		rttc070.clickOrders();
		
		//Click on View icon beside the ordered product
		rttc070.returnID();
		rttc070.checkBox();
		
		//click on Order Status list box of Add Order History tab
		rttc070.viewOrderClick();
		
		rttc039.scrollDown();
		//rttc070.ipAddClick();
		
		//Select Valid credentials in Order Status list box
		rttc070.selectSatus("Complete");
		
		//Click on Add History button
		rttc070.addHistClick();
		
		//launch the user application in other tab of browser
		rttc070.newTab2();
		driver.get(baseUrl);
		loginPOM_rttc007.clickLoginMenu(); 
		
		//Click on User Icon
		rttc036.clickLogin(); 
				
		//Click on MY ORDERS link
		rttc036.clickMyOrders();
				
		//Click on view icon
		rttc036.clickView(); 
				
		
		
		System.out.println(rttc070.ordStatus());
		Assert.assertEquals(false, (rttc070.ordStatus().isEmpty()));
		screenShot.captureScreenShot("RTTC070_Order");
	}
}
