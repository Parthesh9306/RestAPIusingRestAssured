package tests;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import Files.ReusableMethods;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class JIRA_Create_Session_Add_Defect_Add_Comment_Update_Comment {

	
	@Test 
	public void getJIRASession() throws IOException
	{
		String session_id = ReusableMethods.create_Session_ID();
		
		Response resp = 
				
   		given()
				.header("cookie","JSESSIONID="+ReusableMethods.create_Session_ID())
				.contentType(ContentType.JSON)
				.body("{"+
    "\"fields\": {"+
       "\"project\":"+
	   "{"+
          "\"key\": \"RES\""+
       "},"+
       "\"summary\": \"Credit Card Defect\","+
       "\"description\": \"Creating my first bug\","+
       "\"issuetype\": {"+
          "\"name\": \"Bug\""+
       "}"+
   "}"+
"}").
				when()
				.post("/rest/api/2/issue").
				then().assertThat().statusCode(201).extract().response();
		
		JsonPath js = ReusableMethods.RawtoJson(resp);
		String defect_id = js.get("id");
		System.out.println("Defect_ID :"+defect_id);
	}
	
	
	
}
