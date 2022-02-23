package utils;

public class DataDrivenTest {

public static void main(String[] args) {
	
String excelPath="./Data/TestData.xlsx";
String sheetName="DataSet1";

ExcelUtils excel=new ExcelUtils(excelPath,sheetName);
//excel.getRowCount();
excel.getCellData(1,0);
excel.getCellData(2,0);
excel.getCellData(3,0);
excel.getCellData(4,0);
excel.getCellData(5,0);
excel.getCellData(6,0);
excel.getCellData(7,0);
excel.getCellData(1,1);
excel.getCellData(2,1);
excel.getCellData(3,1);
excel.getCellData(4,1);
excel.getCellData(5,1);
excel.getCellData(6,1);
excel.getCellData(7,1);

	}

}
