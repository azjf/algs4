import java.util.Arrays;

public class MatrixVectorMultiplication {
	public static void main(String args[]) {
		int N = 10;
		double[][] a = new double[N][N];
		double[] x = new double[N];
		double[] b = new double[N];

		for (int i = 0; i < N; i++) {
			double sum = 0.0;
			for (int j = 0; j < N; j++) {
				sum += a[i][j] * x[j];
			}
			b[i] = sum;
		}

		System.out.println(Arrays.toString(b));
	}
}
