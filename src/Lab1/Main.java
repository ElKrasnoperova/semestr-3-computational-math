package Lab1;

import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int dimension;
		double approx;
		double[] vectorB;
		double[][] matrix;

		System.out.println("Do you want to input data from keyboard[0] or from file[1]?");
		Scanner scanner = new Scanner(System.in);
		int flag = scanner.nextInt();

		if (flag == 1) {
			FileWorker matrixInfo = new FileWorker();
			dimension = matrixInfo.getMatrixSize();
			vectorB = matrixInfo.getVectorB();
			matrix = matrixInfo.getMatrix();
			approx = matrixInfo.getApproximation();
		} else if (flag == 0){
			System.out.println("Input matrix size ");
			dimension = scanner.nextInt();
			vectorB = new double[dimension];
			matrix = new double[dimension][dimension];
			System.out.println("Input column of right-hand sides. Use 'space' between two numbers and ',' for double");
			for (int i = 0; i < dimension; i++) {
				vectorB[i] = scanner.nextDouble();
			}
			System.out.println("Input matrix. Use 'space' between two numbers and ',' for double");
			for (int i = 0; i<dimension; i++) {
				for (int j = 0; j<dimension; j++) {
					matrix[i][j] = scanner.nextDouble();
				}
			}
			System.out.println("Input approximation");
			approx = scanner.nextDouble();
		}
		else {
			System.out.println("You've written the wrong flag.");
			return;
		}
		
		GaussSeidel gaussSeidel = new GaussSeidel(
				dimension,
				approx,
				matrix,
				vectorB
				);
		gaussSeidel.solve();
		System.out.println(gaussSeidel);
	}
}
