package com.spotify.oauth2.tests;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.Test;
import com.spotify.oauth2.api.AssertStatusCodes;
import com.spotify.oauth2.api.Route;
import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.ArtistAPI;
import com.spotify.oauth2.api.applicationApi.Assertions;
import com.spotify.oauth2.artistpojo.Artist;
import com.spotify.oauth2.utils.PropertyUtils;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.restassured.response.Response;

@Epic("Spotify Oauth 2.0")
@Feature("Artist API")
public class ArtistTests extends BaseTest {

    
	@Test
	public void getArtist()
	{
        Artist requestArtist= requestBuilder("Jeet Gannguli",63,"spotify:artist:2kkQthS9OLpK4UqNWYqoVl");
		String artist_ID=PropertyUtils.get_instance().getString(Route.ARTIST_ID);
		Response res=ArtistAPI.getResponse(artist_ID);
	    Assertions.assertArtist(res.as(Artist.class), requestArtist);
		AssertStatusCodes.assertStatusCode(res, StatusCode.CODE_200);
	}
	
	@Test
	public void getSeveralArtists()
	{
		List<String> ids= new ArrayList<String>();
		ids.add(PropertyUtils.get_instance().getString(Route.ARTIST_ID1));
		ids.add(PropertyUtils.get_instance().getString(Route.ARTIST_ID2));
		
		Response res= ArtistAPI.getResponse(ids);
		AssertStatusCodes.assertStatusCode(res, StatusCode.CODE_200);
	}
	
	
	
	

    @Step
	public static Artist requestBuilder(String name,int popularity,String uri)
	{
		return  Artist.builder().
				name(name).
				popularity(popularity).uri(uri).
				build();
	}






}
