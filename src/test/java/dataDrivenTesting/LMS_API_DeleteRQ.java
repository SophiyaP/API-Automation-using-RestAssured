  package dataDrivenTesting;
	import static io.restassured.RestAssured.*;
	import java.io.IOException;
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
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


	public class LMS_API_DeleteRQ extends API_TestDataProvider {
		
		@Test(dataProvider="LMSDeleteDataProvider",priority=1)
		 @Description("Verify the records are deleted for LMS API ")
		@Severity(SeverityLevel.NORMAL)
		public void LMS_API_TC07_DeleteRQ(String URI,String pId)

		{
			 
				RestAssured.baseURI=URI;
				JSONObject request=new JSONObject();
				request.put("ProgramId",pId);
		Response response=given().auth().basic("admin","password").
				when().delete(pId);
			
		// Validate status Code
					int statusCode = response.getStatusCode();
					Assert.assertEquals(statusCode, 200);
					
					String jsonString =response.getBody().asString();
					System.out.println(jsonString);
			Assert.assertEquals(jsonString.contains("pId"), false);

			
		}

	@Test(dataProvider="LMSDeleteDataProvider_newId",priority=2)
		
		public void LMS_API_TC08_DeleteRQ_newId(String URI,String pId)

		{
			 
				RestAssured.baseURI=URI;
				JSONObject request=new JSONObject();
				request.put("ProgramId",pId);
	Response response= given().auth().basic("admin","password").
				when().delete(pId);
				// Validate status Code
				int statusCode = response.getStatusCode();
				Assert.assertEquals(statusCode, 500);
 // validate response body 
				String responseBody = response.getBody().asString();
				System.out.println(responseBody);  
				Assert.assertEquals(responseBody.contains("Internal Server Error"), true);
		
		}
	}


