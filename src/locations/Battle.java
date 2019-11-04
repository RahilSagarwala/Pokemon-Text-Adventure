package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import mainGame.TimerClass;


public class Battle extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	JButton lmenuButton;
	
	public Battle (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable) {
		
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
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     JButton menuButton = new JButton("Menu");
	     menuButton.setPreferredSize(new Dimension(200,75));
	     menuButton.setBackground(Color.DARK_GRAY);
	     menuButton.setForeground(Color.cyan);
	     menuButton.setFont(font);
	     
	     JButton fightButton = new JButton("Fight");
	     fightButton.setPreferredSize(new Dimension(200,75));
	     fightButton.setBackground(Color.DARK_GRAY);
	     fightButton.setForeground(Color.cyan);
	     fightButton.setFont(font);
	     
	     JButton pokemonButton = new JButton("Pokémon");
	     pokemonButton.setPreferredSize(new Dimension(200,75));
	     pokemonButton.setBackground(Color.DARK_GRAY);
	     pokemonButton.setForeground(Color.cyan);
	     pokemonButton.setFont(font);
	     
	     JButton itemButton = new JButton("Item");
	     itemButton.setPreferredSize(new Dimension(200,75));
	     itemButton.setBackground(Color.DARK_GRAY);
	     itemButton.setForeground(Color.cyan);
	     itemButton.setFont(font);
	     
	     JButton runButton = new JButton("Run");
	     runButton.setPreferredSize(new Dimension(200,75));
	     runButton.setBackground(Color.DARK_GRAY);
	     runButton.setForeground(Color.cyan);
	     runButton.setFont(font);
	     
	     JLabel pokemonLevelLabel = new JLabel();
		 pokemonLevelLabel.setForeground(Color.LIGHT_GRAY);
		 pokemonLevelLabel.setFont(font);
	     
	     if (player.getPartyPokemonArrayList().size() >= 1) {
	     pokemonLevelLabel.setText("L:"+player.getPartyPokemonArrayList().get(0).getLevel() + "");
	     }
	     
	     JLabel pokemonNameLabel = new JLabel();
		 pokemonNameLabel.setForeground(Color.LIGHT_GRAY);
		 pokemonNameLabel.setFont(font);
	     
	     if (player.getPartyPokemonArrayList().size() >= 1) {
	     pokemonNameLabel.setText(player.getPartyPokemonArrayList().get(0).getPokemonName(language));
	     }
	     
	     JLabel pokemonHpLabel = new JLabel();
		 pokemonHpLabel.setForeground(Color.LIGHT_GRAY); 
		 pokemonHpLabel.setFont(font);
		 
	     if (player.getPartyPokemonArrayList().size() >= 1) {
		 pokemonHpLabel.setText(player.getPartyPokemonArrayList().get(0).getHp() + "/" + 
	     player.getPartyPokemonArrayList().get(0).getMaxHp());
	     }
	     
	     JLabel rivalPokemonHpLabel = new JLabel();
		 rivalPokemonHpLabel.setForeground(Color.LIGHT_GRAY); 
		 rivalPokemonHpLabel.setFont(font);
		 
		 if (rival.getPartyPokemonArrayList().size() >= 1) {
			 rivalPokemonHpLabel.setText(rival.getPartyPokemonArrayList().get(0).getHp() + "/" + 
		     rival.getPartyPokemonArrayList().get(0).getMaxHp());
		     }
		 
		 JLabel rivalPokemonNameLabel = new JLabel();
		 rivalPokemonNameLabel.setForeground(Color.LIGHT_GRAY);
		 rivalPokemonNameLabel.setFont(font);
	     
	     if (rival.getPartyPokemonArrayList().size() >= 1) {
	     rivalPokemonNameLabel.setText(rival.getPartyPokemonArrayList().get(0).getPokemonName(language));
	     }
	     
	     JLabel rivalPokemonLevelLabel = new JLabel();
		 rivalPokemonLevelLabel.setForeground(Color.LIGHT_GRAY);
		 rivalPokemonLevelLabel.setFont(font);
	     
	     if (player.getPartyPokemonArrayList().size() >= 1) {
	     rivalPokemonLevelLabel.setText("L:" + rival.getPartyPokemonArrayList().get(0).getLevel() + "");
	     }

	     if (language == "Japanese") { 
	    	 menuButton.setText("メニユー");  
	    	 
	     }
	     
	     JTextArea textArea = new JTextArea();		 
		 textArea.setForeground(Color.cyan);
		 textArea.setBackground(Color.black);
		 textArea.setFont(font);
		 
		 String text = "";
		 
		 if(player.getPartyPokemonArrayList().size() >= 1) {
		 text = rival.getName() + " would like to" + "\n" + "Go, " + 
		 player.getPartyPokemonArrayList().get(0).getPokemonName(language) + "!";
		 }
		 
		 TimerClass tm = new TimerClass(text, stopTimer, textSpeed , textArea);
		 
	    
	     gb.gridx=0;
	     gb.gridy=0;
	     gb.weighty = 1;
	     gb.insets = new Insets(-50,0,0,-400);
	     add(menuButton, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=1;
	     gb.insets = new Insets(0,-250,-100,50);
	     add(pokemonNameLabel, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=2;
	     add(pokemonLevelLabel, gb);
	     
	     gb.gridx = 0;
	     gb.gridy=3;
	     add(pokemonHpLabel, gb);
	     
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
	     gb.gridy=3;
	     gb.insets = new Insets(0,0,0,0);
	     add(textArea, gb);
	     
	     gb.gridx = 3;
	     gb.gridy=0;
	     gb.insets = new Insets(0,0,-100,-400);
	     add(rivalPokemonNameLabel, gb);
	     
	     gb.gridx = 3;
	     gb.gridy=1;
	     add(rivalPokemonLevelLabel, gb);
	     
	     gb.gridx = 3;
	     gb.gridy=2;
	     add(rivalPokemonHpLabel, gb);
	     
	     
	     

	     
	     menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	MenuScreen menu = new MenuScreen(cl, cards, textAreaFont, "", language, textSpeed,
	            			player, rival, stopTimer, "battle", professorOakVisited, labOutsideButtonEnable);
	            	cards.add(menu, "menu");
	                layout.show(cards, "menu");  
	            	
	            }
	        });
	     
	     fightButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	
	            }
	        });
	     
	     pokemonButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	
	            }
	        });
	     
	     itemButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	
	            }
	        });
	     
	     runButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            	
	            }
	        });
	     
	     
		
	}
	
}
