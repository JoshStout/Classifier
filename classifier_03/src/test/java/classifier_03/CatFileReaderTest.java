package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

class CatFileReaderTest {

	@Test
	void testConstructor() {
		CatFileReader reader = new CatFileReader();
		assertNotNull(reader);
	}

	@Test
	void testPrintFiles() {
		CatFileReader reader = new CatFileReader();
		Items items = reader.readFiles("src/test/resources/categories");
		assertNotNull(items);
//		items.printItems();
	}
	
	@Test
	void testGetDepts() {
		CatFileReader reader = new CatFileReader();
		reader.readFiles("src/test/resources/categories");
		String[] depts = new String[reader.getCount()];
		depts = reader.getCategories();
		assertEquals("Category1", depts[0]);
		assertEquals("Category2", depts[1]);
		assertEquals("Category3", depts[2]);
		
	}
	
	@Test
	void testGetDeptMap() {
		CatFileReader reader = new CatFileReader();
		reader.readFiles("src/test/resources/categories");
		HashMap<String, Integer> map = new HashMap<>();
		map = reader.getMap();
		assertEquals(0, map.get("Category2"));
		assertNotEquals(1, map.get("Category1"));
	}
	

}
