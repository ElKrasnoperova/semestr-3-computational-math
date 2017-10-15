package Lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class FileWorker {
	private int dimension;
	private double approximation;
	private double[][] matrix;
	private double[] vectorB;

	private static final File file = new File ("input.txt");
	
	FileWorker() {
		Scanner scanner;
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return;
		}
		dimension = scanner.nextInt();
		vectorB = new double[dimension];
		matrix = new double[dimension][dimension];
		for (int i = 0; i < dimension; i++) {
			vectorB[i] = scanner.nextDouble();
		}
		
		for (int i = 0; i < dimension; i++) {
			for (int j = 0; j < dimension; j++) {
				matrix[i][j] = scanner.nextDouble();
			}
		}
		approximation = scanner.nextDouble();
	}
	
	int getMatrixSize() {
		return dimension;
	}
	
	double getApproximation() {
		return approximation;
	}
	
	double[][] getMatrix() {
		return matrix;
	}
	
	double[] getVectorB() {
		return vectorB;
	}
	
}
