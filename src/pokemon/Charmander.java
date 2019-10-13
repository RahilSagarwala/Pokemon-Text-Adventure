package pokemon;

import java.util.ArrayList;
import attacks.AttackSuper;

public class Charmander extends PokemonSuper {
	
	public Charmander(ArrayList<AttackSuper> attackArrayList, int level, int experience, int hp,
			int attack, int defense, int spattack, int spdefense) {
	    super(attackArrayList, level, experience, hp, attack, defense, spattack, spdefense);
		englishName = "Charmander";
		japaneseName = "ヒトカゲ";
		type = "fire";
		hp = 20;
//		attackArrayList.add()
//		attackArrayList.add()
	}

}
