package com.training.bean;

public class AddCategoriesBean2 {
	private String catName;
	private String catDesc;
	private String catMetaTitle;
	private String catMetaDesc;

	public AddCategoriesBean2() {
	}

	public AddCategoriesBean2(String catName, String catDesc, String catMetaTitle, String catMetaDesc) {
		super();
		this.catName = catName;
		this.catDesc = catDesc;
		this.catMetaTitle = catMetaTitle;
		this.catMetaDesc = catMetaDesc;
	}

	public String getcatName() {
		return catName;
	}

	public void setcatName(String catName) {
		this.catName = catName;
	}

	public String getcatDesc() {
		return catDesc;
	}

	public void setcatDesc(String catDesc) {
		this.catDesc = catDesc;
	}
	
	public String getcatMetaTitle() {
		return catMetaTitle;
	}

	public void setcatMetaTitle(String catMetaTitle) {
		this.catMetaTitle = catMetaTitle;
	}
	
	public String getcatMetaDesc() {
		return catMetaDesc;
	}

	public void setcatMetaDesc(String catMetaDesc) {
		this.catMetaDesc = catMetaDesc;
	}

	@Override
	public String toString() {
		return "AddCategoriesBean2 [catName=" + catName + ", catDesc=" + catDesc + " catMetaTitle=" + catMetaTitle + ", catMetaDesc=" + catMetaDesc + "]";
	}

}
