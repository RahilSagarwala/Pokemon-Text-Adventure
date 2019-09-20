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


public class MainGame {
	JFrame window;
    JPanel cards, namesPanel, titlePanel, frontBoxPanel, backBoxPanel, logoPanel;
    JButton feedbackButton, newGameButton, continueButton, tradeButton, optionsButton;
    JLabel namesLabel, titleLabel;
	Font titleFont, italicNormalFont = new Font("SANS_SERIF", Font.ITALIC, 30), buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
	
	OptionsButtonHandler optionsButtonPress = new OptionsButtonHandler();
	TradeButtonHandler tradeButtonPress = new TradeButtonHandler();
	ContinueButtonHandler continueButtonPress = new ContinueButtonHandler();
	NewGameButtonHandler newGameButtonPress = new NewGameButtonHandler();
	FeedbackButtonHandler feedbackButtonPress = new FeedbackButtonHandler();
	
	final static String mainScreenString = "mainscreen";
    JPanel mainScreenPanel;
    CardLayout cl;
    
    Options options;
    Trade trade;
    NewGame newGame;
    Continue continu;
    Feedback feedback;
    
    
    
    public MainGame() {
    	window = new JFrame("Pok�mon Text Audio Game");	
    	cards = new JPanel();
    	mainScreenPanel = new JPanel();
    	cl = new CardLayout();
    	options = new Options(cl, cards);
    	trade = new Trade(cl, cards);
    	newGame = new NewGame(cl, cards);
    	continu = new Continue(cl, cards);
    	feedback = new Feedback(cl, cards);
        
        
        cards.setLayout(cl);
        
         
        //Title Font
    	try {
		    titleFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts//PokemonHollow.ttf")).deriveFont(55f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(titleFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}
   
        
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
		newGameButton.addActionListener(newGameButtonPress);
		
		
		continueButton = new JButton("Continue");
		continueButton.setBackground(Color.DARK_GRAY);
		continueButton.setForeground(Color.cyan);
		continueButton.setFont(buttonFont);
		continueButton.addActionListener(continueButtonPress);
		
		tradeButton = new JButton("Trade");
		tradeButton.setBackground(Color.DARK_GRAY);
		tradeButton.setForeground(Color.cyan);
		tradeButton.setFont(buttonFont);
		tradeButton.addActionListener(tradeButtonPress);
	
		
		optionsButton = new JButton("Options");
		optionsButton.setBackground(Color.DARK_GRAY);
		optionsButton.setForeground(Color.cyan);
		optionsButton.setFont(buttonFont);
		optionsButton.addActionListener(optionsButtonPress);
		
		
		feedbackButton = new JButton("Feedback");
		feedbackButton.setBackground(Color.DARK_GRAY);
		feedbackButton.setForeground(Color.cyan);
		feedbackButton.setFont(buttonFont);
		feedbackButton.addActionListener(feedbackButtonPress);
		
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
		
		//GridLayout
        mainScreenPanel.setLayout(new GridBagLayout());
        mainScreenPanel.setBackground(Color.black); 
		GridBagConstraints gb = new GridBagConstraints();		
		
		gb.gridx=0;
		gb.gridy=0;
		mainScreenPanel.add(titlePanel,gb);
		
		
		gb.gridx=0;
		gb.gridy=1;
		mainScreenPanel.add(namesPanel,gb);
		
		gb.gridx=0;
		gb.gridy=2;
		mainScreenPanel.add(newGameButton,gb);
		
		gb.gridx=0;
		gb.gridy=3;
		mainScreenPanel.add(continueButton,gb);
		
		gb.gridx=0;
		gb.gridy=4;
		mainScreenPanel.add(tradeButton,gb);
		
		gb.gridx=0;
		gb.gridy=5;
		mainScreenPanel.add(optionsButton,gb);	
		
		gb.gridx=0;
		gb.gridy=6;
		mainScreenPanel.add(feedbackButton,gb);
    
    	
	    cards.add(mainScreenPanel, "mainscreen");
        cards.add(options, "options");
        cards.add(newGame, "newgame");
        cards.add(continu, "continue");
        cards.add(trade, "trade");
        cards.add(feedback, "feedback");
       
        
        
        cl.show(cards, "mainscreen");
    	window.add(cards);
        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.pack();
        window.setVisible(true);
    }

	

     
    
public class OptionsButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			cl = (CardLayout) cards.getLayout();
			cl.show(cards, "options");
			
		}
	}

public class TradeButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		cl = (CardLayout) cards.getLayout();
		cl.show(cards, "trade");
		
		
	}
}
 

public class ContinueButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		cl = (CardLayout) cards.getLayout();
		cl.show(cards, "continue");
		
		
	}
}
 

public class NewGameButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		cl = (CardLayout) cards.getLayout();
		cl.show(cards, "newgame");
		
	}
}

public class FeedbackButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		cl = (CardLayout) cards.getLayout();
		cl.show(cards, "feedback");
		
	}
}
 
public static void main(String[] args) {
	new MainGame();
}
 
}