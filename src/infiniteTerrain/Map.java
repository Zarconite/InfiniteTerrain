package infiniteTerrain;

import java.util.Random;

public class Map extends Game {
	
	//Attributes
	private int numberOfEncounters;
	public static int size=500;
	public static String[][][][] Map = new String[1][1][size][size];//temporarily set the chunk pos to be 0
	private int xMapSpaces = (size/2); //x Starting position would be in the middle of the map
	private int yMapSpaces = (size/2); //Same for Y
	private int xPos;
	private int yPos;
	private boolean encounterTrue = false;
	private int encounterType;

	//Moved the attributes to the right place and decided that a 4d array would be better and be able to be made infinite
	//[x chunk][y chunk][x pos][y pos]

	
	
	// Constructors

	public Map() { 
		this.numberOfEncounters=((int)((size*size)/8)); //12.5% chance of an encounter per tile
		
	}
	
	
	// Methods
	
	public void populateSquares(int numberOfEncounters) 
	{ 
		//Just noticed I would need a onSelection method to place random encounters instead of when it's initialised or else we'd be here until Christmas
		Random randomGen = new Random();
			/* Randomly generate encounter location */
			
			for(int i=0; i<numberOfEncounters; i++) 
			{

			/* Run a while loop to ensure an encounter isn't already in the generated location */
					xPos = randomGen.nextInt(size);
					yPos = randomGen.nextInt(size);
					
					if(Map[0][0][xPos][yPos]== null) 
					{
						encounterType = randomGen.nextInt(Encounter.encountersList.size());//Generate a number based off of the number of encounters | Encounter.encountersList.size()
						//assign that value to the square somehow?
						encounterTrue=true;
						Map[0][0][xPos][yPos] = String.valueOf(encounterType);
					}
			}
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					if(Map[0][0][j][k]== null) {
						Map[0][0][j][k]=(" "+randomGen.nextInt(9));
					}
				}
			}
	}
	
}
	

