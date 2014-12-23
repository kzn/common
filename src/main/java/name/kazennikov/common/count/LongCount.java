package name.kazennikov.common.count;

import com.google.common.base.Objects;

/**
 * Created by kzn on 12/23/14.
 */
public class LongCount<E> {
    E object;
    long count;

    public LongCount(E object, long count) {
        this.object = object;
        this.count = count;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        LongCount longCount = (LongCount) o;

        if(count != longCount.count) return false;
        if(object != null ? !object.equals(longCount.object) : longCount.object != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = object != null ? object.hashCode() : 0;
        result = 31 * result + (int) (count ^ (count >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("object", object)
                .add("count", count)
                .toString();
    }
}
