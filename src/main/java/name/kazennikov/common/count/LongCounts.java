package name.kazennikov.common.count;

import cern.colt.GenericSorting;
import cern.colt.Swapper;
import cern.colt.function.IntComparator;
import gnu.trove.map.hash.TObjectFloatHashMap;
import gnu.trove.map.hash.TObjectLongHashMap;
import gnu.trove.procedure.TObjectFloatProcedure;
import gnu.trove.procedure.TObjectLongProcedure;
import name.kazennikov.common.ArrayUtils;

import java.util.List;

/**
 * Created by kzn on 1/4/15.
 */
public class LongCounts<E> {

    public final IntComparator DESC = new IntComparator() {
        @Override
        public int compare(int i, int i2) {
            return (int) (counts[i2] - counts[i]);
        }
    };

    public final IntComparator ASC = new IntComparator() {
        @Override
        public int compare(int i, int i2) {
            return (int) (counts[i] - counts[i2]);
        }
    };

    public final Swapper SWAPPER = new Swapper() {
        @Override
        public void swap(int i, int i2) {
            ArrayUtils.swap(objects, i, i2);
            ArrayUtils.swap(counts, i, i2);
        }
    };


    E[] objects;
    long[] counts;

    public LongCounts(E[] objects, long[] counts) {
        this.objects = objects;
        this.counts = counts;
    }

    protected void allocate(int size) {
        objects = (E[]) new Object[size];
        this.counts = new long[size];

    }

    public LongCounts(List<LongCount<E>> counts) {
        allocate(counts.size());

        for(int i = 0; i < counts.size(); i++) {
            objects[i] = counts.get(i).object;
            this.counts[i] = counts.get(i).count;
        }
    }

    public LongCounts(TObjectLongHashMap<E> counts) {
        allocate(counts.size());
        counts.forEachEntry(new TObjectLongProcedure<E>() {
            int index = 0;
            @Override
            public boolean execute(E a, long b) {
                objects[index] = a;
                LongCounts.this.counts[index] = b;
                index++;
                return true;
            }
        });
    }

    public int size() {
        return objects.length;
    }

    public float getCount(int index) {
        return counts[index];
    }

    public E getObject(int index) {
        return objects[index];
    }

    public void inplaceSort(IntComparator c) {
        GenericSorting.quickSort(0, size(), c, SWAPPER);
    }




}
