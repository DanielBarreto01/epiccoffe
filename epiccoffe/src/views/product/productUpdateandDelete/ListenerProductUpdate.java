package views.product.productUpdateandDelete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JOptionPane;

import controllers.PersonController;
import controllers.ProductController;
import models.Product;
import router.Option;
import router.Router;
import views.product.productRegistry.ActionsRegistryProduct;

public class ListenerProductUpdate implements ActionListener{
	private JPanelProductUpdate jPanelProductRegistry;
	private PersonController personController;
	private ProductController productController;
	
	public ListenerProductUpdate(JPanelProductUpdate jPanelProductRegistry, PersonController personController,
			ProductController productController) {
		this.jPanelProductRegistry = jPanelProductRegistry;
		this.personController = personController;
		this.productController = productController;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ActionsProductUpdate actionsRegistryProduct = views.product.productUpdateandDelete.ActionsProductUpdate.valueOf(e.getActionCommand());
		switch (actionsRegistryProduct) {
			case SEARCH:
			try {
				Product product = productController.actualProduct(jPanelProductRegistry.getjSearch().getText(), 
						personController.getActualPerson().getId());
				jPanelProductRegistry.createComponents();
				jPanelProductRegistry.setProduct(product);
			} catch (IOException | InterruptedException  e2) {
				JOptionPane.showMessageDialog(null, "          No se pudo buscar \n revisa tu conexion a Internet", "Advertencia", JOptionPane.WARNING_MESSAGE);
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "No existe un producto con ese codigo", "Advertencia", JOptionPane.WARNING_MESSAGE);
				e1.printStackTrace();
			}
			break;
			case UP:
				int cod = Integer.parseInt(jPanelProductRegistry.getjSearch().getText());
				String name = jPanelProductRegistry.getjName().getText();
				String description = jPanelProductRegistry.getjDescription().getText();
				String units = jPanelProductRegistry.getjUnits().getText();
				String price = jPanelProductRegistry.getjPrice().getText();
				if (!name.isBlank() && !description.isBlank() && !units.isBlank() && !price .isBlank()) {
					try {
						productController.updateProduct(cod, name, description, price, units, personController.getActualPerson().getId());
						JOptionPane.showMessageDialog(null,"Datos actualizados con exito", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.HomeAso, personController);
					} catch (NumberFormatException | IOException | InterruptedException e1) {
						JOptionPane.showMessageDialog(null,"No se pudo actualizar los datos del producto", "Advertencia", JOptionPane.WARNING_MESSAGE);
						e1.printStackTrace();
					}
				}else {
					JOptionPane.showMessageDialog(null, "No pueden haber campos vacios", "Advertencia", JOptionPane.WARNING_MESSAGE);
				}
				break;
			case EXIT:
				Router.instance.navigate(Option.HomeAso, personController);
				break;
			case DELETE:
				String[] list = new String[] { "Si", "No" };
				try {
					if (JOptionPane.showOptionDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.DEFAULT_OPTION,
							JOptionPane.QUESTION_MESSAGE, null, list, list[0]) == 0) {
						productController.deleteProduct(jPanelProductRegistry.getjSearch().getText());
						JOptionPane.showMessageDialog(null, "Producto eliminado correctamente", "Advertencia",
								JOptionPane.INFORMATION_MESSAGE);
						Router.instance.navigate(Option.HomeAso, personController);
					}
				} catch (IOException | InterruptedException e1) {
					JOptionPane.showMessageDialog(null, "No se pudo eliminar el producto", "Advertencia",
							JOptionPane.WARNING_MESSAGE);
					e1.printStackTrace();
				}
				break;

			}

		}

	}
