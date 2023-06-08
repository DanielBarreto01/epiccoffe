package views.home;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public class Image extends JPanel{
	private String r = "/imagen/fondo.png";
	/*public int x, y;
	 public String r = "/imagen/hola.jpg";
	public Image(Jframek jPanel1) {
        this.x = 400;//jPanel1.getWidth();
        this.y = 500;//jPanel1.getHeight();
        System.out.println(x+"  "+y);
        this.setSize(x, y);
      // paint(new DebugGraphics());
    }*/
	
	
    public void paint(Graphics g) {
		Dimension dimension = this.getSize();
        ImageIcon Img = new ImageIcon(getClass().getResource(r));
        g.drawImage(Img.getImage(), 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
        super.paintChildren(g);
    }    

}

