package views;



import javax.swing.JFrame;
import javax.swing.WindowConstants;

import router.BackgroundFondo;



public class JFrameMain extends JFrame {
	
	private BackgroundFondo backgroundFondo;
	public JFrameMain() {
		//this.personController = personController;
		//backgroundFondo = new BackgroundFondo();
		//listenerHome = new ListenerHome(this , personController);
		
		this.setTitle("EpicCoffe");
	
		this.setBounds(20, 20, 810, 470);
		this.setLocationRelativeTo(null);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setResizable(false);
	//	this.add(backgroundFondo);
	
		//backgroundFondo.addMouseListener(new ListenerMouse(this));
		
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		//GraphicsDevice grafica = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		//grafica.setFullScreenWindow(this);
		
		//setEnabled(true);
		//setResizable(false);
		setVisible(true);
	}
}
