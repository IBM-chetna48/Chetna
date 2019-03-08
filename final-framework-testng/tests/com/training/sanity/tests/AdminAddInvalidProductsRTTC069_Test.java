//To verify whether application allows admin to add category in categories page
package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM; //old
import com.training.pom.LoginAdminRTTC_037POM;
import com.training.pom.AddCategoryRTTC_038POM;
import com.training.pom.AddProductsRTTC_068POM;
import com.training.pom.ProductListRTTC_067POM;
import com.training.pom.EditCategoryRTTC_039POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminAddInvalidProductsRTTC069_Test {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminRTTC_037POM rttc037;
	//private AdminFilterProductsWithMultipleValuesRTTC_067POM rttc067;
	private AddProductsRTTC_068POM rttc068; 
	private AddCategoryRTTC_038POM rttc038;
	private EditCategoryRTTC_039POM rttc039;
	private static Properties properties;
	private ScreenShot screenShot;

	@BeforeClass
	public void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		rttc037 = new LoginAdminRTTC_037POM(driver);
		rttc038 = new AddCategoryRTTC_038POM(driver);
		rttc039 = new EditCategoryRTTC_039POM(driver);
		//rttc067 = new AdminFilterProductsWithMultipleValuesRTTC_067POM(driver);
		rttc068 = new AddProductsRTTC_068POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
	}

	
	
	@AfterTest
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test(priority = 0)
	public void Login()
	{
		rttc037.enterUsername("admin");
		
		//enter valid password
		rttc037.enterPassword("admin@123");
		
		//click login
		rttc037.submit();

	}
	
	
	@Test (priority = 1, dataProvider = "excel-inputs2" , dataProviderClass = LoginDataProviders.class)
	public void FilterProductInvalidTest(String ProductName1, String Title1, String Model1, String ProductPrice1, String cat1 ) throws InterruptedException, AWTException 
		{
			//step 1 Click on Catelog icon
			rttc038.enterCatalog();
			
			//step 2 Click on Product link
			rttc068.clickProduct();
			
			// step 3 Click on Add New icon
			rttc068.clickAdd();
			
			// step 4Enter Valid credentials in Product Name of General tab
			rttc068.enterProductsName(ProductName1);
			
			// step 5 Enter Valid credentials in Meta Tag Title of General tab
			rttc068.enterMetaTagTitle(Title1);
			
			rttc038.scroll();
			Thread.sleep(2000);
			
			//// step 6 Click on Data tab
			rttc068.clickData();
			
			// step 7 Enter valid credentials in Model textbox
			rttc068.enterModel(Model1);
			rttc039.scrollDown();
			
			// step 8 Enter valid credentials in Price textbox
			rttc068.enterPrice(ProductPrice1);
			rttc038.scroll();
			Thread.sleep(2000);
			
			// step 9 Click on Links tab
			rttc068.clickLinks();
		
			// step 10 Click on Categories textbox
			rttc068.enterCategories(cat1);
			
			// step 11 Keep default values in Attribute, Option, Recurring, Discount,
			// Special, Image, Reward Points and Design tab
			rttc068.clickAttr();
			rttc068.clickOption();
			rttc068.clickRecurring();
			rttc068.clickDisc();
			rttc068.clickSpecial();
			rttc068.clickImage();
			rttc068.clickReward();
			rttc068.clickDesign();
			rttc068.clicksubmit();
			
			//Assert true if error message is received
			String errmsz="Warning: ";
			System.out.println(rttc068.getErrMsz());
			Assert.assertTrue(rttc068.getErrMsz().contains(errmsz));
			
			//Assert.assertEquals(false, (rttc068.getErrMsz().isEmpty()));
			
			screenShot.captureScreenShot("ProductErr");
			
		}
	
	
}
