package com.brunolellis.sample.kryo;

import java.io.FileOutputStream;

import com.brunolellis.sample.SampleManager;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Output;

public class KryoMain {

	public static void main(String[] args) throws Exception {
		SampleManager mgr = new SampleManager();
		System.out.println(mgr.getValue("name"));
		
		
		Kryo kryo = new Kryo();
	    Output output = new Output(new FileOutputStream("/tmp/file.bin"));
	    kryo.writeObject(output, mgr);
	    output.close();
	    
	}

}
