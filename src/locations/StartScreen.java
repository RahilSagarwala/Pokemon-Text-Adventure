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
    Boolean finish = false, nameOptionsBool = false, setVisible = true;
    String screen;
    Player player;
    String language, nextText, redText, greenText, blueText, yellowText;
    Options options;
    
	public void timerStart(String text){
		
		count = 0;
		
		tm = new Timer(75, new ActionListener() {
			  
				
			  public void actionPerformed(ActionEvent arg0) {
			stringLength = text.length();
			
			   count++;
			   if(count > stringLength) {
				    finish = true;
				   
			    
			   } 
			   
			   else {
				   
			    startScreenText1.setText(text.substring(0,count));
			    finish = false;
					   }

			   
			  }
			 });
	tm.start();
	if(finish) {
		tm.stop();
		
	}
	

	}
    
   
	public StartScreen(final CardLayout layout, final JPanel cards, Font font, JTextArea textArea, Boolean finish, String screen,
			Boolean nameOptionsBool, Player player, Boolean setVisible, String language) {
		
		 this.player = player;     
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.startScreenText1 = textArea;
	     this.finish = finish;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     this.setVisible = setVisible;
	     this.language = language;
	     
		 setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 startScreenText1 = new JTextArea();		 
		 startScreenText1.setForeground(Color.cyan);
		 startScreenText1.setBackground(Color.black);
		 startScreenText1.setFont(textAreaFont);

		 if (language == "English") {
			 nextText = "Next";
			 blueText = "BLUE";
			 redText = "RED";
			 greenText = "GREEN";
			 yellowText = "YELLOW";
		 }
		 
		 else {
			 
			 nextText = "つぎ ";
			 blueText = "ブルー";
			 redText = "レッド";
			 greenText = "グリーン";
			 yellowText = "イエロー";
		 }
		 
		 System.out.println(language);
		 
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
		 
		 
		 JButton optionsButton = new JButton("Options");
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
	     
	     
	     optionsButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	options = new Options(cl, cards,"startscreen", startScreenText1, finish, screen, nameOptionsBool, player, setVisible, language);
					cards.add(options, "options");
					cl.show(cards, "options");
					
		
	            	
          
	                
	            }
	        });
	  
	     
	 
		 switch (screen) {
		 case "1":
		 nextButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            if (language == "English") {
	       		 
	       		startScreenText1.setText("*An image of a Nidorino appears.*\r\n" + 
                		"Oak: This world is inhabited by creatures called POKEMON! For some\r\n" + 
                		"            people, POKEMON are pets. Others use them for fights. Myself...\r\n" + 
                		"            I study POKEMON as a profession.");
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "2", false, player, true, language);
	            }
	            else {
	            	startScreenText1.setText(" わたしの なまえは オーキド みんなからは ポケモン はかせと したれれて おるよ\r\n" + 
	            			"\r\n" + 
	            			"この せかいには ポケット モンスターと よばれる\r\n" + 
	            			"\r\n" + 
	            			"いきもの たちが いたるところに すんでいる！ ");
		       		ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "2", false, player, true, language);
   
	            }
	            
	            ss.timerStart(startScreenText1.getText());
                cards.add(ss, "startscreen");
                layout.show(cards, "startscreen");  
             
	                
	            }
	        });
		 break;
		 
		 case "2":
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	if (language == "English") {
		       		 
		       		startScreenText1.setText("*An image of a boy (the player's character) appears.*\r\n" + 
		       				"\r\n" + 
		       				"Oak: First, what is your name?");
		       	 ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "3", true, player,false, "English");
		            	}
		            	else {
		            		startScreenText1.setText("その ポケモン という いきものを ひとは ぺツトに  したり しょうぶに つかったリ。。。\r\n" + 
		            				"そして。。。わたしは この ポケモンの けんきゅを してる というわけだ \r\n" + 
		            				"では はじめに きみの なまえを おしえて もらおう！");
				       	 ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "3", true, player,false, "Japanese");
		            	}

		       		   
		       		 ss.timerStart(startScreenText1.getText());
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");     
	             
		                
		            }
		        });
			 break;
	 
		 case "4":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	if (language == "English") {
		       		 
		       		startScreenText1.setText("*An image of another boy appears.*\r\n" +  
		       				"Oak: This is my grandson. He's been your rival since you were a baby.\r\n" + 
		       				"\r\n" + 
		       				" ...Erm, what is his name again?\r\n" 
		       				);
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "5", true, player, false, "English");
		       		    
		            	}
		            	
		            	else {
		            		startScreenText1.setText("こいつは わたしの まご きみの おさななじみであリ ライバル である\r\n" + 
		            				"。。。えーと？ なまえ わ なんで いつたかな？");
		            	ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "5", true, player, false, "Japanese");
		            		
		            		
		            	}
		       		    ss.timerStart(startScreenText1.getText());
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");     
	             
		                
		            }
		        });
			 
		 }
		  switch(screen) {
		  case "3":
		 name1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	Player player = new Player("RED");

		       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() + "."
		       				);

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "English");
	       		    
	            	}
	            	
	            	else {
	            		
	            	 	Player player = new Player("レッド ");

			       		 
		            	startScreenText1.setText("ふむ。。。" + player.getName() + " と いうんだな！");

		       		
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "Japanese");
	            		
	            	}
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen"); 
	                
          
	                
	            }
	        });

		 
		 name2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	Player player = new Player("BLUE");
	            	
	            	
	       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() + "."
		       				);

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "English");
	       		    
	            	}
	            	
	            	else {
	            		Player player = new Player("ブルー");
		            	
	   	       		 
	            		startScreenText1.setText("ふむ。。。" + player.getName() +  " と いうんだな！");

		       		
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "Japanese");
	            	}
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
       
	                
	            }
	        });
		 
		 name3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	Player player = new Player("GREEN");
	         
	            	
	       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() + ".");

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "English");
	       		    
	            	}
	            	
	            	else {
	            		Player player = new Player("グリーン");
	       	         
		            	
	   	       		 
	            		startScreenText1.setText("ふむ。。。" + player.getName() +  " と いうんだな！");

		       		
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "Japanese");
	            	}
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
       
	                
	            }
	        });
		 
		 name4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	            	if (language == "English") {
	            	Player player = new Player("YELLOW");
	            	
	       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() + ".");

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "English");
	       		    
	            	}
	            	
	            	else {
	            		Player player = new Player("イエロー"); 
	            				
		            	
	   	       		 
	            		startScreenText1.setText("ふむ。。。" + player.getName() +  " と いうんだな！");

		       		
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player, true, "Japanese");
	            	}
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
       
	                
	            }
	        });
		 
		
		 
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
