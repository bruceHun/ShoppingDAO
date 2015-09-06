package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.OrderDetail;

public interface OrderDetailDAO {
	public int add(OrderDetail od);
	public void update(OrderDetail od);
	public void delete(OrderDetail od);
	public OrderDetail searchbyID(int ID);
	public ArrayList<OrderDetail> showAll();
        public ArrayList<OrderDetail> getRange(int offset, int count);
	public int getSize();
        public ArrayList<OrderDetail> findByOrderID(int OrderID);
}
