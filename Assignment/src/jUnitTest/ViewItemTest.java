package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class ViewItemTest {

	@Test
	public void testBeefJerkyContent() {
		assertTrue(Game.viewItem("Beef Jerky"));
	}
	
	@Test
	public void testFrenchFriesContent() {
		assertTrue(Game.viewItem("French Fries"));
	}
	
	@Test
	public void testDeluxeSetContent() {
		assertTrue(Game.viewItem("Deluxe Set"));
	}
	
	@Test
	public void testSteakSetContent() {
		assertTrue(Game.viewItem("Steak Set"));
	}
	
	@Test
	public void testSpicyWaterContent() {
		assertTrue(Game.viewItem("Spicy Water"));
	}
	
	@Test
	public void testFruitPunchContent() {
		assertTrue(Game.viewItem("Fruit Punch"));
	}
	
	@Test
	public void testRecoveryContent() {
		assertTrue(Game.viewItem("Recovery"));
	}
	
	@Test
	public void testHiRecoveryContent() {
		assertTrue(Game.viewItem("Hi-Recovery"));
	}
	
	@Test
	public void testAntiPlagueContent() {
		assertTrue(Game.viewItem("Anti-Plague"));
	}
	
	@Test
	public void testNonContent() {
		assertFalse(Game.viewItem("Nothing"));
	}

}
