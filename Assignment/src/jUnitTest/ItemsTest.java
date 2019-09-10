package jUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import FoodMedicItems.Items;

public class ItemsTest {
	private static Items items;
 
	@BeforeClass
	public static void init() {
		items = new Items("Deluxe Set contains a piece of chicken and a drink that increases hunger by 50, thirst by 50, and it heals by 25. It costs $50.", 50, 50, 25, 50);
	}

	@Test
	public void testGetDesc() {
		assertEquals("Deluxe Set contains a piece of chicken and a drink that increases hunger by 50, thirst by 50, and it heals by 25. It costs $50.", items.getDesc());
	}

	@Test
	public void testGetHunger() {
		assertEquals(50, items.getHunger());
	}

	@Test
	public void testGetThirst() {
		assertEquals(50, items.getThirst());
	}

	@Test
	public void testGetHealth() {
		assertEquals(25, items.getHealth());
	}

	@Test
	public void testGetPrice() {
		assertEquals(50, items.getPrice(), 0.1);
	}

}
