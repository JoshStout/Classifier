package classifier_03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileReader {
	
	/**
	 * Reads a CSV file and returns a 2D array.
	 * @param file A String containing the full path and filename of CVS file to scan
	 * @return a 2D array containing all data within the CSV file
	 */
	public String[][] readFile(String file){
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
			List<String[]> dataList = new ArrayList<>();
			String line;
			while((line = br.readLine()) != null) {
				dataList.add(line.split(","));
			}
			return dataList.toArray(new String[0][]);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}
	

}
