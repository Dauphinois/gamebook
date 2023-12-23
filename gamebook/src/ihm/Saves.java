package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import jeu.IIHM;
import jeu.Jeu;

public class Saves extends IIHM{

	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JButton back;
	private static final String SAVETEXT = "Save ";
	private static final String BACKTEXT = "Retour";
	
	public Saves(String titre,int width, int height, Jeu j) {
		super(titre);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        this.back = new JButton(BACKTEXT);
        this.back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                j.backToMenu();
            }
        });
        this.panel.add(this.back);
        List<JButton> buttons = new ArrayList<JButton>();
        for(int i=1;i<=Jeu.getNbSaves(); ++i) {
        	int k = i;
        	buttons.add(new JButton(SAVETEXT + i));
            buttons.get(i-1).addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    j.loadGame(k);
                }
            });
            if(!Jeu.existsSaves(k))
            	buttons.get(i-1).setEnabled(false);
            this.panel.add(buttons.get(i-1));
        }
        
        this.panel.setBackground(getBgColor());
        
        this.setContentPane(this.panel);
        this.pack();
        this.setSize(width, height);
        this.setResizable(false);
	}
	
}
