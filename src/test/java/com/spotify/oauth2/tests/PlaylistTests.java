package com.spotify.oauth2.tests;


import static com.spotify.oauth2.api.AssertError.assertError;
import static com.spotify.oauth2.api.AssertStatusCodes.assertStatusCode;
import static com.spotify.oauth2.api.applicationApi.Assertions.assertPlaylist;
import org.testng.annotations.Test;
import com.spotify.oauth2.api.Route;
import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.PlaylistAPI;
import com.spotify.oauth2.playlistpojo.Error;
import com.spotify.oauth2.playlistpojo.Playlist;
import com.spotify.oauth2.utils.FakerUtils;
import com.spotify.oauth2.utils.PropertyUtils;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;


@Epic("Spotify Oauth 2.0")
@Feature("Playlist API")
public class PlaylistTests extends BaseTest
{
   
	@Story("Create a playlist story")
	@Link("https://example.org")
	@Link(name = "allure", type = "mylink")//If we want to add some other links then we use this annotation
	@Issue("123")// For example if a particular testcase has a defect then if we want to navigate to that defect the allure provide the link for that defect
	@TmsLink("test-1")// This is used for test management system attached with manual test case  
	@Description("This is the testcase for creating the playlist")
	@Test(description = "Should be able to create  playlist",groups ="Playlist")//it is used to show friendly name for a particular testcase 
	public void ShouldBeAbleToCreatePlaylist()
	{
		Playlist requestPlaylist= RequestBuilder(FakerUtils.generate_fakeName(), FakerUtils.generate_fakeDescription(), false);

		String account_id= PropertyUtils.get_instance().getString(Route.ACCOUNT_ID);

		Response response= PlaylistAPI.Post(requestPlaylist,account_id);

		assertStatusCode(response,StatusCode.CODE_201);
		assertPlaylist(response.as(Playlist.class), requestPlaylist);

	}



	@Test(groups ="Playlist")
	public void GetPlaylist()
	{
		Playlist requestPlaylist= RequestBuilder("Pojo playlist", "Framework playlist", true);

		String playlist_id=PropertyUtils.get_instance().getString(Route.PLAYLIST_ID1);


		Response response= PlaylistAPI.Get(playlist_id);

		assertStatusCode(response,StatusCode.CODE_200);
		assertPlaylist(response.as(Playlist.class), requestPlaylist);

	}
	


	@Test(groups ="Playlist")
	public void UpdatePlaylist()
	{

		Playlist requestPlaylist= RequestBuilder(FakerUtils.generate_fakeName(), FakerUtils.generate_fakeDescription(), false);

		String playlist_id=PropertyUtils.get_instance().getString(Route.PLAYLIST_ID);

		Response response= PlaylistAPI.Update(playlist_id,requestPlaylist);

		assertStatusCode(response,StatusCode.CODE_200);

	}


	@Story("Create a playlist story")
	@Test(groups ="Playlist")
	public void ShouldBeAbleToCreatePlaylist_negative_scenario_namemissing()
	{


		Playlist requestPlaylist= RequestBuilder("", FakerUtils.generate_fakeDescription(), false);

		String account_id= PropertyUtils.get_instance().getString(Route.ACCOUNT_ID);;

		Response response= PlaylistAPI.Post(requestPlaylist,account_id);

		assertStatusCode(response,StatusCode.CODE_400);
		assertError(response.as(Error.class), StatusCode.CODE_400);


	}

	@Story("Create a playlist story")
	@Test(groups ="Playlist")
	public void ShouldBeAbleToCreatePlaylist_negative_scenario_expiredtoken()
	{

		Playlist requestPlaylist= RequestBuilder("", "Framework updated playlist", false);

		String invalid_token=FakerUtils.generate_fakeToken();
		String account_id= PropertyUtils.get_instance().getString(Route.ACCOUNT_ID);;

		Response response= PlaylistAPI.Post(invalid_token,requestPlaylist,account_id);

		assertStatusCode(response,StatusCode.CODE_401);
		assertError(response.as(Error.class), StatusCode.CODE_401);		

	}

	@Step
	public  static Playlist RequestBuilder(String name,String Description,boolean _public)
	{
		return  Playlist.builder().
				name(name).                          //Overall its a builder pattern(chaining methods by returning the object in every method)
				description(Description).             //.build() will return the object of the same playlist POJO class. 
				_public(_public).build();


	}



	
}





