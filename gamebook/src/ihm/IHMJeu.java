package ihm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import jeu.IIHM;
import jeu.Jeu;

public class IHMJeu extends IIHM{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel decisionPanel;
	private JScrollPane situation;
	private JScrollPane decision;
	private JTextArea situationText;
	private JTextArea decisionText;
	private JPanel selectPanel;
	private JPanel buttonPanel;
	private JButton closeButton;
	private JButton leftButton;
	private JButton rightButton;
	private JButton selectButton;
	private static final String LEFTSIGN = "←";
	private static final String RIGHTSIGN = "→";
	private static final String SELECTTEXT = "Suivant";
	private static final String CLOSETEXT = "Quitter";
	private static final String DEFAULTTEXT = "Chargement du jeu...";
	private static final String DEFAULTDECISION = "";
	private static final String BACKGROUND = "map.jpg";
	
	public IHMJeu(String titre,int width, int height, Jeu j) {
		super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        String gamebook = System.getProperty("user.dir");
        String img = ".." + File.separator + getIMG();
        String file = gamebook + File.separator + img + File.separator + BACKGROUND;
        this.panel = new JPanel(new BorderLayout());
        this.decisionPanel = new JPanelBackground(file);

        this.situationText = new JTextArea(DEFAULTTEXT);
        this.situationText.setLineWrap(true);
        this.situationText.setWrapStyleWord(true);
        this.situationText.setEditable(false);
        this.situation = new JScrollPane(this.situationText);
        this.situationText.setBackground(getBgColor());
        this.situation.setBorder(null);
        this.decisionText = new JTextArea(DEFAULTDECISION);
        this.decisionText.setLineWrap(true);
        this.decisionText.setWrapStyleWord(true);
        this.decisionText.setEditable(false);
        this.decisionText.setForeground(Color.WHITE);
        this.decision = new JScrollPane(this.decisionText);
        this.decision.setPreferredSize(new Dimension(300,200));
        this.decisionPanel.add(decision);
        this.decisionText.setOpaque(false);
        this.decision.getViewport().setOpaque(false);
        this.decision.setBorder(null);
        this.decision.setOpaque(false);
        
        this.situation.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        this.situation.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.leftButton = new JButton(LEFTSIGN);
        this.leftButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.displayPrevious();
            }
        });

        this.rightButton = new JButton(RIGHTSIGN);
        this.rightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.displayNext();
            }
        });

        this.selectButton = new JButton(SELECTTEXT);
        this.selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.chooseNext();
            }
        });

        this.panel.add(this.situation, BorderLayout.NORTH);
        this.panel.add(this.decisionPanel, BorderLayout.CENTER);

        this.selectPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.selectPanel.add(this.leftButton);
        this.selectPanel.add(this.selectButton);
        this.selectPanel.add(this.rightButton);
        this.selectPanel.setBorder(null);
        
        this.buttonPanel = new JPanel(new BorderLayout());
        this.closeButton = new JButton(CLOSETEXT);
        this.closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.askEnding();
            }
        });
        this.buttonPanel.add(this.closeButton,BorderLayout.WEST);
        this.buttonPanel.add(this.selectPanel,BorderLayout.CENTER);

        this.panel.add(this.buttonPanel, BorderLayout.SOUTH);
        
        int w = this.selectPanel.getPreferredSize().width + this.closeButton.getPreferredSize().width;
        this.buttonPanel.setLayout(new BoxLayout(this.buttonPanel, BoxLayout.X_AXIS));
        this.buttonPanel.setBorder(new EmptyBorder(0, 0, 0, w));
        this.buttonPanel.add(Box.createRigidArea(new Dimension(0, 0)));
        this.buttonPanel.add(this.closeButton, BorderLayout.WEST);
        this.buttonPanel.add(Box.createHorizontalGlue());
        this.buttonPanel.add(this.selectPanel);
        this.buttonPanel.setBackground(getBgColor());
        this.selectPanel.setBackground(getBgColor());
        this.setContentPane(this.panel);
        this.pack();
        this.setSize(width, height);
        this.setResizable(false);
	}
	
	public void setSituationText(String txt) {
		this.situationText.setText(txt);
		this.situation.revalidate();
	}
	
	public void setDecisionText(String txt) {
		this.decisionText.setText(txt);
		this.decision.revalidate();
	}
	
	@Override
	public void disableButtons() {
		super.disableButtons();
        for (Component component : this.selectPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(false);
            }
        }
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
		for (Component component : this.selectPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(true);
            }
        }
		for (Component component : this.buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setEnabled(true);
            }
        }
	}
	
}
