package representation;

import jeu.INode;

public abstract class Node implements INode{

	private String description;
	private int id;
	
	public Node(int id, String description) {
		this.id= id; 
		this.description = description;
	}

	@Override
	public void display() {
		System.out.println(this);
	}
	
	@Override
	public abstract INode chooseNext();
	
	@Override
	public String toString() {
		return this.description;
	}
	
	@Override
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object o) {
		if(!this.getClass().equals(o.getClass()))
			return false;
		return this.getDescription()==((Node) o).getDescription() && this.getId()==((Node) o).getId();
	}
	
}
