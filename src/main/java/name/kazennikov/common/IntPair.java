package name.kazennikov.common;

import cern.colt.function.LongComparator;

/**
 * Utility class for handling long as pair of ints
 *
 * @author Anton Kazennikov
 */
public class IntPair {
	public static long makePair(int i1, int i2) {
		long key = i1;
		key = key << 32;
		return key + i2;
	}

	public static int first(long pair) {
		return (int) (pair >>> 32);
	}

	public static int second(long pair) {
		return (int) (pair & 0xFFFFFFFFL);
	}

	public static final LongComparator COMPARATOR = new LongComparator() {
		@Override
		public int compare(long l, long l1) {
			int res = Integer.compare(first(l), first(l1));
			if(res != 0)
				return res;

			return Integer.compare(second(l), second(l1));
		}
	};
}
