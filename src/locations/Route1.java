// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import Trainer.*;

public class Route1 extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer, professorOakVisited, labOutsideButtonEnable;
	Player player;
	int textSpeed;
	Rival rival;
	JButton menuButton;
	TrainerSuper trainer;
	String color;
	Clip clip;
	
    public static synchronized void startSound() {
	  	  new Thread(new Runnable() {
	  	    public void run() {
	  	      try {
	  	        Clip clip = AudioSystem.getClip();
	  	        AudioInputStream inputStream = AudioSystem.getAudioInputStream(
	  	          this.getClass().getClassLoader().getResource("route1.wav"));
	  	        clip.open(inputStream);
	  	        clip.start();
	  	      } catch (Exception e) {
	  	        System.err.println(e.getMessage());
	  	      }
	  	    }
	  	  }).start();

	  	}

	public Route1(final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, Boolean professorOakVisited,
			TrainerSuper trainer, String color, Clip clip) throws LineUnavailableException, UnsupportedAudioFileException, IOException {
		
		 this.cl = layout;
	     this.cards = cards;
	     this.textAreaFont = font;
	     this.screen = screen;
	     this.language = language;
	     this.textSpeed = textSpeed;
	     this.player = player;
	     this.rival = rival;
	     this.stopTimer = stopTimer;
	     this.location = location2;
	     this.professorOakVisited = professorOakVisited;
	     this.trainer = trainer;
	     this.color = color;
	     this.clip = clip;
	     
	
	     Clip clip3 = AudioSystem.getClip();
		    AudioInputStream inputStream = AudioSystem.getAudioInputStream(
			          this.getClass().getClassLoader().getResource("route1.wav"));
		    clip3.open(inputStream);
		    
		    if (location == "route1" && professorOakVisited ) {
		    		 clip3.start();
		    }

	     
	     else {
	    	 
	    	 clip3.close();
	     }
	     
	     
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
	     

	     JButton menuButton = new JButton("Menu");
	     menuButton.setPreferredSize(new Dimension(200,75));
	     menuButton.setBackground(Color.DARK_GRAY);
	     menuButton.setForeground(Color.cyan);
	     menuButton.setFont(font);
	     
	     if (language == "Japanese") {	   	  
	    	 menuButton.setText("メニユー");    	 
	     }
	     
	     gb.gridx = 1;
		 gb.gridy = 0;
		 gb.weighty =1;
		 gb.insets = new Insets(0,0,78,0);
		 add(menuButton, gb);
		 
		 menuButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	try {
	            	MenuScreen menu = new MenuScreen(cl, cards, textAreaFont, "", language, textSpeed,
	            			player, rival, stopTimer, "route1", professorOakVisited, 
	            			labOutsideButtonEnable, trainer, 0, color, "", clip);
	            	cards.add(menu, "menu");
	                layout.show(cards, "menu");  
	            	}
	            	catch (Exception a) {
            			a.getMessage();
            		}
	            	
	            }
	        });
		
		
	
	}

}
