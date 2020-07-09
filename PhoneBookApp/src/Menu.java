import java.util.Scanner;

public final class Menu {
	static Scanner scanner = new Scanner(System.in);;

	private Menu() {
	}

	static public void mainMenu() {
		boolean end = false;

		do {
			System.out.println("Welcome To Your PhoneBook");
			System.out.println("What would you like to do?");
			System.out.println("Enter 1:) Display Entries");
			System.out.println("Enter 2:) Add Entry");
			System.out.println("Enter 3:) Search Entries");
			System.out.println("Enter 4:) Delete Entry");
			System.out.println("Enter 5:) Update Entry");
			System.out.println("Enter 6:) Exit");

			String userChoice = scanner.nextLine();
			switch (userChoice.charAt(0)) {
			case '1':
				Repository.printEntries();
				break;
			case '2':
				addMenu();
				break;
			case '3':
				break;
			case '4':
				removeMenu();
				break;
			case '5':
				updateMenu();
				break;
			case '6':
				end = true;
				break;
			default:
				System.out.println("Invalid Input, Try Again");
				System.out.println();
				mainMenu();
			}
		} while (end == false);

	}

	private static void updateMenu() {
		System.out.println("Please Enter the Number Of The Record You Wish To Update");
		String userChoice = scanner.nextLine();
		
		System.out.println("Enter 1:) Update Full Name");
		System.out.println("Enter 2:) Update First Name");
		System.out.println("Enter 3:) Update Last Name");
		System.out.println("Enter 4:) Update Telephone Number");
		System.out.println("Enter 5:) Update Address");
		String userChoice2 = scanner.nextLine();
		
		



		
		
	}

	private static void removeMenu() {
		System.out.println("Please enter the number you wish to delete. ");
		String numberToDelete = scanner.nextLine();
		Repository.deleteByPhone(numberToDelete);

	}

	private static void addMenu() {
		System.out.println("Adding New Entry");
		System.out.println();
		System.out.println("Please Enter Information Of New Entry:");
		String newEntry = scanner.nextLine();
		System.out.println();
		addNewEntry(newEntry);
		System.out.println("Entry Added");
		System.out.println();

	}

	private static void addNewEntry(String newEntry) {
		String[] newEntrySplit = newEntry.split(",");
		String fullName = newEntrySplit[0];
		String[] fullNameArray = fullName.split(" ");
		String firstName = fullNameArray[0];
		String lastName = fullNameArray[fullNameArray.length - 1];
		String street = newEntrySplit[1];
		String city = newEntrySplit[2];
		String state = newEntrySplit[3];
		String zipCode = newEntrySplit[4];
		String number = newEntrySplit[5].strip();

		Address addressObject = new Address(street, city, state, zipCode);
		Entry createdEntry = new Entry(fullName, firstName, lastName, addressObject, number);

		Repository.addToArray(createdEntry);
	}
}
