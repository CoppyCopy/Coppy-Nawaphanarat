package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class CrewInfoTest {

	@BeforeEach
	public void reset() {
		Game.resetCrew();
	}
	
	@Test
	public void testAddedOneCrew() {
		assertTrue(Game.crewInfo("John", "Repairer"));
	}
	
	@Test
	public void testDuplicateName() {
		assertTrue(Game.crewInfo("John", "Repairer"));
		assertFalse(Game.crewInfo("John", "Absolute Unit"));
		assertEquals(1, Game.getCrewName().size());
	}
	
	@Test
	public void testDuplicateMedic() {
		assertTrue(Game.crewInfo("John", "Medic"));
		assertFalse(Game.crewInfo("Johnny", "Medic"));
		assertEquals(1, Game.getCrewType().size());
	}

	@Test
	public void testDuplicateTacCom() {
		assertTrue(Game.crewInfo("John", "Tactical Commander"));
		assertFalse(Game.crewInfo("Johnny", "Tactical Commander"));
		assertEquals(1, Game.getCrewType().size());
	}
	
	@Test
	public void testCrewMemberCounts() {
		Game.count = 3;
		assertTrue(Game.crewInfo("John", "Repairer"));
		assertTrue(Game.crewInfo("Johnny", "Absolute Unit"));
		assertTrue(Game.crewInfo("Johnny1", "Absolute Unit"));
		assertEquals(3, Game.getCrewName().size());
		assertEquals(3, Game.getCrewType().size());
		assertEquals(Game.count, Game.current);
	}
	
	@Test
	public void testAtMaximumRequirementCrewMember() {
		Game.count = 4;
		assertTrue(Game.crewInfo("John", "Repairer"));
		assertTrue(Game.crewInfo("Johnny", "Absolute Unit"));
		assertTrue(Game.crewInfo("Johnny1", "Absolute Unit"));
		assertTrue(Game.crewInfo("Johnny2", "Absolute Unit"));
		assertFalse(Game.crewInfo("Johnny3", "Absolute Unit"));
		assertEquals(Game.count, Game.getCrewName().size());
		assertEquals(Game.count, Game.getCrewType().size());
		assertEquals(Game.count, Game.current);
	}
}
