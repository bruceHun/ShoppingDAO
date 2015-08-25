package shopping.Class;

public class BigPic {
	private Integer BigPicID;
	private String BigPicName;
	private Integer ProductID;
	
	public BigPic(){
		
	}

	public BigPic(Integer bigPicID, String bigPicName, Integer productID) {
		super();
		BigPicID = bigPicID;
		BigPicName = bigPicName;
		ProductID = productID;
	}

	public int getBigPicID() {
		return BigPicID;
	}

	public void setBigPicID(Integer bigPicID) {
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

	public void setProductID(Integer productID) {
		ProductID = productID;
	}

	@Override
	public String toString() {
		return "BigPic [BigPicID=" + BigPicID + ", BigPicName=" + BigPicName + ", ProductID=" + ProductID + "]";
	}
	
	
}
