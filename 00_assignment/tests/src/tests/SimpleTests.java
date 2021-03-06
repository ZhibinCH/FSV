package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTests {
	
	// Exercise 2.1) a)
	@Test
	void testAbs() {
		Assertions.assertEquals(1,Simple.abs(1));
		Assertions.assertEquals(1,Simple.abs(-1));
		Assertions.assertEquals(0,Simple.abs(0));
		
		Assertions.assertEquals(Integer.MAX_VALUE, Simple.abs(Integer.MAX_VALUE));
		Assertions.assertEquals(Integer.MIN_VALUE, Simple.abs(Integer.MIN_VALUE));
		//Integer.MAX_VALUE == 2^31 - 1 
		//Integer.MIN_VALUE == -(2^31)
	}
	
	// Exercise 2.1) b)
	@Test
	void testFib() {
		Assertions.assertEquals(0,Simple.fib(0));
		Assertions.assertEquals(1,Simple.fib(1));
		Assertions.assertEquals(1,Simple.fib(2));
		Assertions.assertEquals(2,Simple.fib(3));
		Assertions.assertEquals(3,Simple.fib(4));
		
	}
	
	@Test
	void testFib_NegativeInput_ReturnsZero() {
		Assertions.assertEquals(0,Simple.fib(-1));
		Assertions.assertEquals(0,Simple.fib(Integer.MIN_VALUE));
		
	}
	
	@Test
	void testFib_VeryLargeInput() {
		Assertions.assertEquals(1836311903, Simple.fib(46));
		// Assertions.assertTrue(Simple.fib(47)<0); -> it leads to an int-overflow
		
	}

	// Exercise 2.1) c)
	static int a[] = { 1, 4, 2, 3, 5, 7, 4, 9, -1 };
	
	@Test
	void testMax() {
		Assertions.assertEquals(1, Simple.max(a, 0, 1));
		Assertions.assertEquals(3, Simple.max(a, 2, 4));
		Assertions.assertEquals(9, Simple.max(a, 0, a.length));
	}
	
	@Test
	void testMax_InvalidParams_throwsError() {
		Assertions.assertThrows(AssertionError.class, () -> Simple.max(null, 0, 0)); // () -> points to a lambda expression that accepts zero arguments
		Assertions.assertThrows(AssertionError.class, () -> Simple.max(a, -1, 0));
		Assertions.assertThrows(AssertionError.class, () -> Simple.max(a, 0, 100));
		
		int[] empty = {};
		Assertions.assertThrows(AssertionError.class, () -> Simple.max(empty, 0, 0));
		Assertions.assertThrows(AssertionError.class, () -> Simple.max(empty, -1, 0));
		Assertions.assertThrows(AssertionError.class, () -> Simple.max(empty, 0, 100));
		
	}	
	
	
}
