
public class BirthDate {
	private String birthDay;
	private String birthMonth;
	private String birthYear;
	
	public BirthDate(String birthDay, String birthMonth, String birthYear) {
		this.birthDay = birthDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
	}
	
	public String birtDay() {
		return this.birthDay;
	}
	
	public String getMonth() {
		return this.birthMonth;
	}

	public String birthYear() {
		return this.birthYear;
	}
	
	public String toString() {
		return birthDay + "/" + birthMonth + "/" + birthYear;
	}

}
