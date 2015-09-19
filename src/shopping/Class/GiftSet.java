package shopping.Class;

public class GiftSet {
	private Integer GiftSetID;  //1
	private String GiftSetName; //2
	private Integer ID1;        //3
	private Integer ID2;        //4
	private Integer ID3;        //5
	private Integer ID4;        //6
	private Integer ID5;        //7
	private Float UnitPrice;    //8
	private Byte Discontinued;  //9
        private SmallPic SmallP;
        private BigPic[] BigP;
	
	public GiftSet(){
		
	}

	

	public GiftSet(Integer giftSetID, String giftSetName, Integer iD1, Integer iD2, Integer iD3, Integer iD4,
			Integer iD5, Float unitPrice, Byte discontinued) {
		super();
		GiftSetID = giftSetID;
		GiftSetName = giftSetName;
		ID1 = iD1;
		ID2 = iD2;
		ID3 = iD3;
		ID4 = iD4;
		ID5 = iD5;
		UnitPrice = unitPrice;
		Discontinued = discontinued;
                SmallP = new SmallPic();
                BigP = new BigPic[6];
	}



	public Integer getGiftSetID() {
		return GiftSetID;
	}



	public void setGiftSetID(Integer giftSetID) {
		GiftSetID = giftSetID;
	}



	public String getGiftSetName() {
		return GiftSetName;
	}



	public void setGiftSetName(String giftSetName) {
		GiftSetName = giftSetName;
	}



	public Integer getID1() {
		return ID1;
	}



	public void setID1(Integer iD1) {
		ID1 = iD1;
	}



	public Integer getID2() {
		return ID2;
	}



	public void setID2(Integer iD2) {
		ID2 = iD2;
	}



	public Integer getID3() {
		return ID3;
	}



	public void setID3(Integer iD3) {
		ID3 = iD3;
	}



	public Integer getID4() {
		return ID4;
	}



	public void setID4(Integer iD4) {
		ID4 = iD4;
	}



	public Integer getID5() {
		return ID5;
	}



	public void setID5(Integer iD5) {
		ID5 = iD5;
	}



	public Float getUnitPrice() {
		return UnitPrice;
	}



	public void setUnitPrice(Float unitPrice) {
		UnitPrice = unitPrice;
	}



	public Byte getDiscontinued() {
		return Discontinued;
	}



	public void setDiscontinued(Byte discontinued) {
		Discontinued = discontinued;
	}

        public SmallPic getSmallP() {
            return SmallP;
        }

        public void setSmallP(SmallPic SmallP) {
            this.SmallP = SmallP;
        }

        public BigPic[] getBigP() {
            return BigP;
        }

        public void setBigP(BigPic[] BigP) {
            this.BigP = BigP;
        }

    @Override
    public String toString() {
        return "GiftSet{" + "GiftSetID=" + GiftSetID + ", GiftSetName=" + GiftSetName + ", ID1=" + ID1 + ", ID2=" + ID2 + ", ID3=" + ID3 + ", ID4=" + ID4 + ", ID5=" + ID5 + ", UnitPrice=" + UnitPrice + ", Discontinued=" + Discontinued + ", SmallP=" + SmallP + ", BigP=" + BigP + '}';
    }

        
        

	
	
}
