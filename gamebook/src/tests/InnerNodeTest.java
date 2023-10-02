package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import representation.InnerNode;
import representation.Node;

class InnerNodeTest {

	@Test
	void test() {
		String testText = "test";
		Node n1 = new InnerNode(testText);
		assertEquals(n1.toString(),testText);
	}

}
