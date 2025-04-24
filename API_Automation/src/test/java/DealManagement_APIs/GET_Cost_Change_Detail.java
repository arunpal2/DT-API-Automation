package DealManagement_APIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common_Test.ReadProperty;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class GET_Cost_Change_Detail 
{
	public static Response response;
	static ReadProperty prop=new ReadProperty();
	static String accessToken;
	static String tokenType;
	
	@BeforeClass
    public static void setup() 
	{// Defining all the Keys from API.Properties File.
		String BASE_URI = ReadProperty.getProperty("BASE_URL");
		String CONTENT_TYPE = ReadProperty.getProperty("CONTENT_TYPE");
		String GRANT_TYPE = ReadProperty.getProperty("GRANT_TYPE");
		String CLIENT_ID = ReadProperty.getProperty("CLIENT_ID_SWY");
		String CLIENT_SECRET = ReadProperty.getProperty("CLIENT_SECRET_SWY");
		String SCOPE = ReadProperty.getProperty("SCOPE_SWY");		
								
		// Using the keys from API.Properties File and Generating access_token from POST Login API.
		Response response = given()
				.header("Content-Type", CONTENT_TYPE)
				.formParam("grant_type",GRANT_TYPE)                                                   
				.formParam("client_id", CLIENT_ID)
				.formParam("client_secret", CLIENT_SECRET)
				.formParam("scope", SCOPE).when()
				.post(BASE_URI+"oauth20/token");
				
		// 
		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		accessToken = jsonObject.get("access_token").toString();
		tokenType = jsonObject.get("token_type").toString();
		System.out.println("Token Type is:::::: " +tokenType); 
		System.out.println("Access Token is:::::: " +accessToken); 		
    }
	
	 @Test
     public void Test_GET_Offer()
	 {	 
		 System.out.println("******************* GET OFFER **************************");
		 System.out.println("\n");
		 //  Create a Request pointing to the Service Endpoint and make a GET Request with access token.
		RequestSpecification httpRequest = given().header("Authorization", "Bearer " + accessToken);
		 Response response = httpRequest.get(ReadProperty.getProperty("Get_Cost_Change_Detail")); 
		 	 
	
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
 			Assert.assertEquals(statusLine, "HTTP/1.1 200 OK"); 
 			System.out.println("\n");
 			Assert.assertEquals(statusCode, 200); 
 					
 			// Validate and verify the response Body.
 			//String bodyAsString = response.asString();
 			//Assert.assertEquals(bodyAsString.contains("GetOfferAPI-1") /*Expected value*/, true /*Actual Value*/, "Response body contains GetOfferAPI-1");
 			
 			System.out.println("****************************** End of GET OFFER Test ******************************");
 			System.out.println("\n");
 			
     }
}
