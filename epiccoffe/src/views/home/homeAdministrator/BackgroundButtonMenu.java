package views.home.homeAdministrator;

import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackgroundButtonMenu  extends JPanel{
	private String url ="./resources/imagenes/menu.png";
	
	public BackgroundButtonMenu() {
		this.setSize(30,30);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Dimension dimension= this.getSize();
		ImageIcon ImageIcon = new ImageIcon(url);
		g.drawImage(ImageIcon.getImage(), 0,0,dimension.width,dimension.height ,null);
		setOpaque(false);
		super.paintChildren(g);
		setOpaque(false);
		super.paintComponent(g);
		System.out.println("papa");
	}
}
