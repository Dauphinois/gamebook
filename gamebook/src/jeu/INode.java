package jeu;

public interface INode {

	public void display();
	public INode chooseNext();
	public int getId();
	public String getDescription();
	public String getDecision();
	public boolean estFin();
	
}
