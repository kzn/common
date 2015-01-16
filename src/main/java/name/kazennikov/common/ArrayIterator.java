package name.kazennikov.common;

import java.util.Iterator;

/**
 * Created by kazennikov on 16.01.2015.
 */
public class ArrayIterator<E> implements Iterator<E> {
    E[] array;
    int current;
    int end;


    public ArrayIterator(E[] array, int start, int end) {
        this.array = array;
        this.current = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return current < end;
    }

    @Override
    public E next() {
        return array[current++];
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
