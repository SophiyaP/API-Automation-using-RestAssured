package dataDrivenTesting;

import static io.restassured.RestAssured.*;
import java.io.IOException;

import org.apache.tools.ant.types.Assertions;
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
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import static utils.Api_Config_Reader.getURI;
import static utils.Api_Config_Reader.getJobid_Delete;
import static utils.Api_Config_Reader.getJobid_delete_newId;

public class Jobs_API_DeleteRQ {

	@Test(priority = 1)
	@Description("Verify the records are deleted for Jobs API")
	@Severity(SeverityLevel.NORMAL)
	public void Jobs_API_TC07_DeleteRQ() throws IOException

	{
		RestAssured.baseURI = getURI();
		JSONObject request = new JSONObject();
		request.put("Job Id", getJobid_Delete());
		Response response = given().queryParams(request).when().delete();

//Validate status Code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
// Validate Response Body
		String jsonString = response.getBody().asString();
		System.out.println(jsonString);
		Assert.assertEquals(jsonString.contains("getJobid_Delete()"), false);

	}

	@Test(priority = 2)

	public void Jobs_API_TC08_DeleteRQ_newId() throws IOException

	{

		RestAssured.baseURI = getURI();

		JSONObject request = new JSONObject();
		request.put("Job Id", getJobid_delete_newId());

		Response response = given().queryParams(request).when().delete();

// Validate status Code
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 404);

		// Validating Response Body

		// By using the response.asString() method, we can convert the body into the
		// string.
		String jsonString = response.asString();
		System.out.println(jsonString);
		Assert.assertEquals(jsonString.contains("'" + getJobid_delete_newId() + "'" + " Job  not found."), true);

	}
}
