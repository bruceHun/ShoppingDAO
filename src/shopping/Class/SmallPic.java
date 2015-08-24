package shopping.Class;

public class SmallPic {
	private int SmallPicID;
	private String SmallPicName;
	private int ProductID;
	
	public SmallPic(){
		
	}

	public SmallPic(int smallPicID, String smallPicName, int productID) {
		super();
		SmallPicID = smallPicID;
		SmallPicName = smallPicName;
		ProductID = productID;
	}

	public int getSmallPicID() {
		return SmallPicID;
	}

	public void setSmallPicID(int smallPicID) {
		SmallPicID = smallPicID;
	}

	public String getSmallPicName() {
		return SmallPicName;
	}

	public void setSmallPicName(String smallPicName) {
		SmallPicName = smallPicName;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	@Override
	public String toString() {
		return "SmallPic [SmallPicID=" + SmallPicID + ", SmallPicName=" + SmallPicName + ", ProductID=" + ProductID
				+ "]";
	}
	
	
}
