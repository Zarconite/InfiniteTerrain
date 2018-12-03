package infiniteTerrain;

import java.util.ArrayList;

import infiniteTerrain.Encounter;

public class Game {

	//Attributes
	
	public int currentXPos;
	public int currentYPos;
	public int Mana=100; //bad encounter could reduce mana, then eventually health
	public int Health=100; //good encounter could add health / mana back
	public static boolean alive=true;
	
	public static ArrayList<Encounter> encountersList = new ArrayList<Encounter>();
	
	//Constructors
	

	
	//Methods
	
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
	
}
