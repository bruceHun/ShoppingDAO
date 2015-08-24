package shopping.Class;

public class GiftSet {
	private int GiftSetID;
	private String GiftSetName;
	private int ID1;
	private int ID2;
	private int ID3;
	private int ID4;
	private int ID5;
	private float UnitPrice;
	private byte Discontinued;
	
	public GiftSet(){
		
	}

	public GiftSet(int giftSetID, String giftSetName, int iD1, int iD2, int iD3, int iD4, int iD5, float unitPrice,
			byte discontinued) {
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
	}

	public int getGiftSetID() {
		return GiftSetID;
	}

	public void setGiftSetID(int giftSetID) {
		GiftSetID = giftSetID;
	}

	public String getGiftSetName() {
		return GiftSetName;
	}

	public void setGiftSetName(String giftSetName) {
		GiftSetName = giftSetName;
	}

	public int getID1() {
		return ID1;
	}

	public void setID1(int iD1) {
		ID1 = iD1;
	}

	public int getID2() {
		return ID2;
	}

	public void setID2(int iD2) {
		ID2 = iD2;
	}

	public int getID3() {
		return ID3;
	}

	public void setID3(int iD3) {
		ID3 = iD3;
	}

	public int getID4() {
		return ID4;
	}

	public void setID4(int iD4) {
		ID4 = iD4;
	}

	public int getID5() {
		return ID5;
	}

	public void setID5(int iD5) {
		ID5 = iD5;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}

	public byte getDiscontinued() {
		return Discontinued;
	}

	public void setDiscontinued(byte discontinued) {
		Discontinued = discontinued;
	}

	@Override
	public String toString() {
		return "GiftSet [GiftSetID=" + GiftSetID + ", GiftSetName=" + GiftSetName + ", ID1=" + ID1 + ", ID2=" + ID2
				+ ", ID3=" + ID3 + ", ID4=" + ID4 + ", ID5=" + ID5 + ", UnitPrice=" + UnitPrice + ", Discontinued="
				+ Discontinued + "]";
	}
	
	
}
