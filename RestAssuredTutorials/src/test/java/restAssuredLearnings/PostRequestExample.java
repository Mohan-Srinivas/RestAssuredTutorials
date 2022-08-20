package restAssuredLearnings;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

/*
Post request
------------
1. Post URL :"https://reqres.in/api/users/"
2. Post request is used to create a resource in a web server
3. Status code of post request is 201-Which means resource has been created 
   Successfully.
4. Generally speaking we have to give necessary headers for Authentication,
   content-types,Accept and JSon body to create the resource
5. To Create the json body,There are lot of ways.You can create JSON using 
   json simple,Gson,Jackson or any other .
   note :  You can keep the JSON body in a file and read the Json from file instead
   of Constructing
 */
public class PostRequestExample
{
	@Test
	public void postMethodExample()
	{
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "Geev's");
		jsonObject.put("job", "President");
		//System.out.println(jsonObject.toString());

		RestAssured.baseURI="https://reqres.in/";

		RestAssured.given()
		.header("","")
		.contentType(ContentType.JSON)
		.body(jsonObject.toJSONString())
		.post("api/users/")
		.then().statusCode(201);
	}
	@Test
	public void postMethod()
	{
		RestAssured.baseURI ="https://reqres.in/"; 
		RequestSpecification request=RestAssured.given();
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("name", "Username1239");
		jsonObject.put("job", "MLA all");
		System.out.println(request.body(jsonObject.toJSONString()));
		Response response=request.post("api/users/");
		ResponseBody body=response.body();
		System.out.println(body.asPrettyString());
		System.out.println(response.statusCode());
	}
}
