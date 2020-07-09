
public class Entry  {
	private String fullName;
	private String firstName;
	private String lastName;
	private Address address;
	private String number;
	
	public Entry() {}
	
	public Entry(String fullName, String firstName, String lastName, Address address, String number) {
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.number = number;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getLastName() {
		return this.lastName;
	}
	
	public Address getAddress() {
		return this.address;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public String getFullName() {
		return this.fullName.strip();
	}
	
	

}
