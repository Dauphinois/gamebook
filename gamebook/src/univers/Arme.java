package univers;

public class Arme {

	private String nom;
	private double efficacite;
	private static final String DEFAULTNOM = "Couteau";
	private static final double DEFAULTEFFICACITE = 0.7;
	
	public Arme() {
		this(DEFAULTNOM,DEFAULTEFFICACITE);
	}
	
	public Arme(String nom, double efficacite) {
		this.nom = nom;
		this.efficacite = efficacite;
	}
	
}
