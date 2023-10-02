package representation;

public abstract class Node {

	private String description;
	private int id;
	private static int idCmt = 1;
	
	public Node(String description) {
		this.description = description;
		this.id = idCmt++;
	}

	public void display() {
		System.out.println(this);
	}
	
	public abstract Node chooseNext(Node next);
	
	public String toString() {
		return this.description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
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
