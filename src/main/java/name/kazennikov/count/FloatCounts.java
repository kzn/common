package name.kazennikov.count;

import cern.colt.GenericSorting;
import cern.colt.Swapper;
import cern.colt.function.IntComparator;
import gnu.trove.map.hash.TObjectFloatHashMap;
import gnu.trove.procedure.TObjectFloatProcedure;
import name.kazennikov.common.ArrayUtils;

import java.util.List;

/**
 * Created by kzn on 1/4/15.
 */
public class FloatCounts<E> {

        public final IntComparator DESC = new IntComparator() {
            @Override
            public int compare(int i, int i2) {
                return (int) Math.signum(counts[i2] - counts[i]);
            }
        };

        public final IntComparator ASC = new IntComparator() {
            @Override
            public int compare(int i, int i2) {
                return (int) Math.signum(counts[i] - counts[i2]);
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
        float[] counts;

        public FloatCounts(E[] objects, float[] counts) {
            this.objects = objects;
            this.counts = counts;
        }

        protected void allocate(int size) {
            objects = (E[]) new Object[size];
            this.counts = new float[size];

        }

        public FloatCounts(List<FloatCount<E>> counts) {
            allocate(counts.size());

            for(int i = 0; i < counts.size(); i++) {
                objects[i] = counts.get(i).object;
                this.counts[i] = counts.get(i).count;
            }
        }

        public FloatCounts(TObjectFloatHashMap<E> counts) {
            allocate(counts.size());
            counts.forEachEntry(new TObjectFloatProcedure<E>() {
                int index = 0;
                @Override
                public boolean execute(E a, float b) {
                    objects[index] = a;
                    FloatCounts.this.counts[index] = b;
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
