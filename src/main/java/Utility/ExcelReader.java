package Utility;
/*Naveen - datareader  hybrid framework
Description- will store all the data in excel in array object and then particular 
test case will run for all the data present in array object  */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;

import pageLibrary.Base;

public class ExcelReader extends Base {
	
	public static String TESTDATA_SHEET_PATH = System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Testdata.xlsx";

	static Workbook book;
	static Sheet sheet;
	static int rows;
	static int columns;

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
	
	public static Object[][] getTestData(String sheetName, String TC) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		rows = sheet.getLastRowNum();
		columns = sheet.getRow(0).getLastCellNum();
		int index = -1;
		for(int i=0;i<rows;i++)
		{
			String xltstcase = sheet.getRow(i).getCell(0).toString();
			System.out.println("xltstcase :"+xltstcase);
			if(xltstcase.equalsIgnoreCase(TC))
			{
				index = i;
				break;
			}
		}
		Object[][] data = new Object[1][columns-1];
		for (int i = 0; i < 1; i++) {
			for (int k = 0; k <columns-1; k++) {
				data[i][k] = sheet.getRow(index).getCell(k+1).toString();
				System.out.println("i "+i+" k "+k);
				System.out.println(data[i][k]);
			}
		}
		return data;
	}

/*	public static void main(String args[])
	{
		System.out.println("Execution started");
		
		Object[][] a = ExcelReader.getTestData("CreateAccount", "data2");
		
		for(int i=0;i<1;i++)
		{
			for(int j=1;j<a[i].length;j++)
			{	
				System.out.println(a[i][j]);
			}
		}
	}*/


}


