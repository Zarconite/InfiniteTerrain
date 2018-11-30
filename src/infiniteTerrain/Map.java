package infiniteTerrain;

import java.util.Random;


public class Map extends Game {

	//Attributes
	private int numberOfEncounters;
	private int Size=2147483647;
	//Technically not infinite, but right now I can't think of a way implement an infinite method into actual code and would rather work on other things until I come up with it.
	//hopefully 2 billion 147 million tiles is enough
	
	
	// Constructors

	public Map() { 
		this.numberOfEncounters=((int)((Size*Size)*0.5));//hopefully sets the starting position in the centre of the map
	}
	
	
	// Methods
	
	public void addEncounters(int numberOfEncounters) { 
		//Just noticed I would need a onSelection method to place random encounters instead of when it's initialised or else we'd be here until Christmas
		Random randomGen = new Random();
		String[][] Map = new String[Size][Size];
		int xMapSpaces = (Size/2); //x Starting position would be in the middle of the map
		int yMapSpaces = (Size/2); //Same for Y
		int xPos;
		int yPos;
		
			/* Randomly generate encounter location */
			
			for(int i=0; i<numberOfEncounters; i++) {
		xPos = randomGen.nextInt(Size);
		yPos = randomGen.nextInt(Size);
		boolean encounterTrue = false;

			/* Run a while loop to ensure an encounter isn't already in the generated location */
		
		while(encounterTrue==false) {
			if(Map[xPos][yPos]!= "[E]") { //Marks a square with [E] when there's an encounter
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
	

