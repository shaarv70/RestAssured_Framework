package com.spotify.oauth2.playlistpojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import groovy.transform.builder.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.jackson.Jacksonized;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter@Setter

@Builder
@Jacksonized
public class Error {

@JsonProperty("error")
private InnerError error;


}
