package dataDrivenTesting;


import static io.restassured.RestAssured.*;
import static utils.Api_Config_Reader.getJobid_delete_newId;

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
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static utils.Api_Config_Reader.getJobid_put;
import static utils.Api_Config_Reader.getJobTitle_put;
public class Jobs_API_PUTRQ extends API_TestDataProvider {
	
	@Test(dataProvider="PutDataProvider",priority=1)
	@Description("Verify all records are fetched using GET method ")
	@Severity(SeverityLevel.CRITICAL)
	public void Jobs_API_TC05_PUTRQ(String jid,String jTitle,String jCompanyName,String jLoc,String jType,String jPT,String jDesc)

	{

		baseURI="https://jobs123.herokuapp.com";
		JSONObject request=new JSONObject();
		request.put("Job Id",jid);
		request.put("Job Title", jTitle);
	Response response=	given().queryParams(request).		
		when().put("/Jobs");
	// Validate status Code
			int statusCode = response.getStatusCode();
			Assert.assertEquals(statusCode, 200);

			// Validating Response Body

			String jsonString = response.asString();

			Assert.assertEquals(jsonString.contains(jid),true);
		Assert.assertEquals(jsonString.contains(jTitle),true);

	}


		@Test(priority=2)
		public void Jobs_API_TC06_PUTRQ_sameData() throws IOException

		{

			baseURI="https://jobs123.herokuapp.com";
			JSONObject request=new JSONObject();
			request.put("Job Id",getJobid_put());
			request.put("Job Title", getJobTitle_put());
	Response response=	given().queryParams(request).		
			when().put("/Jobs");
	// Validate status Code
				int statusCode = response.getStatusCode();
				Assert.assertEquals(statusCode, 404);

				// Validating Response Body
				String jsonString = response.asString();
				System.out.println(jsonString);
						

			Assert.assertEquals(jsonString.contains("'"+ getJobid_put() +"'"+" job not found." +'"'),true);


		}	
}


