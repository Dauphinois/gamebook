package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import univers.Personnage;

class PersonnageTest {

	@Test
	void test() {
		Personnage p = new Personnage("commandant",100,0.5);
		assertEquals("commandant",p.getStatut());
		assertEquals(100,p.getAge());
		assertEquals(0.5,p.getCompletion());
		assertEquals(5000,p.getScore());
	}

}
