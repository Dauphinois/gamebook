package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import representation.Node;
import representation.TerminalNode;

class TerminalNodeTest {

	@Test
	void test() {
		Node t = new TerminalNode(1,"noeud terminal",null);
		assertEquals(1,t.getId());
		assertEquals("noeud terminal",t.getDescription());
		assertSame(t.chooseNext(),t);
		assertTrue(t.estFin());
	}

}
