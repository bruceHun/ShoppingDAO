
package shopping.Class;

public class Cart {
    private Integer ID;             //1
    private String Session;         //2
    private Integer ProductID;      //3
    private String ProductName;     //4
    private Integer ProductUnit;    //5
    private String Capacity;        //6
    private Float UnitPrice;        //7
    private Integer SmallPicID;     //8
    private String GiftSetName;     //9
    private Float GiftSetUnitPrice; //10
    private Integer Quantity;       //11
    private Integer CustomerID;     //12
    private Float Discount;         //13
    
    public Cart(){
        
    };

    public Cart(Integer ID, String Session, Integer ProductID, String ProductName, Integer ProductUnit, String Capacity, Float UnitPrice, Integer SmallPicID, String GiftSetName, Float GiftSetUnitPrice, Integer Quantity, Integer CustomerID, Float Discount) {
        this.ID = ID;
        this.Session = Session;
        this.ProductID = ProductID;
        this.ProductName = ProductName;
        this.ProductUnit = ProductUnit;
        this.Capacity = Capacity;
        this.UnitPrice = UnitPrice;
        this.SmallPicID = SmallPicID;
        this.GiftSetName = GiftSetName;
        this.GiftSetUnitPrice = GiftSetUnitPrice;
        this.Quantity = Quantity;
        this.CustomerID = CustomerID;
        this.Discount = Discount;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getSession() {
        return Session;
    }

    public void setSession(String Session) {
        this.Session = Session;
    }

    public Integer getProductID() {
        return ProductID;
    }

    public void setProductID(Integer ProductID) {
        this.ProductID = ProductID;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public Integer getProductUnit() {
        return ProductUnit;
    }

    public void setProductUnit(Integer ProductUnit) {
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

    public Integer getSmallPicID() {
        return SmallPicID;
    }

    public void setSmallPicID(Integer SmallPicID) {
        this.SmallPicID = SmallPicID;
    }

    public String getGiftSetName() {
        return GiftSetName;
    }

    public void setGiftSetName(String GiftSetName) {
        this.GiftSetName = GiftSetName;
    }

    public Float getGiftSetUnitPrice() {
        return GiftSetUnitPrice;
    }

    public void setGiftSetUnitPrice(Float GiftSetUnitPrice) {
        this.GiftSetUnitPrice = GiftSetUnitPrice;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer Quantity) {
        this.Quantity = Quantity;
    }

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Float getDiscount() {
        return Discount;
    }

    public void setDiscount(Float Discount) {
        this.Discount = Discount;
    }

    @Override
    public String toString() {
        return "Cart{" + "ID=" + ID + ", Session=" + Session + ", ProductID=" + ProductID + ", ProductName=" + ProductName + ", ProductUnit=" + ProductUnit + ", Capacity=" + Capacity + ", UnitPrice=" + UnitPrice + ", SmallPicID=" + SmallPicID + ", GiftSetName=" + GiftSetName + ", GiftSetUnitPrice=" + GiftSetUnitPrice + ", Quantity=" + Quantity + ", CustomerID=" + CustomerID + ", Discount=" + Discount + '}';
    }
    
}


