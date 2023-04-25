package Game;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;


public class GUI extends JFrame {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MatchGame game = new MatchGame();
	private JPanel contentPane = new JPanel();						// I declare JPanel contentPane.
	private JPanel panel = new JPanel();							// I declare JPanel panel.
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		// Method				:	void GUI()
		//
		// Method parameters	:	none
		//
		// Method return		:	void
		//
		// Synopsis				:   This method allows show the interface.
		//							
		//
		// Modifications		:
		//							Date			Developer				Notes
		//							----			---------				-----
		//							2022-09-05		Juan Giraldo			
		//
		// =-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);					
		setBounds(100, 100, 600, 600);									// For set the bounds.
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));				// For set the border.
		setContentPane(contentPane);									// For set the ContentPane
		contentPane.setLayout(null);									// For set the layout
		panel.setBounds(0, 0, 600, 600);								// For set the panel bounds.
		panel.setBackground(Color.GRAY);								// For set the Background panel.
		panel.setLayout(null);											// For set the layout panel.
		contentPane.add(panel);											// For add the panel.
		
		for(int counter=0;counter < 4; counter++) {						// This loop is for show the buttons
			panel.add(game.getListButton().get(counter));		
		}
		
		panel.add(game.getLblCorrectMsg()).setVisible(false);			// For add in the panel the getLblCorrectMsg but no visible
		panel.add(game.getLblWrongMsg()).setVisible(false);				// For add in the panel getlblWrongMsg but no visible
		panel.add(game.getlblEndGame()).setVisible(false);				// For add in the panel getlblEndGame
		panel.add(game.getLblTitle());									// For add in the panel getLblTitle
		panel.add(game.getLblHiScore());								// For add in the panel getLblHiScore
		panel.add(game.getLblScore());									// For add in the panel getLblScore
		panel.add(game.getBtnStartGame());								// For add in the panel getBtnStartGame.
		panel.add(game.getLblHiScoreImage());							// For add in the panel getLblHiScoreImage.
		panel.add(game.getLblScoreImage());								// For add in the panel getLblScoreImage.
		panel.add(game.getLblBlackImage());								// For add in the panel getLblBlackImage
		panel.add(game.getLblBg());										// For add in the panel getLblBg.
		
		
		
		
							
	}
	
	
}


