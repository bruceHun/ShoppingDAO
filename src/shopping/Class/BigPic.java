package shopping.Class;

public class BigPic {
	private Integer BigPicID;
	private String BigPicName;
	private Integer ProductID;
        private Integer GiftSetID;
	
	public BigPic(){
		
	}

	public BigPic(Integer bigPicID, String bigPicName, Integer productID, Integer GiftSetID) {
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

        public Integer getGiftSetID() {
            return GiftSetID;
        }

        public void setGiftSetID(Integer GiftSetID) {
            this.GiftSetID = GiftSetID;
        }

        @Override
        public String toString() {
            return "BigPic{" + "BigPicID=" + BigPicID + ", BigPicName=" + BigPicName + ", ProductID=" + ProductID + ", GiftSetID=" + GiftSetID + '}';
        }

        

	
	
	
}
