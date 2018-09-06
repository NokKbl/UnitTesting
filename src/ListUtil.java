import java.util.ArrayList;
import java.util.List;

/**
 * ListUtil class for count the number of distinct elements in a list.
 * 
 * @author Kunyaruk Katebunlu
 */
public class ListUtil {
    /**
     * Count the number of distinct elements in a list.
     * The list may be empty but not null.
     * TODO: can the list contain null values? Does null count as a unique element?
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
}