import edu.princeton.cs.algs4.SequentialSearchST;

public class SeperateChainingHashST<Key, Value> {
	private int N;
	private int M;
	private SequentialSearchST<Key, Value>[] st;

	public SeperateChainingHashST() {
		this(997);
	}

	public SeperateChainingHashST(int M) {
		this.M = M;
		st = (SequentialSearchST<Key, Value>[]) new SequentialSearchST[M];
		for (int i=0; i<M; i++) {
			st[i] = new SequentialSearchST();
		}
	}

	private int hash(Key x) {
		return (x.hashCode() & 0x7fffffff) % M;
	}

	public Value get(Key key) {
		return (Value) st[hash(key)].get(key);
	}

	public void put(Key key, Value val) {
		if (N >= M / 2) {
			resize(2 * M);
		}
		st[hash(key)].put(key, val);
		N++;
	}

	//public Iterable<Key> keys() {}

	private void resize(int cap) {
		SeperateChainingHashST<Key, Value> t;
		t = new SeperateChainingHashST<Key, Value>(cap);
		for (int i=0; i<M; i++) {
			for (Key key : st[i].keys()) {
				t.put(key, t.get(key));
			}
		}
		st = t.st;
		M = t.M;
	}

	public void delete(Key key) {
		if (!contains(key)) {
			return;
		}
		st[hash(key)].delete(key);
		N--;
		if (N > 0 && N <= M / 8) {
			resize(M / 2);
		}
	}

	boolean contains(Key key) {
		return get(key) != null;
	}
}
