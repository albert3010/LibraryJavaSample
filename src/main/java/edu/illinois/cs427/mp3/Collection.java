package edu.illinois.cs427.mp3;

import java.util.List;
import java.util.*;

//for JSON
import java.util.LinkedHashMap;
import java.util.LinkedList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.util.Map;

/**
 * Represents a collection of books or (sub)collections.
 */
public final class Collection extends Element {
    List<Element> elements;
    private String name;
    
    /**
     * Creates a new collection with the given name.
     *
     * @param name the name of the collection
     */
    public Collection(String name) {
        // TODO implement this
    	this.name = name;
    	this.elements = new LinkedList<Element>();
    	this.setParentCollection(null);
    	
    }

    /**
     * Restores a collection from its given string representation.
     *
     * @param stringRepresentation the string representation
     */
    public static Collection restoreCollection(String stringRepresentation) {
    	JSONParser parser = new JSONParser();
    	
    	try{
    	    
    		JSONObject obj =(JSONObject) parser.parse(stringRepresentation);
    	    //Set title.
    		Collection coll; 
            if(obj.containsKey("name"))
            	coll = new Collection((String) obj.get("name"));
    	    else
                return null;
            
            //Set authors.
    	    JSONArray subColls = (JSONArray)obj.get("SubColls");
    	    if(subColls.size()!=0){
    	    	for(int i=0; i < subColls.size(); i++){
    	    		JSONObject obji = (JSONObject)subColls.get(i); 
    	    		if(obji.containsKey("name")){
    	    			//String collName = (String) obji.get("name");
    	    			Collection newColl = restoreCollection(obji.toJSONString());
    	    			coll.addElement(newColl);
    	    			//newColl.setParentCollection(coll);
    	    		}
    	    		else if(obji.containsKey("title")){
    	    			Book newBook = new Book(obji.toJSONString());
    	    			coll.addElement(newBook);
    	    			//newBook.setParentCollection(coll);
    	    		}
    	    	}
    	    }
    	    
    	    return coll;
        }
        catch(ParseException pe){
        	return null;
        }	
        
    }

    /**
     * Returns the string representation of a collection. 
     * The string representation should have the name of this collection, 
     * and all elements (books/subcollections) contained in this collection.
     *
     * @return string representation of this collection
     */
    public String getStringRepresentation() {
    	String result = "";
        result+="\"name\":\"";
        result+=this.getName();
        result+="\",";
        
        result+="\"SubColls\":[";
        if(this.elements.size()!=0){
        	int remain = this.elements.size();
        	for(Element i: elements){
        		if(i.getClass().toString().contains("Book")){
        			Book tmpBook = (Book)i;
        			result+=tmpBook.getStringRepresentation();
        		}
        		else{
        			Collection tmpColl = (Collection)i;
        			result+=tmpColl.getStringRepresentation();
        		}
        		remain--;
        		if(remain!=0)
        			result+=",";
        	}
        }
        else{
        	
        }
        result+="]";
        return ("{"+result+"}");
    }

    /**
     * Returns the name of the collection.
     *
     * @return the name
     */
    public String getName() {
        // TODO implement this
        return this.name;
    }
    
    /**
     * Adds an element to the collection.
     * If parentCollection of given element is not null,
     * do not actually add, but just return false.
     * (explanation: if given element is already a part of  
     * another collection, you should have deleted the element 
     * from that collection before adding to another collection)
     *
     * @param element the element to add
     * @return true on success, false on fail
     */
    public boolean addElement(Element element) {
    	// TODO implement this
    	if(element.getParentCollection() != null){
    		return false;
    	}
    	elements.add(element);
    	element.setParentCollection(this);
        return true;
    }
    
    /**
     * Deletes an element from the collection.
     * Returns false if the collection does not have 
     * this element.
     * Hint: Do not forget to clear parentCollection
     * of given element 
     *
     * @param element the element to remove
     * @return true on success, false on fail
     */
    public boolean deleteElement(Element element) {
        // TODO implement this
    	if(elements.contains(element)==false)
    		return false;
    	
    	elements.remove(element);
    	element.setParentCollection(null);
    	return true;
    }
    
    /**
     * Returns the list of elements.
     * 
     * @return the list of elements
     */
    public List<Element> getElements() {
        // TODO implement this
        return elements;
    }
}
