// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import Trainer.*;

public class Credits extends JPanel {
	
	JButton returnButton;
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    String language;
    Font font;
    int textSpeed;
    MainGame mg;
    Player player;
    Rival rival;
    Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
    Float titleSize;
    int buttonWidth;
    int buttonHeight;
    String color;
	
	public Credits (final CardLayout layout, final JPanel cards, String language, Font font, int textSpeed,
			Player player, Rival rival, Boolean stopTimer, Float titleSize, int buttonWidth, int buttonHeight,
			Boolean professorOakVisited, Boolean labOutsideButtonEnable, String color) {
		 this.cl = layout;
	     this.cards = cards;
	     this.language = language;
	     this.font = font;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.titleSize = titleSize;
	     this.buttonWidth = buttonWidth;
	     this.buttonHeight = buttonHeight;
	     this.professorOakVisited=professorOakVisited;
	     this.labOutsideButtonEnable=labOutsideButtonEnable;
	     this.color = color;
	     
//	     if (color == "black") {
//	         setBackground(Color.black); 
//	 	    }
//	 	    
//	 	    if (color == "cyan") {
//	 	        setBackground(Color.cyan); 
//	 		    }
	     
	     setBackground(Color.black); 
	     
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(200,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(font);
		 
		 JLabel nameLabel1 = new JLabel("Rahil Sagarwala:   ");
		 nameLabel1.setForeground(Color.LIGHT_GRAY);
		 nameLabel1.setFont(font);
		 
		 JLabel nameLabel2 = new JLabel("Luis Siavichay:      ");
		 nameLabel2.setForeground(Color.LIGHT_GRAY);
		 nameLabel2.setFont(font);
		 
		 JLabel nameLabel3 = new JLabel("Chad Mendenhall: ");
		 nameLabel3.setForeground(Color.LIGHT_GRAY);
		 nameLabel3.setFont(font);
		 
		 JLabel nameLabel4 = new JLabel("Gary Ray:              ");
		 nameLabel4.setForeground(Color.LIGHT_GRAY);
		 nameLabel4.setFont(font);
		 
		 Font font2 = new Font("SANS_SERIF", Font.BOLD, 20);
		 
		 JTextArea nameText1 = new JTextArea("Right logo, Graphical User Interface, " + "\n" + 
		 "Mathematical battle methods, Language swap," + "\n" + "Music integration, Options integration, Japanese integration,"
				  + "\n" + "Debug and formatting, testing," + "\n" + "Button action listeners, Trainer Objects and Properties,"
				 		+ "\n" + "Attack Objects and Properties" + "\n" + "Item objects with potion and map integration," + "\n" + "Pokémon Objects, Properties, and Stats," + "\n" + 
		 "Feedback website survey, Demo, Report," + "\n" + "Powerpoint, Brochure, Group coordination");		 
		 nameText1.setForeground(Color.cyan);
		 nameText1.setBackground(Color.black);
		 nameText1.setFont(font2);
		 
		 JTextArea nameText2 = new JTextArea("Left logo, Menu screen ideas and design, Menu Music concept" + "\n" 
		 + "idea, Feedback website design, Demo, Report" + "\n" + "Initial sound class, Initial Russian language addition" + 
				 "\n" +  "Debug and formatting, Testing, Powerpoint," + "\n" + "Brochure, Group coordination");		 
		 nameText2.setForeground(Color.cyan);
		 nameText2.setBackground(Color.black);
		 nameText2.setFont(font2);
		 
		 JTextArea nameText3 = new JTextArea("Attack test cases, Attack class file, Maven integration, Debug" + "\n"
		 + "and formatting, Testing, Demo, Report," + "\n" + "Group coordination");		 
		 nameText3.setForeground(Color.cyan);
		 nameText3.setBackground(Color.black);
		 nameText3.setFont(font2);
		 
		 JTextArea nameText4 = new JTextArea("Demo, Report, Group coordination, Testing "
		 		+ "                                 ");		 
		 nameText4.setForeground(Color.cyan);
		 nameText4.setBackground(Color.black);
		 nameText4.setFont(font2);
		 
		 
		 
		 if(language == "Japanese") {
			 returnButton.setText("とじる");
		 }
		 
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 gb.gridx = 1;
		 gb.gridy = 0;
		 gb.weighty = 1;
		 gb.insets = new Insets(0, 0,0,0);
		 add(returnButton, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 1;
		 gb.insets = new Insets(0,0,0,0);
		 add(nameLabel1, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 2;
		 add(nameLabel2, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 3;
		 add(nameLabel3, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 4;
		 add(nameLabel4, gb);
		 
		 
		 
		 
		 gb.gridx = 2;
		 gb.gridy = 1;
		 gb.insets = new Insets(0,-175,0,0);
		 add(nameText1, gb);
		 
		 gb.gridx = 2;
		 gb.gridy = 2;
		 add(nameText2, gb);
		 
		 gb.gridx = 2;
		 gb.gridy = 3;
		 add(nameText3, gb);
		 
		 gb.gridx = 2;
		 gb.gridy = 4;
		 add(nameText4, gb);
		 
		 
		 
		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
						Clip clip = null;
						//On instead of off for Music on as default
						mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, 
								titleSize, buttonWidth, buttonHeight, player, rival, professorOakVisited, 
								labOutsideButtonEnable, color, clip, "on", "no");
					} catch (LineUnavailableException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedAudioFileException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            	cards.add(mg, "mainscreen");
	                layout.show(cards, "mainscreen");

	            }
	        });
	}
	

}
