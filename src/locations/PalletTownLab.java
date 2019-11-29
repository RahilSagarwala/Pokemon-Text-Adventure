package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import Trainer.TrainerSuper;
import items.*;


public class PalletTownLab extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	JButton lmenuButton;
	TrainerSuper trainer;
	int battleScreenText = 0;
	String color;
	public PalletTownLab (final CardLayout layout, final JPanel cards, 
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
	     this.labOutsideButtonEnable = labOutsideButtonEnable;
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
	     
	     JButton menuButton = new JButton("Menu");
	     menuButton.setPreferredSize(new Dimension(200,75));
	     menuButton.setBackground(Color.DARK_GRAY);
	     menuButton.setForeground(Color.cyan);
	     menuButton.setFont(font);
	     
	     JButton oakAid1Button = new JButton("Oak's Aid 1");
	     oakAid1Button.setPreferredSize(new Dimension(225,75));
	     oakAid1Button.setBackground(Color.DARK_GRAY);
	     oakAid1Button.setForeground(Color.cyan);
	     oakAid1Button.setFont(font);
	     
	     JButton oakAid2Button = new JButton("Oak's Aid 2");
	     oakAid2Button.setPreferredSize(new Dimension(225,75));
	     oakAid2Button.setBackground(Color.DARK_GRAY);
	     oakAid2Button.setForeground(Color.cyan);
	     oakAid2Button.setFont(font);
	     
	     JButton oakAid3Button = new JButton("Oak's Aid 3");
	     oakAid3Button.setPreferredSize(new Dimension(225,75));
	     oakAid3Button.setBackground(Color.DARK_GRAY);
	     oakAid3Button.setForeground(Color.cyan);
	     oakAid3Button.setFont(font);
	     
	     JButton rivalButton = new JButton(rival.getName());
	     rivalButton.setPreferredSize(new Dimension(225,75));
	     rivalButton.setBackground(Color.DARK_GRAY);
	     rivalButton.setForeground(Color.cyan);
	     rivalButton.setFont(font);
	     
	     JButton bookButton = new JButton("Book");
	     bookButton.setPreferredSize(new Dimension(225,75));
	     bookButton.setBackground(Color.DARK_GRAY);
	     bookButton.setForeground(Color.cyan);
	     bookButton.setFont(font);
	     
	     JButton computerButton = new JButton("Computer");
	     computerButton.setPreferredSize(new Dimension(225,75));
	     computerButton.setBackground(Color.DARK_GRAY);
	     computerButton.setForeground(Color.cyan);
	     computerButton.setFont(font);
	     
	     JButton poster1Button = new JButton("Poster 1");
	     poster1Button.setPreferredSize(new Dimension(225,75));
	     poster1Button.setBackground(Color.DARK_GRAY);
	     poster1Button.setForeground(Color.cyan);
	     poster1Button.setFont(font);
	     
	     JButton poster2Button = new JButton("Poster 2");
	     poster2Button.setPreferredSize(new Dimension(225,75));
	     poster2Button.setBackground(Color.DARK_GRAY);
	     poster2Button.setForeground(Color.cyan);
	     poster2Button.setFont(font);
	     
	     JButton pokeballButton = new JButton("Pokeball");
	     pokeballButton.setPreferredSize(new Dimension(225,75));
	     pokeballButton.setBackground(Color.DARK_GRAY);
	     pokeballButton.setForeground(Color.cyan);
	     pokeballButton.setFont(font);
	     
	     JButton outsideButton = new JButton("Outside");
	     outsideButton.setPreferredSize(new Dimension(225,75));
	     outsideButton.setBackground(Color.DARK_GRAY);
	     outsideButton.setForeground(Color.cyan);
	     outsideButton.setFont(font);
	     
	     JButton professorOakButton = new JButton();
	     professorOakButton.setPreferredSize(new Dimension(225,75));
	     professorOakButton.setBackground(Color.DARK_GRAY);
	     professorOakButton.setForeground(Color.cyan);
	     professorOakButton.setFont(font);
	     
	     JButton choosePokemonButton = new JButton("");
	     choosePokemonButton.setPreferredSize(new Dimension(225,75));
	     choosePokemonButton.setBackground(Color.DARK_GRAY);
	     choosePokemonButton.setForeground(Color.cyan);
	     choosePokemonButton.setFont(font);
	     
	     JLabel locationLabel = new JLabel("<html>Lab <br> Pallet Town <html>");
		 locationLabel.setForeground(Color.LIGHT_GRAY);
		 locationLabel.setFont(font);
	     
	     if (language == "Japanese") {
	   	  
	    	 locationLabel.setText("<html> ラボ <br> マサラタウン<html>");
	    	 menuButton.setText("メニユー");  
	    	 oakAid1Button.setText("じょしゅ　１");
	    	 oakAid2Button.setText("じょしゅ　2");
	    	 oakAid3Button.setText("じょしゅ　3");
	    	 poster1Button.setText("ポスター 1");
	    	 poster2Button.setText("ポスター 2");
	    	 computerButton.setText("コンピューター");
	    	 bookButton.setText("ほん");
	    	 pokeballButton.setText("モンスターボール");
	    	 rivalButton.setText(player.getName()); 
	    	 outsideButton.setText("そとにでいく");
	    	 computerButton.setPreferredSize(new Dimension(250,75));
	    	 pokeballButton.setPreferredSize(new Dimension(280,75)); 
	     }
	     
	     if (professorOakVisited) {
	    	 if (language == "English") {
	    		 professorOakButton.setText("Prof. Oak");
	    		 choosePokemonButton.setText("Pokémon");
	    	 }
	    	 
	    	 else {
	    		 professorOakButton.setText("オーキド");
	        	 choosePokemonButton.setText("ポケモン");
	    	 }
	     }
	     
	     
	     gb.gridx=2;
	     gb.gridy=0;
	     gb.weighty = 1;
	     gb.insets = new Insets(0,-250,0,0);
	     add(menuButton, gb);

	     gb.gridx=0;
	     gb.gridy=1;
	     gb.insets = new Insets(0,30,0,0);
	     add(oakAid1Button, gb);
	     
	     gb.gridx=1;
	     gb.gridy=1;
	     add(oakAid2Button, gb);
	     
	     gb.gridx=2;
	     gb.gridy=1;
	     add(oakAid3Button, gb);
	     
	     gb.gridx=3;
	     gb.gridy=1;
	     add(rivalButton, gb);
	     
	     gb.gridx=2;
	     gb.gridy=3;
	     gb.insets = new Insets(-150,-250,0,0);
	     add(locationLabel, gb);
	     
	     gb.gridx=0;
	     gb.gridy=2;
	     gb.insets = new Insets(0,30,0,0);
	     add(poster1Button, gb);
	     
	     gb.gridx=0;
	     gb.gridy=3;
	     add(poster2Button, gb);
	     
	     gb.gridx=0;
	     gb.gridy=4;
	     add(bookButton, gb);
	     
	     gb.gridx=3;
	     gb.gridy=2;
	     add(computerButton, gb);
	     

	     
	     gb.gridx=3;
	     gb.gridy=3;
	     add(pokeballButton, gb);
	     
	     gb.gridx=3;
	     gb.gridy=4;
	     add(outsideButton, gb);
	     
	     gb.gridx=1;
	     gb.gridy=4;
	     add(professorOakButton, gb);
	     
	     gb.gridx=2;
	     gb.gridy=4;
	     add(choosePokemonButton, gb);
	     
	     
	     menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	MenuScreen menu = new MenuScreen(cl, cards, textAreaFont, "", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", professorOakVisited, labOutsideButtonEnable, 
	            			trainer, 0, color, "");
	            	cards.add(menu, "menu");
	                layout.show(cards, "menu");  
	            	
	            }
	        });
	     
	     oakAid1Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {

	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "oakaid1lab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            	
	            }
	        });
	     
	     oakAid2Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "oakaid2lab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            	
	            }
	        });
	     
	     oakAid3Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "oakaid3lab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            	
	            }
	        });
	     
	     poster1Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "poster1lab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            }
	        });
	     
	     poster2Button.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "poster2lab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            	
	            }
	        });
	     
	     computerButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "computerlab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, 
	            			true, 0, labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            }
	        });
	     
	     bookButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "booklab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            }
	        });
	     
	     
	     pokeballButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "pokeballlab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            }
	        });
	     
	     rivalButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "rivallab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            }
	        });
	     
	     professorOakButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (professorOakButton.getText() == "Prof. Oak" || professorOakButton.getText() == "オーキド") {
	            	
	            	Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "professoroaklab", language, textSpeed,
	            			player, rival, stopTimer, "pallettownlab", false, professorOakVisited, true, 0, 
	            			labOutsideButtonEnable, color);
	            	cards.add(dialogue, "dialogue");
	                layout.show(cards, "dialogue");  
	            	}
	            }
	        });
	     
	     choosePokemonButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (labOutsideButtonEnable == false && player.getPartyPokemonArrayList().size() < 1) {
	            		ChooseStarter chooseStarter = new ChooseStarter(layout, cards, 
		            			textAreaFont, screen, language, textSpeed, 
		            			player, rival, stopTimer, "choosestarter", professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(chooseStarter, "choosestarter");
		            	  layout.show(cards, "choosestarter");
	            	}
	            	
	            	
	            	else {
	            		return;
	            	}
	            	
	            }
	        });
	     
	     outsideButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	//Player must have chosen Pokemon first
	            	if (labOutsideButtonEnable == false && player.getPartyPokemonArrayList().size() == 1) {
	            		//To Dialogue and then Rival Battle. Enable outside button.
	            		
	            		Potion potion = new Potion(1);
	            		player.addItem(potion);
	            		
	            		Dialogue dialogue = new Dialogue(cl, cards, textAreaFont, "rivalbattle1", language, textSpeed,
		            			player, rival, stopTimer, "pallettownlab", true, professorOakVisited, false, 0, true, color);
		            	cards.add(dialogue, "dialogue");
		                layout.show(cards, "dialogue");
	            		
	            		
	            		
	            		
	            	
	            	}
	            	
	            	else if (labOutsideButtonEnable == false && player.getPartyPokemonArrayList().size() < 1) {
	            		return;
	            	}
	            	
	            	else {
	            	  	Outside outside = new Outside(layout, cards, 
		            			textAreaFont, screen, language, textSpeed, 
		            			player, rival, stopTimer, "outside", professorOakVisited, labOutsideButtonEnable, color);
		            	cards.add(outside, "outside");
		            	  layout.show(cards, "outside");
	            	}
	            	
	            }
	        });
	     
	     
	     
	     
		
	}
	
}
