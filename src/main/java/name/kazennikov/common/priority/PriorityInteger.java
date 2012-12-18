package name.kazennikov.common.priority;

public class PriorityInteger<E> implements Comparable<PriorityInteger<E>> {
	public final int priority;
	public final E object;
	
	public PriorityInteger(E object, int priority){
		this.object = object;
		this.priority = priority;
	}

	@Override
	public int compareTo(PriorityInteger<E> o) {
		return priority - o.priority; 
	}
	
	public String toString(){
		return String.format("{val:%s, pri:%d}", object, priority);
	}
	
	public E object() {
		return object;
	}


}
