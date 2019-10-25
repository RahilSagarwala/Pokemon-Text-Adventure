package attacks;

import java.util.Random;

import pokemon.*;

public class AttackSuper {
	String englishName, japaneseName, type;
	double baseAccuracy;
	int pp, basePower;
	
	public AttackSuper(int pp) {
		this.pp = pp;
	}
	
	public String getAttackName(String theLanguage) {
		if (theLanguage == "English") {
			return englishName;
		}
		
		else {
			return japaneseName;
		}
		
	}
	
	public void useAttack(PokemonSuper attackingPokemon, PokemonSuper receivingPokemon ) {
		switch (type) {
		case "Normal": 
			if (attackingPokemon.getType() == "Ghost") {
				return;
		}
			else {
				int attackingPokemonAttackPower = attackingPokemon.getAttack();
				int receivingPokemonDefensePower = receivingPokemon.getDefense();
				Random random = new Random();
				int critical = random.nextInt(10) + 1;
				if (critical < 3) {
					//Add bonus damage for critical
					int damage = (basePower) * (attackingPokemonAttackPower/15) *
							(receivingPokemonDefensePower/15) + 5;
					receivingPokemon.setHp(receivingPokemon.getHp() - damage);
				}
				
				else {
					//Standard Damage
					int damage = (basePower) * (attackingPokemonAttackPower/15) *
							(receivingPokemonDefensePower/15);
					receivingPokemon.setHp(receivingPokemon.getHp() - damage);
				}

			}
			
		}
	
	}

}
