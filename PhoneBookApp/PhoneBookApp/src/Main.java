
public class Main {

	public static void main(String[] args) {
		Address exampleAddress = new Address(" 181 Carmel Woods Dr", "Ellisville", "MO", "63021");
		Entry entry1 = new Entry("Kenneth Haines", "Kenneth", "Haines", exampleAddress, "6363468443");
		Entry entry2 = new Entry("Leah White", "Leah", "White", exampleAddress, "6183033524");
		Repository.addToArray(entry1);
		Repository.addToArray(entry2);

		Menu.mainMenu();	
	}

}
