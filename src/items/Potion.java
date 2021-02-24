// written by: Rahil Sagarwala 
// tested by: Rahil Sagarwala 
// debugged by: Rahil Sagarwala 

package items;
import java.awt.CardLayout;
import java.awt.Font;

import javax.swing.JPanel;

import Trainer.Player;
import Trainer.Rival;
import Trainer.TrainerSuper;
import locations.MapScreen;
import locations.PartyPokemon;
import pokemon.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import Trainer.Player;
import Trainer.Rival;
import Trainer.*;

public class Potion extends ItemSuper {
	Clip clip;

	public Potion(int count) {
		super(count);
		englishName = "Potion";
		japaneseName = "キズぐすり";
	}
	
	public void showPartyPokemon(CardLayout cl, JPanel cards, Font font, String screen, String language, int textSpeed, Player player, Rival rival, Boolean stopTimer, String location, Boolean professorOakVisited,
			Boolean labOutsideButtonEnable, TrainerSuper trainer, int battleScreenText, String englishName, String japaneseName,
			int itemIndex, String color, String previousLocation, Clip clip) {
		PartyPokemon partyPokemon = new PartyPokemon(cl, cards, font, "", language, textSpeed,
    			player, rival, stopTimer, location, professorOakVisited, labOutsideButtonEnable,
    			trainer, battleScreenText, "potion", itemIndex, color, previousLocation, clip);
    	cards.add(partyPokemon, "partypokemon");
        cl.show(cards, "partypokemon");
	}
	
	public void usePotion(PokemonSuper pokemon) {
		//Make sure Pokemon has not fainted, potion has no effect on fainted Pokemon
		if (pokemon.getHp() > 0) {
		int newHp = pokemon.getHp() + 20;
		pokemon.setHp(newHp);
		if (pokemon.getHp() > pokemon.getMaxHp()) {
			pokemon.setHp(pokemon.getMaxHp());
		}
		}
		else {
			return;
		}
		
	}

}
