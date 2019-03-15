import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;
//import static org.hamcrest.Matchers.equalTo;
public class PostData {

	@Test
	
	public void add_data_with_api()
	{
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
	Response res =	given().
		        queryParam("key", "AIzaSyBWkpy81Uy5WDnbSZUHvosP5LoPTDq3pCs").
		        body("{" +
  "\"location\": {"+
   " \"lat\": -33.8669710,"+
    "\"lng\": 151.1958750"+
  "}," +
  "\"accuracy\": 50,"+
  "\"name\": \"Google Shoes!\","+
  "\"phone_number\": \"(02) 9374 4000\","+
  "\"address\": \"48 Pirrama Road, Pyrmont, NSW 2009, Australia\","+
  "\"types\": [\"shoe_store\"],"+
  "\"website\": \"http://www.google.com.au/\","+
  "\"language\": \"en-AU\""+
"}").
		        when().
		        post("/maps/api/place/nearbysearch/json").
		        then().
		        assertThat().statusCode(200).and().contentType(ContentType.JSON).extract().response();
		        //and().body("status",equalTo("OK"));

	//String responsestring = res.asString();
	
//	System.out.println(responsestring);
	System.out.println(res.getStatusCode());
	}
	
	
}
