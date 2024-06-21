package com.spotify.oauth2.api;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import io.qameta.allure.Step;
import io.restassured.response.Response;

public class AssertStatusCodes {



	@Step
	public static void assertStatusCode(Response response,StatusCode statuscode)
	{
		assertThat(response.statusCode(),equalTo(statuscode.code));
	}


}
