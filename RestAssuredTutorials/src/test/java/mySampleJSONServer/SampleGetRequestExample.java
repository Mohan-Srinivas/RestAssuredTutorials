package mySampleJSONServer;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class SampleGetRequestExample 
{
	@Test
	public void getMethodExample()
	{
		baseURI="http://localhost:3000/employees";
		Response response= given().contentType(ContentType.JSON)
		.when()
		.get();
		System.out.println("Status code is : "+response.statusCode());
		System.out.println("Status message is : "+response.statusLine());
		ResponseBody body=response.body();
		System.out.println(body.asPrettyString());
	}

}
