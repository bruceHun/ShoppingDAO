package shopping.Class;

public class Inventory {
	private Integer StockNumber;
	private Integer ProductID;
	private Float Cost;
	private Integer UnitsInStock;
	private Integer UnitsOnOrder;
	private Integer SaftyStock;
	
	public Inventory(){
		
	}
	
	public Inventory(Integer stockNumber, Integer productID, Float cost, Integer unitsInStock, Integer unitsOnOrder,
			Integer saftyStock) {
		super();
		StockNumber = stockNumber;
		ProductID = productID;
		Cost = cost;
		UnitsInStock = unitsInStock;
		UnitsOnOrder = unitsOnOrder;
		SaftyStock = saftyStock;
	}

	public Integer getStockNumber() {
		return StockNumber;
	}

	public void setStockNumber(Integer stockNumber) {
		StockNumber = stockNumber;
	}

	public Integer getProductID() {
		return ProductID;
	}

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	public Float getCost() {
		return Cost;
	}

	public void setCost(Float cost) {
		Cost = cost;
	}

	public Integer getUnitsInStock() {
		return UnitsInStock;
	}

	public void setUnitsInStock(Integer unitsInStock) {
		UnitsInStock = unitsInStock;
	}

	public Integer getUnitsOnOrder() {
		return UnitsOnOrder;
	}

	public void setUnitsOnOrder(Integer unitsOnOrder) {
		UnitsOnOrder = unitsOnOrder;
	}

	public Integer getSaftyStock() {
		return SaftyStock;
	}

	public void setSaftyStock(Integer saftyStock) {
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
