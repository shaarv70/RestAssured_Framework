
package com.spotify.oauth2.playlistpojo;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;


@Data   // - this annotation of lombok will provide some useful methods on its own including getter and setter
@Getter @Setter//This will replace all getter and setter  methods
@Value   //with this annotation we dont need to use private  with the variables            
@Jacksonized  
@Builder      // This will enable us to use the builder pattern(method chaining ) in Playlisttest in request playlist but this will not    
              //recognize the jackson annotations, so to make it recognize we will use @Jacksonized                          
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Playlist {

    @JsonProperty("collaborative")
     Boolean collaborative;
    @JsonProperty("description")
     String description;
    @JsonProperty("external_urls")
     ExternalUrls externalUrls;
    @JsonProperty("followers")
     Followers followers;
    @JsonProperty("href")
     String href;
    @JsonProperty("id")
     String id;
    @JsonProperty("images")
     List<Object> images;
    @JsonProperty("name")
     String name;
    @JsonProperty("owner")
     Owner owner;
    @JsonProperty("primary_color")
     Object primaryColor;
    @JsonProperty("public")
     Boolean _public;
    @JsonProperty("snapshot_id")
     String snapshotId;
    @JsonProperty("tracks")
     Tracks tracks;
    @JsonProperty("type")
     String type;
    @JsonProperty("uri")
     String uri;

  
}
