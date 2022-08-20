package mySampleJSONServer;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.apache.groovy.json.internal.Exceptions.JsonInternalException;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class SamplePostRequestExample 
{
	@Test
	public void postMethodExample()
	{
		baseURI="http://localhost:3000/employees";
		File jsonFile=new File("JsonInput.json");
		/*String jsonBody="{\r\n"
				+ "\"first_name\": \"Ravi\",\r\n"
				+ "\"last_name\": \"Jadeja\",\r\n"
				+ "\"email\": \"jaddu@jaddu.com\"\r\n"
				+ "}";
		byte[] inputJson=jsonBody.getBytes(); */
		Response response= given().contentType(ContentType.JSON)
		.body(jsonFile)
		.when()
		.post();
		System.out.println("Status code is : "+response.statusCode());
		System.out.println("Status message is : "+response.statusLine());
		ResponseBody body=response.body();
		System.out.println(body.asPrettyString());

	}
	@Test
	public void postMethodWithoutBDD()
	{
		//baseURI="http://localhost:3000/employees";
		RequestSpecification request=given();
		JSONObject json=new JSONObject();
		json.put("first_name", "Suresh");
		json.put("last_name", "Raina");
		json.put("email", "SureshRaina48@raina.com");
		System.out.println(json.toString());
		request.contentType(ContentType.JSON);
	    request.body(json.toString());
		Response response=request.post("http://localhost:3000/employees");
		System.out.println("Status code is : "+response.statusCode());
		System.out.println("Status message is : "+response.statusLine());
		ResponseBody body=response.body();
		System.out.println(body.asPrettyString()); 
	}

}
