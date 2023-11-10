package univers;

import jeu.IPersonnage;

public class Militaire implements IPersonnage{

	private String nom;
	private String grade;
	private Arme arme;
	private static final String DEFAULTGRADE = "Soldat";
	private static final Arme DEFAULTARME = new Arme();
	
	public Militaire(String nom) {
		this(nom,DEFAULTGRADE,DEFAULTARME);
	}
	
	public Militaire(String nom, String grade, Arme arme) {
		this.nom = nom;
		this.grade = grade;
		this.arme = arme;
	}
	
	public String getGrade() {
		return this.grade;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public Arme getArme() {
		return this.arme;
	}
	
}
