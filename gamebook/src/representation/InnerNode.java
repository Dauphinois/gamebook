package representation;

import java.util.ArrayList;

public class InnerNode extends Node{
	
	private ArrayList<Node> destinations;
	
	public InnerNode(String description) {
		super(description);
		this.destinations = new ArrayList<Node>();
	}

	@Override
	public Node chooseNext(Node next) throws NotReachableNodeException{
		for(Node n : this.destinations) {
			if(n==next)
				return n;
		}
		throw new NotReachableNodeException();
	}

}
