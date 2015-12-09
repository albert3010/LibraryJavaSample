package edu.illinois.cs427.mp3;



import org.junit.Test;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.StringWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CollectionTest {
    
    @Test
    public void testRestoreCollection1() {
        //TODO implement this
    	Collection cs = new Collection("Computer Science");
    	Collection os = new Collection("Operating System");
    	Collection network = new Collection("Networking");
    	Book p_os = new Book("principle of operating system", "Odin");
    	Book p_nw = new Book("principle of networking", "Spider Man");
    	Book p_os2 = new Book("CS:APP", "CMU");
    	Book intro = new Book("Introduction to Computing", "Teacher");
    	
    	network.addElement(p_nw);
    	os.addElement(p_os2);
    	os.addElement(p_os);
    	cs.addElement(intro);
    	cs.addElement(os);
    	cs.addElement(network);
    	
    	String output = cs.getStringRepresentation();
    	//System.out.println(output);
    	
    	Collection newCS = cs.restoreCollection(output);
    	String output2 = newCS.getStringRepresentation();
    	//System.out.println(output2);
    	
    	//System.out.println(newCS.getName()+"/");
    	//System.out.println(cs.getName()+"/");
    	for(Element i: newCS.getElements()){
    		if(i.getClass().toString().contains("Book")){
    			assertTrue( ((Book)i).getTitle().equals("Introduction to Computing")  );
    		}
    	}
    	//assertTrue( newCS.getName().equals("Computer Science"));
    }
    
    @Test
    public void testRestoreCollection2() {
        //TODO implement this
    	Collection cs = new Collection("Computer Science");
    	Collection os = new Collection("Operating System");
    	Collection network = new Collection("Networking");
    	Book p_os = new Book("principle of operating system", "Odin");
    	Book p_nw = new Book("principle of networking", "Spider Man");
    	Book p_os2 = new Book("CS:APP", "CMU");
    	Book intro = new Book("Introduction to Computing", "Teacher");
    	
    	network.addElement(p_nw);
    	os.addElement(p_os2);
    	os.addElement(p_os);
    	cs.addElement(intro);
    	cs.addElement(os);
    	cs.addElement(network);
    	
    	String output = cs.getStringRepresentation();
    	//System.out.println(output);
    	
    	Collection newCS = cs.restoreCollection(output);
    	String output2 = newCS.getStringRepresentation();
    	//System.out.println(output2);
    	
    	//System.out.println(newCS.getName()+"/");
    	//System.out.println(cs.getName()+"/");
    	
    	assertTrue( newCS.getName().equals("Computer Science"));
    }
    
    @Test
    public void testGetStringRepresentation1() {
        //TODO implement this
    	Collection cs = new Collection("Computer Science");
    	Collection os = new Collection("Operating System");
    	Collection network = new Collection("Networking");
    	Book p_os = new Book("principle of operating system", "Odin");
    	Book p_nw = new Book("principle of networking", "Spider Man");
    	Book p_os2 = new Book("CS:APP", "CMU");
    	Book intro = new Book("Introduction to Computing", "Teacher");
    	
    	network.addElement(p_nw);
    	os.addElement(p_os2);
    	os.addElement(p_os);
    	cs.addElement(intro);
    	cs.addElement(os);
    	cs.addElement(network);
    	
    	String output = cs.getStringRepresentation();
    	System.out.println(output);
    	assertTrue(output.contains("\"title\":\"principle of networking\""));
    }
    
    @Test
    public void testAddElement1() {
        //TODO implement this
    	Collection cs = new Collection("Computer Science");
    	Collection os = new Collection("Operating System");
    	Collection network = new Collection("Networking");
    	Book p_os = new Book("principle of operating system", "Odin");
    	Book p_nw = new Book("principle of networking", "Spider Man");
    	Book p_os2 = new Book("CS:APP", "CMU");
    	Book intro = new Book("Introduction to Computing", "Teacher");
    	
    	network.addElement(p_nw);
    	os.addElement(p_os2);
    	os.addElement(p_os);
    	cs.addElement(intro);
    	cs.addElement(os);
    	cs.addElement(network);
    	
    	assertTrue(cs.getElements().contains(os) );
    }
    
    @Test
    public void testAddElement2() {
        //TODO implement this
    	Collection cs = new Collection("Computer Science");
    	Collection os = new Collection("Operating System");
    	Collection network = new Collection("Networking");
    	Book p_os = new Book("principle of operating system", "Odin");
    	Book p_nw = new Book("principle of networking", "Spider Man");
    	Book p_os2 = new Book("CS:APP", "CMU");
    	Book intro = new Book("Introduction to Computing", "Teacher");
    	
    	network.addElement(p_nw);
    	os.addElement(p_os2);
    	os.addElement(p_os);
    	cs.addElement(intro);
    	cs.addElement(os);
    	cs.addElement(network);
    	
    	assertTrue(os.getElements().contains(p_os) );
    }

    @Test
    public void testDeleteElement1() {
        //TODO implement this
    	Collection cs = new Collection("Computer Science");
    	Collection os = new Collection("Operating System");
    	Collection network = new Collection("Networking");
    	Book p_os = new Book("principle of operating system", "Odin");
    	Book p_nw = new Book("principle of networking", "Spider Man");
    	Book p_os2 = new Book("CS:APP", "CMU");
    	Book intro = new Book("Introduction to Computing", "Teacher");
    	
    	network.addElement(p_nw);
    	os.addElement(p_os2);
    	os.addElement(p_os);
    	cs.addElement(intro);
    	cs.addElement(os);
    	cs.addElement(network);
    	
    	cs.deleteElement(p_nw);
    	cs.deleteElement(os);
    	
    	assertTrue(!cs.getElements().contains(os) );
    }
    
    @Test
    public void testFailureForFlaky(){
    	assertTrue(false);
    }
}
