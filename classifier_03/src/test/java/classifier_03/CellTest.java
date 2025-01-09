package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

class CellTest {

	@Test
	void testConstructor() {
		Items items = new Items();
		Cell cell = new Cell("test", items);
		assertNotNull(cell);
	}
	
	@Test
	void testGetCell() {
		Items items = new Items();
		Cell cell = new Cell("test", items);
		assertEquals("test", cell.getCell());
	}
		
	@Test
	void testItem() {
		Items items = new Items();
		Cell cell = new Cell("test", items);
		Item item = new Item("item");
		cell.addItem(item);
		List<Item> list = cell.getItems();
		assertEquals("item", list.get(0).getItem());
	}
	
	@Test
	void testCategory() {
		Items items = new Items();
		Cell cell = new Cell("test", items);
		Item item = new Item("item");
		item.setCategory("category");
		cell.addItem(item);
		List<String> categories = cell.getCategories();
		assertEquals("category", categories.get(0));
	}
	
	@Test
	void testGetCategories() {
		CatFileReader reader = new CatFileReader();
		Items items = reader.readFiles("src/test/resources/categories");
		Cell cell = new Cell("testitem1test", items);
		List<String> list = cell.getCategories();
		assertEquals("Category1", list.get(0));
	}
}
