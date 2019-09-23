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

public class Options extends JPanel {
	
	JButton returnButton, smallFontButton, mediumFontButton, largeFontButton, onSoundtrackButton, offSoundtrackButton, 
	onTextToSpeechButton, offTextToSpeechButton, slowTextSpeedButton, fastTextSpeedButton;
	CardLayout cl;
    JPanel cards;
    JLabel optionsLabel, fontSizeLabel, soundtrackLabel, textToSpeechLabel, textSpeedLabel;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    ConfirmContinue confirmContinue;
	
	public Options (final CardLayout layout, final JPanel cards) {
		 this.cl = layout;
	     this.cards = cards;
	     JButton returnButton = new JButton("Return");
		 returnButton.setPreferredSize(new Dimension(150,75));
		 setBackground(Color.black);
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(buttonFont);
		 
		 JLabel optionsLabel = new JLabel("Options");
		 optionsLabel.setFont(buttonFont);
		 optionsLabel.setForeground(Color.cyan);
		 
		 JLabel fontSizeLabel = new JLabel("Font Size: ");
		 fontSizeLabel.setFont(buttonFont);
		 fontSizeLabel.setForeground(Color.cyan);
		 JButton smallFontButton = new JButton("Small");
		 smallFontButton.setFont(buttonFont);
		 smallFontButton.setPreferredSize(new Dimension(400,100));
		 smallFontButton.setBackground(Color.DARK_GRAY);
		 smallFontButton.setForeground(Color.cyan);
		 JButton mediumFontButton = new JButton("Medium");
		 mediumFontButton.setFont(buttonFont);
		 mediumFontButton.setPreferredSize(new Dimension(400,100));
		 mediumFontButton.setBackground(Color.DARK_GRAY);
		 mediumFontButton.setForeground(Color.cyan);
		 JButton largeFontButton = new JButton("Large");
		 largeFontButton.setFont(buttonFont);
		 largeFontButton.setPreferredSize(new Dimension(400,100));
		 largeFontButton.setBackground(Color.DARK_GRAY);
		 largeFontButton.setForeground(Color.cyan);
		 
		 
		 JLabel soundtrackLabel = new JLabel("Soundtrack: ");
		 soundtrackLabel.setFont(buttonFont);
		 soundtrackLabel.setForeground(Color.cyan);
		 JButton onSoundtrackButton = new JButton("On");
		 onSoundtrackButton.setFont(buttonFont);
		 onSoundtrackButton.setPreferredSize(new Dimension(400,100));
		 onSoundtrackButton.setBackground(Color.DARK_GRAY);
		 onSoundtrackButton.setForeground(Color.cyan);
		 JButton offSoundtrackButton = new JButton("Off");
		 offSoundtrackButton.setFont(buttonFont);
		 offSoundtrackButton.setPreferredSize(new Dimension(400,100));
		 offSoundtrackButton.setBackground(Color.DARK_GRAY);
		 offSoundtrackButton.setForeground(Color.cyan);
		 
		 JLabel textToSpeechLabel = new JLabel("Text To Speech:    ");
		 textToSpeechLabel.setFont(buttonFont);
		 textToSpeechLabel.setForeground(Color.cyan);
		 JButton onTextToSpeechButton = new JButton("On");
		 onTextToSpeechButton.setFont(buttonFont);
		 onTextToSpeechButton.setPreferredSize(new Dimension(400,100));
		 onTextToSpeechButton.setBackground(Color.DARK_GRAY);
		 onTextToSpeechButton.setForeground(Color.cyan);
		 JButton offTextToSpeechButton = new JButton("Off");
		 offTextToSpeechButton.setFont(buttonFont);
		 offTextToSpeechButton.setPreferredSize(new Dimension(400,100));
		 offTextToSpeechButton.setBackground(Color.DARK_GRAY);
		 offTextToSpeechButton.setForeground(Color.cyan);
		 
		 
		 JLabel textSpeedLabel = new JLabel("Text Speed: ");
		 textSpeedLabel.setFont(buttonFont);
		 textSpeedLabel.setForeground(Color.cyan);

		 JButton slowTextSpeedButton = new JButton("Slow");
		 slowTextSpeedButton.setFont(buttonFont);
		 slowTextSpeedButton.setPreferredSize(new Dimension(400,100));
		 slowTextSpeedButton.setBackground(Color.DARK_GRAY);
		 slowTextSpeedButton.setForeground(Color.cyan);
		 
		 JButton fastTextSpeedButton = new JButton("Fast");
		 fastTextSpeedButton.setFont(buttonFont);
		 fastTextSpeedButton.setPreferredSize(new Dimension(400,100));
		 fastTextSpeedButton.setBackground(Color.DARK_GRAY);
		 fastTextSpeedButton.setForeground(Color.cyan);
		 
		 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 //Column 1
		 gb.anchor=GridBagConstraints.FIRST_LINE_START;
		 gb.gridx=0;
	     gb.gridy=2;
		 add(fontSizeLabel, gb);
		 gb.gridx=0;
	     gb.gridy=3;
		 add(soundtrackLabel,gb);
		 gb.gridx=0;
	     gb.gridy=4;
		 add(textToSpeechLabel,gb);
		 gb.gridx=0;
	     gb.gridy=5;
		 add(textSpeedLabel,gb);
		 

	     
	     //Column 2
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty = 1;
		 add(returnButton, gb);
		 gb.gridx=1;
	     gb.gridy=1;
		 add(optionsLabel, gb);
		 gb.gridx=1;
	     gb.gridy=2;
		 add(smallFontButton,gb);
		 gb.gridx=1;
	     gb.gridy=3;
		 add(onSoundtrackButton,gb);
		 gb.gridx=1;
	     gb.gridy=4;
		 add(onTextToSpeechButton,gb);
		 gb.gridx=1;
	     gb.gridy=5;
		 add(slowTextSpeedButton,gb);
		 
		 //Column 3
		 gb.gridx=2;
	     gb.gridy=2;
		 add(mediumFontButton,gb);
		 gb.gridx=2;
	     gb.gridy=3;
		 add(offSoundtrackButton,gb);
		 gb.gridx=2;
	     gb.gridy=4;
		 add(offTextToSpeechButton,gb);
		 gb.gridx=2;
	     gb.gridy=5;
		 add(fastTextSpeedButton,gb);
		 
		 
		 //Column 4
		 gb.gridx=3;
	     gb.gridy=2;
	     gb.insets = new Insets(0,15,0,0);
		 add(largeFontButton,gb);
	
		 
		 
		 

		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                layout.show(cards, "mainscreen");
	            				}	
	            			}
				 		);
		 
		 smallFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	    layout.show(cards, "confirmcontinue");
		                cards.add(confirmContinue, "confirmcontinue");
		                layout.show(cards, "confirmcontinue");    
		                layout.show(cards, "confirmcontinue");
	            				}	
	            			}
				 		);
		 
		 mediumFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		
		 
		 
		 largeFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 onSoundtrackButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 offSoundtrackButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 onTextToSpeechButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
		 
		 offTextToSpeechButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              
	            				}	
	            			}
				 		);
		 
		 slowTextSpeedButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	               
	            				}	
	            			}
				 		);
		 
		 fastTextSpeedButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                
	            				}	
	            			}
				 		);
	}
	

}
