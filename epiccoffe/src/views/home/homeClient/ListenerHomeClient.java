package views.home.homeClient;

	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.MouseEvent;
	import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.Iterator;

import javax.swing.JOptionPane;

import controllers.PersonController;
import controllers.ProductController;
import controllers.StoreController;
import router.Option;
import router.Router;
import views.home.HomeAssociated.ActionsHomeAssociated;

	//import productRegistry.JFrameProtRegistry;

	public class ListenerHomeClient implements ActionListener, MouseListener{
	private JPanelHomeClient jPanelHomeClient;
	private ProductController productController;
	private PersonController personController;
	private StoreController storeController;
		
		public ListenerHomeClient(JPanelHomeClient jPanelHomeClient, ProductController productController,  PersonController personController,
				StoreController storeController) {
			this.jPanelHomeClient = jPanelHomeClient;
			this.productController = productController;
			this.personController = personController;
			this.storeController = storeController;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			ActionsHomeCliente actionsHomeCliente = views.home.homeClient.ActionsHomeCliente.valueOf(e.getActionCommand());
			boolean validateAge = true;
			switch (actionsHomeCliente) {	
			case SHOW:
				try {
					jPanelHomeClient.showProducts(productController.getProducts());
				} catch (IOException | InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.login, personController);
				break;
			case CARRITO:
				Componets[][] componets = jPanelHomeClient.getBody();
				for (int i = 0; i < componets.length; i++) {
					for (int j = 0; j < componets[0].length; j++) {
						try {
							if (componets[i][j] != null) {
								if (Integer.parseInt(componets[i][j].getNumber().getText()) > 0) {
									componets[0][0].getProduct()
											.calculateVal(Integer.parseInt(componets[i][j].getNumber().getText()));
									storeController.createStore(componets[i][j].getProduct().getId(),
											personController.getActualPerson().getId(),
											Integer.parseInt(componets[i][j].getNumber().getText()),
											componets[i][j].getProduct().getUnitPrice(),
											componets[i][j].getProduct().getName());
									storeController.showStore();
									Router.instance.navigate(Option.Trolley, personController);
								}
							}
						} catch (IOException | InterruptedException e1) {
							JOptionPane.showMessageDialog(null, "No hay productos en el carrito", "Advertencia",
									JOptionPane.WARNING_MESSAGE);
							e1.printStackTrace();
						}
					}

				}

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
			jPanelHomeClient.lateral();
		}
		@Override
		public void mouseExited(MouseEvent e) {
			
		}
}
