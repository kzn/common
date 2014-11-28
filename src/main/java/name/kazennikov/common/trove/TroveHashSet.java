package name.kazennikov.common.trove;

import java.util.Collection;

import gnu.trove.set.hash.THashSet;

public class TroveHashSet<E> extends THashSet<E> {

	public TroveHashSet() {
		super();
	}

	public TroveHashSet(Collection<? extends E> collection) {
		super(collection);
	}

	public TroveHashSet(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	public TroveHashSet(int initialCapacity) {
		super(initialCapacity);
	}
	
	
	public E get(Object e) {
		int index = index(e);
		return index < 0? null : (E) _set[index];
	}
	

}
