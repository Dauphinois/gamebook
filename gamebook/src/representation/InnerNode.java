package representation;

import java.util.ArrayList;
import java.util.List;

import jeu.INode;

public abstract class InnerNode extends Node{
	
	private ArrayList<INode> destinations;
	
	public InnerNode(int id,String description, List<INode> destinations) {
		super(id,description);
		this.destinations = new ArrayList<INode>(destinations);
	}

	@Override
	public abstract INode chooseNext();
	
	public List<INode> getDestinations(){
		return this.destinations;
	}

}
