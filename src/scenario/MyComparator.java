package scenario;

import java.util.Comparator;
import java.util.Map;

/**
 * Auto sorts tree maps by descending order.
 * http://stackoverflow.com/questions/11647889/sorting-the-mapkey-value-in-descending-order-based-on-the-value
 * @author byronb92
 *
 */
public class MyComparator implements Comparator {
	Map map;

	public MyComparator(Map map) {
		this.map = map;
	}

	public int compare(Object o1, Object o2) {
		return ((Integer) map.get(o2)).compareTo((Integer) map.get(o1));

	}
}
