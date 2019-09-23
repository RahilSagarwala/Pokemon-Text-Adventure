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
import mainGame.MainGame.OptionsButtonHandler;

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

public class NewGame extends JPanel {
	
	JButton returnButton, yesButton, noButton;
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JLabel newGameLabel, blankLabel;
    StartScreen ss;
    JTextArea screenTextArea;
    Player player;
	
	public NewGame(final CardLayout layout, final JPanel cards) {
		 this.cl = layout;
	     this.cards = cards;
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
		 
		 setBackground(Color.black);
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(buttonFont);
		 
		 JButton yesButton = new JButton("Yes");
		 yesButton.setBackground(Color.DARK_GRAY);
		 yesButton.setForeground(Color.cyan);
		 yesButton.setFont(buttonFont);
		 yesButton.setPreferredSize(new Dimension(400,100));
		 
		 JButton noButton = new JButton("No");
		 noButton.setBackground(Color.DARK_GRAY);
		 noButton.setForeground(Color.cyan);
		 noButton.setFont(buttonFont);
		 noButton.setPreferredSize(new Dimension(400,100));
		 
		 JLabel newGameLabel = new JLabel("Start a new game?");
		 newGameLabel.setFont(buttonFont);
		 newGameLabel.setForeground(Color.cyan);
		 
		 JLabel blankLabel = new JLabel("");
		 blankLabel.setFont(buttonFont);
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
	              
	           	 JTextArea screenTextArea = new JTextArea("*An image of a man in a lab coat appears.* \n\n Oak: Hello there! "
	     		 		+ "Welcome to the world of POKEMON! My name is OAK!\r\n" + 
	     		 		"            People call me the POKEMON PROF!");

	     		 
	     				 
	           	screenTextArea.setForeground(Color.cyan);
	           	screenTextArea.setBackground(Color.black);
	           	screenTextArea.setFont(buttonFont);
	                ss = new StartScreen(cl,cards,buttonFont, screenTextArea,false,"1", false, player);
	                ss.timerStart(screenTextArea.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");
	            }
	        });
	}
	

}
