import java.util.Arrays;

public abstract class Repository {
	private static Entry[] entriesArray = new Entry[0];


	public static void addToArray(Entry entry) {
		entriesArray = updateArray(entry, entriesArray);

	}

	public static void removeFromArray(Entry entry) {
		entriesArray = decreaseArray(entry, entriesArray);

	}

	public static void deleteByPhone(String number) {
		Entry foundEntry = null;
		for (Entry entry : entriesArray) {
			if (entry.getUniqueID().equals(number)) {
				foundEntry = entry;
			}
		}
		removeFromArray(foundEntry);
	}

	public static void searchFor(int searchKey, String stringToSearch) {
		Entry[] returnEntries = new Entry[0];
	
		switch (searchKey) {
		case 1:
			for (Entry entry : entriesArray) {
				if (entry.getFullName().equals(stringToSearch)) {
					returnEntries = updateArray(entry, returnEntries);
				}
			}
			printReturnEntries(returnEntries);
			break;
	
		case 2:
			for (Entry entry : entriesArray) {
				if (entry.getFirstName().equals(stringToSearch)) {
					returnEntries = updateArray(entry, returnEntries);
				}
	
			}
			printReturnEntries(returnEntries);
			break;
	
		case 3:
			for (Entry entry : entriesArray) {
				if (entry.getLastName().equals(stringToSearch)) {
					returnEntries = updateArray(entry, returnEntries);
				}
	
			}
			printReturnEntries(returnEntries);
			break;
		case 4:
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(stringToSearch)) {
					returnEntries = updateArray(entry, returnEntries);
				}
	
			}
			printReturnEntries(returnEntries);
			break;
	
		case 5:
			if (stringToSearch.length() < 3) {
				for (Entry entry : entriesArray) {
					if (entry.getAddress().getState().equals(stringToSearch)) {
						returnEntries = updateArray(entry, returnEntries);
					}
				}
				printReturnEntries(returnEntries);
				break;
			} else {
				for (Entry entry : entriesArray) {
					if (stringToSearch.equals(entry.getAddress().getCity())) {
						returnEntries = updateArray(entry, returnEntries);
					}
				}
				printReturnEntries(returnEntries);
				break;
			}
		}
	
	}

	public static void updateEntry(String phoneNumber, int selection, String updateString) {
		switch (selection) {
		case 1:
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(phoneNumber)) {
					entry.updateFullName(updateString);
				}
			}
			break;
		case 2:
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(phoneNumber)) {
					entry.updateFirstName(updateString);
				}
			}
			break;
		case 3:
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(phoneNumber)) {
					entry.updateLastName(updateString);
				}
			}
			break;
		case 5:
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(phoneNumber)) {
					updateAddress(updateString, entry);
				}
			}
			break;
		}
	}

	public static void sortArray(Entry[] arrayToSort) {
		Arrays.sort(arrayToSort);
	}

	public static void addBirthday(String phoneNumber, BirthDate birthDay) {
		for (Entry entry : entriesArray) {
			if (entry.getUniqueID().equalsIgnoreCase(phoneNumber)) {
				entry.getEvent().setBirthday(birthDay);
			}
		}

	}

	public static void addAnniversary(String phoneNumber, Anniversary annDay) {
		for (Entry entry : entriesArray) {
			if (entry.getUniqueID().equalsIgnoreCase(phoneNumber)) {
				entry.getEvent().setAnniversary(annDay);
			}

		}
	}

	public static void displayEvents() {
		for (Entry entry : entriesArray) {
			if (entry.getEvent().hasBirthday()) {
				System.out.println(entry + " " + entry.getEvent().getBirthDate().toString() + " Birthday");
				System.out.println();
			}
		}
		for (Entry entry : entriesArray) {
			if (entry.getEvent().hasAnniversary()) {
				System.out.println(entry + " " + entry.getEvent().getAnniversary().toString() + " Anniversary");
				System.out.println();
			}
		}

	}

	public static void updateNumbers(String newNumber, char choice, String uniqueID) {
		switch (choice) {
		case '1':
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(uniqueID)) {
					entry.getNumbers().setMainNumber(newNumber);
					}
				}
			break;
		case '2':
			for(Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(uniqueID)) {
					entry.getNumbers().setHomeNumber(newNumber);
				}
			}
			break;
		case '3':
			for (Entry entry: entriesArray) {
				if (entry.getUniqueID().equals(uniqueID)) {
					entry.getNumbers().setOfficeNumber(newNumber);
				}
			}
			break;
		case '4':
			for (Entry entry : entriesArray) {
				if (entry.getUniqueID().equals(uniqueID)) {
					entry.getNumbers().setFaxNumber(newNumber);
				}
			}
		}
		
	}

	public static void printEntries() {
		sortArray(entriesArray);
		for (Entry entry : entriesArray) {
			System.out.println(entry);
	
		}
	}

	public static void printAllInfoOneEntry(String number) {
		for (Entry entry: entriesArray) {
			if (entry.getUniqueID().equals(number)) {
				System.out.println(entry);
				System.out.println("First Name: " + entry.getFirstName());
				System.out.println("Last Name: " + entry.getLastName());
				System.out.println();
				System.out.println(entry.getNumbers().toString());
				System.out.println();
				System.out.println("Birthday: " + entry.getEvent().getBirthDate().toString());
				System.out.println("Anniversary: " +entry.getEvent().getAnniversary().toString());
				System.out.println();
			}
		}
	}

	private static void printReturnEntries(Entry[] returnEntries) {
		sortArray(returnEntries);
		for (Entry entry : returnEntries) {
			System.out.println(entry);
		}
	}

	private static void updateAddress(String updateString, Entry entry) {
		String[] addressArray = updateString.split(",");
		entry.getAddress().setStreet(addressArray[0]);
		entry.getAddress().setCity(addressArray[1]);
		entry.getAddress().setState(addressArray[2]);
		entry.getAddress().setZip(addressArray[3]);
	
	}

	private static Entry[] decreaseArray(Entry entry, Entry[] oldArray) {
		Entry[] newArray = new Entry[0];
	
		for (Entry currentEntry : oldArray) {
			if (entry.getUniqueID().equals(currentEntry.getUniqueID())) {
				continue;
			} else {
				newArray = updateArray(currentEntry, newArray);
			}
		}
	
		return newArray;
	}

	private static Entry[] updateArray(Entry entry, Entry[] oldArray) {
		Entry[] newArray = new Entry[oldArray.length + 1];
	
		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		newArray[newArray.length - 1] = entry;
		return newArray;
	}

}
