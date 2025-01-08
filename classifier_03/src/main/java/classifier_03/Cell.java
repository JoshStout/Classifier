package classifier_03;

import java.util.ArrayList;
import java.util.List;

public class Cell {

	private String str;
	private List<Item> itemsList;
	private int row;
	
	/**
	 * Represents a cell from the CSV file.
	 * @param str A String representing the contents of the cell.
	 */
	public Cell(String str) {
		this.str = str;
		itemsList = new ArrayList<Item>();
	}
	
	public String getCell() {
		return str;
	}
	
	public void setRow(int row) {
		this.row = row;
	}
	
	public int getRow() {
		return row;
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
	 * Returns a list of Items found within the contents of the Cell object.
	 * @param items An Items object containing all Items that should be 
	 * search for within the Cell object contents.
	 * @return A list of all Items found.
	 */
	public List<Item> containsItems(Items items){
		Item[] arr = items.getItems();
		List<Item> list = new ArrayList<Item>();
		String cellContents = getCell().toLowerCase(); // category files only contain lower case characters
		for(int i = 0; i < arr.length; i++) {
			if(cellContents.contains(arr[i].getItem())) {
				list.add(arr[i]);
				addItem(arr[i]);
			}
		}
		return list;
	}
	
}
