package name.kazennikov.common.trove;

import gnu.trove.strategy.HashingStrategy;

/**
 * Primitive version of {@link HashingStrategy}. Intended for
 * hashing opaque objects (for example objects, represented by indices in some
 * tables)
 * 
 * @author kazennikov
 *
 */
public interface IntHashingStrategy {
	public boolean equals(int i1, int i2);
	public int computeHashCode(int i);
}
