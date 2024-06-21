package com.spotify.oauth2.api.applicationApi;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.spotify.oauth2.artistpojo.Artist;
import com.spotify.oauth2.playlistpojo.Playlist;

import io.qameta.allure.Step;

public class Assertions {

	
	@Step
	public static void assertPlaylist(Playlist responsePlaylist,Playlist requestPlaylist)
	{
		assertThat(responsePlaylist.getName(), equalTo(requestPlaylist.getName()));
		assertThat(responsePlaylist.getDescription(),equalTo(requestPlaylist.getDescription()));
		assertThat(responsePlaylist.get_public(),equalTo(requestPlaylist.get_public()));
	}
	
	
	
	public static void assertArtist(Artist responseArtist,Artist requestArtist)
	{
		assertThat(responseArtist.getName(), equalTo(requestArtist.getName()));
		assertThat(responseArtist.getPopularity(),equalTo(requestArtist.getPopularity()));
		assertThat(responseArtist.getUri(),equalTo(requestArtist.getUri()));
	}
	

	
}
