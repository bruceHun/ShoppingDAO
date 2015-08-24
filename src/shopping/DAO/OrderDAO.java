package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Order;

public interface OrderDAO {
	public int add(Order o);
	public void update(Order o);
	public void delete(Order o);
	public Order searchbyID(int OrderID);
	public ArrayList<Order> showAll();
}
