
public class Events {
	private BirthDate birthdate;
	private Anniversary anniversaryDate;
	private boolean birthFlag;
	private boolean annFlag;
	
	
	public Events() {}
	
	public BirthDate getBirthDate() {
		return this.birthdate;
	}
	
	public void setBirthday(BirthDate birthdate) {
		this.birthdate = birthdate;
		this.birthFlag = true;
	}

	public boolean hasBirthday() {
		return this.birthFlag;
	}

	public Anniversary getAnniversary() {
		return this.anniversaryDate;
	}
	
	public void setAnniversary(Anniversary anniversary) {
		this.anniversaryDate = anniversary;
		this.annFlag = true;
	}

	public boolean hasAnniversary() {
		return this.annFlag;
	}
	
	
	
	
}
