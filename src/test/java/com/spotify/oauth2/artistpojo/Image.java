package com.spotify.oauth2.artistpojo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

@Jacksonized@Builder
@Data@Value
@Getter@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Image {

    @JsonProperty("url")
     String url;
    @JsonProperty("height")
     Integer height;
    @JsonProperty("width")
     Integer width;

   
}
