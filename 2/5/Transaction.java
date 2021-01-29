import edu.princeton.cs.algs4.Date;
import java.util.Comparator;

public class Transaction implements Comparable<Transaction> {
	private final String who;
	private final Date when;
	private final double amount;

	public Transaction(String who, Date when, double amount) {
		this.who = who;
		this.when = when;
		this.amount = amount;
	}

	public int compareTo (Transaction  that) {
		return this.when.compareTo(that.when);
	}

	public static class WhoOrder implements Comparator<Transaction> {
		public int compare(Transaction v, Transaction w) {
			return v.who.compareTo(w.who);
		}
	}

	public static class WhenOrder implements Comparator<Transaction> {
		public int compare(Transaction v, Transaction w) {
			return v.when.compareTo(w.when);
		}
	}

	public static class HowMuchOrder implements Comparator<Transaction> {
		public int compare(Transaction v, Transaction w) {
			if (v.amount < w.amount) {
				return -1;
			}
			if (v.amount > w.amount) {
				return 1;
			}
			return 0;
		}
	}
}
