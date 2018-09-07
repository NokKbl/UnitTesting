import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil class for count the number of distinct elements in the list
 * and search for an element in an array.
 * 
 * @author Kunyaruk Katebunlu
 */
public class ListUtil {
    /**
     * Count the number of distinct elements in a list.
     * The list may be empty but not null.
     * The list can contains null value and count null as a unique element.
     *
     * @param list a list of elements
     * @return the number of distinct elements in list
     */
    public static int countUnique(List<?> list) {
    	List<Object> unique = new ArrayList<>();
    	
    	for(int i = 0; i < list.size(); i++) {
    		Object word = list.get(i);
    		if(!unique.contains(word)) unique.add(word);
    	}
    	
    	return unique.size();
    }
    
    /**
     * Use binary search to searches for an element in an array,
     * where the array contents are already sorted.
     * 
     * @param array an array of elements to search
     * @param element an element that want to search for
     * @return index of the matching element or -1 if the search element is not in the array.
     * @throws IllegalArgumentException if the value to find (element) is null.
     */
    public static <T extends Comparable<? super T>> int binarySearch(T[] array, T element) {
    	int start = 0;
    	int mid = 0;
    	int end = array.length - 1;
    	
    	if(element == null) throw new IllegalArgumentException("Search element must not be null");
    	
    	while(end >= start) {
    		mid = (start + end) / 2;
    		if(array[mid].compareTo(element) == 0) return mid;
    		if(array[mid].compareTo(element) <= -1) start = mid + 1;
    		else end = mid - 1;
    	}
    	
    	return -1;
    }
    
}