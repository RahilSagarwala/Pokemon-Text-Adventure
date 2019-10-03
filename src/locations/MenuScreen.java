package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import mainGame.Options;


public class MenuScreen extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer;
	Player player;
	int textSpeed;
	Rival rival;
	JButton returnButton, optionsButton;
	Options options;
	
	public MenuScreen (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2) {
		
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
	     
	     returnButton = new JButton();
	     returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 optionsButton = new JButton();
	     optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(font);
		 
		 if (language == "English") {
			 returnButton.setText("Return");
			 optionsButton.setText("Options");
		 }
		 
		 else {
			 returnButton.setText("もどる");
			 optionsButton.setText("せっていを かえる");
		 }
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     gb.gridx = 0;
	     gb.gridy = 0;
	     add(returnButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy = 1;
	     add(optionsButton, gb);
	     
	    returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	switch (location) {
	            	case "pallettownyourhouse":
	            	PalletTownYourHouse palletTownYourHouse = new PalletTownYourHouse(cl, cards, textAreaFont, "8", language, textSpeed,
	            			player, rival, stopTimer, "pallettownyourhouse");
	            	cards.add(palletTownYourHouse, "pallettownyourhouse");
	                layout.show(cards, "pallettownyourhouse");  
	            	}
	            	
	            }
	        });
	    
	    optionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
  
    	     JTextArea blankTextArea = new JTextArea();
    	     
    	
            	
            	options = new Options(cl,cards, "menu", blankTextArea, location, false, player, false, language, textSpeed, "",
            			rival, font, false, false, 65f, 0,0, true);
            	cards.add(options, "options");
                layout.show(cards, "options");  
            	
            	
            }
        });
		
	}
	
}
