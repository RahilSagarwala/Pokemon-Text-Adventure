package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.border.EmptyBorder;

import mainGame.ConfirmContinue;
import mainGame.Options;

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
import mainGame.Player;

public class StartScreen extends JPanel {
	
	CardLayout cl;
    JPanel cards, nameOptionsPanel;
    Font textAreaFont = new Font("SANS_SERIF", Font.BOLD, 30);
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JTextArea startScreenText1;
    JButton nextButton1, nextButton2, name1, name2, name3, name4, optionsButton;
    int count = 0;
    int stringLength = 0;
    String stringText;
    StartScreen ss;
    Timer tm;
    Boolean finish, nameOptionsBool = false, setVisible = true;
    String screen;
    Player player2;
    String language, nextText, redText, greenText, blueText, yellowText;
    Options options;
    int textSpeed;
    Boolean stopTimer;
    String fullText2;
    String optionsButtonText;
    
	public void timerStart(String text, Boolean stopTimer){
		String text2 = text;
		count = 0;
		
		
		tm = new Timer(textSpeed, new ActionListener() {
	
	    public void actionPerformed(ActionEvent arg0) {
	 	  
	
			   stringLength = text2.length();
			
			   count++;
			   if(count > stringLength) {
				   		
				    
				    finish = true;	
				    
	
			   } 	
			   
			   else {
				   
			    startScreenText1.setText(text2.substring(0,count));
			    finish = false;
					   }
			
			  }
	    
			 });
		
		 if (finish == true) {
			
			   tm.stop();
		   }
		 
		 if (stopTimer == true) {
		 }
		 else {
	  tm.start();
		 }
	  
	 

		}

   
	public StartScreen(final CardLayout layout, final JPanel cards, Font font, JTextArea textArea, Boolean finish, String screen,
			Boolean nameOptionsBool, Player player, Boolean setVisible, String language, int textSpeed, String fullText) {
		
		 //Attributes passed on from screen to screen, couple of them not needed anymore, player 2 has its name set in case 4
		 this.player2 = player;     
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.startScreenText1 = textArea;
	     this.finish = finish;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     this.setVisible = setVisible;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.fullText2 = fullText;
	     
	     //Extension of JFrame, set layout and attributes for layout
		 setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 startScreenText1 = new JTextArea();		 
		 startScreenText1.setForeground(Color.cyan);
		 startScreenText1.setBackground(Color.black);
		 startScreenText1.setFont(textAreaFont);
	
		 
		 //Elements not used dynamically have their text changed based off of language
		 if (language == "English") {
			 nextText = "Next";
			 blueText = "BLUE";
			 redText = "RED";
			 greenText = "GREEN";
			 yellowText = "YELLOW";
			 optionsButtonText = "Options";	 
		 }	 
		 else {
			 
			 nextText = "つぎ ";
			 blueText = "ブルー";
			 redText = "レッド";
			 greenText = "グリーン";
			 yellowText = "イエロー";
			 optionsButtonText = "せっていを かえる ";
		 }
		 
	
	 //Screen values are initialized on button click action listeners below
		 //fullText2 is used within Timer
	//English main Text
     if (language == "English") { 
    	 switch (screen) {
    	 
    	 case "1":
           	 fullText2 = "*An image of a man in a lab coat appears.* \n\n Oak: Hello there! "
      		 		+ "Welcome to the world of POKEMON! My name is OAK!\r\n" + 
      		 		"            People call me the POKEMON PROF!";    
           	 break;
    	 case "2":

	       		fullText2 = "*An image of a Nidorino appears.*\r\n" + 
             		"Oak: This world is inhabited by creatures called POKEMON! For some\r\n" + 
             		"            people, POKEMON are pets. Others use them for fights. Myself...\r\n" + 
             		"            I study POKEMON as a profession.";
	       		break;
    	 case "3":
    		 fullText2 = "*An image of a boy (the player's character) appears.*\r\n" + 
     				"\r\n" + 
     				"Oak: First, what is your name?";
    		 break;
    		 
    	 case "4":
    		
         	fullText2 = "Oak: Right! So your name is " + player2.getName() + ".";
    		 break;
    		 
    	 case "5":
    		 fullText2 = "*An image of another boy appears.*\r\n" +  
	       				"Oak: This is my grandson. He's been your rival since you were a baby.\r\n" + 
	       				"\r\n" + 
	       				" ...Erm, what is his name again?\r\n";
    		 break;
    		 
    	
    	 }
     }
	         //Japanese main text
	         else {
	        	 switch(screen) {
	        	 case "1":
	        	
	        	 fullText2 = "はじめまして！  ポケッ モンスタ- のせかいへ ようこそ！";
	        	 break;
	        	 
	        	 
	        	 case "2":
	        		 fullText2 = "の ポケモン という いきものを ひとは ぺツトに  したり しょうぶに つかったリ。。。\r\n" + 
	            				"そして。。。わたしは この ポケモンの けんきゅを してる というわけだ \r\n" + "では はじめに きみの なまえを おしえて もらおう！";
	        		 break;
	        		 
	        	 case "3":
	        		 fullText2 = "の ポケモン という いきものを ひとは ぺツトに  したり しょうぶに つかったリ。。。\r\n" + 
	            				"そして。。。わたしは この ポケモンの けんきゅを してる というわけだ \r\n" + "では はじめに きみの なまえを おしえて もらおう！";
	        		 break;
	        		 
	        	 case "4": 
	        		 fullText2 = "ふむ。。。" + player2.getName() +  " と いうんだな！";
	        		 break;
	        		 
	        	 case "5":
	        		 fullText2 = "こいつは わたしの まご きみの おさななじみであリ ライバル である\r\n" + "。。。えーと？ なまえ わ なんで いつたかな？";
	        		 break;
	        		
	        	 }
	         }
	        	 
	         
		 //Start timer with stopTimer value set to false. Only true when going into options from this screen to stop any overlay issues
     	 timerStart(fullText2, false);
     	 
     	 
		 //GUI Setup 
		 JButton nextButton1 = new JButton(nextText);
		 nextButton1.setPreferredSize(new Dimension(150,75));
		 nextButton1.setBackground(Color.DARK_GRAY);
		 nextButton1.setForeground(Color.cyan);
		 nextButton1.setFont(buttonFont);
		 nextButton1.setVisible(setVisible);
		
		 
		 JButton name1 = new JButton(redText);
		 name1.setPreferredSize(new Dimension(200,75));
		 name1.setBackground(Color.DARK_GRAY);
		 name1.setForeground(Color.red);
		 name1.setFont(buttonFont);
		 
		 JButton name2 = new JButton(blueText);
		 name2.setPreferredSize(new Dimension(200,75));
		 name2.setBackground(Color.DARK_GRAY);
		 name2.setForeground(Color.blue);
		 name2.setFont(buttonFont);
		 
		 JButton name3 = new JButton(greenText);
		 name3.setPreferredSize(new Dimension(200,75));
		 name3.setBackground(Color.DARK_GRAY);
		 name3.setForeground(Color.green);
		 name3.setFont(buttonFont);
		 
		 JButton name4 = new JButton(yellowText);
		 name4.setPreferredSize(new Dimension(200,75));
		 name4.setBackground(Color.DARK_GRAY);
		 name4.setForeground(Color.yellow);
		 name4.setFont(buttonFont);
		 
		 JPanel nameOptionsPanel = new JPanel();
		 nameOptionsPanel.setLayout(new GridLayout(1,4));
		 nameOptionsPanel.add(name1);
		 nameOptionsPanel.add(name2);
		 nameOptionsPanel.add(name3);
		 nameOptionsPanel.add(name4);
		 nameOptionsPanel.setVisible(nameOptionsBool);
		 
		 
		 JButton optionsButton = new JButton(optionsButtonText);
		 optionsButton.setPreferredSize(new Dimension(200,75));
		 optionsButton.setBackground(Color.DARK_GRAY);
		 optionsButton.setForeground(Color.cyan);
		 optionsButton.setFont(buttonFont);

		 gb.gridx=0;
	     gb.gridy=0;
		 add(optionsButton, gb);
		 gb.gridx=0;
	     gb.gridy=1;
	     gb.weighty=1;
		 add(startScreenText1, gb);
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nameOptionsPanel, gb);
	     gb.gridx=0;
	     gb.gridy=4;
	     add(nextButton1, gb);
	     
	     //Options Button recreates Options object and shows Options screen with all values already included in StartScreen class (passed on)
	     optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	options = new Options(cl, cards,"startscreen", startScreenText1, finish, screen, nameOptionsBool, player2, setVisible, language, textSpeed, fullText2);
					cards.add(options, "options");
					cl.show(cards, "options");
					timerStart(fullText2, true);
	                
	            }
	        });
	  
	     
	     //Next button click recreates and shows current screen with updated value for screen string
		 switch (screen) {
		 case "1":
		 nextButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	
		       	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "2", false, player2, true, language, textSpeed,fullText2);
                cards.add(ss, "startscreen");
                layout.show(cards, "startscreen");  
             
	                
	            }
	        });
		 break;
		 
		 case "2":
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "3", true, player2, false, language, textSpeed,fullText2);
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
	             
		                
		            }
		        });
			 break;
			 
		 
	 
		 case "4":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "5", true, player2, false, language, textSpeed,fullText2);
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");  
	             
		                
		            }
		        });
			 
		 }
		 
		 //Action listener for name buttons: create player object, set its name, initialize current screen, and show updated screen
		  switch(screen) {
		  case "3":
		 name1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	player2 = new Player("RED");

	            	}
	            	
	            	else {
	            		
	            	 	player2 = new Player("レッド ");	       		    
	            		
	            	}
	            	
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player2, true, language, textSpeed,fullText2);
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
  
	                
	            }
	        });

		 
		 name2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	player2 = new Player("BLUE");

	            	}
	            	
	            	else {
	            	player2 = new Player("ブルー");

	            		
	            	}
	       		   
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player2, true, language, textSpeed,fullText2);
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");    
       
	                
	            }
	        });
		 
		 name3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            		player2 = new Player("GREEN");
	       		    
	            	}
	            	
	            	else {
	            		 player2 = new Player("グリーン");
	
	            	}
	       		    
	             
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player2, true, language, textSpeed,fullText2);
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
	                
	            }
	        });
		 
		 name4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	player2 = new Player("YELLOW");
	         
	       		    
	            	}
	            	
	            	else {
	            		player2 = new Player("イエロー"); 
	            
	            	}
	       		   
	            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player2, true, language, textSpeed,fullText2);
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");  
       
	                
	            }
	        });
		 
		
		 //Action Listener for Rival NPC Trainer's name
		  case "5":
				 name1.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
			            
		          
			                
			            }
			        });
				 
				 name2.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
 
		       
			                
			            }
			        });
				 
				 name3.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {
 
		       
			                
			            }
			        });
				 
				 name4.addActionListener(new ActionListener() {
			            public void actionPerformed(ActionEvent e) {

			                
			            }
			        });
				 break;
		 
		  }
		 
		 
	
		
	}
	

	

	
	}
	
	
