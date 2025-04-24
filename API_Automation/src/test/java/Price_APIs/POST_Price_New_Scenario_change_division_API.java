// Working fine POST API.
package Price_APIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Common_Test.ReadProperty;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class POST_Price_New_Scenario_change_division_API 
{
	public static Response response;
	static ReadProperty prop=new ReadProperty();
	static String accessToken;
	static String tokenType;
	
	@BeforeClass
    public static void setup() 
	{
		// Defining all the Keys from API.Properties File.
		String BASE_URI = ReadProperty.getProperty("BASE_URL");
		String CONTENT_TYPE = ReadProperty.getProperty("CONTENT_TYPE");
		String GRANT_TYPE = ReadProperty.getProperty("GRANT_TYPE");
		String CLIENT_ID = ReadProperty.getProperty("CLIENT_ID_DM");
		String CLIENT_SECRET = ReadProperty.getProperty("CLIENT_SECRET_DM");
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
     public void Test_POST_Price_New_Scenario_change_division_API() throws IOException
	 {	 
		 System.out.println("******************* POST Price New Scenario Change Division API **************************");
		 System.out.println("\n");
		    
				 OkHttpClient client = new OkHttpClient().newBuilder()
						  .build();
						MediaType mediaType = MediaType.parse("application/json");
						
						RequestBody body = RequestBody.create(mediaType, "{\"scenarioId\":0,\"dummyRunId\":null,\"categoryIds\":[42],\"name\":\"API automation test, 2024\",\"description\":null,\"goalValue\":0,\"secVolConstraint\":null,\"secPrfConstraint\":null,\"secRevConstraint\":null,\"startDate\":\"05/13/2024\",\"endDate\":\"11/13/2024\",\"includeNonModel\":false,\"includeModelOnly\":false,\"viewPriceChange\":true,\"includePromo\":false,\"promoTimeframe\":null,\"optCostSource\":-1,\"optFutureCostSource\":0,\"futurePriceTimeframe\":null,\"futureCostTimeFrame\":null,\"priceUpdateCostSource\":-1,\"divisionId\":21,\"productGroupId\":43,\"locationGroupId\":21,\"scenarioGroupId\":null,\"children\":null}");
						
						Request request = new Request.Builder()
						  .url(ReadProperty.getProperty("Price_New_Scenario_change_division_POST_API"))
						  .method("POST", body)
						  .addHeader("Cookie", ReadProperty.getProperty("COOKIE"))
						  .addHeader("Host", ReadProperty.getProperty("HOST"))
						  .addHeader("Content-Type", "application/json")
						  .build();
						
						okhttp3.Response response = client.newCall(request).execute();
				 
				        System.out.println("Response Is::::::" +response);
				    
								
				  /*
			         * To perform validation on response - statusCode, statusLine, timeInMs.
			        */
		        
				   int statusCode = response.code();
		 			//String statusLine = response.getStatusLine();
		 			//long timeInMs = response.getTime();
		 			
		 			// It displays the response in a prettyPrint format
		 			//System.out.println("Response Body is =>  " + response.prettyPrint());
		 			
		 			// This line of code would extract the status code from the response.
		 			System.out.println("The status code recieved  : " + statusCode);
		 			
		 			// This line of code would extract the status Line from the response.
		 			//System.out.println("The status Line recieved  : " + statusLine);
		 			
		 			// This line of code would extract the time from the response.
		 			//System.out.println("Response Time Is          : " + timeInMs +" ms"); 
		 			
		 			//System.out.println("\n");
		 			//Assert.assertEquals(statusLine, "HTTP/1.1 200 200"); 
		 			//System.out.println("\n");
		 			Assert.assertEquals(statusCode, 200); 
		 			
		 			
		 			// Validate and verify the response Body.
		 			//String bodyAsString = response.asString();
		 			//Assert.assertEquals(bodyAsString.contains("GetOfferAPI-1") /*Expected value*/, true /*Actual Value*/, "Response body contains GetOfferAPI-1");
		 			
 			System.out.println("****************************** End of POST Price New Scenario Change Division Test ******************************");
 			System.out.println("\n");
     }
}
