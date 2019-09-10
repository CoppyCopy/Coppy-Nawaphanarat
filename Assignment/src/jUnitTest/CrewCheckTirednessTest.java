package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class CrewCheckTirednessTest {
	
	@BeforeEach
	public void reset() {
		Game.resetCrew();
	}
	
	@Test
	public void testCrewIsNotTired() {
		Game.getCrewName().add("John");
		Game.getCrewTiredness().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(100);
		assertTrue(Game.checkCrewMemberTiredness("John"));
	}
	
	@Test
	public void testCrewIsTooTired() {
		Game.getCrewName().add("John");
		Game.getCrewTiredness().add(19);
		Game.getCrewHunger().add(100);
		Game.getCrewAction().add(0);
		Game.getCrewThirst().add(19);
		assertFalse(Game.checkCrewMemberTiredness("John"));
	}
	
	@Test
	public void testCrewIsAlreadyAction() {
		Game.getCrewName().add("John");
		Game.getCrewTiredness().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewAction().add(1);
		Game.getCrewThirst().add(100);
		assertFalse(Game.checkCrewMemberTiredness("John"));
	}
	
	@Test
	public void testCrewNotOnTheList() {
		Game.getCrewName().add("John");
		Game.getCrewTiredness().add(100);
		Game.getCrewHunger().add(100);
		Game.getCrewAction().add(1);
		Game.getCrewThirst().add(100);
		assertFalse(Game.checkCrewMemberTiredness(""));
	}
}
