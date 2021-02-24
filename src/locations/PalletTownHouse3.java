// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package locations;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.sound.*;

public class PalletTownHouse3 extends JPanel {
	
	CardLayout cl;
	JPanel cards;
	Font textAreaFont;
	String screen, language, location;
	Boolean stopTimer;
	Player player;
	int textSpeed;
	Rival rival;
	JButton locationButton;
	String color;
	Clip clip;
	
	public PalletTownHouse3 (final CardLayout layout, final JPanel cards, 
			Font font, String screen, String language, int textSpeed, 
			Player player, Rival rival, Boolean stopTimer, String location2, String color, Clip clip) {
		
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
	     this.color = color;
	     this.clip = clip;
	     
	     
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
		
	}

}
