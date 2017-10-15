package Lab1;
import java.util.Scanner;

public class Main {
	public static void main(String args[]) {
		int dimension;
		double approx;
		double[] vectorB;
		double[][] matrix;

		System.out.println("Do you want to input data from keyboard[0] or from file[1] or random[2]?");
		Scanner scanner = new Scanner(System.in);
		int flag = scanner.nextInt();

		if (flag == 1) {
			FileWorker matrixInfo = new FileWorker();
			dimension = matrixInfo.getMatrixSize();
			vectorB = matrixInfo.getVectorB();
			matrix = matrixInfo.getMatrix();
			approx = matrixInfo.getApproximation();

		} else if (flag == 0){
			System.out.println("Input matrix size");
			dimension = scanner.nextInt();
			while (dimension == 0) {
				System.out.println("It is not a matrix. Try again, I believe, you can!");
				dimension = scanner.nextInt();
			}
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
			System.out.println("Input approximation. Use ',' for double");
			approx = scanner.nextDouble();
			scanner.close();
		}
		else if(flag == 2) {
			System.out.println("Input matrix size");
			dimension = scanner.nextInt();
			while (dimension == 0) {
				System.out.println("It is not a matrix. Try again, I believe, you can!");
				dimension = scanner.nextInt();
			}

			approx = Math.random()/100;
			vectorB = new double[dimension];
			matrix = new double[dimension][dimension];
			double sum;
			for (int i = 0; i < dimension; i++) {
				sum = 0;
				vectorB[i] = Math.random()*10;
				for (int j = 0; j < dimension; j++) {
					matrix[i][j] = Math.random()*10;
					sum += matrix[i][j];
				}
				matrix[i][i] += sum;
			}
		}
		else {
			System.out.println("You've written the wrong flag.");
			return;
		}
		Utils.printInitDataForGaussSeidel(approx, vectorB, matrix);
		if(Utils.isMatrixElementsEquals(dimension, matrix)) {
			System.out.println("All elements are equal");
			return;
		} else {
			GaussSeidel gaussSeidel = new GaussSeidel(
					dimension,
					approx,
					matrix,
					vectorB
			);

			gaussSeidel.solve();
			System.out.println();
			System.out.println(gaussSeidel);
			return;
		}
	}

}