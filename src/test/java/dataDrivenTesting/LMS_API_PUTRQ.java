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

import static io.restassured.response.Response.*;

	public class LMS_API_PUTRQ  extends API_TestDataProvider{

		@Test(dataProvider="LMSPutDataProvider",priority=1)
		@Description("Verify all records are fetched using GET method ")
		@Severity(SeverityLevel.CRITICAL)
		public void LMS_API_TC05_PUTRQ (String pId,String pName,String pDesc,String bool) {
			
			//Creating HashMap to create a record using post
			
			//Map<String,Object> map=new HashMap<String,Object>();
			JSONObject request=new JSONObject();
			
		       request.put("programId",pId);
		       request.put("programName",pName);
		       request.put("programDescription",pDesc);
		       request.put("online",bool);
		      // System.out.println(request);
		       System.out.println(request.toJSONString());
		       
		Response response= given().auth().basic("admin","password").
				body(request.toJSONString())
				.contentType("application/json")
				.when().put("https://lms-admin-rest-service.herokuapp.com/programs/"+pId);
		
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
		 @Test(dataProvider="LMSPutDataProvider_newid",priority=2)
		
		public void LMS_API_TC06_PUTRQ_newId(String pId,String pName,String pDesc,String bool) {
			
			//Creating HashMap to create a record using post
			
			//Map<String,Object> map=new HashMap<String,Object>();
			JSONObject request=new JSONObject();
			
		       request.put("programId",pId);
		       request.put("programName",pName);
		       request.put("programDescription",pDesc);
		       request.put("online",bool);
		       
		      // System.out.println(request);
		       System.out.println(request.toJSONString());
		    Response response=given().auth().basic("admin","password").
				body(request.toJSONString())
				.contentType("application/json")
				.when().put("https://lms-admin-rest-service.herokuapp.com/programs/"+pId);
	

			 	   //status Code Validation 
			 	
			 	  int statusCode=response.getStatusCode();
			 	   Assert.assertEquals(statusCode,400);
					 	   
			 	//Validating Response Body
			 	   
				 	  String responseBody=response.getBody().asString();
				 	   System.out.println(responseBody);
				 	   Assert.assertEquals(responseBody.contains("Bad Request"),true);
	      
	       
		}	
	}


