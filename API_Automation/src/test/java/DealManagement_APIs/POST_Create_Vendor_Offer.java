package DealManagement_APIs;

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

public class POST_Create_Vendor_Offer 
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
		String CLIENT_ID = ReadProperty.getProperty("CLIENT_ID_SW");
		String CLIENT_SECRET = ReadProperty.getProperty("CLIENT_SECRET_SW");
		String SCOPE = ReadProperty.getProperty("SCOPE_SW");		
		//String HOST = ReadProperty.getProperty("HOST");	
								
		// Using the keys from API.Properties File and Generating access_token from POST Login API.
		Response response = given()
				.header("Content-Type", CONTENT_TYPE)
				.formParam("grant_type",GRANT_TYPE)                                                   
				.formParam("client_id", CLIENT_ID)
				.formParam("client_secret", CLIENT_SECRET)
				.formParam("scope", SCOPE).when()
				.post(BASE_URI+"oauth20/token");
				
		JSONObject jsonObject = new JSONObject(response.getBody().asString());
		accessToken = jsonObject.get("access_token").toString();
		tokenType = jsonObject.get("token_type").toString();
		System.out.println("Token Type is:::::: " +tokenType); 
		System.out.println("Access Token is:::::: " +accessToken); 	
		
    }
	
	 @Test
     public void Test_GET_Scenario_Run_Report() throws IOException
	 {	 
		 System.out.println("******************* GET OFFER **************************");
		 System.out.println("\n");

		 	
		 	
		 	OkHttpClient client = new OkHttpClient().newBuilder()
		 			  .build();
		 			MediaType mediaType = MediaType.parse("application/json");
		 			RequestBody body = RequestBody.create(mediaType, "{\r\n    \"UserName\" : \"rleever\",\r\n    \"RetailerName\" : \"Albertsons\",\r\n    \"RepName\" : \"Richelle Leever\",\r\n    \"Vendor\" : \"GENERAL MILLS INC (000606)\",\r\n    \"BillTo\" : \"Vendor\",\r\n    \"VendorName\" : \"GENERAL MILLS INC (000606)\",\r\n    \"APPayeeNumber\" : \"041445\",\r\n    \"APVendorNumber\" : \"000606\",\r\n    \"ARCustomerNumber\" : \"111978\",\r\n    \"VendorContactName\" : \"VLADIMIR CORDELL TILME\",\r\n    \"VendorAddressLine1\" : \"AddressLine-1\",\r\n    \"VendorAddressLine2\" : \"AddressLine-2\",\r\n    \"VendorCity\" : \"City-1\",\r\n    \"VendorState\" : \"XX\",\r\n    \"VendorCountry\" : \"United S\",\r\n    \"VendorZipCode\" : \"99999\",\r\n    \"VendorEmail\" : \"\",\r\n    \"VendorFax\" :\"999-999-9999\",\r\n    \"VendorPhone\" : \"test@gmail.com\",\r\n    \"VendorBillingEmail\" : \"yyy@yy.yyy\",\r\n    \"ManufacturerName\" : \"General Mills\",\r\n    \"ManufacturerContactName\" : \"VLADIMIR TILME\",\r\n    \"ManufacturerAddressLine1\" : \"AddressLine-1\",\r\n    \"ManufacturerAddressLine2\" : \"AddressLine-2\",\r\n    \"ManufacturerCity\" : \"City-1\",\r\n    \"ManufacturerState\" : \"XX\",\r\n    \"ManufacturerCountry\" : \"USA\",\r\n    \"ManufacturerZipCode\" : \"99999\",\r\n    \"ManufacturerEmail\" : \"\",\r\n    \"ManufacturerFax\" :\"999-999-9999\",\r\n    \"ManufacturerPhone\" : \"999-999-9999\",\r\n    \"VendorTrackingNumber\" :\"Deal Created by API\",\r\n    \"DealDescription\" : \"Deal Created by API - Dewangi \",\r\n    \"DealComments\" : \"Deal Created by API\",\r\n    \"PerformanceType\" : \"19-Portland\",\r\n    \"PerformanceName\" : \"Other\",\r\n    \"PerformanceStartDate\" : \"2025-06-27\",\r\n    \"PerformanceEndDate\" :\"2025-07-10\",\r\n    \"RSFields\" : [{\r\n                    \"FieldName\":\"PromotionId\",\r\n                    \"FieldValue\":\"1\"\r\n    }],\r\n     \"StoreGroups\":null,\r\n    \"FlatAllowances\" :null,\r\n    \"ItemAllowances\":[{\r\n                \"AllowanceName\":\"Scan Allow (05)\",\r\n                \"Basis\":\"Per Transaction\",\r\n                \"PerformanceIndicator\":\"01 Non-Performance\",\r\n                \"ShortName\" : \"Scan05\",\r\n                \"PaymentMethod\" : \"Billback\",\r\n                \"StartDate\" : \"2025-06-27\",\r\n                \"EndDate\" : \"2025-07-10\"\r\n                }],\r\n    \"Item\" :[{\r\n                \"ItemDescription\" : \"BC GSHRS SPR SR BRRY\",\r\n                \"PrimaryAllowanceName\" : \"Scan Allow (05)\",\r\n                \"PrimaryAllowanceAmount\" : 6.00,\r\n                \"UPCCase\" : \"00016000137042\",\r\n                \"UPCConsumer\" : \"016000137042\",\r\n                \"ItemPackSize\" : \"8/4.25 OZ\",\r\n                \"UPCPack\" : \"8\",\r\n                \"UnitCost\": 99.9,\r\n                \"RetailPrice\": 99.9,\r\n                \"BaseDeal\": 99.9,\r\n                \"OtherAllowance\": 99.9,\r\n                \"ForecastedUnits\":1,\r\n                \"Ad\" : true,\r\n                \"Display\": true,\r\n                \"PriceType\": 3,\r\n                \"PriceValue1\": 99.9\r\n            }],\r\n    \"Location\" :[{\r\n        \"LocationName\" : \"05 - Denver\"\r\n    }]\r\n}");
		 			Request request = new Request.Builder()
		 			  .url(ReadProperty.getProperty("POST_Create_Vendor_Offer"))
		 			  .method("POST", body)
		 			  .addHeader("Authorization", "Bearer " + accessToken)
		 			  .addHeader("Content-Type", "application/json")
		 			  .build();
		 			
		 			okhttp3.Response response1 = client.newCall(request).execute();
		 			 
			        String results = response1.body().string();
			        System.out.println("Result is::::" +results);
			        		 	 
		  /*
	         * To perform validation on response - statusCode, statusLine, timeInMs.
	        */
			        int statusCode = response1.code();
		 			System.out.println("The status code recieved  : " + statusCode);
		 			Assert.assertEquals(statusCode, 200); 
		 			System.out.println("****************************** End of POST Price Detailed Scenario Test ******************************");
		 			System.out.println("\n"); 			
     }
}
