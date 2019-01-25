package Files;

public class Payload {

	public static String getPostData()
	{
	
		String post_body_request = "{" +
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
				"}";
		
		return post_body_request;
	}
	
	
	public static String getPostDataforXML()
	{
	
		String post_body_request_xml = "{" +
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
				"}";
		
		return post_body_request_xml;
	}
}
