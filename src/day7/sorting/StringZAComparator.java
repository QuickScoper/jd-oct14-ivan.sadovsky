package day7.sorting;

import java.util.*;

public class StringZAComparator implements Comparator<String> {

	@Override
	public int compare(String o1, String o2) {
		int result = o1.compareToIgnoreCase(o2);
		if (result < 0) {
			return 1;
		} else if (result > 0) {
			return -1;
		}
		return 0;
	}

}
