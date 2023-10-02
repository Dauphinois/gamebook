package representation;

public class TerminalNode extends Node{

	public TerminalNode(String description) {
		super(description);
	}

	@Override
	public Node chooseNext(Node next) {
		return this;
	}
	
}
