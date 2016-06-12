package com.brunolellis.sample.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonParser {
	
	private Gson parser;

	public GsonParser() {
		this(new GsonBuilder());
	}

	public GsonParser(GsonBuilder gsonBuilder) {
		this.parser = gsonBuilder.create();
	}
	
	public <T> T fromJson(String json, Class<T> clazz) {
		return parser.fromJson(json, clazz);
	}
	
	public String toJson(Object src) {
		return parser.toJson(src);
	}
	
}
