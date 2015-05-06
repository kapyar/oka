import java.util.Random;

public class PercolationStats {
	private Percolation per;
	private int size;
	private int numbOfElemInRow;
	private int att;
	private double[] meanHold;
	private double mean;

	public PercolationStats(int N, int T) {
		att = T;
		meanHold = new double[T];
		size = N * N;
		numbOfElemInRow = N;
		Random rand = new Random();
		int row;
		int column;
		for (int i = 0; i < T; ++i) {

			per = new Percolation(N);

			while (!per.percolates()) {
				row = rand.nextInt(numbOfElemInRow) + 1;
				column = rand.nextInt(numbOfElemInRow) + 1;
				per.open(row, column);
			}
			meanHold[i] = (double) per.getOpenedCount() / (double) size;

		}
	}

	// проведемо T окремих експериментів в N на N матриці
	public double mean() {
		if (mean == 0) {
			double m = 0;
			for (int i = 0; i < meanHold.length; ++i) {
				m += meanHold[i];
			}

			mean = m / att;
		}

		return mean;
	}

	// рахує середнє
	public double stddev() {

		double std = 0;
		for (int i = 0; i < meanHold.length; ++i) {
			std += Math.pow(meanHold[i] - mean(), 2);

		}
		if (att > 1)
			return std / (att - 1);
		else
			return std;
	}

	// рахує відхилення
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int N = 200;
		int T = 30;
		PercolationStats stat = new PercolationStats(N, T);
		System.out.println();
		System.out.println("Mean: " + stat.mean());
		System.out.println("Standart dev: " + stat.stddev());
		double dev = Math.sqrt(stat.stddev());
		double sqrtT = Math.sqrt(T);
		double start = stat.mean() - ((double) 1.96 * dev / sqrtT);
		double end = stat.mean() + ((double) 1.96 * dev / sqrtT);
		System.out.println("Trust interval: [" + start + ", " + end + "]");
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time: " + (endTime - startTime) + " ms");

	}
}
