package restAssuredLearnings;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class SampleRestAssured
{
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		Response response=RestAssured.get("https://www.google.co.in");
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		
	}

}


/*
Get Request Steps:-

1. Hit the GET Request of Rest Assured for this "https://reqres.in/api/users/2 "
2. Store the result in a Rest Assured Response data type
3. From the response,either use body() or getBody() to obtain the response body
4. The response obtained is like a Json object,So obtain the response as String 
   using asString() or if you want to pretty, print the Json as prettyString()
   
 Added info : To view pretty printed Json in you browser,you can use any extension
   


*/