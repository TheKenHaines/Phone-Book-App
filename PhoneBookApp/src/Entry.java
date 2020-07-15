
public class Entry implements Comparable<Entry> {
	private String fullName;
	private String firstName;
	private String lastName;
	private Address address;
	private String uniqueID;
	private Numbers numbers;
	private Events event;
	
	public Entry(String fullName, String firstName, String lastName, Address address, String number) {
		this.fullName = fullName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.uniqueID = number;
		this.event = new Events();
		this.numbers = new Numbers(number);
	}

	public String getFullName() {
		return this.fullName.strip();
	}

	public void updateFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void updateFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void updateLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return this.address;
	}

	public void updateAddress(Address address) {
		this.address = address;
	}

	public String getUniqueID() {
		return uniqueID;
	}

	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public Numbers getNumbers() {
		return numbers;
	}

	public void setNumbers(Numbers numbers) {
		this.numbers = numbers;
	}
	
	
	public Events getEvent() {
		return this.event;
	}
	
	public void setEvent(Events event) {
		this.event = event;
	}

	@Override
	public String toString() {
		return fullName + "," + address.toString() + ", " + "(" + uniqueID.substring(0, 3) + ")-"
				+ uniqueID.substring(3, 6) + "-" + uniqueID.substring(6) + "\n";
	}

	@Override
	public int compareTo(Entry o) {
		return toString().compareTo(o.toString());
	}

}
