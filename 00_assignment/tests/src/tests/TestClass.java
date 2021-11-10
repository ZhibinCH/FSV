package tests;


import static org.junit.jupiter.api.Assertions.*; 
import org.junit.jupiter.api.Test ;

public class TestClass {
	@Test
	void test() {
		assertTrue ( System.getProperty( "java.version" ).startsWith ( "11."), "Es ist nicht die richtige Java Version installiert ! " );
	}
}