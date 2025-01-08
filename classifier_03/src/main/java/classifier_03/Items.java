package classifier_03;

public class Items {
	
	private Item[] arr;
	private int count;

	public Items() {
		arr = new Item[] {};
		count = 0;
	}
	
	/**
	 * Method adds Item objects to the ItemsArr object
	 * @param element An Item object
	 */
	public void insert(Item element) {
		if(arr.length == count) {
			Item[] newArr = new Item[count + 1];
			for(int i = 0; i < count; i++) {
				newArr[i] = arr[i];
			}
			arr = newArr;
		}
		arr[count++] = element;
	}
	
	/**
	 * A getter to return the number of Item objects stored 
	 * in the ItemsArr object
	 * @return An integer representing the number of Items in the ItemArr objects
	 */
	public int getSize() {
		return count;
	}
	
	/**
	 * A method to get the current Items saved in the ItemsArr object
	 * @return An array of Item objects
	 */
	public Item[] getItems() {
		return arr;
	}
	
	/**
	 * Prints out the current contents stored in the ItemsArr
	 */
	public void printItems() {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i].getItem());
			System.out.println(arr[i].getCategory());
		}
	}
	
}
