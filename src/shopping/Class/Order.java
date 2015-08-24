package shopping.Class;

public class Order {
	private int OrderID;
	private int CustomerID;
	private String OrderDate;
	private String ShipDate;
	private int DiscountID;
	private byte Canceled;
	
	public Order(){
		
	}

	public Order(int orderID, int customerID, String orderDate, String shipDate, int discountID, byte canceled) {
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

	public void setOrderID(int orderID) {
		OrderID = orderID;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
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

	public void setDiscountID(int discountID) {
		DiscountID = discountID;
	}

	public byte getCanceled() {
		return Canceled;
	}

	public void setCanceled(byte canceled) {
		Canceled = canceled;
	}

	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", OrderDate=" + OrderDate + ", ShipDate="
				+ ShipDate + ", DiscountID=" + DiscountID + ", Canceled=" + Canceled + "]";
	}
	
	
}
