//To verify whether application allows admin to add category in categories page
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
import com.training.pom.AddCategoryRTTC_038POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AddCategoryRTTC038_Test3 {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminRTTC_037POM rttc037;
	private AddCategoryRTTC_038POM rttc038;
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
		rttc038 = new AddCategoryRTTC_038POM(driver);
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
		
		//enter username credentials
		rttc037.enterUsername("admin");
		
		//enter valid password
		rttc037.enterPassword("admin@123");
		
		//click login
		rttc037.submit();

		//step 1 Click on Catelog icon
		rttc038.enterCatalog();
		
		//step 2 Click on Categories link
		rttc038.clickCategory();
		
		//step 3 Click on Add new icon
		rttc038.addCategory();
		
		//step 4 Enter Valid credentials in Category Name textbox of General tab
		rttc038.enterCat_Name("ORNAMENTS");
		
		//step 5 Enter Valid credentials in Description textbox of General tab
		rttc038.enterCat_Desc("ornaments for ladies");
		
		//step 6 Enter Valid credentials in Meta tag Title textbox of General tab
		rttc038.enterMeta_Title("ORNAMENTS");
		
		//step 7 Enter Valid credentials in Meta tag Description textbox of General tab
		rttc038.entercat_metaDesc("ornaments for ladies");
		
		//step 8 enter Valid credentials in Meta key 
		rttc038.entercat_metakey("ornaments");
		
		//scroll up
		rttc038.scroll();
		
		//step 9 Keep Data and Design tab fields with default values
		rttc038.Data_tab();
		rttc038.Design_tab();
		
		//step 10 Click on Save icon
		rttc038.Save();
		
		String msz="Success: ";
		System.out.println(rttc038.success());
		Assert.assertTrue(rttc038.success().contains(msz));
		rttc038.success();
		
		screenShot.captureScreenShot("AddCategory");
	}
}
