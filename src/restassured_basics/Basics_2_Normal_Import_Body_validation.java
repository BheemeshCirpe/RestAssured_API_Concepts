package restassured_basics;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basics_2_Normal_Import_Body_validation {

	@Test

	public void Test2() {

		// Specify Base URI
		RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";

		// Request Object
		RequestSpecification httpRequest = RestAssured.given();

		// Respose Object
		Response response = httpRequest.request(Method.GET, "/Hyderabad");

		JsonPath jp = rawToJson(response);
		
		String city=jp.get("City");
		System.out.println(city);

	}

	public static JsonPath rawToJson(Response r) {
		String respon = r.asString();
		JsonPath x = new JsonPath(respon);
		return x;
	}

}
