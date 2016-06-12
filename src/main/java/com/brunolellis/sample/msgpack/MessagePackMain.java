package com.brunolellis.sample.msgpack;

import java.util.ResourceBundle;

import org.msgpack.MessagePack;

import com.brunolellis.sample.SampleManager;

public class MessagePackMain {

	public static void main(String[] args) throws Exception {
		SampleManager mgr = new SampleManager();
		System.out.println(mgr.getValue("name"));
		
		
		MessagePack msgpack = new MessagePack();
		msgpack.register(SampleManager.class);
		msgpack.register(ResourceBundle.class);
		
		// Serialize
		byte[] raw = msgpack.write(mgr);

		// Deserialize directly using a template
		SampleManager mgr2 = msgpack.read(raw, SampleManager.class);
		System.out.println(mgr2.getName());
	}

}
