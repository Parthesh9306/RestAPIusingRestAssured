package tests;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class logging_in_Request {
	@Test
	
	public void test()
	{
		
			//System.out.println("Hello");
			
			RestAssured.baseURI = "https://maps.googleapis.com";
			
			
			
			given().
			
			       param("location", "-33.8670522,151.1957362").
			       param("radius","500").
			       param("key","AIzaSyBWkpy81Uy5WDnbSZUHvosP5LoPTDq3pCs").log().all().
			when().
			
			       get("/maps/api/place/nearbysearch/json").
			       
		    then().
			       assertThat().statusCode(200).and().
			       contentType(ContentType.JSON).
			       and().header("Server", "scaffolding on HTTPServer2").
			       and().
			       body("results[0].name",equalTo("Sydney"));
			       //body("results[0].geometry.location.lat",equalTo("-33.8688197"))
			       //body("results[0].place_id",equalTo("ChIJP3Sa8ziYEmsRUKgyFmh9AQM"));
			
			
			/*RequestSpecification httprequest = RestAssured.given().param("location", "-33.8670522,151.1957362").
				       param("radius","500").
				       param("key","AIzaSyBWkpy81Uy5WDnbSZUHvosP5LoPTDq3pCs");
			
			Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/json");
			
			String responsebody = response.getBody().asString();
			
			System.out.println("Response Body is -->" + responsebody);*/
			
		}
}
