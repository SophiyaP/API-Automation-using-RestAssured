package utils;

import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	
	public ExcelUtils(String excelPath,String sheetName) { // constructor for the class ExcelUtils,constructor is called when an object is created with new keyword
	try
	{
		
	 workbook=new XSSFWorkbook(excelPath); //to access excel
	 sheet=workbook.getSheet(sheetName); //To access the excel sheet	
		} catch (Exception exp) {
System.out.println(exp.getMessage());
System.out.println(exp.getCause());
		exp.printStackTrace();
	}
}
		public static void getCellData(int rowNum,int colNum)
	{		
		DataFormatter formatter=new DataFormatter(); //Formats the cell value.
		Object value =formatter.formatCellValue(sheet.getRow(rowNum).getCell(colNum)); //we use return type as object,
		//so it can have int,double,string as cell values
		//The above LOC gets the cell value
		System.out.println(value);
	}			
		
	
	public static void getRowCount()
	{
		
		int rowCount=sheet.getPhysicalNumberOfRows(); //To access the active no.of rows in the sheets
		System.out.println("No fo active rows :" +rowCount);

		}
	}

