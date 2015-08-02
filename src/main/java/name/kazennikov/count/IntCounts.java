package name.kazennikov.count;

import cern.colt.GenericSorting;
import cern.colt.Swapper;
import cern.colt.function.IntComparator;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.procedure.TObjectIntProcedure;
import name.kazennikov.common.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kzn on 1/4/15.
 */
public class IntCounts<E> {
    public final IntComparator DESC = new IntComparator() {
        @Override
        public int compare(int i, int i2) {
            return counts[i2] - counts[i];
        }
    };

    public final IntComparator ASC = new IntComparator() {
        @Override
        public int compare(int i, int i2) {
            return counts[i] - counts[i2];
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
    int[] counts;

    public IntCounts(E[] objects, int[] counts) {
        this.objects = objects;
        this.counts = counts;
    }

    protected void allocate(int size) {
        objects = (E[]) new Object[size];
        this.counts = new int[size];

    }

    public IntCounts(List<IntCount<E>> counts) {
        allocate(counts.size());

        for(int i = 0; i < counts.size(); i++) {
            objects[i] = counts.get(i).object;
            this.counts[i] = counts.get(i).count;
        }
    }

    public IntCounts(TObjectIntHashMap<E> counts) {
        allocate(counts.size());
        counts.forEachEntry(new TObjectIntProcedure<E>() {
            int index = 0;
            @Override
            public boolean execute(E a, int b) {
                objects[index] = a;
                IntCounts.this.counts[index] = b;
                index++;
                return true;
            }
        });
    }

    public IntCounts(TObjectIntHashMap<E> counts, final int minLimit, final int maxLimit) {


        final List<E> objects = new ArrayList<>(counts.size());
        final TIntArrayList c = new TIntArrayList(counts.size());
        counts.forEachEntry(new TObjectIntProcedure<E>() {
            int index = 0;
            @Override
            public boolean execute(E a, int b) {
                if(b >= minLimit && b < maxLimit) {
                    objects.add(a);
                    c.add(b);
                }

                return true;
            }
        });

        allocate(objects.size());

        for(int i = 0; i < objects.size(); i++) {
            this.objects[i] = objects.get(i);
            this.counts[i] = c.get(i);
        }
    }

    public int size() {
        return objects.length;
    }

    public int getCount(int index) {
        return counts[index];
    }

    public E getObject(int index) {
        return objects[index];
    }

    public void inplaceSort(IntComparator c) {
        GenericSorting.quickSort(0, size(), c, SWAPPER);
    }


}
