import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>, Value> {
	private Key[] keys;
	private Value[] vals;
	private int N;

	public BinarySearchST(int capacity) {
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	public int size() {
		return N;
	}

	public Value get(Key key) {
		if (isEmpty()) {
			return null;
		}
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			return vals[i];
		} else {
			return null;
		}
	}

	public int rank(Key key) {
		int lo = 0, hi = N - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if (cmp < 0) {
				hi = mid - 1;
			} else if (cmp > 0) {
				lo = mid + 1;
			} else {
				return mid;
			}
		}
		return lo;
	}

	public int rank(Key key, int lo, int hi) {
		if (hi < lo) {
			return lo;
		}
		int mid = lo + (hi - lo) / 2;
		int cmp = key.compareTo(keys[mid]);
		if (cmp < 0) {
			return rank(key, lo, mid - 1);
		} else if (cmp > 0) {
			return rank(key, mid + 1, hi);
		} else {
			return mid;
		}
	}

	public void put(Key key, Value val) {
		int i = rank(key);
		if (i < N && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}
		for (int j=N; j>i; j--) {
			keys[j] = keys[j - 1];
			vals[j] = vals[j - 1];
			keys[i] = key;
			vals[i] = val;
			N++;
		}
	}

	public void delete(Key key) {
		put(key, null);
	}

	boolean contains(Key key) {
		return get(key) != null;
	}

	boolean isEmpty() {
		return size() == 0;
	}

	public Key min() {
		return keys[0];
	}

	public Key max() {
		return keys[N - 1];
	}

	public Key select(int k) {
		return keys[k];
	}

	public Key ceilling(Key key) {
		int i = rank(key);
		return keys[i];
	}

	public Key floor(Key key) {
		return keys[rank(key) - 1];
	}

	/*public Key delete(Key key) {
		if (!contains[key]) {
			return null;
		}
		vals[rank(key)] = null;
		for (i=rank(key); i<N-1; i++) {
			keys[i] = keys[i + 1];
			vals[i] = vals[i + 1];
		}
	}*/

	public Iterable<Key> keys(Key lo, Key hi) {
		Queue<Key> q = new Queue<Key>();
		for (int i=rank(lo); i<rank(hi); i++) {
			q.enqueue(keys[i]);
		}
		if (contains(hi)) {
			q.enqueue(keys[rank(hi)]);
		}
		return q;
	}
}
