package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FileWriterTest {

	@Test
	void test() {
		
		CSVFileReader csvReader = new CSVFileReader();
		String[][] input = csvReader.readFile("src/test/resources/test.csv");
		
		// this reads each department file and adds each item to an array
		CatFileReader catReader = new CatFileReader();
		Items items = catReader.readFiles("src/test/resources/categories"); 
		
		FileWriter writer = new FileWriter(input, catReader, items, 4);
		writer.getOutput(); // need to run before it can printOutput
		writer.printOutput(); 
		System.out.println(writer.getCategoryMap().toString());
		
	}

}
