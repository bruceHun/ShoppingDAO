package shopping.Class;

public class BigPic {
	private int BigPicID;
	private String BigPicName;
	private int ProductID;
	
	public BigPic(){
		
	}

	public BigPic(int bigPicID, String bigPicName, int productID) {
		super();
		BigPicID = bigPicID;
		BigPicName = bigPicName;
		ProductID = productID;
	}

	public int getBigPicID() {
		return BigPicID;
	}

	public void setBigPicID(int bigPicID) {
		BigPicID = bigPicID;
	}

	public String getBigPicName() {
		return BigPicName;
	}

	public void setBigPicName(String bigPicName) {
		BigPicName = bigPicName;
	}

	public int getProductID() {
		return ProductID;
	}

	public void setProductID(int productID) {
		ProductID = productID;
	}

	@Override
	public String toString() {
		return "BigPic [BigPicID=" + BigPicID + ", BigPicName=" + BigPicName + ", ProductID=" + ProductID + "]";
	}
	
	
}
