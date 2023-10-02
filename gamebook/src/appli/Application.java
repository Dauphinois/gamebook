package appli;

import jeu.Jeu;

public class Application {

	public static void main(String[] args) {
		new Jeu();
		Jeu.getCurrentNode().display();
	}

}
