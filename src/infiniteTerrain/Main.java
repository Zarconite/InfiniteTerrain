package infiniteTerrain;

import infiniteTerrain.Map;

import java.util.Scanner;

import infiniteTerrain.Encounter;

public class Main {

	public static void main(String[] args) {
		
		//For loop to show grid position +5 spaces and -5 spaces in any direction? ie: 11x11 grid
		
		Game.addEncounters();
		
		int xPosition = Map.Size/2;
		int yPosition = Map.Size/2;
		
		/*for(Encounter encountersPrint:Encounter.encountersList) { //temporary to ensure all encounters print via the overridden toString() method in Encounter
			System.out.println(encountersPrint.toString());
		}*/
		Scanner scanner = new Scanner(System.in);
		System.out.println("<Welcome message telling you to type 'look'>");
		String inputCommand = scanner.nextLine();
		if(inputCommand.toLowerCase().equals("look")) {
			System.out.println("<You have a GPS and can use 'north', 'south', 'east', 'west' to move. You can type 'use' to check the location of the nearest encounter>");
		}
		//Map.addTheEncounters();
		infiniteTerrain.Map gameMap = new Map();
		gameMap.populateSquares((Map.Size*Map.Size)/2);
		
		while (Game.alive) {
		inputCommand = scanner.nextLine();
		
		if(inputCommand.toLowerCase().equals("north")) {
			yPosition++;
			System.out.println(SquareText(xPosition,yPosition));
		}
		if(inputCommand.toLowerCase().equals("east")) {
			xPosition++;
			System.out.println(SquareText(xPosition,yPosition));
		}
		if(inputCommand.toLowerCase().equals("south")) {
			yPosition--;
			System.out.println(SquareText(xPosition,yPosition));
		}
		if(inputCommand.toLowerCase().equals("west")) {
			xPosition--;
			System.out.println(SquareText(xPosition,yPosition));
		}
		
		if(inputCommand.toLowerCase().equals("use")) {
			System.out.println(use());
			//System.out.println(Encounter.encountersList.get(2)); hopefully this will be something like Encounter.encountersList.get(Map[0][0][xPos][yPos])
			
		}
		if(inputCommand.toLowerCase().equals("test")) {
			System.out.println(Map.Map[0][0][0][0]);
			System.out.println(Map.Map[0][0][0][1]);
		}
		}
		scanner.close();
	}
	

	
	public static String use() {
		
		
		return "<You check your GPS: ";
	}
	
	public static String SquareText(int xPosition, int yPosition) {
		if(Map.Map[0][0][xPosition][yPosition]==null) {
			return "Barren Wasteland";
		}
		else {
		return String.valueOf(Encounter.encountersList.get(Integer.parseInt(Map.Map[0][0][xPosition][yPosition])));
		}
	}

}
