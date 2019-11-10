package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;


public class ConfirmContinue extends JPanel{
	CardLayout cl;
    JPanel cards;
    JButton yesButton, noButton;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JLabel confirmContinueLabel;
    String saveName = "";
    String language;
    Font font;
    int textSpeed;
    Player player;
    Rival rival;
    Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
    Float titleSize;
    int buttonWidth;
    int buttonHeight;
    ContinueGame continu;
    String color;

    
    
	public ConfirmContinue (final CardLayout layout, final JPanel cards, String name, String language, Font font, int textSpeed,
			Player player, Rival rival, Boolean stopTimer, Float titleSize, int buttonWidth, int buttonHeight,
			Boolean professorOakVisited, Boolean labOutsideButtonEnable, String color) {
		 this.saveName = name;
		 this.cl = layout;
	     this.cards = cards;
	     this.language = language;
	     this.font = font;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.titleSize = titleSize;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
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
		 
		 JButton yesButton = new JButton("Yes");
		 yesButton.setBackground(Color.DARK_GRAY);
		 yesButton.setForeground(Color.cyan);
		 yesButton.setFont(font);
		 yesButton.setPreferredSize(new Dimension(400,100));
		 
		 JButton noButton = new JButton("No");
		 noButton.setBackground(Color.DARK_GRAY);
		 noButton.setForeground(Color.cyan);
		 noButton.setFont(font);
		 noButton.setPreferredSize(new Dimension(400,100));
		 
	
		 JLabel confirmContinueLabel = new JLabel(saveName);
		 confirmContinueLabel.setFont(font);
		 confirmContinueLabel.setForeground(Color.cyan);
		 
		 JLabel blankLabel = new JLabel("");
		 blankLabel.setFont(font);
		 blankLabel.setForeground(Color.cyan);
		 
		 if(language == "Japanese") {
			 yesButton.setText("はい");
			 noButton.setText("いいえ");
		 }
		 
		 gb.gridx=0;
	     gb.gridy=1;
		 add(yesButton, gb);
		 
		 gb.gridx=0;
	     gb.gridy=2;
	     gb.weighty=1;
		 add(blankLabel, gb);
		 
		 
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty=1;
		 add(confirmContinueLabel, gb);
		 
		 
		 gb.gridx=2;
	     gb.gridy=1;
		 add(noButton, gb);

		
		 
		 noButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	continu = new ContinueGame(cl, cards, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	        	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	            	cards.add(continu, "continue");
	                layout.show(cards, "continue");
	            }
	        });
		 
		 //Add load file functionality
		 yesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	                
	            }
	        });
	}
	
	
		 
	}


