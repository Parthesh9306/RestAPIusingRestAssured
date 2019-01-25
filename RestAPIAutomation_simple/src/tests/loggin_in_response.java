package tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class loggin_in_response {

@Test
	
	public void test()
	{
		
			//System.out.println("Hello");
			
			RestAssured.baseURI = "https://maps.googleapis.com";
			
			
			
			given().
			
			       param("location", "-33.8670522,151.1957362").
			       param("radius","500").
			       param("key","AIzaSyBWkpy81Uy5WDnbSZUHvosP5LoPTDq3pCs").
			when().
			
			       get("/maps/api/place/nearbysearch/json").
			       
		    then().
			       assertThat().statusCode(200).and().
			       contentType(ContentType.JSON).
			       and().header("Server", "scaffolding on HTTPServer2").
			       and().
			       body("results[0].name",equalTo("Sydney")).log().all();
	
		}
	
}
