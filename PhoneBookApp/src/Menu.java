
import java.util.Scanner;

public final class Menu {
	static Scanner scanner = new Scanner(System.in);;

	private Menu() {
	}

	static public void mainMenu() {
		boolean end = false;

		try {
			do {
				System.out.println("Welcome To Your PhoneBook");
				System.out.println("What would you like to do?");
				System.out.println("Enter 1:) Display Entries");
				System.out.println("Enter 2:) Display One Entry (Full Info)");
				System.out.println("Enter 3:) Add Entry");
				System.out.println("Enter 4:) Search Entries");
				System.out.println("Enter 5:) Delete Entry");
				System.out.println("Enter 6:) Update Entry");
				System.out.println("Enter 7: Add Event");
				System.out.println("Enter 8:) Display All Events");
				System.out.println("Enter 9:) Exit");

				String userChoice = scanner.nextLine();
				switch (userChoice.charAt(0)) {
				case '1':
					Repository.printEntries();
					break;
				case '2':
					System.out.println("What Number Would You Like To Display");
					String number = scanner.nextLine();
					Repository.printAllInfoOneEntry(number);
					break;
				case '3':
					addMenu();
					break;
				case '4':
					searchMenu();
					break;
				case '5':
					removeMenu();
					break;
				case '6':
					updateMenu();
					break;
				case '7':
					addEventMenu();
					break;
				case '8':
					displayEvents();
					break;
				case '9':
					end = true;
					break;
				default:
					System.out.println("Invalid Input, Try Again");
					System.out.println();
					mainMenu();
				}
			} while (end == false);
		} catch (Exception e) {
			System.out.println();
			mainMenu();
		}

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

	private static void searchMenu() {
		System.out.println("Search By:");
		System.out.println("1:) Full Name");
		System.out.println("2:) First Name");
		System.out.println("3:) Last Name");
		System.out.println("4:) Telephone Number");
		System.out.println("5:) City Or State");
		String userChoice = scanner.nextLine();
		switch (userChoice.charAt(0)) {
		case '1':
			System.out.println("Enter Full Name To Search");
			String nameToSearch = scanner.nextLine();
			int searchKey = 1;
			Repository.searchFor(searchKey, nameToSearch);
			break;
		case '2':
			System.out.println("Enter First Name To Search");
			String firstNameSearch = scanner.nextLine();
			searchKey = 2;
			Repository.searchFor(2, firstNameSearch);
			break;
		case '3':
			System.out.println("Enter Last Name To Search");
			String lastNameSearch = scanner.nextLine();
			searchKey = 3;
			Repository.searchFor(searchKey, lastNameSearch);
			break;
		case '4':
			System.out.println("Enter Number To Search");
			String numberSearch = scanner.nextLine();
			searchKey = 4;
			Repository.searchFor(searchKey, numberSearch);
			break;
		case '5':
			System.out.println("Enter City Or State To Search");
			String cityOrState = scanner.nextLine();
			searchKey = 5;
			Repository.searchFor(searchKey, cityOrState);
			break;
	
		}
	}

	private static void removeMenu() {
		System.out.println("Please enter the number you wish to delete. ");
		String numberToDelete = scanner.nextLine();
		Repository.deleteByPhone(numberToDelete);
	
	}

	private static void updateMenu() {
		System.out.println("Please Enter the Number Of The Record You Wish To Update");
		String phoneNumber = scanner.nextLine();
	
		System.out.println("Enter 1:) Update Full Name");
		System.out.println("Enter 2:) Update First Name");
		System.out.println("Enter 3:) Update Last Name");
		System.out.println("Enter 4:) Update Numbers");
		System.out.println("Enter 5:) Update Address");
		int selection = scanner.nextInt();
		scanner.nextLine();
		
		switch (selection) {
		case 1:
			System.out.println("Please Enter The New Full Name");
			String newFullName = scanner.nextLine();
			Repository.updateEntry(phoneNumber, selection, newFullName);
			break;
		case 2:
			System.out.println("Please Enter The New First Name");
			String newFirstName = scanner.nextLine();
			Repository.updateEntry(phoneNumber, selection, newFirstName);
			break;
		case 3:
			System.out.println("Please Enter The New Last Name");
			String newLastName = scanner.nextLine();
			Repository.updateEntry(phoneNumber, selection, newLastName);
			break;
		case 4:
			updateNumbersMenu(phoneNumber, selection);
			break;
		case 5:
			System.out.println("Please Enter The New Full Address");
			System.out.println("SAMPLE FORMAT");
			System.out.println("Street, City, State, Zip");
			String address = scanner.next();
			Repository.updateEntry(phoneNumber, selection, address);
			break;
		default:
			System.out.println("Invalid Input");
			System.out.println();
			updateMenu();
		}
	
	}

	private static void updateNumbersMenu(String phoneNumber, int selection) {
		String newNumber;
		
		System.out.println("Enter 1:) Update Main(Cell) Phone Number");
		System.out.println("Enter 2:) Update Home Phone Number");
		System.out.println("Enter 3:) Update Office Phone Number");
		System.out.println("Enter 4:) Update Fax Number");
		String userChoice = scanner.nextLine();
		
		switch (userChoice.charAt(0)) {
		case '1':
			System.out.println("Please Enter New Main(Cell) Phone Number");
			newNumber = scanner.nextLine();
			Repository.updateNumbers(newNumber, userChoice.charAt(0), phoneNumber);
			break;
		case '2':
			System.out.println("Please Enter New Home Phone Number");
			newNumber = scanner.nextLine();
			Repository.updateNumbers(newNumber, userChoice.charAt(0), phoneNumber);
			break;
		case '3':
			System.out.println("Plese Enter New Office Phone Number");
			newNumber = scanner.nextLine();
			Repository.updateNumbers(newNumber, userChoice.charAt(0), phoneNumber);
			break;
		case '4':
			System.out.println("Please Enter New Fax Number");
			newNumber = scanner.nextLine();
			Repository.updateNumbers(newNumber, userChoice.charAt(0), phoneNumber);
			break;
		}
		
	}

	private static void addEventMenu() {
		System.out.println("Please Enter The Phone Number To Add Event To");
		String phoneNumber = scanner.nextLine();
	
		System.out.println("Please Choose");
		System.out.println("1:) Enter New Birthday");
		System.out.println("2:) Enter New Anniversary");
		System.out.println("3:) Return To Main Menu");
		String userChoice = scanner.nextLine();
	
		switch (userChoice.charAt(0)) {
		case '1':
			addNewBirthDay(phoneNumber);
			break;
		case '2':
			addNewAnniversary(phoneNumber);
			break;
		case '3':
			mainMenu();
			break;
		}
	
	}

	private static void addNewBirthDay(String phoneNumber) {
		System.out.println("Please Enter Birth Date In This Format xx/xx/xxxx (e.g. day, month, year, with slashes): ");
		String birthDate = scanner.nextLine();
	
		try {
			String[] array = birthDate.split("/");
			String day = array[0];
			String month = array[1];
			String year = array[2];
			BirthDate birthDay = new BirthDate(day, month, year);
			Repository.addBirthday(phoneNumber, birthDay);
		} catch (Exception e) {
			System.out.println("Invalid Input, Try Again");
			System.out.println();
			addEventMenu();
		}
	
	}

	private static void addNewAnniversary(String phoneNumber) {
		System.out.println(
				"Please Enter Anniversary Date In This Format xx/xx/xxxx (e.g. day, month, year, with slashes):");
		String annDate = scanner.nextLine();
	
		try {
			String[] array = annDate.split("/");
			String day = array[0];
			String month = array[1];
			String year = array[2];
			Anniversary annDay = new Anniversary(day, month, year);
			Repository.addAnniversary(phoneNumber, annDay);
	
		} catch (Exception e) {
			System.out.println("Invalid Input");
			addEventMenu();
		}
	
	}

	private static void displayEvents() {
		Repository.displayEvents();

	}
}
