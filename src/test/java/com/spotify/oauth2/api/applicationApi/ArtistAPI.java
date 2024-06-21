package com.spotify.oauth2.api.applicationApi;

import java.util.List;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.api.Route;
import com.spotify.oauth2.api.TokenManager;

import io.restassured.response.Response;

public class ArtistAPI {
	
	
	public static Response getResponse(String artist_ID) {
		
		
		return RestResource.Get(Route.ARTISTS+"/"+artist_ID, TokenManager.get_token());
		
		
	}
	
     public static Response getResponse(List<String> ids) {
		
		
		return RestResource.Get(ids, TokenManager.get_token(),Route.ARTISTS+"/");
		
		
	}

}
