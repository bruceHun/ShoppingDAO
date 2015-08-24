package shopping.Class;

public class Membership {
	private int CustomerID;
	private String Account;
	private String Password;
	private byte Membership;
	
	public Membership(){
		
	}

	public Membership(int customerID, String account, String password, byte membership) {
		super();
		CustomerID = customerID;
		Account = account;
		Password = password;
		Membership = membership;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}

	public String getAccount() {
		return Account;
	}

	public void setAccount(String account) {
		Account = account;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public byte getMembership() {
		return Membership;
	}

	public void setMembership(byte membership) {
		Membership = membership;
	}

	@Override
	public String toString() {
		return "Membership [CustomerID=" + CustomerID + ", Account=" + Account + ", Password=" + Password
				+ ", Membership=" + Membership + "]";
	}
	
	
}
