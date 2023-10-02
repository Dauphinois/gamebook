package jeu;

import representation.InnerNode;
import representation.Node;

public class Jeu {

	private static Node currentNode;
	private static final String startDescription = "Situation test";
	
	public Jeu() {
		currentNode = new InnerNode(startDescription);
	}
	
	public static Node getCurrentNode() {
		return currentNode;
	}
	
}
