package com.spotify.oauth2.utils;

import com.github.javafaker.Faker;

public class FakerUtils {

	
	public static String generate_fakeName()
	{
		Faker faker= new Faker();
		return "Playlist"+faker.regexify("[A-Za-z0-9,_-]{20}");
	}
	
	public static String generate_fakeDescription()
	{
		Faker faker= new Faker();
		return "Description"+faker.regexify("[A-Za-z0-9,&.@/_-]{40}");
	}

	public static String generate_fakeToken()
	{
		Faker faker= new Faker();
		return "Description"+faker.regexify("[A-Za-z0-9]{5}");
	}




}
