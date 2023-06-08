package views.home.homeAdministrator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import controllers.PersonController;
import controllers.ProductController;
import views.loginIn.ActionsLoginIn;
import views.registryPerson.ActionsRegistry;
import router.Option;
import router.Router;

//import productRegistry.JFrameProtRegistry;

public class ListenerHome implements ActionListener, MouseListener{
private JPanelHome jFrameHome;
private PersonController personController;
private static int var = 1;
	
	public ListenerHome(JPanelHome jFrameHome, PersonController personController) {
		this.personController = personController;
		this.jFrameHome= jFrameHome;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsHome actionsHome = views.home.homeAdministrator.ActionsHome.valueOf(e.getActionCommand());
		boolean validateAge = true;
		switch (actionsHome) {
			case REGISTRY:
				jFrameHome.setVisible(true);
				Router.instance.navigate(Option.Register, personController);
				
				break;
			case UP:
				jFrameHome.setVisible(true);
				Router.instance.navigate(Option.update, personController);
				break;
			case EXIT:
				Router.instance.navigate(Option.login, personController);
				jFrameHome.setVisible(false);
				break;
			case SHOW:
			try {
				jFrameHome.showPersons(personController.showPerson());
			} catch (IOException | InterruptedException e1) {
				JOptionPane.showMessageDialog(null,"Error, Revisa tu conexion a internet", "Advertencia", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
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
			jFrameHome.lateral();
	}
	@Override
	public void mouseExited(MouseEvent e) {
		
	}
	
}
