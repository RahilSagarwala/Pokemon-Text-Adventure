package mainGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GridLayout;
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
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MainGame {
	JFrame window;
	Container container;
	JPanel titlePanel, feedbackPanel, namesPanel, frontBoxPanel, backBoxPanel, logoPanel, mainButtonsPanel;
	JLabel titlePanelLabel, namesLabel;
	JButton feedbackButton, newGameButton, continueButton, tradeButton, optionsButton; 
	Font italicNormalFont = new Font("SANS_SERIF", Font.ITALIC, 30);
	Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
	Font titleFont;
	
	
	
	
	public static void main (String[] args) {
		new MainGame();
	}
	
	public MainGame() {
		window = new JFrame();
		window.setSize(1280, 680);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);

		container = window.getContentPane();
		
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
		titlePanel.setBounds(240, 50, 800, 70);
		titlePanel.setBackground(Color.black);
		titlePanelLabel = new JLabel();
		titlePanelLabel = new JLabel("Pokémon Text Audio Game");
		titlePanelLabel.setForeground(Color.LIGHT_GRAY);
		titlePanelLabel.setFont(titleFont);	
		titlePanel.add(titlePanelLabel);
		
		namesPanel = new JPanel();
		namesPanel.setBounds(150, 120, 1000, 45);
		namesPanel.setBackground(Color.black);
		namesLabel = new JLabel("By: Rahil Sagarwala, Gary Ray, Chad Mendenhall, and Luis Siavchay");
		namesLabel.setForeground(Color.LIGHT_GRAY);
		namesLabel.setFont(italicNormalFont);
		namesPanel.add(namesLabel);
		
		
		feedbackPanel = new JPanel();
		feedbackPanel.setBounds(0, -15, 200, 100);
		feedbackPanel.setBackground(Color.black);
		feedbackButton = new JButton("Feedback");
		feedbackButton.setPreferredSize(new Dimension(200,100));
		feedbackButton.setBackground(Color.DARK_GRAY);
		feedbackButton.setForeground(Color.cyan);
		feedbackButton.setFont(buttonFont);
		feedbackPanel.add(feedbackButton);
		
		
		frontBoxPanel = new JPanel();
		
		
		backBoxPanel = new JPanel();
		
		
		logoPanel = new JPanel();
		
		
		mainButtonsPanel = new JPanel();
		mainButtonsPanel.setBounds(275, 200, 700, 400);
		mainButtonsPanel.setBackground(Color.blue);
		mainButtonsPanel.setLayout(new GridLayout(4,1));
		
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
		
		newGameButton.setPreferredSize(new Dimension(200,100));
		continueButton.setPreferredSize(new Dimension(200,100));
		tradeButton.setPreferredSize(new Dimension(200,100));
		optionsButton.setPreferredSize(new Dimension(200,100));
		mainButtonsPanel.add(newGameButton);
		mainButtonsPanel.add(continueButton);
		mainButtonsPanel.add(tradeButton);
		mainButtonsPanel.add(optionsButton);
		
		container.add(titlePanel);
		container.add(feedbackPanel);
		container.add(namesPanel);
		container.add(mainButtonsPanel);
		
		
		window.setVisible(true);
	}

}



	