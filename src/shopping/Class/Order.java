package shopping.Class;

public class Order {
	private Integer OrderID;
	private Integer CustomerID;
	private String OrderDate;
	private String ShipDate;
	private Integer DiscountID;
	private Byte Canceled;
	
	public Order(){
		
	}

	public Order(Integer orderID, Integer customerID, String orderDate, String shipDate, Integer discountID, Byte canceled) {
		super();
		OrderID = orderID;
		CustomerID = customerID;
		OrderDate = orderDate;
		ShipDate = shipDate;
		DiscountID = discountID;
		Canceled = canceled;
	}

	public int getOrderID() {
		return OrderID;
	}

	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getShipDate() {
		return ShipDate;
	}

	public void setShipDate(String shipDate) {
		ShipDate = shipDate;
	}

	public int getDiscountID() {
		return DiscountID;
	}

	public void setDiscountID(Integer discountID) {
		DiscountID = discountID;
	}

	public byte getCanceled() {
		return Canceled;
	}

	public void setCanceled(Byte canceled) {
		Canceled = canceled;
	}

	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", OrderDate=" + OrderDate + ", ShipDate="
				+ ShipDate + ", DiscountID=" + DiscountID + ", Canceled=" + Canceled + "]";
	}
	
	
}
