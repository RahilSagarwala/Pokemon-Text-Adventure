package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;

public class NewGame extends JPanel {
	
	JButton yesButton, noButton;
	CardLayout cl;
    JPanel cards;
    JLabel newGameLabel, blankLabel;
    StartScreen ss;
    JTextArea screenTextArea;
    Player player;
    Font font;
    String language, fullText2;
    int textSpeed, buttonWidth, buttonHeight;
    Rival rival;
    Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
    String color;
    MainGame mg;

    
	
	public NewGame(final CardLayout layout, final JPanel cards, Font font, String language, int textSpeed, Boolean stopTimer,
			int buttonWidth, int buttonHeight, Player player, Rival rival, Boolean professorOakVisited, 
			Boolean labOutsideButtonEnable, String color) {
		 this.cl = layout;
	     this.cards = cards;
	     this.font=font;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.stopTimer = stopTimer;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     this.player = player;
	     this.rival = rival;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     this.color = color;
	     

	     
		
		 
//	     if (color == "black") {
//	         setBackground(Color.black); 
//	 	    }
//	 	    
//	 	    if (color == "cyan") {
//	 	        setBackground(Color.cyan); 
//	 		    }
	     
	     setBackground(Color.black); 

		 
		 JButton yesButton = new JButton("Yes");
		 yesButton.setBackground(Color.DARK_GRAY);
		 yesButton.setForeground(Color.cyan);
		 yesButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		 yesButton.setFont(font);
		 
		 
		 JButton noButton = new JButton("No");
		 noButton.setBackground(Color.DARK_GRAY);
		 noButton.setForeground(Color.cyan);
		 noButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		 noButton.setFont(font);
		
		 
		 JLabel newGameLabel = new JLabel("Start New Game?");
		 newGameLabel.setFont(font);
		 newGameLabel.setForeground(Color.cyan);
		 
		 
		 if(language == "Japanese") {
			 newGameLabel.setText("さいしょからはじめる?");
			 noButton.setText("いいえ");
			 yesButton.setText("はい");
		 }
		 
		 
		 JLabel blankLabel = new JLabel("");
		 blankLabel.setFont(font);
		 blankLabel.setForeground(Color.cyan);
		 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 
		 
		 
		 gb.gridx=0;
	     gb.gridy=1;
		 add(yesButton, gb);
		 
		 gb.gridx=0;
	     gb.gridy=2;
	     gb.weighty=1;
		 add(blankLabel, gb);
		 
		 
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty=1;

		 add(newGameLabel, gb);
		 
		 
		 
		 gb.gridx=2;
	     gb.gridy=1;
		 add(noButton, gb);
		 
		
		 noButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
						Clip clip = null;
						//On instead of off for Music on as default
						mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, 
								65f, buttonWidth, buttonHeight, player, rival, professorOakVisited, 
								labOutsideButtonEnable, color, clip, "off", "no");
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	cards.add(mg, "mainscreen");
	                layout.show(cards, "mainscreen");

	            }
	        });
		 
		 yesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		         
	         
	         ss = new StartScreen(cl,cards,font, screenTextArea
	        		 ,"1", false, player, true, language, textSpeed, "",
	        		 rival, false, stopTimer, buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
            
	         
             cards.add(ss, "startscreen");
             layout.show(cards, "startscreen");
	            }
	        });
	}
	

}
