package infiniteTerrain;

import java.util.Random;

public class Map extends Game {
	
	//Attributes
	private int numberOfEncounters;
	public static int chunkSize=50;
	public static int size=100;
	public static String[][][][] Map = new String[chunkSize][chunkSize][size][size];//temporarily set the chunk pos to be 0
	private int xMapSpaces = (size/2); //x Starting position would be in the middle of the map
	private int yMapSpaces = (size/2); //Same for Y
	private int xPos;
	private int yPos;
	private boolean encounterTrue = false;
	private int encounterType;

	//Moved the attributes to the right place and decided that a 4d array would be better and be able to be made infinite
	//[x chunk][y chunk][x pos][y pos]
	
	
	// Constructors
	

	// Methods
	
	public void populateSquares(int numberOfEncounters, int xChunk, int yChunk) 
	{ 
		//Just noticed I would need a onSelection method to place random encounters instead of when it's initialised or else we'd be here until Christmas
		Random randomGen = new Random();
			/* Randomly generate encounter location */
			
			for(int i=0; i<numberOfEncounters; i++) 
			{

			/* Run a while loop to ensure an encounter isn't already in the generated location */
					xPos = randomGen.nextInt(size);
					yPos = randomGen.nextInt(size);
					
					if(Map[xChunk][yChunk][xPos][yPos]== null) 
					{
						encounterType = randomGen.nextInt(Encounter.encountersList.size());//Generate a number based off of the number of encounters | Encounter.encountersList.size()
						//assign that value to the square somehow?
						encounterTrue=true;
						Map[xChunk][yChunk][xPos][yPos] = String.valueOf(encounterType);
					}
			}
			for(int j=0; j<size; j++) {
				for(int k=0; k<size; k++) {
					if(Map[xChunk][yChunk][j][k]== null) {
						Map[xChunk][yChunk][j][k]=(" "+randomGen.nextInt(9));
					}
				}
			}
	}
	
	
}
	

