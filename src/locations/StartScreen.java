package locations;

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

public class StartScreen extends JPanel {
	
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JTextArea startScreen1;
    JButton nextButton1, nextButton2;
	
	public StartScreen(final CardLayout layout, final JPanel cards) {
		 this.cl = layout;
	     this.cards = cards;
		 setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 JTextArea startScreen1 = new JTextArea("*An image of a man in a lab coat appears.* \n\n Oak: Hello there! "
		 		+ "Welcome to the world of POKEMON! My name is OAK!\r\n" + 
		 		"            People call me the POKEMON PROF!");
		 startScreen1.setForeground(Color.cyan);
		 startScreen1.setBackground(Color.black);
		 startScreen1.setFont(buttonFont);
		 
		 JButton nextButton1 = new JButton("Next");
		 nextButton1.setPreferredSize(new Dimension(150,75));
		 nextButton1.setBackground(Color.DARK_GRAY);
		 nextButton1.setForeground(Color.cyan);
		 nextButton1.setFont(buttonFont);
		 	 
		 
		 gb.gridx=0;
	     gb.gridy=0;
	     gb.weighty=1;
		 add(startScreen1, gb);
		 gb.gridx=0;
	     gb.gridy=1;
		 add(nextButton1, gb);
		 
		 
		 
		 nextButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                startScreen1.setText("*An image of a Nidorino appears.\r\n" + 
	                		"Oak       : This world is inhabited by creatures called POKEMON! For some\r\n" + 
	                		"            people, POKEMON are pets. Others use them for fights. Myself...\r\n" + 
	                		"            I study POKEMON as a profession.");
	             nextButton1.setVisible(false);
	             JButton nextButton2 = new JButton("Next");
	       		 nextButton2.setPreferredSize(new Dimension(150,75));
	       		 nextButton2.setBackground(Color.DARK_GRAY);
	       		 nextButton2.setForeground(Color.cyan);
	       		 nextButton2.setFont(buttonFont);
	       		 add(nextButton2, gb);
	            }
	        });
		 

	}
	
		

		
	}
