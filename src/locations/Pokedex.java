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
import pokemon.*;
import Trainer.*;

public class Pokedex extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable, pokedex;
	Player player;
	int textSpeed;
	Rival rival;
	JLabel locationLabel;
	Dialogue dialogue;
	MenuScreen menu;
	PokemonSuper pokemon;
	TrainerSuper trainer;
	int battleScreenText;
	String color, previousLocation;
	
	public Pokedex (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited, 
			Boolean labOutsideButtonEnable, Boolean pokedex, PokemonSuper pokemon, 
			TrainerSuper trainer, int battleScreenText, String color, String previousLocation) {
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
	     this.pokedex = pokedex;
	     this.pokemon = pokemon;
	     this.trainer = trainer;
	     this.battleScreenText=battleScreenText;
	     this.color=color;
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
	
		 JLabel nameLabel = new JLabel(pokemon.getPokemonName(language).toUpperCase());
		 nameLabel.setForeground(Color.LIGHT_GRAY);
		 nameLabel.setFont(font);
		 
		 JLabel numberLabel = new JLabel("No. " + pokemon.getNumber());
		 numberLabel.setForeground(Color.LIGHT_GRAY);
		 numberLabel.setFont(font);
		 
		 JLabel speciesLabel = new JLabel(pokemon.getSpecies(language));
		 speciesLabel.setForeground(Color.LIGHT_GRAY);
		 speciesLabel.setFont(font);
		 
		 JLabel heightLabel = new JLabel(pokemon.getHeight(language));
		 heightLabel.setForeground(Color.LIGHT_GRAY);
		 heightLabel.setFont(font);
		 
		 JLabel weightLabel = new JLabel(pokemon.getweight(language));
		 weightLabel.setForeground(Color.LIGHT_GRAY);
		 weightLabel.setFont(font);
		 
		 JTextArea textArea = new JTextArea(pokemon.getPokedex(language));		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
		 	 
		   
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");

	     }
	     
	     gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);

		 gb.gridx=1;
	     gb.gridy=1;
		 add(nameLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=2;
		 add(numberLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=3;
		 add(speciesLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=4;
		 add(heightLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=5;
		 add(weightLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=6;
		 add(textArea, gb);
		 
		 
		 
		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
            		
	            	PokemonStats pokemonStats = new PokemonStats(cl, cards, textAreaFont, "", language, textSpeed,
                			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
                			pokemon, trainer, battleScreenText, color, previousLocation);
                	cards.add(pokemonStats, "pokemonstats");
                    layout.show(cards, "pokemonstats");
            	  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
