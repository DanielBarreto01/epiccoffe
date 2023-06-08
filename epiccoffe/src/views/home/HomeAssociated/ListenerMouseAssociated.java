package views.home.HomeAssociated;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ListenerMouseAssociated implements MouseListener {
	private JPanelHomeAssociated jFrameHome;
	
	public ListenerMouseAssociated(JPanelHomeAssociated jFrameHome) {
		this.jFrameHome = jFrameHome;
	}	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		jFrameHome.e();
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		jFrameHome.e();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
