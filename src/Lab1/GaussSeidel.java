package Lab1;
public class GaussSeidel {
	
	private double[][] matrix;
	private double[] vectorB;
	private double approx;
	private int dimension;

	/**
	 *
	 * @param dimension Size of matrix
	 * @param approx Allowable error
	 * @param matrix Input matrix
	 * @param vectorB Column of right-hand sides
	 */
	public GaussSeidel(int dimension, double approx, double[][] matrix, double[] vectorB) {
		this.matrix = matrix;
		this.approx = approx;
		this.dimension = dimension;
		this.vectorB = vectorB;
	}

	/**
	 * Check diagonal dominance in the input matrix
	 * @return "True" for matrix with diagonal dominance, "false" for others
	 */
	public boolean isDiagonalDominance() {
		double absDiagonalElement = 0;
		double absSumLineElements = 0;
		for (int i = 0; i < dimension; i++) {
			absDiagonalElement = Math.abs(matrix[i][i]);
			absSumLineElements = -absDiagonalElement;
			for (int j = 0; j < dimension; j++) {
				absSumLineElements +=  Math.abs(matrix[i][j]);
			}
			
			if (absDiagonalElement < absSumLineElements) {
				System.out.println(absDiagonalElement + " " + absSumLineElements);
				changeMatrixRows(i);
				return false;
			}
		}
		return true;
	}

	/**
	 * Change matrix rows
	 * @param row Row without diagonal dominance
	 */
	public void changeMatrixRows(int row) {
		int newRow = row + 1;
		if (row == dimension - 1) {
			newRow = 0;
		}
		double[] temporary = matrix[row];
		matrix[row] = matrix[newRow];
		matrix[newRow] = temporary;
	}

	/**
	 * Solve linear system of equations
	 * @return Array of results
	 */
	public double[] solver() {
		if (!isDiagonalDominance()) {
			System.out.println("Matrix isn't diagonal dominance");
		}
		int flag = 0;
		double[] solution = new double[dimension];
		double[] initApproximation = new double[dimension];

		for (int i = 0; i < dimension; i++) {
			initApproximation[i] = 0;
		}

		int k = 0;
		while (flag != dimension) {
			flag = 0;
			k++;
			for (int i = 0; i < dimension; i++) {
				double presolution = vectorB[i];
				for (int n = 0; n < dimension; n++) {
					if (i != n) {
						presolution -= matrix[i][n] * initApproximation[n];
					}
				}
				solution[i] = (1 / matrix[i][i]) * presolution;
				if (Math.abs(solution[i] - initApproximation[i]) > approx) {
					initApproximation[i] = solution[i];
				} else {
					flag++;
				}
			}
		}
		return solution;
	}

}
