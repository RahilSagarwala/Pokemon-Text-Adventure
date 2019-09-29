package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;


public class ConfirmContinue extends JPanel{
	CardLayout cl;
    JPanel cards;
    JButton yesButton, noButton;
    Font buttonFont = new Font("SANS_SERIF", Font.BOLD, 30);
    JLabel confirmContinueLabel;
    String saveName = "";
    
    
	public ConfirmContinue (final CardLayout layout, final JPanel cards, String name) {
		 this.saveName = name;
		 this.cl = layout;
	     this.cards = cards;
	     setBackground(Color.black);
		 setLayout(new GridBagLayout());
		 GridBagConstraints gb = new GridBagConstraints();
		 
		 JButton yesButton = new JButton("Yes");
		 yesButton.setBackground(Color.DARK_GRAY);
		 yesButton.setForeground(Color.cyan);
		 yesButton.setFont(buttonFont);
		 yesButton.setPreferredSize(new Dimension(400,100));
		 
		 JButton noButton = new JButton("No");
		 noButton.setBackground(Color.DARK_GRAY);
		 noButton.setForeground(Color.cyan);
		 noButton.setFont(buttonFont);
		 noButton.setPreferredSize(new Dimension(400,100));
		 
	
		 JLabel confirmContinueLabel = new JLabel("Continue " + saveName);
		 confirmContinueLabel.setFont(buttonFont);
		 confirmContinueLabel.setForeground(Color.cyan);
		 
		 JLabel blankLabel = new JLabel("");
		 blankLabel.setFont(buttonFont);
		 blankLabel.setForeground(Color.cyan);
		 
		 gb.gridx=0;
	     gb.gridy=1;
		 add(yesButton, gb);
		 
		 gb.gridx=0;
	     gb.gridy=2;
	     gb.weighty=1;
		 add(blankLabel, gb);
		 
		 
		 gb.gridx=1;
	     gb.gridy=0;
	     gb.weighty=1;
		 add(confirmContinueLabel, gb);
		 
		 
		 gb.gridx=2;
	     gb.gridy=1;
		 add(noButton, gb);

		
		 
		 noButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                layout.show(cards, "continue");
	            }
	        });
		 
		 //Add load file functionality
		 yesButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	
	                
	            }
	        });
	}
	
	
		 
	}


