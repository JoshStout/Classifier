package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CSVFileReaderTest {

	@Test
	void testConstructor() {
		CSVFileReader reader = new CSVFileReader();
		assertNotNull(reader);
	}
	
	@Test
	void readFile() {
		CSVFileReader reader = new CSVFileReader();
		String[][] twoD = reader.readFile("src/test/resources/test.csv");
//		for(int i = 0; i < twoD.length; i++) {
//			for(int j = 0; j < 11; j++) {
//				System.out.print(twoD[i][j]);
//				System.out.print(",");
//			}
//			System.out.println();
//		}
	}

}
