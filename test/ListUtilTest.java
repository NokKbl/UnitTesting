import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test methods in the ListUtil class.
 * 
 * @author Kunyaruk Katebunlu
 */
public class ListUtilTest {
	
	// Test for countUnique method
	
	private List<?> makeList(Object ... elements){
		return Arrays.asList(elements);
	}
	
	@Test
	public void testEmptyList() {
		List<?> list = new ArrayList<>(); // an empty list
		assertEquals(0, ListUtil.countUnique(list));
	}
	
	@Test
	public void testStringSizeOfOne() {
		assertEquals(1, ListUtil.countUnique(makeList("Apple")));
		assertEquals(1, ListUtil.countUnique(makeList("Hello", "Hello")));
	}
	
	@Test
	public void testStringSizeOfTwoItemsManyOrders() {
		assertEquals(2, ListUtil.countUnique(makeList("Apple", "Banana")));
		assertEquals(2, ListUtil.countUnique(makeList("Hello", "Apple", "Hello", "Apple", "Apple", "Hello")));
	}
	
	@Test
	public void testNumberTypeItems() {
		assertEquals(1, ListUtil.countUnique(makeList(1)));
		assertEquals(1, ListUtil.countUnique(makeList(1, 1, 1)));
		
		assertEquals(2, ListUtil.countUnique(makeList(1, 2)));
		assertEquals(2, ListUtil.countUnique(makeList(2, 1, 1, 2, 2, 1)));
	}
	
	@Test
	public void testNullItem() {
		List<?> list = new ArrayList<>();
		list.add(null);
		assertEquals(1, ListUtil.countUnique(list));
	}
	
	@Test
	public void testMultipleTypeItems() {
		assertEquals(2, ListUtil.countUnique(makeList(1, "Hi")));
		assertEquals(3, ListUtil.countUnique(makeList(1, 1.345, "Hello")));
		assertEquals(4, ListUtil.countUnique(makeList(1, "Apple", 2, 1, "Apple", "Hello")));
	}
	
	
	// Test for binarySearch method
	
	@Test
	public void testBinarySearchSimpleCases() {
		// array with even length
		String[] arrString = new String[] {"Ant", "Bird"};
		assertEquals(0, ListUtil.binarySearch(arrString, "Ant"));
		assertEquals(1, ListUtil.binarySearch(arrString, "Bird"));
		
		Integer[] arrInt = new Integer[] {1,2,3,4};
		assertEquals(1, ListUtil.binarySearch(arrInt, 2));
		assertEquals(2, ListUtil.binarySearch(arrInt, 3));
		
		// array with odd length
		Double[] arrDouble = {5.44};
		assertEquals(0, ListUtil.binarySearch(arrDouble, 5.44));
		
		arrString = new String[] {"Ant", "Bird", "Cat"};
		assertEquals(1, ListUtil.binarySearch(arrString, "Bird"));
		assertEquals(2, ListUtil.binarySearch(arrString, "Cat"));
		
		arrInt = new Integer[] {1,2,3,4,5};
		assertEquals(0, ListUtil.binarySearch(arrInt, 1));
		assertEquals(3, ListUtil.binarySearch(arrInt, 4));
		assertEquals(4, ListUtil.binarySearch(arrInt, 5));	
	}
	
	@Test
	public void testBinarySearchElementNotMatch() {
		String[] arrString = {"Apple", "Banana", "Orange"};
		assertEquals(-1, ListUtil.binarySearch(arrString, "Hi"));
		assertEquals(-1, ListUtil.binarySearch(arrString, "banana")); // not capital letter
		
		Integer[] arrInt = {1,2,3,4,5};
		assertEquals(-1, ListUtil.binarySearch(arrInt, 12));
	}
	
	@Test
	public void testBinarySearchDuplicateValue() {
		String[] arrString = {"Ant", "Bird", "Bird", "Bird", "Orange"};
		assertEquals(2, ListUtil.binarySearch(arrString, "Bird"));
		
		Integer[] arrInt = {1,1,2,3,4,5};
		assertEquals(0, ListUtil.binarySearch(arrInt, 1));
	}
	
	@Test
	public void testBinarySearchEmptyArray() {
		String[] arr = { };
		assertEquals(-1, ListUtil.binarySearch(arr, "Hi"));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testBinarySearchNullElement() {
		Integer[] arr = {1, 2, 3, 4};
		assertEquals(0, ListUtil.binarySearch(arr, null));
	}
}
