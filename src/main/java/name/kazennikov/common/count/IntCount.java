package name.kazennikov.common.count;

import com.google.common.base.Objects;

/**
 * Created by kzn on 12/23/14.
 */
public class IntCount<E> {
    E object;
    int count;

    public IntCount(E object, int count) {
        this.object = object;
        this.count = count;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        IntCount intCount = (IntCount) o;

        if(count != intCount.count) return false;
        if(object != null ? !object.equals(intCount.object) : intCount.object != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = object != null ? object.hashCode() : 0;
        result = 31 * result + count;
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
