package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Discount;

public interface DiscountDAO {
	public int add(Discount d);
	public void update(Discount d);
	public void delete(Discount d);
	public Discount searchbyID(int DiscountID);
	public ArrayList<Discount> showAll();
}
