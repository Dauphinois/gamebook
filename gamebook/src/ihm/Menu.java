package ihm;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jeu.IIHM;
import jeu.Jeu;

public class Menu extends IIHM{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel bgPanel;
	private JPanel buttonPanel;
	private JScrollPane explication;
	private JTextArea explicationText;
	private JButton start;
	private JButton close;
	private JButton load;
	private static final String STARTTEXT = "Commencer";
	private static final String CLOSETEXT = "Quitter";
	private static final String LOADTEXT = "Reprendre";
	private static final String DEFAULTEXPLICATION = "Bienvenue dans le jeu dont vous êtes le héros."
			+ " L'objectif de ce jeu sera, dans chaque situation donnée, de choisir l'action que vous "
			+ "voudrez effectuer.\n Pour commencer une nouvelle partie, cliquez sur Commencer, pour reprendre"
			+ "une ancienne partie, cliquez sur Reprendre, les parties seront alors rangées de la plus récente (1)"
			+ " à la plus ancienne (3).\n Une fois en jeu, la situation s'affichera en haut"
			+ " de l'écran et les choix s'afficheront au centre en blanc. Appuyez sur les flèches pour afficher"
			+ " l'option suivante/précédente et sur Suivant pour valider l'option. Si aucune option ne s'affiche c'est qu'"
			+ "aucun choix n'est nécessaire, appuyez donc sur Suivant pour voir la suite.\n Bonne partie !";
	private static final String BACKGROUND = "icon.png";
	
	public Menu(String titre,int width, int height, Jeu j) {
		super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String gamebook = System.getProperty("user.dir");
        String img = ".." + File.separator + getIMG();
        String file = gamebook + File.separator + img + File.separator + BACKGROUND;
        this.bgPanel = new JPanelBackground(file);
        this.panel = new JPanel(new BorderLayout());
        
        this.explicationText = new JTextArea(DEFAULTEXPLICATION);
        this.explicationText.setLineWrap(true);
        this.explicationText.setWrapStyleWord(true);
        this.explication = new JScrollPane(this.explicationText);
        
        this.start = new JButton(STARTTEXT);
        this.start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.startGame();
            }
        });
        
        this.close = new JButton(CLOSETEXT);
        this.close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.end();
            }
        });
        
        this.load = new JButton(LOADTEXT);
        this.load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.loadGame();
            }
        });
        
        if(!Jeu.existsSaves())
        	this.load.setEnabled(false);

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.buttonPanel.add(this.close);
        this.buttonPanel.add(this.start);
        this.buttonPanel.add(this.load);
        
        this.panel.add(this.explication,BorderLayout.NORTH);
        this.panel.add(this.buttonPanel,BorderLayout.SOUTH);
        this.panel.add(this.bgPanel);
        
        this.explicationText.setBackground(getBgColor());
        this.buttonPanel.setBackground(getBgColor());

        this.setContentPane(this.panel);
        this.pack();
        this.setSize(width, height);
        this.setResizable(false);
	}
	
	@Override
	public void disableButtons() {
		super.disableButtons();
        for (Component component : this.buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(false);
            }
        }
    }

	@Override
	public void enableButtons() {
		super.enableButtons();
		for (Component component : this.buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(true);
            }
        }
	}
	
}
