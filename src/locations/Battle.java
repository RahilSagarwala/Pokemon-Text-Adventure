package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import Trainer.TrainerSuper;
import items.Map;
import items.Potion;
import Trainer.Player;
import Trainer.Rival;
import mainGame.Options;
import mainGame.TimerClass;


public class Battle extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location, text, playerAttack, trainerAttack;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	TrainerSuper trainer;
	Rival rival;
	JButton lmenuButton;
	int battleScreenText;
	String color;
	Boolean showAttacks;
	String previousLocation;
	
	public Battle (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, TrainerSuper trainer, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, Rival rival, int battleScreenText2, String color, Boolean showAttacks, String text,
			String playerAttack2, String trainerAttack2, String previousLocation) {
		
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
	     this.showAttacks = showAttacks;
	     this.playerAttack = playerAttack2;
	     this.trainerAttack = trainerAttack2;
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

	    
	     
	     JTextArea textArea = new JTextArea();		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
		 
		 
		 if(player.getPartyPokemonArrayList().size() >= 1 && battleScreenText == 0 && language == "English"){
			 text = trainer.getName() + " wants to" + "\n" + "fight. " + trainer.getName() + "\n" + " sent out " + 
			 trainer.getPartyPokemonArrayList().get(0).getPokemonName(language).toUpperCase() + "!" + "\n" + 
			  "Go! "  + player.getPartyPokemonArrayList().get(0).getPokemonName(language).toUpperCase() + "!";
		 
		 }
		 
		 if(player.getPartyPokemonArrayList().size() >= 1 && battleScreenText == 0 && language == "Japanese"){
			 text = trainer.getName() +  "が　しょうぶを" + "\n" + "しかけてきた！"+ trainer.getName() +"\n" + "は"+ trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + 
					"\n"+"を"+ "くリだした！"+ "\n" + "ゆけっ！　" + player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "!";
			 
			 }
		 
		 
		 JButton nextButton = new JButton("Next");
		 nextButton.setPreferredSize(new Dimension(250,75));
		 nextButton.setBackground(Color.DARK_GRAY);
		 nextButton.setForeground(Color.cyan);
		 nextButton.setFont(font);
		 nextButton.setVisible(false);
		 
		 //Win
		 if (trainer.getPartyPokemonArrayList().get(0).getHp() <= 0) {
	 			battleScreenText = 1;
	 			//disable all buttons
	 			fightButton.setVisible(false);
	 			itemButton.setVisible(false);
	 			pokemonButton.setVisible(false);
	 			runButton.setVisible(false);
	 			optionsButton.setVisible(false);
	 			//enable next button to direct to dialogue which then directs to previous location before battle
	 			nextButton.setVisible(true);
	 			player.setMoney(player.getMoney() + 1000);
	 		}
		 
	
		 
		 //Lose
	     if (player.getPartyPokemonArrayList().get(0).getHp() <= 0) {
			battleScreenText = 2;
			//disable all buttons
			fightButton.setVisible(false);
 			itemButton.setVisible(false);
 			pokemonButton.setVisible(false);
 			runButton.setVisible(false);
 			optionsButton.setVisible(false);
 			//enable next button to direct to dialogue which then directs to previous location before battle
 			nextButton.setVisible(true);
 			player.setMoney(player.getMoney() - 1000);
 			if (player.getMoney() < 0) {
 				player.setMoney(0);
 			}
 			
 			
			
		}
		 
		 switch (battleScreenText) {
		 case 3: 
			 if( language == "English") {
				 text = player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + " used "  + "\n"
			 + playerAttack + "! " + "\n" + "Enemy" + "\n" +  trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + 
						 " used " + "\n" + trainerAttack + "!";
			 }
			 
			 if (language == "Japanese") {
				 text = player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "の" + "\n" + playerAttack + "!" + "\n" +
			 "てきの" + "\n" + trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + trainerAttack +
			 "!";

			 }
			 break;
			 
		 case 4: 
			 text = "";
			 break;
		 case 999: 
			 if( language == "English") {
				 text = "You cannot run" + "\n" + "from a trainer battle.";
			 }
			 
			 if (language == "Japanese") {
				 text = "ダメだ！　しょうぶの" + "\n" + "さいちゅうに　あいてに" + "\n" +"せなかは"  + "みせられない！";
			 }
			 break;
			 
		//win	 
		 case 1: 
			 if( language == "English") {
				 text = player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + " used "  + "\n"
						 + playerAttack + "! " + "\n" + "Enemy" + "\n" + 
						 trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + " used " + "\n" +
						 trainerAttack + "!" + "\n" + trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" 
						 + "fainted." + "\n" + player.getName() + "\n" + " received ￥1000."; 
						 
			 }
			 
			 if (language == "Japanese") {
				 text = player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "の" + "\n" + playerAttack + "!" + "\n" +
						 "てきの" + "\n" + trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + trainerAttack +
						 "!" + "\n" + "きての　" + "\n" + trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" +
						 "たおれた！" + "\n" + player.getName() + " １０００￥　を" + "\n" +"かくとく　しました。";
			 }
			 break;
			 
		//lose 
		 case 2: 
			 if( language == "English") {
				 text = player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + " used "  + "\n"
						 + playerAttack + "! " + "\n" +  "Enemy" + "\n" +
						 trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + " used " + "\n" +
						 trainerAttack + "!" + "\n" + player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" 
						 + "fainted." + "\n" + player.getName() + "\n" + " lost ￥1000.";
			 }
			 
			 if (language == "Japanese") {
				 text = player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "の" + "\n" + playerAttack + "!" + "\n" +
						 "てきの" + "\n" + trainer.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" + trainerAttack +
						 "!"+ "\n" + "きての　" + "\n" + player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "\n" +
						 "たおれた！" + "\n" + player.getName() + " １０００￥　を" + "\n" +"かくとく　うしないました。";
			 }
			 break;
			 
			 
		 }
		 

 		
 		
		 
		 TimerClass tm = new TimerClass(text, stopTimer, textSpeed , textArea);
		 
		 ArrayList<JButton> buttonList = new ArrayList<JButton>();
		 
		 JButton attack1Button = new JButton();
		 attack1Button.setPreferredSize(new Dimension(225,75));
		 attack1Button.setBackground(Color.DARK_GRAY);
		 attack1Button.setForeground(Color.cyan);
		 attack1Button.setFont(font);
		 
		 JButton attack2Button = new JButton();
		 attack2Button.setPreferredSize(new Dimension(225,75));
		 attack2Button.setBackground(Color.DARK_GRAY);
		 attack2Button.setForeground(Color.cyan);
		 attack2Button.setFont(font);
		 
		 JButton attack3Button = new JButton();
		 attack3Button.setPreferredSize(new Dimension(225,75));
		 attack3Button.setBackground(Color.DARK_GRAY);
		 attack3Button.setForeground(Color.cyan);
		 attack3Button.setFont(font);
		 
		 JButton attack4Button = new JButton();
		 attack4Button.setPreferredSize(new Dimension(225,75));
		 attack4Button.setBackground(Color.DARK_GRAY);
		 attack4Button.setForeground(Color.cyan);
		 attack4Button.setFont(font);
		 
		 JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(250,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		
		 
		 buttonList.add(attack1Button);
		 buttonList.add(attack2Button);
		 buttonList.add(attack3Button);
		 buttonList.add(attack4Button);
		 
		 for (int i = 0; i < player.getPartyPokemonArrayList().get(0).getAttacks().size(); i++) {
			 if ((player.getPartyPokemonArrayList().get(0).getAttacks().get(i) != null)) {
			  buttonList.get(i).setText(player.getPartyPokemonArrayList().get(0).getAttacks().get(i).getAttackName(language)
					  + " x" + 
					  player.getPartyPokemonArrayList().get(0).getAttacks().get(i).getPp());
			 }
			 else {
				 buttonList.get(i).setText("");
			 }
			 }
				
		 if (language == "Japanese") { 
	    	 optionsButton.setText("せっていを かえる");
	    	 fightButton.setText("たたかう");
	    	 runButton.setText("にげる");
	    	 itemButton.setText("どうぐ");
	    	 pokemonButton.setText("ポケモン");
		     optionsButton.setPreferredSize(new Dimension(400,75));
		     returnButton.setText("とじる"); 
		     nextButton.setText("つぎ");
	    	 
	     }
	    
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
	     
	     if (showAttacks == false) {
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
	     }
	     
	     else {
	    	 gb.gridx = 0;
		     gb.gridy=4;
		     gb.insets = new Insets(0,-250,0,350);
		     add(buttonList.get(0), gb);
		   
		     gb.gridx = 1;
		     gb.gridy=4;
		     add(buttonList.get(1), gb);
		          
		     gb.gridx = 0;
		     gb.gridy=5;
		     add(buttonList.get(2), gb);
		     
		     gb.gridx = 1;
		     gb.gridy=5;
		     add(buttonList.get(3), gb);
		     
		     gb.gridx = 1;
		     gb.gridy=5;
		     gb.insets = new Insets(0,0,0,0);
		     add(returnButton, gb);
	     }
	     
	     gb.gridx = 1;
	     gb.gridy=5;
	     gb.insets = new Insets(0,0,0,0);
	     add(nextButton, gb);
	     
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
	     


 	  
	     
	     
		 for (JButton button : buttonList) {
			 button.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) { 
		            	int buttonIndex = buttonList.indexOf(button);
		            	
	            		
		            	//Need to add separate statement for leer and growl, they have separate methods
		            	//Need to add Japanese language names
	            		if (player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "Scratch" || player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "Tackle" || player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "たいあたリ" || player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "ひつかく") { 
	            			player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex)
	            			.useAttack(player.getPartyPokemonArrayList().get(0), trainer.getPartyPokemonArrayList().get(0));
	            			
	            			playerAttack = player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language);	
	            			
	            		}
	            		
	            		if (player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "Tail Whip" || player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "しつぽをふる") { 
	            			player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex)
	            			.useTailWhip(player.getPartyPokemonArrayList().get(0), trainer.getPartyPokemonArrayList().get(0));
	            			
	            			playerAttack = player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language);	
	            			
	            		}
	            		
	            		if (player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "Growl" || player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language) 
	            				== "なきごえ") { 
	            			player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex)
	            			.useGrowl(player.getPartyPokemonArrayList().get(0), trainer.getPartyPokemonArrayList().get(0));
	            			
	            			playerAttack = player.getPartyPokemonArrayList().get(0).getAttacks().get(buttonIndex).getAttackName(language);	
	            			
	            		}
	            			
	            			//Need to randomize index value for random attack
	            		    int x = (int)(Math.random() * (((trainer.getPartyPokemonArrayList().get(0).getAttacks().size() - 1) - 0) + 1)) + 0;
	            		    if (trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "Tackle" ||
	            		    		trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "Scratch" ||
	            		    		trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "たいあたリ" ||
	            		    		trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "ひつかく")
	            		    trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).
	            			useAttack(trainer.getPartyPokemonArrayList().get(0), player.getPartyPokemonArrayList().get(0));
	            			
	            			trainerAttack = trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language);
	            			
	            			Battle battle = new Battle(cl, cards, textAreaFont, 
	    	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
	    	                		labOutsideButtonEnable, rival, 3, color, false, "", playerAttack, trainerAttack, previousLocation);
	    	            	cards.add(battle, "battle");
	    	            	
	    	                layout.show(cards, "battle");
	    	                
	    	                if (trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "Growl" ||
	    	                		trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "なきごえ") {
	            		    trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).
	            			useGrowl(trainer.getPartyPokemonArrayList().get(0), player.getPartyPokemonArrayList().get(0));
	            			
	            			trainerAttack = trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language);
	            			
	            			battle = new Battle(cl, cards, textAreaFont, 
	    	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
	    	                		labOutsideButtonEnable, rival, 3, color, false, "", playerAttack, trainerAttack, previousLocation);
	    	            	cards.add(battle, "battle");
	    	            	
	    	                layout.show(cards, "battle");
	    	                
	    	                
	    	                }
	    	                
	    	                if (trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "Tail Whip" ||
	    	                		trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language) == "しつぽをふる") {
		            		    trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).
		            			useTailWhip(trainer.getPartyPokemonArrayList().get(0), player.getPartyPokemonArrayList().get(0));
		            			
		            			trainerAttack = trainer.getPartyPokemonArrayList().get(0).getAttacks().get(x).getAttackName(language);
		            			
		            			battle = new Battle(cl, cards, textAreaFont, 
		    	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
		    	                		labOutsideButtonEnable, rival, 3, color, false, "", playerAttack, trainerAttack, previousLocation);
		    	            	cards.add(battle, "battle");
		    	            	
		    	                layout.show(cards, "battle");
		    	                
		    	                
		    	                }
	            		}
		            
		            
		            
		            
	            		
	            		
	            		
	            		
		            	
		            
		        });
		 }
	     
    
	     optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	JTextArea blankTextArea = new JTextArea();
	            	
	            	Options options = new Options(cl,cards, "battle", blankTextArea, location, false, player, false, language, textSpeed, "",
	            			rival, font, false, false, 65f, 0,0, true, professorOakVisited, 
	            			labOutsideButtonEnable, trainer, 4, color,previousLocation);
	            	cards.add(options, "options");
	                layout.show(cards, "options");  
	            	
	            }
	        });
	     
	     fightButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Battle battle = new Battle(cl, cards, textAreaFont, 
	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
	                		labOutsideButtonEnable, rival, 4, color, true, "", "", "", previousLocation);
	            	cards.add(battle, "battle");
	            	
	                layout.show(cards, "battle");
	            	
	            }
	        });
	     
	     returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Battle battle = new Battle(cl, cards, textAreaFont, 
	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
	                		labOutsideButtonEnable, rival, 4, color, false, "", "", "", previousLocation);
	            	cards.add(battle, "battle");
	            	
	                layout.show(cards, "battle");
	            	
	            }
	        });
	     
	     nextButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	switch (previousLocation) {
	            	case "pallettownlab":
	            		PalletTownLab palletTownLab = new PalletTownLab(cl, cards, textAreaFont, 
		                		"12", language, textSpeed, player, rival, stopTimer, "pallettownlab", professorOakVisited, 
		                		labOutsideButtonEnable, color);
		            	cards.add(palletTownLab, "pallettownlab");
		            	
		                layout.show(cards, "pallettownlab");
	            		break;
	            
	            	}
	            	
	            	
	            }
	        });
	     
	     
	     pokemonButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	PartyPokemon partyPokemon = new PartyPokemon(cl, cards, textAreaFont, "battle", language, textSpeed,
	            			player, rival, stopTimer, "battle", professorOakVisited, labOutsideButtonEnable, trainer,
	            			4, "", 0, color, previousLocation);
	            	cards.add(partyPokemon, "partypokemon");
	                layout.show(cards, "partypokemon");
	            	
	            }
	        });
	     
	     itemButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	Inventory inventory = new Inventory(cl, cards, textAreaFont, "battle", language, textSpeed,
	            			player, rival, stopTimer, "battle", professorOakVisited, labOutsideButtonEnable, trainer, 4, previousLocation);
	            	cards.add(inventory, "inventory");
	                layout.show(cards, "inventory");
	            }
	        });
	     
	     runButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {	 
	            	battleScreenText = 999;
	            	Battle battle = new Battle(cl, cards, textAreaFont, 
	                		"12", language, textSpeed, player, rival, stopTimer, "battle", professorOakVisited, 
	                		labOutsideButtonEnable, rival, battleScreenText, color, false, "", "", "", previousLocation);
	            	cards.add(battle, "battle");
	            	
	                layout.show(cards, "battle");
	            }
	        });
	     
	     
		
	}
	
}
