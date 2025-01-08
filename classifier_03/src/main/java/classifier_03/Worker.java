package classifier_03;

import java.util.HashMap;
import java.util.Scanner;

public class Worker {

	public Worker(String file) {
		
		System.out.println("Input which column to search and hit 'Enter'");
		Scanner reader = new Scanner(System.in);
		int column = reader.nextInt(); 
		reader.close();
		
		// this adds the CSV file to a 2d array
		CSVFileReader csvReader = new CSVFileReader();
		String[][] input = csvReader.readFile(file);
		
		// this reads each department file and adds each item to an array
		CatFileReader catReader = new CatFileReader();
		Items items = catReader.readFiles("src/test/resources/categories"); // for testing
//		Items items = catReader.readFiles("src/main/resources/categories");
				
		
		
	}

}
