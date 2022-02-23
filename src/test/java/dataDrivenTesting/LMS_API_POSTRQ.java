package dataDrivenTesting;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.response.Response.*;
import static org.hamcrest.Matchers.hasItems;

public class LMS_API_POSTRQ extends API_TestDataProvider{

	@Test(dataProvider="LMSPostDataProvider",priority=1)
	@Description("Verify the records are created using POST method for LMS API")
	@Severity(SeverityLevel.BLOCKER)
	public void LMS_API_TC03_POSTRQ(String pId,String pName,String pDesc,String bool) {
			JSONObject request=new JSONObject();
		
	       request.put("programId",pId);
	       request.put("programName",pName);
	       request.put("programDescription",pDesc);
	       request.put("online",bool);
	       
	Response response=given().auth().basic("admin","password").
			body(request.toJSONString())
			.contentType("application/json")
			.when().post("https://lms-admin-rest-service.herokuapp.com/programs");

			
	   //status Code Validation 
	
	  int statusCode=response.getStatusCode();
	   Assert.assertEquals(statusCode,200);
	   
	   //Validating Response Body
	   
	  String responseBody=response.getBody().asString();
	   System.out.println(responseBody);
	   Assert.assertEquals(responseBody.contains(pId),true);
	   Assert.assertEquals(responseBody.contains(pName),true);
	   Assert.assertEquals(responseBody.contains(pDesc),true);
	   Assert.assertEquals(responseBody.contains(bool),true);  
	   
		      
	}
	@Test(dataProvider="LMSPostDataProvider",priority=2)
	
	public void LMS_API_TC04_POSTRQ_missingParams(String pId,String pName,String pDesc,String bool) {
		
		//Creating HashMap to create a record using post
		
		//Map<String,Object> map=new HashMap<String,Object>();
		JSONObject request=new JSONObject();
		
	   //   request.put("programId",pId);
	     //  request.put("programName",pName);
	       request.put("programDescription",pDesc);
	      // request.put("online",bool);
	       
	   Response response= given().auth().basic("admin","password").
			body(request.toJSONString())
			.contentType("application/json")
			.when().post("https://lms-admin-rest-service.herokuapp.com/programs");
	 
	   //Validating Response Body		
				
	        int statusCode=response.getStatusCode();
	        Assert.assertEquals(statusCode, 500);
	        
	        String responseBody=response.getBody().asString();
	        Assert.assertEquals(responseBody.contains("Internal Server Error"),true);
		

      
       
	}	
}
