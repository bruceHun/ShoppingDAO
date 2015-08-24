package shopping.Class;

public class Product {
	private Integer ProductID;
	private String Barcode;
	private Integer CategoryID;
	private String ProductName;
	private String ProductUnit;
	private String Capacity;
	private Float UnitPrice;
	private Byte Discontinued;
	private String Description;
	
	public Product() {
	}

	
	
	public Product(Integer productID, String barcode, Integer categoryID, String productName, String productUnit,
			String capacity, Float unitPrice, Byte discontinued, String description) {
		super();
		ProductID = productID;
		Barcode = barcode;
		CategoryID = categoryID;
		ProductName = productName;
		ProductUnit = productUnit;
		Capacity = capacity;
		UnitPrice = unitPrice;
		Discontinued = discontinued;
		Description = description;
	}



	public Integer getProductID() {
		return ProductID;
	}



	public void setProductID(Integer productID) {
		ProductID = productID;
	}



	public String getBarcode() {
		return Barcode;
	}



	public void setBarcode(String barcode) {
		Barcode = barcode;
	}



	public Integer getCategoryID() {
		return CategoryID;
	}



	public void setCategoryID(Integer categoryID) {
		CategoryID = categoryID;
	}



	public String getProductName() {
		return ProductName;
	}



	public void setProductName(String productName) {
		ProductName = productName;
	}



	public String getProductUnit() {
		return ProductUnit;
	}



	public void setProductUnit(String productUnit) {
		ProductUnit = productUnit;
	}



	public String getCapacity() {
		return Capacity;
	}



	public void setCapacity(String capacity) {
		Capacity = capacity;
	}



	public Float getUnitPrice() {
		return UnitPrice;
	}



	public void setUnitPrice(Float unitPrice) {
		UnitPrice = unitPrice;
	}



	public Byte getDiscontinued() {
		return Discontinued;
	}



	public void setDiscontinued(Byte discontinued) {
		Discontinued = discontinued;
	}



	public String getDescription() {
		return Description;
	}



	public void setDescription(String description) {
		Description = description;
	}



	@Override
	public String toString(){
		return 	"\nProductID: "+ProductID
				+"\nBarcode: "+Barcode
				+"\nCategoryID: "+CategoryID
				+"\nProductName: "+ProductName
				+"\nProductUnit: "+ProductUnit
				+"\nCapacity: "+Capacity
				+"\nUnitPrice: "+UnitPrice
				+"\nDiscontinued: "+Discontinued
				+"\nDescription: "+Description;
		
	}
}
