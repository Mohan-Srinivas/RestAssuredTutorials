package mySampleJSONServer;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class JsonValidationExample 
{
	
	//1. Check if the league id is 35
	@Test
	public void checkLeagueId()
	{
		get("http://localhost:3000/team").then().body("data.leagueId", equalTo(35));
	}
	
	//2. Check if the visiting team is 'India'
	@Test
	public void checkVisitingTeam()
	{
		get("http://localhost:3000/team").then().body("data.visitingTeam", equalTo("India"));
	}
	//3. Check if the weight is 65.7
	@Test
	public void checkWeight()
	{
		get("http://localhost:3000/team").then().body("data.weight", equalTo(65.7f));
	}
	//4.Check if the response is taking less than a second
	@Test
	public void checkResponseTime()
	{
		get("http://localhost:3000/team").then().time(lessThan(1l), TimeUnit.SECONDS);
	}
	//5. Check if odds array has 2 elements in it
	@Test
	public void checkEntries()
	{
		get("http://localhost:3000/team").then().body("odds", hasSize(1));
	}
	@Test
	public void checkEmpty()
	{
		get("http://localhost:3000/team").then().body("odds",empty());
	}
}
