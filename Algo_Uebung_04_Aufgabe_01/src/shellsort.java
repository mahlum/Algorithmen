import java.util.*;

public class shellsort<K> {
	static <K extends Comparable<K>> void shell_sort(K[] field, int[] Dist) {
		for (int i = 0; i < Dist.length; ++i) {
			for (int i1 = Dist[i]; i1 < field.length; ++i1) {
				final K IVAL = field[i1];
				int i2 = i1;
				while (i2 >= Dist[i] && field[i2 - Dist[i]].compareTo(IVAL) > 0) {
					field[i2] = field[i2 - Dist[i]];
					i2 = i2 - Dist[i];
				}
				field[i2] = IVAL;
			}
		}
	}
}