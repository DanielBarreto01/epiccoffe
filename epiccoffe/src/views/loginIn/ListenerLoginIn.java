package views.loginIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import controllers.PersonController;
import router.Router;
import router.Option;


public class ListenerLoginIn implements ActionListener {
	private JPanelLogin jFrameLoginIn;
	private PersonController personController;

	public ListenerLoginIn(JPanelLogin jFrameLoginIn, PersonController personController) {
		this.jFrameLoginIn = jFrameLoginIn;
		this.personController = personController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		OptionLoginIn actionsRegistry = views.loginIn.OptionLoginIn.valueOf(e.getActionCommand());
		switch (actionsRegistry) {
		case ENTER:
			char[] listPassword = jFrameLoginIn.getJNamePassword().getPassword();
			String password = "";
			for (int i = 0; i < listPassword.length; i++) {
				password += listPassword[i];
			}
			try {
				if (personController.validateUser(jFrameLoginIn.getJNameUse().getText(), password)!= null) {
					System.out.println(personController.validateUser(jFrameLoginIn.getJNameUse().getText(), password));
					personController.actualPerson(jFrameLoginIn.getJNameUse().getText());
					if (personController.searchPersoForUser(jFrameLoginIn.getJNameUse().getText()).getTypeOfPerson().equals("AD - Administrador")) {
						Router.instance.navigate(Option.HomeAdm, personController);
					}else if (personController.searchPersoForUser(jFrameLoginIn.getJNameUse().getText()).getTypeOfPerson().equals("AS - Asociado")) {
						Router.instance.navigate(Option.HomeAso, personController);
					}else {
						Router.instance.navigate(Option.HomeClient, personController);
					}
					
					jFrameLoginIn.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null,"El usuario o la contraseña son inocrrectas", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				
			} catch (IOException |InterruptedException e1) {
				JOptionPane.showMessageDialog(null,"Error, Revisa tu conexion a internet", "Advertencia", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			} 
		}
	}
}
