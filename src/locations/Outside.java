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
import Trainer.TrainerSuper;

public class Outside extends JPanel {
	
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
	TrainerSuper trainer = new TrainerSuper();
	String color;

	
	public Outside(final CardLayout layout, final JPanel cards, 
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
	     
	     
	     
	     locationLabel = new JLabel("<html>Outside <br> Pallet Town <html>");
		 locationLabel.setForeground(Color.LIGHT_GRAY);
		 locationLabel.setFont(font);
	     
	     JButton yourHouseButton = new JButton("My House");
	     yourHouseButton.setPreferredSize(new Dimension(225,75));
	     yourHouseButton.setBackground(Color.DARK_GRAY);
	     yourHouseButton.setForeground(Color.cyan);
	     yourHouseButton.setFont(font);
	     
	     JButton rivalHouseButton = new JButton(rival.getName() + "'s House");
	     rivalHouseButton.setPreferredSize(new Dimension(300,75));
	     rivalHouseButton.setBackground(Color.DARK_GRAY);
	     rivalHouseButton.setForeground(Color.cyan);
	     rivalHouseButton.setFont(font);
	     
	     JButton labButton = new JButton("Lab");
	     labButton.setPreferredSize(new Dimension(200,75));
	     labButton.setBackground(Color.DARK_GRAY);
	     labButton.setForeground(Color.cyan);
	     labButton.setFont(font);
	     
	     JButton route1Button = new JButton("Route 1");
	     route1Button.setPreferredSize(new Dimension(200,75));
	     route1Button.setBackground(Color.DARK_GRAY);
	     route1Button.setForeground(Color.cyan);
	     route1Button.setFont(font);
	     
	     
	     JButton menuButton = new JButton("Menu");
	     menuButton.setPreferredSize(new Dimension(200,75));
	     menuButton.setBackground(Color.DARK_GRAY);
	     menuButton.setForeground(Color.cyan);
	     menuButton.setFont(font);
	     
	     if (language == "Japanese") {
	  
	    	 locationLabel.setText("<html>そと <br> マサラタウン<html>");
	    	 menuButton.setText("メニユー");    
	    	 yourHouseButton.setText("わたしのうち");
	    	 rivalHouseButton.setText(rival.getName() + "いえ");
	    	 route1Button.setText("ルート1");
	    	 labButton.setText("ラボ");
	    	 
	     }
		 
	    //column 1
		 gb.gridx = 0;
		 gb.gridy = 2;
		 gb.weightx = 1;
		 gb.insets = new Insets(-75,0,0,0);
		 add(yourHouseButton, gb);
		
		 
	     
	     
	     //column 2
		 gb.gridx = 1;
		 gb.gridy = 0;
		 gb.weighty =1;
		 gb.insets = new Insets(0,0,78,0);
		 add(menuButton, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 1;
		 add(rivalHouseButton, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 2;
		 add(locationLabel, gb);
		 
		 gb.gridx = 1;
		 gb.gridy = 3;
		 add(labButton, gb);
		 
		 //column 3
		 gb.gridx = 2;
		 gb.gridy = 2;
		 add(route1Button, gb);
	
		 
		 yourHouseButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	palletTownYourHouse = new PalletTownYourHouse(cl, cards, textAreaFont, 
	                		"8", language, textSpeed, player, rival, stopTimer, "My House", professorOakVisited, labOutsideButtonEnable, color);
	            	cards.add(palletTownYourHouse, "pallettownyourhouse");
	            	
	                layout.show(cards, "pallettownyourhouse");             
	            }
	        });
		 
		 rivalHouseButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	PalletTownRivalHouse palletTownRivalHouse = new PalletTownRivalHouse(cl, cards, textAreaFont, 
	                		"10", language, textSpeed, player, rival, stopTimer, "Rival House", professorOakVisited,
	                		labOutsideButtonEnable, color);
	            	cards.add(palletTownRivalHouse, "pallettownrivalhouse");
	            	
	                layout.show(cards, "pallettownrivalhouse");    
	            	
	            }
	        });
		 
		 labButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, 
	                		"12", language, textSpeed, player, rival, stopTimer, "pallettownlab", professorOakVisited, 
	                		labOutsideButtonEnable, color);
	            	cards.add(palletTownLab, "pallettownlab");
	            	
	                layout.show(cards, "pallettownlab");
	            }
	        });
		 
		 route1Button.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
			     if (professorOakVisited == false) {
			    	 Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "route1oak", language, textSpeed,
		         			player, rival, stopTimer, "route1oak", true, professorOakVisited, false, 0, labOutsideButtonEnable, color);
		         	cards.add(dialogue, "dialogue");
		             cl.show(cards, "dialogue"); 
			     }
			     else {
				 Route1 route1 = new Route1(cl, cards, textAreaFont, 
	                		"13", language, textSpeed, player, rival, stopTimer, "route1", professorOakVisited, trainer, color);
	            	cards.add(route1, "route1");
	            	
	                layout.show(cards, "route1");
			     }
			
				 
	            }
	        });
		 
		 menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	menu = new MenuScreen(cl, cards, textAreaFont, "", language, textSpeed,
	            			player, rival, stopTimer, "pallettownoutside", professorOakVisited, 
	            			labOutsideButtonEnable, trainer, 0, color, "");
	            	cards.add(menu, "menu");
	                layout.show(cards, "menu");  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
