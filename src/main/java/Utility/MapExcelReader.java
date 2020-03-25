package Utility;
/*youtube - https://www.youtube.com/watch?v=3y1sfsRbQqQ 
Raju pandey - Read data from excel convert to Hasmap for selenium testing
This is applicable for sheet having 2 column out of which one will be key other will be value.
please note that in map duplicate keys are not allowed*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MapExcelReader {
	
	private static FileInputStream fis;
	private static XSSFWorkbook workbook;
	private static XSSFSheet sheet;
	
	public static void loadexcel(String sheetname) throws IOException
	{
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Testdata.xlsx");
			
		} catch (FileNotFoundException e) {
			System.out.println("File might be missing");
			e.printStackTrace();
		}
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet(sheetname);
		fis.close();		
	}
	
	public static Map<String,Map<String,String>> getdatamap(String sheetname) throws IOException
	{
		if(sheet == null)
		{
			loadexcel(sheetname);
		}
		
		Map<String,Map<String,String>> supermap = new HashMap<String,Map<String,String>>();
		Map<String,String> mymap = new HashMap<String, String>();
		
		int rows = sheet.getLastRowNum()+1;
		int columns = sheet.getRow(0).getLastCellNum();
		
		System.out.println("total rows : "+ rows+" total columns : "+columns);
		
		for(int i=1 ; i<rows ; i++)
		{
			String mykey =sheet.getRow(i).getCell(0).toString();
			for(int j=1;j<columns;j++)
			{	
				String myvalue = sheet.getRow(i).getCell(j).toString();
				mymap.put(mykey, myvalue);
			}
			//System.out.println("mymap  :  "+mymap);
			supermap.put(sheetname, mymap);
		}
			
		return supermap;
	
	}
	
	public static String getvalue(String sheetname,String value) throws IOException
	{
		Map<String, String> getmap = getdatamap(sheetname).get(sheetname);
		String myval = getmap.get(value);
		return myval;
	}
	
	public static void main(String args[]) throws IOException
	{
		System.out.println("Loding excel . . .");
			String v1 = getvalue("keyvaluecheck","name");
			String v2 = getvalue("keyvaluecheck","password");
			System.out.println("name : "+v1+" password : "+v2);
			System.out.println("Execution completed");
	}

}
