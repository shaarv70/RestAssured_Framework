package com.spotify.oauth2.api;

import java.time.Instant;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.spotify.oauth2.utils.PropertyUtils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import  static io.restassured.RestAssured.*;

public class TokenManager {

	private static String access_token;
	private static Instant expiry_time;
	

	public synchronized static String get_token() /*here synchronized is used because in case of parallel execution 
	                                       //multiple thread/testcases will try to execute this method,so
	                                        synchronized will make them wait until one one thread exceutes the method  */
	{
		try
		{
			if(access_token==null || Instant.now().isAfter(expiry_time))
			{	
				System.out.println("Renewing token...");	
				Response response = renew_token();
				access_token = response.path("access_token");
				int expiryDurationInSeconds=response.path("expires_in");
				expiry_time=Instant.now().plusSeconds(expiryDurationInSeconds);
				

			}
			else 
			{
				System.out.println("Token is Good to Use");
			}
		}


		catch(Exception e)
		{
			e.printStackTrace();
			throw new RuntimeException("ABORT !!! Failed to get token");
		}

		return access_token;
	}


	private static Response renew_token()
	{
		
		HashMap<String,String> formparams= new HashMap<String, String>();
		formparams.put("client_id", PropertyUtils.get_instance().getString(Route.CLIENT_ID));
		formparams.put("client_secret",PropertyUtils.get_instance().getString(Route.CLIENT_SECRET));
		formparams.put("grant_type", PropertyUtils.get_instance().getString(Route.GRANT_TYPE));
		formparams.put("refresh_token",PropertyUtils.get_instance().getString(Route.REFRESH_TOKEN));

		Response response= RestResource.postAccount(formparams);

		if(response.statusCode()!=200)
		{
			throw new RuntimeException("ABORT !!! Failed to get token");

		}

		return response;



	}
}


