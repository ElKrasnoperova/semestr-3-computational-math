package Lab1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class FileWorker {
	private int dimension;
	private double approximation;
	private double[][] matrix;
	private double[] vectorB;

	private static final File file = new File ("input.txt");
	
	public FileWorker() {
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
	
	public int getMatrixSize() {
		return dimension;
	}
	
	public double getApproximation() {
		return approximation;
	}
	
	public double[][] getMatrix() {
		return matrix;
	}
	
	public double[] getVectorB() {
		return vectorB;
	}
	
}
