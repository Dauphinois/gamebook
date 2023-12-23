package representation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ihm.IHMJeu;
import jeu.INode;

public class ChanceNode extends InnerNode{

	private List<Double> pourcentagesDestinations;
	private static Random r = new Random();
	private static final String DEFAULTDECISION="";
	
	public ChanceNode(int id, String description, List<INode> destinations, List<Double> pourcentages, IHMJeu ihm) {
		super(id,description,destinations,ihm);
		this.pourcentagesDestinations = new ArrayList<Double>(pourcentages);
	}

	@Override
	public INode chooseNext() {
		double tirage = (double)r.nextInt(101)/ 100.0; //tirage d'un nombre décimal aléatoire entre 0 et 1
		for(int i=0,p=0;i<this.getDestinations().size();++i) {
			if(tirage>=p && tirage <=p+this.pourcentagesDestinations.get(i)) {
				return this.getDestinations().get(i);
			}
			p+=this.pourcentagesDestinations.get(i);	
		}
		return this;
	}

	@Override
	public String getDecision() {
		return DEFAULTDECISION;
	}
	
}
