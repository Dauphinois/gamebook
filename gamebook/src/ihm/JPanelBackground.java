package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class JPanelBackground extends JPanel {

	private static final long serialVersionUID = 1L;
	private Image backgroundImage;

	public JPanelBackground(String fileName){
		try {
			this.backgroundImage = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int panelWidth = getWidth();
        int panelHeight = getHeight();
        Image scaledImage = backgroundImage.getScaledInstance(panelWidth, panelHeight, Image.SCALE_SMOOTH);
        g.drawImage(scaledImage, 0, 0, this);
	}
	
}
