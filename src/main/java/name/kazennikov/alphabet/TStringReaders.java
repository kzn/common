package name.kazennikov.alphabet;

import gnu.trove.map.hash.TIntIntHashMap;
import gnu.trove.map.hash.TLongIntHashMap;
import gnu.trove.map.hash.TObjectIntHashMap;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.StringTokenizer;

import name.kazennikov.common.StringTools;


public class TStringReaders {
	public static TIntIntHashMap readIntIntHashMap(String fileName) throws IOException {
		BufferedReader r = null;
		
		try {
			r = new BufferedReader(new FileReader(fileName));
			String s = r.readLine();
			int count = Integer.parseInt(s);
			TIntIntHashMap map = new TIntIntHashMap(count);
			for(int i = 0; i != count; i++) {
				s = r.readLine();
				StringTokenizer st = new StringTokenizer(s, "\t");
				int key = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				map.put(key, value);
			}
			return map;
		} finally {
			if(r != null)
				r.close();
		}
	}
	
	public static TLongIntHashMap readLongIntHashMap(String fileName) throws IOException {
		BufferedReader r = null;
		
		try {
			r = new BufferedReader(new FileReader(fileName));
			String s = r.readLine();
			int count = Integer.parseInt(s);
			TLongIntHashMap map = new TLongIntHashMap(count);
			for(int i = 0; i != count; i++) {
				s = r.readLine();
				StringTokenizer st = new StringTokenizer(s, "\t");
				long key = Long.parseLong(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				map.put(key, value);
			}
			return map;
		} finally {
			if(r != null)
				r.close();
		}
	}
	
	public static <E> TObjectIntHashMap<E> readObjectIntHashMap(String fileName, StringParser<E> parser) throws IOException {
		BufferedReader r = null;
		int c0 = 0;
		String foo = null;
		try {
			r = new BufferedReader(new FileReader(fileName));
			String s = r.readLine();
			int count = Integer.parseInt(s);
			TObjectIntHashMap<E> map = new TObjectIntHashMap<E>(count);
			for(int i = 0; i != count; i++) {
				c0++;
				s = r.readLine();
				foo = s;
				List<String> v = StringTools.split(s, '\t', false);
				E key = parser.parse(v.get(0));
				int value = Integer.parseInt(v.get(1));
				map.put(key, value);
			}
			return map;
		} finally {
			if(r != null)
				r.close();
		}
	}

	
	
}
