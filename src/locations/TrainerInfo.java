package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import items.*;
import Trainer.*;

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
	TrainerSuper trainer;
	int battleScreenText;
	String color;
	
	public TrainerInfo(final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited, 
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String color) {
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
	     this.trainer = trainer;
	     this.battleScreenText=battleScreenText;
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
		 
		 JLabel badge1Label = new JLabel("1. Brock    ");
		 badge1Label.setForeground(Color.LIGHT_GRAY);
		 badge1Label.setFont(font);
		 
		 JLabel badge2Label = new JLabel("2. Misty    ");
		 badge2Label.setForeground(Color.LIGHT_GRAY);
		 badge2Label.setFont(font);
		 
		 JLabel badge3Label = new JLabel("3. Lt. Surge    ");
		 badge3Label.setForeground(Color.LIGHT_GRAY);
		 badge3Label.setFont(font);
		 
		 JLabel badge4Label = new JLabel("4. Erika    ");
		 badge4Label.setForeground(Color.LIGHT_GRAY);
		 badge4Label.setFont(font);
		 
		 JLabel badge5Label = new JLabel("5. Koga    ");
		 badge5Label.setForeground(Color.LIGHT_GRAY);
		 badge5Label.setFont(font);
		 
		 JLabel badge6Label = new JLabel("6. Sabrina    ");
		 badge6Label.setForeground(Color.LIGHT_GRAY);
		 badge6Label.setFont(font);
		 
		 JLabel badge7Label = new JLabel("7. Blaine    ");
		 badge7Label.setForeground(Color.LIGHT_GRAY);
		 badge7Label.setFont(font);
		 
		 JLabel badge8Label = new JLabel("8. ?    ");
		 badge8Label.setForeground(Color.LIGHT_GRAY);
		 badge8Label.setFont(font);
		 
		 JPanel badgePanel = new JPanel();
		 badgePanel.setBackground(Color.black);
		 badgePanel.setLayout(new GridLayout(2,4));
		 badgePanel.add(badge1Label);
		 badgePanel.add(badge2Label);
		 badgePanel.add(badge3Label);
		 badgePanel.add(badge4Label);
		 badgePanel.add(badge5Label);
		 badgePanel.add(badge6Label);
		 badgePanel.add(badge7Label);
		 badgePanel.add(badge8Label);
		 
		 
		 
	     	     
	     
	     if (language == "Japanese") {
	    	 returnButton.setText("とじる");
	    	 nameLabel.setText("なまえ：　" + player.getName());
//	    	 idLabel.setText("");
	    	 badgeLabel.setText("ポケモン　バッジ：　" + player.getBadeNumber());
	    	 moneyLabel.setText("おこづかい：　" + player.getMoney() + "￥");
	    	 badge1Label.setText("1. タケシ    ");
	    	 badge2Label.setText("2. カスミ    ");
	    	 badge3Label.setText("3. マチス    ");
	    	 badge4Label.setText("4. エリカ    ");
	    	 badge5Label.setText("5. キョウ     ");
	    	 badge6Label.setText("6. ナツメ    ");
	    	 badge7Label.setText("7. カツラ    ");
	    	 badge8Label.setText("8. ?    ");
	    	 
	     }
	     
	    
	     
	     gb.gridx=0;
	     gb.gridy=0;
	     gb.insets = new Insets(-125,0,0,0);
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
		 
		 gb.gridx=0;
	     gb.gridy=5;
		 add(badgePanel, gb);
		 

		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {  		
            		
            		MenuScreen menu = new MenuScreen(cl, cards, font, screen, language, textSpeed, player,
            				rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable, 
            				trainer, battleScreenText, color, "");
            		cards.add(menu, "menu");
            	    layout.show(cards, "menu");
            	  
	            	
	            }
	        });
		 
		 
	     
	     
	}

}
 
