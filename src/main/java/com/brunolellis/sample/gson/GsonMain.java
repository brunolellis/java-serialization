package com.brunolellis.sample.gson;

import java.util.ResourceBundle;

import com.brunolellis.sample.SampleManager;
import com.google.gson.GsonBuilder;

public class GsonMain {

	public static void main(String[] args) throws Exception {
		SampleManager mgr = new SampleManager();
		System.out.println(mgr.getValue("name"));

		GsonBuilder gb = new GsonBuilder()
				.setExclusionStrategies(new CustomExclusionStrategy(ResourceBundle.class));
		
		GsonParser parser = new GsonParser(gb);
		
		long start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			parser.toJson(mgr);
		}
		long end = System.currentTimeMillis();
		System.out.println("total ms = " + (end - start));
		
		
		String mgrJson = parser.toJson(mgr);
		
		start = System.currentTimeMillis();
		for (int i = 0; i < 1000; i++) {
			parser.fromJson(mgrJson, SampleManager.class);
		}
		end = System.currentTimeMillis();
		System.out.println("total ms = " + (end - start));
		
	}

}
