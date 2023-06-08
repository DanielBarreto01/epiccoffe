package views.home.homeClient;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class ListenerMouse implements MouseListener {
	private JPanelHomeClient jFrameHomeClient;
	
	public ListenerMouse(JPanelHomeClient jFrameHomeClient) {
		this.jFrameHomeClient = jFrameHomeClient;
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		jFrameHomeClient.e();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
