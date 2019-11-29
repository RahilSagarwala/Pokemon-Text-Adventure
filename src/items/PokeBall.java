// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package items;

import pokemon.*;
import Trainer.*;

public class PokeBall extends ItemSuper{

	public PokeBall(int count) {
		super(count);
		englishName = "PokeBall";
		japaneseName = "";
	}
	
	public void catchPokemon(PokemonSuper pokemon, Player player) {
		if (player.getPartyPokemonArrayList().size() <= 6) {
			player.addPokemonToParty(pokemon);
		}
		else {
//			player.addPokemonToBox(pokemon);
		}
	}

}
