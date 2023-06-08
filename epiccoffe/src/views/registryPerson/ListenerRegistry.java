package views.registryPerson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import controllers.PersonController;
import exceptions.RepeatedDocumentNumberException;
import exceptions.RepeatedUserException;
import router.Option;
import router.Router;

public class ListenerRegistry implements ActionListener{
	
	private JPanelRegistry jFrameRegistry;
	private PersonController personController;

	public ListenerRegistry(JPanelRegistry jFrameRegistry, PersonController personController) {
		this.jFrameRegistry = jFrameRegistry;
		this.personController = personController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsRegistry actionsRegistry = views.registryPerson.ActionsRegistry.valueOf(e.getActionCommand());
		boolean validateAge = true;
		switch (actionsRegistry) {
			case ADD:
				String firstNamePerson = jFrameRegistry.getjNameText().getText();
				String LastNamePerson = jFrameRegistry.getjLastNameText().getText();
				String documentPerson = jFrameRegistry.getjLastId().getText();
				String user = jFrameRegistry.getjMail().getText();
				String password = jFrameRegistry.getjPassword().getText();
				if (!(firstNamePerson.isBlank() | LastNamePerson.isBlank() | documentPerson.isBlank())) {						
					try {
						validateAge = personController.createPerson(firstNamePerson,
							LastNamePerson, jFrameRegistry.getjComboBoxTypeId().getSelectedItem().toString(), 
							documentPerson.toUpperCase(), user, password, 
							new GregorianCalendar(Integer.parseInt(jFrameRegistry.getjComboBoxYear().getSelectedItem().toString()),
									Integer.parseInt(jFrameRegistry.getjComboBoxMounth().getSelectedItem().toString())-1,
									Integer.parseInt(jFrameRegistry.getjComboBoxDay().getSelectedItem().toString())), 
							jFrameRegistry.getjComboBoxTypePerson().getSelectedItem().toString());
					} catch (NumberFormatException | IOException | InterruptedException ex) {
						JOptionPane.showMessageDialog(null,"Error al registar", "Advertencia", JOptionPane.WARNING_MESSAGE);
						ex.printStackTrace();
						return;
					} catch (RepeatedDocumentNumberException e1) {
						JOptionPane.showMessageDialog(null,"ya hay una persona con ese documento", "Advertencia", JOptionPane.WARNING_MESSAGE);
						return;
					} catch (RepeatedUserException e1) {
						JOptionPane.showMessageDialog(null,"ya hay una persona con ese nombre de usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
						return;
					}
					if (validateAge) {
					JOptionPane.showMessageDialog(null,"Resgistro guardado con exito", "Informacion", JOptionPane.DEFAULT_OPTION);
						Router.instance.navigate(Option.HomeAdm, personController);
					}else{
						JOptionPane.showMessageDialog(null,"La persona debe ser Mayor de edad", "Advertencia", JOptionPane.WARNING_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null,"Debe llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case YEAR_AND_MOUNTH:
				jFrameRegistry.setDays();
				break;
			case CLOSE:
				Router.instance.navigate(Option.HomeAdm, personController);
				break;
		}
	}


	

}
