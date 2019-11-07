import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import attacks.*;

class AttacksTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testGetAttacks() {
		Attacks attackList = Attacks.getAttacks();
		assertNotNull(attackList, "getAttacks() returned null");
	}
	
	@Test
	void testGetAttack() {
		Attacks attackList = Attacks.getAttacks();
		Attack poundTest = attackList.getAttack(1);
		Attack absorbTest = attackList.getAttack(71);
		Attack struggleTest = attackList.getAttack(165);
		
		Attack poundActual = new Attack();
		Attack absorbActual = new Attack();
		Attack struggleActual = new Attack();
		
		poundActual.setAccuracy(100);
		poundActual.setCategory("Physical");
		poundActual.setContest("Tough");
		poundActual.setengName("Pound");
		poundActual.setJapName("ポンド");
		poundActual.setNum(1);
		poundActual.setPower(40);
		poundActual.setPp(35);
		poundActual.setType("Normal");
		
		absorbActual.setAccuracy(100);
		absorbActual.setCategory("Special");
		absorbActual.setContest("Clever");
		absorbActual.setengName("Absorb");
		absorbActual.setJapName("吸収する");
		absorbActual.setNum(71);
		absorbActual.setPower(40);
		absorbActual.setPp(15);
		absorbActual.setType("Grass");
		
		struggleActual.setAccuracy(0);
		struggleActual.setCategory("Physical");
		struggleActual.setContest("Tough");
		struggleActual.setengName("Struggle");
		struggleActual.setJapName("闘争");
		struggleActual.setNum(165);
		struggleActual.setPower(50);
		struggleActual.setPp(1);
		struggleActual.setType("Normal");
		
		assertNotNull(poundTest);
		assertNotNull(absorbTest);
		assertNotNull(struggleTest);
		assertTrue(poundTest.getNum() == poundActual.getNum());
		assertTrue(absorbTest.getNum() == absorbActual.getNum());
		assertTrue(struggleTest.getNum() == struggleActual.getNum());
		
		assertTrue(poundTest.getCategory() == poundActual.getCategory());
		assertTrue(absorbTest.getCategory() == absorbActual.getCategory());
		assertTrue(struggleTest.getCategory() == struggleActual.getCategory());
		
		assertTrue(poundTest.getAccuracy() == poundActual.getAccuracy());
		assertTrue(absorbTest.getAccuracy() == absorbActual.getAccuracy());
		assertTrue(struggleTest.getAccuracy() == struggleActual.getAccuracy());
		
	}

}
