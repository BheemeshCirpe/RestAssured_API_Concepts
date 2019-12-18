package restassured_basics;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basics_1_Normal_Import {

	@Test

	public void Test1() {

		// Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Respose Object
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		// Print the Response in Console
		String responseBody = response.getBody().asString();
		System.out.println("Respose Body is " + responseBody);

		int statusCode = response.getStatusCode();
		System.out.println("status code is " + statusCode);

		// validating status code

		Assert.assertEquals(statusCode, 200);
		
		String contentType =response.contentType();
		System.out.println("Content type is " + contentType);
		
		Assert.assertEquals(contentType, "application/jsons" );

	}

}
