package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Inventory;

public interface InventoryDAO {
	public int add(Inventory i);
	public void update(Inventory i);
	public void delete(Inventory i);
	public Inventory searchbyID(int StockNumber);
	public ArrayList<Inventory> showAll();
        public ArrayList<Inventory> getRange(int offset, int count);
        public int getSize();
}
