package classifier_03;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private String str;
	private List<Item> itemsList;
	
	/**
	 * Represents a cell from the CSV file.
	 * @param str A String representing the contents of the cell.
	 */
	public Cell(String str, Items items) {
		itemsList = new ArrayList<Item>();
		this.str = str;
		containsItems(items);
	}
	
	public String getCell() {
		return str;
	}
		
	/**
	 * Add an Item object to Cell object.
	 * @param item An Item found within the Cell's contents
	 */
	public void addItem(Item item) {
		itemsList.add(item);
	}
		
	/**
	 * Returns a list containing all Item objects found within the cell.
	 * @return An List of items.
	 */
	public List<Item> getItems(){
		return itemsList;
	}
	
	/**
	 * Returns a List containing all categories of Items found in cell.
	 * @return A List object of categories.
	 */
	public List<String> getCategories(){
		List<String> categories = new ArrayList<String>();
		for(Item itm : itemsList) {
			categories.add(itm.getCategory());
		}
		return categories;
	}
	
	/**
	 * Called by the constructor, it iterates through each item
	 * and searches if it is contained within the cell's String contents. If 
	 * item is found, the item is added to at List, which can be retrieved with 
	 * the getItems method.
	 * adds it to a List.
	 * @param items Items object containing all items to search for.
	 */
	private void containsItems(Items items){
		Item[] arr = items.getItems();
		String cellContents = getCell().toLowerCase(); // category files only contain lower case characters
		for(int i = 0; i < arr.length; i++) {
			if(cellContents.contains(arr[i].getItem())) {
				addItem(arr[i]);
			}
		}
	}
	
}
