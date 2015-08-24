package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.ProductCategory;

public interface ProductCategoryDAO {
	public int add(ProductCategory pc);
	public void update(ProductCategory pc);
	public void delete(ProductCategory pc);
	public ProductCategory searchbyID(int CategoryID);
	public ArrayList<ProductCategory> showAll();
}

