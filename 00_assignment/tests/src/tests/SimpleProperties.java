package tests;

import org.junit.jupiter.api.Assertions;

import net.jqwik.api.Property;
import net.jqwik.api.ForAll;



public class SimpleProperties {

	// Exercise 2.2) a)
	@Property
	void checkAbsValue(@ForAll int x) {
		int y = Simple.abs(x);
		Assertions.assertTrue(y == x || y == -x);
	}
	
}
