package dataDrivenTesting;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.MatcherAssert.assertThat;
import static utils.Api_Config_Reader.getURI;
import static utils.Api_Config_Reader.getinvalidURI;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Jobs_API_GETRQ  extends API_TestDataProvider {

	
	@Test(priority=1)
	@Description("Verify all records are fetched using GET method for jobs API ")
	@Severity(SeverityLevel.MINOR)
	public void Jobs_API_TC01_GetAllRecs() throws IOException 
	{
	//specify the base URI
		RestAssured.baseURI=getURI();
		// using httprequest object to send request to server
		RequestSpecification httprequest=RestAssured.given();

		//Response object
		Response response=httprequest.request(Method.GET);


		//StatusCode Validation
		int statusCode= response.getStatusCode();
		System.out.println("Status Code received from the response is "+statusCode);
		Assert.assertEquals(statusCode,200);

		//  statusLine Validation
		String statusLine = response.getStatusLine();
		System.out.println("Status Line "+statusLine);
		Assert.assertEquals(statusLine , "HTTP/1.1 200 OK", "Correct status code returned");
	
	
		// Validate the response
		Assert.assertEquals(response.asString().contains("1009"),true, "Correct jobID received in the Response"); 
		
		//Json Schema Validation
		String responseBody=response.asString();
		assertThat( responseBody.replaceAll("NaN", "null"),  matchesJsonSchemaInClasspath("JobsAPISchema.json"));
	}

//@Test(priority=2)

	public void Jobs_API_TC02_GETRQ_invalidURL() throws IOException 
	{
	
		RestAssured.baseURI=getinvalidURI();
		// using httprequest object to send request to server
		RequestSpecification httprequest=RestAssured.given();

		//Response object
		Response response=httprequest.request(Method.GET);
		//Print the response
		//response body will be in JSON format so converting 
		String responseBody=response.getBody().asString();
		System.out.print("Response Body is " + responseBody);

		//StatusCode Validation
		int statusCode= response.getStatusCode();
		Assert.assertEquals(statusCode,404);
		
		//StatusLine Validation
		String statusLine=response.getStatusLine();

		Assert.assertEquals(statusLine, "HTTP/1.1 404 NOT FOUND");
		//Response body Validation
		
	//	String jsonString = response.asString();
		
Assert.assertEquals( response.asString().contains( "The requested URL was not found on the server."),true);
}
}
