package edu.illinois.cs427.mp3;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Random;
import java.util.*;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;
public class BookTest {
    /**
     * Tests default constructor Book(String t, String a).
     */

    Random rand = new Random();;

    @Test
    public void testBookConstructor1() {
        //TODO implement this
    	Book b = new Book("Data Mining", "Han");
    	assertTrue(b.getTitle() == "Data Mining");
    	assertTrue(b.getAuthor() == "Han");
		
    }

    /**
     * Tests Book(String s ) constructor
     * Book with only one author.
     */
    @Test
    public void testBookConstructor2() {
    	String s = "{\"title\":\"Data\", \"authors\":[\"Han\"]}";
        Book b = new Book(s);
    	assertTrue(b.getTitle().equals("Data"));	
    	assertTrue(b.getAuthor().equals("Han"));
    }

    /**
     * Tests Book(String s ) constructor
     * Book with more authors.
     */
    @Test
    public void testBookConstructor3() {
        String s = "{\"title\":\"Data\", \"authors\":[\"Han\", \"Zhai\", \"John\"]}";
        Book b = new Book(s);
        assertTrue(b.getTitle().equals("Data"));    
        assertTrue(b.getAuthor().equals("Han;Zhai;John"));
    }

    /**
     * Tests Book(String s) constructor with multiple authors.
     */
    @Test
    public void testBookConstructor4(){
        String s = "{\"title\":\"Data\", \"authors\":[\"Han\", \"Zhai\"]}";
        Book b = new Book(s);
        assertTrue(b.getTitle().equals("Data"));
        assertTrue(b.getAuthor().equals("Han;Zhai"));
    }

    /**
     * Tests GetStringRepresentation.
     */
    @Test
    public void testGetStringRepresentation1() {
        //TODO implement this
        System.out.println("testGetStringRepresentation1----------------------");
        Book b = new Book("NLP", "John;Will");
        System.out.println(b.getStringRepresentation());
        System.out.println("compared to:"+"{\"title\":\"NLP\", \"authors\":[\"John\", \"Will\"]}");
        String s = b.getStringRepresentation();
        assertTrue(s.equals("{\"title\":\"NLP\", \"authors\":[\"John\", \"Will\"]}"));
        System.out.println("-----------");
        
    }

    /**
     * Tests GetStringRepresentation.
     */
    @Test
    public void testGetStringRepresentation2() {
        
        Book b = new Book("NLP", "John;Will");
        //System.out.println(b.getStringRepresentation());
        String s = b.getStringRepresentation();
        
        Book b2 = new Book(s);
        assertTrue(b.getTitle().equals(b2.getTitle()));
        assertTrue(b.getAuthor().equals(b2.getAuthor()));
    }


    @Test
    public void testGetContainingCollections1() {
        //TODO implement this
        String s = "{\"title\":\"Data\", \"authors\":[\"Han\", \"Zhai\"]}";
        Book b = new Book(s);
        b.setParentCollection(new Collection("CS"));
        ArrayList<Collection> collections = (ArrayList<Collection>) b.getContainingCollections();
        for(Collection c: collections){
            assertTrue(c.getName().equals("CS"));
            assertFalse(c.getName().equals("C"));
        }

    }

    @Test
    public void testGetContainingCollections2() {
        //TODO implement this
        String s = "{\"title\":\"Data\", \"authors\":[\"Han\", \"Zhai\"]}";
        Book b = new Book(s);
        Collection cs_collect = new Collection("CS");
        cs_collect.setParentCollection(new Collection("Engineering"));
        b.setParentCollection(cs_collect);
        System.out.println(b.getContainingCollections());
        ArrayList<Collection> cont_collectn = (ArrayList<Collection>) b.getContainingCollections();
        assertTrue(cont_collectn.get(0).getName().equals("CS"));
        assertTrue(cont_collectn.get(1).getName().equals("Engineering"));
    }

    @Test
    public void flakyTest1() {
        //TODO implement this
        int randomNum = rand.nextInt(100);
        System.out.println(randomNum);
        assertTrue(randomNum > 50);
    }
    
    @Test
    public void flakyTest2() {
        //TODO implement this
        int randomNum = rand.nextInt(100);
        System.out.println(randomNum);
        assertTrue(randomNum > 50);
    }
    
    @Test
    public void flakyTest3() {
        //TODO implement this
        int randomNum = rand.nextInt(100);
        System.out.println(randomNum);
        assertTrue(randomNum > 50);
    }
    
    @Test
    public void flakyTest4() {
        //TODO implement this
        int randomNum = rand.nextInt(100);
        System.out.println(randomNum);
        assertTrue(randomNum > 50);
    }

    @Test
    public void failTest() {
        //TODO implement this
        assertTrue(false);
    }
}
