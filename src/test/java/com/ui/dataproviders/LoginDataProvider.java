package com.ui.dataproviders;

import java.util.Iterator;

import org.testng.annotations.DataProvider;

import com.ui.pojo.User;
import com.utility.ExcelReaderUtility;

public class LoginDataProvider {
	
	@DataProvider(name = "LoginTestExcelDataProvider")
	public static Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtility.readExcelFile("testData/LoginData.xlsx", "LoginTestData");
	}

}
