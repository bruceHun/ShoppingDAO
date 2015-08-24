package shopping.Class;

public class Administrator {
	private String Account;
	private String Password; 
	private String Level;
	
	public Administrator(){
		
	}

	public Administrator(String account, String password, String level) {
		super();
		Account = account;
		Password = password;
		Level = level;
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

	public String getLevel() {
		return Level;
	}

	public void setLevel(String level) {
		Level = level;
	}
	
	public String toString(){
		return "\nAccount: "+Account
				+"\nPassword: "+Password
				+"\nLevel: "+Level;
	}
}
