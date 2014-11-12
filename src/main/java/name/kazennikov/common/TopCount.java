package name.kazennikov.common;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.procedure.TObjectIntProcedure;

public class TopCount<E> {
	public static class Pair<E> {
		public final E data;
		public final int count;
		
		public Pair(E data, int count) {
			super();
			this.data = data;
			this.count = count;
		}
		
		
	}
	
	TObjectIntHashMap<E> counts = new TObjectIntHashMap<E>();
	
	public void add(E o, int count) {
		counts.adjustOrPutValue(o, count, count);
	}
	
	public void add(E o) {
		add(o, 1);
	}
	
	public void addAll(Collection<? extends E> c) {
		for(E o : c) {
			add(o);
		}
	}
	
	public void mergeWith(final TopCount<? extends E> srcCounts) {
		srcCounts.counts.forEachEntry(new TObjectIntProcedure<E>() {

			@Override
			public boolean execute(E a, int b) {
				counts.adjustOrPutValue(a, b, b);
				return true;
			}
		});
		
	}
	
	public List<Pair<E>> build() {
		final List<Pair<E>> pairs = new ArrayList<Pair<E>>();
		
		counts.forEachEntry(new TObjectIntProcedure<E>() {

			@Override
			public boolean execute(E a, int b) {
				pairs.add(new Pair<E>(a, b));
				return true;
			}
		});
		
		Collections.sort(pairs, new Comparator<Pair<E>>() {

			@Override
			public int compare(Pair<E> o1, Pair<E> o2) {
				return o2.count - o1.count;
			}
		});
		
		return pairs;
	}
	
	
	public void write(File f) throws IOException {
		try(PrintWriter pw = new PrintWriter(f, "UTF-8")) {
			for(Pair<E> pair : build()) {
				pw.printf("%s\t%d%n", pair.data, pair.count);
			}
		}
	}
	

}
