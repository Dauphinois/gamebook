package representation;

import java.util.ArrayList;
import java.util.List;

import ihm.IHMJeu;
import jeu.INode;

public abstract class InnerNode extends Node{
	
	private ArrayList<INode> destinations;
	private static IHMJeu ihm;
	
	public InnerNode(int id,String description, List<INode> destinations, IHMJeu ihm) {
		super(id,description);
		if(InnerNode.ihm==null)
			InnerNode.ihm = ihm;
		this.destinations = new ArrayList<INode>(destinations);
	}

	@Override
	public abstract INode chooseNext();
	
	@Override
	public abstract String getDecision();
	
	public List<INode> getDestinations(){
		return this.destinations;
	}
	
	public void setDecisionText(String txt) {
		ihm.setDecisionText(txt);
	}

}
