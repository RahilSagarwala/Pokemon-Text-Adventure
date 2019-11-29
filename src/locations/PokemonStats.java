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

public class PokemonStats extends JPanel {
	
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
	
	public PokemonStats (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited, 
			Boolean labOutsideButtonEnable, Boolean pokedex, PokemonSuper pokemon, TrainerSuper trainer, 
			int battleScreenText, String color, String previousLocation) {
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
		 
		 JButton pokedexButton = new JButton("Pokedex");
	     pokedexButton.setPreferredSize(new Dimension(250,75));
	     pokedexButton.setBackground(Color.DARK_GRAY);
	     pokedexButton.setForeground(Color.cyan);
	     pokedexButton.setFont(font);
		 
		 JLabel nameLabel = new JLabel(pokemon.getPokemonName(language).toUpperCase());
		 nameLabel.setForeground(Color.LIGHT_GRAY);
		 nameLabel.setFont(font);
		 
		 JLabel numberLabel = new JLabel("No. " + pokemon.getNumber());
		 numberLabel.setForeground(Color.LIGHT_GRAY);
		 numberLabel.setFont(font);
		 
		 JLabel typeLabel = new JLabel("TYPE1" + "/" + pokemon.getType(language));
		 typeLabel.setForeground(Color.LIGHT_GRAY);
		 typeLabel.setFont(font);
		 
		 JLabel typeLabel2 = new JLabel("TYPE2" + "/" + pokemon.getType2(language));
		 typeLabel2.setForeground(Color.LIGHT_GRAY);
		 typeLabel2.setFont(font);
		 
		 JLabel idLabel = new JLabel("IDNo/" + pokemon.getId());
		 idLabel.setForeground(Color.LIGHT_GRAY);
		 idLabel.setFont(font);
		 
		 JLabel ownerLabel = new JLabel("OT/" + pokemon.getOwner());
		 ownerLabel.setForeground(Color.LIGHT_GRAY);
		 ownerLabel.setFont(font);
		 
		 JLabel statusLabel = new JLabel("STATUS/" + pokemon.getStatus(language));
		 statusLabel.setForeground(Color.LIGHT_GRAY);
		 statusLabel.setFont(font);
		 
		 JLabel levelLabel = new JLabel(":L" + pokemon.getLevel() + "");
		 levelLabel.setForeground(Color.LIGHT_GRAY);
		 levelLabel.setFont(font);
		 
		 
		 JLabel hpLabel = new JLabel("HP: " + pokemon.getHp() + "/" + pokemon.getMaxHp());
		 hpLabel.setForeground(Color.LIGHT_GRAY);
		 hpLabel.setFont(font);
		 
		 JLabel attackLabel = new JLabel("ATTACK: " + pokemon.getAttack() + "");
		 attackLabel.setForeground(Color.LIGHT_GRAY);
		 attackLabel.setFont(font);
		 
		 JLabel defenseLabel = new JLabel("DEFENSE: " + pokemon.getDefense() + "");
		 defenseLabel.setForeground(Color.LIGHT_GRAY);
		 defenseLabel.setFont(font);
		 
		 JLabel speedLabel = new JLabel("SPEED: " + pokemon.getSpeed() + "");
		 speedLabel.setForeground(Color.LIGHT_GRAY);
		 speedLabel.setFont(font);
		 
		 JLabel specialLabel = new JLabel("SPECIAL: " + pokemon.getSpecial() + "");
		 specialLabel.setForeground(Color.LIGHT_GRAY);
		 specialLabel.setFont(font);
		 
		 
		   
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");
	    	 attackLabel.setText("こうげき：　" + pokemon.getAttack());
	    	 defenseLabel.setText("ぼうぎょ：　" + pokemon.getDefense());
	    	 speedLabel.setText("すばやさ：　" + pokemon.getSpeed());
	    	 specialLabel.setText("とくしゅ：　" + pokemon.getSpecial());
	    	 ownerLabel.setText("おや/" + pokemon.getOwner());
	    	 typeLabel.setText("タイプ1/" + pokemon.getType(language));
	    	 typeLabel2.setText("タイプ2/　" + pokemon.getType2(language));
	    	 statusLabel.setText("じょうたい/" + pokemon.getStatus(language));
	    	 pokedexButton.setText("ずかん");

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
		 add(typeLabel, gb);
		 
		 if (pokemon.getType2(language) != null) {
		 gb.gridx=1;
	     gb.gridy=4;
		 add(typeLabel2, gb);
		 }
		 
		 gb.gridx=1;
	     gb.gridy=5;
		 add(idLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=6;
		 add(ownerLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=7;
		 add(statusLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=8;
		 add(levelLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=9;
		 add(hpLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=10;
		 add(attackLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=11;
		 add(defenseLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=12;
		 add(speedLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=13;
		 add(specialLabel, gb);
		 
		 gb.gridx=1;
	     gb.gridy=14;
		 add(pokedexButton, gb);
		 


		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
            		
	            	PartyPokemon partyPokemon = new PartyPokemon(cl, cards, textAreaFont, "", language, textSpeed,
	            			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, trainer,
	            			battleScreenText, "", 0, color, previousLocation);
	            	cards.add(partyPokemon, "partypokemon");
	                layout.show(cards, "partypokemon");
            	  
	            	
	            }
	        });
		 
		 pokedexButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
         		
	            	Pokedex pokedex = new Pokedex(cl, cards, textAreaFont, "", language, textSpeed,
                			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, false, 
                			pokemon, trainer, battleScreenText, color, previousLocation);
                	cards.add(pokedex, "pokedex");
                    layout.show(cards, "pokedex");
         	  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
