package Lab1;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GaussSeidel {
	
	private double[][] matrix;
	private double[] vectorB;
	private double approx;
	private int dimension;
	private double[] solution;
	private double[] previousIteration;
	private int iteration = 0;

	/**
	 *
	 * @param dimension Size of matrix
	 * @param approx Allowable error
	 * @param matrix Input matrix
	 * @param vectorB Column of right-hand sides
	 */
	GaussSeidel(int dimension, double approx, double[][] matrix, double[] vectorB) {
		this.matrix = matrix;
		this.approx = approx;
		this.dimension = dimension;
		this.vectorB = vectorB;
		this.solution = new double[dimension];
		this.previousIteration = new double[dimension];
	}

	/**
	 * Check diagonal dominance in the input matrix
	 * @return "True" for input matrix with diagonal dominance, "false" for others
	 */
	private boolean isDiagonalDominance() {
		double absDiagonalElement = 0;
		double absSumLineElements = 0;
		for (int i = 0; i < dimension; i++) {
			absDiagonalElement = Math.abs(matrix[i][i]);
			absSumLineElements = -absDiagonalElement;
			for (int j = 0; j < dimension; j++) {
				absSumLineElements +=  Math.abs(matrix[i][j]);
			}
			if (absDiagonalElement < absSumLineElements) {
				return false;
			}
		}
		return true;
	}

	/**
	 * For checking is it possible to make matrix diagonal dominance
	 * @return List of new position for rows (or null)
	 */
	private ArrayList<Integer> getNewPositionsForRows() {
		double element;
		double elementsSum;
		ArrayList<Integer> newPositionsForRows = new ArrayList<>(dimension);
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				element = Math.abs(matrix[i][j]);
				elementsSum = -matrix[i][j];
				for (int k = 0; k < dimension; k++) {
					elementsSum += Math.abs(matrix[i][k]);
				}
				if (element > elementsSum) {
					if (!newPositionsForRows.contains(j)) {
						newPositionsForRows.add(i, j);
					}
					else {
						return null;
					}
				}
			}
		}
		for (Integer x: newPositionsForRows) {
			if (x == null) {
				System.out.println("No diagonal");
				return null;
			}
		}
		return newPositionsForRows;
	}

	/**
	 * Make matrix diagonal dominance
	 * @param newPositionsForLine List of new position for rows
	 */
	private void makeDiagonalDominance(ArrayList<Integer> newPositionsForLine) {
		double[][] newMatrix = new double[dimension][dimension];
		double[] newVectorB = new double[dimension];
		for (int i = 0; i < dimension; i++) {
			newMatrix[i] = matrix[newPositionsForLine.get(i)];
			newVectorB[i] = vectorB[newPositionsForLine.get(i)];
		}
		matrix = newMatrix;
		vectorB = newVectorB;
	}


	/**
	 * Solve linear system of equations
	 */
	void solve() {
		if (!isDiagonalDominance()) {
			System.out.println("Initial matrix isn't diagonal dominance");
			ArrayList<Integer> newPositionsForRows = getNewPositionsForRows();
			if (newPositionsForRows != null) {
				makeDiagonalDominance(newPositionsForRows);
			} else {
				System.out.println("Matrix can't be diagonal dominance");
				return;
			}
		}
		int flag = 0;

		for (int i = 0; i < dimension; i++) {
			previousIteration[i] = 0;
		}

		while (flag != dimension) {
			flag = 0;
			iteration++;
			for (int i = 0; i < dimension; i++) {
				double presolution = vectorB[i];
				for (int n = 0; n < dimension; n++) {
					if (i != n) {
						presolution -= matrix[i][n] * previousIteration[n];
					}
				}
				solution[i] = (1 / matrix[i][i]) * presolution;
				if (Math.abs(solution[i] - previousIteration[i]) > approx) {
					previousIteration[i] = solution[i];
				} else {
					flag++;
				}
			}
		}
	}


	@Override
	public String toString() {
		String pattern = "##0.000";
		DecimalFormat decimalFormat = new DecimalFormat(pattern);
		StringBuilder output = new StringBuilder();
		output.append("Results: " + "\t\t\t   " );
		for (double x: solution){
			output.append(decimalFormat.format(x) + " ");
		}
		output.append("\n" + "Iterations: \t\t\t" + iteration + "\n" + "Approximations column:  ");
		for (int i = 0; i < dimension; i++) {
			output.append(decimalFormat.format((Math.abs(solution[i] - previousIteration[i]))) + " ");
		}
		return output.toString();
	}

}
