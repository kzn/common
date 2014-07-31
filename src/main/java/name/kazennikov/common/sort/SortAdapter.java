package name.kazennikov.common.sort;

public interface SortAdapter {
	public int size();
	public int compare(int index1, int index2);
	public void swap(int index1, int index2);
}
