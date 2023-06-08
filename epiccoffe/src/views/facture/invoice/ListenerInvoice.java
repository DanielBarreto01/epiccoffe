package views.facture.invoice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.PersonController;
import router.Option;
import router.Router;
import views.facture.trolley.ActionsTrolley;

public class ListenerInvoice  implements ActionListener{
	private JPanelInvoice frameInvoice;
	private PersonController personController;
	
	public ListenerInvoice(JPanelInvoice frameInvoice, PersonController personController) {
		this.personController = personController;
		this.frameInvoice= frameInvoice;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsInvoice actionsInvoice = views.facture.invoice.ActionsInvoice.valueOf(e.getActionCommand());	
		switch (actionsInvoice) {
			case EXIT:
				Router.instance.navigate(Option.HomeClient, personController);
				break;
		}
		
	}
}
