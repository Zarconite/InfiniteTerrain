
package infiniteTerrain;

public class Encounter extends Square {

	//Attributes
	String description;
	Boolean isBadEncounter;
	int encounterID;
	int manaModifier;
	int healthModifier;
	
	//Constructors
	
	public Encounter(String vDescription, Boolean vIsBadEncounter, int vManaModifier, int vHealthModifier) {	
		this.description = vDescription;
		this.isBadEncounter = vIsBadEncounter;
		this.manaModifier = vManaModifier;
		this.healthModifier = vHealthModifier;
	}
	
	
	//Methods
		
	public String toString() {
		
		if(isBadEncounter) {
			if(manaModifier<0&&healthModifier<0) {
				return ("Oh no! Bad encounter: " + this.description + ". You lose: " + manaModifier + " mana as well as: " + healthModifier + " health!");
			}
			else if(manaModifier<0) {
				return ("Oh no! Bad encounter: " + this.description + ". You lose: " + manaModifier + " mana!");	
			}
			else if(healthModifier<0){
				return ("Oh no! Bad encounter: " + this.description + ". You lose: " + healthModifier+ " health!");	
			}
			else {
				return ("Oh no! Bad encounter: " + this.description + ". But luckily you don't lose any mana or health!");
			}
		}
		else {
			if(manaModifier>0&&healthModifier>0) {
				return ("Lucky you! Good encounter: " + this.description + ". You gain: " + manaModifier + " mana as well as: " + healthModifier + " health!");
			}
			else if(manaModifier>0) {
				return ("Lucky you! Good encounter: " + this.description + ". You gain: " + manaModifier + " mana!");	
			}
			else if(healthModifier>0){
				return ("Lucky you! Good encounter: " + this.description + ". You gain: " + healthModifier+ " health!");	
			}
			else {
				return ("Lucky you! Good encounter: " + this.description + ". However you don't gain any mana or health!");
			}	
		}
	}
}
