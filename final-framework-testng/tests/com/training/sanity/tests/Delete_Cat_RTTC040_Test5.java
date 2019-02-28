/* To verify whether application allows the user to remove added product 
 * details from cart
 */
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
import com.training.pom.DeleteCat_RTTC_040;
//import com.training.pom.LoginPOM; //old
import com.training.pom.LoginAdminRTTC_037POM;
import com.training.pom.AddCategoryRTTC_038POM;
import com.training.pom.EditCategoryRTTC_039POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class Delete_Cat_RTTC040_Test5 {
	
	private WebDriver driver;
	private String adminUrl;
	private LoginAdminRTTC_037POM rttc037;
	private AddCategoryRTTC_038POM rttc038;
	private EditCategoryRTTC_039POM rttc039;
	private DeleteCat_RTTC_040 rttc040;
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
		rttc040 = new DeleteCat_RTTC_040(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(adminUrl);
		//enter username 
		rttc037.enterUsername("admin");
		//enter password
		rttc037.enterPassword("admin@123");
		//click login
		rttc037.submit();
		
		//Click on Catalog icon
		rttc038.enterCatalog();
		
		//Click on Categories link
		rttc038.clickCategory();
		
		//click on add button to create new category
		rttc038.addCategory();
		
		//enter new category name 
		rttc038.enterCat_Name("ORNAMENTS");
		
		//enter description for new category
		rttc038.enterCat_Desc("ornaments for ladies");
		
		//enter meta-title for new category
		rttc038.enterMeta_Title("ORNAMENTS");
		
		//enter meta-desciption for new category
		rttc038.entercat_metaDesc("ornaments for ladies");
		
		//enter meta key for new category
		rttc038.entercat_metakey("ornaments");
		
		//scroll up to save the newly created category
		rttc038.scroll();
		
		//click save
		rttc038.Save();
		
		//get success message
		rttc038.success();
		
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}
	
	@Test
	public void validLoginTest() throws InterruptedException, AWTException {
		//step 1 Click on Catelog icon
		rttc038.enterCatalog();
		
		//step 2 Click on Categories link
		rttc038.clickCategory();
		
		Thread.sleep(2000);
		//scroll down
		rttc039.scrollDown();
		
		//step 3 Click on Checkbox of the category to be deleted
		rttc040.checkCat();
		
		//scroll up
		rttc038.scroll();
		
		//step 4 Click on Delete icon
		rttc040.deleteCat();
		Thread.sleep(2000);
		
		//step 5 click on Ok button of pop up window
		rttc040.alert();
		
		//step 6 Category deleted successfully message displayed on the screen
		String msz="Success: ";
		System.out.println(rttc040.getMszBox());
		Assert.assertTrue(rttc040.getMszBox().contains(msz));
		screenShot.captureScreenShot("RTTC040_Delete Category");
		
	}
}
