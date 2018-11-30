package testInfiniteTerrain;
import static org.junit.Assert.*;
import org.junit.Test;

import infiniteTerrain.Main;

public class testInfiniteTerrain {

	@Test
	 public void Look() {
		assertEquals(Main.look(), "<You have a GPS and can use 'north', 'south', 'east', 'west' to move>");

    }

	@Test
	 public void MoveNorth() {
		assertEquals(Main.MoveNorth(), "You find x");

   }
	
	@Test
	 public void MoveEast() {
		assertEquals(Main.MoveEast(), "You find x");

  }
	
	@Test
	 public void MoveSouth() {
		assertEquals(Main.MoveSouth(), "You find x");

  }
	
	@Test
	 public void MoveWest() {
		assertEquals(Main.MoveWest(), "You find x");

  }
	
}
