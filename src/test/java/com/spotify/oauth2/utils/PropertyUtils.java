package com.spotify.oauth2.utils;

import java.util.Objects;
import java.util.ResourceBundle;

public class PropertyUtils {
	
	public static  ResourceBundle rb;
	
	
 public static ResourceBundle get_instance()
   {
	   if(Objects.isNull(rb))
	   {
		  rb= ResourceBundle.getBundle("config");
	   }
	 return rb;
   }



}

