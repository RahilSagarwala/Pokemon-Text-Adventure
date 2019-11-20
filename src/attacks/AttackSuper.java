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
	
	public int getPower() {
		return basePower;
	}
	
	public void useGrowl(PokemonSuper attackingPokemon, PokemonSuper receivingPokemon) {
		receivingPokemon.setAttack(receivingPokemon.getAttack() - 1);
	}
	
	public void useTailWhip(PokemonSuper attackingPokemon, PokemonSuper receivingPokemon) {
		receivingPokemon.setDefense(receivingPokemon.getDefense() - 1);
	}
	
	public void useAttack(PokemonSuper attackingPokemon, PokemonSuper receivingPokemon ) {
		
//		receivingPokemon.setHp(receivingPokemon.getHp() - 2);
		
		int A = attackingPokemon.getLevel();
		int B = attackingPokemon.getAttack();
		int C = this.getPower();
		int D = receivingPokemon.getDefense();
		
		//1 or 1.5
		int X = 1;
				
		//40, 20, 10, 5, 2.5, or 0
		int Y = 10;
		
		//Random between 217 and 255
		int Z = 230;
		
//		((2A/5+2)*B*C)/D)/50)+2)*X)*Y/10)*Z)/255
		
		
		float damage1 = 2*A/5+2;
		float damage2 = ((damage1 * B * C)/D)/50;
		float damage3 = ((damage2 + 2) * X) * (Y/10);
		float damage4 = (damage3 * Z) / 255;
		int damage5 = (int)damage4;
		
		receivingPokemon.setHp(receivingPokemon.getHp() - damage5);
		

		
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