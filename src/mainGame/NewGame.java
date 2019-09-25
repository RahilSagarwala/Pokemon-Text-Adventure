package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import locations.StartScreen;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    String language;
    int textSpeed;
    String fullText2;
    Rival rival;
	
	public NewGame(final CardLayout layout, final JPanel cards, Font font, String language, int textSpeed) {
		 this.cl = layout;
	     this.cards = cards;
	     this.font=font;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
		 
		 setBackground(Color.black);
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
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
	            		         
	         
	         ss = new StartScreen(cl,cards,font, screenTextArea,false,"1", false, player,true, language, textSpeed, "", rival, false);
            
             cards.add(ss, "startscreen");
             layout.show(cards, "startscreen");
	            }
	        });
	}
	

}
