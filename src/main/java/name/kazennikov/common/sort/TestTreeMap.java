package name.kazennikov.common.sort;

import gnu.trove.list.array.TIntArrayList;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.base.Objects;


public class TestTreeMap {
	
	
	
	public static void test1() throws Exception {
		CompactTreeMap1<String, String> m1 = new CompactTreeMap1<String, String>();
		Random r = new Random(10);
		Random r1 = new Random(15);
		long st = System.currentTimeMillis();
		long elapsed1 = 0;
		long elapsed2 = 0;
		
		for(int i = 0; i < 1000000; i++) {
			int k = r.nextInt() >>> 1;
			//System.out.printf("Adding %d%n", k);
			String key = "" + k;
			String value = "";
			//long ts0 = System.nanoTime();
			m1.put(key, value);
			//long ts1 = System.nanoTime();
			//elapsed1 += ts1 - ts0;
			//elapsed2 += System.nanoTime() - ts1;
			//keys.add(key);
			

			
			/*if(r1.nextBoolean()) {
				int idx = r1.nextInt(keys.size());
				m1.remove(keys.get(idx));
				m2.remove(keys.get(idx));
			}*/
			
		}
		
		/*if(!compareTrees(m1, m2)) {
			System.out.printf("not equal");

		}*/

		

		
		System.out.printf("CTM Elapsed: %dms ", System.currentTimeMillis() - st);
		System.out.printf("m1=%d%n", m1.size());
		//System.out.printf("Elapsed CTM: %d ns%n", elapsed1);
		//System.out.printf("Elapsed TM: %d ns%n", elapsed2);
		
		//System.out.println(m);
	}
	
public static void test2() throws Exception {
		RefTreeMap<String, String> m2 = new RefTreeMap<String, String>(); 
		List<String> keys = new ArrayList<String>();
		Random r = new Random(10);
		Random r1 = new Random(15);
		long st = System.currentTimeMillis();
		long elapsed1 = 0;
		long elapsed2 = 0;
		
		for(int i = 0; i < 1000000; i++) {
			int k = r.nextInt() >>> 1;
			//System.out.printf("Adding %d%n", k);
			String key = "" + k;
			String value = "";
			//long ts0 = System.nanoTime();
			//long ts1 = System.nanoTime();
			//elapsed1 += ts1 - ts0;
			m2.put(key, value);
			//elapsed2 += System.nanoTime() - ts1;
			//keys.add(key);
			

			
			/*if(r1.nextBoolean()) {
				int idx = r1.nextInt(keys.size());
				m1.remove(keys.get(idx));
				m2.remove(keys.get(idx));
			}*/
			
		}
		
		/*if(!compareTrees(m1, m2)) {
			System.out.printf("not equal");

		}*/

		

		
		System.out.printf("RTM Elapsed: %dms ", System.currentTimeMillis() - st);
		System.out.printf("m2=%d%n", m2.size());
		//System.out.printf("Elapsed CTM: %d ns%n", elapsed1);
		//System.out.printf("Elapsed TM: %d ns%n", elapsed2);
		
		//System.out.println(m);
	}
	

	
	public static void main(String[] args) throws Exception {
		//for(int i = 0; i < 20; i++)
		
		while(true) {
			test1();
			//test2();
		}
	}

	private static boolean compareTrees(CompactTreeMap1<String, String> m1, RefTreeMap<String, String> m2) {
		return equal(m1, m1.root, m2.root);
		
	}
	
	private static boolean equal(CompactTreeMap1<String, String> m1, int index, RefTreeMap.Entry<String, String> e2) {
		if(index == m1.NIL && e2 == null)
			return true;
		
		if(m1.left(index) == m1.NIL && e2.left != null)
			return false;
		
		if(m1.left(index) != m1.NIL && e2.left == null)
			return false;
		
		if(m1.right(index) == m1.NIL && e2.right != null)
			return false;
		
		if(m1.right(index) != m1.NIL && e2.right == null)
			return false;
		
		if(m1.key(index) != e2.key || m1.value(index) != e2.value)
			return false;
		
		//if(m1.color(index)  != e2.color)
		//	return false;
		
		if(m1.parent(index) == m1.NIL && e2.parent != null)
			return false;
		
		if(m1.parent(index) != m1.NIL && e2.parent == null)
			return false;
		
		if(e2.parent != null && m1.key(m1.parent(index)) != e2.parent.key) {
			return false;
		}
		
		return equal(m1, m1.left(index), e2.left) && equal(m1, m1.right(index), e2.right);

	}

}
