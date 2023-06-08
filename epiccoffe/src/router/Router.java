package router;

import views.JFrameMain;
import views.facture.invoice.JPanelInvoice;
import views.facture.trolley.JPanelTrolley;
import views.loginIn.JPanelLogin;
import views.product.productRegistry.JFrameProtRegistry;
import views.product.productUpdateandDelete.JPanelProductUpdate;
import views.registryPerson.JPanelRegistry;
import views.updateAndDeletePerson.JPanelUpDelete;
import views.home.HomeAssociated.JPanelHomeAssociated;
import views.home.homeAdministrator.JPanelHome;
import views.home.homeClient.JPanelHomeClient;

import java.awt.Dimension;

import javax.swing.*;

import controllers.PersonController;
import controllers.ProductController;
import controllers.StoreController;

public record Router(JFrameMain jFrameMain) {
	
    public static Router instance = null;
    public static ProductController productController = new ProductController();
    public static StoreController storeController = new StoreController();
    
    public void navigate(Option route, PersonController personController) {
        switch (route) {
        	case login -> goTo(new JPanelLogin(personController));
        	case HomeAdm -> goTo(new JPanelHome(personController));
        	case Register -> goTo(new JPanelRegistry(personController));
            case update -> goToPerson(new JPanelUpDelete(personController), personController);
            case HomeAso -> goTo (new JPanelHomeAssociated(personController, productController));
            case registerProduct -> goTo (new JFrameProtRegistry(personController, productController));
            case UpdateProduct -> goTo(new JPanelProductUpdate(personController, productController));
            case HomeClient -> goTo(new JPanelHomeClient(productController, personController, storeController));
            case Trolley -> goTo(new JPanelTrolley(productController, personController, storeController));
            case Invoice -> goTo(new JPanelInvoice(personController));
        }
    }
    
    private void goToPerson(JPanelUpDelete jFameUpDelete, PersonController personController) {
    	jFrameMain.setContentPane(jFameUpDelete);
    	jFrameMain.revalidate();
    }

   private void goTo(JPanel jPanel) {
    	jPanel.setLayout(null);  
    	jFrameMain.setContentPane(jPanel);
    	jFrameMain.revalidate();
    	 
    }
}
