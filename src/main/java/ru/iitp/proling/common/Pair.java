package ru.iitp.proling.common;


public class Pair<E1, E2> implements Comparable<Pair<E1, E2>> {
	public final E1 first;
	public final E2 second;


	private Pair(E1 first, E2 second) {
		this.first = first;
		this.second = second;
	}


	public static <E1, E2> Pair<E1, E2> of(E1 first, E2 second) {
		return new Pair<E1, E2>(first, second);
	}


	@Override
	public int compareTo(Pair<E1, E2> o) {
		int cmp = compare(first, o.first);
		return cmp == 0 ? compare(second, o.second) : cmp;
	}

	// todo move this to a helper class.
	private static int compare(Object o1, Object o2) {
		return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1 : ((Comparable) o1).compareTo(o2);
	}


	@Override
	public int hashCode() {
		return 31 * hashcode(first) + hashcode(second);
	}


	// todo move this to a helper class.
	private static int hashcode(Object o) {
		return o == null ? 0 : o.hashCode();
	}


	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair)) return false;
		if (this == obj) return true;
		return equal(first, ((Pair) obj).first) && equal(second, ((Pair) obj).second);
	}


	// todo move this to a helper class.
	private boolean equal(Object o1, Object o2) {
		return o1 == null ? o2 == null : (o1 == o2 || o1.equals(o2));
	}


	@Override
	public String toString() {
		return "(" + first + ", " + second + ')';
	}
}