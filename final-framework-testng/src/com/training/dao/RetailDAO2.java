package com.training.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.training.bean.AddCategoriesBean2;
import com.training.bean.LoginBean;
import com.training.connection.GetConnection;
import com.training.utility.LoadDBDetails;

// Data Access Object 
public class RetailDAO2 {
	
	Properties properties; 
	
	public RetailDAO2() {
		 try {
			properties = new Properties();
			FileInputStream inStream = new FileInputStream("./resources/sql.properties");
			properties.load(inStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<AddCategoriesBean2> getLogins(){
	//	String sql = properties.getProperty("get.logins"); 
		String sql = properties.getProperty("get.categories");
		GetConnection gc  = new GetConnection(); 
		List<AddCategoriesBean2> list = null;
		try {
			gc.ps1 = GetConnection.getMySqlConnection(LoadDBDetails.getDBDetails()).prepareStatement(sql); 
			list = new ArrayList<AddCategoriesBean2>(); 
			
			gc.rs1 = gc.ps1.executeQuery(); 
			
			while(gc.rs1.next()) {
			
				AddCategoriesBean2 temp = new AddCategoriesBean2(); 
				temp.setcatName(gc.rs1.getString(1));
				temp.setcatDesc(gc.rs1.getString(2));
				temp.setcatMetaTitle(gc.rs1.getString(3));
				temp.setcatMetaDesc(gc.rs1.getString(4));

				list.add(temp); 
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list; 
	}
	
	public static void main(String[] args) {
		new RetailDAO2().getLogins().forEach(System.out :: println);
	}
	
	
}
