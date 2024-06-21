package com.spotify.oauth2.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import com.spotify.oauth2.playlistpojo.Error;

public class AssertError {
	
	
	
	public static void assertError(Error error,StatusCode statuscode)
	{ 
		assertThat(error.getError().getStatus(), equalTo(statuscode.code));
	    assertThat(error.getError().getMessage(),equalTo(statuscode.msg));
	}


}
