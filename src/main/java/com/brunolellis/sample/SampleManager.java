package com.brunolellis.sample;

import java.util.Locale;
import java.util.ResourceBundle;

public class SampleManager {
	
	private ResourceBundle bundle;
	
	private String name;
	
	public SampleManager() {
		System.out.println("SampleManager constructor");
		bundle = ResourceBundle.getBundle("messages", Locale.ENGLISH);
		name = bundle.getString("name");
	}
	
	public String getName() {
		return name;
	}

	public String getValue(String key) {
		return bundle.getString(key);
	}
	
}
