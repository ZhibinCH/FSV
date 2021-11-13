package tests;

import java.util.ArrayList;
import java.util.List;

public class IntUtils {
	static List<Integer> asList (int... ints){ 
		// Varargs: The three periods after the final parameter's type indicate that the final argument may be passed as an array or as a sequence of arguments.
		// Varargs can be used only in the final argument position.
		List<Integer> intList = new ArrayList<>(); // List is an interface which ArrayList implements. 
		for (int element:ints) {
			intList.add(element);
		}
		return intList;
	}
	
	static List<Integer> asList(int a[], int from, int to) {
		List<Integer> intList = new ArrayList<>();
		for (int i = from; i < to; i++)
			intList.add(a[i]);
		return intList;
	}

}
