package edu.illinois.cs427.mp3;

import java.util.List;
import java.util.*;
import java.util.Iterator;
import org.json.simple.JSONObject;
import org.json.simple.JSONArray;
import org.json.simple.parser.ParseException;
import org.json.simple.parser.JSONParser;

/**
 * This class contains the information needed to represent a book.
 * StringRepresentation format: Two keys: title and authors. One space after a commma.
 * {"title":"Data Mining", "authors":["Han", "Zhai"]}
 */
public final class Book extends Element {
    private String title;
    private String author;//Different authors separated by ;(semicolon).

    /**
     * Builds a book with the given title and author.
     *
     * @param title the title of the book
     * @param author the author of the book
     */
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.setParentCollection(null); //Not necessary. By default, uninitialized object is set to null.
    }

    /**
     * Builds a book from the string representation, 
     * which contains the title and author of the book. 
     * @param stringRepresentation the string representation
     */
    public Book(String stringRepresentation) {
        JSONParser parser = new JSONParser();
    	try{
    	    JSONObject book_json_obj =(JSONObject) parser.parse(stringRepresentation);
            //Set title.
            if(book_json_obj.containsKey("title"))
    	    	this.title = (String) book_json_obj.get("title");
    	    else
                this.title = "none";
            //System.out.println(title);
            //Set authors.
    	    JSONArray authors = (JSONArray)book_json_obj.get("authors");
    	    //System.out.println("size of authors:"+authors.size());
    	    this.author = arrayToString(authors);
    	    //System.out.println("Author is :"+this.author);
            this.setParentCollection(null);
        }
        catch(ParseException pe){
            
            this.title = "none";
            this.author = "none";
            this.setParentCollection(null);
        }	
    }

    /**
     * Returns the string representation of the given book.
     * The representation contains the title and author of the book.
     *
     * @return the string representation
     */
    public String getStringRepresentation() {
        
    	String[] authors = this.author.split(";");
        String authors_list = "";
    	for(String a: authors){
    	    authors_list += "\""+ a.trim() + "\", " ;//trim() to remove leading and trailing whitespaces.
    	}
    	if(!authors_list.isEmpty())//Remove trailing comma and space.
    	    authors_list = authors_list.substring(0, authors_list.length()-2);
    	authors_list = "[" + authors_list + "]";
        return "{\"title\":\""+this.title+"\", \"authors\":"+authors_list +"}";
    }

    /**
     * Returns all the collections that this book belongs to directly and indirectly.
     * Consider the following. 
     * (1) Computer Science is a collection. 
     * (2) Operating Systems is a collection under Computer Science. 
     * (3) The Linux Kernel is a book under Operating System collection. 
     * Then, getContainingCollections method for The Linux Kernel should return a list 
     * of these two collections (Operating Systems, Computer Science), starting from 
     * the direct collection to more indirect collections.
     *
     * @return the list of collections
     */
    public List<Collection> getContainingCollections() {
        
        List<Collection> c = new ArrayList<Collection>();
        Collection p = this.getParentCollection();
        //Assume a book without parent collection has parentCollenction == null.
    	while(p != null){
    	    c.add(p);
            p = p.getParentCollection();
    	}
        return c;
    }

    /**
     * Returns the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        // TODO implement this
        return title;
    }

    /**
     * Returns the author of the book.
     *
     * @return the author
     */
    public String getAuthor() {
        // TODO implement this
        return author;
    }


    /**
     * Joins a JSONArray to a string delimited by ; (semicolon)
     * @param the array
     * @return a string
     */ 
    private String arrayToString(JSONArray a){
        String result = "";
        Iterator<String> iterator = a.iterator();
     	while (iterator.hasNext()){
    	    String author_name = iterator.next();
    	    //System.out.println(author_name);
    	    if(!author_name.isEmpty())
    	        result += author_name.trim() +";"; //trim() to remove leading and trailing whitespaces.
    	}
    	if(!result.isEmpty())
    	    result = result.substring(0, result.length()-1);//remove trailing semicolon.
    	return result;
    }
}
