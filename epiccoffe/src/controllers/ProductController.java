package controllers;

import java.io.IOException;

import models.ManagerProduct;
import models.Person;
import models.Product;

public class ProductController {
	private ManagerProduct managerProduct;
	
	public ProductController() {
		managerProduct = new ManagerProduct();
	}
	
	public void createProduct(String name, String description, String unitPrice, String stockNumber, int CodOfPerson) throws IOException, InterruptedException {
		managerProduct.createProduct(new Product(name, description, Double.parseDouble(unitPrice),Integer.parseInt(stockNumber), CodOfPerson));
	}
	
	public Product[] showProduct() throws IOException, InterruptedException {
		return managerProduct.getProducts();
	}
	
	public Product actualProduct(String codProduct, int CodeOfPerson) throws IOException, InterruptedException, Exception {
		return	managerProduct.actualProduct(codProduct, CodeOfPerson);
	}
	
	public void deleteProduct(String id) throws IOException, InterruptedException {
		managerProduct.deleteProduct(Integer.parseInt(id));
	}
	
	public void updateProduct(int id, String name, String description, String unitPrice, String stockNumber, int CodOfPerson ) throws NumberFormatException, IOException, InterruptedException {
		managerProduct.updateProduct(id, new Product(name, description, Double.parseDouble(unitPrice),Integer.parseInt(stockNumber), CodOfPerson));
	}
	
	public Product[] getProducts() throws IOException, InterruptedException {
		return managerProduct.getProducts();
	}
	
	public void updateProduct(int id, Product product) throws NumberFormatException, IOException, InterruptedException {
		managerProduct.updateProduct(id, product);
	}
	
	public Product product (int id) throws IOException, InterruptedException {
		return managerProduct.getProductId(id);
	}
}
