package classifier_03;

import java.util.Scanner;

public class Worker {

	public Worker(String file) {
		
		System.out.println("Input column number to scan and hit 'Enter'");
		Scanner reader = new Scanner(System.in);
		int column = reader.nextInt(); 
		reader.close();
		
		// this adds the CSV file to a 2d array
		CSVFileReader csvReader = new CSVFileReader();
		String[][] input = csvReader.readFile(file);
		
		CatFileReader catReader = new CatFileReader();
		Items items = catReader.readFiles("src/test/resources/categories"); // for testing
//		Items items = catReader.readFiles("src/main/resources/categories");
				
		
		
	}

}
