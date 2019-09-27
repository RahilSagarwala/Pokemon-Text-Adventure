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
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;

public class Options extends JPanel {
	
	JButton returnButton, smallFontButton, mediumFontButton, largeFontButton, onSoundtrackButton, offSoundtrackButton, 
	onTextToSpeechButton, offTextToSpeechButton, slowTextSpeedButton, fastTextSpeedButton, englishButton, japaneseButton,
	timerOffButton;
	CardLayout cl;
    JPanel cards;
    JLabel optionsLabel, fontSizeLabel, soundtrackLabel, textToSpeechLabel, textSpeedLabel, languageLabel;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    StartScreen startScreen;
    JTextArea startScreenTextArea = new JTextArea();
    Font font1;
    MainGame mg;
    String language1;
    String position;
    JTextArea textArea;
    Boolean finish;
    String screen;
	Boolean nameOptionsBool, nameOptionsBool2;
	Player player;
	Boolean setVisible;
	int textSpeed1;
	String fullText2;
	Rival rival;
	Boolean stopTimer;
    
    
	
	public Options (final CardLayout layout, final JPanel cards, String position, JTextArea textArea, Boolean finish, String screen,
			Boolean nameOptionsBool, Player player2, Boolean setVisible, String language, int textSpeed, String fullText, Rival rival2, Font font,
			Boolean stopTimer1, Boolean nameOptionsBool2) {
		 this.cl = layout;
	     this.cards = cards;
	     this.position = position;
	     this.startScreenTextArea = textArea;
	     this.finish = finish;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     this.player = player2;
	     this.setVisible = setVisible;
	     this.language1 = language;
	     this.textSpeed1 = textSpeed;
	     this.fullText2 = fullText;
	     this.rival = rival2;
	     this.font1 = font;
	     this.stopTimer = stopTimer1;
	     this.nameOptionsBool2 = nameOptionsBool2;
	     
	     
	     //Create GUI
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
		 
		 JLabel languageLabel = new JLabel("Language: ");
		 languageLabel.setFont(buttonFont);
		 languageLabel.setForeground(Color.cyan);
		 JButton englishButton = new JButton("English");
		 englishButton.setFont(buttonFont);
		 englishButton.setPreferredSize(new Dimension(400,100));
		 englishButton.setBackground(Color.DARK_GRAY);
		 englishButton.setForeground(Color.cyan);
		 JButton japaneseButton = new JButton("Japanese");
		 japaneseButton.setFont(buttonFont);
		 japaneseButton.setPreferredSize(new Dimension(400,100));
		 japaneseButton.setBackground(Color.DARK_GRAY);
		 japaneseButton.setForeground(Color.cyan);
		 
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
		 
		 JButton timerOffButton = new JButton("OFF");
		 timerOffButton.setFont(buttonFont);
		 timerOffButton.setPreferredSize(new Dimension(400,100));
		 timerOffButton.setBackground(Color.DARK_GRAY);
		 timerOffButton.setForeground(Color.cyan);
		 
		 
		 //Add to GridBagLayout with coordinates
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
		 gb.gridx=0;
	     gb.gridy=6;
		 add(languageLabel,gb);
		 

	     
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
		 gb.gridx=1;
	     gb.gridy=6;
		 add(englishButton,gb);
		 gb.insets = new Insets(0,30,0,0);
		 
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
		 gb.gridx=2;
	     gb.gridy=6;
		 add(japaneseButton,gb);
	
		 
		 
		 //Column 4
		 gb.gridx=3;
	     gb.gridy=2;
	     gb.insets = new Insets(0,15,0,0);
		 add(largeFontButton,gb);
		 gb.gridx=3;
	     gb.gridy=5;
	     gb.insets = new Insets(0,-10,0,0);
		 add(timerOffButton,gb);
	

		 //Each screen has a position, thus Options knows where to return to
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (position == "startscreen") {
	            		
	            		 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, nameOptionsBool2, stopTimer);	          
		            	    cards.add(startScreen, "startscreen");
		            	    layout.show(cards, "startscreen");
		            	    
	            	}		
	            	
	            	else {
	            		  layout.show(cards, position);	            	
	            	}	            
	        	  
	                
	            				}	
	            			}
				 		);
		 
		 //All subsequent Action Listeners must update any relevant screen with new variables
		 smallFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		font1 = new Font("SANS_SERIF", Font.BOLD, 10);
	            	    mg = new MainGame(cl, cards, font1, language1, textSpeed1, stopTimer);
	            	    
	            	    startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen,
	            	    		nameOptionsBool, player,setVisible,language1, textSpeed1, 
	            	    		fullText2, rival, false, stopTimer);
	            	    
	            	    cards.add(mg, "mainscreen");  
	            	    cards.add(startScreen, "startscreen"); 
	            	    
	            	  
		               
	            				}	
	            			}
				 		);
		 
		 mediumFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	font1 = new Font("SANS_SERIF", Font.BOLD, 30);
	            	 mg = new MainGame(cl, cards, font1, language1, textSpeed1, stopTimer);
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, false, stopTimer);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");    
	                
	                
	            				}	
	            			}
				 		);
		
		 
		 
		 largeFontButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	font1 = new Font("SANS_SERIF", Font.BOLD, 50);
	            	 mg = new MainGame(cl, cards, font1, language1, textSpeed1, stopTimer);
	            	    cards.add(mg, "mainscreen");
	                
	            				}	
	            			}
				 		);
		 
		 englishButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 mg = new MainGame(cl, cards, font, "English", textSpeed1, stopTimer);
	            	 language1 = "English";
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, false, stopTimer);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");
	            
	            	   
	                
	            				}	
	            			}
				 		);
		 
		 japaneseButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 mg = new MainGame(cl, cards, font, "Japanese", textSpeed1, stopTimer);
	            	 language1 = "Japanese";
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, false, stopTimer);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");
	            	
	            	   
	                
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
		 
		 //The higher the number, the slower the speed
		 //Initialized in UI Class as default
		 slowTextSpeedButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            		textSpeed1 = 100;
	    
	            		stopTimer = false;
		            	 mg = new MainGame(cl, cards, font, language, textSpeed1, stopTimer);
		            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, false, true);
		            	 cards.add(mg, "mainscreen");
		            	 cards.add(startScreen, "startscreen");
		            	
	            				}	
	            			}
				 		);
		 
		 fastTextSpeedButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	textSpeed1 = 50;
	            	stopTimer = false;
	            	
	            	 mg = new MainGame(cl, cards, font, language, textSpeed1, stopTimer);
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, false, true);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");
	            	
	            				}	
	            			}
				 		);
		 timerOffButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	 stopTimer = true;
	            	 mg = new MainGame(cl, cards, font, language, textSpeed1, stopTimer);
	            	 startScreen = new StartScreen(cl, cards, font1, startScreenTextArea,finish,screen, nameOptionsBool, player,setVisible,language1, textSpeed1, fullText2, rival, false, true);
	            	 cards.add(mg, "mainscreen");
	            	 cards.add(startScreen, "startscreen");
	            				}	
	            			}
				 		);
		 
	}
	

}
