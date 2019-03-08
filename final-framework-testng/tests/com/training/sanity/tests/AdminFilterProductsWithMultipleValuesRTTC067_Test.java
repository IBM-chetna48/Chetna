//To verify whether application allows admin to add category in categories page
package com.training.sanity.tests;

import java.awt.AWTException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.training.dataproviders.LoginDataProviders;
import com.training.generics.ScreenShot;
//import com.training.pom.LoginPOM; //old
import com.training.pom.LoginAdminRTTC_037POM;
import com.training.pom.AddCategoryRTTC_038POM;
import com.training.pom.ProductListRTTC_067POM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

public class AdminFilterProductsWithMultipleValuesRTTC067_Test {

	private WebDriver driver;
	private String adminUrl;
	private LoginAdminRTTC_037POM rttc037;
	private ProductListRTTC_067POM rttc067;
	private AddCategoryRTTC_038POM rttc038;
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
		rttc067 = new ProductListRTTC_067POM(driver);
		adminUrl = properties.getProperty("adminURL");
		screenShot = new ScreenShot(driver);
		// open the browser
		driver.get(adminUrl);
	}

	@AfterClass
	public void tearDown() throws Exception {
		Thread.sleep(1000);
		driver.quit();
	}

	@Test(priority = 0)
	public void Login() {
		// enter username credentials
		rttc037.enterUsername("admin");

		// enter valid password
		rttc037.enterPassword("admin@123");

		// click login
		rttc037.submit();
	}

	@Test(priority = 1, dataProvider = "excel-inputs", dataProviderClass = LoginDataProviders.class)
	public void FilterProductTest(String ProductName, String ProductPrice, String Status, String Model, String Quantity,
			String Image) throws InterruptedException, AWTException {

		// step 1 Click on Catalog icon
		rttc038.enterCatalog();

		// step 2 Click on Product link
		rttc067.clickProduct();

		// step 3 Enter valid credentials in Product Name textbox
		rttc067.enterProductsName(ProductName);

		// step 4 Enter Valid credentials in Price textbox
		rttc067.enterPrice(ProductPrice);

		// step 5 Select values from Status list box
		rttc067.enterStatus(Status);

		// step 6 Enter Valid credentials in Model textbox
		rttc067.enterModel(Model);

		// step7 Enter Valid credentials in Quantity textbox
		rttc067.enterQuantity(Quantity);

		// step8 Select values from Image list box
		rttc067.enterImage(Image);

		// step9 Select values from Image list box
		rttc067.clickFilter();

		// String msz="Success: ";

		System.out.println(rttc067.getResult());
		Assert.assertEquals(false, (rttc067.getResult().isEmpty()));

		screenShot.captureScreenShot("ProductFilter");
	}
}
