package edu.illinois.cs427.mp3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

/**
 * Container class for all the collections (that eventually contain books).
 * Its main responsibility is to save the collections to a file and restore them from a file.
 */
public final class Library {
    private List<Collection> collections;

    /**
     * Builds a new, empty library.
     */
    public Library() {
        // TODO implement this
    	this.collections = new LinkedList<Collection>();
    }

    private void addToLib(Collection coll){
    	//System.out.println(coll.getName());
    	this.collections.add(coll);
    	for(Element i:coll.getElements()){
    		if(i.getClass().toString().contains("Collection")){
    			this.addToLib((Collection)i);
    		}
    	}
    }
    
    /**
     * Builds a new library and restores its contents from the given file.
     *
     * @param fileName the file from where to restore the library.
     */
    public Library(String fileName) {
        // TODO implement this
    	this.collections = new LinkedList<Collection>();
    	
    	String content;
    	try {
			content = new Scanner(new File("lib.txt")).useDelimiter("\\Z").next();
			//System.out.println(content);
			
			Object obj=JSONValue.parse(content);
			JSONArray array=(JSONArray)obj;
			
			for(int i=0; i < array.size(); i++){
				JSONObject obj2 = (JSONObject)array.get(i);
				if(obj2.containsKey("name")){
					Collection coll = null;
					Collection newColl = coll.restoreCollection(obj2.toString());
					this.addToLib(newColl);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    }

    /**
     * Saved the contents of the library to the given file.
         *
     * @param fileName the file where to save the library
     */
    public void saveLibraryToFile(String fileName) {
        // TODO implement this
    	String out = "[";
    	int count = 0;
    	for(Collection i : this.collections){
    		if(i.getParentCollection()==null)
    			count++;
    	}
    	
    	for(Collection i : this.collections){
    		if(i.getParentCollection()==null){
    			//System.out.println(i.getName());
    			out+=i.getStringRepresentation();
    			count--;
    			if(count!=0)
    				out+=",";
    		}
    	}
    	out+="]";
    	//System.out.println("write to file: ");
    	//System.out.println(out);
    	try {
			PrintWriter outFile = new PrintWriter(fileName);
			outFile.println(out);
			outFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
    	
    }

    /**
     * Returns the collections contained in the library.
     *
     * @return library contained elements
     */
    public List<Collection> getCollections() {
        // TODO implement this
        return collections;
    }
}
