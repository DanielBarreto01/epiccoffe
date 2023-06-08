package router;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundFondo  extends JPanel{
	private String url =".resources/imagenes/fondoa.jpg";
	
	
	@Override
	 protected void paintComponent(Graphics g) {
        super.paintComponent(g);
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
		setOpaque(false);
		System.out.println("hols");
	}
}
