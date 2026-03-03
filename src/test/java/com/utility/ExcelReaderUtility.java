package com.utility;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {

	public static Iterator<User> readExcelFile(String fileName, String sheetName) {

		InputStream inputStream = Thread.currentThread().getContextClassLoader()
				.getResourceAsStream(fileName);

		XSSFWorkbook xssfWorkbook = null;
		XSSFSheet xssfSheet = null;
		Iterator<Row> rowIterator = null;
		Cell emailAddressCell = null;
		Cell passwordAddressCell = null;
		Row row = null;
		List<User> userList = new ArrayList<>();

		try {
			xssfWorkbook = new XSSFWorkbook(inputStream);
			xssfSheet = xssfWorkbook.getSheet(sheetName);
			rowIterator = xssfSheet.iterator();

			rowIterator.next(); // skip column name

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordAddressCell = row.getCell(1);
				User user = new User(emailAddressCell.toString(), passwordAddressCell.toString());
				userList.add(user);
			}

			xssfWorkbook.close();

		} catch (IOException e) {

			e.printStackTrace();
		}

		return userList.iterator();

	}

}
