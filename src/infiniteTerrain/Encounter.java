
package infiniteTerrain;

public class Encounter extends Square {

	//Attributes
	String description;
	Boolean isBadEncounter;
	int encounterID;
	int manaModifier;
	int healthModifier;
	String goodEncounter = "Lucky you! Good encounter: ";
	String badEncounter = "Oh no! Bad encounter: ";
	String lose = ". You lose: ";
	String gain = ". You gain: ";
	String health = " health!";
	String mana = " mana!";
	String manaAsWellAs = " mana as well as: ";
	
	//Constructors
	
	public Encounter(String vDescription, Boolean vIsBadEncounter, int vManaModifier, int vHealthModifier) {	
		this.description = vDescription;
		this.isBadEncounter = vIsBadEncounter;
		this.manaModifier = vManaModifier;
		this.healthModifier = vHealthModifier;
	}


	//Methods
	
	@Override
	public String toString() {
		
		if(isBadEncounter) {
			if(manaModifier<0&&healthModifier<0) {
				return (badEncounter + this.description + lose + manaModifier + manaAsWellAs + healthModifier + health);
			}
			else if(manaModifier<0) {
				return (badEncounter + this.description + lose + manaModifier + mana);	
			}
			else if(healthModifier<0){
				return (badEncounter + this.description + lose + healthModifier+ health);	
			}
			else {
				return (badEncounter + this.description + ". But luckily you don't lose any mana or health!");
			}
		}
		else {
			if(manaModifier>0&&healthModifier>0) {
				return (goodEncounter + this.description + gain + manaModifier + manaAsWellAs + healthModifier + health);
			}
			else if(manaModifier>0) {
				return (goodEncounter + this.description + gain + manaModifier + mana);	
			}
			else if(healthModifier>0){
				return (goodEncounter + this.description + gain + healthModifier+ health);	
			}
			else {
				return (goodEncounter + this.description + ". However you don't gain any mana or health!");
			}	
		}
	}
}
