package mainGame;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
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
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MainGame {
	JFrame window;
	Container container;
	JPanel titlePanel, feedbackPanel, namesPanel, frontBoxPanel, backBoxPanel, logoPanel, mainButtonsPanel;
	JLabel titlePanelLabel, namesLabel;
	JButton feedbackButton;
	Font titleFont = new Font("SANS_SERIF", Font.BOLD, 52);
	Font italicNormalFont = new Font("SANS_SERIF", Font.ITALIC, 30);
	
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
		
		titlePanel = new JPanel();
		titlePanel.setBounds(240, 50, 800, 70);
		titlePanel.setBackground(Color.black);
		titlePanelLabel = new JLabel();
		titlePanelLabel = new JLabel("Pokémon Blue Text Audio Game");
		titlePanelLabel.setForeground(Color.blue);
		titlePanelLabel.setFont(titleFont);	
		titlePanel.add(titlePanelLabel);
		
		namesPanel = new JPanel();
		namesPanel.setBounds(150, 120, 1000, 45);
		namesPanel.setBackground(Color.black);
		namesLabel = new JLabel("By: Rahil Sagarwala, Gary Ray, and Chad Mendenhall");
		namesLabel.setForeground(Color.blue);
		namesLabel.setFont(italicNormalFont);
		namesPanel.add(namesLabel);
		
		
		feedbackPanel = new JPanel();
		feedbackPanel.setBounds(0, -15, 200, 100);
		feedbackPanel.setBackground(Color.black);
		feedbackButton = new JButton("Feedback");
		feedbackButton.setPreferredSize(new Dimension(200,100));
		feedbackPanel.add(feedbackButton);
		
		
		frontBoxPanel = new JPanel();
		
		
		backBoxPanel = new JPanel();
		
		
		logoPanel = new JPanel();
		
		
		mainButtonsPanel = new JPanel();
		
		container.add(titlePanel);
		container.add(feedbackPanel);
		container.add(namesPanel);
		
		
		
		window.setVisible(true);
	}

}



	