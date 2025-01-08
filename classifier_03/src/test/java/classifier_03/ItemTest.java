package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemTest {

	@Test
	void testConstructor() {
		Item item = new Item("test");
		assertNotNull(item);
	}
	
	@Test
	void testGetItem() {
		Item item = new Item("test");
		assertEquals("test", item.getItem());
	}
	
	@Test
	void testCategory() {
		Item item = new Item("test");
		item.setCategory("category");
		assertEquals("category", item.getCategory());
	}

}
