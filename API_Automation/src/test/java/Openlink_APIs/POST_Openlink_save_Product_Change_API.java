package Openlink_APIs;

import static io.restassured.RestAssured.given;

import java.io.IOException;

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
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class POST_Openlink_save_Product_Change_API 
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
     public void Test_POST_Openlink_save_Product_Change_API() throws IOException
	 {	 
		 System.out.println("******************* GET Openlink save Product Change API **************************");
		 System.out.println("\n");


		 OkHttpClient client = new OkHttpClient().newBuilder()
				  .build();
				MediaType mediaType = MediaType.parse("application/json");
				
				RequestBody body = RequestBody.create(mediaType, "{\"changedProdList\":[{\"attributed\":\"No\",\"hasRecentPOS\":\"No\",\"isSeasonal\":\"No\",\"productID\":133467,\"upc\":\"00812887_00000\",\"description\":\"AXE      DEOD BDY SPRY TSUNAMI\",\"size\":\"4.00\",\"uom\":\"OZ\",\"brand\":\"AXE\",\"currentRetail\":\"-1.00\",\"avgScanPrice\":\"2.68\",\"pricePerUOM\":\"0.67\",\"cost\":\"3.200\",\"avgWeeklyVolume\":\"16.67\",\"includedInModel\":\"Yes\",\"customerStatus\":\"Discontinued\",\"firstScannedDate\":1097305200000,\"lastScannedDate\":1143874800000,\"lineGroup\":null,\"customerProductKey\":\"00000000812887\",\"sizeFamily\":null,\"sizeClass\":null,\"brandFamily\":null,\"brandClass\":null,\"prePriced\":\"No\",\"level1Descr\":\"BEAUTY CARE\",\"level2Descr\":\"DEODORANT 02\",\"level3Descr\":\"DEODORANT - BODY SPRAY 02\",\"level4Descr\":\"DEODORANT - BODY SPRAY 02\",\"level5Descr\":null,\"level6Descr\":null,\"level7Descr\":null,\"level8Descr\":null,\"level9Descr\":null,\"level10Descr\":null,\"level11Descr\":null,\"level12Descr\":null,\"equivUnits\":\"1.00\",\"productLinkType\":null,\"matureProductUPC\":null,\"matureProductDescription\":null,\"matureProductDemandGroup\":null,\"matureProductUOM\":null,\"eqcFactor\":\"1.00\",\"basePriceError\":\"No\",\"equivUnitError\":\"No\",\"demandGroup\":\"BODY_SPRAY_MEN\",\"hasAnyError\":\"No\",\"manuFacturer\":\"UNKNOWN\",\"ppg\":\"194Package_PG3\",\"useProductHierarchyMapFlag\":\"Yes\"},{\"attributed\":\"No\",\"hasRecentPOS\":\"No\",\"isSeasonal\":\"No\",\"productID\":133403,\"upc\":\"00301795_00000\",\"description\":\"OL SPICE AP/DEO/BW/BDY SPRY\",\"size\":\"6.50\",\"uom\":\"OZ\",\"brand\":\"RIGHT_GUARD\",\"currentRetail\":\"-1.00\",\"avgScanPrice\":\"2.85\",\"pricePerUOM\":\"0.44\",\"cost\":\"2.810\",\"avgWeeklyVolume\":\"6.19\",\"includedInModel\":\"Yes\",\"customerStatus\":\"Discontinued\",\"firstScannedDate\":1128754800000,\"lastScannedDate\":1145084400000,\"lineGroup\":\"OLD_SPICE_BODY_SPRAY_6.5OZ\",\"customerProductKey\":\"00000000301795\",\"sizeFamily\":null,\"sizeClass\":null,\"brandFamily\":null,\"brandClass\":null,\"prePriced\":\"No\",\"level1Descr\":\"BEAUTY CARE\",\"level2Descr\":\"DEODORANT 02\",\"level3Descr\":\"DEODORANT - STICK/SOLID 02\",\"level4Descr\":\"DEODORANTS - STICK-SOLID 02\",\"level5Descr\":null,\"level6Descr\":null,\"level7Descr\":null,\"level8Descr\":null,\"level9Descr\":null,\"level10Descr\":null,\"level11Descr\":null,\"level12Descr\":null,\"equivUnits\":\"0.62\",\"productLinkType\":null,\"matureProductUPC\":null,\"matureProductDescription\":null,\"matureProductDemandGroup\":null,\"matureProductUOM\":null,\"eqcFactor\":\"1.00\",\"basePriceError\":\"No\",\"equivUnitError\":\"No\",\"demandGroup\":\"BODY_SPRAY_MEN\",\"hasAnyError\":\"No\",\"manuFacturer\":\"UNKNOWN\",\"ppg\":null,\"useProductHierarchyMapFlag\":\"Yes\"}]}");
				Request request = new Request.Builder()
				  .url(ReadProperty.getProperty("Openlink_save_Product_Change_POST_URL"))
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
 			
 			System.out.println("****************************** End of GET Openlink save Product Change API ******************************");
 			System.out.println("\n");
 			
     }
}
