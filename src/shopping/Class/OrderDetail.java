package shopping.Class;

public class OrderDetail {
	private int ID;
	private int OrderID;
	private int ProductID;
	private int GiftSetID;
	private float SalesPrice;
	private int Quantity;
	
	public OrderDetail(){
		
	}

	
	
	public OrderDetail(int iD, int orderID, int productID, int giftSetID, float salesPrice, int quantity) {
		super();
		ID = iD;
		OrderID = orderID;
		ProductID = productID;
		GiftSetID = giftSetID;
		SalesPrice = salesPrice;
		Quantity = quantity;
	}



	public int getID() {
		return ID;
	}



	public void setID(int iD) {
		ID = iD;
	}



	public int getOrderID() {
		return OrderID;
	}



	public void setOrderID(int orderID) {
		OrderID = orderID;
	}



	public int getProductID() {
		return ProductID;
	}



	public void setProductID(int productID) {
		ProductID = productID;
	}



	public int getGiftSetID() {
		return GiftSetID;
	}



	public void setGiftSetID(int giftSetID) {
		GiftSetID = giftSetID;
	}



	public float getSalesPrice() {
		return SalesPrice;
	}



	public void setSalesPrice(float salesPrice) {
		SalesPrice = salesPrice;
	}



	public int getQuantity() {
		return Quantity;
	}



	public void setQuantity(int quantity) {
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
