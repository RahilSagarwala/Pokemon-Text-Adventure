package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;

public class NewGame extends JPanel {
	
	JButton returnButton, yesButton, noButton;
	CardLayout cl;
    JPanel cards;
    JLabel newGameLabel, blankLabel;
    StartScreen ss;
    JTextArea screenTextArea;
    Player player;
    Font font;
    String language, fullText2;
    int textSpeed, buttonWidth, buttonHeight;
    Rival rival;
    Boolean stopTimer;

    
	
	public NewGame(final CardLayout layout, final JPanel cards, Font font, String language, int textSpeed, Boolean stopTimer,
			int buttonWidth, int buttonHeight) {
		 this.cl = layout;
	     this.cards = cards;
	     this.font=font;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.stopTimer = stopTimer;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     
	     
	     JButton returnButton = new JButton("Return");
		
		 
		 setBackground(Color.black);
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		 returnButton.setFont(font);
		 
		 JButton yesButton = new JButton("Yes");
		 yesButton.setBackground(Color.DARK_GRAY);
		 yesButton.setForeground(Color.cyan);
		 yesButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		 yesButton.setFont(font);
		 
		 
		 JButton noButton = new JButton("No");
		 noButton.setBackground(Color.DARK_GRAY);
		 noButton.setForeground(Color.cyan);
		 noButton.setPreferredSize(new Dimension(buttonWidth,buttonHeight));
		
		 noButton.setFont(font);
		
		 
		 JLabel newGameLabel = new JLabel("Start New Game?");
		 newGameLabel.setFont(font);
		 newGameLabel.setForeground(Color.cyan);
		 
		 JLabel blankLabel = new JLabel("");
		 blankLabel.setFont(font);
		 blankLabel.setForeground(Color.cyan);
		 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 
		 
		 
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

		 add(newGameLabel, gb);
		 
		 
		 
		 gb.gridx=2;
	     gb.gridy=1;
		 add(noButton, gb);
		 
		
		 
		 noButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                layout.show(cards, "mainscreen");
	            }
	        });
		 
		 yesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		         
	         
	         ss = new StartScreen(cl,cards,font, screenTextArea
	        		 ,"1", false, player, true, language, textSpeed, "",
	        		 rival, false, stopTimer, buttonWidth, buttonHeight);
            
	         
             cards.add(ss, "startscreen");
             layout.show(cards, "startscreen");
	            }
	        });
	}
	

}
