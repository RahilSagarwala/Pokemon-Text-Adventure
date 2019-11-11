package attacks;

import java.util.Random;

import pokemon.PokemonSuper;

public class AttackSuper {

	String englishName;
	String japaneseName;
	double baseAccuracy;
	int pp;
	int basePower;
	String type;

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
	
	public int getPp() {
		return pp;
	}
	
	public void useAttack(PokemonSuper attackingPokemon, PokemonSuper receivingPokemon ) {
		
		receivingPokemon.setHp(receivingPokemon.getHp() - 2);
		
		
		
//		switch (type) {
//		case "Normal": 
//			if (attackingPokemon.getType("english") == "Ghost" || attackingPokemon.getType("english") == "" ) {
//				System.out.println("1");
//				return;
//			}
//			
//			int attackingPokemonAttackPower = attackingPokemon.getAttack();
//			int receivingPokemonDefensePower = receivingPokemon.getDefense();
//			Random random = new Random();
//			int critical = random.nextInt(10) + 1;
//			System.out.println("2");
//			if (critical < 3) {
//				//Add bonus damage for critical
//				int damage = (basePower) * (attackingPokemonAttackPower/15) *
//						(receivingPokemonDefensePower/15) + 5;
//				receivingPokemon.setHp(receivingPokemon.getHp() - damage);
//				System.out.println("3");
//			}
//			else {
//				//Standard Damage
//				int damage = (basePower) * (attackingPokemonAttackPower/15) *
//						(receivingPokemonDefensePower/15);
//				receivingPokemon.setHp(receivingPokemon.getHp() - damage);
//				System.out.println("4");
//			}
//		}
	}
}