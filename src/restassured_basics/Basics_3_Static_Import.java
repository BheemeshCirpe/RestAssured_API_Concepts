package restassured_basics;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class Basics_3_Static_Import {

	public static void main(String[] args) {
		
		RestAssured.baseURI ="https://maps.googleapis.com";
		
		given().
	       param("location","-33.8670522,151.1957362").
	       param("radius","500").
	       param("key","AIzaSyBbB-w8QJU6R_CIZshjBcSEtdSnpQ2Vmlw").
	    when().
	       get("/maps/api/place/nearbysearch/json").
	    then().assertThat().statusCode(200).and().contentType(ContentType.JSON);
		
		
	    
	       
	}

}
