package infiniteTerrain;

import infiniteTerrain.Map;

import java.util.Scanner;

import infiniteTerrain.Encounter;

public class Main {

	public static void main(String[] args) {
		
		infiniteTerrain.Map gameMap = new Map();
		//For loop to show grid position +5 spaces and -5 spaces in any direction? ie: 11x11 grid
		
		addEncounters();
		
		for(Encounter encountersPrint:Encounter.encountersList) { //temporary to ensure all encounters print via the overridden toString() method in Encounter
			System.out.println(encountersPrint.toString());
		}
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("<Welcome message telling you to type 'look'>");
		String Input = scanner.next();
		if(Input=="look") {
			look();
		}
		
	}
	
	public static void addEncounters() {
		
		Encounter TreasureChest = new Encounter("You found a treasure chest, contained within it was a health potion!", false, 0, 25);
		Encounter PitfallTrap = new Encounter("You accidentally stumbled into a trap and fell!", true, 0, -10);
		Encounter WildAnimals = new Encounter("A pack of animals tried to attack you, however you managed to fend them off with your magic.", true, -10, 0);
		Encounter WitchesHouse = new Encounter("A strange magical hut lies before you, upon looting it you find five mana potions!", false, 50, 0);
		Encounter Dragon = new Encounter("A dragon suddenly swoops down out of nowhere and blasts you with fire! Your mana protects you from some of the damage but it still singes you.", true, -30, -10);
		Encounter SlipperySlope = new Encounter("You reach a large hill with a shiny golden chest at the very top! You attempt to scale the hill but end up slipping about half way up and fall to the bottom!", true, 0,-10);
		
		Encounter.encountersList.add(TreasureChest);
		Encounter.encountersList.add(PitfallTrap);
		Encounter.encountersList.add(WildAnimals);
		Encounter.encountersList.add(WitchesHouse);
		Encounter.encountersList.add(Dragon);
		Encounter.encountersList.add(SlipperySlope);
	}
	
	public static void look() {
		
		System.out.println("<You have a GPS and can use 'north', 'south', 'east', 'west' to move>");
		
	}

}
