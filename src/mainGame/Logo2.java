package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import Trainer.*;

public class Logo2 extends JPanel {
	
	JButton returnButton;
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    String language;
    Font font;
    int textSpeed;
    MainGame mg;
    Player player;
    Rival rival;
    Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
    Float titleSize;
    int buttonWidth;
    int buttonHeight;
    ImageIcon logoIcon;
    JLabel logoLabel;
    String color;
	
	public Logo2 (final CardLayout layout, final JPanel cards, String language, Font font, int textSpeed,
			Player player, Rival rival, Boolean stopTimer, Float titleSize, int buttonWidth, int buttonHeight,
			Boolean professorOakVisited, Boolean labOutsideButtonEnable, String color) {
		 this.cl = layout;
	     this.cards = cards;
	     this.language = language;
	     this.font = font;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.titleSize = titleSize;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     
//	     if (color == "black") {
//	         setBackground(Color.black); 
//	 	    }
//	 	    
//	 	    if (color == "cyan") {
//	 	        setBackground(Color.cyan); 
//	 		    }
	     
	     setBackground(Color.black); 
	     
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(50,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 if(language == "Japanese") {
			 returnButton.setText("とじる");
		 }
		 
		 
		 logoIcon = new ImageIcon(this.getClass().getClassLoader().getResource("logo1full.png"));
		 logoLabel = new JLabel(logoIcon);
		 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 gb.gridx = 0;
		 gb.gridy = 0;
		 add(returnButton, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 1;
		 add(logoLabel, gb);
		 
		 
		 
		 
		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
						Clip clip = null;
						//On instead of off for Music on as default
						mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, 
								titleSize, buttonWidth, buttonHeight, player, rival, professorOakVisited, labOutsideButtonEnable,
								color, clip, "on", "no");
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
	}
	

}
