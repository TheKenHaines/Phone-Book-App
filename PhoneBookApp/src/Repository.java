
public class Repository {
	private static Entry[] entriesArray = new Entry[0];

	private Repository() {
	}

	public static void addToArray(Entry entry) {
		entriesArray = updateArray(entry, entriesArray);
		
	}

	private static Entry[] updateArray(Entry entry, Entry[] oldArray) {
		Entry[] newArray = new Entry[oldArray.length + 1];

		for (int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
		newArray[newArray.length - 1] = entry;
		return newArray;
	}
	
	public static void removeFromArray(Entry entry) {
		entriesArray = decreaseArray(entry, entriesArray);
		
	}

	private static Entry[] decreaseArray(Entry entry, Entry[] oldArray) {
		Entry[] newArray = new Entry[0];
		
		for (Entry currentEntry : oldArray) {
			if (entry.getNumber().equals(currentEntry.getNumber())) {
				continue;
			} else {
				newArray =updateArray(currentEntry, newArray);
			}
		}
		
		return newArray;
	}
	
	public static void printEntries() {
		for (Entry entry : entriesArray){
			String num = entry.getNumber().strip();
			String areaCode =("(" + num.substring(0, 3) + ")-");
			String number1 = num.substring(3, 6);
			String number2= num.substring(6);
			System.out.println(entry.getFullName() + "," + entry.getAddress().getAddressString() + ", " + areaCode + number1 + "-" +number2);
			System.out.println();
		}
	}
	
	public static void deleteByPhone(String number) {
		Entry foundEntry = null;
		for (Entry entry : entriesArray) {
			if (entry.getNumber().equals(number)) {
				foundEntry = entry;
			}
		}
		removeFromArray(foundEntry);
	}

}