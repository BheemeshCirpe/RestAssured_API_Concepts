package restassured_basics;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Basics_5_Post_Request_With_Json_File {

	public static void main(String[] args) throws IOException {
		RestAssured.baseURI = "http://216.10.245.166";

		given().queryParam("key", "qaclick123") // need to give queryparameter when we send post request
				.body(generateStringFromResource("C:\\Users\\roopa\\eclipse-workspace\\Web_Services\\Test_Data\\post_request_data.json"))
				.when().post("maps/api/place/add/json").then().assertThat().statusCode(200).and()
				.contentType(ContentType.JSON).and().body("status", equalTo("OK"));

	}
	
	public static String generateStringFromResource (String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}

}
