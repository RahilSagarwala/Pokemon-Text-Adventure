// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package Trainer;

import java.util.ArrayList;

import javax.swing.JPanel;

import items.*;
import items.Map;
import pokemon.*;

import java.awt.CardLayout;
import java.awt.Font;
import java.io.*; 
import java.util.*; 

public class Player extends TrainerSuper {
	int i;
	CardLayout cl;
	JPanel cards;
	int badgeNumber = 0;
	int id;

	
	public Player() {
		money = 0;	
	}
	
	public int getBadeNumber() {
		return badgeNumber;
	}
	
	public void incrementBadgeNumber() {
		badgeNumber++;
	}
	
	public void generateId() {
		 Random random = new Random();
		 id = Math.abs(random.nextInt());
	}
	
	public int getId() {
		return id;
	}

}
	
