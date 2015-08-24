package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Customer;

public interface CustomerDAO {
	public int add(Customer c);
	public void update(Customer c);
	public void delete(Customer c);
	public Customer searchbyID(int CustomerID);
	public ArrayList<Customer> showAll();
}
