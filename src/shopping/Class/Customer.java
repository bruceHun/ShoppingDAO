package shopping.Class;



public class Customer {
	private Integer CustomerID;
	private String CustomerName;
	private String PersonalID;
	private Byte Gender;
	private String BirthDate;
	private String Phone;
	private String CelPhone;
	private String Address;
	private String Email;
	private String CustomerType;
	private Integer DiscountID;
	
	public Customer() {
		super();
	}

	
	public Customer(Integer customerID, String customerName, String personalID, Byte gender, String birthDate,
			String phone, String celPhone, String address, String email, String customerType, Integer discountID) {
		super();
		CustomerID = customerID;
		CustomerName = customerName;
		PersonalID = personalID;
		Gender = gender;
		BirthDate = birthDate;
		Phone = phone;
		CelPhone = celPhone;
		Address = address;
		Email = email;
		CustomerType = customerType;
		DiscountID = discountID;
	}

	public Integer getCustomerID() {
		return CustomerID;
	}


	public void setCustomerID(Integer customerID) {
		CustomerID = customerID;
	}


	public String getCustomerName() {
		return CustomerName;
	}


	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}


	public String getPersonalID() {
		return PersonalID;
	}


	public void setPersonalID(String personalID) {
		PersonalID = personalID;
	}


	public Byte getGender() {
		return Gender;
	}


	public void setGender(Byte gender) {
		Gender = gender;
	}


	public String getBirthDate() {
		return BirthDate;
	}


	public void setBirthDate(String birthDate) {
		BirthDate = birthDate;
	}


	public String getPhone() {
		return Phone;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public String getCelPhone() {
		return CelPhone;
	}


	public void setCelPhone(String celPhone) {
		CelPhone = celPhone;
	}


	public String getAddress() {
		return Address;
	}


	public void setAddress(String address) {
		Address = address;
	}


	public String getEmail() {
		return Email;
	}


	public void setEmail(String email) {
		Email = email;
	}


	public String getCustomerType() {
		return CustomerType;
	}


	public void setCustomerType(String customerType) {
		CustomerType = customerType;
	}


	public Integer getDiscountID() {
		return DiscountID;
	}


	public void setDiscountID(Integer discountID) {
		DiscountID = discountID;
	}


	@Override
	public String toString(){
		return "CustomerID: "+CustomerID
				+"\nCutomerName: "+CustomerName
				+"\nPersonalID: "+PersonalID
				+"\nGender: "+Gender
				+"\nBirthDate: "+BirthDate 
				+"\nPhone: "+Phone 
				+"\nCelPhone: "+CelPhone 
				+"\nAddress: "+Address 
				+"\nEmail: "+Email 
				+"\nCustomerType: "+CustomerType 
				+"\nDiscountID:"+DiscountID; 
		
	}
	
	
}
