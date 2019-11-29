// written by: Rahil Sagarwala and Chad Mendenhall
// tested by: Rahil Sagarwala and Chad Mendenhall
// debugged by: Rahil Sagarwala and Chad Mendenhall

package attacks;

import java.util.Random;
import pokemon.*;
import com.google.gson.annotations.SerializedName;

public class Attack {
	@SerializedName("AttackNum")
	private int num;
	private String engName;
	private String japName;
	private String type;
	private String category;
	private String contest;
	private int pp;
	private int power;
	private int accuracy;
	
	// Accesors / Mutators
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	public String getEngName() {
		return engName;
	}
	public void setengName(String engName) {
		this.engName = engName;
	}
	
	public String getJapName() {
		return japName;
	}
	public void setJapName(String japName) {
		this.japName = japName;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public String getContest() {
		return contest;
	}
	public void setContest(String contest) {
		this.contest = contest;
	}
	
	public int getPp() {
		return pp;
	}
	public void setPp(int pp) {
		this.pp = pp;
	}
	
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public int getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	// Return the attack name specified by language argument
	public String getAttackName(String theLanguage) {
		if (theLanguage == "English") {
			return engName;
		}
		
		else {
			return japName;
		}
	}
	
	//Attack constructors
	public Attack() {
		this.num = 0;
		this.engName = "";
		this.japName = "";
		this.type = "";
		this.category = "";
		this.contest = "";
		this.pp = 0;
		this.power = 0;
		this.accuracy = 0;
	}
	public Attack(int pp) {
		this.num = 0;
		this.engName = "";
		this.japName = "";
		this.type = "";
		this.category = "";
		this.contest = "";
		this.pp = pp;
		this.power = 0;
		this.accuracy = 0;
		
	}
	
	// Attack constructor with number, and language
	public Attack(int attackNumber, String theLanguage) {

	}
	
	// Use an attack in a battle between two passed in pokemon
	public void useAttack(PokemonSuper attackingPokemon, PokemonSuper receivingPokemon ) {
		switch (type) {
		case "Normal": 
			if (attackingPokemon.getType("english") == "Ghost" || attackingPokemon.getType("english") == "" ) return;
			
			int attackingPokemonAttackPower = attackingPokemon.getAttack();
			int receivingPokemonDefensePower = receivingPokemon.getDefense();
			Random random = new Random();
			int critical = random.nextInt(10) + 1;
			if (critical < 3) {
				//Add bonus damage for critical
				int damage = (power) * (attackingPokemonAttackPower/15) *
						(receivingPokemonDefensePower/15) + 5;
				receivingPokemon.setHp(receivingPokemon.getHp() - damage);
			}
			else {
				//Standard Damage
				int damage = (power) * (attackingPokemonAttackPower/15) *
						(receivingPokemonDefensePower/15);
				receivingPokemon.setHp(receivingPokemon.getHp() - damage);
			}
		}
	}
}
