package shopping.Class;

public class Membership {
	private Integer CustomerID;
	private String Account;
	private String Password;
	private Byte Membership;
	
	public Membership(){
		
	}

	public Membership(Integer customerID, String account, String password, Byte membership) {
		super();
		CustomerID = customerID;
		Account = account;
		Password = password;
		Membership = membership;
	}

	public int getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(Integer customerID) {
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

	public void setMembership(Byte membership) {
		Membership = membership;
	}

	@Override
	public String toString() {
		return "Membership [CustomerID=" + CustomerID + ", Account=" + Account + ", Password=" + Password
				+ ", Membership=" + Membership + "]";
	}
	
	
}
