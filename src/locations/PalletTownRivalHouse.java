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
import items.*;
import Trainer.TrainerSuper;

public class PalletTownRivalHouse extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	JLabel locationLabel;
	Dialogue dialogue;
	MenuScreen menu;
	PalletTownYourHouse palletTownYourHouse;
	int count = 0;
	String color;
	
	public PalletTownRivalHouse (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, String color) {
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
	     this.professorOakVisited = professorOakVisited;
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
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     
	     
	     locationLabel = new JLabel("<html> Rival House <br> Pallet Town <html>");
		 locationLabel.setForeground(Color.LIGHT_GRAY);
		 locationLabel.setFont(font);
	     
	     JButton outsideButton = new JButton("Outside");
	     outsideButton.setPreferredSize(new Dimension(225,75));
	     outsideButton.setBackground(Color.DARK_GRAY);
	     outsideButton.setForeground(Color.cyan);
	     outsideButton.setFont(font);
	     
	     JButton talkToRivalSisterButton = new JButton("Talk to " + rival.getName() + "'s sister");
	     talkToRivalSisterButton.setPreferredSize(new Dimension(400,75));
	     talkToRivalSisterButton.setBackground(Color.DARK_GRAY);
	     talkToRivalSisterButton.setForeground(Color.cyan);
	     talkToRivalSisterButton.setFont(font);
	     
	     JButton pickUpMapButton = new JButton("Pick up Map");
	     pickUpMapButton.setPreferredSize(new Dimension(250,75));
	     pickUpMapButton.setBackground(Color.DARK_GRAY);
	     pickUpMapButton.setForeground(Color.cyan);
	     pickUpMapButton.setFont(font);
	     
	     JButton menuButton = new JButton("Menu");
	     menuButton.setPreferredSize(new Dimension(200,75));
	     menuButton.setBackground(Color.DARK_GRAY);
	     menuButton.setForeground(Color.cyan);
	     menuButton.setFont(font);
	     
	     JButton blankButton = new JButton("");
	     blankButton.setPreferredSize(new Dimension(200,75));
	     blankButton.setBackground(Color.DARK_GRAY);
	     blankButton.setForeground(Color.cyan);
	     blankButton.setFont(font);
	     
	     if (language == "Japanese") {
	  
	    	 locationLabel.setText("<html>ライバル　の　いえ<br> マサラタウン<html>");
	    	 menuButton.setText("メニユー");    
	    	 pickUpMapButton.setText("ちずをひろう");
	    	 outsideButton.setText("そとにでいく");
	    	 talkToRivalSisterButton.setText(rival.getName() + "のおねえさんとはなす");
	    	 talkToRivalSisterButton.setPreferredSize(new Dimension(500,75));
	    	
	    	 
	     }
		 
	    //column 1
		 gb.gridx = 0;
		 gb.gridy = 2;
		 gb.weightx = 1;
		 gb.insets = new Insets(-75,0,0,0);
		 add(outsideButton, gb);
		
		 
	     
	     
	     //column 2
		 gb.gridx = 1;
		 gb.gridy = 0;
		 gb.weighty =1;
		 gb.insets = new Insets(0,0,78,0);
		 add(menuButton, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 1;
		
		 add(talkToRivalSisterButton, gb);
		 gb.gridx = 1;
		 gb.gridy = 2;
		 add(locationLabel, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 3;
		 add(blankButton, gb);
		 
		 //Column 3
		//column 3
		 gb.gridx = 2;
		 gb.gridy = 2;
		 add(pickUpMapButton, gb);
	
		 
		 outsideButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Outside outside = new Outside(layout, cards, 
	            			textAreaFont, screen, language, textSpeed, 
	            			player, rival, stopTimer, "outside", professorOakVisited, labOutsideButtonEnable, color);
	            	cards.add(outside, "outside");
	            	  layout.show(cards, "outside");
	            	        
	            }
	        });
		 
		 //Go to Dialogue
		 talkToRivalSisterButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "talktorivalsister", language, textSpeed,
	            			player, rival, stopTimer, "pallettownrivalhouse", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue"); 
	            	
	            }
	        });
		 
		 //Go to Dialogue and add Map to inventory, check if map already exists
		 pickUpMapButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	//If inventory is empty, add map
	              	if (player.getItems().isEmpty()) {
	              		Map map = new Map(1);
	              		player.addItem(map);
	              	}
	            	
	            	
	              	//If inventory contains map, count. If count is equal to size, add map
	            	int i;
	            	for (i = 0; i < player.getItems().size(); i++) {
	            		
	            	if (player.getItems().get(i).getItemName(language) != "Map" || 
	            			player.getItems().get(i).getItemName(language) != "ちず") {
	            	i++;
	
	            		}	            	
	               	if (i == player.getItems().size()-1) {	
		            	Map map = new Map(1);
		            	player.addItem(map);
		            	break;
		            	
		            	}
	             
	            	}
	            	
	     
	            	
	            
	            
	            	
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "pickupmap", language, textSpeed,
	            			player, rival, stopTimer, "pallettownrivalhouse", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue"); 
	            	 	
	            }
	        });
		 
		 
		 menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	TrainerSuper trainer = new TrainerSuper();

	            	menu = new MenuScreen(cl, cards, textAreaFont, "", language, textSpeed,
	            			player, rival, stopTimer, "pallettownrivalhouse", professorOakVisited, 
	            			labOutsideButtonEnable, trainer, 0, color, "");
	            	cards.add(menu, "menu");
	                layout.show(cards, "menu");  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
