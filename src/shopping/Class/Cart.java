
package shopping.Class;

public class Cart {
    private Integer ID;
    private String Session;
    private Integer ProductID;
    private Integer GiftSetID;
    private Integer Quantity;
    private Integer CustomerID;
    
    public Cart(){
        
    };

    public Cart(Integer ID, String Session, Integer ProductID, Integer GiftSetID, Integer Quantity, Integer CustomerID) {
        this.ID = ID;
        this.Session = Session;
        this.ProductID = ProductID;
        this.GiftSetID = GiftSetID;
        this.Quantity = Quantity;
        this.CustomerID = CustomerID;
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

    public Integer getGiftSetID() {
        return GiftSetID;
    }

    public void setGiftSetID(Integer GiftSetID) {
        this.GiftSetID = GiftSetID;
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

    @Override
    public String toString() {
        return "Cart{" + "ID=" + ID + ", Session=" + Session + ", ProductID=" + ProductID + ", GiftSetID=" + GiftSetID + ", Quantity=" + Quantity + ", CustomerID=" + CustomerID + '}';
    }
    
    
    
    
}


