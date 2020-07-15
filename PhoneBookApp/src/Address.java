
public class Address {
	private String street;
	private String city;
	private String state;
	private String zipCode;
	
		
	public Address(String street, String city, String state, String zipCode) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}
	
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		state = state.toUpperCase();
		this.state = state;
	}

	public String getZip() {
		return this.zipCode;
	}

	public void setZip(String zip) {
		this.zipCode = zip;
	}

	public String toString() {
		return street + ", " + city + ", " + state + ", " + zipCode;
	}
}
