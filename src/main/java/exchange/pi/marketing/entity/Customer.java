package exchange.pi.marketing.entity;

public class Customer {

	private String title;
	private String firstName; 
	private String lastName;
	private String email;
	
	public Customer() {
		
	}
	
	public Customer(String title, String firstName, String lastName, String email) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
