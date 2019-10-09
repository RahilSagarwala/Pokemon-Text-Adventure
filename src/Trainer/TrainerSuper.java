package Trainer;

import items.*;
import pokemon.*;
import java.io.*; 
import java.util.*; 

public class TrainerSuper {
	String name = "";
	String language;
//	ItemSuper itemArray[] = new ItemSuper[100];
	ArrayList<ItemSuper> itemArrayList = new ArrayList<ItemSuper>(100);

	public TrainerSuper(String name, ArrayList<ItemSuper> itemArray) {
		this.name = name;
		this.itemArrayList = itemArray;
		
	}
	
	public String getName () {	
		
		return name;	
	}
	
	
	public void setName(String name2) {
		name = name2;
	}
	
	public void addItem(ItemSuper item) {
		itemArrayList.add(item);
	}
	
	public String getItemNames(String language) {
	
		
		return itemArrayList.get(0).getItemName(language);

	}
	
	public ArrayList<ItemSuper> getItems() {

		return itemArrayList;

	}
	

	
}
