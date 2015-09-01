package shopping.DAO;

import java.util.ArrayList;

import shopping.Class.Membership;

public interface MembershipDAO {
	public int add(Membership m);
	public void update(Membership m);
	public void delete(Membership m);
	public Membership searchbyID(int CustomerID);
	public Membership searchbyAccount(String Account);
	public ArrayList<Membership> showAll();
        public ArrayList<Membership> getRange(int offset, int count);
        public int getSize();
}

