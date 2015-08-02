package name.kazennikov.sort;

import cern.colt.Swapper;
import cern.colt.function.IntComparator;

public interface SortAdapter extends IntComparator, Swapper {
	public int size();
}
