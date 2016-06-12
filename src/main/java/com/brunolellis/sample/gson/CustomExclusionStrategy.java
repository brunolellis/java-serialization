package com.brunolellis.sample.gson;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
 
public class CustomExclusionStrategy implements ExclusionStrategy {
 
    private Class<?> clazzToExclude;

	public CustomExclusionStrategy(Class<?> clazz) {
		this.clazzToExclude = clazz;
	}

	public boolean shouldSkipField(FieldAttributes f) {
//        return (f.getDeclaringClass() == Plane.class && f.getName().equals("cost"));
    	return false;
    }
 
    public boolean shouldSkipClass(Class<?> clazz) {
        return clazz.equals(clazzToExclude);
    }
 
}