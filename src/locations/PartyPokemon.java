package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import items.*;

public class PartyPokemon extends JPanel {
	
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
	
	public PartyPokemon (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited, Boolean labOutsideButtonEnable) {
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
		 
		 
		
		 
		 for (JButton button : buttonList) {
			 switch (button.getText()) {
			 case "Charmander": button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {  		
	            		for (int i = 0; i<player.getPartyPokemonArrayList().size(); i++)
	            		if (player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "Charmander" || 
	            		player.getPartyPokemonArrayList().get(i).getPokemonName(language) == "ヒトカゲ" ) {
	            			//Show Pokemon stats screen
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
	            		}
	            	  
		            	
		            }
		        });
			 
			 break;
			 
			 
			 
			 
			 }
		 }

		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
            		
            		MenuScreen menu = new MenuScreen(cl, cards, font, screen, language, textSpeed, player,
            				rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable);
            		cards.add(menu, "menu");
            	    layout.show(cards, "menu");
            	  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
