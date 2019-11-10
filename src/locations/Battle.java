package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.TrainerSuper;
import Trainer.Player;
import Trainer.Rival;
import mainGame.Options;
import mainGame.TimerClass;


public class Battle extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	TrainerSuper trainer;
	Rival rival;
	JButton lmenuButton;
	int battleScreenText;
	String color;
	
	public Battle (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, TrainerSuper trainer, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, Rival rival, int battleScreenText2, String color) {
		
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.screen = screen;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.trainer = trainer;
	     this.stopTimer = stopTimer;
	     this.location = location2;
	     this.professorOakVisited = professorOakVisited;
	     this.labOutsideButtonEnable = labOutsideButtonEnable;
	     this.battleScreenText = battleScreenText2;
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
	     
	     JButton optionsButton = new JButton("Options");
	     optionsButton.setPreferredSize(new Dimension(200,75));
	     optionsButton.setBackground(Color.DARK_GRAY);
	     optionsButton.setForeground(Color.cyan);
	     optionsButton.setFont(font);
	     
	     JButton fightButton = new JButton("FIGHT");
	     fightButton.setPreferredSize(new Dimension(200,75));
	     fightButton.setBackground(Color.DARK_GRAY);
	     fightButton.setForeground(Color.cyan);
	     fightButton.setFont(font);
	     
	     JButton pokemonButton = new JButton("PKMN");
	     pokemonButton.setPreferredSize(new Dimension(200,75));
	     pokemonButton.setBackground(Color.DARK_GRAY);
	     pokemonButton.setForeground(Color.cyan);
	     pokemonButton.setFont(font);
	     
	     JButton itemButton = new JButton("ITEM");
	     itemButton.setPreferredSize(new Dimension(200,75));
	     itemButton.setBackground(Color.DARK_GRAY);
	     itemButton.setForeground(Color.cyan);
	     itemButton.setFont(font);
	     
	     JButton runButton = new JButton("RUN");
	     runButton.setPreferredSize(new Dimension(200,75));
	     runButton.setBackground(Color.DARK_GRAY);
	     runButton.setForeground(Color.cyan);
	     runButton.setFont(font);
	     
	     JLabel playerPokemonLevelLabel = new JLabel();
		 playerPokemonLevelLabel.setForeground(Color.LIGHT_GRAY);
		 playerPokemonLevelLabel.setFont(font);
	     
	     if (player.getPartyPokemonArrayList().size() >= 1) {
	     playerPokemonLevelLabel.setText("L:"+player.getPartyPokemonArrayList().get(0).getLevel() + "");
	     }
	     
	     JLabel playerPokemonNameLabel = new JLabel();
		 playerPokemonNameLabel.setForeground(Color.LIGHT_GRAY);
		 playerPokemonNameLabel.setFont(font);
	     
	     if (player.getPartyPokemonArrayList().size() >= 1) {
	    	 playerPokemonNameLabel.setText(player.getPartyPokemonArrayList().get(0).getPokemonName(language));
	     }
	     
	     JLabel playerPokemonHpLabel = new JLabel();
	     playerPokemonHpLabel.setForeground(Color.LIGHT_GRAY); 
	     playerPokemonHpLabel.setFont(font);
		 
	     if (player.getPartyPokemonArrayList().size() >= 1) {
	    	playerPokemonHpLabel.setText("HP: " + player.getPartyPokemonArrayList().get(0).getHp() + "/" + 
	     player.getPartyPokemonArrayList().get(0).getMaxHp());
	     }
	     
	     JLabel trainerPokemonHpLabel = new JLabel();
	     trainerPokemonHpLabel.setForeground(Color.LIGHT_GRAY); 
	     trainerPokemonHpLabel.setFont(font);
		 
		 if (trainer.getPartyPokemonArrayList().size() >= 1) {
			 trainerPokemonHpLabel.setText("HP: " + trainer.getPartyPokemonArrayList().get(0).getHp() + "/" + 
					 trainer.getPartyPokemonArrayList().get(0).getMaxHp());
		     }
		 
		 JLabel trainerPokemonNameLabel = new JLabel();
		 trainerPokemonNameLabel.setForeground(Color.LIGHT_GRAY);
		 trainerPokemonNameLabel.setFont(font);
	     
	     if (trainer.getPartyPokemonArrayList().size() >= 1) {
	    	 trainerPokemonNameLabel.setText(trainer.getPartyPokemonArrayList().get(0).getPokemonName(language));
	     }
	     
	     JLabel trainerPokemonLevelLabel = new JLabel();
	     trainerPokemonLevelLabel.setForeground(Color.LIGHT_GRAY);
	     trainerPokemonLevelLabel.setFont(font);
	     
	     if (trainer.getPartyPokemonArrayList().size() >= 1) {
	    	 trainerPokemonLevelLabel.setText("L:" + trainer.getPartyPokemonArrayList().get(0).getLevel() + "");
	     }

	     if (language == "Japanese") { 
	    	 optionsButton.setText("せっていを かえる");
	    	 fightButton.setText("たたかう");
	    	 runButton.setText("にげる");
	    	 itemButton.setText("どうぐ");
	    	 pokemonButton.setText("ポケモン");
		     optionsButton.setPreferredSize(new Dimension(400,75));
	    	 
	    	 
	    	 
	     }
	     
	     JTextArea textArea = new JTextArea();		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
		 
		 String text = "";
		 
		 if(player.getPartyPokemonArrayList().size() >= 1 && battleScreenText == 0 && language == "English"){
			 text = trainer.getName() + " wants to" + "\n" + "fight. " + rival.getName() + "\n" + " sent out " + 
			 rival.getPartyPokemonArrayList().get(0).getPokemonName(language).toUpperCase() + "!" + "\n" + 
			  "Go! "  + player.getPartyPokemonArrayList().get(0).getPokemonName(language).toUpperCase() + "!";
		 
		 }
		 
		 if(player.getPartyPokemonArrayList().size() >= 1 && battleScreenText == 0 && language == "Japanese"){
			 text = trainer.getName() +  "が　しょうぶを" + "\n" + "しかけてきた！"+ trainer.getName() +"\n" + "は"+ trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + 
					"\n"+"を"+ "くリだした！"+ "\n" + "ゆけっ！　" + player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "!";
			 
			 }
		 
		 switch (battleScreenText) {
		 case 999: 
			 if( language == "English") {
				 text = "You cannot run" + "\n" + "from a trainer battle.";
			 }
			 
			 if (language == "Japanese") {
				 text = "ダメだ！　しょうぶの" + "\n" + "さいちゅうに　あいてに" + "\n" +"せなかは"  + "みせられない！";
			 }
			 break;
		 }
		 
		 TimerClass tm = new TimerClass(text, stopTimer, textSpeed , textArea);
		 
	    
	     gb.gridx=0;
	     gb.gridy=0;
	     gb.weighty = 1;
	     gb.insets = new Insets(-50,0,0,-400);
	     add(optionsButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=1;
	     gb.insets = new Insets(-75,-250,-100,50);
	     add(playerPokemonNameLabel, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=2;
	     add(playerPokemonLevelLabel, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=3;
	     add(playerPokemonHpLabel, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=4;
	     gb.insets = new Insets(0,-250,0,350);
	     add(fightButton, gb);
	   
	     gb.gridx = 1;
	     gb.gridy=4;
	     add(pokemonButton, gb);
	          
	     gb.gridx = 0;
	     gb.gridy=5;
	     add(itemButton, gb);
	     
	     gb.gridx = 1;
	     gb.gridy=5;
	     add(runButton, gb);
	     
	     gb.gridx = 1;
	     gb.gridy=4;
	     gb.insets = new Insets(-200,0,0,0);
	     add(textArea, gb);
	     
	     gb.gridx = 3;
	     gb.gridy=0;
	     gb.insets = new Insets(0,0,-100,-400);
	     add(trainerPokemonNameLabel, gb);
	     
	     gb.gridx = 3;
	     gb.gridy=1;
	     add(trainerPokemonLevelLabel, gb);
	     
	     gb.gridx = 3;
	     gb.gridy=2;
	     add(trainerPokemonHpLabel, gb);
	     
    
	     optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JTextArea blankTextArea = new JTextArea();
	            	
	            	Options options = new Options(cl,cards, "battle", blankTextArea, location, false, player, false, language, textSpeed, "",
	            			rival, font, false, false, 65f, 0,0, true, professorOakVisited, 
	            			labOutsideButtonEnable, trainer, battleScreenText, color);
	            	cards.add(options, "options");
	                layout.show(cards, "options");  
	            	
	            }
	        });
	     
	     fightButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	
	            }
	        });
	     
	     pokemonButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	PartyPokemon partyPokemon = new PartyPokemon(cl, cards, textAreaFont, "battle", language, textSpeed,
	            			player, rival, stopTimer, "battle", professorOakVisited, labOutsideButtonEnable, trainer,
	            			battleScreenText, "", 0, color);
	            	cards.add(partyPokemon, "partypokemon");
	                layout.show(cards, "partypokemon");
	            	
	            }
	        });
	     
	     itemButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	Inventory inventory = new Inventory(cl, cards, textAreaFont, "battle", language, textSpeed,
	            			player, rival, stopTimer, "battle", professorOakVisited, labOutsideButtonEnable, trainer, battleScreenText);
	            	cards.add(inventory, "inventory");
	                layout.show(cards, "inventory");
	            }
	        });
	     
	     runButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {	 
	            	battleScreenText = 999;
	            	Battle battle = new Battle(cl, cards, textAreaFont, 
	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
	                		labOutsideButtonEnable, rival, battleScreenText, color);
	            	cards.add(battle, "battle");
	            	
	                layout.show(cards, "battle");
	            }
	        });
	     
	     
		
	}
	
}
