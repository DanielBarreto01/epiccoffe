package views.home.homeClient;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BackgroundFondo extends JLabel{
	private String url ="./resources/imagenes/principal.jpg";
	
	public BackgroundFondo(){
		this.setSize(1366, 768);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width, dimension.height, null);
		setOpaque(false);
		super.paintChildren(g);
		System.out.println("mcnnc");
	}
}
