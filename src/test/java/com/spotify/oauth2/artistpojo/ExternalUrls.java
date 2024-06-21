package com.spotify.oauth2.artistpojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Value@Jacksonized@Builder
@Getter@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ExternalUrls {

    @JsonProperty("spotify")
     String spotify;
  

  

}
