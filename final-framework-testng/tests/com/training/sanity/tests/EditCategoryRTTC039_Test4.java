//To verify whether application allows admin to Edit Meta tag Title in categories page
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
import com.training.pom.EditCategoryRTTC_039POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class EditCategoryRTTC039_Test4 {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminRTTC_037POM rttc037;
	private AddCategoryRTTC_038POM rttc038;
	private EditCategoryRTTC_039POM rttc039;
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
		rttc039 = new EditCategoryRTTC_039POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		
		//steps for admin login
		rttc037.enterUsername("admin");
		rttc037.enterPassword("admin@123");
		rttc037.submit();
		/* steps for adding category*/
		rttc038.enterCatalog();
		rttc038.clickCategory();
		rttc038.addCategory();
		rttc038.enterCat_Name("ORNAMENTS");
		rttc038.enterCat_Desc("ornaments for ladies");
		rttc038.enterMeta_Title("ORNAMENTS");
		rttc038.entercat_metaDesc("ornaments for ladies");
		rttc038.entercat_metakey("ornaments");
		rttc038.scroll();
		rttc038.Save();
		rttc038.success();
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		//step 1 1. Click on Catelog icon
		rttc038.enterCatalog();
		
		//step 2. Click on Categories link
		rttc038.clickCategory();
		Thread.sleep(2000);
		
		//scroll down
		rttc039.scrollDown();
		
		//step 3. Click on Edit icon of the category to modify
		rttc039.editCat();
		
		//step 4 Clear the values present in Meta tag Title textbox and enter new value
		rttc039.editMeta_Title("ornament");
		
		//step 5 Enter Valid credentials in Meta tag Description textbox of General tab
		rttc039.editmeta_Desc("oranament");
		
		//scroll up
		rttc038.scroll();
		
		//step 6  Keep Data and Design tab fields with default values
		rttc038.Data_tab();
		rttc038.Design_tab();
		
		//step 7  Click on Save icon
		rttc038.Save();
		
		String msz="Success: ";
		System.out.println(rttc039.success());
		Assert.assertTrue(rttc039.success().contains(msz));
		rttc038.success();
		
		screenShot.captureScreenShot("Edit Category");
	}
}
