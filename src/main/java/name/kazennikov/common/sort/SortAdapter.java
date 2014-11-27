package name.kazennikov.common.sort;

import cern.colt.Swapper;
import cern.colt.function.IntComparator;

public interface SortAdapter extends IntComparator, Swapper {
	public int size();
}
