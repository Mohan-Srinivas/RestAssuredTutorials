package restAssuredLearnings;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ValidatableResponse;

public class GetRequestExample 
{	
	@Test
	public void getRequestMethod()
	{
		Response response=RestAssured.get("https://reqres.in/api/users/3");
		//response.getBody();
		
		ResponseBody  responseBody=response.body();
		String result=responseBody.asString();
		String preetyResult=responseBody.asPrettyString();
		System.out.println(result);
		System.out.println(preetyResult);
	}
	@Test
	public void getRequestviaBDD()
	{
		RestAssured.baseURI="https://reqres.in/api";
		ValidatableResponse response= RestAssured.
				given()
					.param("","")
					.header("","")
				.when()
					.get("/users/3")
				.then()
					.statusCode(200);
		System.out.println(response.toString());
		//System.out.println(response.asPrettyString());
	}
}
