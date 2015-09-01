package shopping.DAO;
import java.util.ArrayList;
import shopping.Class.Cart;

public interface CartDAO {
        public int add(Cart c);
	public void update(Cart c);
	public void delete(Cart c);
	public Cart searchbySession(String Session);
	public ArrayList<Cart> showAll();
        public ArrayList<Cart> getRange(int offset, int count);
        public int getSize();
        
}
