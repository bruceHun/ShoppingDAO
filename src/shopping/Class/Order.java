package shopping.Class;

import java.util.ArrayList;

public class Order {
	private Integer OrderID;
	private Integer CustomerID;
	private String OrderDate;
	private String ShipDate;
	private Integer DiscountID;
	private Byte Canceled;
        private ArrayList<OrderDetail> Detail;
	
	public Order(){
		
	}



    public Order(Integer OrderID, Integer CustomerID, String OrderDate, String ShipDate, Integer DiscountID, Byte Canceled) {
        this.OrderID = OrderID;
        this.CustomerID = CustomerID;
        this.OrderDate = OrderDate;
        this.ShipDate = ShipDate;
        this.DiscountID = DiscountID;
        this.Canceled = Canceled;
        Detail = new ArrayList<>();
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

        public ArrayList<OrderDetail> getDetail() {
            return Detail;
        }

        public void setDetail(ArrayList<OrderDetail> Detail) {
            this.Detail = Detail;
        }

        
        
	@Override
	public String toString() {
		return "Order [OrderID=" + OrderID + ", CustomerID=" + CustomerID + ", OrderDate=" + OrderDate + ", ShipDate="
				+ ShipDate + ", DiscountID=" + DiscountID + ", Canceled=" + Canceled + "]";
	}
	
	
}
