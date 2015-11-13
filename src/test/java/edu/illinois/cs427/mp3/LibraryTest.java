package edu.illinois.cs427.mp3;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.Test;

public class LibraryTest {
    @Test
	public void testLibraryConstructorFromFile1() {
        //TODO implement this
		Library lib = new Library("lib.txt");
    	boolean goodLib = false;
    	for(Collection i:lib.getCollections()){
    		if(i.getName().equals("Networking"))
    			goodLib = true;
    	}
		assertTrue(goodLib);
    }

    @Test
    public void testSaveLibraryToFile1() {
        //TODO implement this
    	Library lib = new Library("lib.txt");
    	lib.saveLibraryToFile("output.txt");
    	String content = null;
    	try {
			content = new Scanner(new File("output.txt")).useDelimiter("\\Z").next();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	assertTrue(content.contains("Russian"));
    }
}
