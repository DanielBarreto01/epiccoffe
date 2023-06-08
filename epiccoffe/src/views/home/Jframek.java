package views.home;

import javax.swing.DebugGraphics;
import javax.swing.JFrame;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Jframek extends JFrame {
	private Image j;
	public Jframek() {
		j = new Image();
		this.setTitle("gg");
		/*UIDefaults uiDefaults = UIManager.getDefaults();
		UIManager.put("JFrame.activeTitleBackground", Color.red);
		
		uiDefaults.put("activeCaption", new javax.swing.plaf.ColorUIResource(Color.RED));
		uiDefaults.put("activeCaptionText", new javax.swing.plaf.ColorUIResource(Color.RED));
		JFrame.setDefaultLookAndFeelDecorated(true);*/
		this.setResizable ( false);
	    this.setLocationRelativeTo ( null );
		this.setBounds(0,0,800,800);
		this.setLocationRelativeTo(null);
		this.add(j);
		
	}
	
	public static void main(String[] args) {
		Jframek j = new Jframek();
		j.setVisible(true);
	}
}
