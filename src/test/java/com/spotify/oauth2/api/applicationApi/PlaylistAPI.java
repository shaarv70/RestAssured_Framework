	package com.spotify.oauth2.api.applicationApi;



import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.api.Route;
import com.spotify.oauth2.pojo.Playlist;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import com.spotify.oauth2.api.TokenManager;



public class PlaylistAPI {

//	static String  access_token="BQBsC50cjVPpehAthcrvU2hDwNMamQjxi9CDilPnom4IGAa7sCxHQ0j_S3wVDjwroXnmi4_A33gk0X5Y1Vde_B3PXh6f-XHBgv5Jx7iYUeEmSAz-HkEKoZyKwKEcTbN9rbkSBu9PMWK0ILyHEKfh7WamtspittOM-IgKDW8sKYoCbDfqLd2hdD1M5L1b2OOVdtayNE1asXgDyHv60oBodQlPOq9F6WZ1jcwhETPQauWqnCz9yUdTDxlnX66_w6A4Kpgb-KnvqrKH";

    @Step
	public static Response Post(Playlist requestPlaylist, String account_id)
	{
		return RestResource.Post(Route.USERS+account_id+Route.PLAYLISTS, TokenManager.get_token(), requestPlaylist);
		
	
	}


	public static Response Post(String token,Playlist requestPlaylist,String account_id)
	{
		return RestResource.Post(Route.USERS+account_id+Route.PLAYLISTS, token, requestPlaylist);
		
	}



	public static Response Get(String playlist_id)
	{
		return RestResource.Get(Route.PLAYLISTS+"/"+playlist_id,TokenManager.get_token());
		
	}


	public static Response Update(String playlist_id,Playlist requestPlaylist)
	{ 
        return RestResource.Update(requestPlaylist, TokenManager.get_token(), Route.PLAYLISTS+"/"+playlist_id);
		
		
    }

     //just checking thr process


}
