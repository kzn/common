package ru.iitp.proling.common.priority;

public class PriorityDouble<E> implements Comparable<PriorityDouble<E>> {
	public final double priority;
	public final E object;

	public PriorityDouble(E object, double priority) {
		this.object = object;
		this.priority = priority;
	}

	@Override
	public int compareTo(PriorityDouble<E> o) {
		return Double.compare(priority, o.priority);
	}
	
	public String toString(){
		return String.format("{val:%s, pri:%f}", object, priority);
	}
	
	public E object() {
		return object;
	}

}
