package ru.iitp.proling.common.priority;

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
}
