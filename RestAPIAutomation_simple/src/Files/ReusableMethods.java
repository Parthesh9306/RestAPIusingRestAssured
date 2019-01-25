package Files;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethods {
	
	static ReusableMethods rm = new ReusableMethods();
	
	
	static Properties prop = new Properties();
	
	
	
	public void GetDataFromProperties() throws IOException 
	{
		FileInputStream fi = new FileInputStream("D:\\Executables\\FundTech_TAF_Soap_Ui\\RestAPIAutomation_simple\\src\\Files\\environment.properties");
		prop.load(fi);
	}

	public static XmlPath RawtoXML(Response res)
	{
		
		String response = res.asString();
		XmlPath xpath = new XmlPath(response);
		return xpath;
		
	}
	
	public static JsonPath RawtoJson(Response res)
	{
		
		String response = res.asString();
		JsonPath jpath = new JsonPath(response);
		return jpath;
		
	}
	
	
	public static String create_Session_ID() throws IOException
	{
		rm.GetDataFromProperties();
		
RestAssured.baseURI = prop.getProperty("JIRA_HOST");
		
		Response res=given()
				.contentType(ContentType.JSON)
		      .body("{\"username\": \"partheshjoshi\", \"password\": \"vaspas9306\"}").
		when()
		     .post("/rest/auth/1/session").
		then()
		      .assertThat()
		      .statusCode(200)
		      .extract().response();
		
		
		//String responsestring = res.asString();
		//System.out.println("Response is :"+responsestring);
		
	JsonPath js =ReusableMethods.RawtoJson(res);
	String session_id = js.get("session.value");
	System.out.println(session_id);
	return session_id;
	
	}
}
