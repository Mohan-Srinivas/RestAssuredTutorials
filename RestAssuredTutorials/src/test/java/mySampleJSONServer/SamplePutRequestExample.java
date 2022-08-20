package mySampleJSONServer;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SamplePutRequestExample 
{
	@Test
	public void putMethodExample()
	{
		RestAssured.baseURI="http://localhost:3000/employees/4";
		String jsonBody="{\r\n"
				+ "\"first_name\": \"Ravi\",\r\n"
				+ "\"last_name\": \"Jadeja\",\r\n"
				+ "\"email\": \"jadeja@jadeja.com\"\r\n"
				+ "}";
		byte[] inputJson=jsonBody.getBytes();
		Response response= RestAssured.given().contentType(ContentType.JSON)
							.body(inputJson)
							.when()
							.put();
		
		System.out.println("Status code is : "+response.statusCode());
		System.out.println("Status message is : "+response.statusLine());
		ResponseBody body=response.body();
		System.out.println(body.asPrettyString());
	}
	@Test
	public void patchMethodWithoutBDD()
	{
		RestAssured.baseURI="http://localhost:3000/employees/5";
		JSONObject json=new JSONObject();
		json.put("first_name", "Suresh");
		json.put("last_name", "Raina");
		json.put("email", "SureshRaina48@gracia.com");
		RequestSpecification request= RestAssured.given();
		request.contentType(ContentType.JSON);
		request.body(json.toJSONString());
		Response response= request.patch();
		System.out.println("Status code is : "+response.statusCode());
		System.out.println("Status message is : "+response.statusLine());
		ResponseBody body=response.body();
		System.out.println(body.asPrettyString());
		
		
		
	}
	
}
