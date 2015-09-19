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
        private Inventory Stock;
        private SmallPic SmallP;
	private BigPic[] BigP;
        
    public Product() {
    }

    public Product(Integer ProductID, String Barcode, Integer CategoryID, String ProductName, String ProductUnit, String Capacity, Float UnitPrice, Byte Discontinued, String Description) {
        this.ProductID = ProductID;
        this.Barcode = Barcode;
        this.CategoryID = CategoryID;
        this.ProductName = ProductName;
        this.ProductUnit = ProductUnit;
        this.Capacity = Capacity;
        this.UnitPrice = UnitPrice;
        this.Discontinued = Discontinued;
        this.Description = Description;
        Stock = new Inventory();
        SmallP = new SmallPic();
        BigP = new BigPic[6];
    }

	

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer ProductID) {
        this.ProductID = ProductID;
    }

    public String getBarcode() {
        return Barcode;
    }

    public void setBarcode(String Barcode) {
        this.Barcode = Barcode;
    }

    public Integer getCategoryID() {
        return CategoryID;
    }

    public void setCategoryID(Integer CategoryID) {
        this.CategoryID = CategoryID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getProductUnit() {
        return ProductUnit;
    }

    public void setProductUnit(String ProductUnit) {
        this.ProductUnit = ProductUnit;
    }

    public String getCapacity() {
        return Capacity;
    }

    public void setCapacity(String Capacity) {
        this.Capacity = Capacity;
    }

    public Float getUnitPrice() {
        return UnitPrice;
    }

    public void setUnitPrice(Float UnitPrice) {
        this.UnitPrice = UnitPrice;
    }

    public Byte getDiscontinued() {
        return Discontinued;
    }

    public void setDiscontinued(Byte Discontinued) {
        this.Discontinued = Discontinued;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Inventory getStock() {
        return Stock;
    }

    public void setStock(Inventory Stock) {
        this.Stock = Stock;
    }

    public SmallPic getSmallP() {
        return SmallP;
    }

    public void setSmallP(SmallPic SmallP) {
        this.SmallP = SmallP;
    }

    public BigPic[] getBigP() {
        return BigP;
    }

    public void setBigP(BigPic[] BigP) {
        this.BigP = BigP;
    }

 
    
    @Override
    public String toString() {
        return "Product{" + "ProductID=" + ProductID + ", Barcode=" + Barcode + ", CategoryID=" + CategoryID + ", ProductName=" + ProductName + ", ProductUnit=" + ProductUnit + ", Capacity=" + Capacity + ", UnitPrice=" + UnitPrice + ", Discontinued=" + Discontinued + ", Description=" + Description + ", Stock=" + Stock + ", BigP=" + BigP + ", SmallP=" + SmallP + '}';
    }

    


	
}
