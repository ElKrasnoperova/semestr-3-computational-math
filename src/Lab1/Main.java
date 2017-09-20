package Lab1;
//TODO 3 signs
//TODO output with the table
//TODO incorrect data in random
import java.util.Random;
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
			scanner.close();
		}
		else if(flag == 2){
			Random random = new Random();
			dimension = random.nextInt(20);
			System.out.println(dimension);
			approx = 0.01;
			vectorB = new double[dimension];
			matrix = new double[dimension][dimension];
			for (int i = 0; i <dimension; i++) {
				vectorB[i] = Math.random();
			}
			for (int i = 0; i < dimension; i++) {
				for (int j = 0; j < dimension; j++) {
					matrix[i][j] = Math.random();
				}
			}



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
