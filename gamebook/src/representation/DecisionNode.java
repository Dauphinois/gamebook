package representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import jeu.INode;

public class DecisionNode extends InnerNode{

	private static Scanner sc = new Scanner(System.in);
	private static String saisie;
	private List<String> textesDestinations;
	
	public DecisionNode(int id, String description, List<INode> destinations, List<String> txt) {
		super(id,description,destinations);
		this.textesDestinations = new ArrayList<String>(txt);
	}

	@Override
	public INode chooseNext() {
		for(int i=0;i<this.getDestinations().size();++i) {
			System.out.println((i+1)+" : "+this.textesDestinations.get(i));
		}
		boolean erreur = false;
		int choix = 0;
		do {
			try {
				saisie = sc.next();
				choix = Integer.parseInt(saisie)-1;
				if(choix<0 || choix>=this.getDestinations().size())
					throw new NotReachableNodeException();
				erreur = false;
			}catch(Exception e) {
				erreur = true;
				System.out.println("Veuillez uniquement saisir le chiffre correspondant à votre choix");
			}
		}while(erreur);
		return this.getDestinations().get(choix);
	}
	
	//Utile dans les tests unitaires pour vérifier la dernière valeur saisie
	public static String getSaisie() {
		return saisie;
	}
	
	public static void stopScanner() {
		sc.close();
	}
	
}
