package models;

public class Invoice {
	private String productCod;
	private String nameProduct;
	private String unitPrice;
	private int units;
	
	public Invoice(String productCod, String nameProduct, String unitPrice, int units) {
		this.productCod = productCod;
		this.nameProduct = nameProduct;
		this.unitPrice = unitPrice;
		this.units = units;
	}
}
