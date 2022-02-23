package dataDrivenTesting;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static utils.Api_Config_Reader.getLMS_URI;
import static utils.Api_Config_Reader.getLMS_invalidID;
import static utils.Api_Config_Reader.getURI;

import java.io.IOException;




public class LMS_API_GETRQ  {

		//create a Testng Function
	@Test(priority=1)
	@Description("Verify all records are fetched using GET method for LMS API ")
	@Severity(SeverityLevel.MINOR)
	public void LMS_API_TC01_GETRQ() throws IOException 
	{
		//specify the base URI
				RestAssured.baseURI= "https://lms-admin-rest-service.herokuapp.com/programs";
				
//basic authentication
				
				PreemptiveBasicAuthScheme authscheme=new PreemptiveBasicAuthScheme();
				authscheme.setUserName("admin");
				authscheme.setPassword("password");
				
				RestAssured.authentication=authscheme;
				
				// using httprequest object to send request to server
				RequestSpecification httprequest=RestAssured.given();
				
				//Response object
				Response response=httprequest.request(Method.GET);
				
				//Print the response
				//response body will be in JSON format so converting 
				String responseBody=response.getBody().prettyPrint();
				System.out.print("Response Body is " + responseBody);

				//StatusCode Validation
				int statusCode= response.getStatusCode();
				System.out.println("Status Code received from the response is "+statusCode);
				Assert.assertEquals(statusCode,200);

				//  statusLine Validation
				String statusLine = response.getStatusLine();
				System.out.println("Status Line"+ statusLine);
				Assert.assertEquals(statusLine , "HTTP/1.1 200 ", "Correct status code returned");
			
			
				// Validate the response
Assert.assertEquals(response.asString().contains("2227"),true, "Correct jobID received in the Response");
//jsonSchemaValidation
String jsonString=response.asString();
assertThat(jsonString,matchesJsonSchemaInClasspath("LMSAPI.json"));
  }
	
	//create a Testng Function
//	@Test(priority=2)
	
	public void  LMS_API_TC02_GETRQ_invalidId() throws IOException 
	{
      Response response= given().auth().basic("admin","password").
        		           when().get(getLMS_URI());
      //statusCode Validation
      int  statusCode=  response.getStatusCode();
      Assert.assertEquals(statusCode, 200);
      
 //Response 
      
      String jsonString=response.asString();
      System.out.println(jsonString);
      Assert.assertEquals("programId".contains("getLMS_invalidID"),false);
 
    
        		         
       
 
	}
       
 
	}

 