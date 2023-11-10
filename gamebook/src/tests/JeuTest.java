package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import jeu.INode;
import representation.TerminalNode;
import representation.DecisionNode;

class JeuTest {

	@Test
	void test() {
		INode fin1 = new TerminalNode(2,"Vous avez rejoint Napoleo");
		INode fin2 = new TerminalNode(3,"Vous avez rejoint Alex le grand");
		String s1 = "Rejoindre Napoleo", s2 = "Rejoindre Alex le grand";
		List<INode> destinations = new ArrayList<INode>();
		List<String> textes = new ArrayList<String>();
		destinations.add(fin1);
		destinations.add(fin2);
		textes.add(s1);
		textes.add(s2);
		INode start = new DecisionNode(1,"Vous êtes soldat et pouvez choisir de rejoindre Napoleo ou Alex le grand",destinations,textes);
		INode currentNode = start.chooseNext();
		if(DecisionNode.getSaisie().equals("1"))
			assertEquals(currentNode,fin1);
		else if(DecisionNode.getSaisie().equals("2"))
			assertEquals(currentNode,fin2);
		else
			fail();
	}

}
