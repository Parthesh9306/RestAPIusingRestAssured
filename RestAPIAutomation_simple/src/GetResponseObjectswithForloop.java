import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import Files.ReusableMethods;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetResponseObjectswithForloop {

	@Test
	
	public void test()
	{
		
			//System.out.println("Hello");
			
			RestAssured.baseURI = "https://maps.googleapis.com";
			
			Response res =
			
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
			       extract().response();
			       
			
			JsonPath js = ReusableMethods.RawtoJson(res);
			
			int count = js.get("results.size()");
			
			//String name = js.get("results[0].name");
			
			//System.out.println(name);
			
			for (int i=0; i<count; i++)
			{
				System.out.println(js.get("results["+i+"].name").toString());
			}
		}
	
}
