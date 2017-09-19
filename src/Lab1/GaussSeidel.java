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
	 * Method for checking diagonal dominance in the input matrix
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
				System.out.println(absDiagonalElement + " " + absSumLineElements );
				return false;
			}
		}
		return true;
	}
	
}
