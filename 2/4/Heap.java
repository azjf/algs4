import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Heap {
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int k=N/2; k>=1; k--) {
			sink(a, k, N);
		}
		while (N > 1) {
			exch(a, 1, N--);
			sink(a, 1, N);
		}
	}

	private static void sink(Comparable[] a, int k, int N) {
		while (2 * k <= N) {
			int j = 2 * k;
			if (j < N && less(a, j, j + 1)) {
				j++;
			}
			if (!less(a, k, j)) {
				break;
			}
			exch(a, k, j);
			k = j;
		}
	}

	private static boolean less(Comparable[] a, int i, int j) {
		return a[i-1].compareTo(a[j-1]) < 0;
	};

	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	};

	private static void exch(Comparable[] a, int i, int j) {
		Comparable t = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = t;
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
	}
}
