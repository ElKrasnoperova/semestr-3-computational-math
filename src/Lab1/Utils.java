package Lab1;

public class Utils {

    public static void printInitDataForGaussSeidel(double approx, double[] vectorB, double[][] matrix) {
        int dimension = vectorB.length;
        System.out.println("Approximation: " + approx);
        System.out.print("VectorB: ");
        for (int i = 0; i < dimension; i++) {
            System.out.print(vectorB[i] + " ");
        }
        System.out.println();
        System.out.println("Matrix: ");
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
