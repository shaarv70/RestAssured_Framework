package com.spotify.oauth2.artistpojo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;


@Value
@Getter@Setter
@Jacksonized@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Artist{

    @JsonProperty("external_urls")
    ExternalUrls externalUrls;
    @JsonProperty("followers")
     Followers followers;
    @JsonProperty("genres")
     List<String> genres;
    @JsonProperty("href")
     String href;
    @JsonProperty("id")
     String id;
    @JsonProperty("images")
     List<Image> images;
    @JsonProperty("name")
     String name;
    @JsonProperty("popularity")
     Integer popularity;
    @JsonProperty("type")
     String type;
    @JsonProperty("uri")
     String uri;
 

   
}
