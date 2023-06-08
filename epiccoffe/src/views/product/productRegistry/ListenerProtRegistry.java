package views.product.productRegistry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import router.Option;
import router.Router;

import controllers.PersonController;
import controllers.ProductController;


public class ListenerProtRegistry implements ActionListener{
	private JFrameProtRegistry jFrameProtRegistry;
	private ProductController productController;
	private PersonController personController;
	
	public ListenerProtRegistry(JFrameProtRegistry jFrameProtRegistry, ProductController productController, PersonController personerController) {
		this.jFrameProtRegistry= jFrameProtRegistry;
		this.productController = productController;
		this.personController = personerController;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsRegistryProduct actionsRegistryProduct = views.product.productRegistry.ActionsRegistryProduct.valueOf(e.getActionCommand());
		switch (actionsRegistryProduct) {
		case REGISTER: 
			String name = jFrameProtRegistry.getJName().getText();
			String description = jFrameProtRegistry.getJDescription().getText();
			String unitPricee = jFrameProtRegistry.getJPrice().getText();
			String units = jFrameProtRegistry.getJUnits().getText();	
			try {
				productController.createProduct(name, description, unitPricee, units, 
						personController.getActualPerson().getId());
			} catch (IOException | InterruptedException e1) {
				
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null,"Resgistro guardado con exito", "Informacion", JOptionPane.DEFAULT_OPTION);
		}
		Router.instance.navigate(Option.HomeAso, personController);
	}

}
