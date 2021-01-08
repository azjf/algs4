import edu.princeton.cs.algs4.StdOut;

public class TestDate {
	public static void main(String[] args) {
		int m = Integer.parseInt(args[0]);
		int d = Integer.parseInt(args[1]);
		int y = Integer.parseInt(args[2]);
		//BasicDate date = new BasicDate(m, d, y);
		SmallDate date = new SmallDate(m, d, y);
		StdOut.println(date);
	}
}
