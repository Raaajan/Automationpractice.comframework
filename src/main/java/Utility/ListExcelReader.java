package Utility;
/*youtube - https://www.youtube.com/watch?v=rJ3-94VjWMg&t=383s
Raju pandey - Read data from excel convert to Hasmap for selenium testing
This is for sheet having multiple columns*/
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ListExcelReader {
	
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

	public static List<Map<String,String>> getdata(String sheetname) throws IOException
	{
		if(sheet == null)
		{
			loadexcel(sheetname);
		}
		
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		
		int rows = sheet.getLastRowNum()+1;
		int columns = sheet.getRow(0).getLastCellNum();
		
		for(int j=1;j<columns;j++)
		{
			Map<String,String> mymap = new HashMap<String,String>();
			for(int i=1;i<rows;i++)
			{
				String key = sheet.getRow(i).getCell(0).toString();
				String value = sheet.getRow(i).getCell(j).toString();
				mymap.put(key, value);
				
			}
			System.out.println("mymap : "+mymap);
			list.add(mymap);
			System.out.println("List : "+list);
		}
		return list;
	}
	
	
	public static  List<String> getvalue(String sheetname,String xlkey) throws IOException
	{
		List<Map<String,String>> newlist = getdata(sheetname);
		List<String> datalist = new ArrayList<String>();
		for (Map<String,String> newmap :newlist)
		{
		String val =newmap.get(xlkey);
		datalist.add(val);
		}
		return datalist;
	}

	public static void main(String args[]) throws IOException
	{
		System.out.println("Execution Starts. . . ");
		List<String> fn = getvalue("Testing","firstname");
		System.out.println("final list : "+fn);
		System.out.println(fn.get(0));
	}
}
