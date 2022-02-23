package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hslf.usermodel.HSLFSheet;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class API_TestDataProvider {
		
	//Data for posting records in Jobs API
	
	@DataProvider(name="JobsPostDataProvider")
	String [][] getTestData() throws IOException
	{
		// read data from excel 
		//String userdir=System.getProperty("user.dir");
		String excelPath="./Data/TestData.xls";
		
	int rowNum=XLUtils.getRowCount(excelPath,"JobsDataSet1");  // to get row count
	int colCount=XLUtils.getCellCount(excelPath,"JobsDataSet1", 1); // to get  no of columns in row 1.

	String testData[][]=new String[rowNum][colCount];

	for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
	{
		for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
		{
			testData[i-1][j]=XLUtils.getCellData(excelPath,"JobsDataSet1", i, j);
		}
	}
			return(testData);
	}

	

//Data for updating a  record in Jobs API
	
@DataProvider(name="PutDataProvider")
String [][] getTestData3() throws IOException
{
	// read data from excel 
	//String userdir=System.getProperty("user.dir");
	String excelPath="./Data/TestData.xls";
	
int rowNum=XLUtils.getRowCount(excelPath,"DataSet3");  // to get row count
int colCount=XLUtils.getCellCount(excelPath,"DataSet3", 1); // to get  no of columns in row 1.

String testData[][]=new String[rowNum][colCount];

for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
{
	for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
	{
		testData[i-1][j]=XLUtils.getCellData(excelPath,"DataSet3", i, j);
	}
}
		return(testData);
}


//Data for posting records in LMS API

	@DataProvider(name="LMSPostDataProvider")
	String [][] getTestData5() throws IOException
	{
		// read data from excel 
		//String userdir=System.getProperty("user.dir");
		String excelPath="./Data/TestData.xls";
		
	int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet7");  // to get row count
	int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet7", 1); // to get  no of columns in row 1.

	String testData[][]=new String[rowNum][colCount];

	for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
	{
		for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
		{
			testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet7", i, j);
		}
	}
			return(testData);
	}

	
	//Data for updating a  record in LMS API

		@DataProvider(name="LMSPutDataProvider")
		
		String [][] getTestData6() throws IOException
		{
			// read data from excel 
			//String userdir=System.getProperty("user.dir");
			String excelPath="./Data/TestData.xls";
			
		int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet8");  // to get row count
		int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet8", 1); // to get  no of columns in row 1.

		String testData[][]=new String[rowNum][colCount];

		for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
		{
			for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
			{
				testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet8", i, j);
			}
		}
				return(testData);
		}
		//Data for deleting  a  record in Jobs API

		@DataProvider(name="LMSDeleteDataProvider")

		String [][] getTestData7() throws IOException
		{
			// read data from excel 
			//String userdir=System.getProperty("user.dir");
			String excelPath="./Data/TestData.xls";
			
		int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet9");  // to get row count
		int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet9", 1); // to get  no of columns in row 1.

		String testData[][]=new String[rowNum][colCount];

		for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
		{
			for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
			{
				testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet9", i, j);
			}
		}
				return(testData);
		}

		
		
		
                              ///////Negative Scenarios 
		
		
		
		//Data for posting same records in Jobs API
		
		@DataProvider(name="JobsPost_sameRecord_DataProvider")
		String [][] getTestData10() throws IOException
		{
			// read data from excel 
			//String userdir=System.getProperty("user.dir");
			String excelPath="./Data/TestData.xls";
			
		int rowNum=XLUtils.getRowCount(excelPath,"JobsDataSet7");  // to get row count
		int colCount=XLUtils.getCellCount(excelPath,"JobsDataSet7", 1); // to get  no of columns in row 1.

		String testData[][]=new String[rowNum][colCount];

		for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
		{
			for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
			{
				testData[i-1][j]=XLUtils.getCellData(excelPath,"JobsDataSet7", i, j);
			}
		}
				return(testData);
		}

	
				//Data for updating a  record in Jobs API
				
				@DataProvider(name="PutDataProvider_sameId")
				
				String [][] getTestData12() throws IOException
				{
					// read data from excel 
					//String userdir=System.getProperty("user.dir");
					String excelPath="./Data/TestData.xls";
					
				int rowNum=XLUtils.getRowCount(excelPath,"JobsDataSet6");  // to get row count
				int colCount=XLUtils.getCellCount(excelPath,"JobsDataSet6", 1); // to get  no of columns in row 1.

				String testData[][]=new String[rowNum][colCount];

				for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
				{
					for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
					{
						testData[i-1][j]=XLUtils.getCellData(excelPath,"JobsDataSet6", i, j);
					}
				}
						return(testData);
				}
				

				//Data for posting records in LMS API

					@DataProvider(name="LMSPostDataProvider_sameId")
					
					String [][] getTestData14() throws IOException
					{
						// read data from excel 
						//String userdir=System.getProperty("user.dir");
						String excelPath="./Data/TestData.xls";
						
					int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet16");  // to get row count
					int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet16", 1); // to get  no of columns in row 1.

					String testData[][]=new String[rowNum][colCount];

					for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
					{
						for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
						{
							testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet16", i, j);
						}
					}
							return(testData);
					}

					
					//Data for updating record in LMS API

						@DataProvider(name="LMSPutDataProvider_sameId")
						
						String [][] getTestData15() throws IOException
						{
							// read data from excel 
							//String userdir=System.getProperty("user.dir");
							String excelPath="./Data/TestData.xls";
							
						int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet8");  // to get row count
						int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet8", 1); // to get  no of columns in row 1.

						String testData[][]=new String[rowNum][colCount];

						for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
						{
							for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
							{
								testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet8", i, j);
							}
						}
								return(testData);
						}
						//Data for deleting  a  record in Jobs API

						@DataProvider(name="LMSDeleteDataProvider_newId")

						String [][] getTestData16() throws IOException
						{
							// read data from excel 
							//String userdir=System.getProperty("user.dir");
							String excelPath="./Data/TestData.xls";
							
						int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet19");  // to get row count
						int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet19", 1); // to get  no of columns in row 1.

						String testData[][]=new String[rowNum][colCount];

						for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
						{
							for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
							{
								testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet19", i, j);
							}
						}
								return(testData);
						}
						
						//Data for updating a  non existing record in LMS API

						@DataProvider(name="LMSPutDataProvider_newid")
						
						String [][] getTestData17() throws IOException
						{
							// read data from excel 
							//String userdir=System.getProperty("user.dir");
							String excelPath="./Data/TestData.xls";
							
						int rowNum=XLUtils.getRowCount(excelPath,"LMSDataSet18");  // to get row count
						int colCount=XLUtils.getCellCount(excelPath,"LMSDataSet18", 1); // to get  no of columns in row 1.

						String testData[][]=new String[rowNum][colCount];

						for(int i=1; i<=rowNum;i++) // starting from row [1] as row[0] is header in excelsheet
						{
							for(int j=0;j<colCount;j++)//starting from column [0] as column[0] is jobId in excelsheet
							{
								testData[i-1][j]=XLUtils.getCellData(excelPath,"LMSDataSet18", i, j);
							}
						}
								return(testData);
						}
}

