import static java.lang.System.out;
import static java.lang.Math.*;

public class MatrixSumation {

	/**
	 * @param args
	 */
	public static void main1(String[] args) {
		final int ROWS = 3;
		final int COLS = 4;
		int[][] data = new int[ROWS][COLS];

		// Init Array With Random Data
		for (int r = 0; r < ROWS; r++)
			for (int c = 0; c < COLS; c++)
				data[r][c] = (int) (100 * random());

		// Print Array
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++)
				System.out.print(data[r][c] + "\t");
			System.out.println();
		}

		// Calculate Row Sums
		int[] rowsum = new int[data.length];
		for (int r = 0; r < data.length; r++) {
			int sum = 0;
			for (int c = 0; c < data[r].length; c++)
				sum += data[r][c];
			rowsum[r] = sum;
		}

		// Calculate Col Sums
		int[] colsum = new int[data[0].length];
		for (int c = 0; c < data[0].length; c++) {
			int sum = 0;
			for (int r = 0; r < data.length; r++)
				sum += data[r][c];
			colsum[c] = sum;
		}

		// Print Results
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++)
				System.out.print(data[r][c] + "\t");
			System.out.println(rowsum[r]);
		}
		for (int c = 0; c < data[0].length; c++)
			System.out.print(colsum[c] + "\t");
		System.out.println();
	}

	// ******************************************************************************

	public static void main2(String args[]) {
		final int ROWS = 3;
		final int COLS = 4;
		int[][] data = new int[ROWS][COLS];

		initArrayWithRandomData(data);
		printArray(data);

		int[] rowsum = new int[data.length];
		calculateRowSums(data, rowsum);

		int[] colsum = new int[data[0].length];
		calculateColSums(data, colsum);
		
		printResults(data, rowsum, colsum);
	}

	private static void initArrayWithRandomData(int[][] d) {
		for (int r = 0; r < d.length; r++)
			for (int c = 0; c < d[r].length; c++)
				d[r][c] = (int) (100 * Math.random());
	}
	
	private static void printArray(int[][] data) {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++)
				out.print(data[r][c] + "\t");
			out.println();
		}
	}
	
	private static void calculateRowSums(int[][] data, int[] rowsum) {
		for (int r = 0; r < data.length; r++) {
			int sum = 0;
			for (int c = 0; c < data[r].length; c++)
				sum += data[r][c];
			rowsum[r] = sum;
		}
	}
	
	private static void calculateColSums(int[][] data, int[] colsum) {
		for (int c = 0; c < data[0].length; c++) {
			int sum = 0;
			for (int r = 0; r < data.length; r++)
				sum += data[r][c];
			colsum[c] = sum;
		}
	}
	
	private static void printResults(int[][] data, int[] rowsum, int[] colsum) {
		for (int r = 0; r < data.length; r++) {
			for (int c = 0; c < data[r].length; c++)
				out.print(data[r][c] + "\t");
			out.println(rowsum[r]);
		}
		for (int c = 0; c < data[0].length; c++)
			out.print(colsum[c] + "\t");
		out.println();		
	}
	
	// ******************************************************************************

	public static void main(String args[]) {
		final int ROWS = 3;
		final int COLS = 4;

		int[][] data = initArrayWithRandomData(ROWS, COLS);
		printArray(data);

		int[] rowsum = calculateRowSums(data);
		int[] colsum = calculateColSums(data);
		
		printResults(data, rowsum, colsum);
	}

	private static int[][] initArrayWithRandomData(int rows, int cols) {
		int[][] d = new int[rows][cols];
		for (int r = 0; r < d.length; r++)
			for (int c = 0; c < d[r].length; c++)
				d[r][c] = (int) (100 * Math.random());
		return d;
	}

	private static int[] calculateRowSums(int[][] data) {
		int[] rowsum = new int[data.length];
		for (int r = 0; r < data.length; r++) {
			int sum = 0;
			for (int c = 0; c < data[r].length; c++)
				sum += data[r][c];
			rowsum[r] = sum;
		}
		return rowsum;
	}
	
	private static int[] calculateColSums(int[][] data) {
		int[] colsum = new int[data[0].length];
		for (int c = 0; c < data[0].length; c++) {
			int sum = 0;
			for (int r = 0; r < data.length; r++)
				sum += data[r][c];
			colsum[c] = sum;
		}
		return colsum;
	}


}
