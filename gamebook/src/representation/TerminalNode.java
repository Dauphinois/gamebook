package representation;

public class TerminalNode extends Node{
	
	private IPersonnage personnage;
	private static final String ENDTEXT = "Votre partie est terminée. ";
	private static final String GOODBYETEXT = "Vous pouvez rejouer pour obtenir un meilleur score "
			+ "ou bien simplement essayer les autres scénarios, à bientôt !";
	
	public TerminalNode(int id, String description,IPersonnage p) {
		super(id,description);
		this.personnage = p;
	}

	@Override
	public Node chooseNext() {
		return this;
	}
	
	@Override
	public boolean estFin() {
		return true;
	}

	@Override
	public String getDecision() {
		return ENDTEXT + "Votre statut est : " + this.personnage.getStatut() + " à l'âge de "
				+ this.personnage.getAge() + " ans, et un taux de complétion du jeu de "
						+ this.personnage.getCompletion()*100 + "%. Ceci vous fait un score de "
								+ this.personnage.getScore() + ". " + GOODBYETEXT;
	}
	
}
