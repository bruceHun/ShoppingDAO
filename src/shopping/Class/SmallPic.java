package shopping.Class;

public class SmallPic {
	private Integer SmallPicID;
	private String SmallPicName;
	private Integer ProductID;
	
	public SmallPic(){
		
	}

	public SmallPic(Integer smallPicID, String smallPicName, Integer productID) {
		super();
		SmallPicID = smallPicID;
		SmallPicName = smallPicName;
		ProductID = productID;
	}

	public int getSmallPicID() {
		return SmallPicID;
	}

	public void setSmallPicID(Integer smallPicID) {
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

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	@Override
	public String toString() {
		return "SmallPic [SmallPicID=" + SmallPicID + ", SmallPicName=" + SmallPicName + ", ProductID=" + ProductID
				+ "]";
	}
	
	
}
