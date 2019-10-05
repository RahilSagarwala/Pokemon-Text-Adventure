package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import mainGame.MainGame;
import mainGame.Options;
import mainGame.TimerClass;


public class Dialogue extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, nextVisible;
	Player player;
	int textSpeed;
	Rival rival;
	JButton menuButton, returnButton, nextButton;
	TimerClass tm;
	PalletTownYourHouse palletTownYourHouse;
	JTextArea textArea;
	String text = "";
	
	public Dialogue (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean nextVisible) {
		
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.screen = screen;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.location = location2;
	     
	     setBackground(Color.black);
	     
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 JButton nextButton = new JButton("Next");
		 nextButton.setPreferredSize(new Dimension(150,75));
		 nextButton.setBackground(Color.DARK_GRAY);
		 nextButton.setForeground(Color.cyan);
		 nextButton.setFont(font);
		 nextButton.setVisible(nextVisible);
		 
		 textArea = new JTextArea();		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
	     
		 if (language == "Japanese") {
			 returnButton.setText("とじる");
			 nextButton.setText("つぎ");
		 }
		 
		 switch (screen) {
		 case "playsnes": 
			 if (language == "English") {
				 text = player.getName() + " is playing the SNES! ...Okay! It's time to go!";
				 }
			 else {
				 text = "";
				 }
			 break;
		 case "watchtv": 
			 if (language == "English") {
				 text = "There's a movie on TV. Four boys are walking on railroad tracks.\n" + 
				 		"I better go too.";
				 }
			 else {
				 text = "";
				 }
			 break;
			 
		 case "talktomom": 
			 if (language == "English") {
				 text = "Mom: Right. All boys leave home some day. It said so on TV.\n" + 
				 		"PROF.OAK, next door, is looking for you.";
				 }
			 else {
				 text = "";
				 }
			 break;
		 
		 }
		 
		 tm = new TimerClass(text, stopTimer, textSpeed , textArea);
	     
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     if (nextButton.isVisible()) {
	     gb.gridx=0;
	     gb.gridy=0;
	     gb.weighty = 1;
	     gb.insets = new Insets(-100,0,0,0);
	     add(returnButton, gb);
	     
	     gb.gridx=0;
	     gb.gridy=1;
	     gb.insets = new Insets(25,0,0,0);
	     add(textArea, gb);
	     
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nextButton, gb);
	     }
	     else {
	    	 
	    	 gb.gridx=0;
		     gb.gridy=0;
		     add(returnButton, gb);
		     
		     gb.gridx=0;
		     gb.gridy=1;
		     gb.weighty = 1;
		     gb.insets = new Insets(-150,0,0,0);
		     add(textArea, gb);
	    	 
	     }
	     
	     
	     returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	switch (location) {
	            	
	            	case "pallettownyourhouse":
	            		
	            		palletTownYourHouse = new PalletTownYourHouse(layout, cards, 
	            				font, screen, language, textSpeed, 
	            				player, rival, stopTimer, location);
	            		cards.add(palletTownYourHouse, "pallettownyourhouse");
	            	    layout.show(cards, "pallettownyourhouse");
	            		
	            	}

	            	    
	                
	            				}	
	            			}
				 		);
		
	}
	
}
