package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import items.*;

public class TrainerInfo extends JPanel {
	
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
	
	public TrainerInfo(final CardLayout layout, final JPanel cards, 
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
		 
		 JLabel nameLabel = new JLabel("Name: " + player.getName());
		 nameLabel.setForeground(Color.LIGHT_GRAY);
		 nameLabel.setFont(font);
		 
		 JLabel idLabel = new JLabel("ID: " + player.getId());
		 idLabel.setForeground(Color.LIGHT_GRAY);
		 idLabel.setFont(font);
		 
		 JLabel moneyLabel = new JLabel("Money: " + player.getMoney() + "￥");
		 moneyLabel.setForeground(Color.LIGHT_GRAY);
		 moneyLabel.setFont(font);
		 
		 JLabel badgeLabel = new JLabel("Badges Earned: " + player.getBadeNumber());
		 badgeLabel.setForeground(Color.LIGHT_GRAY);
		 badgeLabel.setFont(font);
		 
	     	     
	     
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");

	     }
	     
	     gb.gridx=0;
	     gb.gridy=0;
	     gb.insets = new Insets(-200,0,0,0);
		 add(returnButton, gb);
		 
		 gb.gridx=0;
	     gb.gridy=1;
	     gb.insets = new Insets(50,0,0,0);
		 add(nameLabel, gb);
		 
		 gb.gridx=0;
	     gb.gridy=2;
		 add(idLabel, gb);
		 
		 gb.gridx=0;
	     gb.gridy=3;
		 add(moneyLabel, gb);
		 
		 gb.gridx=0;
	     gb.gridy=4;
		 add(badgeLabel, gb);
		 

		 
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
 
