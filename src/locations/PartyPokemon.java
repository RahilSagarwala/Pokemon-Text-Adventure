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
import Trainer.*;

public class PartyPokemon extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location, item;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed, itemIndex;
	Rival rival;
	JLabel locationLabel;
	Dialogue dialogue;
	MenuScreen menu;
	TrainerSuper trainer;
	int battleScreenText;
	String color, previousLocation;
	
	public PartyPokemon (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited, Boolean labOutsideButtonEnable,
			TrainerSuper trainer, int battleScreenText, String item, int itemIndex, String color, String previousLocation) {
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
	     this.item = item;
	     this.itemIndex = itemIndex;
	     this.color = color;
	     this.previousLocation=previousLocation;
	     
	     
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
		 
		 JButton pokemon1Button = new JButton();
		 pokemon1Button.setPreferredSize(new Dimension(300,75));
		 pokemon1Button.setBackground(Color.DARK_GRAY);
		 pokemon1Button.setForeground(Color.cyan);
		 pokemon1Button.setFont(font);
		 
		 JButton pokemon2Button = new JButton();
		 pokemon2Button.setPreferredSize(new Dimension(300,75));
		 pokemon2Button.setBackground(Color.DARK_GRAY);
		 pokemon2Button.setForeground(Color.cyan);
		 pokemon2Button.setFont(font);
		 
		 JButton pokemon3Button = new JButton();
		 pokemon3Button.setPreferredSize(new Dimension(300,75));
		 pokemon3Button.setBackground(Color.DARK_GRAY);
		 pokemon3Button.setForeground(Color.cyan);
		 pokemon3Button.setFont(font);
		 
		 JButton pokemon4Button = new JButton();
		 pokemon4Button.setPreferredSize(new Dimension(300,75));
		 pokemon4Button.setBackground(Color.DARK_GRAY);
		 pokemon4Button.setForeground(Color.cyan);
		 pokemon4Button.setFont(font);
		 
		 JButton pokemon5Button = new JButton();
		 pokemon5Button.setPreferredSize(new Dimension(300,75));
		 pokemon5Button.setBackground(Color.DARK_GRAY);
		 pokemon5Button.setForeground(Color.cyan);
		 pokemon5Button.setFont(font);
		 
		 JButton pokemon6Button = new JButton();
		 pokemon6Button.setPreferredSize(new Dimension(300,75));
		 pokemon6Button.setBackground(Color.DARK_GRAY);
		 pokemon6Button.setForeground(Color.cyan);
		 pokemon6Button.setFont(font);
		 
		 
		 
		 buttonList.add(pokemon1Button);
		 buttonList.add(pokemon2Button);
		 buttonList.add(pokemon3Button);
		 buttonList.add(pokemon4Button);
		 buttonList.add(pokemon5Button);
		 buttonList.add(pokemon6Button);
		 
		 
		 for (int i = 0; i < player.getPartyPokemonArrayList().size(); i++) {
		  buttonList.get(i).setText(player.getPartyPokemonArrayList().get(i).getPokemonName(language));
		 }
		
		
	     	     
	     
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");
	     }
	     
	     gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);
		 
		 gb.gridx=1;
	     gb.gridy=1;
		 add(pokemon1Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=2;
		 add(pokemon2Button, gb);

		 gb.gridx=1;
	     gb.gridy=3;
		 add(pokemon3Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=4;
		 add(pokemon4Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=5;
		 add(pokemon5Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=6;
		 add(pokemon6Button, gb);
		 
		 
		
		 if (item == "") {
		 for (JButton button : buttonList) {
			 switch (button.getText()) {
			 case "Charmander": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
	            		for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
	            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Charmander" || 
	            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "ヒトカゲ" ) {
	            			
	            			PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
	                    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
	                    			player.getPartyPokemonArrayList().get(i), trainer, battleScreenText, color, previousLocation);
	                    	cards.add(pokemonStats, "pokemonstats");
	                        layout.show(cards, "pokemonstats");
	            		}
	            	  
		            	
		            }
		        });
			 
			 break;
			 
			 case "ヒトカゲ": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
		            	for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
		            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Charmander" || 
		            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "ヒトカゲ" ) {
		            			//Show Pokemon stats screen
		            			PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
		                    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
		                    			player.getPartyPokemonArrayList().get(i), trainer, battleScreenText, color, previousLocation);
		                    	cards.add(pokemonStats, "pokemonstats");
		                        layout.show(cards, "pokemonstats");
	            		}
	            	  
		            	
		            }
		        });
			 break;
			 
			 case "Squirtle": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
	            		for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
	            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Squirtle" || 
	            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "ゼニガメ" ) {
	            			//Show Pokemon stats screen
	            			
	            			PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
	                    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
	                    			player.getPartyPokemonArrayList().get(i), trainer, battleScreenText, color, previousLocation);
	                    	cards.add(pokemonStats, "pokemonstats");
	                        layout.show(cards, "pokemonstats");
	            		}
	            	  
		            	
		            }
		        });
			 
			 break;
			 
			 case "ゼニガメ": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
	            		for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
	            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Squirtle" || 
	            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "ゼニガメ" ) {
	            			//Show Pokemon stats screen
	            			PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
	                    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
	                    			player.getPartyPokemonArrayList().get(i), trainer, battleScreenText, color, previousLocation);
	                    	cards.add(pokemonStats, "pokemonstats");
	                        layout.show(cards, "pokemonstats");
	            		}
	            	  
		            	
		            }
		        });
			 
			 break;
			 
			 case "Bulbasaur": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
	            		for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
	            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Bulbasaur" || 
	            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "フシギダネ" ) {
	            			//Show Pokemon stats screen
	            			PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
	                    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
	                    			player.getPartyPokemonArrayList().get(i), trainer, battleScreenText, color, previousLocation);
	                    	cards.add(pokemonStats, "pokemonstats");
	                        layout.show(cards, "pokemonstats");
	            		}
		            }
		        });
			 
			 break;
			 
			 case "フシギダネ": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
	            		for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
	            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Bulbasaur" || 
	            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "フシギダネ" ) {
	            			//Show Pokemon stats screen
	            			PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
	                    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
	                    			player.getPartyPokemonArrayList().get(i), trainer, battleScreenText, color, previousLocation);
	                    	cards.add(pokemonStats, "pokemonstats");
	                        layout.show(cards, "pokemonstats");
	            		}
		            }
		        });
			 
			 break;
			
			
			 
			 
			 
			 }
			 
			 
		 }
		 
	
		 }
		 
		 if (item == "potion") {
			 for (JButton button : buttonList) {
				 int buttonIndex = buttonList.indexOf(button);
			 button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	Potion potion = new Potion(1);
		            	potion.usePotion(player.getPartyPokemonArrayList().get(buttonIndex));
		            	

		            	player.getItems().get(itemIndex).setCount(player.getItems().get(itemIndex).getCount()-1);
		            	player.removeItems();
		            	
		            }
		        });
			 }
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
 
