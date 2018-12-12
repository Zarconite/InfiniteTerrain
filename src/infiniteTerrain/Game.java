package infiniteTerrain;

import java.util.ArrayList;
import java.util.Scanner;

import infiniteTerrain.Encounter;

public class Game {

	//Attributes
	
	public int currentXPos;
	public int currentYPos;
	public int Mana=100; //bad encounter could reduce mana, then eventually health
	public int Health=100; //good encounter could add health / mana back
	public static boolean alive=true;
	public static int currentXChunk=Map.chunkSize/2;
	public static int currentYChunk=Map.chunkSize/2;
	public static infiniteTerrain.Map gameMap = new Map();
	public static ArrayList<Encounter> encountersList = new ArrayList<Encounter>();
	
	//Constructors
	

	
	//Methods
	
	public static void runGame() {
		
		addEncounters();
		
		int xPosition = Map.size/2;
		int yPosition = Map.size/2;
		boolean exploredTilesTrue = false;
		
		//for(Encounter encountersPrint:Encounter.encountersList) { //temporary to ensure all encounters print via the overridden toString() method in Encounter
		//	System.out.println(encountersPrint.toString());
		//}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Do you want the map to show where you've travelled to? (Yes/No)");
		String inputCommand = scanner.nextLine();
		if(inputCommand.toLowerCase().equals("yes")) {
			exploredTilesTrue=true;
		}
	
		System.out.println("<Welcome message telling you to type 'look'>");
		inputCommand = scanner.nextLine();
		
		if(inputCommand.toLowerCase().equals("look")) {
			System.out.println(look());
		}
		
		
		gameMap.populateSquares((Map.size*Map.size)/8,Map.chunkSize/2,Map.chunkSize/2); //12.5% chance of encounter generating in any tile
		
		while (Game.alive) {
		
			
		inputCommand = scanner.nextLine();
		
		if(inputCommand.toLowerCase().equals("north")) {
			yPosition=north(xPosition,yPosition,exploredTilesTrue);
		}
		
		if(inputCommand.toLowerCase().equals("east")) {
			xPosition=east(xPosition,yPosition,exploredTilesTrue);
		}
		
		if(inputCommand.toLowerCase().equals("south")) {
			yPosition=south(xPosition,yPosition,exploredTilesTrue);
		}
		
		if(inputCommand.toLowerCase().equals("west")) {
			xPosition=west(xPosition,yPosition,exploredTilesTrue);
		}
		
		if(inputCommand.toLowerCase().equals("use")) { //Fix the out of bounds exception!
			use(xPosition,yPosition);
			
		}
		}
		scanner.close();
		
	}
	
	public static String look() {
		return "You have a GPS and can use 'north', 'south', 'east', 'west' to move. You can type 'use' to check the location of the nearest encounter";
	}
	
	public static String currentLocation(int xPosition, int yPosition) {
		return "You are currently at x: "+xPosition+" y: "+(Map.size-yPosition);
	}
	
	public static int north(int xPosition, int yPosition, Boolean exploredTilesTrue) {
		try {
		yPosition--;
		System.out.println(currentLocation(xPosition,yPosition));
		System.out.println(SquareText(xPosition,yPosition,exploredTilesTrue));
		}
		catch(ArrayIndexOutOfBoundsException northEdge) {
			yPosition=Map.size;
			currentYChunk=currentYChunk-1;
			gameMap.populateSquares((Map.size*Map.size)/8,currentXChunk,currentYChunk);
			System.out.println("Chunk Update! Now moving into: " +currentXChunk+","+currentYChunk);
		}
		return yPosition;
	}
	
	public static int east(int xPosition, int yPosition, Boolean exploredTilesTrue) {
		try {
		xPosition++;
		System.out.println(currentLocation(xPosition,yPosition));
		System.out.println(SquareText(xPosition,yPosition,exploredTilesTrue));
		}
		catch(ArrayIndexOutOfBoundsException eastEdge) {
			xPosition=0;
			currentXChunk=currentXChunk+1;
			gameMap.populateSquares((Map.size*Map.size)/8,currentXChunk,currentYChunk);
			System.out.println("Chunk Update! Now moving into: " +currentXChunk+","+currentYChunk);
		}
		return xPosition;
	}
	
	public static int south(int xPosition, int yPosition, Boolean exploredTilesTrue) {
		try {
		yPosition++;
		System.out.println(currentLocation(xPosition,yPosition));
		System.out.println(SquareText(xPosition,yPosition,exploredTilesTrue));
		}
		catch(ArrayIndexOutOfBoundsException southEdge) {
			yPosition=0;
			currentYChunk=currentYChunk+1;
			gameMap.populateSquares((Map.size*Map.size)/8,currentXChunk,currentYChunk);
			System.out.println("Chunk Update! Now moving into: " +currentXChunk+","+currentYChunk);
		}
		return yPosition;
	}
	
	public static int west(int xPosition, int yPosition, Boolean exploredTilesTrue) {
		try {
		xPosition--;
		System.out.println(currentLocation(xPosition,yPosition));
		System.out.println(SquareText(xPosition,yPosition,exploredTilesTrue));
		}
		catch(ArrayIndexOutOfBoundsException westEdge) {
			xPosition=Map.size;
			currentXChunk=currentXChunk-1;
			gameMap.populateSquares((Map.size*Map.size)/8,currentXChunk,currentYChunk);
			System.out.println("Chunk Update! Now moving into: " +currentXChunk+","+currentYChunk);
		}
		return xPosition;
	}
	
	public static void use(int xPosition, int yPosition) {
		System.out.println("You check your GPS, you are currently at x: "+xPosition+" y: "+(Map.size-yPosition)+":");
		
		for(int j=-3; j<=3; j++) {
			for(int k=-3; k<=3; k++) {
				
				if(j==0&&k==0) {
					System.out.print("[X]");
					}
				else if(Map.Map[currentXChunk][currentYChunk][k+xPosition][j+yPosition].charAt(0)==' ') { 
					System.out.print("[ ]");
				}
				else {
					System.out.print("["+Map.Map[currentXChunk][currentYChunk][k+xPosition][j+yPosition]+"]");
				}
				
			}
			System.out.println();
		}
		
	}
	
	public static String SquareText(int xPosition, int yPosition, boolean exploredTilesTrue) {
		String[] noEncounter = {
				"Current terrain: Light Woodland",
				"Current terrain: Light Woodland",
				"Current terrain: Woodland",
				"Current terrain: Forest",
				"Current terrain: Plains",
				"Current terrain: Dense forest",
				"Current terrain: Hills",
				"Current terrain: Valley",
				"Current terrain: Barren Wasteland",
				"Current terrain: Dead woodland",
				"Current terrain: Abandoned buildings"
				};
		String squareTextReturner="";
		if(Map.Map[currentXChunk][currentYChunk][xPosition][yPosition].charAt(0)==' ') {
			squareTextReturner = noEncounter[Integer.parseInt(Map.Map[currentXChunk][currentYChunk][xPosition][yPosition].replaceAll("\\s+",""))];
			setExplored(xPosition, yPosition,exploredTilesTrue);
			return squareTextReturner;
		}
		else if(Map.Map[currentXChunk][currentYChunk][xPosition][yPosition] == "+") {
			return "You've been here before";
		}
		else {
			squareTextReturner = String.valueOf(Encounter.encountersList.get(Integer.parseInt(Map.Map[currentXChunk][currentYChunk][xPosition][yPosition])));
		setExplored(xPosition, yPosition,exploredTilesTrue);
		return squareTextReturner;
		}
	}
	public static void setExplored(int xPosition, int yPosition,boolean exploredTilesTrue) { 
		if(Map.Map[currentXChunk][currentYChunk][xPosition][yPosition].charAt(0)!=' ' && exploredTilesTrue==false) {
		Map.Map[currentXChunk][currentYChunk][xPosition][yPosition] = " "+Map.Map[currentXChunk][currentYChunk][xPosition][yPosition];
		}
		else if(exploredTilesTrue){
			Map.Map[currentXChunk][currentYChunk][xPosition][yPosition] = "+";
		}
	}
	
	public static void addEncounters() {
		
		Encounter TreasureChest = new Encounter("You found a treasure chest, contained within it was a health potion!", false, 0, 25);
		Encounter PitfallTrap = new Encounter("You accidentally stumbled into a trap and fell!", true, 0, -10);
		Encounter WildAnimals = new Encounter("A pack of animals tried to attack you, however you managed to fend them off with your magic.", true, -10, 0);
		Encounter WitchesHouse = new Encounter("A strange magical hut lies before you, upon looting it you find five mana potions!", false, 50, 0);
		Encounter Dragon = new Encounter("A dragon suddenly swoops down and blasts you with fire! Your mana protects you from some of the damage but it still singes you.", true, -30, -10);
		Encounter SlipperySlope = new Encounter("You reach a large hill with a shiny golden chest at the very top! You attempt to scale the hill but end up slipping about half way up and fall to the bottom!", true, 0,-10);
		
		Encounter.encountersList.add(TreasureChest);
		Encounter.encountersList.add(PitfallTrap);
		Encounter.encountersList.add(WildAnimals);
		Encounter.encountersList.add(WitchesHouse);
		Encounter.encountersList.add(Dragon);
		Encounter.encountersList.add(SlipperySlope);
	}
	
}
