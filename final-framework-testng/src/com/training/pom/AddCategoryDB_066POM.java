/*
 * Category Add Page 
 */
package com.training.pom;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AddCategoryDB_066POM {
	private WebDriver driver;

	public AddCategoryDB_066POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name = "category_description[1][name]")
	private WebElement cat_name;
	
	@FindBy(xpath = "//div[@class='note-editable panel-body']")
	private WebElement cat_desc;

	@FindBy(id = "input-meta-title1")
	private WebElement cat_metatitle;
	
	
	@FindBy(id = "input-meta-description1")
	private WebElement cat_metaDesc;
	
	@FindBy(id = "input-meta-keyword1")
	private WebElement cat_metakey;
	
		// Enter Valid credentials in Category Name textbox of General tab
	public String enterCat_Name(String catname) {
		this.cat_name.clear();
		this.cat_name.sendKeys(catname);
		return this.cat_name.getAttribute("value");
	}
	
	//Enter Valid credentials in Description textbox of General tab
	public String enterCat_Desc(String catdesc) {
		this.cat_desc.clear();
		this.cat_desc.sendKeys(catdesc);
		return this.cat_desc.getText();
	}
	
	//Enter credentials in Meta tag Title textbox of General tab
	public String enterMeta_Title(String title) {
		this.cat_metatitle.clear();
		this.cat_metatitle.sendKeys(title);
		return this.cat_metatitle.getAttribute("value");
		
	}
	
	//Enter Valid credentials in Meta tag Description textbox of General tab
	public String entercat_metaDesc(String metadesc) {
		this.cat_metaDesc.clear();
		this.cat_metaDesc.sendKeys(metadesc);
		return this.cat_metaDesc.getAttribute("value");
	}
	
	
		
}
