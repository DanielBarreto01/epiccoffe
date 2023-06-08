package models;

public class Store {
	
	private int idProduct;
	private int idPerson;
	private int unitsNumber;
	private double unitPrice;
	private String productName;
	private int id;
	
	public Store(int idProduct, int idPerson, int unitsNumber, double unitPrice, String productName) {
		super();
		this.idProduct = idProduct;
		this.idPerson = idPerson;
		this.unitsNumber = unitsNumber;
		this.unitPrice = unitPrice;
		this.productName = productName;
	}

	public int getIdProduct() {
		return idProduct;
	}

	public int getIdPerson() {
		return idPerson;
	}

	public int getUnitsNumber() {
		return unitsNumber;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public String getProductName() {
		return productName;
	}

	public int getId() {
		return id;
	}
}