package Game;

import java.util.Vector;

public class Player {	
	
	
	private int score;								//I declare private int the variable score.
	
		
	public Player() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	Player()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows has the level and score for the player.
		//						
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		

		this.score = 0;					//The value of the variable.
	}
	
	public void setScore(int score) {	// For set of setScore
		this.score = score;
				
	}	
	public int getScore() {				// For get of getScore
		return score;
	}	
	
		
}
