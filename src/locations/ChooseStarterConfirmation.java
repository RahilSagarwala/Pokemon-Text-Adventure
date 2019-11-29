// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import mainGame.*;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import locations.PalletTownYourHouse;
import pokemon.*;

public class ChooseStarterConfirmation extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location, pokemon;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	JButton menuButton;
	JTextArea textArea;
	String color;

   
	public ChooseStarterConfirmation(final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideEnable, String pokemon, String color) {
		
		 //Attributes passed on from screen to screen, couple of them not needed anymore, player 2 has its name set in case 4
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
	     this.labOutsideButtonEnable = labOutsideEnable;
	     this.pokemon = pokemon;
	     this.color = color;
	     
	     
	     //Extension of JFrame, set layout and attributes for layout
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
		 textArea = new JTextArea();		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
	
		 
		 JButton yesButton = new JButton("Yes");
		 yesButton.setBackground(Color.DARK_GRAY);
		 yesButton.setForeground(Color.cyan);
		 yesButton.setFont(font);
		 yesButton.setPreferredSize(new Dimension(200,100));
		 
		 
		 JButton noButton = new JButton("No");
		 noButton.setBackground(Color.DARK_GRAY);
		 noButton.setForeground(Color.cyan);
		 noButton.setFont(font);
		 noButton.setPreferredSize(new Dimension(200,100));
		 
		 
		 
		 //Elements not used dynamically have their text changed based off of language
		 if (language == "Japanese") {
			 noButton.setText("いいえ");
			 yesButton.setText("はい");		 
		 }	 
		 
		 switch (pokemon) {
		 case "charmander": 
			 if (language == "English") {
				 textArea.setText("Choose the fire type Charmander?");
			 }
			 
			 else {
				 textArea.setText("ほう！ほのおのポケモン" + "\n" +"ヒトカゲに　するんじゃな？");
			 }
			 break;
			 
		 case "squirtle": 
			 if (language == "English") {
				 textArea.setText("Choose the water type Squirtle?");
			 }
			 
			 else {
				 textArea.setText("ほう！ほのおのポケモン"+"\n"+"ゼニガメに　するんじゃな？");
			 }
			 break;
			 
		 case "bulbasaur": 
			 if (language == "English") {
				 textArea.setText("Choose the grass type Bulbasaur?");
			 }
			 
			 else {
				 textArea.setText("ほう！ほのおのポケモン"+"\n"+"フシギダネに　するんじゃな？");
			 }
			 break;
			 
		 }


		 gb.gridx=0;
	     gb.gridy=1;
		 add(yesButton, gb);
		 
		 
		 JLabel blankLabel = new JLabel("");
		 blankLabel.setFont(font);
		 blankLabel.setForeground(Color.cyan);
		 gb.gridx=0;
	     gb.gridy=2;
	     gb.weighty=1;
		 add(blankLabel, gb);
		 
		 
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty=1;
		 add(textArea, gb);
		 
		 gb.gridx=2;
	     gb.gridy=1;
		 add(noButton, gb);
		 
	 	 
	  
		 noButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	ChooseStarter chooseStarter = new ChooseStarter(layout, cards, 
	            			textAreaFont, screen, language, textSpeed, 
	            			player, rival, stopTimer, "choosestarter", professorOakVisited, labOutsideButtonEnable, color);
	            	cards.add(chooseStarter, "choosestarter");
	            	  layout.show(cards, "choosestarter");            	
	            }
	        });
		 
		 yesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	switch (pokemon) {
	            	case "charmander":
	            		Charmander charmander = new Charmander("");
	            		charmander.generateStats();
	            		charmander.generateId();
	            		charmander.generateOwner(player.getName());
	            		player.addPokemonToParty(charmander);
	            		
	            		Squirtle squirtle = new Squirtle("");
	            		squirtle.generateStats();
	            		squirtle.generateId();
	            		squirtle.generateOwner(player.getName());
	            		rival.addPokemonToParty(squirtle);
	            		

		            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "starterchosen", language, textSpeed,
		            			player, rival, stopTimer, "pallettownlab", true, professorOakVisited, false, 
		            			0, labOutsideButtonEnable, color);
		            	cards.add(dialogue, "dialogue");
		                layout.show(cards, "dialogue");
	            		
	            		break;
	            	case "squirtle":
	            		squirtle = new Squirtle("");
	            		squirtle.generateStats();
	            		squirtle.generateId();
	            		squirtle.generateOwner(player.getName());
	            		player.addPokemonToParty(squirtle);
	            		
	            		Bulbasaur bulbasaur = new Bulbasaur("");
	            		bulbasaur.generateStats();
	            		bulbasaur.generateId();
	            		bulbasaur.generateOwner(player.getName());
	            		rival.addPokemonToParty(bulbasaur);

	            		
	            		dialogue = new Dialogue(cl, cards, textAreaFont, "starterchosen", language, textSpeed,
		            			player, rival, stopTimer, "pallettownlab", true, professorOakVisited, false, 0, 
		            			labOutsideButtonEnable, color);
		            	cards.add(dialogue, "dialogue");
		                layout.show(cards, "dialogue");
	            		
	            		
	            		break;
	            	case "bulbasaur":
	            		
	            		bulbasaur = new Bulbasaur("");
	            		bulbasaur.generateStats();
	            		bulbasaur.generateId();
	            		bulbasaur.generateOwner(player.getName());
	            		player.addPokemonToParty(bulbasaur);
	            		
	            		charmander = new Charmander("");
	            		charmander.generateStats();
	            		charmander.generateId();
	            		charmander.generateOwner(player.getName());
	            		rival.addPokemonToParty(charmander);
	            		
	            		dialogue = new Dialogue(cl, cards, textAreaFont, "starterchosen", language, textSpeed,
		            			player, rival, stopTimer, "pallettownlab", true, professorOakVisited, false, 0, 
		            			labOutsideButtonEnable, color);
		            	cards.add(dialogue, "dialogue");
		                layout.show(cards, "dialogue");
	            		
	            		
	            		break;
	            	}
       	
	            }
	        });
		 
		 
		 
	
		
	}
	
	
	}
	
	
