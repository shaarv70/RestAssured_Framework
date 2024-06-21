package com.spotify.oauth2.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.List;

import io.restassured.response.Response;

public class RestResource extends SpecBuilder{




	public static Response postAccount(HashMap<String,String> formparams)
	{
		return given(getAccountRequestSpec()).
				formParams(formparams).

				when().post(Route.API+Route.TOKEN).

				then().spec(getResponseSpecefication()).
				extract().response();

	}




	public static Response Post(String path,String token,Object requestPlaylist)
	{
		return given(getRequestSpecefication()).
				body(requestPlaylist).
				auth().oauth2(token).
				

				when().
				post(path).

				then().
				spec(getResponseSpecefication()).extract().response();
	}



	public static Response Get( String path, String access_token)
	{
		return	
				given(getRequestSpecefication()).
				auth().oauth2(access_token).

				when().get(path).

				then().spec(getResponseSpecefication()).
				extract().response();

	}


	public static Response Update(Object requestPlaylist, String access_token,String path)
	{
		return	
				given(getRequestSpecefication()).
				body(requestPlaylist).
				auth().oauth2(access_token).
				

				when().put(path).

				then().spec(getResponseSpecefication()).extract().response();
    }
	
	public static Response Get(List<String> ids,String access_token,String path)
	{
		return	
				given(getRequestSpecefication()).queryParam("ids", ids).
				auth().oauth2(access_token).

				when().get(path).

				then().spec(getResponseSpecefication()).
				extract().response();
		
	}




}
