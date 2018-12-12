package testInfiniteTerrain;
import static org.junit.Assert.*;
import org.junit.Test;

import infiniteTerrain.Encounter;
import infiniteTerrain.Game;
import infiniteTerrain.Main;

public class testInfiniteTerrain {

	
	@Test
	 public void Look() {
		assertEquals(Game.look(), "You have a GPS and can use 'north', 'south', 'east', 'west' to move. You can type 'use' to check the location of the nearest encounter");

    }
	
	@Test
	 public void AddEncounters() {
		Game.addEncounters();
		assertEquals(String.valueOf(Encounter.encountersList.get(1)),"Oh no! Bad encounter: You accidentally stumbled into a trap and fell!. You lose: -10 health!");

  }/*
	@Test
	 public void useGPS() {
		Game.runGame();
		assertNotNull("Game map not initialized!",Game.use(255,255));

 }*/
	/*
	@Test
	 public void Game.north() {
		assertEquals("north", "You find x");

   }
	
	@Test
	 public void Game.east() {
		assertEquals("east", "You find x");

  }
	
	@Test
	
	assertEquals("Move south complete!", "You find x");
	 public void Game.south() {
		

  }
	
	@Test
	 public void Game.west() {
		assertEquals("west", "You find x");

  }
	*/
}
