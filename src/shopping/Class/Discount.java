package shopping.Class;

public class Discount {
	private Integer DiscountID;
	private Float Discount;
	
	public Discount(){
		
	}

	public Discount(Integer discountID, Float discount) {
		super();
		DiscountID = discountID;
		Discount = discount;
	}

	public int getDiscountID() {
		return DiscountID;
	}

	public void setDiscountID(Integer discountID) {
		DiscountID = discountID;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(Float discount) {
		Discount = discount;
	}

	@Override
	public String toString() {
		return "Discount [DiscountID=" + DiscountID + ", Discount=" + Discount + "]";
	}
	
	
}
