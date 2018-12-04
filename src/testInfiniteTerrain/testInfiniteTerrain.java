package testInfiniteTerrain;
import static org.junit.Assert.*;
import org.junit.Test;

import infiniteTerrain.Main;

public class testInfiniteTerrain {

	@Test
	 public void Look() {
		assertEquals("look", "<You have a GPS and can use 'north', 'south', 'east', 'west' to move>");

    }

	@Test
	 public void MoveNorth() {
		assertEquals("north", "You find x");

   }
	
	@Test
	 public void MoveEast() {
		assertEquals("east", "You find x");

  }
	
	@Test
	 public void MoveSouth() {
		assertEquals("south", "You find x");

  }
	
	@Test
	 public void MoveWest() {
		assertEquals("west", "You find x");

  }
	
}
