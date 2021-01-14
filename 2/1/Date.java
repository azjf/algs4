public class Date implements Comparable<Date> {
	private final int month;
	private final int day;
	private final int year;

	public Date(int m, int d, int y) {
		month = m;
		day = d;
		year = y;
	}

	public int month() {
		return month;
	}

	public int day() {
		return day;
	}

	public int year() {
		return year;
	}

	public String toString() {
		return month() + "/" + day() + "/" + year();
	}

	public boolean equals(Object x) {
		if (this == x) return true;
		if (x == null) return false;
		if (this.getClass() != x.getClass()) return false;
		Date that = (Date) x;
		if (this.day != that.day) return false;
		if (this.month != that.month) return false;
		if (this.year != that.year) return false;
		return true;
	}

	public int compareTo(Date that) {
		if (this.year > that.year) {
			return 1;
		}
		if (this.year < that.year) {
			return -1;
		}
		if (this.month > that.month) {
			return 1;
		}
		if (this.month < that.month) {
			return -1;
		}
		if (this.day > that.day) {
			return 1;
		}
		if (this.day < that.day) {
			return -1;
		}
		return 0;
	}
}
