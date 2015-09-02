
package shopping.DAO;

import java.util.ArrayList;
import shopping.Class.DeliveryDetail;

public interface DeliveryDetailDAO {

	public int add(DeliveryDetail dd);
	public void update(DeliveryDetail dd);
	public void delete(DeliveryDetail dd);
	public DeliveryDetail searchbyID(Integer ID);
	public ArrayList<DeliveryDetail> showAll();
	public ArrayList<DeliveryDetail> getRange(int offset, int count);
	public int getSize();
        public ArrayList<DeliveryDetail> searchbyOrderID(Integer OrderID);
}


