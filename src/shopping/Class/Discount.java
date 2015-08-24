package shopping.Class;

public class Discount {
	private int DiscountID;
	private float Discount;
	
	public Discount(){
		
	}

	public Discount(int discountID, float discount) {
		super();
		DiscountID = discountID;
		Discount = discount;
	}

	public int getDiscountID() {
		return DiscountID;
	}

	public void setDiscountID(int discountID) {
		DiscountID = discountID;
	}

	public float getDiscount() {
		return Discount;
	}

	public void setDiscount(float discount) {
		Discount = discount;
	}

	@Override
	public String toString() {
		return "Discount [DiscountID=" + DiscountID + ", Discount=" + Discount + "]";
	}
	
	
}
