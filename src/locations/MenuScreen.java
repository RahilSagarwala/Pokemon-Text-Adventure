// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import mainGame.Options;
import Trainer.TrainerSuper;
import Trainer.*;


public class MenuScreen extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	TrainerSuper trainer;
	Rival rival;
	JButton returnButton, optionsButton, pokemonButton, itemButton, saveButton, playerButton;
	Options options;
	int battleScreenText;
	String color, previousLocation;
	
	public MenuScreen (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String color, String previousLocation) {
		
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
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     this.battleScreenText = battleScreenText;
	     this.color = color;
	     this.previousLocation=previousLocation;
	     
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
	     
	     
//		 if (color == "black") {
//		        setBackground(Color.black); 
//			    }
//			    
//			    if (color == "cyan") {
//			        setBackground(Color.cyan); 
//				    }
		 
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
	            			player, rival, stopTimer, "pallettownyourhouse", professorOakVisited, labOutsideButtonEnable, color);
	            	cards.add(palletTownYourHouse, "pallettownyourhouse");
	                layout.show(cards, "pallettownyourhouse");  
	                break;
	                
	            	case "pallettownoutside":
		            	Outside outside = new Outside(cl, cards, textAreaFont, "9", language, textSpeed,
		            			player, rival, stopTimer, "outside", professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(outside, "outside");
		                layout.show(cards, "outside"); 
		                break;
		                
	            	case "pallettownrivalhouse":
	            		PalletTownRivalHouse palletTownRivalHouse = new PalletTownRivalHouse(cl, cards, textAreaFont, "8", language, textSpeed,
		            			player, rival, stopTimer, "pallettownyourhouse", professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(palletTownRivalHouse, "pallettownrivalhouse");
		                layout.show(cards, "pallettownrivalhouse");  
		                break;
		                
	            	case "pallettownlab":
	            		PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, "12", language, textSpeed,
		            			player, rival, stopTimer, "pallettownyourhouse", professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(palletTownLab, "pallettownlab");
		                layout.show(cards, "pallettownlab");  
		                break;
		                
	            	case "route1":
	            		Route1 route1 = new Route1(cl, cards, textAreaFont, "13", language, textSpeed,
		            			player, rival, stopTimer, "route1", professorOakVisited, trainer, color);
		            	cards.add(route1, "route1");
		                layout.show(cards, "route1");  
		                break;
		                
	            	case "battle":
	            		Battle battle = new Battle(cl, cards, textAreaFont, 
		                		"12", language, textSpeed, player, trainer, stopTimer, "battle", professorOakVisited, 
		                		labOutsideButtonEnable, rival, battleScreenText, color, false, "", "", "", previousLocation);
		            	cards.add(battle, "battle");
		                layout.show(cards, "battle");  
		                break;
	            	}
	            	
	            }
	        });
	    
	    optionsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
  
    	     JTextArea blankTextArea = new JTextArea();
            	
            	options = new Options(cl,cards, "menu", blankTextArea, location, false, player, false, language, textSpeed, "",
            			rival, font, false, false, 65f, 0,0, true, professorOakVisited, 
            			labOutsideButtonEnable, trainer, battleScreenText, color, "");
            	cards.add(options, "options");
                layout.show(cards, "options");  
            	
            	
            }
        });
	    
	    pokemonButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	PartyPokemon partyPokemon = new PartyPokemon(cl, cards, textAreaFont, "", language, textSpeed,
            			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, trainer, 
            			battleScreenText, "", 0, color, "");
            	cards.add(partyPokemon, "partypokemon");
                layout.show(cards, "partypokemon");

            	
            }
        });
	    
	    itemButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	Inventory inventory = new Inventory(cl, cards, textAreaFont, "", language, textSpeed,
            			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, 
            			trainer, battleScreenText, "");
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
            	TrainerInfo trainerInfo = new TrainerInfo(cl, cards, textAreaFont, "", language, textSpeed,
            			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, trainer, battleScreenText, color);
            	cards.add(trainerInfo, "trainerinfo");
                layout.show(cards, "trainerinfo");
            	
            }
        });
		
	}
	
	
	
	
}
