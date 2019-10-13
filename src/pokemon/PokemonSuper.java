package pokemon;

import java.util.ArrayList;

import items.ItemSuper;
import attacks.*;

public class PokemonSuper {
	String englishName;
	String japaneseName;
	String language;
	String type;
	int level, experience, hp, attack, defense, spattack, spdefense;
	double catchRate, ecounterRate;
	ArrayList<AttackSuper> attackArrayList = new ArrayList<AttackSuper>(4);
	
	public PokemonSuper(ArrayList<AttackSuper> attackArrayList, int level, int experience, int hp, 
			int attack, int defense, int spattack, int spdefense) {	
	this.attackArrayList = attackArrayList;
	this.hp = hp;
	this.level = level;
	this.experience = experience;
	this.attack = attack;
	this.defense = defense;
	this.spattack = spattack;
	this.spdefense = spdefense;
	}
	
	
	public String getPokemonName(String theLanguage) {
		if (theLanguage == "English") {
			return englishName;
		}
		
		else {
			return japaneseName;
		}
		
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int newHp) {
		hp = newHp;
	}
	
}
