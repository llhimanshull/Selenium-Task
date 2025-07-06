package com.demo.tests.apis;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.base.Initializer;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class bookingId extends Initializer{

	
	@Test
	public void GETApiTest() {
		
		test = extent.createTest("Valid GET Api Testing");
		test.info("Hitting the endpoint");
		
		Response response = RestAssured
				.given()
					.baseUri("https://restful-booker.herokuapp.com/")
				.when()
					.get("/booking");
		test.info("endpoint hit /booking");
		int statusCode = response.getStatusCode();
		test.info("status code received:" + statusCode);
		assertEquals(response.getStatusCode(), 200);
		
		if(!response.jsonPath().getList("bookingid").isEmpty()) {
			test.pass("Booking IDs Retrieve successfully");
			System.out.println("Id" + response.jsonPath().getList("bookingid"));
		}else {
			test.warning("No booking Ids Found in response");
		}
		
		
	}
	
	@Test
	public void POSTApiTest() {
		
		test = extent.createTest("Post API Testing");
		
		String requestBody = """ 
			{
				"username" : "admin",
				"password" : "password123"
			}
		""";
		
		
		test.info("response body created" + requestBody);
		
		Response response = RestAssured
				.given()
					.baseUri("https://restful-booker.herokuapp.com")
					.contentType(ContentType.JSON)
					.body(requestBody)
				.when()
					.post("/auth");
		
		int statusCode = response.getStatusCode();
		test.info("status code received" + statusCode);
		
		String token = response.jsonPath().getString("token");
		
		if(token != null && !token.isEmpty()) {
			test.pass("token was generated" + token);
		}else {
			test.warning("no token genrated");
		}
		
		System.out.println("Response:\n" + response.prettyPrint());
		
		assertEquals(response.getStatusCode(), 200 );
		
				
				
	}

}
