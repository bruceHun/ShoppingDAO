package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.BigPic;

public interface BigPicDAO {
	public int add(BigPic bp);
	public void update(BigPic bp);
	public void delete(BigPic bp);
	public BigPic searchbyID(int BigPicID);
	public ArrayList<BigPic> showAll();
}
