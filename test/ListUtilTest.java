import java.util.*;

import org.junit.*;
import static org.junit.Assert.*;

/**
 * Test methods in the ListUtil class.
 * 
 * @author Kunyaruk Katebunlu
 */
public class ListUtilTest {
	
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
}
