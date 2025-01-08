package classifier_03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class CatFileReader {
	
	private String[] categories;
	private int count;

	public CatFileReader() {
		categories = new String[] {};
		count = 0;
	}
	
	/**
	 * A getter to provide an array of Strings representing 
	 * all the category, which is taken from the filenames
	 * @return An array of Strings representing all the category
	 */
	public String[] getCategories() {
		return categories;
	}
	
	/**
	 * A method to get the number of category found in 
	 * the resources folder
	 * @return A integer representing the number of category
	 */
	public int getCount() {
		return count;
	}
	
	/**
	 * Creates a HashMap where the key is each category and the value are 
	 * initialized to zero.
	 * @return A HashMap of each category and each value is set to 0
	 */
	public HashMap<String, Integer> getMap(){
		HashMap<String, Integer> catMap = new HashMap<>();
		for(int i = 0; i < categories.length; i++) {
			catMap.put(categories[i], 0);
		}
		return catMap;
	}
	
	/**
	 * Iterates through each file saved in
	 * resources/categories folder
	 * and adds each word saved on its own line
	 * as an Item object in an ItemsArray object.
	 * @return An ItemsArray object
	 */
	public Items readFiles(String catFiles) {
		File dir = new File(catFiles);
		File[] directoryListing = dir.listFiles();
		Items itemsArray = new Items();
		if(directoryListing != null) {
			itemsArray = fileIterator(directoryListing);
		} else {
			// handlers here 
		}
		return itemsArray;
	}
	
	/**
	 * Iterates thru each file within the folder as specified
	 * in the readFiles method while adding each filename 
	 * to the HashMap for each category.
	 * @param directoryListing File[] object containing the location of the categories folder
	 * @return An itemsArray object containing all the items found in each categories file
	 */
	private Items fileIterator(File[] directoryListing) {
		Items itemsArray = new Items();
		for(File child : directoryListing) {
			insertCategory(child.getName());
			try {
				Scanner sc = new Scanner(new File(child.toString()));
				sc.useDelimiter("\r\n");
				while(sc.hasNext()){
					Item item = new Item(sc.nextLine());
					item.setCategory(child.getName());
					itemsArray.insert(item);
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return itemsArray;
	}
	
	/**
	 * A helper method to insert each filename into an Array of Strings
	 * @param str An array of Strings containing each category
	 */
	private void insertCategory(String str) {
		if(categories.length == count) {
			String[] newCat = new String[count + 1];
			for(int i = 0; i < count; i++) {
				newCat[i] = categories[i];
			}
			categories = newCat;
		}
		categories[count++] = str;
	}

}
