package name.kazennikov.common.trove;

import gnu.trove.list.TByteList;
import gnu.trove.list.TCharList;
import gnu.trove.list.TDoubleList;
import gnu.trove.list.TFloatList;
import gnu.trove.list.TIntList;
import gnu.trove.list.TShortList;
import gnu.trove.list.array.TCharArrayList;
import gnu.trove.list.array.TIntArrayList;
import gnu.trove.map.hash.TObjectFloatHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.map.hash.TObjectLongHashMap;
import gnu.trove.procedure.TObjectFloatProcedure;
import gnu.trove.procedure.TObjectIntProcedure;
import gnu.trove.procedure.TObjectLongProcedure;
import name.kazennikov.common.count.FloatCount;
import name.kazennikov.common.count.IntCount;
import name.kazennikov.common.count.LongCount;

import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TroveUtils {
    private TroveUtils() {}

    public static void swap(TIntList l, int i, int j) {
        int t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public static void swap(TDoubleList l, int i, int j) {
        double t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public static void swap(TFloatList l, int i, int j) {
        float t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public static void swap(TShortList l, int i, int j) {
        short t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public static void swap(TCharList l, int i, int j) {
        char t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public static void swap(TByteList l, int i, int j) {
        byte t = l.get(i);
        l.set(i, l.get(j));
        l.set(j, t);
    }

    public static void expand(TIntArrayList dest, CharSequence s) {
        dest.resetQuick();

        for(int i = 0; i < s.length(); i++) {
            dest.add(s.charAt(i));
        }
    }

    public static void expand(TCharArrayList dest, CharSequence s) {
        dest.resetQuick();

        for(int i = 0; i < s.length(); i++) {
            dest.add(s.charAt(i));
        }
    }



    public static void expand(TIntArrayList dest, CharSequence from, CharSequence to) {
        dest.resetQuick();
        int maxLength = Math.max(from.length(), to.length());

        for(int i = 0; i < maxLength; i++) {
            char wfChar = i < from.length()? from.charAt(i) : 0;
            char lemmaChar = i < to.length()? to.charAt(i) : 0;

            int destSymbol = (lemmaChar << 16) + wfChar;
            dest.add(destSymbol);
        }
    }

    public static <E> TObjectIntHashMap<? super E> mergeCounts(final TObjectIntHashMap<? super E> dest, final TObjectIntHashMap<? extends E> src) {
        src.forEachEntry(new TObjectIntProcedure<E>() {
            @Override
            public boolean execute(E a, int b) {
                dest.adjustOrPutValue(a, b, b);
                return true;
            }
        });

        return dest;
    }

    public static <E> TObjectFloatHashMap<? super E> mergeCounts(final TObjectFloatHashMap<? super E> dest, final TObjectFloatHashMap<? extends E> src) {
        src.forEachEntry(new TObjectFloatProcedure<E>() {
            @Override
            public boolean execute(E a, float b) {
                dest.adjustOrPutValue(a, b, b);
                return true;
            }
        });

        return dest;
    }

    public static <E> TObjectFloatHashMap<? super E> mergeCounts(final TObjectFloatHashMap<? super E> dest, final TObjectIntHashMap<? extends E> src) {
        src.forEachEntry(new TObjectIntProcedure<E>() {
            @Override
            public boolean execute(E a, int b) {
                dest.adjustOrPutValue(a, b, b);
                return true;
            }
        });

        return dest;
    }

    public static <E> List<IntCount<E>> getCounts(final TObjectIntHashMap<E> count, final int minCount, final int maxCount) {
        final List<IntCount<E>> l = new ArrayList<>();

        count.forEachEntry(new TObjectIntProcedure<E>() {
            @Override
            public boolean execute(E a, int b) {
                if(b >= minCount && b < maxCount)
                    l.add(new IntCount<E>(a, b));

                return true;
            }
        });

        Collections.sort(l, new Comparator<IntCount<E>>() {
            @Override
            public int compare(IntCount<E> o1, IntCount<E> o2) {
                return o2.getCount() - o1.getCount();
            }
        });

        return l;
    }

    public static <E> List<LongCount<E>> getCounts(final TObjectLongHashMap<E> count, final long minCount, final long maxCount) {
        final List<LongCount<E>> l = new ArrayList<>();

        count.forEachEntry(new TObjectLongProcedure<E>() {
            @Override
            public boolean execute(E a, long b) {
                if(b >= minCount && b < maxCount)
                    l.add(new LongCount<E>(a, b));

                return true;
            }
        });

        Collections.sort(l, new Comparator<LongCount<E>>() {
            @Override
            public int compare(LongCount<E> o1, LongCount<E> o2) {
                return (int) (o2.getCount() - o1.getCount());
            }
        });

        return l;
    }

    public static <E> List<FloatCount<E>> getCounts(final TObjectFloatHashMap<E> count, final float minCount, final float maxCount) {
        final List<FloatCount<E>> l = new ArrayList<>();

        count.forEachEntry(new TObjectFloatProcedure<E>() {
            @Override
            public boolean execute(E a, float b) {
                if(b >= minCount && b < maxCount)
                    l.add(new FloatCount<E>(a, b));

                return true;
            }
        });

        Collections.sort(l, new Comparator<FloatCount<E>>() {
            @Override
            public int compare(FloatCount<E> o1, FloatCount<E> o2) {
                return (int) Math.signum(o2.getCount() - o1.getCount());
            }
        });

        return l;
    }

    public static <E> void writeCounts(File dest, TObjectIntHashMap<E> counts, int minCount, int maxCount) throws IOException {
        List<IntCount<E>> l = getCounts(counts, minCount, maxCount);
        try(PrintWriter pw = new PrintWriter(dest)) {
            for(IntCount<E> c : l) {
                pw.printf("%s\t%d%n", c.getObject(), c.getCount());
            }
        }
    }

    public static <E> void writeCounts(File dest, TObjectLongHashMap<E> counts, long minCount, long maxCount) throws IOException {
        List<LongCount<E>> l = getCounts(counts, minCount, maxCount);
        try(PrintWriter pw = new PrintWriter(dest)) {
            for(LongCount<E> c : l) {
                pw.printf("%s\t%d%n", c.getObject(), c.getCount());
            }
        }
    }

    public static <E> void writeCounts(File dest, TObjectFloatHashMap<E> counts, float minCount, float maxCount) throws IOException {
        List<FloatCount<E>> l = getCounts(counts, minCount, maxCount);
        try(PrintWriter pw = new PrintWriter(dest)) {
            for(FloatCount<E> c : l) {
                pw.printf("%s\t%f%n", c.getObject(), c.getCount());
            }
        }
    }
}
