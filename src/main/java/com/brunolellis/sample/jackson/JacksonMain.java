package com.brunolellis.sample.jackson;

import java.io.File;

import com.brunolellis.sample.SampleManager;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

public class JacksonMain {

	public static void main(String[] args) throws Exception {
		SampleManager mgr = new SampleManager();
		System.out.println(mgr.getValue("name"));
		
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(mapper.getSerializationConfig().getDefaultVisibilityChecker()
                .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
		
	    mapper.addMixIn(SampleManager.class, SampleManagerMixin.class);
		
	    FilterProvider filterProvider = new SimpleFilterProvider()
	      .addFilter("SampleManagerMixinFilter", SimpleBeanPropertyFilter.serializeAllExcept("bundle"));
	    mapper.setFilterProvider(filterProvider);
	    
//	    mapper.enableDefaultTyping(); // polymorphic -> save concrete class
	    
		String jsonFile = "/tmp/samplemanager.jackson.json";
		mapper.writeValue(new File(jsonFile), mgr);
	    
		SampleManager mgr2 = mapper.readValue(new File(jsonFile), SampleManager.class);
		System.out.println(mgr2.getName());
	}

}
