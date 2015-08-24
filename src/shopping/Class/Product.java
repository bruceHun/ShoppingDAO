package shopping.Class;

public class Product {
	private int ProductID;
	private String Barcode;
	private int CategoryID;
	private String ProductName;
	private String ProductUnit;
	private String Capacity;
	private float UnitPrice;
	private byte Discontinued;
	private String Description;
	
	public Product() {
	}

	public Product(int productID, String barcode, int categoryID, String productName, String productUnit,
			String capacity, float unitPrice, byte discontinued, String description) {
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

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public String getBarcode() {
		return Barcode;
	}

	public void setBarcode(String barcode) {
		Barcode = barcode;
	}

	public int getCategoryID() {
		return CategoryID;
	}

	public void setCategoryID(int categoryID) {
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

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}

	public byte getDiscontinued() {
		return Discontinued;
	}

	public void setDiscontinued(byte discontinued) {
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
