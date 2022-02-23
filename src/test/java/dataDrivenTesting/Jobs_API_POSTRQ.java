package dataDrivenTesting;

import static io.restassured.RestAssured.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;


public class Jobs_API_POSTRQ extends API_TestDataProvider {
	
	@Test(dataProvider="JobsPostDataProvider",priority=1)
	@Description("Verify the records are created using POST method for Jobs API")
	@Severity(SeverityLevel.BLOCKER)
	public void Jobs_API_TC03_POSTRQ(String jid,String jTitle,String jCompanyName,String jLoc,String jType,String jPT,String jDesc)

	{

		baseURI="https://jobs123.herokuapp.com";
	//	JSONObject request=new JSONObject();
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("Job Id",jid);
		map.put("Job Title", jTitle);
		map.put("Job Company Name", jCompanyName);
		map.put("Job Location", jLoc);
		map.put("Job Type",jType);
		map.put("Job Posted time",jPT);
		map.put("Job Description",jDesc);
	Response response=given().queryParams(map).	
		when().post("/Jobs");

	//status Code Validation 
	
	  int statusCode=response.getStatusCode();
	   Assert.assertEquals(statusCode,200);
	   
	   //Validating Response Body
	   
	  String responseBody=response.getBody().asString();
	   System.out.println(responseBody);
	   Assert.assertEquals(responseBody.contains(jid),true);
	   Assert.assertEquals(responseBody.contains(jTitle),true);
	   Assert.assertEquals(responseBody.contains(jCompanyName),true);
	   Assert.assertEquals(responseBody.contains(jLoc),true);
	   Assert.assertEquals(responseBody.contains(jType),true);
	   Assert.assertEquals(responseBody.contains(jPT),true);
	   Assert.assertEquals(responseBody.contains(jDesc),true);
	  
	}
	@Test(dataProvider="JobsPost_sameRecord_DataProvider",priority=2)
	public void Jobs_API_TC04_POSTRQ_sameData(String jid,String jTitle,String jCompanyName,String jLoc,String jType,String jPT,String jDesc)

	{

		baseURI="https://jobs123.herokuapp.com";
	//	JSONObject request=new JSONObject();
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("Job Id",jid);
		map.put("Job Title", jTitle);
		map.put("Job Company Name", jCompanyName);
		map.put("Job Location", jLoc);
		map.put("Job Type",jType);
		map.put("Job Posted time",jPT);
		map.put("Job Description",jDesc);
	Response response=given().queryParams(map).	
		when().post("/Jobs");
			
	//status Code Validation 
		
		  int statusCode=response.getStatusCode();
		   Assert.assertEquals(statusCode,409);
		   
		   //Validating Response Body
		   
		  String responseBody=response.getBody().asString();
		   System.out.println(responseBody);
		  Assert.assertEquals(responseBody.contains("'"+jid +"' already exists"),true);
	}




}


