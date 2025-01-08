package classifier_03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ItemsTest {

	@Test
	void testConstructor() {
		Items items = new Items();
		assertNotNull(items);
	}
	
	@Test
	void testOne() {
		Item one = new Item("one");
		one.setCategory("a");
		Items items = new Items();
		items.insert(one);
		assertEquals(1, items.getSize());
		Item[] arr = items.getItems();
		assertEquals("one", arr[0].getItem());
		assertEquals("a", arr[0].getCategory());
	}


}
