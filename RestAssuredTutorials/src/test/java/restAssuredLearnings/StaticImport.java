package restAssuredLearnings;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;


//Need to use without using RestAssured,we can import the Rest assured as follows
//import static io.restassured.RestAssured.*;

public class StaticImport 
{
	@Test
	public void deleteRequestExample()
	{
		baseURI="https://reqres.in/";
		given().contentType(ContentType.JSON)
		.when()
		.delete("api/users/2")
		.then()
		.statusCode(204);
	}
	

}
