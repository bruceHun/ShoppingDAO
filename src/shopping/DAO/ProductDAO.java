package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Product;

public interface ProductDAO {
	public int add(Product p);
	public void update(Product p);
	public void delete(Product p);
	public Product searchbyID(Integer ProductID);
	public ArrayList<Product> showAll();
	public ArrayList<Product> gerRange(int offset, int count);
	public int getSize();
        public ArrayList<Product> findByName(String ProductName);
}
