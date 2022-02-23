package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Api_Config_Reader {
	
 public static Properties readPropertiesFile() throws IOException  {

	 Properties prop=new Properties();
	 FileInputStream input=new FileInputStream("C:\\Users\\sofij\\eclipse-workspace\\API_Automation_RestAssured\\src\\test\\java\\utils\\Api_Config");
	
		prop.load(input);
		 return prop;
		 
 }
	

public static String  getURI() throws IOException
 {
	 return readPropertiesFile().getProperty("URI");
 }
public static String  getinvalidURI() throws IOException
{
	 return readPropertiesFile().getProperty("invalidURI");
}
public static String  getJobid_Delete() throws IOException
{
	 return readPropertiesFile().getProperty("Jobid_Delete");
}
public static String  getJobid_delete_newId() throws IOException
{
	 return readPropertiesFile().getProperty("Jobid_delete_newId");
}
public static String  getJobid_put() throws IOException
{
	 return readPropertiesFile().getProperty("Jobid_Put");
}
public static String  getJobTitle_put() throws IOException
{
	 return readPropertiesFile().getProperty("JobTitle_Put");
}
public static String  getLMS_URI() throws IOException
{
	 return readPropertiesFile().getProperty("LMS_URI");
}
public static String  getLMS_invalidID() throws IOException
{
	 return readPropertiesFile().getProperty("LMS_prgId");
}
}
