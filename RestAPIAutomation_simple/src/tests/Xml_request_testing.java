package tests;
import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import Files.ReusableMethods;
import Files.resources;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class Xml_request_testing {
	
	Properties prop = new Properties();
	
	@BeforeTest
	public void GetDatafromproperties() throws IOException
	{
		//FileInputStream fi = new FileInputStream("D:\\Executables\\FundTech_TAF_Soap_Ui\\RestAPIAutomation_simple\\src\\Files\\environment.properties");
		FileInputStream fi = new FileInputStream("D:\\Executables\\FundTech_TAF_Soap_Ui\\RestAPIAutomation_simple\\src\\Files\\environment.properties");
	    prop.load(fi);	
	}
	
	@Test
	
	public void AddData() throws IOException
	{
		
        RestAssured.baseURI=prop.getProperty("HOST");
        
        String postbodyrequest=GenerateStringFromResource("D:\\Parthesh IMP\\REST API Automation\\Test Data\\XML_Body_request_for_post.xml");
       
		
		
		//Task - 1 : Add new Place Id
		
		Response res= given().
		        queryParam("key",prop.getProperty("KEY")).
		        body(postbodyrequest).
		        when().
		        post(resources.placepostdatainxml()).
		        then().
		       assertThat().statusCode(200).and().contentType(ContentType.XML).
		        extract().response();
		
		//String response =  res.asString();
		
		//System.out.println("Response is :" + response);
		
		//Task - 2 : Grab the Place Id from Response
		
		XmlPath x = ReusableMethods.RawtoXML(res);
		
		String place_id = x.get("PlaceAddResponse.place_id");
		
		System.out.println("Place Id is :" +place_id);
		
		//Task - 3 : Delete Place Id
		
	}

	public static String GenerateStringFromResource(String path) throws IOException
	{
		return new String(Files.readAllBytes(Paths.get(path)));
	}
}
