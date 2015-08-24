package shopping.Class;

public class Inventory {
	private int StockNumber;
	private int ProductID;
	private float Cost;
	private int UnitsInStock;
	private int UnitsOnOrder;
	private int SaftyStock;
	
	public Inventory(){
		
	}

	public Inventory(int stockNumber, int productID, float cost, int unitsInStock, int unitsOnOrder, int saftyStock) {
		super();
		StockNumber = stockNumber;
		ProductID = productID;
		Cost = cost;
		UnitsInStock = unitsInStock;
		UnitsOnOrder = unitsOnOrder;
		SaftyStock = saftyStock;
	}

	public int getStockNumber() {
		return StockNumber;
	}

	public void setStockNumber(int stockNumber) {
		StockNumber = stockNumber;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	public float getCost() {
		return Cost;
	}

	public void setCost(float cost) {
		Cost = cost;
	}

	public int getUnitsInStock() {
		return UnitsInStock;
	}

	public void setUnitsInStock(int unitsInStock) {
		UnitsInStock = unitsInStock;
	}

	public int getUnitsOnOrder() {
		return UnitsOnOrder;
	}

	public void setUnitsOnOrder(int unitsOnOrder) {
		UnitsOnOrder = unitsOnOrder;
	}

	public int getSaftyStock() {
		return SaftyStock;
	}

	public void setSaftyStock(int saftyStock) {
		SaftyStock = saftyStock;
	}
	
	@Override
	public String toString(){
		return "\nStackNumber: "+StockNumber
				+"\nProductID: "+ProductID
				+"\nCost: "+Cost
				+"\nUnitsInStock: "+UnitsInStock
				+"\nUnitsOnOrder: "+UnitsOnOrder
				+"SaftyStock: "+SaftyStock;
	}
}
