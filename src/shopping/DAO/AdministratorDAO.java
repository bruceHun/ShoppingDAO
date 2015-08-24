package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Administrator;

public interface AdministratorDAO {
	public String add(Administrator a);
	public void update(Administrator a);
	public void delete(Administrator a);
	public Administrator searchbyID(String Account);
	public ArrayList<Administrator> showAll();
}
