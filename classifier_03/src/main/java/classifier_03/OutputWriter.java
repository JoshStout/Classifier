package classifier_03;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class OutputWriter {
	
	private String[][] input;
	private String[][] output;
	private CatFileReader catReader;
	private Items items;
	private int column;
	private HashMap<String, Integer> catMap;
	
	/**
	 * 
	 * @param input
	 * @param catReader
	 */
	public OutputWriter(String[][] input, CatFileReader catReader, Items items, int column) {
		this.input = input;
		this.catReader = catReader;
		this.items = items;
		this.column = column;
		this.catMap = getPrivateMap();
	}
	
	/**
	 * 
	 * @return A 2D array of Strings with newly added columns.
	 * @throws IOException 
	 */
	public String[][] getOutput() throws IOException{
		traverseColumn();
		printOutput();
		System.out.println(getCategoryMap().toString());
		outputCSV();
		return output;
	}
	
	/**
	 * Performs a deep copy of a 2D array and adds columns equal to the number of category files.
	 * It also adds the filenames as headers to the first row.
	 * @return A 2D String of the input with additional columns added, including headers.
	 */
	private String[][] deepCopyCSV(){
		int rows = input.length;
		int cols = input[0].length;
		String[][] newArr = new String[rows][cols + catReader.getCategories().length];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				newArr[i][j] = new String(input[i][j]);
			}
		}
		String[] headers = catReader.getCategories();
		for(int i = 0; i < headers.length; i++) {
			newArr[0][cols + i] = headers[i];
		}
		return newArr;
	}
	
	/**
	 * 
	 */
	private void traverseColumn() {
		output = deepCopyCSV();
		for(int i = 0; i < output.length; i++) {
			Cell cell = new Cell(output[i][column], items);
			List<String> cellCategories = cell.getCategories();
			for(String cat : cellCategories) {
				output[i][input[0].length + getOffset(cat)] = "x";
				catMap.put(cat, catMap.get(cat) + 1);
			}			
		}		
	}
	
	/**
	 * After columns are filled in the output file, the HashMap
	 * will return the total counts for each category.
	 * @return A HashMap containing the sum of each category.
	 */
	public HashMap<String, Integer> getCategoryMap(){
		return catMap;
	}
	
	/**
	 * For tracking how many Items of each category are found.
	 * @return A HashMap where the key == category and value == 0.
	 */
	private HashMap<String, Integer> getPrivateMap(){
		HashMap<String, Integer> map = (HashMap<String, Integer>) catReader.getMap();
		return map;
	}
	
	/**
	 * Determine the column offset to the left based on the category provided.
	 * @param category A String representing the category.
	 * @return a integer indicating how many columns to the left is the category column.
	 */
	private int getOffset(String category) {
		HashMap<String, Integer> offsetMap = getOffsetMap();
		return offsetMap.get(category);
	}
	
	/**
	 * Creates a HashMap of each department and sets the value
	 * to the column offset amount.
	 * @return A HashMap containing offset for each category. The
	 * key == category and the value == the offset amount.
	 */
	private HashMap<String, Integer> getOffsetMap() {
		HashMap<String, Integer> offsetMap = new HashMap<>();
		String[] categories = catReader.getCategories();
		for(int i = 0; i < categories.length; i++) {
			offsetMap.put(categories[i], i);
		}
		return offsetMap;
	}
	
	/**
	 * Prints out the contents of the 2D output array. 
	 * getOutput() method must be run first.
	 */
	private void printOutput() {
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[0].length; j++) {
				System.out.print(output[i][j]);
			}
			System.out.println();
		}	
	}
	
	public void outputCSV() throws IOException {
		FileWriter obj = new FileWriter("src/test/resources/output.csv");
		obj.write(output[1][1]);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[0].length; j++) {
				if(output[i][j] != null) {
					obj.write(output[i][j]);
				}
				obj.write(",");
			}
			obj.write("\n");
		}
		obj.close();
	}

}
