package Lab1;
public class GaussSeidel {
	
	private double[][] matrix;
	private double[] vectorB;
	private double approx;
	private int dimention;

	public GaussSeidel(int dimention, double approx, double[][] matrix, double[] vectorB) {
		this.matrix = matrix;
		this.approx = approx;
		this.dimention = dimention;
		this.vectorB = vectorB;
	}
	
	public boolean isDiagonalDominance() {
		double absDiagonalElement = 0;
		double absSumLineElements = 0;
		for (int i = 0; i < dimention; i++) {
			absDiagonalElement = Math.abs(matrix[i][i]);
			absSumLineElements = -absDiagonalElement;
			for (int j = 0; j < dimention; j++) {
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
