package jeu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import appli.IJeu;
import representation.ChanceNode;
import representation.DecisionNode;
import representation.InnerNode;
import representation.Node;
import representation.TerminalNode;

public class Jeu implements IJeu{
	
	private static final String url = "jdbc:mysql://localhost:3306/gamebook";
	private static final String user = "root";
	private static final String password = "root";
	private static final int IDDEPART = 1;
	private static INode currentNode;
	private static Connection connection;
	
	public Jeu() {
		databaseConnection();
		getGraph();
		lancer();
	}
	
	public void lancer() {
		System.out.println("Début du jeu :");
		currentNode.display();
	}
	
	public static void databaseConnection() {
		System.out.println("Connexion à la base de données...");
		try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getGraph() {
		System.out.println("Récupération des données...");
		currentNode = initialiserNode(IDDEPART);
	}
	
	public static INode initialiserNode(int id) {
		List<INode> successeurs = new ArrayList<INode>();
		List<String> textes = new ArrayList<String>();
		List<Double> pourcentages = new ArrayList<Double>();
		boolean choice = false;
		boolean chance = false;
		String description = "";
		try {
			String sql = "SELECT * FROM scene WHERE idScene="+id+";";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			result.next();
			description = result.getString("Description");
			sql = "SELECT * FROM directionChoice WHERE idDepart="+id+";";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				choice = true;
				successeurs.add(initialiserNode(result.getInt("idArrivee")));
				textes.add(result.getString("Texte"));
			}
			sql = "SELECT * FROM directionChance WHERE idDepart="+id+";";
			statement = connection.prepareStatement(sql);
			result = statement.executeQuery();
			while(result.next()) {
				chance = true;
				successeurs.add(initialiserNode(result.getInt("idArrivee")));
				pourcentages.add(result.getDouble("Chance"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(choice)
			return new DecisionNode(id,description,successeurs,textes);
		if(chance)
			return new ChanceNode(id,description,successeurs,pourcentages);
		return new TerminalNode(id,description);
	}
	
	public static INode getCurrentNode() {
		return currentNode;
	}
	
}
