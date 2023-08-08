package spotify.oauth2.tests;


import static org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*; 
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PlaylistTests {

	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;
	@BeforeClass
	public void beforeClass()
	{


		String access_token="BQBZX-4c0xXIsJVJ_wxULNUPPx6JVKupbtJd690ZkbbBZj5aWrv0E3J06N5VTJ0_CNtyNHgYzV9ufUGLKS1Qw-4YUeO4U5TqvkjtDKTKJVVi2ygKWV4fV3bOYQviNSb4GbHlkkNnF3qyqGb-Y5Zl3nrHIAIguXTEy6l-GjLbNqWrX_lKW0OW2Iyg9T5mDsnciurQ75-EprQ_H1bL60rXU39MYHHu2Q5dFBJsOSLOl-LOlbqyKEr83YWgnveNVoTeVfrqMdzymtj1";

		RequestSpecBuilder requestspecbuilder = new RequestSpecBuilder();
		requestspecbuilder.setBaseUri("https://api.spotify.com");
		requestspecbuilder.setBasePath("/v1");
		requestspecbuilder.log(LogDetail.ALL);
		requestspecbuilder.addHeader("Content-Type","application/json;charset=utf-8");
		requestspecbuilder.addHeader("Authorization", "Bearer "+access_token);
		requestSpecification = requestspecbuilder.build(); 


		ResponseSpecBuilder responsespecbuilder= new ResponseSpecBuilder();
		responsespecbuilder.log(LogDetail.ALL);
		
	//	responsespecbuilder.expectContentType(ContentType.JSON);
		responseSpecification = responsespecbuilder.build();
	}




	@Test
	public void ShouldBeAbleToCreatePlaylist()
	{
		String payload= "{\r\n"
				+ "   \"name\": \"My Playlist1\",\r\n"
				+ "    \"description\": \"ResAssured Playlist1\",\r\n"
				+ "    \"public\": false\r\n"
				+ "\r\n"
				+ "}";
		String account_Id="h9x04fizo1rcd86beet3hm8yd";


		given(requestSpecification).
		body(payload).pathParam("id",account_Id).

		when().post("/users/{id}/playlists").

		then().spec(responseSpecification).
		assertThat().statusCode(201).
		body("name", equalTo("My Playlist1"),
				"description", equalTo("ResAssured Playlist1"),
				"public", equalTo(false));
	}



@Test
public void GetPlaylist()
{

	String playlist_id="1k13LGKEjuQrEDsUP4WE2b";


	given(requestSpecification).
	pathParam("id",playlist_id).

	when().get("/playlists/{id}").

	then().spec(responseSpecification).
	assertThat().statusCode(200).
	body("name", equalTo("My Playlist1"),
			"description", equalTo("ResAssured Playlist1"),
			"public", equalTo(false));
}


    
@Test
public void UpdatePlaylist()
{
     String payload= "{\r\n"
			+ "    \"name\": \"My updated playlist\",\r\n"
			+ "    \"description\": \"RestAssured updated playlist\",\r\n"
			+ "    \"public\": false\r\n"
			+ "}";
	
	String playlist_id="1k13LGKEjuQrEDsUP4WE2b";


	given(requestSpecification).
	body(payload).pathParam("id",playlist_id).

	when().put("/playlists/{id}").

	then().spec(responseSpecification).
	assertThat().
	statusCode(200).
	
	body("name", equalTo("My updated playlist"),
			"description", equalTo("RestAssured updated playlist"),
			"public", equalTo(false));
}

    
 
@Test
public void ShouldBeAbleToCreatePlaylist_negative_scenario_namemissing()
{
	String payload= "{\r\n"
			+ "   \"name\": \"\",\r\n"
			+ "    \"description\": \"ResAssured Playlist1\",\r\n"
			+ "    \"public\": false\r\n"
			+ "\r\n"
			+ "}";
	String account_Id="h9x04fizo1rcd86beet3hm8yd";


	given(requestSpecification).
	body(payload).pathParam("id",account_Id).

	when().post("/users/{id}/playlists").

	then().spec(responseSpecification).
	assertThat().statusCode(400).
	body(
			"error.status", equalTo(400),
			"error.message", equalTo("Missing required field: name"));
}


@Test
public void ShouldBeAbleToCreatePlaylist_negative_scenario_expiredtoken()
{
	String payload= "{\r\n"
			+ "   \"name\": \"My Playlist1\",\r\n"
			+ "    \"description\": \"ResAssured Playlist1\",\r\n"
			+ "    \"public\": false\r\n"
			+ "\r\n"
			+ "}";
	String account_Id="h9x04fizo1rcd86beet3hm8yd";


	given().baseUri("https://api.spotify.com").
	basePath("/v1").
	header("Content-Type","application/json;charset=utf-8").
	header("Authorization", "Bearer "+"1234").
	body(payload).pathParam("id",account_Id).

	when().post("/users/{id}/playlists").

	then().spec(responseSpecification).
	assertThat().statusCode(401).
	body(
			"error.status", equalTo(401),
			"error.message", equalTo("Invalid access token"));
}




}





