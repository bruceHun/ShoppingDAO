package shopping.Class;

public class SmallPic {
	private Integer SmallPicID;
	private String SmallPicName;
	private Integer ProductID;
        private Integer GiftSetID;
	
	public SmallPic(){
		
	}

	public SmallPic(Integer smallPicID, String smallPicName, Integer productID, Integer GiftSetID) {
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

        public Integer getGiftSetID() {
            return GiftSetID;
        }

        public void setGiftSetID(Integer GiftSetID) {
            this.GiftSetID = GiftSetID;
        }

        @Override
        public String toString() {
            return "SmallPic{" + "SmallPicID=" + SmallPicID + ", SmallPicName=" + SmallPicName + ", ProductID=" + ProductID + ", GiftSetID=" + GiftSetID + '}';
        }

        
        
	
	
	
}
