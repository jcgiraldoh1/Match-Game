package Game;

import java.util.Vector;

public class MatchGamePlayer extends Player {
	
	private int level;													//I declare private int the variable level.
	private Vector<Integer> sequence = new Vector <Integer>();			//I declare private the Vector int sequence.
	
	public MatchGamePlayer() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	MatchGamePlayer()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows has the level and sequence for the player.
		//						
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-16-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		super();						//Calling the father's constructor.
		this.level = 1;					//The value of the variable.
		
	}
	
	public void setLevel(int level) {	// For set of setLevel
		this.level = level;
	}		
	public int getLevel() {				// For get of getLevel
		return level;
		
		
	}
	
	public void clearSequence() {		// For clear the clearSequence
		this.sequence.clear();
	}
	public void setSequence(Vector<Integer> sequence) {		//For set the Vector setSequence
		this.sequence = sequence;
		
	}	
	public Vector<Integer> getSequence() {					////For get the Vector getSequence
		return sequence;
		
	}

}
