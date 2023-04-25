package Game;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.util.Vector;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;

public class MatchGame {													// The class called MatchGame
	
	
	private Vector<Integer> sequenceList = new Vector<Integer>();			// I declare private Vector list sequenceList like integer.
	private Vector <JButton> listButton = new Vector<JButton>();			// I declare private Vector list JButton listButton like integer.
	private MatchGamePlayer player;													// I declare private for instantiate the class Player.
	private int hiScore=0;													// I declare private variable hiScore.
	private int points=0;													// I declare private variable points.
	private int tempScore=0;												// I declare private variable tempScore.
	private int counterTimera;												// I declare private variable counterTimera
	private int counterTimerb;												// I declare private variable counterTimerb
	private boolean buttonsEnabled = false;									// I declare private boolean buttonsEnabled.
	private int subLevel=1;													// I declare private int subLevel.
	private Timer timer;													// I declare private Timer timer
	private JButton btnStartGame;											// I declare private JButton type for btnStartGame. 
	private JLabel lblScore;												// I declare private JLabel type for lblScore.
	private JLabel lblHiScore;												// I declare private JLabel type for lblHiScore.						
	private JLabel lblTitle;												// I declare private JLabel type for lblTitle. 
	private JLabel lblHiScoreImage;											// I declare private JLabel type for lblHiScoreImage.								
	private JLabel lblScoreImage;											// I declare private JLabel type for lblScoreImage.
	private JLabel lblBlackImage;											// I declare private JLabel type for lblBlackImage.
	private JLabel lblBg;													// I declare private JLabel type for lblBg.						
	private JLabel lblCorrectMsg;											// I declare private JLabel type for lblCorrectMsg.	
	private JLabel lblWrongMsg;												// I declare private JLabel type for lblWrongMsg.	
	private JLabel lblEndGame;												// I declare private JLabel type for lblEndGame.
	private File correctSequenceAudio = new File("Audio/Won.wav"); 			// I declare private File correctSequenceAudio for won audio.
	private File wrongSequenceAudio = new File("Audio/Lose.wav"); 			// I declare private File wrongSequenceAudio for lose audio.
	private Vector<Vector<String>> locationList = new Vector<Vector<String>>(); 	// I declare private Vector list locationList like integer.
		
	public MatchGame() {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	MatchGame
		//
		// Method parameters	:	the method allows String command line parameters to be entered
		//
		// Method return		:	none
		//
		// Synopsis				:   This method allows show the timer and graphics items
		//						
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		counterTimera=0;													// the counterTimera in a cero value
		counterTimerb=0;													// the counterTimerb in a cero value
		timer = new Timer(1000,new ActionListener() {						// the counters timer for show or hide the random colors.
			public void actionPerformed(ActionEvent e) {					// the ActionListener for timer.
				
				if(counterTimerb==0) {										// If is counterTimerb show the random color.
					showRandomColor(sequenceList.get(counterTimera));										
				}
				
				if(counterTimerb==1) {
					hideRandomColor(sequenceList.get(counterTimera));		// If is not counterTimerb hide the random color.
				}
				
				//System.out.println(counterTimera + "  "  + counterTimerb);
				counterTimerb = counterTimerb+1;								// counterTimerb increase one by one.
				if(counterTimerb == 2) {										// for check if the counterTimberb is done.
					counterTimerb = 0;											// for reset the counterTimberb.
					counterTimera = counterTimera+1;							// counterTimera increase one by one.
					if(counterTimera == sequenceList.size()) {					// for check if the counterTimberb is equal to sequenceList.		
						timer.stop();											// stop the timer.
						buttonsEnabled = true;									// buttonsEnable change by true.
					}					
				}				
			}
		});
		
		player = new  MatchGamePlayer();													// instantiate the class Player for the player in MatchGame class
		Vector <String> temp = new Vector <String>();							// I declare private Vector list temp like String.			
		temp.add("Images/Red.png");												// for add the image path
		temp.add("Images/RedHi.png");											// for add the image path
		locationList.add(temp);													// for add the locationList (temp).
		
		Vector <String> temp1 = new Vector <String>();							// I declare private Vector list temp1 like String.
		temp1.add("Images/Green.png");											// for add the image path	
		temp1.add("Images/GreenHi.png");										// for add the image path
		locationList.add(temp1);												// for add the locationList (temp1).
		
		Vector <String> temp2 = new Vector <String>();							// I declare private Vector list temp2 like String.
		temp2.add("Images/Blue.png");											// for add the image path
		temp2.add("Images/BlueHi.png");											// for add the image path
		locationList.add(temp2);												// for add the locationList (temp2).
		
		Vector <String> temp3 = new Vector <String>();							// I declare private Vector list temp3 like String.					
		temp3.add("Images/Yellow.png");											// for add the image path
		temp3.add("Images/YellowHi.png");										// for add the image path
		locationList.add(temp3);												// for add the locationList (temp3).
		
		for(int counter=0; counter < 4; counter++) {							//this for are the graphics items  buttons.
			listButton.add(new JButton());
			listButton.get(counter).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			listButton.get(counter).setBorderPainted(false);
			listButton.get(counter).setContentAreaFilled(false);
			listButton.get(counter).setSize(110, 141);
			ImageIcon image = new ImageIcon(locationList.get(counter).get(0));
			Icon icon = new ImageIcon(image.getImage().getScaledInstance(listButton.get(counter).getWidth(), listButton.get(counter).getHeight(), Image.SCALE_DEFAULT));
			listButton.get(counter).setIcon(icon);
			int c = counter;			
			listButton.get(counter).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (buttonsEnabled) {
						pressButtonColor(c);
					}
					
				}
			});
		}
		
		listButton.get(0).setLocation(284, 106);					// The location of the button 0.
		listButton.get(1).setLocation(164, 106);					// The location of the button 1.
		listButton.get(2).setLocation(284, 258);					// The location of the button 2.
		listButton.get(3).setLocation(164, 258);					// The location of the button 3.

		lblTitle= new JLabel();										// For create the label lblTitle.
		lblTitle.setLocation(181, 11);								// The location of lblTitle.
		lblTitle.setSize(213, 50);									// For set the size lblTitle.
		ImageIcon imageTitle = new ImageIcon("Images/MatchGame2.png"); //Path of the image.
		Icon iconTitle = new ImageIcon(imageTitle.getImage().getScaledInstance(lblTitle.getWidth(), lblTitle.getHeight(), Image.SCALE_DEFAULT));
		lblTitle.setIcon(iconTitle);		
		
		lblHiScoreImage= new JLabel();								// For create the label lblHiScoreImage.					
		lblHiScoreImage.setLocation(10, 514);						// The location of lblHiScoreImage.
		lblHiScoreImage.setSize(163, 36);							// For set the size lblHiScoreImage.
		ImageIcon imageHiScore = new ImageIcon("Images/HiScore1.png"); // Path of the image.
		Icon iconHiScore = new ImageIcon(imageHiScore.getImage().getScaledInstance(lblHiScoreImage.getWidth(), lblHiScoreImage.getHeight(), Image.SCALE_DEFAULT));
		lblHiScoreImage.setIcon(iconHiScore);		
		
		lblScoreImage= new JLabel();								// For create the label lblScoreImage.
		lblScoreImage.setLocation(333, 514);						// The location of lblScoreImage.
		lblScoreImage.setSize(163, 36);								// For set the size lblScoreImage.
		ImageIcon imageScore = new ImageIcon("Images/Score1.png");	// Path of the image. 
		Icon iconScore = new ImageIcon(imageScore.getImage().getScaledInstance(lblScoreImage.getWidth(), lblScoreImage.getHeight(), Image.SCALE_DEFAULT));
		lblScoreImage.setIcon(iconScore);		
		
		lblHiScore = new JLabel("");								// For create the label lblHiScore.
		lblHiScore.setFont(new Font("Tahoma", Font.PLAIN, 30));		// For set the size lblHiScore.
		lblHiScore.setBounds(183, 514, 46, 36);						// For set the bounds lblHiScore.
		
		lblScore = new JLabel("");									// For create the label lblScore. 
		lblScore.setFont(new Font("Tahoma", Font.PLAIN, 30));		// For set the size lblScore.
		lblScore.setBounds(496, 514, 78, 36);						// For set the bounds lblScore.
		
		lblBlackImage= new JLabel();								// For create the label lblBlackImage.
		lblBlackImage.setLocation(225, 182);						// The location of lblBlackImage.
		lblBlackImage.setSize(110, 141);							// For set the size lblBlackImage.
		ImageIcon imageBlack = new ImageIcon("Images/Black1.png");	// Path of the image. 
		Icon iconBlack = new ImageIcon(imageBlack.getImage().getScaledInstance(lblBlackImage.getWidth(), lblBlackImage.getHeight(), Image.SCALE_DEFAULT));
		lblBlackImage.setIcon(iconBlack);
		
		lblCorrectMsg = new JLabel ("Correct");						// For create the label lblCorrectMsg.
		lblCorrectMsg.setForeground(Color.WHITE);					// For set the foreground white lblCorrectMsg.
		lblCorrectMsg.setFont(new Font("Tahoma", Font.PLAIN, 30));	// For set the size lblCorrectMsg.	
		lblCorrectMsg.setBounds(232, 225, 196, 50);					// For set the bounds lblCorrectMsg.
		
		lblWrongMsg = new JLabel ("Wrong");							// For create the label lblWrongMsg. 
		lblWrongMsg.setForeground(Color.WHITE);						// For set the foreground white lblWrongMsg.
		lblWrongMsg.setFont(new Font("Tahoma", Font.PLAIN, 30));	// For set the size lblWrongMsg.		
		lblWrongMsg.setBounds(235, 225, 196, 50);					// For set the bounds lblWrongMsg.
		
		lblEndGame = new JLabel ("GameOver");						// For create the label lblEndGame.
		lblEndGame.setForeground(Color.WHITE);						// For set the foreground white lblEndGame.
		lblEndGame.setFont(new Font("Tahoma", Font.PLAIN, 20));		// For set the size lblEndGame.
		lblEndGame.setBounds(235, 225, 196, 50);					// For set the bounds lblEndGame.
		
		btnStartGame = new JButton("Start Game");					// For create the JButton StartGame
		btnStartGame.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				startGame();										// For call the method StartGame();.				
			}
		});
		btnStartGame.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));		// For set the size btnStartGame.
		btnStartGame.setBounds(212, 410, 128, 31);								// For set the bounds btnStartGame.
		
		lblBg = new JLabel();										// For create the label lblBg.
		lblBg.setSize(600, 600);									// For set the size lblBg.	
		ImageIcon imageBg = new ImageIcon("Images/Background.jpg");	// Path of the image. 
		Icon iconBg = new ImageIcon(imageBg.getImage().getScaledInstance(lblBg.getWidth(), lblBg.getHeight(), Image.SCALE_DEFAULT));
		lblBg.setIcon(iconBg);
		lblBg.setBounds(0, 0, 584, 561);							// For set the bounds lblBg.
	}

	public void setSequenceList(Vector<Integer> sequenceList) {		// For set of setSequenceList.
		this.sequenceList = sequenceList;
		
	}
	public Vector<Integer> getSequenceList() {						// For get of getSequenceList.
		return sequenceList;
		
	}
	public void setListButton(Vector <JButton> listButton) {		// For set of setListButton.
		this.listButton = listButton;
		
	}
	public Vector<JButton> getListButton() {						// For get of getListButton
		return listButton;
		
	}
	public void setPlayer(MatchGamePlayer player) {							// For set of setPlayer.
		this.player = player;
		
	}
	public MatchGamePlayer getPlayer() {										// For get of getPlayer.
		return player;
		
	}
	public void setHiScore(int hiScore) {							// For set of setHiScore.
		this.hiScore = hiScore;
		
	}
	public int getHiScore() {										// For get of getHiScore.
		return hiScore;
		
	}
	public void setTempScore(int tempScore) {						// For set of setTempScore.
		this.tempScore = tempScore;
	}
	public int getTempScore() {										// For get of getTempScore
		return tempScore;
	}
	public void setTimer(Timer timer) {								// For set of setTimer.
		this.timer = timer;
	}
	public Timer getTimer() {										// For get of getTimer.
		return timer;
	}
	public void setBtnStartGame(JButton btnStartGame) {				// For set of setBtnStartGame.
		this.btnStartGame = btnStartGame;
		
	}
	public JButton getBtnStartGame() {								// For get of getBtnStartGame.
		return btnStartGame;
	}
	public void setLblScore(JLabel lblScore) {						// For set of setLblScore.
		this.lblScore = lblScore;
		
	}
	public JLabel getLblScore() {									// For get of getLblScore
		return lblScore;
	}
	public void setLblHiScore(JLabel lblHiScore) {					// For set of setLblHiScore.
		this.lblHiScore = lblHiScore;
	}
	public JLabel getLblHiScore() {									// For get of getLblHiScore.
		return lblHiScore;
	}
	public void setLblTitle(JLabel lblTitle) {						// For set of setLblTitle.
		this.lblTitle = lblTitle;
	}
	public JLabel getLblTitle() {									// For get of getLblTitle.
		return lblTitle;
		
	}		
	public void setLblHiScoreImage(JLabel lblHiScoreImage) {		// For set of setLblHiScoreImage.
		this.lblHiScoreImage = lblHiScoreImage;
	}	
	public JLabel getLblHiScoreImage() {							// For get of getLblHiScoreImage.
		return lblHiScoreImage;
	}	
	public void setLblScoreImage(JLabel lblScoreImage) {			// For set of setLblScoreImage.
		this.lblScoreImage = lblScoreImage;
				
	}	
	public JLabel getLblScoreImage() {								// For get of getLblScoreImage.
		return lblScoreImage;
	}	
	public void setLblBlackImage(JLabel lblBlackImage) {			// For set of setLblBlackImage.
		this.lblBlackImage = lblBlackImage;
	}	
	public JLabel getLblBlackImage() {								// For get of getLblBlackImage.
		return lblBlackImage;
	}	
	public void setLblBg(JLabel lblBg) {							// For set of setLblBg.
		this.lblBg = lblBg;
	}	
	public JLabel getLblBg() {										// For get of getLblBg.
		return lblBg;
	}			
	public void setLblCorrectMsg(JLabel lblCorrectMsg) {			// For set of setLblCorrectMsg.
		this.lblCorrectMsg = lblCorrectMsg;
	}	
	public JLabel getLblCorrectMsg() {								// For get of getLblCorrectMsg.
		return lblCorrectMsg;
	}	
	public void setLblWrongMsg(JLabel lblWrongMsg) {				// For set of setLblWrongMsg.
		this.lblWrongMsg = lblWrongMsg;
	}	
	public JLabel getLblWrongMsg() {								// For get of getlblWrongMsg.
		return lblWrongMsg;	
	}
	public void setLblEndGame(JLabel lblEndGame) {					// For set of setlblEndGame.
		this.lblEndGame = lblEndGame;
	}
	public JLabel getlblEndGame() {									//For get of setlblEndGame.
		return lblEndGame;
	}
	public void setCorrectSequenceAudio(File correctSequenceAudio) { //For set of setCorrectSequenceAudio.
		this.correctSequenceAudio = correctSequenceAudio;			
	}
	public File getCorrectSequenceAudio() {							// For get of getCorrectSequenceAudio.
		return correctSequenceAudio;
	}
	public void setWrongSequenceAudio(File wrongSequenceAudio) {	// For set of setWrongSequenceAudio.
		this.wrongSequenceAudio = wrongSequenceAudio;
	}
	public File getWrongSequenceAudio() {							// For set of getWrongSequenceAudio.
		return wrongSequenceAudio;
	}
	
	public void startGame() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void startGame()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows show Start the game.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		counterTimera=0;						// counterTimera variable in value 0.
		counterTimerb=0;						// counterTimerb variable in value 0.
		lblCorrectMsg.setVisible(false);		// lblCorrectMsg label set no visible.
		lblWrongMsg.setVisible(false);			// lblWrongMsg label set no visible.
		createRandomSequence();					// For call the method.
		timer.start();							// For start the timer.
		btnStartGame.setVisible(false);			// btnStartGame button no visible.
		lblEndGame.setVisible(false);			//Set the lblEndGame visible
		
	}
	
	public void createRandomSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void createRandomSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows create the random sequence of the colors.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		
		int numColors;											// I declare int numColor.
		sequenceList.clear();									// For clear the system sequenceList
		player.clearSequence();									// For clear the player sequence list.
	    numColors = player.getLevel() + 2;						// Increase colors depend of the level.
	    Random color = new Random();							// For random method in this case colors.
	    for(int counter = 0;counter < numColors; counter++) {	// This loop is for add the colors in a sequenceList. 
	    	sequenceList.add(color.nextInt(4));
	    }
		
	    /*for(int counter = 0;counter < numColors; counter++) {	
	    	System.out.println(sequenceList.get(counter));
	    }*/
		
	}
	
	public void showRandomColor(int location) {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showRandomColor()
		//
		// Method parameters	:	int location
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows show the the random sequence of the colors.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		ImageIcon image = new ImageIcon(locationList.get(location).get(1));		//For create the show  image.
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(listButton.get(location).getWidth(), listButton.get(location).getHeight(), Image.SCALE_DEFAULT));
		listButton.get(location).setIcon(icon);					
	}
	
	public void hideRandomColor(int location) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void hideRandomColor()
		//
		// Method parameters	:	int location
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows hide the the random sequence of the colors.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		ImageIcon image = new ImageIcon(locationList.get(location).get(0));		////For create the hide  image.
		Icon icon = new ImageIcon(image.getImage().getScaledInstance(listButton.get(location).getWidth(), listButton.get(location).getHeight(), Image.SCALE_DEFAULT));
		listButton.get(location).setIcon(icon);			
	}
	
	public void pressButtonColor(int id) {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void pressButtonColor()
		//
		// Method parameters	:	int id
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows you to save the click that the player enters for each button pressed.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
	
		
	player.getSequence().add(id);			//For add the player pressed button in the sequence.
	//System.out.println(player.getSequence().get(player.getSequence().size()-1));
	if(player.getSequence().size() == sequenceList.size()) {		//For check if the system sequence and player sequence is equal.
		buttonsEnabled = false;										// the buttonsEnabled is false.
		evaluate();													// For call the method evaluate.
		}			
	}
	
	public void evaluate() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void evaluate()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows evalute the random sequence vs the player sequence.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if(player.getSequence().equals(sequenceList))  {				//for compare the sequence between player and the system.
			correctSequence();											// in case it is correct call the method correctSequence.
			

		}else {
			wrongSequence();											//else call the method wrongSequence.
		}			
	}
	
	public void correctSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void correctSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows call the the methods for gain points, increase the level, show a message and play an audio when the player pressed the sequence correctly.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-29-03		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		
		gainPoints();										//For call method gainPoints.
		subLevel++;										//For Increase subLevel.
		if(subLevel == 5) {								// When the subLevel is equal to 5.
			subLevel=1;										//subLevel is equal 1.
			player.setLevel(player.getLevel()+1);			// For increase the level.
		}
		showCorrectMsg();									//For call the method showCorrectMsg.
		playCorrectAudio();									// For call the method playCorrectAudio.
		btnStartGame.setVisible(true);						// For set visible the button btnStartGame.
	}
	
	public void gainPoints() {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void gainPoints()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows obtain the points.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
				
		//points = player.getScore() +10;												//For set the points.
		points= player.getScore()+(10*(int)Math.pow((double)2,(double)player.getLevel()-1));							// For set the points depend of the level.
		//System.out.println("You won: " + 10 * player.getLevel() + " points");		
		player.setScore(points);													//For set the score.
		lblScore.setText(":"+points+"");											// For call the points to lblScore.
		if(hiScore < points) {
			hiScore=points;
		}
		obtainHiScore();
		
	}
	
	public void showCorrectMsg() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showCorrectMsg()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows show a message when the player pressed the sequence correctly.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		if(player.getSequence().equals(sequenceList))  {			//In case it both sequences are equal then set visible lblCorrectMsg 
			lblCorrectMsg.setVisible(true);
		}				
	}
	
	public void playCorrectAudio() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playCorrectAudio()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows reproduce an audio when the player pressed the sequence correctly.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		try {
			Clip won = AudioSystem.getClip();												//Method for open and start the audio.
			won.open(AudioSystem.getAudioInputStream(correctSequenceAudio));
			won.start();		
		} catch(Exception e) {
			System.out.println("Exception playing Win audio."+e.getMessage());
		}		
	}
	
	public void wrongSequence() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void wrongSequence()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows call the the methods for lose points, show a message and play an audio when the player pressed the sequence incorrectly.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		losePoints();					//For call method gainPoints		
		if(player.getScore() <= 0) {	//For check if the points are 0 then call the method endGame.
			endGame();
			
			
			
			
		}else {
			 
			showWrongMsg();					//For call the method showWrongMsg
			playWrongAudio();				//For call the method playWrongAudio
			btnStartGame.setVisible(true);	// For set visible the button btnStartGame
		}
			
	
	}
	
	public void losePoints() {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void losePoints()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows reduce the points.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		//points = player.getScore() -20;										//For set the points		
		points= player.getScore()-(10*(int)Math.pow((double)2,(double)player.getLevel()));							// For set the points depend of the level.
		//System.out.println("You lose : " - 20 * player.getLevel()+ " points");		
		player.setScore(points);											//For set the score
		lblScore.setText(":"+ points+"");									// For call the points to lblScore
		
		
	}
	
	public void showWrongMsg() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void showWrongMsg()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows show a message when the player pressed the sequence incorrectly.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		if(player.getSequence().equals(sequenceList))  {			//In case it both sequences are not equal then set visible lblWrongMsg
			lblWrongMsg.setVisible(false);
		}else {
			lblWrongMsg.setVisible(true);
			btnStartGame.setVisible(true);				//Set the btnStartGame  visible
		}		
	}
	
	public void playWrongAudio() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void playWrongAudio()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows reproduce an audio when the player pressed the sequence incorrectly.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		try {
			Clip lose = AudioSystem.getClip();								//For open an start the audio
			lose.open(AudioSystem.getAudioInputStream(wrongSequenceAudio));
			lose.start();		
		} catch(Exception e) {
			System.out.println("Exception playing Win audio."+e.getMessage());
		}		
	}
			
	public void obtainHiScore() {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void obtainHiScore()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows obtain the hiScore value.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
			
			lblHiScore.setText(":"+ hiScore +"");				
		
	}
	
	public void endGame() {	
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void endGame()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows finish the game.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		
		
		btnStartGame.setVisible(true);				//Set the btnStartGame not visible
		lblEndGame.setVisible(true);				//Set the lblEndGame visible
		playWrongAudio();							//For call the method playWrongAudio
		if(points <=0) {							//For reset the score value when the player obtain gameover.
			points = 0;
			player.setScore(0);
		}
		lblScore.setText(":"+ points+"");			//For show the lblScore value.
			
		
	}
	
}




