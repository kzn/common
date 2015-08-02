package name.kazennikov.count;

import com.google.common.base.Objects;

/**
 * Created by kzn on 12/23/14.
 */
public class FloatCount<E> {
    E object;
    float count;

    public FloatCount(E object, float count) {
        this.object = object;
        this.count = count;
    }

    public E getObject() {
        return object;
    }

    public void setObject(E object) {
        this.object = object;
    }

    public float getCount() {
        return count;
    }

    public void setCount(float count) {
        this.count = count;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        FloatCount that = (FloatCount) o;

        if(Float.compare(that.count, count) != 0) return false;
        if(object != null ? !object.equals(that.object) : that.object != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = object != null ? object.hashCode() : 0;
        result = 31 * result + (count != +0.0f ? Float.floatToIntBits(count) : 0);
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
