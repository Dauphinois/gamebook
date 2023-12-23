package representation;
import java.util.ArrayList;
import java.util.List;

import ihm.IHMJeu;
import jeu.INode;

public class DecisionNode extends InnerNode{

	private int index;
	private List<String> textesDestinations;
	
	public DecisionNode(int id, String description, List<INode> destinations, List<String> txt, IHMJeu ihm) {
		super(id,description,destinations,ihm);
		this.textesDestinations = new ArrayList<String>(txt);
		this.index = 0;
		this.updateDecision();
	}

	@Override
	public INode chooseNext() {
		return this.getDestinations().get(this.index);
	}
	
	public void displayNext() {
		if(index+1<this.getDestinations().size())
			++index;
		this.updateDecision();
	}
	
	public void displayPrevious() {
		if(index-1>=0)
			--index;
		this.updateDecision();
	}
	
	private void updateDecision() {
		super.setDecisionText(this.textesDestinations.get(this.index));
	}

	@Override
	public String getDecision() {
		return this.textesDestinations.get(this.index);
	}
	
}
