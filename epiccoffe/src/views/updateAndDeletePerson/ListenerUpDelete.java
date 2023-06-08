package views.updateAndDeletePerson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import controllers.PersonController;
import exceptions.RepeatedDocumentNumberException;
import exceptions.RepeatedUserException;
import router.Option;
import router.Router;

public class ListenerUpDelete implements ActionListener {
	private JPanelUpDelete jPanelUpDelete;
	private PersonController personController; 

	public ListenerUpDelete(JPanelUpDelete jPanelUpDelete, PersonController personController) {
		this.personController = personController;
		this.jPanelUpDelete = jPanelUpDelete;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsUpDelete actionsUpDelete = views.updateAndDeletePerson.ActionsUpDelete.valueOf(e.getActionCommand()); 
	    switch (actionsUpDelete) {
			case UPDATE: 
			String firstNamePerson = jPanelUpDelete.getjNameText().getText();
			String LastNamePerson = jPanelUpDelete.getjLastNameText().getText();
			String documentPerson = jPanelUpDelete.getjLastId().getText();
			String user = jPanelUpDelete.getjMail().getText();
			String password = jPanelUpDelete.getjPassword().getText();
			if (!(firstNamePerson.isBlank() | LastNamePerson.isBlank() | documentPerson.isBlank())) {
			boolean validate = true;
			try {
				validate = personController.UpdatePerson(jPanelUpDelete.getActualPerson().getDocumentNumber(),
						jPanelUpDelete.getActualPerson().getUser(),
						jPanelUpDelete.getActualPerson().getId(), 
						firstNamePerson,LastNamePerson, 
						jPanelUpDelete.getJComboBoxTypeId().getSelectedItem().toString().substring(0,2),
						documentPerson.toUpperCase(), user, password,
						jPanelUpDelete.getJComboBoxYear().getSelectedItem().toString(), 
						jPanelUpDelete.getJComboBoxMounth().getSelectedItem().toString(),
						jPanelUpDelete.getJComboBoxDay().getSelectedItem().toString(),
						jPanelUpDelete.getjComboBoxTypePerson().getSelectedItem().toString());
			} catch (NumberFormatException | IOException | InterruptedException e1) {
				JOptionPane.showMessageDialog(null,"Error al registar, revisa tu conexion a Internet", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			} catch (RepeatedDocumentNumberException e1) {
				JOptionPane.showMessageDialog(null,"ya hay una persona con ese documento", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			} catch (RepeatedUserException e1) {
				JOptionPane.showMessageDialog(null,"ya hay una persona con ese nombre de usuario", "Advertencia", JOptionPane.WARNING_MESSAGE);
				return;
			} catch (Exception e2) {
			}
				if (validate) {
					JOptionPane.showMessageDialog(null,"Resgistro actualizado con exito", "Informacion", JOptionPane.DEFAULT_OPTION);
					Router.instance.navigate(Option.HomeAdm, personController);
				}else {
					JOptionPane.showMessageDialog(null,"La persona debe ser Mayor de edad", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null,"Debe llenar todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			break;
			case DAYS:
				jPanelUpDelete.setDays();	
			break;
			case DELETE:
				String [] list = new String[] {"Si","No"};
				if (JOptionPane.showOptionDialog(null, "¿Esta seguro que desea eliminar?", "Alerta!", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, list, list[0])==0) {
					try {
						personController.deletPerson(String.valueOf(jPanelUpDelete.getActualPerson().getId()));
						JOptionPane.showMessageDialog(null,"Resgistro eliminado con exito", "Informacion", JOptionPane.DEFAULT_OPTION);
						Router.instance.navigate(Option.HomeAdm, personController);
					} catch (IOException | InterruptedException e1) {
						JOptionPane.showMessageDialog(null, "Error revisa tu conexion a Internet", "Informacion", JOptionPane.DEFAULT_OPTION);
						e1.printStackTrace();
					}
				}
			break;
			case CLOSE:
				Router.instance.navigate(Option.HomeAdm, personController);
			break;
			case SEARCH:
			try {
				jPanelUpDelete.showPerson(personController.searchPersoForDocuemnt(jPanelUpDelete.getjTextSearch().getText()));
				jPanelUpDelete.generateButtons();
			} catch (IOException | InterruptedException e1) {
				JOptionPane.showMessageDialog(null, "Error revisa tu conexion a Internet", "Advertencia", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null, "No se econtro a la persona", "Advertencia", JOptionPane.WARNING_MESSAGE);
			}
			break;

		}

	}

}
