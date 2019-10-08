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
		 item1Button.setPreferredSize(new Dimension(300,75));
		 item1Button.setBackground(Color.DARK_GRAY);
		 item1Button.setForeground(Color.cyan);
		 item1Button.setFont(font);
		 
		 JButton item2Button = new JButton();
		 item2Button.setPreferredSize(new Dimension(300,75));
		 item2Button.setBackground(Color.DARK_GRAY);
		 item2Button.setForeground(Color.cyan);
		 item2Button.setFont(font);
		 
		 JButton item3Button = new JButton();
		 item3Button.setPreferredSize(new Dimension(300,75));
		 item3Button.setBackground(Color.DARK_GRAY);
		 item3Button.setForeground(Color.cyan);
		 item3Button.setFont(font);
		 
		 JButton item4Button = new JButton();
		 item4Button.setPreferredSize(new Dimension(300,75));
		 item4Button.setBackground(Color.DARK_GRAY);
		 item4Button.setForeground(Color.cyan);
		 item4Button.setFont(font);
		 
		 JButton item5Button = new JButton();
		 item5Button.setPreferredSize(new Dimension(300,75));
		 item5Button.setBackground(Color.DARK_GRAY);
		 item5Button.setForeground(Color.cyan);
		 item5Button.setFont(font);
		 
		 JButton item6Button = new JButton();
		 item6Button.setPreferredSize(new Dimension(300,75));
		 item6Button.setBackground(Color.DARK_GRAY);
		 item6Button.setForeground(Color.cyan);
		 item6Button.setFont(font);
		 
		 JButton nextPageButton = new JButton("Next Page");
		 nextPageButton.setPreferredSize(new Dimension(300,75));
		 nextPageButton.setBackground(Color.DARK_GRAY);
		 nextPageButton.setForeground(Color.cyan);
		 nextPageButton.setFont(font);
	     
		 
	    if (player.getItems().isEmpty()) {
	    	item1Button.setText("");
	    	item2Button.setText("");
	    	item3Button.setText("");
	    	item4Button.setText("");
	    	item5Button.setText("");
	    	item6Button.setText("");
	    	nextPageButton.setText("");
	    }
	    
	    else {
	    	item1Button.setText(player.getItems().get(0).getItemName());
	    }
	    
	    //Loop through items array to check for null and set for each button
//	    for (int i =0; i <= player.getItems().size(); i++) {
//	    	if (player.getItems().get(i).equals(null))  {
//	    		
//	    	}
//	    	
//	    	else {
//	    		
//	    	}
//	    }
//	     
	     
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
		 
		 gb.gridx=1;
	     gb.gridy=2;
		 add(item2Button, gb);

		 gb.gridx=1;
	     gb.gridy=3;
		 add(item3Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=4;
		 add(item4Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=5;
		 add(item5Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=6;
		 add(item6Button, gb);
		 
		 gb.gridx=1;
	     gb.gridy=7;
		 add(nextPageButton, gb);

		 
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
 
