package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class TestUtil {

	public static long pageLoadTimeout = 30;
	public static long implicitWaitTimeout = 30;
	public static String sheetPath="C:\\SeleniumTraining\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\FreeCRMTestdata.xlsx";
	public static Workbook book;
	public static Sheet sheet;


	public static Object[][] getTestData(String sheetname) throws InvalidFormatException, IOException {

		FileInputStream file = null;

		file = new FileInputStream(sheetPath);
		book = WorkbookFactory.create(file);
		sheet = book.getSheet("contacts");

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for (int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
		}

		return data;
	}








}
