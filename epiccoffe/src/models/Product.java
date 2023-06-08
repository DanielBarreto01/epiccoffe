package models;

public class Product {
	private String name;
	private String description;
	private double unitPrice;
	private int stockNumber;
	private int CodOfPerson;
	private int soldUnits;
	private double totalSalesValue;
	private int unitsAvailable;
	private int id;
	
	public Product(String name, String description, double unitPrice, int stockNumber, int codOfPerson) {
		super();
		this.name = name;
		this.description = description;
		this.unitPrice = unitPrice;
		this.stockNumber = stockNumber;
		this.CodOfPerson = codOfPerson;
		soldUnits = 0;
		totalSalesValue = 0;
		unitsAvailable = stockNumber;
	}
	
	public void calculateVal(int units){
		soldUnits += units;
		unitsAvailable = stockNumber - soldUnits;
		totalSalesValue += unitPrice * units;
	}
	
	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public int getStockNumber() {
		return stockNumber;
	}

	public int getCodOfPerson() {
		return CodOfPerson;
	}

	public int getSoldUnits() {
		return soldUnits;
	}

	public double getTotalSalesValue() {
		return totalSalesValue;
	}

	public int getUnitsAvailable() {
		return unitsAvailable;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Nombre:  "+ name + "   Precio: " +unitPrice;
	}
}
