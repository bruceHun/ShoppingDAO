package shopping.Class;

public class OrderDetail {
	private Integer ID;
	private Integer OrderID;
	private Integer ProductID;
	private Integer GiftSetID;
	private Float SalesPrice;
	private Integer Quantity;
	
	public OrderDetail(){
		
	}


	public OrderDetail(Integer iD, Integer orderID, Integer productID, Integer giftSetID, Float salesPrice,
			Integer quantity) {
		super();
		ID = iD;
		OrderID = orderID;
		ProductID = productID;
		GiftSetID = giftSetID;
		SalesPrice = salesPrice;
		Quantity = quantity;
	}


	public Integer getID() {
		return ID;
	}


	public void setID(Integer iD) {
		ID = iD;
	}


	public Integer getOrderID() {
		return OrderID;
	}


	public void setOrderID(Integer orderID) {
		OrderID = orderID;
	}


	public Integer getProductID() {
		return ProductID;
	}


	public void setProductID(Integer productID) {
		ProductID = productID;
	}


	public Integer getGiftSetID() {
		return GiftSetID;
	}


	public void setGiftSetID(Integer giftSetID) {
		GiftSetID = giftSetID;
	}


	public Float getSalesPrice() {
		return SalesPrice;
	}


	public void setSalesPrice(Float salesPrice) {
		SalesPrice = salesPrice;
	}


	public Integer getQuantity() {
		return Quantity;
	}


	public void setQuantity(Integer quantity) {
		Quantity = quantity;
	}


	@Override
	public String toString(){
		return "\nID"+ID
				+"\nOrderID: " +OrderID
				+"\nProdcutID: "+ProductID
				+"\nGiftSetID: "+GiftSetID
				+"\nSalesPrice: "+SalesPrice
				+"\nQuantity: "+Quantity;
	}
	
}
