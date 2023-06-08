package views.facture.trolley;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import controllers.PersonController;
import controllers.ProductController;
import controllers.StoreController;
import models.Product;
import models.Store;
import router.Option;
import router.Router;
import views.home.homeAdministrator.ActionsHome;

public class ListenerTrolley implements ActionListener {
	
	private JPanelTrolley jFrameTrolley ;
	private PersonController personController;
	private StoreController storeController;
	private ProductController productController;

	public ListenerTrolley(JPanelTrolley jFrameTrolley, PersonController personController,
			StoreController storeController, ProductController productController) {
		this.jFrameTrolley = jFrameTrolley;
		this.personController = personController;
		this.storeController = storeController;
		this.productController = productController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsTrolley actionsTrolley = views.facture.trolley.ActionsTrolley.valueOf(e.getActionCommand());	
		switch (actionsTrolley) {
			case BUY:
				Store[] storeList = storeController.getStore();
				for (int i = 0; i < storeList.length; i++) {
					if (storeList[i] != null) {
						try {
							Product product = productController.actualProduct(storeList[i].getIdProduct()+"", productController.product(storeList[i].getIdProduct()).getCodOfPerson());
							product.calculateVal(storeList[i].getUnitsNumber());
							productController.updateProduct(storeList[i].getIdProduct(), product);
						} catch (Exception e1) {
							e1.printStackTrace();
						}
					}
				}
				actualizate();
				Router.instance.navigate(Option.Invoice, personController);
				break;
			case CANCEL:
				actualizate();
				Router.instance.navigate(Option.HomeClient, personController);
				break;
		}
	}
		
	public void actualizate() {
		Store[] storeList = storeController.getStore();
		for (int i = 0; i < storeList.length; i++) {
			if (storeList[i] != null) {
				try {
					storeController.deleteStore(storeList[i].getId());
				} catch (IOException | InterruptedException e1) {
					JOptionPane.showMessageDialog(null,"Revisa tu conexion a internet", "Advertencia", JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
			}
			
		}	
		
	}
}
