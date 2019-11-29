// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import items.*;
import Trainer.TrainerSuper;
import Trainer.*;

public class Inventory extends JPanel {
	
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
	TrainerSuper trainer;
	int battleScreenText;
	String color, previousLocation;
	
	public Inventory (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String previousLocation) {
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
	     this.trainer = trainer;
	     this.battleScreenText=battleScreenText;
	     this.previousLocation = previousLocation;
	     
	     
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
	     
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 ArrayList<JButton> buttonList = new ArrayList<JButton>();
		 
		 JButton item1Button = new JButton();
		 item1Button.setPreferredSize(new Dimension(300,75));
		 item1Button.setBackground(Color.DARK_GRAY);
		 item1Button.setForeground(Color.cyan);
		 item1Button.setFont(font);
		 
		 JButton item2Button = new JButton();
		 item2Button.setPreferredSize(new Dimension(300,75));
		 item2Button.setBackground(Color.DARK_GRAY);
		 item2Button.setForeground(Color.cyan);
		 item2Button.setFont(font);
		 
		 JButton item3Button = new JButton();
		 item3Button.setPreferredSize(new Dimension(300,75));
		 item3Button.setBackground(Color.DARK_GRAY);
		 item3Button.setForeground(Color.cyan);
		 item3Button.setFont(font);
		 
		 JButton item4Button = new JButton();
		 item4Button.setPreferredSize(new Dimension(300,75));
		 item4Button.setBackground(Color.DARK_GRAY);
		 item4Button.setForeground(Color.cyan);
		 item4Button.setFont(font);
		 
		 JButton item5Button = new JButton();
		 item5Button.setPreferredSize(new Dimension(300,75));
		 item5Button.setBackground(Color.DARK_GRAY);
		 item5Button.setForeground(Color.cyan);
		 item5Button.setFont(font);
		 
		 JButton item6Button = new JButton();
		 item6Button.setPreferredSize(new Dimension(300,75));
		 item6Button.setBackground(Color.DARK_GRAY);
		 item6Button.setForeground(Color.cyan);
		 item6Button.setFont(font);
		 
		 buttonList.add(item1Button);
		 buttonList.add(item2Button);
		 buttonList.add(item3Button);
		 buttonList.add(item4Button);
		 buttonList.add(item5Button);
		 buttonList.add(item6Button);
		 
		 
		 for (int i = 0; i < player.getItems().size(); i++) {
		  buttonList.get(i).setText(player.getItems().get(i).getItemName(language) + " x" + 
		 player.getItems().get(i).getCount());
		 }
		
		
		 JButton nextPageButton = new JButton("Next Page");
		 nextPageButton.setPreferredSize(new Dimension(300,75));
		 nextPageButton.setBackground(Color.DARK_GRAY);
		 nextPageButton.setForeground(Color.cyan);
		 nextPageButton.setFont(font);
	     	     
	     
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");
	    	 nextPageButton.setText("つぎ");
	     }
	     
	     gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);
		 
		 gb.gridx=1;
	     gb.gridy=1;
		 add(item1Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=2;
		 add(item2Button, gb);

		 gb.gridx=1;
	     gb.gridy=3;
		 add(item3Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=4;
		 add(item4Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=5;
		 add(item5Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=6;
		 add(item6Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=7;
		 add(nextPageButton, gb);
		 
		 for (JButton button : buttonList) {
			 button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) { 
		            	int buttonIndex = buttonList.indexOf(button);
	            		
	            		if (player.getItems().get(buttonIndex).getItemName(language) == "Map" || 
	            		player.getItems().get(buttonIndex).getItemName(language) ==  "ちず") {
	            			Map map = new Map(1);
	            			map.showMap(cl, cards, font, screen, language, textSpeed, player, rival, stopTimer,
	            					location, professorOakVisited, labOutsideButtonEnable, trainer, battleScreenText, color, previousLocation);
	            		}
	            		
	            		if (player.getItems().get(buttonIndex).getItemName(language) == "Potion" || 
	    	            		player.getItems().get(buttonIndex).getItemName(language) ==  "キズぐすり") {
	    	            			
	    	            			Potion potion = new Potion(1);
	    	            			potion.showPartyPokemon(cl, cards, font, screen, language, 
	    	            					textSpeed, player, rival, 
	    	            					stopTimer, location, professorOakVisited, 
	    	            					labOutsideButtonEnable, trainer, battleScreenText, "potion", "", buttonIndex, color, previousLocation);
	    	            			      		
	    	            		}
	            	  
		            	
		            }
		        });
		 }
		 
		
		 

		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
            		
	            	switch (location) {
	            	case "battle":
	            		Battle battle = new Battle(cl, cards, textAreaFont, 
		                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
		                		labOutsideButtonEnable, rival, battleScreenText, color, false, "", "", "", previousLocation);
		            	cards.add(battle, "battle");
		            	
		                layout.show(cards, "battle");
		                break;
	            	default:
	            		MenuScreen menu = new MenuScreen(cl, cards, font, screen, language, textSpeed, player,
	            				rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, trainer,
	            				battleScreenText, color, "");
	            		cards.add(menu, "menu");
	            	    layout.show(cards, "menu");
	            	    break;
	            		
	            	}
            		
            	  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
