package phonebook;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PhoneBookTests {
	
	private static final String HILBERT = "Hilbert";
	private IPhoneBook book;
	
	@BeforeEach
	void setup() {
		// Initialization
		book = new PhoneBook();
	}
	
	@Test
	void addEntry_addTwoNumbersToSameKey_bothAreStored() {
		// Run method to be tested
		book.addEntry("Hilbert", 1234);
		book.addEntry("Hilbert", 7777);

		// Check result
		int[] numbers = book.lookupName("Hilbert");
		assertElements(numbers, 1234, 7777);
	}

	void assertElements(int[] array, int... elements) {
		Assertions.assertArrayEquals(array, elements);
	}
	
	@Test
	void removeEntry_addTwoNumbersToSameKey_thenRemoveOne() {
		// Run method to be tested
		book.addEntry("Hilbert", 1234);
		book.addEntry("Hilbert", 7777);
		book.removeEntry("Hilbert", 1234);

		// Check result
		int[] numbers = book.lookupName("Hilbert");
		assertElements(numbers, 7777);	
	}
	
	@Test
	@DisplayName("removeEntry_removeAddedEntry_lookupNameIsEmpty")
	void testRemoveAddedElement() {
		// Exercise 1c)

		// Run test
		book.addEntry(HILBERT, 1234);
		book.removeEntry(HILBERT, 1234);

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers);
	}
	
	@Test
	void removeEntry_inEmptyPhoneBook() {
		// Exercise 1c)
		book.removeEntry("Hilbert", 1234);

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers);	
	}
	
	@Test
	@DisplayName("removeEntry_removeNonExistingValue_leavesOthersUnaffected")
	void testAddMultipleEntriesForSameKeyDeleteNotExisting() {
		// Exercise 1d)

		// Run test
		book.addEntry(HILBERT, 1);
		book.addEntry(HILBERT, 2);
		book.addEntry(HILBERT, 3);
		book.addEntry(HILBERT, 4);
		book.removeEntry(HILBERT, 27);

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers, 1, 2, 3, 4);
	}
	
	@Test
	@DisplayName("lookupName_checkJuergen_returnsCorrectValue")
	void testLookUpReturnsCorrectEntry() {
		// Exercise 1d)

		// Run test
		book.addEntry(HILBERT, 1);
		book.addEntry("Juergen", 2);

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers, 1);
	}
	
	@Test
	@DisplayName("addEntry_addValueZero_isNotValid")
	void testZeroCanNotBeAdded() {
		// Exercise 1d)

		// Run test
		book.addEntry(HILBERT, 0);

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers);
	}
	
	@Test
	@DisplayName("addEntry_addFiveElementsForSingleKey_lookupIsCorrect")
	void testAdd5EntriesForSameKey() {
		// Exercise 1d, g)

		// Run test
		book.addEntry(HILBERT, 1);
		book.addEntry(HILBERT, 2);
		book.addEntry(HILBERT, 3);
		book.addEntry(HILBERT, 4);
		book.addEntry(HILBERT, 5); // like no effect, because the length is larger than 4

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers, 1, 2, 3, 4);
	}

	@Test
	@DisplayName("removeEntry_removeTwoExistingValues_leavesOthersUnaffected")
	void testAddMultipleEntriesForSameKeyDeleteTwo() {
		// Exercise 1g)

		// Run test
		book.addEntry(HILBERT, 1);
		book.addEntry(HILBERT, 2);
		book.addEntry(HILBERT, 3);
		book.addEntry(HILBERT, 4);
		book.removeEntry(HILBERT,4);
		book.removeEntry(HILBERT,3);
		book.removeEntry(HILBERT,1);
		book.removeEntry(HILBERT,2); // could not be removed, because the removeEntry stops once there is a 0 

		// Check result
		int[] numbers = book.lookupName(HILBERT);
		assertElements(numbers,2); 
	}

	@Test
	@DisplayName("lookupName_addTwoEntries_lookUpReturnsCorrectNumber")
	void testAdd2EntriesLookUpOne() {
		// Exercise 1g)

		// Run test
		book.addEntry("Anna", 1234);
		book.addEntry("Nana", 1235); // "Anna" and "Nana" lead to the same hash value defined in PhoneBook class

		// Check result
		int[] numbers = book.lookupName("Anna");
		assertElements(numbers, 1234, 1235);
	}
}
