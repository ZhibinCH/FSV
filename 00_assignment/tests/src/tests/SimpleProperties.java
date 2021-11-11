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
	
}
