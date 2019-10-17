package pokemon;

import java.util.ArrayList;
import java.util.Random;

import items.ItemSuper;
import attacks.*;

public class PokemonSuper {
	String englishName;
	String japaneseName;
	String russianName;
	String language;
	String type;
	int level, experience, hp, attack, defense, spAttack, spDefense;
	double catchRate, ecounterRate;
	ArrayList<AttackSuper> attackArrayList = new ArrayList<AttackSuper>(4);
	String location;
	 Random random = new Random();
	
	public PokemonSuper(String location) {	
		this.location = location;
	}
	
	public void generateStats() {
		//Random stats based upon level
		if (level == 5) {
			int randomHp = random.nextInt(10) + 1;
			hp = randomHp;
			int randomAttack = random.nextInt(10) + 1;
			attack = randomAttack;
			int randomDefense = random.nextInt(10) + 1;
			defense = randomDefense;
			int randomSpAttack = random.nextInt(10) + 1;
			spAttack = randomSpAttack;
			int randomSpDefense = random.nextInt(10) + 1;
			spDefense = randomSpDefense;	
			
		}
	}
	
	public String getType() {
	return type;
	}
	
	
	public ArrayList<AttackSuper> getAttacks() {
		return attackArrayList;
	}
	
	public void setAttacks(AttackSuper attack) {
		if(attackArrayList.size() < 4) {
		attackArrayList.add(attack);
		}
		else {
			//Remove an attack and add another attack
			return;
		}
	}
	
	
	public String getPokemonName(String theLanguage) {
		if (theLanguage == "English") {
			return englishName;
		}
		else if (theLanguage == "Japanese") {
			return japaneseName;
		}
		else {
			return russianName;
		}
		
	}
	
	public void setPokemonName(String name) {
		englishName = name;
		japaneseName = name;
		russianName = name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setHp(int newHp) {
		hp = newHp;
	}

	
}
