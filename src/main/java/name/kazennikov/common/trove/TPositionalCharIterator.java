package name.kazennikov.common.trove;

import gnu.trove.iterator.TCharIterator;

/**
 * Positional char iterator
 */
public interface TPositionalCharIterator extends TCharIterator {
    /**
     * Return current iterator position
     * @return
     */
    public int getPos();

    /**
     * Set iterator position
     * @param pos target position
     */
    public void setPos(int pos);
}
