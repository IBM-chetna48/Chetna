package com.training.dataproviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import com.training.bean.AddCategoriesBean2;
import com.training.bean.LoginBean;
import com.training.dao.ELearningDAO;
import com.training.dao.RetailDAO2;
import com.training.readexcel.ApachePOIExcelRead;
import com.training.readexcel.ReadExcel;

public class LoginDataProviders {

	@DataProvider(name = "db-inputs")
	public Object [][] getDBData() {
/*
		List<LoginBean> list = new ELearningDAO().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(LoginBean temp : list){
			Object[]  obj = new Object[2]; 
			obj[0] = temp.getUserName(); 
			obj[1] = temp.getPassword(); 
		*/
		List<AddCategoriesBean2> list = new RetailDAO2().getLogins(); 
		
		Object[][] result = new Object[list.size()][]; 
		int count = 0; 
		for(AddCategoriesBean2 temp : list){
			Object[]  obj = new Object[4]; 
			obj[0] = temp.getcatName(); 
			obj[1] = temp.getcatDesc();
			obj[2] = temp.getcatMetaTitle();
			obj[3] = temp.getcatMetaDesc();
		
			result[count ++] = obj; 
		}
		
		
		return result;
	}
	
	@DataProvider(name = "excel-inputs")
	public Object[][] getExcelData(){
		String fileName ="C:/IBM_SeleniumWD/RTTD_006.xlsx";
		String sheetName = "Sheet1";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs1")
	public Object[][] getExcelData1(){
		String fileName ="C:/IBM_SeleniumWD/RTTD_006.xlsx"; 
		String sheetName = "Sheet2";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "excel-inputs2")
	public Object[][] getExcelData2(){
		String fileName ="C:/IBM_SeleniumWD/RTTD_006.xlsx"; 
		String sheetName = "Sheet3";
		return new ApachePOIExcelRead().getExcelContent(fileName,sheetName); 
	}
	
	@DataProvider(name = "xls-inputs")
	public Object[][] getXLSData(){
		// ensure you will have the title as first line in the file 
		return new ReadExcel().getExcelData("C:/Users/Naveen/Desktop/Testing.xls", "Sheet1"); 
	}
}
