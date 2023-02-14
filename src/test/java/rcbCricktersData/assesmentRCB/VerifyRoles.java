package rcbCricktersData.assesmentRCB;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import  org.hamcrest.Matcher.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import  static io.restassured.matcher.RestAssuredMatchers.*;
import static org.testng.Assert.assertEquals;
import static   org.hamcrest.Matchers.*;


import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.util.logging.Log;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import  io.restassured.matcher.RestAssuredMatchers.*;
import io.restassured.parsing.Parser;


public class VerifyRoles {

	@Test(enabled=false)
	public static void verifyCountry()
	{

		int foreginers=0;
		JsonPath js = new JsonPath(Payload.rCBdata());

		int count = js.getInt("player.size()");

		for(int i=0; i<count;i++)
		{
			String country= js.get("player["+i+"].country");
			if (!"India".equals(country))
			{

				foreginers++;
				System.out.println(country);


				if( foreginers==4) { System.out.println("there are atleast 4 foreginers "); }

			}


			//System.out.println(roles);
		}
		System.out.println(foreginers);
	}
	@Test(enabled=false)
	public static void verifyRoles()
	{
		int keeper=0;
		JsonPath js = new JsonPath(Payload.rCBdata());

		int count = js.getInt("player.size()");

		for(int i=0; i<count;i++)
		{
			String roles= js.get("player["+i+"].role");
			if (roles.equalsIgnoreCase("Wicket-keeper"))
			{

				keeper++;
				System.out.println(roles);


				if( keeper>=1) { System.out.println("there are atleast 1 wicket-keeper "); }

			}

		}
		System.out.println(keeper);
		
	}
	
}
