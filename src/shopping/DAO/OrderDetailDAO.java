package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.OrderDetail;

public interface OrderDetailDAO {
	public int add(OrderDetail od);
	public void update(OrderDetail od);
	public void delete(OrderDetail od);
	public OrderDetail searchbyID(int ID);
	public ArrayList<OrderDetail> showAll();
}
