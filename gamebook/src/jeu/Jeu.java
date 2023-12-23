package jeu;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SwingUtilities;
import appli.IJeu;
import ihm.Close;
import ihm.IHMJeu;
import ihm.Menu;
import ihm.Saves;
import representation.ChanceNode;
import representation.DecisionNode;
import representation.NotReachableNodeException;
import representation.TerminalNode;
import univers.Personnage;

public class Jeu implements IJeu{
	
	private static final String URL = "jdbc:mysql://localhost:3306/gamebook";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	private static final String NOM = "Le jeu dont vous êtes le héros";
	private static final String DATATEXT = "Connexion à la base de données...";
	private static final String GRAPHTEXT = "Récupération des données...";
	private static final String STARTTEXT = "Lancement du jeu...";
	private static final String SAVETEXT = "Votre partie a été sauvegardée avec succès";
	private static final String SAVES = "saves";
	private static final String SAVEFILENAME = "save";
	private static final String SAVEFORMAT = ".dat";
	private static final String FIRSTSAVE = "1";
	private static final int NBSAVES = 3;
	private static final int GAMEWIDTH = 800;
	private static final int GAMEHEIGHT = 600;
	private static final int MENUWIDTH = 800;
	private static final int MENUHEIGHT = 800;
	private static final int SUBWIDTH = 200;
	private static final int SUBHEIGHT = 100;
	private static final int IDDEPART = 1;
	private static INode currentNode;
	private static Connection connection;
	private static IHMJeu game;
	private static Menu menu;
	private static Close close;
	private static Saves saves;
	
	public Jeu() {
		databaseConnection();
		game = new IHMJeu(NOM,GAMEWIDTH,GAMEHEIGHT,this);
		menu = new Menu(NOM,MENUWIDTH,MENUHEIGHT,this);
		close = new Close(NOM,SUBWIDTH,SUBHEIGHT,this);
		saves = new Saves(NOM,SUBWIDTH,SUBHEIGHT,this);
		lancer();
	}
	
	public void lancer() {
		menu.display();
	}
	
	public void loadGame() {
		saves.display();
		if(!menu.hasButtonsDisabled())
			menu.disableButtons();
	}
	
	public void loadGame(int nb) {
		saves.close();
		if(menu.hasButtonsDisabled())
			menu.enableButtons();
		String gamebook = System.getProperty("user.dir");
        String saves = ".." + File.separator + SAVES;
		String file = gamebook + File.separator + saves + File.separator + SAVEFILENAME + nb + SAVEFORMAT;
		int id = 1;
		try (DataInputStream dis = new DataInputStream(new FileInputStream(file))) {
            id = dis.readInt();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
		menu.close();
		getGraph(id);
		System.out.println(STARTTEXT);
		game.display();
	}
	
	public void startGame() {
		menu.close();
		getGraph(IDDEPART);
		System.out.println(STARTTEXT);
		game.display();
	}
	
	public void continueGame() {
		close.close();
		if(menu.hasButtonsDisabled())
			menu.enableButtons();
		if(game.hasButtonsDisabled())
			game.enableButtons();
	}
	
	public void backToMenu() {
		saves.close();
		if(menu.hasButtonsDisabled())
			menu.enableButtons();
		menu.display();
	}
	
	public void end() {
		menu.close();
	}
	
	public static boolean existsSaves(int nb) {
		String gamebook = System.getProperty("user.dir");
        String saves = ".." + File.separator + SAVES;
		String file = gamebook + File.separator + saves + File.separator + SAVEFILENAME + nb + SAVEFORMAT;
		File f = new File(file);
		return f.exists() && f.length()>0;
	}
	
	public static boolean existsSaves() {
		for(int i=0;i<NBSAVES;++i) {
			if(existsSaves(i))
				return true;
		}
		return false;
	}
	
	public void askEnding() {
		close.display();
		if(!menu.hasButtonsDisabled())
			menu.disableButtons();
		if(!game.hasButtonsDisabled())
			game.disableButtons();
	}
	
	public void endGame() {
		close.close();
		game.close();
		menu.close();
	}
	
	public void saveGame() {
		String gamebook = System.getProperty("user.dir");
        String saves = ".." + File.separator + SAVES;
		String file = "";
		int i = 0;
		boolean saved = false;
		while(i<NBSAVES && !saved) {
			++i;
			file = gamebook + File.separator + saves + File.separator + SAVEFILENAME + i + SAVEFORMAT;
			if(!existsSaves(i)) {
				try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file))) {
		            dos.writeInt(currentNode.getId());
		            System.out.println(SAVETEXT);
		            dos.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
				saved = true;
			}
		}
		if(!saved) {
			for(int j=1;j<NBSAVES;++j) {
				String source = gamebook + File.separator + saves + File.separator + SAVEFILENAME + j + SAVEFORMAT;
				String destination = gamebook + File.separator + saves + File.separator + SAVEFILENAME + (j+1) + SAVEFORMAT;
				try (DataInputStream dis = new DataInputStream(new FileInputStream(source))) {
					FileOutputStream des = new FileOutputStream(destination);
					byte[] buffer = new byte[1024];
		            int bytesRead;
		            while ((bytesRead = dis.read(buffer)) != -1) {
		                des.write(buffer, 0, bytesRead);
		            }
		            des.close();
		            dis.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			}
			file = gamebook + File.separator + saves + File.separator + SAVEFILENAME + FIRSTSAVE + SAVEFORMAT;
			try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(file,false))) {
	            dos.writeInt(currentNode.getId());
	            System.out.println(SAVETEXT);
	            dos.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}
        this.endGame();
	}
	
	public static void databaseConnection() {
		System.out.println(DATATEXT);
		try {
			connection = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getGraph(int id) {
		System.out.println(GRAPHTEXT);
		currentNode = initialiserNode(id);
		game.setSituationText(currentNode.getDescription());
		game.setDecisionText(currentNode.getDecision());
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
			return new DecisionNode(id,description,successeurs,textes,game);
		if(chance)
			return new ChanceNode(id,description,successeurs,pourcentages,game);
		try {
			String sql = "SELECT * FROM endings WHERE idScene="+id+";";
			PreparedStatement statement = connection.prepareStatement(sql);
			ResultSet result = statement.executeQuery();
			while(result.next()) {
				return new TerminalNode(id,description, new Personnage(result.getString("Status"),result.getInt("Age"),result.getDouble("Completeness")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(id);
		throw new NotReachableNodeException();
	}
	
	public void displayNext() {
		if(currentNode instanceof DecisionNode) {
			DecisionNode n = (DecisionNode)currentNode;
			n.displayNext();
		}
	}
	
	
	public void displayPrevious() {
		if(currentNode instanceof DecisionNode) {
			DecisionNode n = (DecisionNode)currentNode;
			n.displayPrevious();
		}
	}
	
	public void chooseNext() {
		currentNode = currentNode.chooseNext();
		game.setSituationText(currentNode.getDescription());
		game.setDecisionText(currentNode.getDecision());
	}
	
	public static INode getCurrentNode() {
		return currentNode;
	}
	
	public static int getNbSaves() {
		return NBSAVES;
	}
	
}
