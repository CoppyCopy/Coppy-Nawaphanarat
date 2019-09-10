package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class BalAndItemsCheckTest {
	@BeforeEach
	public void reset() {
		Game.updateMoney(100.0);
		Game.getCrewType().clear();
		Game.getCrewItems().clear();
	}
	@Test
	public void checkMoney() {
		assertEquals(100.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testMaximumCapacityInventory() {
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		Game.getCrewItems().add("Beef Jerky");
		assertFalse(Game.checkBalanceAndItems(Game.getMoney(), "Beef Jerky"));
	}
	
	@Test
	public void testBuyDeluxSetWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Deluxe Set"));
		assertEquals(55.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyDeluxeSetWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Deluxe Set"));
		assertEquals(50.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyBeefJerkyWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Beef Jerky"));
		assertEquals(95.5, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyBeefJerkyWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Beef Jerky"));
		assertEquals(95.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyFrenchFriesWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "French Fries"));
		assertEquals(91.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyFrenchFriesWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "French Fries"));
		assertEquals(90.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyFruitPunchWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Fruit Punch"));
		assertEquals(95.5, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyFruitPunchWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Fruit Punch"));
		assertEquals(95.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuySteakSetWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Steak Set"));
		assertEquals(55.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuySteakSetWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Steak Set"));
		assertEquals(50.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuySpicyWaterWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Spicy Water"));
		assertEquals(95.5, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuySpicyWaterWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Spicy Water"));
		assertEquals(95.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyHiRecoveryWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Hi-Recovery"));
		assertEquals(55.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyHiRecoveryWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Hi-Recovery"));
		assertEquals(50.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyRecoveryWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Recovery"));
		assertEquals(73.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyRecoveryWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Recovery"));
		assertEquals(70.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void testBuyAntiPlagueWithBarterer() {
		Game.getCrewType().add("Barterer");
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Anti-Plague"));
		assertEquals(82.0, Game.getMoney(), 0.1);
	}
	
	@Test
	public void TestBuyAntiPlagueWithoutBarterer() {
		assertTrue(Game.checkBalanceAndItems(Game.getMoney(), "Anti-Plague"));
		assertEquals(80.0, Game.getMoney(), 0.1);
	}
}
