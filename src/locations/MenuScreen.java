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
	JButton returnButton, optionsButton, pokemonButton, itemButton, saveButton, playerButton;
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
		 returnButton.setPreferredSize(new Dimension(400,100));
		 
		 optionsButton = new JButton();
	     optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(font);
		 optionsButton.setPreferredSize(new Dimension(400,100));
		 
		 pokemonButton = new JButton();
	     pokemonButton.setBackground(Color.DARK_GRAY);
		 pokemonButton.setForeground(Color.cyan);
		 pokemonButton.setFont(font);
		 pokemonButton.setPreferredSize(new Dimension(400,100));
		 
		 itemButton = new JButton();
	     itemButton.setBackground(Color.DARK_GRAY);
		 itemButton.setForeground(Color.cyan);
		 itemButton.setFont(font);
		 itemButton.setPreferredSize(new Dimension(400,100));
		 
		 playerButton = new JButton();
	     playerButton.setBackground(Color.DARK_GRAY);
		 playerButton.setForeground(Color.cyan);
		 playerButton.setFont(font);
		 playerButton.setPreferredSize(new Dimension(400,100));
		 
		 saveButton = new JButton();
	     saveButton.setBackground(Color.DARK_GRAY);
		 saveButton.setForeground(Color.cyan);
		 saveButton.setFont(font);
		 saveButton.setPreferredSize(new Dimension(400,100));
		 
		 if (language == "English") {
			 returnButton.setText("EXIT");
			 optionsButton.setText("OPTION");
			 pokemonButton.setText("POKéMON");
			 itemButton.setText("ITEM");
			 playerButton.setText(player.getName());
			 saveButton.setText("SAVE");
		 }
		 
		 else {
			 returnButton.setText("とじる");
			 optionsButton.setText("せっていを かえる");
			 pokemonButton.setText("ポケモン");
			 itemButton.setText("どうぐ");
			 playerButton.setText(player.getName());
			 saveButton.setText("レポート");
		 }
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     gb.gridx = 0;
	     gb.gridy = 0;
	     add(pokemonButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy = 1;
	     add(itemButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy = 2;
	     add(playerButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy = 3;
	     add(saveButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy = 4;
	     add(optionsButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy = 5;
	     add(returnButton, gb);
	     
	    returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	switch (location) {
	            	case "pallettownyourhouse":
	            	PalletTownYourHouse palletTownYourHouse = new PalletTownYourHouse(cl, cards, textAreaFont, "8", language, textSpeed,
	            			player, rival, stopTimer, "pallettownyourhouse");
	            	cards.add(palletTownYourHouse, "pallettownyourhouse");
	                layout.show(cards, "pallettownyourhouse");  
	                break;
	                
	            	case "pallettownoutside":
		            	Outside outside = new Outside(cl, cards, textAreaFont, "9", language, textSpeed,
		            			player, rival, stopTimer, "outside");
		            	cards.add(outside, "outside");
		                layout.show(cards, "outside"); 
		                break;
		                
	            	case "pallettownrivalhouse":
	            		PalletTownRivalHouse palletTownRivalHouse = new PalletTownRivalHouse(cl, cards, textAreaFont, "8", language, textSpeed,
		            			player, rival, stopTimer, "pallettownyourhouse");
		            	cards.add(palletTownRivalHouse, "pallettownrivalhouse");
		                layout.show(cards, "pallettownrivalhouse");  
		                break;
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
	    
	    pokemonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	

            	
            }
        });
	    
	    itemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Inventory inventory = new Inventory(cl, cards, textAreaFont, "", language, textSpeed,
            			player, rival, stopTimer, location);
            	cards.add(inventory, "inventory");
                layout.show(cards, "inventory");
            	
            }
        });
	    
	    saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            
            }
        });
	    
	    playerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	
            }
        });
		
	}
	
}
