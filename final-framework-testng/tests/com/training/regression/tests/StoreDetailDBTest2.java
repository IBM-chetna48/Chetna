/*
 * To verify whether application stores category details in database
 */
package com.training.regression.tests;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dataproviders.LoginDataProviders;
import com.training.generics.GenericMethods;
import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.AddCategoryDB_066POM;
import com.training.pom.AddCategoryRTTC_038POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class StoreDetailDBTest2 {
	private WebDriver driver;
	private String baseUrl;
	private String adminUrl;
	private LoginPOM loginPOM;
	private AddCategoryDB_066POM db_066;
	private AddCategoryRTTC_038POM rttc038;
	private static Properties properties;
	private ScreenShot screenShot;
	private GenericMethods genericMethods; 
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws IOException {
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
	}

	@BeforeMethod
	public void setUp() throws Exception {
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		loginPOM = new LoginPOM(driver);
		db_066 = new AddCategoryDB_066POM(driver);
		rttc038 = new AddCategoryRTTC_038POM(driver);
		//baseUrl = properties.getProperty("baseURL");
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		genericMethods = new GenericMethods(driver); 
		// open the browser
		driver.get(adminUrl);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}


	@Test(dataProvider = "db-inputs", dataProviderClass = LoginDataProviders.class)
	public void loginDBTest(String catName, String catdesc, String catmetatitle, String catmetadesc) throws AWTException, InterruptedException {
		// for demonstration 
//		genericMethods.getElement("login", "id"); 
		
		//steps for login
		loginPOM.sendUserName("admin");	
		loginPOM.sendPassword("admin@123");
		loginPOM.clickLoginBtn();
		
		//STEP 1 Click on Catelog icon
		rttc038.enterCatalog(); 
		
		//STEP 2 Click on Categories link
		rttc038.clickCategory(); 
		
		//STEP 3 Click on Add new icon
		rttc038.addCategory(); 
		
		//STEP 4 Enter Valid credentials in Category Name textbox of General tab
		String categoryName = db_066.enterCat_Name("ORNAMENTS"); 
		
		 //STEP 5 Enter Valid credentials in Description textbox of General tab
		String catDesc= db_066.enterCat_Desc("ornaments for ladies");
		
		//STEP 6 Enter Valid credentials in Meta tag Title textbox of General tab
		String categoryMetaTitle = db_066.enterMeta_Title("ORNAMENTS"); 
		
		//STEP 7 Enter Valid credentials in Meta tag Description textbox of General tab
		String categoryMetaDesc = db_066.entercat_metaDesc("ornaments for ladies"); 
		rttc038.scroll();
		
		//STEP 8 Keep Data and Design tab fields with default values
		rttc038.Data_tab();
		rttc038.Design_tab();
		
		//STEP 9 Click on Save icon
		rttc038.Save();
		//Compare entered values with that present in dataBase
		assertEquals(catName,categoryName);
		assertEquals(catdesc,catDesc);
		assertEquals(catmetatitle,categoryMetaTitle);
		assertEquals(catmetadesc,categoryMetaDesc);
		
		screenShot.captureScreenShot("db_066");

	}

}