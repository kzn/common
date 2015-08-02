package name.kazennikov.trove;

import gnu.trove.set.hash.TCustomHashSet;
import gnu.trove.strategy.HashingStrategy;

import java.util.Collection;

public class TroveCustomHashSet<E> extends TCustomHashSet<E> {

	public TroveCustomHashSet() {
		super();
	}

	public TroveCustomHashSet(HashingStrategy<? super E> strategy,
			Collection<? extends E> collection) {
		super(strategy, collection);
	}

	public TroveCustomHashSet(HashingStrategy<? super E> strategy,
			int initialCapacity, float loadFactor) {
		super(strategy, initialCapacity, loadFactor);
	}

	public TroveCustomHashSet(HashingStrategy<? super E> strategy,
			int initialCapacity) {
		super(strategy, initialCapacity);
	}

	public TroveCustomHashSet(HashingStrategy<? super E> strategy) {
		super(strategy);
	}
	
	public E get(Object e) {
		int index = index(e);
		return index < 0? null : (E) _set[index];
	}


	
}
