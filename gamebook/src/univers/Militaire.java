package univers;

public abstract class Militaire {

	private String nom;
	
	public Militaire(String nom) {
		this.nom = nom;
	}
	
	public String getGrade() {
		return this.getClass().getName();
	}
	
	public String getNom() {
		return this.nom;
	}
	
}
