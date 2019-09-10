package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class shipNameTest {
	private String name;
	@Test
	public void testShipNameIsNotEmpty() {
		name = "Hey";
		assertTrue(Game.shipNameVerification(name));
	}

	@Test
	public void testShipNameIsEmpty() {
		name = "";
		assertFalse(Game.shipNameVerification(name));
	}
}
