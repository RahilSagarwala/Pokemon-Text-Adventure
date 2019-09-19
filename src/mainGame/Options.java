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

import mainGame.MainGame.OptionsHandler;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Options extends MainGame {
	JPanel returnPanel, optionsPanel,testPanel;
	JButton returnButton, fontSmallButton, fontMediumButton, fontLargeButton, soundtrackYesButton, soundtrackNoButton,
	textToSpeechYesButton, textToSpeechNoButton, textSpeedSlowButton, textSpeedFastButton;
	JLabel returnLabel, optionsLabel, fontLabel, soundtrackLabel, textToSpeechLabel, textSpeedLabel,testPanelLabel;
	optionsReturnHandler optionsReturnHandler = new optionsReturnHandler();
	JFrame window2;
	
	Container container2;
	
	public class optionsReturnHandler implements ActionListener{
		
		
		public void actionPerformed(ActionEvent event){

			
		}
	}
	
	public void setupOptions(Container container) {
		
		
		
		returnPanel = new JPanel();
		returnPanel.setBounds(500, -15, 200, 100);
		returnPanel.setBackground(Color.black);
		returnButton = new JButton("Return");
		returnButton.setFont(MainGame.buttonFont);
		returnButton.setPreferredSize(new Dimension(200,100));
		returnButton.setBackground(Color.DARK_GRAY);
		returnButton.setForeground(Color.cyan);
		returnPanel.add(returnButton);
		container.add(returnPanel);
		
		returnButton.addActionListener(optionsReturnHandler);
		
	}
	
}

