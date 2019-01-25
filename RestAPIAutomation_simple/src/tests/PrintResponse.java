package tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import scala.Equals;
//import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;



public class PrintResponse {
	
	@Test
	
	public void test()
	{
		
			//System.out.println("Hello");
			
			RestAssured.baseURI = "https://maps.googleapis.com";
	
			
			RequestSpecification httprequest = RestAssured.given().param("location", "-33.8670522,151.1957362").
				                                                   param("radius","500").
				                                                   param("key","AIzaSyBWkpy81Uy5WDnbSZUHvosP5LoPTDq3pCs");
			
			Response response = httprequest.request(Method.GET, "/maps/api/place/nearbysearch/json");
			
			String responsebody = response.getBody().asString();
			
			System.out.println("Response Body is -->" + responsebody);
			
		}

	}