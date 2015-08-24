package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.GiftSet;

public interface GiftSetDAO {
	public int add(GiftSet g);
	public void update(GiftSet g);
	public void delete(GiftSet g);
	public GiftSet searchbyID(int GiftSetID);
	public ArrayList<GiftSet> showAll();
}
