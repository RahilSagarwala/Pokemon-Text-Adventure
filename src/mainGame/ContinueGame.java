package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class ContinueGame extends JPanel {
	
	JButton returnButton, saveOneButton, saveTwoButton, saveThreeButton;
	CardLayout cl;
    JPanel cards;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JLabel chooseSaveLabel;
    ConfirmContinue cc;
    ConfirmContinue confirmContinue;

	
	public ContinueGame (final CardLayout layout, final JPanel cards) {
		 this.cl = layout;
	     this.cards = cards;
	     setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 
		 
	     JButton returnButton = new JButton("Return");
	     returnButton.setPreferredSize(new Dimension(150,75));
		 returnButton.setBackground(Color.DARK_GRAY);
		 returnButton.setForeground(Color.cyan);
		 returnButton.setFont(buttonFont);
		 
		 JLabel chooseSaveLabel = new JLabel("Choose your save file: ");
		 chooseSaveLabel.setFont(buttonFont);
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
		 saveTwoButton.setFont(buttonFont);
		 
		 JButton saveThreeButton = new JButton("Save 3");
		 saveThreeButton.setPreferredSize(new Dimension(150,75));
		 saveThreeButton.setBackground(Color.DARK_GRAY);
		 saveThreeButton.setForeground(Color.cyan);
		 saveThreeButton.setFont(buttonFont);
		 
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
	                layout.show(cards, "mainscreen");
	                
	            }
	        });
		 
		 saveOneButton.addActionListener(new ActionListener(){
	            public void actionPerformed(ActionEvent e) {
	                confirmContinue = new ConfirmContinue(cl,cards, "Save 1?" );
	                cards.add(confirmContinue, "confirmcontinue");
	                layout.show(cards, "confirmcontinue");    
	            
	               
	            }
	        });
		 
		
		 
		 saveTwoButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                confirmContinue = new ConfirmContinue(cl,cards, "Save 2?" );
	                cards.add(confirmContinue, "confirmcontinue");
	                layout.show(cards, "confirmcontinue");    
	              
	            	
	           
	            }
	        });
		 
		 saveThreeButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                confirmContinue = new ConfirmContinue(cl,cards, "Save 3?" );
	                cards.add(confirmContinue, "confirmcontinue");
	                layout.show(cards, "confirmcontinue");    
	             
	                
	            }
	        });
	}


}

