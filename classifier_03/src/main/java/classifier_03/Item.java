package classifier_03;

public class Item {

	private String item;
	private String cat;
	
	/**
	 * Represents an Item contain in one of the files under
	 * resources/categories.
	 * @param item
	 */
	public Item(String item) {
		this.item = item;
	}
	
	public String getItem() {
		return item;
	}

	public String getCategory() {
		return cat;
	}
	
	public void setCategory(String cat) {
		this.cat = cat;
	}

}
