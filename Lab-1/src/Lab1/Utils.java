package Lab1;

import java.text.DecimalFormat;

public class Utils {

    /**
     * Printing input data
     * @param approx Allowable error
     * @param vectorB Column of right-hand sides
     * @param matrix Input matrix
     */
    public static void printInitDataForGaussSeidel(double approx, double[] vectorB, double[][] matrix) {
        String pattern = "##0.000";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        int dimension = vectorB.length;
        System.out.println("Approximation: " + decimalFormat.format(approx));
        System.out.print("VectorB: ");
        for (int i = 0; i < dimension; i++) {
            System.out.print(decimalFormat.format(vectorB[i]) + " ");
        }
        System.out.println();
        System.out.println("Matrix: ");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(decimalFormat.format(matrix[i][j]) + " ");
            }
            System.out.println();
        }

    }

    /**
     *
     * @param dimension Size of matrix
     * @param matrix Input matrix
     * @return False if all elements in matriz are equal, in other case return true
     */
    public static boolean isMatrixElementsEquals(int dimension, double[][] matrix) { // название получше надо
        double firstElement = matrix[0][0];

        for (int i = 0; i < dimension; i++) {
            for(int j=0; j< dimension; j++) {
                if (matrix[i][j] != firstElement ) {
                    return false;
                }
            }
        }

        return true;
    }
}
