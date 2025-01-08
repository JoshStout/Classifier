package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	void testConstructor() {
		Cell cell = new Cell("test");
		assertNotNull(cell);
	}
	
	@Test
	void testGetCell() {
		Cell cell = new Cell("test");
		assertEquals("test", cell.getCell());
	}
	
	@Test
	void testRow() {
		Cell cell = new Cell("test");
		cell.setRow(2);
		assertEquals(2, cell.getRow());
	}
	
	@Test
	void testItem() {
		Cell cell = new Cell("test");
		Item item = new Item("item");
		cell.addItem(item);
		List<Item> list = cell.getItems();
		assertEquals("item", list.get(0).getItem());
	}
	
	@Test
	void testCategory() {
		Cell cell = new Cell("test");
		Item item = new Item("item");
		item.setCategory("category");
		cell.addItem(item);
		List<String> categories = cell.getCategories();
		assertEquals("category", categories.get(0));
	}

	@Test
	void testContainsItems() {
		Cell cell1 = new Cell("testitem1test");
		Cell cell2 = new Cell("testitemtest");
		CatFileReader reader = new CatFileReader();
		Items items = reader.readFiles("src/test/resources/categories");
		List<Item> list1 = cell1.containsItems(items);
		List<Item> list2 = cell2.containsItems(items);
		assertEquals("item1", list1.get(0).getItem());
		assertNotEquals("item", list1.get(0).getItem());
		assertTrue(list2.isEmpty());
	}
	
	@Test
	void testGetCategoriesTwo() {
		Cell cell = new Cell("testitem1test");
		CatFileReader reader = new CatFileReader();
		Items items = reader.readFiles("src/test/resources/categories");
		cell.containsItems(items);
		List<String> list = cell.getCategories();
		assertEquals("Category1", list.get(0));
	}
}
