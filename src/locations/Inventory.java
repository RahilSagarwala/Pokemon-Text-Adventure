package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import items.*;

public class Inventory extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer;
	Player player;
	int textSpeed;
	Rival rival;
	JLabel locationLabel;
	Dialogue dialogue;
	MenuScreen menu;
	
	public Inventory (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2) {
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
	     
	     
	     setBackground(Color.black);
	     setLayout(new GridBagLayout());
	     GridBagConstraints gb = new GridBagConstraints();
	     
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 JButton item1Button = new JButton();
		 item1Button.setPreferredSize(new Dimension(150,75));
		 item1Button.setBackground(Color.DARK_GRAY);
		 item1Button.setForeground(Color.cyan);
		 item1Button.setFont(font);
	     
		 
	    if (player.getItems().isEmpty()) {
	    	item1Button.setText("");
	    }
	    
	    else {
	    	item1Button.setText(player.getItemNames());
	    }
	     
	     
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");
	    	 item1Button.setText("");
	     }
	     
	     gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);
		 
		 gb.gridx=1;
	     gb.gridy=1;
		 add(item1Button, gb);
		 
	   
	
		
		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
            		
            		MenuScreen menu = new MenuScreen(cl, cards, font, screen, language, textSpeed, player,
            				rival, stopTimer, location);
            		cards.add(menu, "menu");
            	    layout.show(cards, "menu");
            	  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
