package mainGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.Timer;

public class TimerClass {
	String text;
	Boolean stopTimer;
	int textSpeed;
	JTextArea textArea;
	Timer tm;
	int stringLength;
	Boolean finish = false;
	int count;
	
	public TimerClass(String text, Boolean stopTimer, int textSpeed, JTextArea textArea) {
		this.text = text;
		this.stopTimer = stopTimer;
		this.textSpeed = textSpeed;
		this.textArea = textArea;

		
		if (stopTimer) {
			tm = new Timer(textSpeed, new ActionListener() {
				
			    public void actionPerformed(ActionEvent arg0) {
			    	

			    	 textArea.setText(text);
			    	}

					 });
				
				 if (finish == true) {
					
					   tm.stop();
				   }
			
			  tm.start();
		}
		
		else {
		tm = new Timer(textSpeed, new ActionListener() {
			
	    public void actionPerformed(ActionEvent arg0) {
	    	
	    	   
	    	   stringLength = 0;
			   stringLength = text.length();
			
			   count++;
			   if(count > stringLength || stringLength == 0) {
				   		 
				    finish = true;	
			   } 	
			   
			   else {
				   
			    textArea.setText(text.substring(0,count));
			    finish = false;
					   }
	    	}

			 });
		
		 if (finish == true) {
			
			   tm.stop();
		   }
	
	  tm.start();
	
		
		
	}
	

		

		}

}
