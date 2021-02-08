//import edu.princeton.cs.algs4.HashSET;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DeDup {
	public static void main(String[] args) {
		//HashSET<String> set;
		SET<String> set;
		set = new SET<String>();
		while (!StdIn.isEmpty()) {
			String key = StdIn.readString();
			if (!set.contains(key)) {
				set.add(key);
				StdOut.println(key);
			}
		}
	}
}
