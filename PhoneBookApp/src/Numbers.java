
public class Numbers {
	private String mainNumber;
	private String homeNumber;
	private String officeNumber;
	private String faxNumber;
	
	public Numbers(String phoneNumber) {
		this.mainNumber = phoneNumber;
	}

	public String getMainNumber() {
		return mainNumber;
	}

	public void setMainNumber(String mainNumber) {
		this.mainNumber = mainNumber;
	}

	public String getHomeNumber() {
		return homeNumber;
	}

	public void setHomeNumber(String homeNumber) {
		this.homeNumber = homeNumber;
		this.homeNumber = "(" + this.homeNumber.substring(0, 3) + ")-" + this.homeNumber.substring(3, 6) + "-" + this.homeNumber.substring(6);

	}

	public String getOfficeNumber() {
		return officeNumber;
	}

	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
		this.officeNumber = "(" + this.officeNumber.substring(0, 3) + ")-" + this.officeNumber.substring(3, 6) + "-" + this.officeNumber.substring(6);

	}

	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
		this.faxNumber = "(" + this.faxNumber.substring(0, 3) + ")-" + this.faxNumber.substring(3, 6) + "-" + this.faxNumber.substring(6);

	}
	
	public String toString() {
		return "Home Phone Number: " + homeNumber + "\nOffice Number: " + officeNumber + "\nFax Number: " + faxNumber;
	}

}
