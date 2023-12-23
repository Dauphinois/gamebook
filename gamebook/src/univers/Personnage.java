package univers;

import representation.IPersonnage;

public class Personnage implements IPersonnage{

	private String statut;
	private int age;
	private double completion;
	private static final int MULTIPLICATEUR = 1000000;
	
	public Personnage(String statut, int age, double completion) {
		this.statut = statut;
		this.age = age;
		this.completion = completion;
	}
	
	@Override
	public int getScore() {
		return (int)((this.completion*MULTIPLICATEUR)/this.age);
	}
	
	@Override
	public String getStatut() {
		return this.statut;
	}
	
	@Override
	public int getAge() {
		return this.age;
	}
	
	@Override
	public double getCompletion() {
		return this.completion;
	}
	
}
