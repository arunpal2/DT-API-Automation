package Openlink_APIs;

import static io.restassured.RestAssured.given;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common_Test.ReadProperty;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.cookie.CookieFilter;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Openlink_runEquivalentUnits_API 
{
	public static Response response;
	static ReadProperty prop=new ReadProperty();
	static String accessToken;
	static String tokenType;
	@BeforeClass
    public static void setup()
	{
		//Thread.sleep(2000);
		// Defining all the Keys from API.Properties File.
		String BASE_URI = ReadProperty.getProperty("BASE_URL");
		String CONTENT_TYPE = ReadProperty.getProperty("CONTENT_TYPE");
		String GRANT_TYPE = ReadProperty.getProperty("GRANT_TYPE");
		String CLIENT_ID = ReadProperty.getProperty("CLIENT_ID");
		String CLIENT_SECRET = ReadProperty.getProperty("CLIENT_SECRET");
		String SCOPE = ReadProperty.getProperty("SCOPE");		
								
		// Using the keys from API.Properties File and Generating access_token from POST Login API.
		Response response = given()
				.header("Content-Type", CONTENT_TYPE)
				.formParam("grant_type",GRANT_TYPE)                                                   
				.formParam("client_id", CLIENT_ID)
				.formParam("client_secret", CLIENT_SECRET)
				.formParam("scope", SCOPE).when()
				.post(BASE_URI+"oauth20/token");
				
//		JSONObject jsonObject = new JSONObject(response.getBody().asString());
//		accessToken = jsonObject.get("access_token").toString();
//		tokenType = jsonObject.get("token_type").toString();
//		System.out.println("Token Type is:::::: " +tokenType); 
//		System.out.println("Access Token is:::::: " +accessToken); 	
		
    }
	
	 @Test
     public void Test_Openlink_isValidationRunning_API()
	 {	 
		 System.out.println("******************* GET Openlink run Equivalent Units API **************************");
		 System.out.println("\n");

		 RequestSpecification httpRequest = given().header("Host", ReadProperty.getProperty("HOST")).header("Cookie",ReadProperty.getProperty("COOKIE"));		
		 Response response = httpRequest.get(ReadProperty.getProperty("Openlink_runEquivalentUnits_URL")); 		 		
		 		 
		  /*
	         * To perform validation on response - statusCode, statusLine, timeInMs.
	        */
        
 			int statusCode = response.getStatusCode();
 			String statusLine = response.getStatusLine();
 			long timeInMs = response.getTime();
 			
 			// It displays the response in a prettyPrint format
 			System.out.println("Response Body is =>  " + response.prettyPrint());
 			
 			// This line of code would extract the status code from the response.
 			System.out.println("The status code recieved  : " + statusCode);
 			
 			// This line of code would extract the status Line from the response.
 			System.out.println("The status Line recieved  : " + statusLine);
 			
 			// This line of code would extract the time from the response.
 			System.out.println("Response Time Is          : " + timeInMs +" ms"); 
 			
 			System.out.println("\n");
 			Assert.assertEquals(statusLine, "HTTP/1.1 200 200"); 
 			System.out.println("\n");
 			Assert.assertEquals(statusCode, 200); 
 					
 			// Validate and verify the response Body.
// 			String bodyAsString = response.asString();
// 			Assert.assertEquals(bodyAsString.contains("GetOfferAPI-1") /*Expected value*/, true /*Actual Value*/, "Response body contains GetOfferAPI-1");
 			
 			System.out.println("****************************** End of GET Openlink run Equivalent Units API ******************************");
 			System.out.println("\n");
 			
     }
}
