package jUnitTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import GameEnvironment.Game;

class RemoveCrewTest {
	@BeforeEach
	public void reset() {
		Game.resetCrew();
	}
	@Test
	public void test() {
		Game.crewInfo("John", "Repairer");
		assertTrue(Game.removeCrew("John"));
	}

}
