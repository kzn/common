package name.kazennikov.common;

import gnu.trove.list.TByteList;
import gnu.trove.list.TCharList;
import gnu.trove.list.TDoubleList;
import gnu.trove.list.TFloatList;
import gnu.trove.list.TIntList;
import gnu.trove.list.TShortList;

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









}
