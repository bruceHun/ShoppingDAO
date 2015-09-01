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
        private Membership Member;
	
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
                Member = new Membership();
	}

    public Integer getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(Integer CustomerID) {
        this.CustomerID = CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public String getPersonalID() {
        return PersonalID;
    }

    public void setPersonalID(String PersonalID) {
        this.PersonalID = PersonalID;
    }

    public Byte getGender() {
        return Gender;
    }

    public void setGender(Byte Gender) {
        this.Gender = Gender;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getCelPhone() {
        return CelPhone;
    }

    public void setCelPhone(String CelPhone) {
        this.CelPhone = CelPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getCustomerType() {
        return CustomerType;
    }

    public void setCustomerType(String CustomerType) {
        this.CustomerType = CustomerType;
    }

    public Integer getDiscountID() {
        return DiscountID;
    }

    public void setDiscountID(Integer DiscountID) {
        this.DiscountID = DiscountID;
    }

    public Membership getMember() {
        return Member;
    }

    public void setMember(Membership Member) {
        this.Member = Member;
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
