package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import representation.Node;
import representation.TerminalNode;

class TerminalNodeTest {

	@Test
	void test() {
		Node n1 = new TerminalNode("test");
		assertEquals(n1,n1.chooseNext(null));
	}

}
