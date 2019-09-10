package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class FeedTest {

	@BeforeEach
	public void reset() {
		Game.getCrewAction().clear();
		Game.getCrewHunger().clear();
		Game.getCrewThirst().clear();
		Game.getCrewHealth().clear();
		Game.getCrewStatus().clear();
		Game.getCrewName().clear();
	}
	
	@Test
	public void testActionTaken() { 
		Game.getCrewAction().add(1);
		Game.getCrewHealth().add(100);
		Game.getCrewThirst().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Beef Jerky", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testEatingJerkyWithFullHungerAndHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Beef Jerky", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testEatingJerkyWithLowerHungerAndHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(92);
		Game.getCrewHunger().add(85);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Beef Jerky", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(97), Game.getCrewHealth().get(0));
		assertEquals(Integer.valueOf(95), Game.getCrewHunger().get(0));
	}
	
	@Test
	public void testEatingJerkyWithOverLimitedHealthAndHunger() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(97);
		Game.getCrewHunger().add(97); 
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Beef Jerky", Game.getCrewName().get(0))); // This should gives 102 after eaten a jerky then set to 100
		assertEquals(Integer.valueOf(100), Game.getCrewHunger().get(0));
		assertEquals(Integer.valueOf(100), Game.getCrewHealth().get(0));
	}
	
	@Test
	public void testEatingDeluxeSetWithLowerHealthHungerAndThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(60);
		Game.getCrewHunger().add(29);
		Game.getCrewThirst().add(49);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Deluxe Set", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(79), Game.getCrewHunger().get(0));
		assertEquals(Integer.valueOf(85), Game.getCrewHealth().get(0));
		assertEquals(Integer.valueOf(99), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testEatingDeluxeSetWithFullHealthHungerAndThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewThirst().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Deluxe Set", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testEatingDeluxeSetWithOverLimitedHealthHungerAndThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(96);
		Game.getCrewHunger().add(95);
		Game.getCrewThirst().add(94);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Deluxe Set", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(100), Game.getCrewHunger().get(0));
		assertEquals(Integer.valueOf(100), Game.getCrewHealth().get(0));
		assertEquals(Integer.valueOf(100), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testEatingSteakSetWithLowerHealthHungerAndThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(60);
		Game.getCrewHunger().add(29);
		Game.getCrewThirst().add(69);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Steak Set", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(99), Game.getCrewHunger().get(0));
		assertEquals(Integer.valueOf(95), Game.getCrewHealth().get(0));
		assertEquals(Integer.valueOf(99), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testEatingSteakSetWithFullHealthHungerAndThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewThirst().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Steak Set", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testEatingSteakSetWithOverLimitedHealthHungerAndThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(96);
		Game.getCrewHunger().add(95);
		Game.getCrewThirst().add(94);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Steak Set", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(100), Game.getCrewHunger().get(0));
		assertEquals(Integer.valueOf(100), Game.getCrewHealth().get(0));
		assertEquals(Integer.valueOf(100), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testEatingFrenchFriesWithLowerHealthAndHunger() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(84);
		Game.getCrewHunger().add(77); 
		Game.getCrewName().add("John");
		assertTrue(Game.feed("French Fries", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(97), Game.getCrewHunger().get(0));
		assertEquals(Integer.valueOf(94), Game.getCrewHealth().get(0));
	}
	
	@Test
	public void testEatingFrenchFriesWithFullHealthAndHunger() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("French Fries", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testEatingFrenchFriesWithOverLimitedHealthAndHunger() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(95);
		Game.getCrewHunger().add(95);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("French Fries", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(100), Game.getCrewHealth().get(0));
		assertEquals(Integer.valueOf(100), Game.getCrewHunger().get(0));
	}
	
	@Test
	public void testConsumeSpicyWaterWithLowerThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(75);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Spicy Water", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(95), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testConsumeSpicyWaterWithFullThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Spicy Water", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testConsumeSpicyWaterWithOverLimitedThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(97);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Spicy Water", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(100), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testConsumeFruitPunchWithLowerThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(85);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Fruit Punch", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(95), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testConsumeFruitPunchWithFullThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Fruit Punch", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testConsumeFruitPunchWithOverLimitedThirst() {
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(95);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Fruit Punch", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(100), Game.getCrewThirst().get(0));
	}
	
	@Test
	public void testConsumeHiRecoveryWithLowerHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(45); 
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Hi-Recovery", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(95), Game.getCrewHealth().get(0));
	}
	
	@Test
	public void testConsumeHiRecoveryWithFullHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Hi-Recovery", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testConsumeHiRecoveryWithOverLimitedHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(95);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Hi-Recovery", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testConsumeRecoveryWithLowerHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(70);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Recovery", Game.getCrewName().get(0))); 
		assertEquals(Integer.valueOf(95), Game.getCrewHealth().get(0));
	}
	
	@Test
	public void testConsumeRecoveryWithFullHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(100);
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Recovery", Game.getCrewName().get(0)));
	}
	
	@Test
	public void testConsumeRecoveryWithOverLimitedHealth() {
		Game.getCrewAction().add(0);
		Game.getCrewHealth().add(90);
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Recovery", Game.getCrewName().get(0)));
		assertEquals(Integer.valueOf(100), Game.getCrewHealth().get(0));
	}
	
	@Test
	public void testConsumeAntiPlagueWithUnhealthy() {
		Game.getCrewAction().add(0);
		Game.getCrewStatus().add("Unhealthy");
		Game.getCrewName().add("John");
		assertTrue(Game.feed("Anti-Plague", Game.getCrewName().get(0)));
		assertEquals("Healthy", Game.getCrewStatus().get(0));
	}
	
	@Test
	public void testConsumeAntiPlagueAndAlreadyHealthy() {
		Game.getCrewAction().add(0);
		Game.getCrewStatus().add("Healthy");
		Game.getCrewName().add("John");
		assertFalse(Game.feed("Anti-Plague", Game.getCrewName().get(0)));
		assertEquals("Healthy", Game.getCrewStatus().get(0));
	}

}
