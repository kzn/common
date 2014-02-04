package name.kazennikov.common;

import gnu.trove.map.hash.TObjectIntHashMap;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import com.google.common.io.LineProcessor;

public class LineProcessors {
	private LineProcessors() {}
	
	public static class StringSetReader implements LineProcessor<Set<String>> {
		Set<String> set;
		
		public StringSetReader() {
			this(new HashSet<String>());
		}
		
		public StringSetReader(Set<String> set) {
			this.set = set;
		}
		

		@Override
		public Set<String> getResult() {
			return set;
		}

		@Override
		public boolean processLine(String line) throws IOException {
			set.add(line);
			return true;
		}
	}
	
	public static class StringCountReader implements LineProcessor<TObjectIntHashMap<String>> {
		TObjectIntHashMap<String> table = new TObjectIntHashMap<>();
		String sep;
		
		public StringCountReader() {
			this("\t");
		}
		
		public StringCountReader(String sep) {
			this.sep = sep;
		}

		@Override
		public TObjectIntHashMap<String> getResult() {
			return table;
		}

		@Override
		public boolean processLine(String line) throws IOException {
			if(line.isEmpty())
				return true;
			
			int sepOffset = line.indexOf(this.sep);
			if(sepOffset == -1)
				throw new IllegalStateException("Line '" + line + "' doesn't have separator '" + sep + "'");
			int count = Integer.parseInt(line.substring(sepOffset + sep.length()));
			table.adjustOrPutValue(line.substring(0, sepOffset), count, count);
			return true;
		}
		
	}

}
