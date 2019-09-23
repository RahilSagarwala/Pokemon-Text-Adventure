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
import mainGame.MainGame.OptionsButtonHandler;

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
    JButton nextButton1, nextButton2, name1, name2, name3, name4;
    int count = 0;
    int stringLength = 0;
    String stringText;
    StartScreen ss;
    Timer tm;
    Boolean finish = false, nameOptionsBool = false;
    String screen;
    Player player;
    
	public void timerStart(String text){
		
		count = 0;
		
		tm = new Timer(50, new ActionListener() {
			  
				
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
			Boolean nameOptionsBool, Player player) {
		
		 this.player = player;     
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.startScreenText1 = textArea;
	     this.finish = finish;
	     this.screen = screen;
	     this.nameOptionsBool = nameOptionsBool;
	     
		 setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 startScreenText1 = new JTextArea();		 
		 startScreenText1.setForeground(Color.cyan);
		 startScreenText1.setBackground(Color.black);
		 startScreenText1.setFont(textAreaFont);

		 
		 JButton nextButton1 = new JButton("Next");
		 nextButton1.setPreferredSize(new Dimension(150,75));
		 nextButton1.setBackground(Color.DARK_GRAY);
		 nextButton1.setForeground(Color.cyan);
		 nextButton1.setFont(buttonFont);
		 
		 JButton name1 = new JButton("RED");
		 name1.setPreferredSize(new Dimension(200,75));
		 name1.setBackground(Color.DARK_GRAY);
		 name1.setForeground(Color.red);
		 name1.setFont(buttonFont);
		 
		 JButton name2 = new JButton("BLUE");
		 name2.setPreferredSize(new Dimension(200,75));
		 name2.setBackground(Color.DARK_GRAY);
		 name2.setForeground(Color.blue);
		 name2.setFont(buttonFont);
		 
		 JButton name3 = new JButton("GREEN");
		 name3.setPreferredSize(new Dimension(200,75));
		 name3.setBackground(Color.DARK_GRAY);
		 name3.setForeground(Color.green);
		 name3.setFont(buttonFont);
		 
		 JButton name4 = new JButton("YELLOW");
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
		 

 
		 gb.gridx=0;
	     gb.gridy=0;
	     gb.weighty=1;
		 add(startScreenText1, gb);
	     gb.gridx=0;
	     gb.gridy=1;
	     add(nameOptionsPanel, gb);
	     gb.gridx=0;
	     gb.gridy=2;
	     add(nextButton1, gb);
	     
	     nameOptionsPanel.setVisible(nameOptionsBool);
	 
		 switch (screen) {
		 case "1":
		 nextButton1.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	       		 
	       		startScreenText1.setText("*An image of a Nidorino appears.*\r\n" + 
                		"Oak: This world is inhabited by creatures called POKEMON! For some\r\n" + 
                		"            people, POKEMON are pets. Others use them for fights. Myself...\r\n" + 
                		"            I study POKEMON as a profession.");

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "2", false, player);
	       		 ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
             
	                
	            }
	        });
		 break;
		 
		 case "2":
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		       		 
		       		startScreenText1.setText("*An image of a boy (the player's character) appears.*\r\n" + 
		       				"\r\n" + 
		       				"Oak: First, what is your name?");

		       		
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "3", true, player);
		       		 ss.timerStart(startScreenText1.getText());
		                cards.add(ss, "startscreen");
		                layout.show(cards, "startscreen");     
	             
		                
		            }
		        });
			 break;
	 
		 case "4":
			 
			 nextButton1.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		       		 
		       		startScreenText1.setText("*An image of another boy appears.*\r\n" +  
		       				"Oak: This is my grandson. He's been your rival since you were a baby.\r\n" + 
		       				"\r\n" + 
		       				" ...Erm, what is his name again?\r\n" 
		       				);

		       		
		       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "5", true, player);
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
	            	Player player = new Player();
	            	player.setName("RED");
	            	
	       		 
	       		startScreenText1.setText("Oak: Right! So your name is " + player.getName()
	       				);

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player);
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
          
	                
	            }
	        });
		 
		 name2.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Player player = new Player();
	            	player.setName("BLUE");
	            	
	       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() +"!\r\n" + 
		       				"\r\n" + 
		       				"*An image of another boy appears.*");

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player);
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
       
	                
	            }
	        });
		 
		 name3.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Player player = new Player();
	            	player.setName("GREEN");
	            	
	       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() +"!\r\n" + 
		       				"\r\n" + 
		       				"*An image of another boy appears.*");

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player);
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
       
	                
	            }
	        });
		 
		 name4.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	Player player = new Player();
	            	player.setName("YELLOW");
	            	
	       		 
	            	startScreenText1.setText("Oak: Right! So your name is " + player.getName() +"!\r\n" + 
		       				"\r\n" + 
		       				"*An image of another boy appears.*");

	       		
	       		    ss = new StartScreen(cl,cards, textAreaFont, startScreenText1, false, "4", false, player);
	       		    ss.timerStart(startScreenText1.getText());
	                cards.add(ss, "startscreen");
	                layout.show(cards, "startscreen");     
       
	                
	            }
	        });
		 
		  }
		 
		 
	
		
	}
	

	

	
	}
