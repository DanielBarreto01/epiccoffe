package views.home.HomeAssociated;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import controllers.PersonController;
import views.home.homeAdministrator.ActionsHome;
import router.Option;
import router.Router;

public class ListenerHomeAssociated implements ActionListener, MouseListener{

	private JPanelHomeAssociated jFrameHomeAssociated;
	private PersonController personController;
	
	public ListenerHomeAssociated(JPanelHomeAssociated jFrameHomeAssociated, PersonController personController) {
		this.jFrameHomeAssociated= jFrameHomeAssociated;
		this.personController = personController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsHomeAssociated actionsHomeAssociated = views.home.HomeAssociated.ActionsHomeAssociated.valueOf(e.getActionCommand());
		boolean validateAge = true;
		switch (actionsHomeAssociated) {
		case REGISRTY:
			Router.instance.navigate(Option.registerProduct, personController);
			break;
		case UPDATE:
			Router.instance.navigate(Option.UpdateProduct, personController);
			break;
		case EXIT:
			Router.instance.navigate(Option.login, personController);
			break;
		}
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		jFrameHomeAssociated.lateral();
	}

	@Override
	public void mouseExited(MouseEvent e) {	
	}

}
