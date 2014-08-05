package name.kazennikov.alphabet;


import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TLongIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;
import gnu.trove.procedure.TIntIntProcedure;
import gnu.trove.procedure.TLongIntProcedure;
import gnu.trove.procedure.TObjectIntProcedure;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class TStringWriters {
	
	public static void write(String fileName, TLongIntHashMap map) throws IOException {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(fileName));
			final BufferedWriter w1 = w;
			w1.append(Integer.toString(map.size()));
			w1.newLine();
			
			map.forEachEntry(new TLongIntProcedure() {
				
				@Override
				public boolean execute(long arg0, int arg1) {
					try {
						w1.append(Long.toString(arg0));
						w1.append('\t');
						w1.append(Integer.toString(arg1));
						w1.newLine();
					} catch(IOException e) {
						return false;
					}
					return true;
				}
			});
		} finally {
			if(w != null)
				w.close();
		}
	}
	
	public static void write(String fileName, TIntIntHashMap map) throws IOException {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(fileName));
			final BufferedWriter w1 = w;
			w1.append(Integer.toString(map.size()));
			w1.newLine();
			
			map.forEachEntry(new TIntIntProcedure() {
				
				@Override
				public boolean execute(int arg0, int arg1) {
					try {
						w1.append(Integer.toString(arg0));
						w1.append('\t');
						w1.append(Integer.toString(arg1));
						w1.newLine();
					} catch(IOException e) {
						return false;
					}
					return true;
				}
			});
		} finally {
			if(w != null)
				w.close();
		}
	}
	
	public static void write(String fileName, TObjectIntHashMap<String> map) throws IOException {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(fileName));
			final BufferedWriter w1 = w;
			w1.append(Integer.toString(map.size()));
			w1.newLine();
			
			map.forEachEntry(new TObjectIntProcedure<String>() {
				
				@Override
				public boolean execute(String arg0, int arg1) {
					try {
						w1.append(arg0);
						w1.append('\t');
						w1.append(Integer.toString(arg1));
						w1.newLine();
					} catch(IOException e) {
						return false;
					}
					return true;
				}
			});
		} finally {
			if(w != null)
				w.close();
		}
	}
	
	public static <E> void write(String fileName, final StringParser<E> parser, TObjectIntHashMap<E> map) throws IOException {
		BufferedWriter w = null;
		try {
			w = new BufferedWriter(new FileWriter(fileName));
			final BufferedWriter w1 = w;
			w1.append(Integer.toString(map.size()));
			w1.newLine();
			
			map.forEachEntry(new TObjectIntProcedure<E>() {
				
				@Override
				public boolean execute(E arg0, int arg1) {
					try {
						w1.append(parser.serialize(arg0));
						w1.append('\t');
						w1.append(Integer.toString(arg1));
						w1.newLine();
					} catch(IOException e) {
						return false;
					}
					return true;
				}
			});
		} finally {
			if(w != null)
				w.close();
		}
	}



}
