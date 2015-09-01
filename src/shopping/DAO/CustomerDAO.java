package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Customer;

public interface CustomerDAO {
	public int add(Customer c);
	public void update(Customer c);
	public void delete(Customer c);
	public Customer searchbyID(int CustomerID);
        public Customer SearchbyPersonalID(String PersonalID);
	public ArrayList<Customer> showAll();
        public ArrayList<Customer> getRange(int offset, int count);
        public int getSize();
}
