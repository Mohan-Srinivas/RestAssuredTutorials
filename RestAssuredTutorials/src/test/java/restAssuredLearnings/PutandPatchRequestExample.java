package restAssuredLearnings;


import org.json.simple.JSONObject;
import org.testng.annotations.Test;

/*
	PUT vs Patch
	When we need to replace an Existing Resource entirely,we can use Put
	
	When we are doing partial Update,We Can use HTTP Patch
	
	
	We need to give which resource are we going to update
	
	Delete :
	This request type is to delete the resource from the webserver
*/

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class PutandPatchRequestExample 
{
	@Test
	public void putRequestExample()
	{
		RestAssured.baseURI="https://reqres.in/";
		
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "newName");
		jsonObject.put("job", "Actor");
		
		RestAssured.given()
		.contentType(ContentType.JSON)
		.when()
		.body(jsonObject.toJSONString())
		.put("api/users/2")
		.then()
		.statusCode(200);
	}
	@Test
	public void putRequestwithoutBDD()
	{
		RestAssured.baseURI="https://reqres.in/";
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "newName");
		jsonObject.put("job", "Actor");
		RequestSpecification request=RestAssured.given();
		request.body(jsonObject.toJSONString());
		Response response=request.put("api/users/2");
		ResponseBody body= response.body();
		System.out.println(body.asPrettyString());
		System.out.println(response.statusCode());
	}
	@Test
	public void deleteRequestExample()
	{
		RestAssured.baseURI="https://reqres.in/";
		RestAssured.given().contentType(ContentType.JSON)
		.when()
		.delete("api/users/2")
		.then()
		.statusCode(204);
	}
	@Test
	public void deleteRequestwithoutBDD()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response response=RestAssured.delete("api/users/2");
		ResponseBody body=response.getBody();
		System.out.println(body.asPrettyString());
		System.out.println(response.statusLine());
	}	
}
