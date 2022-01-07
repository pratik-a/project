package beans;
public class CustomerBean {
	private int account_no;
	private int account_no2;
	
	private String username;
	private String password;
	private double amount;
	private String address;
    private String phone;
    private String email;
	
	
	public int getAccount_no() {
		return account_no ;
	}

	public int getAccount_no2() {
		return account_no2 ;
	}


	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public void setAccount_no2(int account_no2) {
		this.account_no2 = account_no2;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone= phone;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email= email;
	}
	
	
}
