package infiniteTerrain;

public class Square extends Map {

	//Attributes
	Boolean isExplored=false;
	Boolean hasEncounter;
	
	
	//Constructors
	
	
	//Methods
	
	public void ExploreTile() {
		// this.flagged = b;
		if (this.isExplored == false) {
			this.isExplored = true;
		}
	}
	
	@Override
	public String toString() {
		if (this.isExplored==false) {
			return "[ ]";
		}
		else{
			return "[+]";
		}
		
	}
	
}
