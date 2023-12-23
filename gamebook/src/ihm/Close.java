package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jeu.IIHM;
import jeu.Jeu;

public class Close extends IIHM{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JPanel buttonPanel;
	private JTextArea questionText;
	private JScrollPane question;
	private JButton yes;
	private JButton no;
	private static final String YESTEXT = "Oui";
	private static final String NOTEXT = "Non";
	private static final String DEFAULTQUESTION = "Voulez-vous sauvegarder ?";
	
	public Close(String titre,int width, int height, Jeu j) {
		super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.questionText = new JTextArea(DEFAULTQUESTION);
        this.questionText.setEditable(false);
        this.questionText.setBackground(new Color(0,0,0,0));
        this.question = new JScrollPane(this.questionText);
        this.question.getViewport().setOpaque(false);
        this.question.setBorder(null);
        this.panel = new JPanel();
        
        this.yes = new JButton(YESTEXT);
        this.yes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.saveGame();
            }
        });
        
        this.no = new JButton(NOTEXT);
        this.no.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.endGame();
            }
        });

        this.buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.buttonPanel.add(this.yes);
        this.buttonPanel.add(this.no);

        this.panel.add(question);
        this.panel.add(buttonPanel);
        this.panel.setBackground(getBgColor());
        this.buttonPanel.setBackground(getBgColor());
        this.question.setBackground(getBgColor());
        
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
