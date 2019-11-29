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

public class ContinueGame extends JPanel {
	
	JButton returnButton, saveOneButton, saveTwoButton, saveThreeButton;
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JLabel chooseSaveLabel;
    ConfirmContinue cc;
    ConfirmContinue confirmContinue;
    String language, saveText;
    Font font;
    int textSpeed;
    MainGame mg;
    Player player;
    Rival rival;
    Boolean stopTimer, labOutsideButtonEnable;
    Float titleSize;
    int buttonWidth;
    int buttonHeight;
    Boolean professorOakVisited;
    String color;

	
	public ContinueGame (final CardLayout layout, final JPanel cards, String language, Font font, int textSpeed,
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
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 
		 
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(buttonFont);
		 
		 JLabel chooseSaveLabel = new JLabel("Choose your save file: ");
		 chooseSaveLabel.setFont(font);
		 chooseSaveLabel.setForeground(Color.cyan);
		 
		 JButton saveOneButton = new JButton("Save 1");
		 saveOneButton.setPreferredSize(new Dimension(150,75));
		 saveOneButton.setBackground(Color.DARK_GRAY);
		 saveOneButton.setForeground(Color.cyan);
		 saveOneButton.setFont(buttonFont);
		 
		 JButton saveTwoButton = new JButton("Save 2");
		 saveTwoButton.setPreferredSize(new Dimension(150,75));
		 saveTwoButton.setBackground(Color.DARK_GRAY);
		 saveTwoButton.setForeground(Color.cyan);
		 saveTwoButton.setFont(font);
		 
		 JButton saveThreeButton = new JButton("Save 3");
		 saveThreeButton.setPreferredSize(new Dimension(150,75));
		 saveThreeButton.setBackground(Color.DARK_GRAY);
		 saveThreeButton.setForeground(Color.cyan);
		 saveThreeButton.setFont(font);
		 
		 if(language == "Japanese") {
			 returnButton.setText("とじる");
			 chooseSaveLabel.setText("どのレポートを ロードしますか？");
			 saveOneButton.setText("レポート 1");
			 saveTwoButton.setText("レポート 2");
			 saveThreeButton.setText("レポート 3");
			 saveOneButton.setPreferredSize(new Dimension(200,75));
			 saveTwoButton.setPreferredSize(new Dimension(200,75));
			 saveThreeButton.setPreferredSize(new Dimension(200,75));
		 }
		 
		
		 
		 gb.gridx = 0;
		 gb.gridy = 0;
		 gb.weighty = 1;
		 add(returnButton, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 1;
		 add(chooseSaveLabel, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 2;
		 add(saveOneButton, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 3;
		 add(saveTwoButton, gb);
		 
		 gb.gridx = 0;
		 gb.gridy = 4;
		 add(saveThreeButton, gb);
		 
		 
		 

		 returnButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	              	
	            	try {
						Clip clip = null;
						//On instead of off for Music on as default
						mg = new MainGame(cl,cards, font,language, textSpeed, stopTimer, 
								titleSize, buttonWidth, buttonHeight, player, rival,professorOakVisited,labOutsideButtonEnable, 
								color, clip, "off", "no");
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
		 
		 saveOneButton.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	            	
	            	
	            	if (language == "English") {
	            		saveText = "Continue Save 1?";
	            	}
	            	else {
	            		saveText = "レポート　１　 ロードしますか？";
	            	}
	            	
	                confirmContinue = new ConfirmContinue(cl, cards,saveText, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	        	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	                cards.add(confirmContinue, "confirmcontinue");
	                layout.show(cards, "confirmcontinue");    
	                
	                
	            
	               
	            }
	        });
		 
		
		 
		 saveTwoButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            		saveText = "レポート　２　 ロードしますか?";
	            	}
	            	else {
	            		saveText = "";
	            	}
	            	
	            	
	                confirmContinue = new ConfirmContinue(cl, cards,saveText, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	        	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	                cards.add(confirmContinue, "confirmcontinue");
	                layout.show(cards, "confirmcontinue");    
	              
	            	
	           
	            }
	        });
		 
		 saveThreeButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	if (language == "English") {
	            		saveText = "Continue Save 3?";
	            	}
	            	else {
	            		saveText = "レポート　３　 ロードしますか";
	            	}
	            	
	                confirmContinue = new ConfirmContinue(cl, cards,saveText, language, font, textSpeed, player, rival, stopTimer, titleSize, 
	        	 			buttonWidth, buttonHeight, professorOakVisited, labOutsideButtonEnable, color);
	                cards.add(confirmContinue, "confirmcontinue");
	                layout.show(cards, "confirmcontinue");    
	             
	                
	            }
	        });
	}


}

