
package shopping.Class;

public class DeliveryDetail {
    private Integer ID;             //1
    private Integer OrderID;        //2
    private String AddresseeName;   //3
    private String Phone;           //4
    private String CelPhone;        //5
    private String Address;         //6
    private String Time;            //7
    private String DeliveryMethod;  //8
    private Integer Fee;            //9

    public DeliveryDetail(){
        
    };
    
    public DeliveryDetail(Integer ID, Integer OrderID, String AddresseeName, String Phone, String CelPhone, String Address, String Time, String DeliveryMethod, Integer Fee) {
        this.ID = ID;
        this.OrderID = OrderID;
        this.AddresseeName = AddresseeName;
        this.Phone = Phone;
        this.CelPhone = CelPhone;
        this.Address = Address;
        this.Time = Time;
        this.DeliveryMethod = DeliveryMethod;
        this.Fee = Fee;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public Integer getOrderID() {
        return OrderID;
    }

    public void setOrderID(Integer OrderID) {
        this.OrderID = OrderID;
    }

    public String getAddresseeName() {
        return AddresseeName;
    }

    public void setAddresseeName(String AddresseeName) {
        this.AddresseeName = AddresseeName;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCelPhone() {
        return CelPhone;
    }

    public void setCelPhone(String CelPhone) {
        this.CelPhone = CelPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String Time) {
        this.Time = Time;
    }

    public String getDeliveryMethod() {
        return DeliveryMethod;
    }

    public void setDeliveryMethod(String DeliveryMethod) {
        this.DeliveryMethod = DeliveryMethod;
    }

    public Integer getFee() {
        return Fee;
    }

    public void setFee(Integer Fee) {
        this.Fee = Fee;
    }

    @Override
    public String toString() {
        return "DeliveryDetail{" + "ID=" + ID + ", OrderID=" + OrderID + ", AddresseeName=" + AddresseeName + ", Phone=" + Phone + ", CelPhone=" + CelPhone + ", Address=" + Address + ", Time=" + Time + ", DeliveryMethod=" + DeliveryMethod + ", Fee=" + Fee + '}';
    }
    
    
    
}
