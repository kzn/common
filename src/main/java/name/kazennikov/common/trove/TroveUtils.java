package name.kazennikov.common.trove;

import gnu.trove.list.TByteList;
import gnu.trove.list.TCharList;
import gnu.trove.list.TDoubleList;
import gnu.trove.list.TFloatList;
import gnu.trove.list.TIntList;
import gnu.trove.list.TShortList;
import gnu.trove.list.array.TCharArrayList;
import gnu.trove.list.array.TIntArrayList;

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









}
