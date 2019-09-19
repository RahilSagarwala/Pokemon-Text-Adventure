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
    JPanel cards, namesPanel, titlePanel, containerPanel, buttonPanel, buttonContainerPanel, feedbackPanel, frontBoxPanel, backBoxPanel, logoPanel, 
    mainButtonsPanel, borderPanel, namesTitleContainerPanel;
    JButton feedbackButton, newGameButton, continueButton, tradeButton, optionsButton;
    JLabel namesLabel; 
	JLabel titlePanelLabel;
	Font titleFont, italicNormalFont = new Font("SANS_SERIF", Font.ITALIC, 30), buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
	
	OptionsButtonHandler optionsButtonPress = new OptionsButtonHandler();
	TradeButtonHandler tradeButtonPress = new TradeButtonHandler();
	ContinueButtonHandler continueButtonPress = new ContinueButtonHandler();
	NewGameButtonHandler newGameButtonPress = new NewGameButtonHandler();
	
    final static String mainScreenString = "mainscreen";
    final static String optionsString = "options";
    final static String tradeString = "trade";
    final static String continueString = "continue";
    final static String newGameString = "newgame";
	
	
    public void addContent(Container pane) {

    	//Card Layout
        JPanel mainScreenPanel = new JPanel();
        JPanel optionsPanel = new JPanel();
        JPanel tradePanel = new JPanel();
        JPanel continuePanel = new JPanel();
        JPanel newGamePanel = new JPanel();
        mainScreenPanel.setLayout(new BorderLayout());
        mainScreenPanel.setBackground(Color.black); 
        cards = new JPanel(new CardLayout());
        cards.add(mainScreenPanel, mainScreenString);
        cards.add(optionsPanel, optionsString);
        cards.add(tradePanel, tradeString);
        cards.add(continuePanel, continueString);
        cards.add(newGamePanel, newGameString);
        pane.add(cards);
        
        optionsPanel.setBackground(Color.black);
        tradePanel.setBackground(Color.black);
        continuePanel.setBackground(Color.black);
        newGamePanel.setBackground(Color.black);
        
        
        
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
		titlePanelLabel = new JLabel();
		titlePanelLabel = new JLabel("Pokémon Text Audio Game");
		titlePanelLabel.setForeground(Color.LIGHT_GRAY);
		titlePanelLabel.setFont(titleFont);	
		titlePanel.add(titlePanelLabel);
		
		namesPanel = new JPanel();
		namesPanel.setBackground(Color.black);
		namesLabel = new JLabel("By: Rahil Sagarwala, Gary Ray, Chad Mendenhall, and Luis Siavchay");
		namesLabel.setForeground(Color.LIGHT_GRAY);
		namesLabel.setFont(italicNormalFont);
		namesPanel.add(namesLabel);
		
		JPanel namesTitleContainterPanel = new JPanel(new GridLayout(2,1));
		namesTitleContainterPanel.add(titlePanel);
		namesTitleContainterPanel.add(namesPanel);
		
		
		
		JPanel buttonContainerPanel = new JPanel();
		JPanel mainButtonsPanel = new JPanel();
		mainButtonsPanel.setBounds(275, 200, 700, 400);
		mainButtonsPanel.setBackground(Color.black);
		mainButtonsPanel.setLayout(new GridLayout(5,1));
		
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
		feedbackButton.setPreferredSize(new Dimension(200,100));
		feedbackButton.setBackground(Color.DARK_GRAY);
		feedbackButton.setForeground(Color.cyan);
		feedbackButton.setFont(buttonFont);
		
		
		newGameButton.setPreferredSize(new Dimension(200,100));
		continueButton.setPreferredSize(new Dimension(200,100));
		tradeButton.setPreferredSize(new Dimension(200,100));
		optionsButton.setPreferredSize(new Dimension(200,100));
		mainButtonsPanel.add(newGameButton);
		mainButtonsPanel.add(continueButton);
		mainButtonsPanel.add(tradeButton);
		mainButtonsPanel.add(optionsButton);
		mainButtonsPanel.add(feedbackButton);
		buttonContainerPanel.add(mainButtonsPanel);
		buttonContainerPanel.setBackground(Color.black);
		
		//Add an image
		frontBoxPanel = new JPanel();
		
		//Add an image
		backBoxPanel = new JPanel();
		
		//Add an image
		logoPanel = new JPanel();

		
		mainScreenPanel.add(buttonContainerPanel, BorderLayout.SOUTH);
		mainScreenPanel.add(namesTitleContainterPanel, BorderLayout.NORTH);
 
    
    }
     

     

    private static void createWindow() {
    
        JFrame frame = new JFrame("Pokémon Text Audio Game");	
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MainGame demo = new MainGame();
        demo.addContent(frame.getContentPane());
        frame.setSize(1280, 680);
//        frame.pack();
        frame.setVisible(true);
    }
    
public class OptionsButtonHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			CardLayout cl = (CardLayout) cards.getLayout();
			cl.show(cards, "options");
			
		}
	}

public class TradeButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, "trade");
		
	}
}
 

public class ContinueButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, "continue");
		
	}
}
 

public class NewGameButtonHandler implements ActionListener{
	
	public void actionPerformed(ActionEvent event){
		CardLayout cl = (CardLayout) cards.getLayout();
		cl.show(cards, "newgame");
		
	}
}
 
     
    public static void main(String[] args) {
       
                createWindow();
            }
 
}