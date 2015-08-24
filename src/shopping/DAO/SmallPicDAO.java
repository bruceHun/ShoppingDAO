package shopping.DAO;

import java.util.ArrayList;
import shopping.Class.SmallPic;

public interface SmallPicDAO {
	
	public int add(SmallPic sp);
	public void update(SmallPic sp);
	public void delete(SmallPic sp);
	public SmallPic searchbyID(int SmallpicID);
	public ArrayList<SmallPic> showAll();
}
