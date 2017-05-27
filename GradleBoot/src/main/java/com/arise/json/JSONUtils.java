package com.arise.json;

import java.io.IOException;
import java.util.List;

import com.arise.model.AreaOfInterest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONUtils {
	
	
	
	public static <T>List<T> parseJsonArray(String in, Class<T> clazz){
		ObjectMapper mapper = new ObjectMapper();
		List<T> myObjects=null;
		try {
			//myObjects = mapper.readValue(in, new TypeReference<List<T>>(){});
			myObjects = mapper.readValue(in, mapper.getTypeFactory().constructCollectionType(List.class, clazz));
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return myObjects;
	}
	
//	public static <T>List<T> parseJsonArray(String in){
//		ObjectMapper mapper = new ObjectMapper();
//		
//		List<T> myObjects=null;
//		try {
//			myObjects = mapper.readValue(in, new TypeReference<List<T>>(){});
//		} catch (JsonParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (JsonMappingException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return myObjects;
//	}
	
	public static void main(String...sherineILoveYou){
		System.out.println("Go go go");
		String evilJson = "[{\"title\":\"hey\"},{\"title\":\"sherine\"},{\"title\":\"beautiful\"}]";
		List<AreaOfInterest> list = parseJsonArray(evilJson, AreaOfInterest.class);
		for(AreaOfInterest area:list){
			System.out.println("show me some love: "+area.getTitle());
		}
	}

}
