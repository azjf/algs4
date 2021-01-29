import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import java.util.Comparator;

public class Insertion {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && less(a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}

	public static void sort(Object[] a, Comparator c) {
		int N = a.length;
		for (int i=0; i<N; i++) {
			for (int j=i; j>0 && less(c, a[j], a[j-1]); j--) {
				exch(a, j, j-1);
			}
		}
	}

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	};

	private static boolean less(Comparator c, Object v, Object w) {
		return c.compare(v, w) < 0;
	}

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void exch(Object[] a, int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	private static void show(Comparable[] a) {
		for (int i=0; i<a.length; i++) {
			StdOut.print(a[i] + " ");
		}
		StdOut.println();
	}

	public static boolean isSorted(Comparable[] a) {
		for (int i=1; i<a.length; i++) {
			if (less(a[i], a[i-1])) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[] a = In.readStrings();
		sort(a);
		assert isSorted(a);
		show(a);

		//Insertion.sort(a, new Transaction.WhenOrder());
		//Insertion.sort(a, new Transaction.HowMuchOrder());
	}
}
