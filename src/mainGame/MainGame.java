package mainGame;

import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.swing.border.EmptyBorder;
import javax.swing.text.View;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import locations.StartScreen;
import Trainer.Player;
import Trainer.Rival;



public class MainGame extends JPanel {

    JPanel cards, namesPanel, titlePanel, frontBoxPanel, backBoxPanel, logoPanel;
    JButton feedbackButton, newGameButton, continueButton, tradeButton, optionsButton;
    JLabel namesLabel, titleLabel;
	Font titleFont, italicNormalFont = new Font("SANS_SERIF", Font.ITALIC, 30), buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
	
	
	JPanel mainScreenPanel;
	final static String mainScreenString = "mainscreen";
    CardLayout cl;
    
    Options options;
    Trade trade;
    NewGame newGame;
    ContinueGame continu;
    StartScreen startScreen;
    ConfirmContinue confirmContinue;
    String chosenSave = "";
    JTextArea startScreenTextArea = new JTextArea();
    Player player;
    Font font;
    String language;
    int textSpeed;
    String fullText2;
    Rival rival;
    Boolean stopTimer;
    
    
    public MainGame(final CardLayout layout, final JPanel cards, Font font, String language, int textSpeed, Boolean stopTimer) {
    	this.cl = layout;
	    this.cards = cards;
	    this.font = font;
	    this.language = language;
	    this.textSpeed = textSpeed;
	    this.stopTimer = stopTimer;
	    
	   
    	
	    setLayout(new GridBagLayout());
        setBackground(Color.black); 
        
   
      
         
        //Title Font
    	try {
		    titleFont = Font.createFont(Font.TRUETYPE_FONT, 
		            this.getClass().getClassLoader().getResourceAsStream("PokemonHollow.ttf")).deriveFont(55f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(titleFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
    	
    	//Create GUI
		titlePanel = new JPanel();
		titlePanel.setBackground(Color.black);
		titleLabel = new JLabel();
		titleLabel = new JLabel("Pok�mon Text Audio Game");
		titleLabel.setForeground(Color.LIGHT_GRAY);
		titleLabel.setFont(titleFont);	
		titlePanel.add(titleLabel);


		
		namesPanel = new JPanel();
		namesPanel.setBackground(Color.black);
		namesLabel = new JLabel("By: Rahil Sagarwala, Gary Ray, Chad Mendenhall, and Luis Siavchay");
		namesLabel.setForeground(Color.LIGHT_GRAY);
		namesLabel.setFont(italicNormalFont);
		namesPanel.add(namesLabel);
		
		
		
		newGameButton = new JButton("New Game");
		newGameButton.setBackground(Color.DARK_GRAY);
		newGameButton.setForeground(Color.cyan);
		newGameButton.setFont(buttonFont);
		
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.DARK_GRAY);
		continueButton.setForeground(Color.cyan);
		continueButton.setFont(buttonFont);
		
		tradeButton = new JButton("Trade");
		tradeButton.setBackground(Color.DARK_GRAY);
		tradeButton.setForeground(Color.cyan);
		tradeButton.setFont(buttonFont);
	
		
		optionsButton = new JButton("Options");
		optionsButton.setBackground(Color.DARK_GRAY);
		optionsButton.setForeground(Color.cyan);
		optionsButton.setFont(buttonFont);
		
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setBackground(Color.DARK_GRAY);
		feedbackButton.setForeground(Color.cyan);
		feedbackButton.setFont(buttonFont);
		
		feedbackButton.setPreferredSize(new Dimension(400,100));
		newGameButton.setPreferredSize(new Dimension(400,100));
		continueButton.setPreferredSize(new Dimension(400,100));
		tradeButton.setPreferredSize(new Dimension(400,100));
		optionsButton.setPreferredSize(new Dimension(400,100));
		
		
		//Add an image
		frontBoxPanel = new JPanel();
		
		//Add an image
		backBoxPanel = new JPanel();
		
		//Add an image
		logoPanel = new JPanel();
		
		//GridBagLayout
       
		
		//Add GUI Elements to GridBagLayout
		GridBagConstraints gb = new GridBagConstraints();		
		
		gb.gridx=0;
		gb.gridy=0;
		add(titlePanel,gb);
		
		
		gb.gridx=0;
		gb.gridy=1;
		add(namesPanel,gb);
		
		gb.gridx=0;
		gb.gridy=2;
		add(newGameButton,gb);
		
		
		
		gb.gridx=0;
		gb.gridy=3;
		add(continueButton,gb);
		
		gb.gridx=0;
		gb.gridy=4;
		add(tradeButton,gb);
		
		gb.gridx=0;
		gb.gridy=5;
		add(optionsButton,gb);	
		
		gb.gridx=0;
		gb.gridy=6;
		add(feedbackButton,gb); 
		
		
		 newGameButton.addActionListener(new ActionListener() {
			
			 public void actionPerformed(ActionEvent e) {
				 if (font == null) {
					 newGame = new NewGame(cl, cards, buttonFont, language, textSpeed, stopTimer);
					 cards.add(newGame, "newgame");
					cl.show(cards, "newgame");
					
				 }
				 else {
					newGame = new NewGame(cl, cards, font, language, textSpeed, stopTimer);
					 cards.add(newGame, "newgame");
					cl.show(cards, "newgame");
				 }
					
	            }
	        });
		 
		 optionsButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
					options = new Options(cl, cards,"mainscreen", startScreenTextArea, "1",
							false, player, true, language, textSpeed, fullText2, rival, font,
							false, stopTimer);
					cards.add(options, "options");
					cl.show(cards, "options");
					
	            }
	        });
		 
		 feedbackButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 try {
					    Desktop.getDesktop().browse(new URL("http://rsagarwala.infprojects.fhsu.edu/PokemonTextAudioGame/").toURI());
					} catch (Exception ex) {}
					
	            }
	        });
        
		 tradeButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 	cl = (CardLayout) cards.getLayout();
					cl.show(cards, "trade");
					
	            }
	        });
		 
		 continueButton.addActionListener(new ActionListener() {
				
			 public void actionPerformed(ActionEvent e) {
				 cl = (CardLayout) cards.getLayout();
					cl.show(cards, "continue");
					
	            }
	        });
    }



}
 
