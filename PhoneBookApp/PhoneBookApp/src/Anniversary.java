
public class Anniversary {
	String annDay;
	String annMonth;
	String annYear;

	public Anniversary(String annDay, String annMonth, String annYear) {
		this.annDay = annDay;
		this.annMonth = annMonth;
		this.annYear = annYear;

	}
	
	public String getAnnDay() {
		return this.annDay;
	}
	
	public String annMonth() {
		return this.annMonth;
	}
	
	public String annYear() {
		return this.annYear;
	}

	public String toString() {
		return annDay + "/" + annMonth + "/" + annYear;
	}
}
