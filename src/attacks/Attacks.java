package attacks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.google.gson.Gson;

public class Attacks {
	private final static Attacks INSTANCE = new Attacks();
	List<Attack> attackList;
	
	private Attacks() {
		try {
			String fileData = new String(Files.readAllBytes(Paths.get("AttackData.json")));
			Attack[] attacks = new Gson().fromJson(fileData, Attack[].class);
			attackList = Arrays.asList(attacks);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Attacks getAttacks() { return INSTANCE; }
	
	public Attack getAttack(int pAttackNumber) {
		Attack attack = null;
		List<Attack> result = attackList.stream()
				.filter(item -> item.getNum() == pAttackNumber)
				.collect(Collectors.toList());
		if(result.isEmpty()) return attack;
		attack = result.get(0);
				
		return attack;
	}
}
