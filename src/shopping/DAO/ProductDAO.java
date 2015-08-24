package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Product;

public interface ProductDAO {
	public int add(Product p);
	public void update(Product p);
	public void delete(Product p);
	public Product searchbyID(int ProductID);
	public ArrayList<Product> showAll();
}
