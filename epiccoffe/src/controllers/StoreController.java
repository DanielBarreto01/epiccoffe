package controllers;

import java.io.IOException;

import models.ManagerStrore;
import models.Product;
import models.Store;

public class StoreController {
	private ManagerStrore managerStrore;
	private Store store[];
	
	public StoreController() {
		managerStrore = new ManagerStrore();
		store = new Store[1];
	}
	
	public void createStore(int idProduct, int idPerson, int unitsNumber, double unitPrice, String productName) throws IOException, InterruptedException {
		managerStrore.createStrore(new Store(idProduct, idPerson, unitsNumber, unitPrice,  productName));
	}
	
	public void showStore() throws IOException, InterruptedException {
		store = managerStrore.getProducts();
	}

	public Store[] getStore() {
		return store;
	}
	
	public void deleteStore(int id) throws IOException, InterruptedException {
		managerStrore.deleteStore(id);
	}
}
