package infiniteTerrain;

import java.util.Random;


public class Map extends Game {

	//Attributes
	private int numberOfEncounters;
	private int Size=500;
	private String[][][][] Map = new String[0][0][Size][Size];
	private int xMapSpaces = (Size/2); //x Starting position would be in the middle of the map
	private int yMapSpaces = (Size/2); //Same for Y
	private int xPos;
	private int yPos;
	private boolean encounterTrue = false;

	//Moved the attributes to the right place and decided that a 4d array would be better
	//[x chunk][y chunk][x pos][y pos]

	
	
	// Constructors

	public Map() { 
		this.numberOfEncounters=((int)((Size*Size)/8)); //12.5% chance of an encounter per tile
	}
	
	
	// Methods
	
	public void addEncounters(int numberOfEncounters) { 
		//Just noticed I would need a onSelection method to place random encounters instead of when it's initialised or else we'd be here until Christmas
		Random randomGen = new Random();
			/* Randomly generate encounter location */
			
			for(int i=0; i<numberOfEncounters; i++) {
		xPos = randomGen.nextInt(Size);
		yPos = randomGen.nextInt(Size);

			/* Run a while loop to ensure an encounter isn't already in the generated location */
		
		while(encounterTrue==false) {
			if(Map[0][0][xPos][yPos]!= "[E]") { //Marks a square with [E] when there's an encounter
				randomGen.nextInt(Encounter.encountersList.size());//Generate a number based off of the number of encounters
				//assign that value to the square somehow?
				encounterTrue=true;
				
			}
			xPos = randomGen.nextInt(Size); //Generate X position based off of the maximum number of spaces
			yPos = randomGen.nextInt(Size); //Generate Y position based off of the maximum number of spaces
		}
	}
}
	
}
	

