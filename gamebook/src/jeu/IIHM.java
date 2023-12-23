package jeu;

import java.awt.Color;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class IIHM extends JFrame{

	private boolean buttonsDisabled;
	private static final long serialVersionUID = 1L;
	private static final String IMG = "img";
	private static final String ICON = "icon.png";
	private static final Color BGCOLOR = new Color(127,127,127,255);

	public IIHM(String titre) {
		super(titre);
		this.buttonsDisabled = false;
		String gamebook = System.getProperty("user.dir");
        String img = ".." + File.separator + IMG;
		ImageIcon icon = new ImageIcon(gamebook + File.separator + img + File.separator + ICON);
        this.setIconImage(icon.getImage());
	}
	
	public void disableButtons() {
		this.buttonsDisabled = true;
	}
	
	public void enableButtons() {
		this.buttonsDisabled = false;
	}
	
	public boolean hasButtonsDisabled() {
		return this.buttonsDisabled;
	}
	
	public static String getIMG() {
		return IMG;
	}
	
	public void display() {
		this.setVisible(true);
	}
	
	public void close() {
		this.dispose();
	}
	
	public static Color getBgColor() {
		return BGCOLOR;
	}
	
}
