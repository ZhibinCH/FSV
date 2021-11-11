package tests;

import org.junit.jupiter.api.Assertions;

import net.jqwik.api.Property;
import net.jqwik.api.Assume;
import net.jqwik.api.ForAll;



public class SimpleProperties {

	// Exercise 2.2) a)
	@Property
	void checkAbsValue(@ForAll int x) {
		int y = Simple.abs(x);
		Assertions.assertTrue(y == x || y == -x);
	}
	
	@Property
	void checkAbsNonNegativity(@ForAll int x) {
		
		// rule out Integer.MIN_VALUE
		Assume.that(x != Integer.MIN_VALUE);
		
		int y = Simple.abs(x);
		Assertions.assertTrue(y >= 0);
	}
	
	@Property
	void checkAbsReference(@ForAll int x) {
		Assertions.assertTrue(Simple.abs(x) == Math.abs(x));
	}
	
	// Exercise 2.2) b)
	@Property
	void maxContainsAll(@ForAll int array[]) {
		Assume.that(array.length > 0);
		int max = Simple.max(array, 0, array.length);
		Assertions.assertTrue(IntUtils.asList(array).contains(max));
	}
	
	
	
}
